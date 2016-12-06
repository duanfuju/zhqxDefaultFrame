package cn.com.oking.em.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;

import cn.com.oking.em.dao.EmModeContentDefaultDao;
import cn.com.oking.em.entity.EmContentList;
import cn.com.oking.em.entity.EmModeContentDefault;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;

@Component
public class EmModeContentAction {
	
	@Resource
	private EmModeContentDefaultDao dao;
	
	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcT;
	
	@Transactional
	@DataProvider		
	public void getData(Page<EmModeContentDefault> page,Map<String, Object> params){
		dao.find(page,"from EmModeContentDefault where dmId='"+params.get("dmId")+"'");
	}
	
	@Transactional
	@DataResolver	
	public void save(List<EmModeContentDefault> infos){
		for (int i = 0; i < infos.size(); i++) {
			EmModeContentDefault em=infos.get(i);
			if (!StringUtil.isNotEmpty(em.getMcId())) {
				em.setMcId(KeyUtil.getKey());
			}
		}
		dao.persistEntities(infos);
	}
	
	@Transactional
	@DataProvider	
	public List<Map<String, Object>>  getDataByDmId(String id){
		List<Map<String, Object>> list=null;
		try {
			String sql="select mc_id, cl_num, description, url, line, col" +
					", orderid, mc_num, img_src, displaysize, dm_id " +
					" from em_mode_content_default where dm_id='"+id+"' order by orderid";
			list=jdbcT.queryForList(sql);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}
	
}
