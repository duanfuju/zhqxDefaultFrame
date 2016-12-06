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

import cn.com.oking.em.dao.EmCzfaJyDao;
import cn.com.oking.em.entity.EmCzfaJy;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;

@Component
public class EmCzfaJyAction {

		@Resource
		private EmCzfaJyDao jydao;
		
		@Transactional
		@DataProvider
		public void getData(Page<EmCzfaJy> page,Map<String, Object> params){
			if (params!=null) {
				jydao.find(page,"from EmCzfaJy where zhlx like '%"+params.get("zhlx")+"%' and NVL(orderNumber,0) like '%"+params.get("orderNumber")+"%'");
										
			}else{
				jydao.find(page,"from EmCzfaJy");
			}
		}
		
		
		/**
		 * 有datagrid中点击行后根据id编号查询单体
		 * @param page
		 * @param params
		 */
		@Transactional
		@DataProvider		
		public EmCzfaJy getDataById(String id){
			return (EmCzfaJy) jydao.find("from EmCzfaJy where id='"+id+"'").get(0);
		}
		
		/**
		 * 删除的操作
		 * @param infos
		 */
		@DataResolver
		@Transactional
		public void save(List<EmCzfaJy> infos) {
			jydao.persistEntities(infos);
		}
		
		/**
		 * 修改和保存的操作
		 * @param infos
		 */
		@DataResolver
		@Transactional
		public void save(EmCzfaJy info) {
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
