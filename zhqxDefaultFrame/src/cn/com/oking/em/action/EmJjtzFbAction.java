package cn.com.oking.em.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.bdf2.core.business.IUser;
import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;


import cn.com.oking.em.dao.EmJjtzFbDao;
import cn.com.oking.em.entity.EmJjtzFb;
import cn.com.oking.em.entity.EmJjtzJy;
import cn.com.oking.util.GF_JacobUtil;
import cn.com.oking.util.KeyUtil;

@Component
public class EmJjtzFbAction {
		
		@Resource
		private EmJjtzFbDao fbdao;
		@Resource
		private EmAlarmstandardAction alAction;
		
		
		/**
		 * ������֪ͨ�������ɽ���֪ͨ
		 * @param jy
		 */
		@Transactional		
		@DataResolver
		public void copy(EmJjtzJy jy){
			String key=KeyUtil.getKey();
			EmJjtzFb fb=null;
			try {
				fb = (EmJjtzFb) fbdao.find("from EmJjtzFb where tzjyId='"+jy.getTzjyId()+"'").get(0);
			} catch (Exception e) {
				fb=null;
				e.printStackTrace();
			}
			if (fb==null) {
				fb=new EmJjtzFb();
				fb.setId(key);
			}
			key=fb.getId();
			fb.setZhlx(jy.getZhlx());//�ֺ�����
			fb.setStatus(jy.getStatus());//״̬
			fb.setContent(jy.getContent());//֪ͨ��������
			fb.setTzjyId(jy.getTzjyId());//֪ͨ����ı��
			fb.setBzId(jy.getBzId());//���ñ�׼�ı��
			fb.setCreateby(jy.getCreateby());//֪ͨ���齨����
			fb.setCreatedate(jy.getCreatedate());//֪ͨ���齨������
			fb.setSubject(jy.getSubject());//֪ͨ��������
			fbdao.save(fb);
			
			
			String path=ContextHolder.getRequest().getSession().getServletContext().getRealPath("pageoffice") ;
			String templetPath =path+ "\\doc"+"/jjtz_fb.doc"; //ģ���ļ�  
			String otPath = path+ "\\doc"+"\\jjtz"+key+".doc"; //�����ļ�  
			GF_JacobUtil word = new GF_JacobUtil(); 
			try {  
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			    //�Ƿ���ʾ��word  
			    word.openWord(false);  
			    //��ģ���ļ�  
			    word.openDocument(templetPath);  
			    //�滻��ǩ����  
			    word.replaceBookMark("PO_zhlx",jy.getZhlx()); 
			    word.replaceBookMark("PO_content", jy.getContent()); 
			    word.replaceBookMark("PO_person", jy.getCreateby()); 
			    word.replaceBookMark("PO_date", sdf.format(jy.getCreatedate())); 
			    
			    //���浽path  
			    word.saveFileAs(otPath);
			    word.wordToPDF(otPath, path+ "\\pdf"+"\\jjtz"+key+".pdf");
			} catch (Exception ex) {  
			    ex.printStackTrace();  
			} finally {  
			    //�ر�Word  
			    word.closeDocument();  
			    word.closeWord();  
			}  
		}
		/**
		 * datagrid��ѯ�����������ѯ����			
		 * @param page
		 * @param params
		 */
		@Transactional		
		@DataProvider			
		public void getData(Page<EmJjtzFb> page,Map<String, Object> params){
			IUser user = ContextHolder.getLoginUser();
			if (user!=null) {
				ContextHolder.getRequest().getSession().setAttribute("username", user.getCname());
			}
			if (params!=null) {
				try {
					//subject����֪ͨ����    zhlx�ֺ�����    content����֪ͨ����
					fbdao.find(page,"from EmJjtzFb where subject like '%"+params.get("zt").toString()
												+"%' and zhlx like '%"+params.get("zhlx").toString()
												+"%' and content like '%"+params.get("jjtz").toString()+"%'");
				} catch (Exception e) {
					e.printStackTrace();
					fbdao.find(page,"from EmJjtzFb");
				}
			}else{
				fbdao.find(page,"from EmJjtzFb");
			}
		}
		
		@Transactional		
		@DataProvider			
		public List<EmJjtzFb> getData(){
			List<EmJjtzFb> list=fbdao.find("from EmJjtzFb");
			return 	list;
		}
		/**
		 * ɾ���Ĳ���
		 * @param infos
		 */
		@DataResolver
		@Transactional
		public void save(List<EmJjtzFb> infos) {
			fbdao.persistEntities(infos);
		}
		
		/**
		 * ��datagrid�е���к����id��Ų�ѯ����
		 * @param page
		 * @param params
		 */
		@Transactional
		@DataProvider		
		public EmJjtzFb getDataById(String id){
			return (EmJjtzFb) fbdao.find("from EmJjtzFb where id='"+id+"'").get(0);
		}
		
		/**
		 * ֪ͨ��׼
		 * @param fb
		 */
		@Transactional		
		@DataResolver
		public void approval(EmJjtzFb fb){
			fb.setAppdate(new Date());
			fb.setStatus("����׼");
			fbdao.save(fb);
		}
		
		
		
}
