package cn.com.oking.em.action;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.com.oking.em.dao.EmHospitalDao;
import cn.com.oking.em.entity.EmHospital;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;

import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.data.provider.Page;
import com.bstek.dorado.web.DoradoContext;

@Component
public class EmHospitalAction {
	@Resource
	private EmHospitalDao dao;
	
	
	@DataProvider
	@Transactional				
	public Collection<EmHospital> getDataById(String id){
		Collection<EmHospital> list=null;
		if (StringUtil.isNotEmpty(id)) {
			list=dao.find("from EmHospital where parentid='"+id+"'");
			
		}else{
			list= dao.find("from EmHospital where parentid is null");
		}
		return list;
	}
	@DataProvider
	@Transactional				
	public Collection<EmHospital> getDataDropList(){
		return dao.find("from EmHospital where parentid is null");
	}
	
	
	
	
	@DataProvider
	@Transactional
	public void getData(Page<EmHospital> page){
		dao.find(page," from EmHospital where parentid is not null");
	}
	
	@DataResolver
	@Transactional
	public void save(List<EmHospital> infos) {
		for (int i = 0; i < infos.size(); i++) {
			EmHospital es=infos.get(i);
			if (!StringUtil.isNotEmpty(es.getId())) {
				es.setId(KeyUtil.getKey());
			}
		}
		dao.persistEntities(infos);
	}
	
	@DataResolver
	@Transactional		
	public void save1(EmHospital info) {
		if (!StringUtil.isNotEmpty(info.getId())) {
			String parent=info.getParentid();
			EmHospital es=(EmHospital) dao.find(" from EmHospital where placename='"+parent+"'").get(0);
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
