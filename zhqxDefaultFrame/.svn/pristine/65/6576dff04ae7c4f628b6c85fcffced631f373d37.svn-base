package cn.com.oking.em.action;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.data.provider.Page;
import com.bstek.dorado.web.DoradoContext;

import cn.com.oking.em.dao.EmStoreDao;
import cn.com.oking.em.dao.EmSuppliesDao;
import cn.com.oking.em.entity.EmStore;
import cn.com.oking.em.entity.EmSupplies;
import cn.com.oking.em.entity.XEmSupplies;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;

@Component
public class EmSuppliesAction {
	@Resource
	private EmSuppliesDao dao;
	@Resource
	private EmStoreDao sdao;
	
	
	@Transactional		
	@DataProvider
	public Collection<EmSupplies> getDataByStorename(String storenum){
		EmStore store=(EmStore) sdao.find("from EmStore where storenum='"+storenum+"'").get(0);
		Collection<EmSupplies>	list= dao.find("from EmSupplies where location ='"+store.getStorename()+"'");
		return list;
	}
	@DataProvider			
	@Transactional
	public void getData(Page<EmSupplies> page,Map<String, Object> params){
		if (params!=null) {
			try {
				dao.find(page,"from EmSupplies where  description like '%"+params.get("description").toString()+"%' and contraces like '%"+params.get("contraces").toString()+"%'  order by id desc");
			} catch (Exception e) {
				e.printStackTrace();
				dao.find(page,"from EmSupplies order by id desc");
			}
		}else{
			dao.find(page,"from EmSupplies order by id desc");
		}
	}
	
	@Transactional
	@DataProvider
	public Collection<EmSupplies> getDataTree(String name){
		Collection<EmSupplies>	list= dao.find("from EmSupplies where description like '%"+name+"%'");
		return list;
	}
	
	
	@DataResolver
	@Transactional
	public void save(List<EmSupplies> infos) {
		for (int i = 0; i < infos.size(); i++) {
			EmSupplies em=infos.get(i);
			if (!StringUtil.isNotEmpty(em.getId())) {
				String key=KeyUtil.getKey();
				em.setId(key);
				em.setItemnum(key);
			}
		}
		dao.persistEntities(infos);
	}
	
	
	@Expose
	@Transactional		
	public void saveList(List<EmSupplies> param){
		List<XEmSupplies> listx=new ArrayList<XEmSupplies>();
		for (EmSupplies emSupplies : param) {
			XEmSupplies em=new XEmSupplies();
			EmStore es=(EmStore) sdao.find("from EmStore where storename = '"+emSupplies.getLocation()+"'").get(0);
			em.setLongitude(es.getLongitude());
			em.setLatitude(es.getLatitude());
			em.setLocation(emSupplies.getLocation());
			em.setContraces(emSupplies.getContraces());
			em.setPhone(emSupplies.getPhone());
			em.setDescription(emSupplies.getDescription());
			em.setQuantity(emSupplies.getQuantity());
			em.setUnit(emSupplies.getUnit());
			listx.add(em);
		}
		DoradoContext.getCurrent().getRequest().getSession().setAttribute("maps", listx);
	}
}
