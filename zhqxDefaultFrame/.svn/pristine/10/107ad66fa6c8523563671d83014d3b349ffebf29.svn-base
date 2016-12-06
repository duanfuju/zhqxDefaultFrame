package cn.com.oking.em.action;

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
import cn.com.oking.em.dao.EmXymlFbfwDao;
import cn.com.oking.em.entity.EmXymlFb;
import cn.com.oking.em.entity.EmXymlFbfw;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;

@Component
public class EmXymlFbfwAction {

		@Resource
		private EmXymlFbfwDao fbfwdao;
		
		@Resource
		private EmXymlFbDao fbdao;
		
		@Transactional
		@DataProvider
		public List<EmXymlFbfw> getData(String id){
			return  fbfwdao.find("from EmXymlFbfw where zlbhId='"+id+"'");
		}
		
		
		
		/**
		 * 发布
		 * @param fb
		 */
		@Transactional
		@DataResolver
		public void publish(EmXymlFb fb){
			fb.setPubdate(new Date());
			fb.setStatus("已发布");
			IUser user = ContextHolder.getLoginUser();
			fb.setPubby(user.getCname());
			fbdao.save(fb);
		}
		
		/**
		 * 保存发布范围
		 * @param infos
		 */
		@DataResolver
		@Transactional
		public void save(List<EmXymlFbfw> infos) {
			for (int i = 0; i < infos.size(); i++) {
				EmXymlFbfw em=infos.get(i);
				if (!StringUtil.isNotEmpty(em.getId())) {
					String key=KeyUtil.getKey();
					em.setId(key);
				}
			}
			fbfwdao.persistEntities(infos);
		}
		
		
		
		
		/**
		 * datagrid查询或根据条件查询数据			
		 * @param page
		 * @param params
		 */
		@Transactional		
		@DataProvider			
		public void getData(Page<EmXymlFb> page,Map<String, Object> params){
			if (params!=null) {
				try {
					//    zhlx灾害类型    content紧急通知内容
					fbdao.find(page,"from EmXymlFb where status!='待审核' " 
												+" and zhlx like '%"+params.get("zhlx").toString()
												+"%' and content like '%"+params.get("jjtz").toString()+"%'");
				} catch (Exception e) {
					e.printStackTrace();
					fbdao.find(page,"from EmXymlFb where status!='待审核'");
				}
			}else{
				fbdao.find(page,"from EmXymlFb where status!='待审核'");
				IUser user = ContextHolder.getLoginUser();
				if (user!=null) {
					ContextHolder.getRequest().getSession().setAttribute("username", user.getCname());
				}
			}
		}
}
