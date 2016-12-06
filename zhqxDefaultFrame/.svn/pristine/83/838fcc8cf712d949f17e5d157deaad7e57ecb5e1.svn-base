package cn.com.oking.em.action;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.bdf2.core.CoreHibernateDao;
import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.data.provider.Page;
import com.bstek.dorado.web.DoradoContext;

import cn.com.oking.em.dao.EmShelterDao;
import cn.com.oking.em.entity.EmShelter;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;

@Component
public class EmShelterAction extends CoreHibernateDao{
	@Resource
	private EmShelterDao dao;
	
	
	@DataProvider
	@Transactional				
	public Collection<EmShelter> getDataById(String id){
		Collection<EmShelter> list=null;
		if (StringUtil.isNotEmpty(id)) {
			list=dao.find("from EmShelter where parentid='"+id+"'");
			
		}else{
			list= dao.find("from EmShelter where parentid is null");
		}
		return list;
	}
	@DataProvider
	@Transactional				
	public Collection<EmShelter> getDataDropList(){
		return dao.find("from EmShelter where parentid is null");
	}
	
	
	
	
	@DataProvider
	@Transactional
	public void getData(Page<EmShelter> page){
		dao.find(page," from EmShelter where parentid is not null");
	}
	
	@DataResolver
	@Transactional
	public void save(List<EmShelter> infos) {
		for (int i = 0; i < infos.size(); i++) {
			EmShelter es=infos.get(i);
			if (!StringUtil.isNotEmpty(es.getId())) {
				es.setId(KeyUtil.getKey());
			}
		}
		dao.persistEntities(infos);
	}
	
	@DataResolver
	@Transactional		
	public void save1(EmShelter info) {
		if (!StringUtil.isNotEmpty(info.getId())) {
			String parent=info.getParentid();
			EmShelter es=(EmShelter) dao.find(" from EmShelter where placename='"+parent+"'").get(0);
			info.setParentid(es.getId());
			info.setId(KeyUtil.getKey());
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
