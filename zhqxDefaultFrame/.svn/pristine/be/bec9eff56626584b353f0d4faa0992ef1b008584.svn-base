package cn.com.oking.waterdata;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class GetWind {
	@Resource(name = "jdbcPub_svc")
	private JdbcTemplate jdbcT;

	public Map<String, Object> getWind() {
		String sql = "select obtid,wd2dd,wd2df from(select * from(select obtid,wd2dd,wd2df from t_js_obt_min_wind t order by bj_datetime desc)where rownum<=16) where wd2df=(select max(wd2df) from(select OBTID,wd2dd,wd2df from t_js_obt_min_wind t order by bj_datetime desc) where rownum<=16)";

		Map<String, Object> map;
		map = jdbcT.queryForList(sql).get(0);
		
//		map.put("HOURR", map.get("OBTID")+"");
//		map.put("WD2DD", map.get("WD2DD")+"");
//		map.put("WD2DF", map.get("WD2DF")+"");
//		
		FileUtil.contentToTxt(FileUtil.windfilename, map.toString());
		
		return map;
	}
}
