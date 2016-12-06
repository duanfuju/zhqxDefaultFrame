package cn.com.oking.em.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;

import cn.com.oking.em.dao.EmDisplayModeDao;
import cn.com.oking.em.entity.EmDisplayMode;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;

@Component
public class EmDisplayModeAction {
	@Resource
	private EmDisplayModeDao dao;
	
	
	
	@Transactional
	@DataProvider	
	public EmDisplayMode findById(String id){
		EmDisplayMode em= (EmDisplayMode) dao.find("from EmDisplayMode where dmId='"+id+"'").get(0);
		return em;
	}
	
	
	@Transactional
	@DataProvider	
	public void getData(Page<EmDisplayMode> page,Map<String, Object> params){
		dao.find(page,"from EmDisplayMode");
	}
	
	@Transactional
	@DataResolver	
	public void save(List<EmDisplayMode> infos){
		for (int i = 0; i < infos.size(); i++) {
			EmDisplayMode em=infos.get(i);
			if (!StringUtil.isNotEmpty(em.getDmId())) {
				em.setDmId(KeyUtil.getKey());
				em.setType("¶¨ÖÆ");
			}
			if (em.getType().equals("Ä¬ÈÏ")) {
				infos.remove(i);
			}
		}
		if (infos.size()>0) {
			dao.persistEntities(infos);
		}
	}
}
