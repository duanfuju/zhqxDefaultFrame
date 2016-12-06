package cn.com.oking.waterdata;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import cn.com.oking.util.StringUtil;

/**
 * @author sglei
 * @date 2016-1-13
 */
@Component
public class GetPkwdPx {
	@Resource(name = "jdbcPub_svc")
	private JdbcTemplate jdbcT;

	public String getJsongw() {
		String sql = "select station_name,(case when MAXT=999999.0 then (select round(avg(maxt),1) maxt  from ( select MAXT,station_name from (select a.station_num, a.station_name from pub_svc.weather_station a left join pub_svc.WEATHER_CITY_STATION b on a.station_num = b.station_num where b.city_id = '320111') c left join (select max(bj_datetime), obtid, MAXT from pub_svc.t_js_obt_hour_temp d,(select t.obtid || max(t.MAXT) as tid from pub_svc.t_js_obt_hour_temp  t where t.bj_datetime > sysdate - 1 group by t.obtid) e where d.bj_datetime > sysdate - 1 and d.obtid || d.MAXT = e.tid group by (d.obtid, d.MAXT)) f on c.station_num = f.obtid order by MAXT desc)where maxt <>999999.0) else MAXT end)MAXT from (select a.station_num, a.station_name from pub_svc.weather_station a left join pub_svc.WEATHER_CITY_STATION b on a.station_num = b.station_num where b.city_id = '320111') c left join (select max(bj_datetime), obtid, MAXT from pub_svc.t_js_obt_hour_temp d,(select t.obtid || max(t.MAXT) as tid from pub_svc.t_js_obt_hour_temp  t where t.bj_datetime > sysdate - 1 group by t.obtid) e where d.bj_datetime > sysdate - 1 and d.obtid || d.MAXT = e.tid group by (d.obtid, d.MAXT)) f on c.station_num = f.obtid order by station_name";
		List<Map<String, Object>> list = jdbcT.queryForList(sql);
		String yJson = "";
		String b = "";
		String c = "";
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < list.size(); j++) {
				Map<String, Object> vs = list.get(j);
				b = StringUtil.changeZero(vs.get("MAXT"));
				c = c + b + ",";
			}
			int num = c.length();
			c = c.substring(0, num - 1);
			yJson = "[" + c + "]";
		}

		return yJson;
	}

	public String getJson2() {
		String sql = "select station_name,(case when MAXT=999999.0 then (select round(avg(maxt),1) maxt  from ( select MAXT,station_name from (select a.station_num, a.station_name from pub_svc.weather_station a left join pub_svc.WEATHER_CITY_STATION b on a.station_num = b.station_num where b.city_id = '320111') c left join (select max(bj_datetime), obtid, MAXT from pub_svc.t_js_obt_hour_temp d,(select t.obtid || max(t.MAXT) as tid from pub_svc.t_js_obt_hour_temp  t where t.bj_datetime > sysdate - 1 group by t.obtid) e where d.bj_datetime > sysdate - 1 and d.obtid || d.MAXT = e.tid group by (d.obtid, d.MAXT)) f on c.station_num = f.obtid order by MAXT desc)where maxt <>999999.0) else MAXT end)MAXT from (select a.station_num, a.station_name from pub_svc.weather_station a left join pub_svc.WEATHER_CITY_STATION b on a.station_num = b.station_num where b.city_id = '320111') c left join (select max(bj_datetime), obtid, MAXT from pub_svc.t_js_obt_hour_temp d,(select t.obtid || max(t.MAXT) as tid from pub_svc.t_js_obt_hour_temp  t where t.bj_datetime > sysdate - 1 group by t.obtid) e where d.bj_datetime > sysdate - 1 and d.obtid || d.MAXT = e.tid group by (d.obtid, d.MAXT)) f on c.station_num = f.obtid order by MAXT desc";
		List<Map<String, Object>> list = jdbcT.queryForList(sql);
		String yJson = "";
		String b = "";
		String c = "";
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < list.size(); j++) {
				Map<String, Object> vs = list.get(j);
				b = StringUtil.changeZero(vs.get("MAXT"));
				c = c + b + ",";
			}
			int num = c.length();
			c = c.substring(0, num - 1);
			yJson = "[" + c + "]";
		}

		return yJson;
	}

	public String getJsondw() {
		String sql = "select station_name,(case when mint=999999.0 then (select round(avg(mint),1) mint from(select station_name,mint from (select a.station_num, a.station_name from pub_svc.weather_station a left join pub_svc.WEATHER_CITY_STATION b on a.station_num = b.station_num where b.city_id = '320111') c left join (select max(bj_datetime), obtid, mint from pub_svc.t_js_obt_hour_temp d,(select t.obtid || min(t.mint) as tid from pub_svc.t_js_obt_hour_temp  t where t.bj_datetime > sysdate - 1 group by t.obtid) e where d.bj_datetime > sysdate - 1 and d.obtid || d.mint = e.tid group by (d.obtid, d.mint)) f on c.station_num = f.obtid order by mint )where mint<>999999.0) else mint end)mint from (select a.station_num, a.station_name from pub_svc.weather_station a left join pub_svc.WEATHER_CITY_STATION b on a.station_num = b.station_num where b.city_id = '320111') c left join (select max(bj_datetime), obtid, mint from pub_svc.t_js_obt_hour_temp d,(select t.obtid || min(t.mint) as tid from pub_svc.t_js_obt_hour_temp  t where t.bj_datetime > sysdate - 1 group by t.obtid) e where d.bj_datetime > sysdate - 1 and d.obtid || d.mint = e.tid group by (d.obtid, d.mint)) f on c.station_num = f.obtid order by station_name";

		List<Map<String, Object>> list = jdbcT.queryForList(sql);

		String yJson = "";
		String b = "";
		String c = "";

		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < list.size(); j++) {
				Map<String, Object> vs = list.get(j);
				b = StringUtil.changeZero(vs.get("MINT"));
				c = c + b + ",";
			}
			int num = c.length();
			c = c.substring(0, num - 1);
			yJson = "[" + c + "]";
		}

		return yJson;
	}

	public String getJson3() {
		String sql = "select station_name,(case when mint=999999.0 then (select round(avg(mint),1) mint from(select station_name,mint from (select a.station_num, a.station_name from pub_svc.weather_station a left join pub_svc.WEATHER_CITY_STATION b on a.station_num = b.station_num where b.city_id = '320111') c left join (select max(bj_datetime), obtid, mint from pub_svc.t_js_obt_hour_temp d,(select t.obtid || min(t.mint) as tid from pub_svc.t_js_obt_hour_temp  t where t.bj_datetime > sysdate - 1 group by t.obtid) e where d.bj_datetime > sysdate - 1 and d.obtid || d.mint = e.tid group by (d.obtid, d.mint)) f on c.station_num = f.obtid order by mint )where mint<>999999.0) else mint end)mint from (select a.station_num, a.station_name from pub_svc.weather_station a left join pub_svc.WEATHER_CITY_STATION b on a.station_num = b.station_num where b.city_id = '320111') c left join (select max(bj_datetime), obtid, mint from pub_svc.t_js_obt_hour_temp d,(select t.obtid || min(t.mint) as tid from pub_svc.t_js_obt_hour_temp  t where t.bj_datetime > sysdate - 1 group by t.obtid) e where d.bj_datetime > sysdate - 1 and d.obtid || d.mint = e.tid group by (d.obtid, d.mint)) f on c.station_num = f.obtid order by mint";

		List<Map<String, Object>> list = jdbcT.queryForList(sql);

		String yJson = "";
		String b = "";
		String c = "";

		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < list.size(); j++) {
				Map<String, Object> vs = list.get(j);
				b = StringUtil.changeZero(vs.get("MINT"));
				c = c + b + ",";
			}
			int num = c.length();
			c = c.substring(0, num - 1);
			yJson = "[" + c + "]";
		}

		return yJson;
	}

	public String getMax() {
		String dmax = "";
		String sqlmax = "select max(mint) mint from(select station_name,mint from (select a.station_num, a.station_name from pub_svc.weather_station a left join pub_svc.WEATHER_CITY_STATION b on a.station_num = b.station_num where b.city_id = '320111') c left join (select max(bj_datetime), obtid, mint from pub_svc.t_js_obt_hour_temp d,(select t.obtid || min(t.mint) as tid from pub_svc.t_js_obt_hour_temp  t where t.bj_datetime > sysdate - 1 group by t.obtid) e where d.bj_datetime > sysdate - 1 and d.obtid || d.mint = e.tid group by (d.obtid, d.mint)) f on c.station_num = f.obtid order by mint )where mint<>999999.0";
		List<Map<String, Object>> list = jdbcT.queryForList(sqlmax);
		Map<String, Object> vsmax = list.get(0);
		dmax = StringUtil.changeZero(vsmax.get("MINT"));
		return dmax;
	}

	public String getMin() {
		String dmin = "";
		String sqlmin = "select min(mint) mint from(select station_name,mint from (select a.station_num, a.station_name from pub_svc.weather_station a left join pub_svc.WEATHER_CITY_STATION b on a.station_num = b.station_num where b.city_id = '320111') c left join (select max(bj_datetime), obtid, mint from pub_svc.t_js_obt_hour_temp d,(select t.obtid || min(t.mint) as tid from pub_svc.t_js_obt_hour_temp  t where t.bj_datetime > sysdate - 1 group by t.obtid) e where d.bj_datetime > sysdate - 1 and d.obtid || d.mint = e.tid group by (d.obtid, d.mint)) f on c.station_num = f.obtid order by mint )where mint<>999999.0";
		List<Map<String, Object>> list = jdbcT.queryForList(sqlmin);
		Map<String, Object> vsmin = list.get(0);
		dmin = StringUtil.changeZero(vsmin.get("MINT"));

		return dmin;
	}

	public String getMax1() {

		String dmax = "";
		String sqlmax = "select max(maxt) maxt  from ( select MAXT,station_name from (select a.station_num, a.station_name from pub_svc.weather_station a left join pub_svc.WEATHER_CITY_STATION b on a.station_num = b.station_num where b.city_id = '320111') c left join (select max(bj_datetime), obtid, MAXT from pub_svc.t_js_obt_hour_temp d,(select t.obtid || max(t.MAXT) as tid from pub_svc.t_js_obt_hour_temp  t where t.bj_datetime > sysdate - 1 group by t.obtid) e where d.bj_datetime > sysdate - 1 and d.obtid || d.MAXT = e.tid group by (d.obtid, d.MAXT)) f on c.station_num = f.obtid order by MAXT desc)where maxt <>999999.0";
		List<Map<String, Object>> list = jdbcT.queryForList(sqlmax);
		Map<String, Object> vsmax = list.get(0);
		dmax = StringUtil.changeZero(vsmax.get("MAXT"));
		return dmax;
	}

	public String getMin1() {
		String dmin = "";
		String sqlmin = "select min(maxt) maxt  from ( select MAXT,station_name from (select a.station_num, a.station_name from pub_svc.weather_station a left join pub_svc.WEATHER_CITY_STATION b on a.station_num = b.station_num where b.city_id = '320111') c left join (select max(bj_datetime), obtid, MAXT from pub_svc.t_js_obt_hour_temp d,(select t.obtid || max(t.MAXT) as tid from pub_svc.t_js_obt_hour_temp  t where t.bj_datetime > sysdate - 1 group by t.obtid) e where d.bj_datetime > sysdate - 1 and d.obtid || d.MAXT = e.tid group by (d.obtid, d.MAXT)) f on c.station_num = f.obtid order by MAXT desc)where maxt <>999999.0";

		List<Map<String, Object>> list = jdbcT.queryForList(sqlmin);
		Map<String, Object> vsmin = list.get(0);
		dmin = StringUtil.changeZero(vsmin.get("MAXT"));
		return dmin;
	}

	/*************************************** ·Ö¸îÏß *************************************/

	public String getJson() {
		String sql = "select station_name,(case when MAXT=999999.0 then (select round(avg(maxt),1) maxt  from ( select MAXT,station_name from (select a.station_num, a.station_name from pub_svc.weather_station a left join pub_svc.WEATHER_CITY_STATION b on a.station_num = b.station_num where b.city_id = '320111') c left join (select max(bj_datetime), obtid, MAXT from pub_svc.t_js_obt_hour_temp d,(select t.obtid || max(t.MAXT) as tid from pub_svc.t_js_obt_hour_temp  t where t.bj_datetime > sysdate - 1 group by t.obtid) e where d.bj_datetime > sysdate - 1 and d.obtid || d.MAXT = e.tid group by (d.obtid, d.MAXT)) f on c.station_num = f.obtid order by MAXT desc)where maxt <>999999.0) else MAXT end)MAXT from (select a.station_num, a.station_name from pub_svc.weather_station a left join pub_svc.WEATHER_CITY_STATION b on a.station_num = b.station_num where b.city_id = '320111') c left join (select max(bj_datetime), obtid, MAXT from pub_svc.t_js_obt_hour_temp d,(select t.obtid || max(t.MAXT) as tid from pub_svc.t_js_obt_hour_temp  t where t.bj_datetime > sysdate - 1 group by t.obtid) e where d.bj_datetime > sysdate - 1 and d.obtid || d.MAXT = e.tid group by (d.obtid, d.MAXT)) f on c.station_num = f.obtid order by MAXT desc";
		List<Map<String, Object>> list = jdbcT.queryForList(sql);
		Gson g = new Gson();
		String xJson = "";

		String b = "";
		List<String> l = new ArrayList<String>();

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j <= i; j++) {
				Map<String, Object> vs = list.get(i);
				b = vs.get("STATION_NAME").toString();
			}

			l.add(b);
		}

		xJson = g.toJson(l);
		return xJson;
	}

	public String getJsonzg() {
		String sql = "select station_name,(case when MAXT=999999.0 then (select round(avg(maxt),1) maxt  from ( select MAXT,station_name from (select a.station_num, a.station_name from pub_svc.weather_station a left join pub_svc.WEATHER_CITY_STATION b on a.station_num = b.station_num where b.city_id = '320111') c left join (select max(bj_datetime), obtid, MAXT from pub_svc.t_js_obt_hour_temp d,(select t.obtid || max(t.MAXT) as tid from pub_svc.t_js_obt_hour_temp  t where t.bj_datetime > sysdate - 1 group by t.obtid) e where d.bj_datetime > sysdate - 1 and d.obtid || d.MAXT = e.tid group by (d.obtid, d.MAXT)) f on c.station_num = f.obtid order by MAXT desc)where maxt <>999999.0) else MAXT end)MAXT from (select a.station_num, a.station_name from pub_svc.weather_station a left join pub_svc.WEATHER_CITY_STATION b on a.station_num = b.station_num where b.city_id = '320111') c left join (select max(bj_datetime), obtid, MAXT from pub_svc.t_js_obt_hour_temp d,(select t.obtid || max(t.MAXT) as tid from pub_svc.t_js_obt_hour_temp  t where t.bj_datetime > sysdate - 1 group by t.obtid) e where d.bj_datetime > sysdate - 1 and d.obtid || d.MAXT = e.tid group by (d.obtid, d.MAXT)) f on c.station_num = f.obtid order by MAXT desc";

		List<Map<String, Object>> list = jdbcT.queryForList(sql);
		String b = "";
		String l = "";

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j <= i; j++) {
				Map<String, Object> vs = list.get(i);
				b = vs.get("STATION_NAME").toString();
			}

			l += b + ",";
		}

		return l;
	}

	public String getJson1() {
		String sql = "select station_name,(case when mint=999999.0 then (select round(avg(mint),1) mint from(select station_name,mint from (select a.station_num, a.station_name from pub_svc.weather_station a left join pub_svc.WEATHER_CITY_STATION b on a.station_num = b.station_num where b.city_id = '320111') c left join (select max(bj_datetime), obtid, mint from pub_svc.t_js_obt_hour_temp d,(select t.obtid || min(t.mint) as tid from pub_svc.t_js_obt_hour_temp  t where t.bj_datetime > sysdate - 1 group by t.obtid) e where d.bj_datetime > sysdate - 1 and d.obtid || d.mint = e.tid group by (d.obtid, d.mint)) f on c.station_num = f.obtid order by mint )where mint<>999999.0) else mint end)mint from (select a.station_num, a.station_name from pub_svc.weather_station a left join pub_svc.WEATHER_CITY_STATION b on a.station_num = b.station_num where b.city_id = '320111') c left join (select max(bj_datetime), obtid, mint from pub_svc.t_js_obt_hour_temp d,(select t.obtid || min(t.mint) as tid from pub_svc.t_js_obt_hour_temp  t where t.bj_datetime > sysdate - 1 group by t.obtid) e where d.bj_datetime > sysdate - 1 and d.obtid || d.mint = e.tid group by (d.obtid, d.mint)) f on c.station_num = f.obtid order by mint";

		List<Map<String, Object>> list = jdbcT.queryForList(sql);

		Gson g = new Gson();
		String xJson = "";

		String b = "";
		List<String> l = new ArrayList<String>();

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j <= i; j++) {
				Map<String, Object> vs = list.get(i);
				b = vs.get("STATION_NAME").toString();
			}
			l.add(b);
		}

		xJson = g.toJson(l);
		return xJson;
	}

	public String getJsonzd() {
		String sql = "select station_name,(case when mint=999999.0 then (select round(avg(mint),1) mint from(select station_name,mint from (select a.station_num, a.station_name from pub_svc.weather_station a left join pub_svc.WEATHER_CITY_STATION b on a.station_num = b.station_num where b.city_id = '320111') c left join (select max(bj_datetime), obtid, mint from pub_svc.t_js_obt_hour_temp d,(select t.obtid || min(t.mint) as tid from pub_svc.t_js_obt_hour_temp  t where t.bj_datetime > sysdate - 1 group by t.obtid) e where d.bj_datetime > sysdate - 1 and d.obtid || d.mint = e.tid group by (d.obtid, d.mint)) f on c.station_num = f.obtid order by mint )where mint<>999999.0) else mint end)mint from (select a.station_num, a.station_name from pub_svc.weather_station a left join pub_svc.WEATHER_CITY_STATION b on a.station_num = b.station_num where b.city_id = '320111') c left join (select max(bj_datetime), obtid, mint from pub_svc.t_js_obt_hour_temp d,(select t.obtid || min(t.mint) as tid from pub_svc.t_js_obt_hour_temp  t where t.bj_datetime > sysdate - 1 group by t.obtid) e where d.bj_datetime > sysdate - 1 and d.obtid || d.mint = e.tid group by (d.obtid, d.mint)) f on c.station_num = f.obtid order by mint";

		List<Map<String, Object>> list = jdbcT.queryForList(sql);

		String b = "";
		String l = "";

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j <= i; j++) {
				Map<String, Object> vs = list.get(i);
				b = vs.get("STATION_NAME").toString();
			}

			l += b + ",";
		}
		return l;
	}

	public String getStationJson() {
		String sql = "select station_name,(case when mint=999999.0 then (select round(avg(mint),1) mint from(select station_name,mint from (select a.station_num, a.station_name from pub_svc.weather_station a left join pub_svc.WEATHER_CITY_STATION b on a.station_num = b.station_num where b.city_id = '320111') c left join (select max(bj_datetime), obtid, mint from pub_svc.t_js_obt_hour_temp d,(select t.obtid || min(t.mint) as tid from pub_svc.t_js_obt_hour_temp  t where t.bj_datetime > sysdate - 1 group by t.obtid) e where d.bj_datetime > sysdate - 1 and d.obtid || d.mint = e.tid group by (d.obtid, d.mint)) f on c.station_num = f.obtid order by mint )where mint<>999999.0) else mint end)mint from (select a.station_num, a.station_name from pub_svc.weather_station a left join pub_svc.WEATHER_CITY_STATION b on a.station_num = b.station_num where b.city_id = '320111') c left join (select max(bj_datetime), obtid, mint from pub_svc.t_js_obt_hour_temp d,(select t.obtid || min(t.mint) as tid from pub_svc.t_js_obt_hour_temp  t where t.bj_datetime > sysdate - 1 group by t.obtid) e where d.bj_datetime > sysdate - 1 and d.obtid || d.mint = e.tid group by (d.obtid, d.mint)) f on c.station_num = f.obtid order by station_name";

		List<Map<String, Object>> list = jdbcT.queryForList(sql);
		Gson g = new Gson();
		String xJson = "";
		String b = "";
		List<String> l = new ArrayList<String>();

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j <= i; j++) {
				Map<String, Object> vs = list.get(i);
				b = vs.get("STATION_NAME").toString();
			}

			l.add(b);
		}

		xJson = g.toJson(l);
		return xJson;
	}
}
