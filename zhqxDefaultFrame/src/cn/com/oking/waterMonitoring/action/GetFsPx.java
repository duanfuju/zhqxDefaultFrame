package cn.com.oking.waterMonitoring.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class GetFsPx {
	@Resource(name = "jdbcPub_svc")
	private JdbcTemplate jdbcT;
	
	public String getJson1(String stime,String etime) {
	    String sql = "select station_name,(case when WD3SMAXDF=999999.0 then (select round(avg(WD3SMAXDF),1) WD3SMAXDF  from( select  WD3SMAXDF,station_name from (select a.station_num,a.station_name from PUB_SVC.weather_station a left join pub_svc.WEATHER_CITY_STATION b  on a.station_num=b.station_num where b.city_id='320111' )c left join(select max( bj_datetime),obtid,WD3SMAXDF from    PUB_SVC.t_js_obt_hour_wind  d,(select t.obtid||max(t.WD3SMAXDF) as tid from pub_svc.t_js_obt_hour_wind t where t.bj_datetime between to_date('"+stime+"','yyyy-MM-dd hh24:mi') and to_date('"+etime+"','yyyy-MM-dd hh24:mi')  group by t.obtid) e where d.bj_datetime between to_date('"+stime+"','yyyy-MM-dd hh24:mi') and to_date('"+etime+"','yyyy-MM-dd hh24:mi') and d.obtid||d.WD3SMAXDF = e.tid group by(d.obtid,d.WD3SMAXDF) )f on c.station_num=f.obtid order by WD3SMAXDF desc) where WD3SMAXDF<>999999.0) else WD3SMAXDF end) WD3SMAXDF from (select a.station_num,a.station_name from PUB_SVC.weather_station a left join pub_svc.WEATHER_CITY_STATION b  on a.station_num=b.station_num where b.city_id='320111' )c left join(select max( bj_datetime),obtid,WD3SMAXDF from    PUB_SVC.t_js_obt_hour_wind  d,(select t.obtid||max(t.WD3SMAXDF) as tid from pub_svc.t_js_obt_hour_wind t where t.bj_datetime between to_date('"+stime+"','yyyy-MM-dd hh24:mi') and to_date('"+etime+"','yyyy-MM-dd hh24:mi')  group by t.obtid) e where d.bj_datetime between to_date('"+stime+"','yyyy-MM-dd hh24:mi') and to_date('"+etime+"','yyyy-MM-dd hh24:mi') and d.obtid||d.WD3SMAXDF = e.tid group by(d.obtid,d.WD3SMAXDF) )f on c.station_num=f.obtid order by WD3SMAXDF desc";
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
		 String sql = "select station_name,(case when WD3SMAXDF=999999.0 then (select round(avg(WD3SMAXDF),1) WD3SMAXDF  from( select  WD3SMAXDF,station_name from (select a.station_num,a.station_name from PUB_SVC.weather_station a left join pub_svc.WEATHER_CITY_STATION b  on a.station_num=b.station_num where b.city_id='320111' )c left join(select max( bj_datetime),obtid,WD3SMAXDF from    PUB_SVC.t_js_obt_hour_wind  d,(select t.obtid||max(t.WD3SMAXDF) as tid from pub_svc.t_js_obt_hour_wind t where t.bj_datetime between to_date('"+stime+"','yyyy-MM-dd hh24:mi') and to_date('"+etime+"','yyyy-MM-dd hh24:mi')  group by t.obtid) e where d.bj_datetime between to_date('"+stime+"','yyyy-MM-dd hh24:mi') and to_date('"+etime+"','yyyy-MM-dd hh24:mi') and d.obtid||d.WD3SMAXDF = e.tid group by(d.obtid,d.WD3SMAXDF) )f on c.station_num=f.obtid order by WD3SMAXDF desc) where WD3SMAXDF<>999999.0) else WD3SMAXDF end) WD3SMAXDF from (select a.station_num,a.station_name from PUB_SVC.weather_station a left join pub_svc.WEATHER_CITY_STATION b  on a.station_num=b.station_num where b.city_id='320111' )c left join(select max( bj_datetime),obtid,WD3SMAXDF from    PUB_SVC.t_js_obt_hour_wind  d,(select t.obtid||max(t.WD3SMAXDF) as tid from pub_svc.t_js_obt_hour_wind t where t.bj_datetime between to_date('"+stime+"','yyyy-MM-dd hh24:mi') and to_date('"+etime+"','yyyy-MM-dd hh24:mi')  group by t.obtid) e where d.bj_datetime between to_date('"+stime+"','yyyy-MM-dd hh24:mi') and to_date('"+etime+"','yyyy-MM-dd hh24:mi') and d.obtid||d.WD3SMAXDF = e.tid group by(d.obtid,d.WD3SMAXDF) )f on c.station_num=f.obtid order by WD3SMAXDF desc";
	    List<Map<String, Object>> list = jdbcT.queryForList(sql);
	    String str="";
	    for (int i = 0; i < list.size(); i++) {
    	  Map<String, Object> map = list.get(i);
    	  str += "'"+map.get("WD3SMAXDF").toString()+"',";
	    }
	    str=str.substring(0, str.length()-1);
	    str="["+str+"]";
	    return str;
	}
}
