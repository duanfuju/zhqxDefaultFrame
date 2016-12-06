package cn.com.oking.waterMonitoring.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class GetYlPx {
	@Resource(name = "jdbcPub_svc")
	private JdbcTemplate jdbcT;
	
	public String getJson1(String stime,String etime) {
	    String sql = "select station_name from (select a.station_num,a.station_name from pub_svc.weather_station a left join pub_svc.WEATHER_CITY_STATION b on a.station_num=b.station_num  where b.city_id='320111' )c left join(select  bj_datetime,obtid,hour24r  from    pub_svc.t_js_obt_hour_rain  d,(select max(to_char(t.bj_datetime,'yyyy-mm-dd hh24:mi:ss'))||t.obtid as tid from pub_svc.t_js_obt_hour_rain  t where t.bj_datetime between to_date('"+stime+"','yyyy-MM-dd hh24:mi') and to_date('"+etime+"','yyyy-MM-dd hh24:mi') group by t.obtid) e where d.bj_datetime between to_date('"+stime+"','yyyy-MM-dd hh24:mi') and to_date('"+etime+"','yyyy-MM-dd hh24:mi') and (to_char(d.bj_datetime,'yyyy-mm-dd hh24:mi:ss'))||d.obtid = e.tid)f on c.station_num=f.obtid order by f.hour24r desc";
	    List<Map<String, Object>> list = jdbcT.queryForList(sql);
	    String str="";
	    for (int i = 0; i < list.size(); i++) {
    	  Map<String, Object> map = list.get(i);
    	  str += "'"+map.get("station_name").toString()+"',";
	    }
	    str=str.substring(0, str.length()-1);
	    str="["+str+"]";
	    return str;
	}
	
	
	
	 public  String getJson2(String stime,String etime) {
	    String sql = "select hour24r from (select a.station_num,a.station_name from pub_svc.weather_station a left join pub_svc.WEATHER_CITY_STATION b on a.station_num=b.station_num  where b.city_id='320111' )c left join(select  bj_datetime,obtid,(hour24r-hourr) as hour24r  from    pub_svc.t_js_obt_hour_rain  d,(select max(to_char(t.bj_datetime,'yyyy-mm-dd hh24:mi:ss'))||t.obtid as tid from pub_svc.t_js_obt_hour_rain  t where t.bj_datetime between to_date('"+stime+"','yyyy-MM-dd hh24:mi') and to_date('"+etime+"','yyyy-MM-dd hh24:mi') group by t.obtid) e where d.bj_datetime between to_date('"+stime+"','yyyy-MM-dd hh24:mi') and to_date('"+etime+"','yyyy-MM-dd hh24:mi') and (to_char(d.bj_datetime,'yyyy-mm-dd hh24:mi:ss'))||d.obtid = e.tid)f on c.station_num=f.obtid order by f.hour24r desc";
	    List<Map<String, Object>> list = jdbcT.queryForList(sql);
	    String str="";
	    for (int i = 0; i < list.size(); i++) {
    	  Map<String, Object> map = list.get(i);
    	  str += "'"+map.get("hour24r").toString()+"',";
	    }
	    str=str.substring(0, str.length()-1);
	    str="["+str+"]";
	    return str;
	}
}
