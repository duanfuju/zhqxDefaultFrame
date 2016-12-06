package cn.com.oking.em.action;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.com.oking.em.dao.EmCzfaJyAdviceDao;
import cn.com.oking.em.dao.EmCzfaMlAdviceDao;
import cn.com.oking.em.dao.EmCzfaMlDao;
import cn.com.oking.em.entity.EmCzfaJyAdvice;
import cn.com.oking.em.entity.EmCzfaMl;
import cn.com.oking.em.entity.EmCzfaJy;
import cn.com.oking.em.entity.EmCzfaMlAdvice;
import cn.com.oking.util.Document;
import cn.com.oking.util.KeyUtil;

import com.bstek.bdf2.core.business.IUser;
import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;

@Component
public class EmCzfaMlAction {
	@Resource
	private EmCzfaMlDao fbdao;
	
	@Resource
	private EmCzfaJyAdviceDao advicedao;
	
	@Resource
	private EmCzfaMlAdviceDao mladvicedao;
	
	/**
	 * �����߽������ɴ���ָ��
	 * @param jy
	 */
	@Transactional		
	@DataResolver
	public void copy(EmCzfaJy jy){
		String word_id="";
		ArrayList tableData=null;
		//�����÷���������Ƶ������������
		boolean isHave=false;
		EmCzfaMl fb=null;
		try {
			fb = (EmCzfaMl) fbdao.find("from EmCzfaMl where orderNumber='"+jy.getOrderNumber()+"'").get(0);
			word_id=fb.getId();
			isHave=true;
		} catch (Exception e) {
			fb=null;
			isHave=false;
			e.printStackTrace();
		}
		String  fkey=KeyUtil.getKey();
		if (fb==null) {
			fb=new EmCzfaMl();
			fb.setId(fkey);
			word_id=fkey;
			fb.setJjtzId(jy.getJjtzId());//����֪ͨ����id
		}
		fb.setZhlx(jy.getZhlx());//�ֺ�����
		fb.setStatus(jy.getStatus());//״̬
		fb.setBzId(jy.getBzId());//���ñ�׼�ı��
		fb.setResponseLevel(jy.getResponseLevel());//��Ӧ����
		fb.setOrderNumber(jy.getOrderNumber());//������
		fb.setCreateby(jy.getCreateby());//֪ͨ���齨����
		fb.setCreatedate(jy.getCreatedate());//֪ͨ���齨������
		//���÷����������ý�����Ƶ������������ñ���
		List<EmCzfaJyAdvice> jyList=null;
		try {
			if (!isHave) {
				 jyList=advicedao.find("from EmCzfaJyAdvice where czfaJyId='"+jy.getId()+"' order by type");
				 /*
				  *������Ҫʹ��java�������word�ĵ��������б� --����
				  */
				 tableData = new ArrayList(jyList.size()+1); 
				 String[] title = {"����", "����Ӧ��"}; 
				 tableData.add(title); 
				 
				 
				 for (int i = 0; i < jyList.size(); i++) {
					 EmCzfaJyAdvice jySingle=jyList.get(i);
					 EmCzfaMlAdvice mlSingle=new EmCzfaMlAdvice();
					 mlSingle.setId(KeyUtil.getKey());
					 mlSingle.setDept(jySingle.getDept());
					 mlSingle.setType(jySingle.getType());
					 mlSingle.setResponses(jySingle.getResponses());
					 mlSingle.setCzfaJyId(fkey);
					 mladvicedao.save(mlSingle);
					 /*
					  *������Ҫʹ��java�������word�ĵ��������б� --���ݲ���
					  */
					 String[] field = { mlSingle.getDept(), mlSingle.getResponses()}; 
					 tableData.add(field); 
				 }
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		fbdao.save(fb);
		
		String path=ContextHolder.getRequest().getSession().getServletContext().getRealPath("pageoffice") ;
		String templetPath =path+ "\\doc"+"\\czfa_jy.doc"; //ģ���ļ�  
		String otPath = path+ "\\doc"+"\\czfa"+word_id+".doc"; //�����ļ�  
		if (tableData.size()>0) {
			Document doc = null; 
			  try { 
				  doc = new Document(); 
				  doc.open(templetPath); 
				  doc.insertAtBookmark("PO_level", jy.getResponseLevel());
				  doc.insertAtBookmark("PO_zhlx", jy.getZhlx());
				  doc.insertAtBookmark("PO_table",tableData,"������"); 
				  doc.saveAs(otPath);
				  doc.wordToPDF(otPath, path+ "\\pdf"+"\\czfa"+word_id+".pdf");
			  } catch (Exception e) { 
				  e.printStackTrace(); 
			  } finally { 
				  try {
					doc.close(true);
				  } catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				  } 
			  }
		}
	}
	
	
	/**
	 * datagrid��ѯ�����������ѯ����			
	 * @param page
	 * @param params
	 */
	@Transactional		
	@DataProvider			
	public void getData(Page<EmCzfaMl> page,Map<String, Object> params){
		IUser user = ContextHolder.getLoginUser();
		if (user!=null) {
			ContextHolder.getRequest().getSession().setAttribute("username", user.getCname());
		}
		if (params!=null) {
			try {
				fbdao.find(page,"from EmCzfaMl where zhlx like '%"+params.get("zhlx")+"%' and NVL(orderNumber,0) like '%"+params.get("orderNumber")+"%'");
			} catch (Exception e) {
				e.printStackTrace();
				fbdao.find(page,"from EmCzfaMl");
			}
		}else{
			fbdao.find(page,"from EmCzfaMl");
		}
	}
	@Transactional		
	@DataProvider			
	public List<EmCzfaMl> getData(){
		List<EmCzfaMl> list=fbdao.find("from EmCzfaMl");
		return list;
	}
	
	@Transactional		
	@DataProvider			
	public void getDataByStatus(Page<EmCzfaMl> page,Map<String, Object> params){
		IUser user = ContextHolder.getLoginUser();
		if (user!=null) {
			ContextHolder.getRequest().getSession().setAttribute("username", user.getCname());
		}
		if (params!=null) {
			try {
				fbdao.find(page,"from EmCzfaMl where status!='�����' and zhlx like '%"+params.get("zhlx")+"%' and NVL(orderNumber,0) like '%"+params.get("orderNumber")+"%'");
			} catch (Exception e) {
				e.printStackTrace();
				fbdao.find(page,"from EmCzfaMl where status!='�����'");
			}
		}else{
			fbdao.find(page,"from EmCzfaMl where status!='�����'");
		}
	}
	
	
	
	/**
	 * ɾ���Ĳ���
	 * @param infos
	 */
	@DataResolver
	@Transactional
	public void save(List<EmCzfaMl> infos) {
		for (int i = 0; i < infos.size(); i++) {
			EmCzfaMl m=infos.get(i);
			List<EmCzfaMlAdvice> list=mladvicedao.find("from EmCzfaMlAdvice where czfaJyId='"+m.getId()+"'");
			if (list.size()>0) {
				for (int j = 0; j < list.size(); j++) {
					EmCzfaMlAdvice advice=list.get(j);
					mladvicedao.delete(advice);
				}
			}
		}
		fbdao.persistEntities(infos);
	}
	
	/**
	 * ��datagrid�е���к����id��Ų�ѯ����
	 * @param page
	 * @param params
	 */
	@Transactional
	@DataProvider		
	public EmCzfaMl getDataById(String id){
		return (EmCzfaMl) fbdao.find("from EmCzfaMl where id='"+id+"'").get(0);
	}
	
	/**
	 * ֪ͨ��׼
	 * @param fb
	 */
	@Transactional		
	@DataResolver
	public void approval(EmCzfaMl fb){
		fb.setAppdate(new Date());
		fb.setStatus("����׼");
		String word_id=fb.getId();
		fbdao.save(fb);
		ArrayList tableData=null;
		//����id��ŵ�������в�ѯ����ָ�type=1��
		
		List<EmCzfaMlAdvice> adviceList=advicedao.find("from EmCzfaMlAdvice where czfaJyId='"+fb.getId()+"' and type='1'");
		if (adviceList.size()>0) {
			tableData = new ArrayList(adviceList.size()); 
			 for (int i = 0; i < adviceList.size(); i++) {
				 EmCzfaMlAdvice advice=adviceList.get(i);
				 String[] field = { advice.getDept(), advice.getResponses()}; 
				 tableData.add(field);
			 }
		}
		//Ȼ����ͨ��java���뽫������䵽word
		if (tableData!=null) {
			String path=ContextHolder.getRequest().getSession().getServletContext().getRealPath("pageoffice") + "\\doc";
			String otPath = path+"\\czfa"+word_id+".doc"; //�����ļ�  
			if (tableData.size()>0) {
				Document doc = null; 
				try { 
					doc = new Document(); 
					doc.open(otPath); 
					doc.insertAtBookmark("PO_table_append",tableData,"������"); 
				} catch (Exception e) { 
					  e.printStackTrace(); 
				} finally { 
					try {
						doc.close(true);
					} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
					} 
				}
			}
		}
	}
}
