package cn.com.oking.em.action;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;

import cn.com.oking.em.dao.EmResponsesPlanDao;
import cn.com.oking.em.entity.EmResponsesPlan;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;

@Component
public class EmResponsesPlanAction {
	@Resource
	private EmResponsesPlanDao dao;
	
	@DataProvider
	@Transactional	
	public void getData(Page<EmResponsesPlan> page){
		dao.find(page,"from EmResponsesPlan");
	}
	@DataProvider		
	@Transactional	
	public EmResponsesPlan getPlanByPlannum(String id){
		EmResponsesPlan em=(EmResponsesPlan) dao.find("from EmResponsesPlan where id='"+id+"'").get(0);
		return  em;
	}
	
	
	@DataResolver
	@Transactional	
	public void save(List<EmResponsesPlan> infos){
		for (int i = 0; i < infos.size(); i++) {
			EmResponsesPlan em=infos.get(i);
			String key=KeyUtil.getKey();
			if (!StringUtil.isNotEmpty(em.getId())) {
				em.setId(key);
			}
		}
		dao.persistEntities(infos);
	}
	@DataResolver
	@Transactional	
	public void save(EmResponsesPlan entity){
		dao.save(entity);
	}
}
