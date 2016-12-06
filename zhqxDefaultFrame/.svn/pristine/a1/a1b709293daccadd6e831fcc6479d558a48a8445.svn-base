package cn.com.oking.dataInterface.action;

import java.util.Collection;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;
import cn.com.oking.dataInterface.dao.LMonitorSysListDao;
import cn.com.oking.entity.MonitorSysList;

@Component
public class SysListAction {
	
	@Resource
	private LMonitorSysListDao listDao;
	
	
	@DataProvider
	@Transactional
	public Collection<MonitorSysList> getAll(){
		return listDao.getAll();
	}
	
	//分页查询
	@DataProvider
	@Transactional
	public void getAll(Page<MonitorSysList> page){
		System.out.println("pageNo:"+page.getPageNo());
		System.out.println("pageSize:"+page.getPageSize());
		//page.setEntities(data);
		listDao.find(page,"from MonitorSysList");
	}
    //多条查询
	@DataProvider
	@Transactional
	public void method(Page<MonitorSysList>page,String dataname){
			if(null !=dataname)
				listDao.find(page,"from MonitorSysList where dataname like '%"+dataname+"%'");
			else
				listDao.getAll(page);
	}	

	//保存，增删改                    
	@DataResolver  
	@Transactional
	public void saveAll(Collection<MonitorSysList> monitorSysList){
		listDao.persistEntities(monitorSysList);
	}
}

