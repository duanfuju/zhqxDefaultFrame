package cn.com.oking.waterMonitoring.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


import com.bstek.dorado.annotation.DataProvider;

@Component
public class WeatherStation {
	@Resource(name = "jdbcPub_svc")
	private JdbcTemplate jdbc;

	
	
	/**
	 * ÏÂÀ­¿ò£¨Õ¾µã£©
	 * @return
	 */
	@DataProvider	
	public List<Map<String, Object>> getStationData(){
		List<Map<String, Object>> list=null;
		try {
			String sql="select station_num num, station_name name from weather_station t where px  is not null";
			list = jdbc.queryForList(sql);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}
}
