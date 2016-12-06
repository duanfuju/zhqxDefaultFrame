package cn.com.oking.dataInterface.action;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;


import cn.com.oking.dataInterface.dao.MonitorAdminDao;
import cn.com.oking.dataInterface.entity.MonitorAdmin;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;

@Component
public class MonitorAdminAction {
	
	@Resource
	private MonitorAdminDao monitorAdminDao;
	
	@DataProvider
	@Transactional
	public Collection<MonitorAdmin> getAll(){
		return monitorAdminDao.getAll();
	}
	
	@DataProvider
	@Transactional
	public void getAll(Page<MonitorAdmin>page){
		System.out.println("pageNo:"+page.getPageNo());
		System.out.println("pageSize:"+page.getPageSize());
		//page.setEntities(data);
		monitorAdminDao.find(page,"from MonitorAdmin");
	}
	
	@DataProvider
	@Transactional
	public void method(Page<MonitorAdmin>page,String adminname){
		if(null !=adminname)
			monitorAdminDao.find(page,"from MonitorAdmin where adminname like '%"+adminname+"%'");
		else
			monitorAdminDao.getAll(page);
	}
	
	@DataResolver
	@Transactional
	public void saveAll(List<MonitorAdmin> monitorAdmin){
		for (int i = 0; i < monitorAdmin.size(); i++) {
			MonitorAdmin em=monitorAdmin.get(i);
			if (!StringUtil.isNotEmpty(em.getId())) {
				String key=KeyUtil.getKey();
				em.setId(key);
			}
			monitorAdminDao.persistEntities(monitorAdmin);
		}
	}

}