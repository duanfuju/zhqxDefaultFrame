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
		 * 将紧急通知建议生成紧急通知
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
			fb.setZhlx(jy.getZhlx());//灾害类型
			fb.setStatus(jy.getStatus());//状态
			fb.setContent(jy.getContent());//通知建议内容
			fb.setTzjyId(jy.getTzjyId());//通知建议的编号
			fb.setBzId(jy.getBzId());//引用标准的编号
			fb.setCreateby(jy.getCreateby());//通知建议建立人
			fb.setCreatedate(jy.getCreatedate());//通知建议建立日期
			fb.setSubject(jy.getSubject());//通知建议主题
			fbdao.save(fb);
			
			
			String path=ContextHolder.getRequest().getSession().getServletContext().getRealPath("pageoffice") ;
			String templetPath =path+ "\\doc"+"/jjtz_fb.doc"; //模版文件  
			String otPath = path+ "\\doc"+"\\jjtz"+key+".doc"; //保存文件  
			GF_JacobUtil word = new GF_JacobUtil(); 
			try {  
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			    //是否显示打开word  
			    word.openWord(false);  
			    //打开模版文件  
			    word.openDocument(templetPath);  
			    //替换书签内容  
			    word.replaceBookMark("PO_zhlx",jy.getZhlx()); 
			    word.replaceBookMark("PO_content", jy.getContent()); 
			    word.replaceBookMark("PO_person", jy.getCreateby()); 
			    word.replaceBookMark("PO_date", sdf.format(jy.getCreatedate())); 
			    
			    //保存到path  
			    word.saveFileAs(otPath);
			    word.wordToPDF(otPath, path+ "\\pdf"+"\\jjtz"+key+".pdf");
			} catch (Exception ex) {  
			    ex.printStackTrace();  
			} finally {  
			    //关闭Word  
			    word.closeDocument();  
			    word.closeWord();  
			}  
		}
		/**
		 * datagrid查询或根据条件查询数据			
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
					//subject紧急通知主题    zhlx灾害类型    content紧急通知内容
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
		 * 删除的操作
		 * @param infos
		 */
		@DataResolver
		@Transactional
		public void save(List<EmJjtzFb> infos) {
			fbdao.persistEntities(infos);
		}
		
		/**
		 * 有datagrid中点击行后根据id编号查询单体
		 * @param page
		 * @param params
		 */
		@Transactional
		@DataProvider		
		public EmJjtzFb getDataById(String id){
			return (EmJjtzFb) fbdao.find("from EmJjtzFb where id='"+id+"'").get(0);
		}
		
		/**
		 * 通知批准
		 * @param fb
		 */
		@Transactional		
		@DataResolver
		public void approval(EmJjtzFb fb){
			fb.setAppdate(new Date());
			fb.setStatus("已批准");
			fbdao.save(fb);
		}
		
		
		
}
