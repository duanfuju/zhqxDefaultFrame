package cn.com.oking.em.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import cn.com.oking.em.entity.WeatherRisk;
import com.bstek.dorado.hibernate.HibernateDao;

@Repository
public class WeatherRiskDao extends HibernateDao<WeatherRisk, Long>{
	@Resource(name = "jdbcPub_svc")
	private JdbcTemplate jdbcT;
	
	public List<Map<String, Object>> findWRData(){
		String sql="select filename,filedir,to_char(filetime,'yyyy-mm-dd hh24:mi')filetime,filetype from pub_svc.WEATHER_RISK";
		List<Map<String, Object>> os=jdbcT.queryForList(sql);
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		for (Map<String,Object> map : os) {
			Map<String, Object> m=new HashMap<String, Object>();
			m.put("filename", map.get("filename"));
			m.put("filedir", map.get("filedir"));
			m.put("filetime", map.get("filetime"));
			m.put("filetype", map.get("filetype"));
			list.add(m);
		}
		return list;
	} 
}