package cn.com.oking.em.action;

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

import cn.com.oking.em.dao.EmMonitoringDao;
import cn.com.oking.em.entity.EmMonitoring;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;

@Component
public class EmMonitoringAction {

	@Resource
	private EmMonitoringDao dao;
	
	@Transactional
	@DataProvider
	public void getData(Page<EmMonitoring> page){
		dao.find(page, "from EmMonitoring");
	}
	
	@Transactional
	@DataProvider
	public List<EmMonitoring> getDataTree(){
		return dao.find("from EmMonitoring");
	}
	
	@DataResolver
	@Transactional
	public void save(List<EmMonitoring> infos) {
		for (int i = 0; i < infos.size(); i++) {
			EmMonitoring es=infos.get(i);
			if (!StringUtil.isNotEmpty(es.getId())) {
				es.setId(KeyUtil.getKey());
			}
		}
		dao.persistEntities(infos);
	}
	@DataResolver
	@Transactional		
	public void save1(EmMonitoring info) {
		if (!StringUtil.isNotEmpty(info.getId())) {
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
