package cn.com.oking.waterdata;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class GetRain {
	@Resource(name = "jdbcPub_svc")
	private JdbcTemplate jdbcT;

	public List<Map<String, Object>> getRain() {
		String sql1r = "select hour1r as hourr,obtid from(select * from(select OBTID,HOUR1R,HOUR3R,HOUR6R,HOUR24R from t_js_obt_min_rain t order by bj_datetime desc)where rownum<=16) where hour1r=(select max(hour1r) from(select OBTID,HOUR1R,HOUR3R,HOUR6R,HOUR24R from t_js_obt_min_rain t order by bj_datetime desc) where rownum<=16 )";
		String sql3r = "select hour3r as hourr,obtid from(select * from(select OBTID,HOUR1R,HOUR3R,HOUR6R,HOUR24R from t_js_obt_min_rain t order by bj_datetime desc)where rownum<=16) where hour3r=(select max(hour3r) from(select OBTID,HOUR1R,HOUR3R,HOUR6R,HOUR24R from t_js_obt_min_rain t order by bj_datetime desc) where rownum<=16 )";
		String sql6r = "select hour6r as hourr,obtid from(select * from(select OBTID,HOUR1R,HOUR3R,HOUR6R,HOUR24R from t_js_obt_min_rain t order by bj_datetime desc)where rownum<=16) where hour6r=(select max(hour6r) from(select OBTID,HOUR1R,HOUR3R,HOUR6R,HOUR24R from t_js_obt_min_rain t order by bj_datetime desc) where rownum<=16 )";
		String sql24r = "select hour24r as hourr,obtid from(select * from(select OBTID,HOUR1R,HOUR3R,HOUR6R,HOUR24R from t_js_obt_min_rain t order by bj_datetime desc)where rownum<=16) where hour24r=(select max(hour24r) from(select OBTID,HOUR1R,HOUR3R,HOUR6R,HOUR24R from t_js_obt_min_rain t order by bj_datetime desc) where rownum<=16 )";

		List<Map<String, Object>> list_rain = new ArrayList<Map<String, Object>>();

		Map<String, Object> map1 = null, map3 = null, map6 = null, map24 = null;

		map1 = jdbcT.queryForList(sql1r).get(0);
		map3 = jdbcT.queryForList(sql3r).get(0);
		map6 = jdbcT.queryForList(sql6r).get(0);
		map24 = jdbcT.queryForList(sql24r).get(0);

		list_rain.add(map1);
		list_rain.add(map3);
		list_rain.add(map6);
		list_rain.add(map24);
		
		for (int i = 0; i < list_rain.size(); i++) {
			list_rain.get(i).put("OBTID", list_rain.get(i).get("OBTID")+"");
			list_rain.get(i).put("HOURR", list_rain.get(i).get("HOURR")+"");
		}

		FileUtil.contentToTxt(FileUtil.rainfilename,list_rain.toString());
		return list_rain;
	}

	
}
