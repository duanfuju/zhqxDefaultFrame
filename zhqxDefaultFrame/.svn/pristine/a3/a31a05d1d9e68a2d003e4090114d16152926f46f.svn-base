package cn.com.oking.waterdata;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class GetWateData {

	@Resource(name = "jdbcPub_svc")
	private JdbcTemplate jdbcT;

	public Map<String, Object> getData() {
		List<Map<String, Object>> list = null;
	
		try {
			String sql = "select * from water_data t order by wd_date desc";
			list = jdbcT.queryForList(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}
}
