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

import cn.com.oking.em.dao.EmXymlJyDao;
import cn.com.oking.em.entity.EmXymlJy;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;

@Component
public class EmXymlJyAction {

		@Resource
		private EmXymlJyDao jydao;
		
		/**
		 * �������͸���������ѯ�����û�оͲ�����
		 * @param page
		 * @param params
		 */
		@Transactional
		@DataProvider		
		public void getData(Page<EmXymlJy> page,Map<String, Object> params){
			if (params!=null) {
				try {
					//    zhlx�ֺ�����    content����֪ͨ����
					jydao.find(page,"from EmXymlJy where zhlx like '%"+params.get("zhlx").toString()
												+"%' and content like '%"+params.get("content").toString()+"%'");
				} catch (Exception e) {
					e.printStackTrace();
					jydao.find(page,"from EmXymlJy");
				}
			}else{
				IUser user = ContextHolder.getLoginUser();
				if (user!=null) {
					ContextHolder.getRequest().getSession().setAttribute("username", user.getCname());
				}
				jydao.find(page,"from EmXymlJy");
			}
		}
		/**
		 * ��datagrid�е���к����id��Ų�ѯ����
		 * @param page
		 * @param params
		 */
		@Transactional
		@DataProvider		
		public EmXymlJy getDataById(String id){
			return (EmXymlJy) jydao.find("from EmXymlJy where id='"+id+"'").get(0);
		}
		
		/**
		 * ɾ���Ĳ���
		 * @param infos
		 */
		@DataResolver
		@Transactional
		public void save(List<EmXymlJy> infos) {
			jydao.persistEntities(infos);
		}
		
		/**
		 * �޸ĺͱ���Ĳ���
		 * @param infos
		 */
		@DataResolver
		@Transactional
		public void save(EmXymlJy info) {
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
