package cn.com.oking.em.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;

import cn.com.oking.em.dao.EmDocdemoDao;
import cn.com.oking.em.entity.EmDocdemo;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;


@Component
public class EmDocdemoAction {
	@Resource
	private EmDocdemoDao dao;
	
	@Transactional
	@DataProvider
	public void getData(Page<EmDocdemo> page){
		dao.find(page,"from EmDocdemo");
	}
	
	@DataProvider		
	@Transactional	
	public EmDocdemo getPlanById(String id){
		EmDocdemo em=(EmDocdemo) dao.find("from EmDocdemo where id='"+id+"'").get(0);
		return  em;
	}
	
	
	@DataResolver
	@Transactional	
	public void save(List<EmDocdemo> infos){
		for (int i = 0; i < infos.size(); i++) {
			EmDocdemo em=infos.get(i);
			String key=KeyUtil.getKey();
			if (!StringUtil.isNotEmpty(em.getId())) {
				em.setId(key);
			}
		}
		dao.persistEntities(infos);
	}
	@DataResolver
	@Transactional	
	public void save(EmDocdemo entity){
		dao.save(entity);
	}
}
