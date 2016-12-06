package cn.com.oking.em.action;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.data.provider.Page;
import com.bstek.dorado.web.DoradoContext;

import cn.com.oking.em.dao.EmStoreDao;
import cn.com.oking.em.entity.EmStore;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;

@Component
public class EmStoreAction {

	@Resource			
	private EmStoreDao dao;
	
	@Transactional
	@DataProvider
	public void getData(Page<EmStore> page){
		dao.find(page, "from EmStore order by id desc");
	}
	
	@Transactional
	@DataProvider
	public Collection<EmStore> getDataTree(){
		return dao.find("from EmStore");
	}
	
	@Transactional		
	@DataProvider
	public List<EmStore> getReference(String storename){
		List<EmStore> list= dao.find("from EmStore where storename='"+storename+"'");
		return list;
	}
	
	
	@DataResolver
	@Transactional
	public void save(List<EmStore> infos) {
		for (int i = 0; i < infos.size(); i++) {
			EmStore es=infos.get(i);
			String key=KeyUtil.getKey();
			if (!StringUtil.isNotEmpty(es.getId())) {
				es.setId(key);
				es.setStorenum(key);
			}
		}
		dao.persistEntities(infos);
	}
	@DataResolver
	@Transactional		
	public void save1(EmStore info) {
		String key=KeyUtil.getKey();
		if (!StringUtil.isNotEmpty(info.getId())) {
			info.setId(key);
			info.setStorenum(key);
		}
		dao.save(info);
	}
	@Expose
	@Transactional		
	public String getCoordinates(){
		String longitude=(String) ContextHolder.getRequest().getSession().getAttribute("longitude");
		String latitude= (String) ContextHolder.getRequest().getSession().getAttribute("latitude");
		StringBuffer info = new StringBuffer();
		info.append("{'longitude':'"+longitude+"',");
		info.append("'latitude':'"+latitude+"'}");
		return info.toString();
	}
	
	@Expose
	@Transactional		
	public void saveList(List<Object> param){
		DoradoContext.getCurrent().getRequest().getSession().setAttribute("maps", param);
	}
}
