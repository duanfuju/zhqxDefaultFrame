package cn.com.oking.em.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;

import cn.com.oking.em.dao.EmContentListDao;
import cn.com.oking.em.entity.EmContentList;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;
/**
 * ÄÚÈÝÇåµ¥
 * @author Ñ°Ïã
 *
 */
@Component
public class EmContentListAction {
	@Resource
	private EmContentListDao dao;
	
	
	
	@Transactional
	@DataProvider	
	public void getData(Page<EmContentList> page,Map<String, Object> params){
		dao.find(page,"from EmContentList");
	}
	
	@Transactional
	@DataResolver	
	public void save(List<EmContentList> infos){
		for (int i = 0; i < infos.size(); i++) {
			EmContentList em=infos.get(i);
			if (!StringUtil.isNotEmpty(em.getClId())) {
				em.setClId(KeyUtil.getKey());
			}
		}
		dao.persistEntities(infos);
	}
	
	
	
}
