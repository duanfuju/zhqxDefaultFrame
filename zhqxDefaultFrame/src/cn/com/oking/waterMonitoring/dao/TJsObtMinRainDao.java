package cn.com.oking.waterMonitoring.dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.com.oking.entity.TJsObtMinRain;


@Repository
public class TJsObtMinRainDao{
	
	@Resource(name = "jdbcPub_svc")
	private JdbcTemplate jdbcT;
	
	public List<TJsObtMinRain> findByObtid(String obtid){
		String sql="select to_char(bj_datetime,'yyyy-mm-dd hh24:mi')ddatetime,hour1r from t_js_obt_min_rain where obtid='"+obtid
				+"' and sysdate-bj_datetime<48 order by ddatetime desc";//1.9
		List<Map<String, Object>> os=jdbcT.queryForList(sql);
		List<TJsObtMinRain> list=new ArrayList<TJsObtMinRain>();
		for (Map<String,Object> map : os) {
			TJsObtMinRain tj=new TJsObtMinRain();
			SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm");
			try {
				tj.setDdatetime(sim.parse(map.get("ddatetime").toString()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			tj.setHour1r(new BigDecimal(map.get("hour1r").toString()));
			list.add(tj);
		}
		return list;
	}
}
