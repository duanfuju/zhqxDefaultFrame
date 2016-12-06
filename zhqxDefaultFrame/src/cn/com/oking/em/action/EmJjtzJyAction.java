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

import cn.com.oking.em.dao.EmJjtzJyDao;
import cn.com.oking.em.entity.EmJjtzJy;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;

@Component
public class EmJjtzJyAction {
	
		@Resource
		private EmJjtzJyDao jydao;
		
		
		
		
		/**
		 * 有条件就根据条件查询，如果没有就查所有
		 * @param page
		 * @param params
		 */
		@Transactional
		@DataProvider		
		public void getData(Page<EmJjtzJy> page,Map<String, Object> params){
			if (params!=null) {
				try {
					//subject紧急通知主题    zhlx灾害类型    content紧急通知内容
					jydao.find(page,"from EmJjtzJy where subject like '%"+params.get("zt").toString()
												+"%' and zhlx like '%"+params.get("zhlx").toString()
												+"%' and content like '%"+params.get("jjtz").toString()+"%'");
				} catch (Exception e) {
					e.printStackTrace();
					jydao.find(page,"from EmJjtzJy");
				}
			}else{
				IUser user = ContextHolder.getLoginUser();
				if (user!=null) {
					ContextHolder.getRequest().getSession().setAttribute("username", user.getCname());
				}
				jydao.find(page,"from EmJjtzJy");
			}
		}
		/**
		 * 有datagrid中点击行后根据id编号查询单体
		 * @param page
		 * @param params
		 */
		@Transactional
		@DataProvider		
		public EmJjtzJy getDataById(String id){
			return (EmJjtzJy) jydao.find("from EmJjtzJy where id='"+id+"'").get(0);
		}
		
		/**
		 * 删除的操作
		 * @param infos
		 */
		@DataResolver
		@Transactional
		public void save(List<EmJjtzJy> infos) {
			jydao.persistEntities(infos);
		}
		
		/**
		 * 修改和保存的操作
		 * @param infos
		 */
		@DataResolver
		@Transactional
		public void save(EmJjtzJy info) {
			IUser user = ContextHolder.getLoginUser();
			if (user!=null) {
				ContextHolder.getRequest().getSession().setAttribute("username", user.getCname());
				if (!StringUtil.isNotEmpty(info.getId())) {
					String key=KeyUtil.getKey();
					info.setId(key);
					info.setCreateby(user.getCname());
					info.setCreatedate(new Date());
				}
				jydao.save(info);
			}
		}
}
