package cn.com.oking.dataInterface.action;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;

import cn.com.oking.dataInterface.dao.HrefModuleDao;
import cn.com.oking.dataInterface.entity.HrefModule;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;


@Component
public class HrefModuleAction {

	@Resource
	private HrefModuleDao hrefModuleDao;
	
	@DataProvider
	@Transactional
	public Collection<HrefModule> getAll(){
		return hrefModuleDao.getAll();
	}
	
	@DataProvider
	@Transactional
	public void getAll(Page<HrefModule> page){
		System.out.println("pageNo:"+page.getPageNo());
		System.out.println("pageSize:"+page.getPageSize());
		//page.setEntities(data);
		hrefModuleDao.find(page,"from HrefModule");
	}
	
	
	@DataProvider
	@Transactional
	public void method(Page<HrefModule>page,String modulename){
		if(null !=modulename)
			hrefModuleDao.find(page,"from HrefModule where modulename like '%"+modulename+"%'");
		else
			hrefModuleDao.getAll(page);
	}
	
	@DataResolver
	@Transactional
	public void saveAll(List<HrefModule> hrefModule){
		for (int i = 0; i < hrefModule.size(); i++) {
			HrefModule em=hrefModule.get(i);
			if (!StringUtil.isNotEmpty(em.getId())) {
				String key=KeyUtil.getKey();
				em.setId(key);
			}
			hrefModuleDao.persistEntities(hrefModule);
	}
	}
}

