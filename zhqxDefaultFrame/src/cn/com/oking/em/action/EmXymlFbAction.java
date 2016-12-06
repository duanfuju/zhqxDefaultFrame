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

import cn.com.oking.em.dao.EmXymlFbDao;
import cn.com.oking.em.entity.EmAlarmstandard;
import cn.com.oking.em.entity.EmXymlFb;
import cn.com.oking.em.entity.EmXymlJy;
import cn.com.oking.util.GF_JacobUtil;
import cn.com.oking.util.KeyUtil;

@Component
public class EmXymlFbAction {

		@Resource
		private EmXymlFbDao fbdao;
		
		@Resource
		private EmAlarmstandardAction alAction;
		
		/**
		 * �����߽������ɴ���ָ��
		 * @param jy
		 */
		@Transactional		
		@DataResolver
		public void copy(EmXymlJy jy){
			EmXymlFb fb=null;
			String key=KeyUtil.getKey();
			try {
				fb = (EmXymlFb) fbdao.find("from EmXymlFb where zlbhId='"+jy.getXymlId()+"'").get(0);
			} catch (Exception e) {
				fb=null;
				e.printStackTrace();
			}
			if (fb==null) {
				fb=new EmXymlFb();
				fb.setId(key);
			}
			key=fb.getId();
			fb.setJjtzId(jy.getJjtzId());//����֪ͨ����id
			fb.setZlbhId(jy.getXymlId());//ָ����==��Ӧ�������
			fb.setZhlx(jy.getZhlx());//�ֺ�����
			fb.setStatus(jy.getStatus());//״̬
			fb.setContent(jy.getContent());//֪ͨ��������
			fb.setBzId(jy.getBzId());//���ñ�׼�ı��
			fb.setCreateby(jy.getCreateby());//֪ͨ���齨����
			fb.setCreatedate(jy.getCreatedate());//֪ͨ���齨������
			
			fb.setRelatedNotice(jy.getSubject());
			fbdao.save(fb);
			String path=ContextHolder.getRequest().getSession().getServletContext().getRealPath("pageoffice") ;
			String templetPath =path+ "\\doc"+"/xyml_fb.doc"; //ģ���ļ�  
			String otPath = path+ "\\doc"+"\\xyml"+key+".doc"; //�����ļ�  
			GF_JacobUtil word = new GF_JacobUtil();  
			try {  
				//��ȡ�ֺ��ȼ�
				EmAlarmstandard alarmstandard=alAction.getDataById(jy.getBzId());
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
			    word.replaceBookMark("PO_level", alarmstandard.getDisasterlevel()); 
			    word.replaceBookMark("PO_num", jy.getXymlId()); 
			    
			    //���浽path  
			    word.saveFileAs(otPath);  
			    word.wordToPDF(otPath, path+ "\\pdf"+"\\xyml"+key+".pdf");
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
		public void getData(Page<EmXymlFb> page,Map<String, Object> params){
			IUser user = ContextHolder.getLoginUser();
			if (user!=null) {
				ContextHolder.getRequest().getSession().setAttribute("username", user.getCname());
			}
			if (params!=null) {
				try {
					//    zhlx�ֺ�����    content����֪ͨ����
					fbdao.find(page,"from EmXymlFb where zhlx like '%"+params.get("zhlx").toString()
												+"%' and content like '%"+params.get("content").toString()+"%'");
				} catch (Exception e) {
					e.printStackTrace();
					fbdao.find(page,"from EmXymlFb");
				}
			}else{
				fbdao.find(page,"from EmXymlFb");
			}
		}
		@Transactional		
		@DataProvider			
		public List<EmXymlFb> getData(){
			List<EmXymlFb> list=fbdao.find("from EmXymlFb");
			return list;
		}
		
		
		
		
		
		
		
		
		/**
		 * ɾ���Ĳ���
		 * @param infos
		 */
		@DataResolver
		@Transactional
		public void save(List<EmXymlFb> infos) {
			fbdao.persistEntities(infos);
		}
		
		/**
		 * ��datagrid�е���к����id��Ų�ѯ����
		 * @param page
		 * @param params
		 */
		@Transactional
		@DataProvider		
		public EmXymlFb getDataById(String id){
			return (EmXymlFb) fbdao.find("from EmXymlFb where id='"+id+"'").get(0);
		}
		
		/**
		 * ֪ͨ��׼
		 * @param fb
		 */
		@Transactional		
		@DataResolver
		public void approval(EmXymlFb fb){
			fb.setAppdate(new Date());
			fb.setStatus("����׼");
			fbdao.save(fb);
		}
}
