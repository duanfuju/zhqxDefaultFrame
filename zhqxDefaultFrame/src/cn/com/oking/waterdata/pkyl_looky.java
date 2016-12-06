package cn.com.oking.waterdata;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class pkyl_looky {
	@Resource(name = "jdbcPub_svc")
	private JdbcTemplate jdbcT;

	public Double getJson1hour1(String id, String sj, String time)
			throws Exception {
		String sql = "select * from (select sj, (case when hourr>999 then 0 else hourr end)hourr,(case when hour1r>999 then 0 else hour1r end)hour1r from(select t.bj_datetime,to_char(t.bj_datetime,'HH24') sj,t.obtid,t.hourr,t.hour1r,t.hour24r,t.R202N,t.R52N from pub_svc.t_Js_Obt_Hour_rain  t where t.obtid='"
				+ id
				+ "'and to_date('"
				+ time
				+ "','yyyy-mm-dd hh24:mi:ss')-t.bj_datetime>=0  order by t.bj_datetime desc)c where rownum<=24 order by c.bj_datetime desc) where sj="
				+ sj + " ";

		List<Map<String, Object>> list = jdbcT.queryForList(sql);
		if (list.size() <= 0) {
			String sql2 = "select *from (select sj, (case when hourr>999 then 0 else hourr end)hourr,(case when hour1r>999 then 0 else hour1r end)hour1r  from(select t.bj_datetime,to_char(t.bj_datetime,'HH24') sj,t.obtid,t.hourr,t.hour1r,t.hour24r,t.R202N,t.R52N from pub_svc.t_Js_Obt_Hour_rain  t where t.obtid='"
					+ id
					+ "' order by t.bj_datetime desc)c where rownum<=24 order by c.bj_datetime)where sj="
					+ sj + " ";

			list = jdbcT.queryForList(sql2);
		}
		double b = 0.0D;
		String c = "";
		if ((list != null) && (list.size() != 0)) {
			Map<String, Object> vs = list.get(0);
			b = Double.parseDouble(vs.get("hour1r").toString());
			String bb = String.valueOf(b);
			if ((bb.equals("")) || (bb == null)) {
				b = 0.0D;
			}
			c = c + String.valueOf(b);
		} else {
			b = 0.0D;
		}
		return Double.valueOf(b);
	}

	public String getJson1hour2(String id, String time) throws Exception {
		List<String> list = pkyl_lookx.getHour(time, 1);

		String sj = "";
		double pkyl = 0.0D;
		List<Double> l = new ArrayList<Double>();
		for (int i = 0; i < 24; i++) {
			for (int j = 0; j <= 1; j++) {
				sj = (String) list.get(i);

				pkyl = getJson1hour1(id, sj, time).doubleValue();
			}
			l.add(Double.valueOf(pkyl));
		}
		Gson g = new Gson();
		String aa = g.toJson(l);

		return aa;
	}

	public String getMax1hour(String id, String time) throws Exception {
		String maxnum = "";
		String sqlmax = "select max(hour1r) as maxnum from (select sj, (case when hourr>999 then 0 else hourr end)hourr,(case when hour1r>999 then 0 else hour1r end)hour1r from(select t.bj_datetime,to_char(t.bj_datetime,'HH24') sj,t.obtid,t.hourr,t.hour1r,t.hour24r,t.R202N,t.R52N from pub_svc.t_Js_Obt_Hour_rain  t where t.obtid='"
				+ id
				+ "'and to_date('"
				+ time
				+ "','yyyy-mm-dd hh24:mi:ss')-t.bj_datetime>=0  order by t.bj_datetime desc)c where rownum<=24 order by c.bj_datetime)  ";

		List<Map<String, Object>> listmax = jdbcT.queryForList(sqlmax);
		Map<String, Object> vsmax = listmax.get(0);
		maxnum = vsmax.get("maxnum").toString();
		return maxnum;
	}

	public Double getJson3hour1(String id, String sj, String time)
			throws Exception {
		String sql = "select * from (select sj, (case when hourr>999 then 0 else hourr end)hourr,(case when hour1r>999 then 0 else hour1r end)hour1r,hour3r from(select t.bj_datetime,to_char(t.bj_datetime,'HH24') sj,t.obtid,t.hourr,t.hour1r,(hour3r-hourr) as hour3r,t.hour24r,t.R202N,t.R52N from pub_svc.t_Js_Obt_Hour_rain  t where t.obtid='"
				+ id
				+ "'and to_date('"
				+ time
				+ "','yyyy-mm-dd hh24:mi:ss')-t.bj_datetime>=0  order by t.bj_datetime desc)c where rownum<=24 order by c.bj_datetime desc) where sj="
				+ sj + " ";

		List<Map<String, Object>> list = jdbcT.queryForList(sql);
		if (list.size() <= 0) {
			String sql2 = "select *from (select sj, (case when hourr>999 then 0 else hourr end)hourr,(case when hour1r>999 then 0 else hour1r end)hour1r  from(select t.bj_datetime,to_char(t.bj_datetime,'HH24') sj,t.obtid,t.hourr,t.hour1r,t.hour24r,t.R202N,t.R52N from pub_svc.t_Js_Obt_Hour_rain  t where t.obtid='"
					+ id
					+ "' order by t.bj_datetime desc)c where rownum<=24 order by c.bj_datetime)where sj="
					+ sj + " ";

			list = jdbcT.queryForList(sql2);
		}

		double b = 0.0D;
		String c = "";
		if ((list != null) && (list.size() != 0)) {
			Map<String, Object> vs = list.get(0);
			b = Double.parseDouble(vs.get("hour3r").toString());
			String bb = String.valueOf(b);
			if ((bb.equals("")) || (bb == null)) {
				b = 0.0D;
			}
			c = c + String.valueOf(b);
		} else {
			b = 0.0D;
		}
		return Double.valueOf(b);
	}

	public String getJson3hour2(String id, String time) throws Exception {
		List<String> list = pkyl_lookx.getHour(time, 3);

		String sj = "";
		double pkyl = 0.0D;
		List<Double> l = new ArrayList<Double>();
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j <= 1; j++) {
				sj = (String) list.get(i);

				pkyl = getJson3hour1(id, sj, time).doubleValue();
			}
			l.add(Double.valueOf(pkyl));
		}
		Gson g = new Gson();
		String aa = g.toJson(l);

		return aa;
	}

	public String getMax3hour(String id, String time) throws Exception {
		String maxnum = "";

		String sqlmax = "select max(hour3r) as maxnum from (select sj, (case when hourr>999 then 0 else hourr end)hourr,(case when hour1r>999 then 0 else hour1r end)hour1r,hour3r from(select t.bj_datetime,to_char(t.bj_datetime,'HH24') sj,t.obtid,t.hourr,t.hour1r,(hour3r-hourr) as hour3r,t.hour24r,t.R202N,t.R52N from pub_svc.t_Js_Obt_Hour_rain  t where t.obtid='"
				+ id
				+ "'and to_date('"
				+ time
				+ "','yyyy-mm-dd hh24:mi:ss')-t.bj_datetime>=0  order by t.bj_datetime desc)c where rownum<=24 order by c.bj_datetime) ";

		List<Map<String, Object>> listmax = jdbcT.queryForList(sqlmax);
		Map<String, Object> vsmax = listmax.get(0);
		maxnum = vsmax.get("maxnum").toString();

		return maxnum;
	}

	public Double getJson6hour1(String id, String sj, String time)
			throws Exception {
		String sql = "select * from (select sj, (case when hourr>999 then 0 else hourr end)hourr,(case when hour1r>999 then 0 else hour1r end)hour1r,hour3r,hour6r from(select t.bj_datetime,to_char(t.bj_datetime,'HH24') sj,t.obtid,t.hourr,t.hour1r,t.hour3r,(hour6r-hourr) as hour6r,t.hour24r,t.R202N,t.R52N from pub_svc.t_Js_Obt_Hour_rain  t where t.obtid='"
				+ id
				+ "'and to_date('"
				+ time
				+ "','yyyy-mm-dd hh24:mi:ss')-t.bj_datetime>=0  order by t.bj_datetime desc)c where rownum<=24 order by c.bj_datetime desc) where sj="
				+ sj + " ";

		List<Map<String, Object>> list = jdbcT.queryForList(sql);
		if (list.size() <= 0) {
			String sql2 = "select *from (select sj, (case when hourr>999 then 0 else hourr end)hourr,(case when hour1r>999 then 0 else hour1r end)hour1r  from(select t.bj_datetime,to_char(t.bj_datetime,'HH24') sj,t.obtid,t.hourr,t.hour1r,t.hour24r,t.R202N,t.R52N from pub_svc.t_Js_Obt_Hour_rain  t where t.obtid='"
					+ id
					+ "' order by t.bj_datetime desc)c where rownum<=24 order by c.bj_datetime)where sj="
					+ sj + " ";

			list = jdbcT.queryForList(sql2);
		}

		double b = 0.0D;
		String c = "";
		if ((list != null) && (list.size() != 0)) {
			Map<String, Object> vs = list.get(0);
			b = Double.parseDouble(vs.get("hour6r").toString());
			String bb = String.valueOf(b);
			if ((bb.equals("")) || (bb == null)) {
				b = 0.0D;
			}
			c = c + String.valueOf(b);
		} else {
			b = 0.0D;
		}
		return Double.valueOf(b);
	}

	public String getJson6hour2(String id, String time) throws Exception {
		List<String> list = pkyl_lookx.getHour(time, 6);

		String sj = "";
		double pkyl = 0.0D;
		List<Double> l = new ArrayList<Double>();
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j <= 1; j++) {
				sj = (String) list.get(i);

				pkyl = getJson6hour1(id, sj, time).doubleValue();
			}
			l.add(Double.valueOf(pkyl));
		}
		Gson g = new Gson();
		String aa = g.toJson(l);

		return aa;
	}

	public String getMax6hour(String id, String time) throws Exception {
		String maxnum = "";

		String sqlmax = "select max(hour6r) as maxnum from (select sj, (case when hourr>999 then 0 else hourr end)hourr,(case when hour1r>999 then 0 else hour1r end)hour1r,hour3r,hour6r from(select t.bj_datetime,to_char(t.bj_datetime,'HH24') sj,t.obtid,t.hourr,t.hour1r,t.hour3r,(hour6r-hourr) as hour6r,t.hour24r,t.R202N,t.R52N from pub_svc.t_Js_Obt_Hour_rain  t where t.obtid='"
				+ id
				+ "'and to_date('"
				+ time
				+ "','yyyy-mm-dd hh24:mi:ss')-t.bj_datetime>=0  order by t.bj_datetime desc)c where rownum<=24 order by c.bj_datetime)  ";

		List<Map<String, Object>> listmax = jdbcT.queryForList(sqlmax);
		Map<String, Object> vsmax = listmax.get(0);
		maxnum = vsmax.get("maxnum").toString();

		return maxnum;
	}

	public String getMax12hour(String id, String time) throws Exception {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		date = dateFormat.parse(time);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		String hour1 = String.valueOf(hour);
		String hour2 = "";
		if (hour1.equals("00")) {
			hour1 = "0";
			hour2 = "12";
		}
		if (hour1.equals("01")) {
			hour1 = "1";
			hour2 = "13";
		}
		if (hour1.equals("02")) {
			hour1 = "2";
			hour2 = "14";
		}
		if (hour1.equals("03")) {
			hour1 = "3";
			hour2 = "15";
		}
		if (hour1.equals("04")) {
			hour1 = "4";
			hour2 = "16";
		}
		if (hour1.equals("05")) {
			hour1 = "5";
			hour2 = "17";
		}
		if (hour1.equals("06")) {
			hour1 = "6";
			hour2 = "18";
		}
		if (hour1.equals("07")) {
			hour1 = "7";
			hour2 = "19";
		}
		if (hour1.equals("08")) {
			hour1 = "8";
			hour2 = "20";
		}
		if (hour1.equals("09")) {
			hour1 = "9";
			hour2 = "21";
		}
		if (hour1.equals("10")) {
			hour2 = "22";
		}
		if (hour1.equals("11")) {
			hour2 = "23";
		}
		if (hour1.equals("12")) {
			hour2 = "0";
		}
		if (hour1.equals("13")) {
			hour2 = "1";
		}
		if (hour1.equals("14")) {
			hour2 = "2";
		}
		if (hour1.equals("15")) {
			hour2 = "3";
		}
		if (hour1.equals("16")) {
			hour2 = "4";
		}
		if (hour1.equals("17")) {
			hour2 = "5";
		}
		if (hour1.equals("18")) {
			hour2 = "6";
		}
		if (hour1.equals("19")) {
			hour2 = "7";
		}
		if (hour1.equals("20")) {
			hour2 = "8";
		}
		if (hour1.equals("21")) {
			hour2 = "9";
		}
		if (hour1.equals("22")) {
			hour2 = "10";
		}
		if (hour1.equals("23")) {
			hour2 = "11";
		}
		String sql = "select max(hour12r) maxnum from (select hour12r from (select hour12r,bj_datetime,hour from (select  hour12r,bj_datetime,hour from (select (hour12r-hourr) as hour12r,bj_datetime ,hour from pub_svc.t_Js_Obt_Hour_rain t where obtid='"
				+ id
				+ "' and  bj_datetime<=to_date('"
				+ time
				+ "','yyyy-mm-dd hh24:mi:ss')  order by t.bj_datetime desc) where hour='"
				+ hour1
				+ "' or hour='"
				+ hour2
				+ "' )where rownum<=6) order by bj_datetime asc)";

		String maxnum = "";

		List<Map<String, Object>> listmax = jdbcT.queryForList(sql);
		Map<String, Object> vsmax = listmax.get(0);
		maxnum = vsmax.get("maxnum").toString();

		return maxnum;
	}

	public String getMax24hour(String id, String time) throws Exception {
		String maxnum = "";
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		date = dateFormat.parse(time);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		String hour1 = String.valueOf(hour);
		String hour2 = "";
		if (hour1.equals("00")) {
			hour1 = "0";
			hour2 = "12";
		}
		if (hour1.equals("01")) {
			hour1 = "1";
			hour2 = "13";
		}
		if (hour1.equals("02")) {
			hour1 = "2";
			hour2 = "14";
		}
		if (hour1.equals("03")) {
			hour1 = "3";
			hour2 = "15";
		}
		if (hour1.equals("04")) {
			hour1 = "4";
			hour2 = "16";
		}
		if (hour1.equals("05")) {
			hour1 = "5";
			hour2 = "17";
		}
		if (hour1.equals("06")) {
			hour1 = "6";
			hour2 = "18";
		}
		if (hour1.equals("07")) {
			hour1 = "7";
			hour2 = "19";
		}
		if (hour1.equals("08")) {
			hour1 = "8";
			hour2 = "20";
		}
		if (hour1.equals("09")) {
			hour1 = "9";
			hour2 = "21";
		}
		if (hour1.equals("10")) {
			hour2 = "22";
		}
		if (hour1.equals("11")) {
			hour2 = "23";
		}
		if (hour1.equals("12")) {
			hour2 = "0";
		}
		if (hour1.equals("13")) {
			hour2 = "1";
		}
		if (hour1.equals("14")) {
			hour2 = "2";
		}
		if (hour1.equals("15")) {
			hour2 = "3";
		}
		if (hour1.equals("16")) {
			hour2 = "4";
		}
		if (hour1.equals("17")) {
			hour2 = "5";
		}
		if (hour1.equals("18")) {
			hour2 = "6";
		}
		if (hour1.equals("19")) {
			hour2 = "7";
		}
		if (hour1.equals("20")) {
			hour2 = "8";
		}
		if (hour1.equals("21")) {
			hour2 = "9";
		}
		if (hour1.equals("22")) {
			hour2 = "10";
		}
		if (hour1.equals("23")) {
			hour2 = "11";
		}
		String sqlmax = "select max(hour24r) maxnum from (select   bj_datetime,(hour24r-hourr)as hour24r  from pub_svc.t_Js_Obt_Hour_rain t where obtid='"
				+ id
				+ "' and  bj_datetime<=to_date('"
				+ time
				+ "','yyyy-mm-dd hh24:mi:ss') and hour='"
				+ hour1
				+ "' order by t.bj_datetime desc ) where  rownum<=5  order by bj_datetime asc";

		List<Map<String, Object>> listmax = jdbcT.queryForList(sqlmax);
		Map<String, Object> vsmax = listmax.get(0);
		maxnum = vsmax.get("maxnum").toString();
		return maxnum;
	}

	public String getJson12hour(String id, String time) throws Exception {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		date = dateFormat.parse(time);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		String hour1 = String.valueOf(hour);
		String hour2 = "";
		if (hour1.equals("00")) {
			hour1 = "0";
			hour2 = "12";
		}
		if (hour1.equals("01")) {
			hour1 = "1";
			hour2 = "13";
		}
		if (hour1.equals("02")) {
			hour1 = "2";
			hour2 = "14";
		}
		if (hour1.equals("03")) {
			hour1 = "3";
			hour2 = "15";
		}
		if (hour1.equals("04")) {
			hour1 = "4";
			hour2 = "16";
		}
		if (hour1.equals("05")) {
			hour1 = "5";
			hour2 = "17";
		}
		if (hour1.equals("06")) {
			hour1 = "6";
			hour2 = "18";
		}
		if (hour1.equals("07")) {
			hour1 = "7";
			hour2 = "19";
		}
		if (hour1.equals("08")) {
			hour1 = "8";
			hour2 = "20";
		}
		if (hour1.equals("09")) {
			hour1 = "9";
			hour2 = "21";
		}
		if (hour1.equals("10")) {
			hour2 = "22";
		}
		if (hour1.equals("11")) {
			hour2 = "23";
		}
		if (hour1.equals("12")) {
			hour2 = "0";
		}
		if (hour1.equals("13")) {
			hour2 = "1";
		}
		if (hour1.equals("14")) {
			hour2 = "2";
		}
		if (hour1.equals("15")) {
			hour2 = "3";
		}
		if (hour1.equals("16")) {
			hour2 = "4";
		}
		if (hour1.equals("17")) {
			hour2 = "5";
		}
		if (hour1.equals("18")) {
			hour2 = "6";
		}
		if (hour1.equals("19")) {
			hour2 = "7";
		}
		if (hour1.equals("20")) {
			hour2 = "8";
		}
		if (hour1.equals("21")) {
			hour2 = "9";
		}
		if (hour1.equals("22")) {
			hour2 = "10";
		}
		if (hour1.equals("23")) {
			hour2 = "11";
		}
		String sql = "select hour12r from (select hour12r,bj_datetime,hour from (select  hour12r,bj_datetime,hour from (select (hour12r-hourr) as hour12r,bj_datetime ,hour from pub_svc.t_Js_Obt_Hour_rain t where obtid='"
				+ id
				+ "' and  bj_datetime<=to_date('"
				+ time
				+ "','yyyy-mm-dd hh24:mi:ss')  order by t.bj_datetime desc) where hour='"
				+ hour1
				+ "' or hour='"
				+ hour2
				+ "' )where rownum<=6) order by bj_datetime asc";

		List<Map<String, Object>> list = jdbcT.queryForList(sql);

		String yJson = "";
		double b = 0.0D;
		String c = "";

		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < list.size(); j++) {
				Map<String, Object> vs = list.get(j);
				b = Double.parseDouble(vs.get("hour12r").toString());
				c = c + String.valueOf(b) + ",";
			}
			int num = c.length();
			c = c.substring(0, num - 1);
			yJson = "[" + c + "]";
		}

		return yJson;
	}

	public String getJson24hour(String id, String time) throws Exception {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		date = dateFormat.parse(time);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		String hour1 = String.valueOf(hour);
		String hour2 = "";
		if (hour1.equals("00")) {
			hour1 = "0";
			hour2 = "12";
		}
		if (hour1.equals("01")) {
			hour1 = "1";
			hour2 = "13";
		}
		if (hour1.equals("02")) {
			hour1 = "2";
			hour2 = "14";
		}
		if (hour1.equals("03")) {
			hour1 = "3";
			hour2 = "15";
		}
		if (hour1.equals("04")) {
			hour1 = "4";
			hour2 = "16";
		}
		if (hour1.equals("05")) {
			hour1 = "5";
			hour2 = "17";
		}
		if (hour1.equals("06")) {
			hour1 = "6";
			hour2 = "18";
		}
		if (hour1.equals("07")) {
			hour1 = "7";
			hour2 = "19";
		}
		if (hour1.equals("08")) {
			hour1 = "8";
			hour2 = "20";
		}
		if (hour1.equals("09")) {
			hour1 = "9";
			hour2 = "21";
		}
		if (hour1.equals("10")) {
			hour2 = "22";
		}
		if (hour1.equals("11")) {
			hour2 = "23";
		}
		if (hour1.equals("12")) {
			hour2 = "0";
		}
		if (hour1.equals("13")) {
			hour2 = "1";
		}
		if (hour1.equals("14")) {
			hour2 = "2";
		}
		if (hour1.equals("15")) {
			hour2 = "3";
		}
		if (hour1.equals("16")) {
			hour2 = "4";
		}
		if (hour1.equals("17")) {
			hour2 = "5";
		}
		if (hour1.equals("18")) {
			hour2 = "6";
		}
		if (hour1.equals("19")) {
			hour2 = "7";
		}
		if (hour1.equals("20")) {
			hour2 = "8";
		}
		if (hour1.equals("21")) {
			hour2 = "9";
		}
		if (hour1.equals("22")) {
			hour2 = "10";
		}
		if (hour1.equals("23")) {
			hour2 = "11";
		}
		String sql = "select * from (select   bj_datetime,(hour24r-hourr)as hour24r  from pub_svc.t_Js_Obt_Hour_rain t where obtid='"
				+ id
				+ "' and  bj_datetime<=to_date('"
				+ time
				+ "','yyyy-mm-dd hh24:mi:ss') and hour='"
				+ hour1
				+ "' order by t.bj_datetime desc ) where  rownum<=5  order by bj_datetime asc";

		List<Map<String, Object>> list = jdbcT.queryForList(sql);
		String yJson = "";
		double b = 0.0D;
		String c = "";

		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < list.size(); j++) {
				Map<String, Object> vs = list.get(j);
				b = Double.parseDouble(vs.get("hour24r").toString());
				c = c + String.valueOf(b) + ",";
			}
			int num = c.length();
			c = c.substring(0, num - 1);
			yJson = "[" + c + "]";
		}

		return yJson;
	}
}