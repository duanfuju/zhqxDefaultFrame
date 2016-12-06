package cn.com.oking.dataInterface.action;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;

import com.bstek.dorado.data.provider.Page;

import cn.com.oking.dataInterface.dao.MonitorListDao;
import cn.com.oking.dataInterface.entity.MonitorList;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;

@Component
public class MonitorListAction {
	@Resource
	private MonitorListDao listDao;
	
	@DataProvider
	@Transactional
	public Collection<MonitorList> getAll()throws Exception{
		Collection<MonitorList> list=listDao.find("from MonitorList");
		return list;
	}
	@DataProvider
	@Transactional
	public void getAll(Page<MonitorList>page){
		System.out.println("pageNo:"+page.getPageNo());
		System.out.println("pageSize:"+page.getPageSize());
		//page.setEntities(data);
		listDao.find(page,"from MonitorList");
	}
	
	//µ•Ãı≤È—Ø
	@DataProvider
	@Transactional
	public void method(Page<MonitorList> page,String dataname){
		if(null !=dataname)
			listDao.find(page,"from MonitorList where dataname like '%"+dataname+"%'");
		else
			listDao.getAll(page);
	}
	@DataResolver
	@Transactional
	public void saveAll(List<MonitorList> monitorList){
		for (int i = 0; i < monitorList.size(); i++) {
			MonitorList em=monitorList.get(i);
			if (!StringUtil.isNotEmpty(em.getId())) {
				String key=KeyUtil.getKey();
				em.setId(key);
			}
		listDao.persistEntities(monitorList);
	}
	}
}