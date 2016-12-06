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
		 * 将决策建议生成代拟指令
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
			fb.setJjtzId(jy.getJjtzId());//紧急通知建议id
			fb.setZlbhId(jy.getXymlId());//指令编号==响应命令建议编号
			fb.setZhlx(jy.getZhlx());//灾害类型
			fb.setStatus(jy.getStatus());//状态
			fb.setContent(jy.getContent());//通知建议内容
			fb.setBzId(jy.getBzId());//引用标准的编号
			fb.setCreateby(jy.getCreateby());//通知建议建立人
			fb.setCreatedate(jy.getCreatedate());//通知建议建立日期
			
			fb.setRelatedNotice(jy.getSubject());
			fbdao.save(fb);
			String path=ContextHolder.getRequest().getSession().getServletContext().getRealPath("pageoffice") ;
			String templetPath =path+ "\\doc"+"/xyml_fb.doc"; //模版文件  
			String otPath = path+ "\\doc"+"\\xyml"+key+".doc"; //保存文件  
			GF_JacobUtil word = new GF_JacobUtil();  
			try {  
				//获取灾害等级
				EmAlarmstandard alarmstandard=alAction.getDataById(jy.getBzId());
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
			    word.replaceBookMark("PO_level", alarmstandard.getDisasterlevel()); 
			    word.replaceBookMark("PO_num", jy.getXymlId()); 
			    
			    //保存到path  
			    word.saveFileAs(otPath);  
			    word.wordToPDF(otPath, path+ "\\pdf"+"\\xyml"+key+".pdf");
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
		public void getData(Page<EmXymlFb> page,Map<String, Object> params){
			IUser user = ContextHolder.getLoginUser();
			if (user!=null) {
				ContextHolder.getRequest().getSession().setAttribute("username", user.getCname());
			}
			if (params!=null) {
				try {
					//    zhlx灾害类型    content紧急通知内容
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
		 * 删除的操作
		 * @param infos
		 */
		@DataResolver
		@Transactional
		public void save(List<EmXymlFb> infos) {
			fbdao.persistEntities(infos);
		}
		
		/**
		 * 有datagrid中点击行后根据id编号查询单体
		 * @param page
		 * @param params
		 */
		@Transactional
		@DataProvider		
		public EmXymlFb getDataById(String id){
			return (EmXymlFb) fbdao.find("from EmXymlFb where id='"+id+"'").get(0);
		}
		
		/**
		 * 通知批准
		 * @param fb
		 */
		@Transactional		
		@DataResolver
		public void approval(EmXymlFb fb){
			fb.setAppdate(new Date());
			fb.setStatus("已批准");
			fbdao.save(fb);
		}
}
