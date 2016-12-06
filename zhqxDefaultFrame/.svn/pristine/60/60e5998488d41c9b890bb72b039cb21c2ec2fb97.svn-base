package cn.com.oking.waterdata;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class GetPkfsPx {
	@Resource(name = "jdbcPub_svc")
	private JdbcTemplate jdbcT;

	public String getJson2() {
		String sql = "select station_name,(case when WD3SMAXDF=999999.0 then (select round(avg(WD3SMAXDF),1) WD3SMAXDF  from( select  WD3SMAXDF,station_name from (select a.station_num,a.station_name from PUB_SVC.weather_station a left join pub_svc.WEATHER_CITY_STATION b  on a.station_num=b.station_num where b.city_id='320111' )c left join(select max( bj_datetime),obtid,WD3SMAXDF from    PUB_SVC.t_js_obt_hour_wind  d,(select t.obtid||max(t.WD3SMAXDF) as tid from pub_svc.t_js_obt_hour_wind t where t.bj_datetime>sysdate-1  group by t.obtid) e where d.bj_datetime>sysdate-1 and d.obtid||d.WD3SMAXDF = e.tid group by(d.obtid,d.WD3SMAXDF) )f on c.station_num=f.obtid order by WD3SMAXDF desc) where WD3SMAXDF<>999999.0) else WD3SMAXDF end) WD3SMAXDF from (select a.station_num,a.station_name from PUB_SVC.weather_station a left join pub_svc.WEATHER_CITY_STATION b  on a.station_num=b.station_num where b.city_id='320111' )c left join(select max( bj_datetime),obtid,WD3SMAXDF from    PUB_SVC.t_js_obt_hour_wind  d,(select t.obtid||max(t.WD3SMAXDF) as tid from pub_svc.t_js_obt_hour_wind t where t.bj_datetime>sysdate-1  group by t.obtid) e where d.bj_datetime>sysdate-1 and d.obtid||d.WD3SMAXDF = e.tid group by(d.obtid,d.WD3SMAXDF) )f on c.station_num=f.obtid order by WD3SMAXDF desc";
		List<Map<String, Object>> list = jdbcT.queryForList(sql);

		String b = "";
		List<String> l = new ArrayList<String>();

		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < list.size(); j++) {
				Map<String, Object> map = list.get(j);
				b = map.get("WD3SMAXDF").toString();
				l.add(b);
			}
		}
		return l.toString();
	}

	public String getMax() {
		String maxnum = "";
		String sqlmax = "select max(WD3SMAXDF) WD3SMAXDF from( select  WD3SMAXDF,station_name from (select a.station_num,a.station_name from PUB_SVC.weather_station a left join pub_svc.WEATHER_CITY_STATION b  on a.station_num=b.station_num where b.city_id='320111' )c left join(select max( bj_datetime),obtid,WD3SMAXDF from    PUB_SVC.t_js_obt_hour_wind  d,(select t.obtid||max(t.WD3SMAXDF) as tid from pub_svc.t_js_obt_hour_wind t where t.bj_datetime>sysdate-1  group by t.obtid) e where d.bj_datetime>sysdate-1 and d.obtid||d.WD3SMAXDF = e.tid group by(d.obtid,d.WD3SMAXDF) )f on c.station_num=f.obtid order by WD3SMAXDF desc) where WD3SMAXDF<>999999.0";
		List<Map<String, Object>> listmax = jdbcT.queryForList(sqlmax);
		Map<String, Object> vsmax = listmax.get(0);
		maxnum = vsmax.get("WD3SMAXDF").toString();
		return maxnum;
	}

	public String getMin() {
		String minnum = "";
		String sqlmin = "select min(WD3SMAXDF) WD3SMAXDF from( select  WD3SMAXDF,station_name from (select a.station_num,a.station_name from PUB_SVC.weather_station a left join pub_svc.WEATHER_CITY_STATION b  on a.station_num=b.station_num where b.city_id='320111' )c left join(select max( bj_datetime),obtid,WD3SMAXDF from    PUB_SVC.t_js_obt_hour_wind  d,(select t.obtid||max(t.WD3SMAXDF) as tid from pub_svc.t_js_obt_hour_wind t where t.bj_datetime>sysdate-1  group by t.obtid) e where d.bj_datetime>sysdate-1 and d.obtid||d.WD3SMAXDF = e.tid group by(d.obtid,d.WD3SMAXDF) )f on c.station_num=f.obtid order by WD3SMAXDF desc) where WD3SMAXDF<>999999.0";
		List<Map<String, Object>> listmin = jdbcT.queryForList(sqlmin);
		Map<String, Object> vsmin = listmin.get(0);
		minnum = vsmin.get("WD3SMAXDF").toString();
		return minnum;
	}
}