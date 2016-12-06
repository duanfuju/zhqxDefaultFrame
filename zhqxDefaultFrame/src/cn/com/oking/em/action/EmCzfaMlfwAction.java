package cn.com.oking.em.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.bdf2.core.business.IUser;
import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;

import cn.com.oking.em.dao.EmCzfaMlDao;
import cn.com.oking.em.dao.EmCzfaMlfwDao;
import cn.com.oking.em.entity.EmCzfaMl;
import cn.com.oking.em.entity.EmCzfaMlfw;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;


@Component
public class EmCzfaMlfwAction {

	@Resource
	private EmCzfaMlfwDao fwdao;
	
	@Resource
	private EmCzfaMlDao mldao;
	
	@Transactional
	@DataProvider
	public List<EmCzfaMlfw> getData(String id){
		return  fwdao.find("from EmCzfaMlfw where czfaJyId='"+id+"'");
	}
	

	
	/**
	 * 发布
	 * @param fb
	 */
	@Transactional
	@DataResolver
	public void publish(EmCzfaMl fb){
		fb.setPubdate(new Date());
		fb.setStatus("已发布");
		IUser user = ContextHolder.getLoginUser();
		fb.setPubby(user.getCname());
		mldao.save(fb);
	}
	
	/**
	 * 保存发布范围
	 * @param infos
	 */
	@DataResolver
	@Transactional
	public void save(List<EmCzfaMlfw> infos) {
		for (int i = 0; i < infos.size(); i++) {
			EmCzfaMlfw em=infos.get(i);
			if (!StringUtil.isNotEmpty(em.getId())) {
				String key=KeyUtil.getKey();
				em.setId(key);
			}
		}
		fwdao.persistEntities(infos);
	}
	
}
