package cn.com.oking.waterdata;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import cn.com.oking.util.StringUtil;

import com.google.gson.Gson;

@Component
public class GetPkwdSx {
	@Resource(name = "jdbcPub_svc")
	private JdbcTemplate jdbcT;

	public Double getJson1(String id, String sj) {
		String sql = "select *from  (select  sj,(case when t>999 then 0 else t end)t   from(select t.bj_datetime,to_char(t.bj_datetime,'HH24') sj,t.obtid,t.t from pub_svc.t_Js_Obt_Hour_Temp  t where t.obtid='"
				+ id
				+ "'and sysdate-t.bj_datetime<=1 order by t.bj_datetime desc)c where rownum<=24 order by c.bj_datetime) where sj="
				+ sj + " ";
		List<Map<String, Object>> list = jdbcT.queryForList(sql);
		double b = 0.0D;
		String c = "";
		if ((list != null) && (list.size() != 0)) {
			Map<String, Object> map = list.get(0);
			b = Double.parseDouble(StringUtil.changeZero(map.get("t")));
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

	public String getJson2(String id) {
		String sql = "select round(avg(t), 0)temp from  (select  sj,(case when t>999 then 0 else t end)t   from(select t.bj_datetime,to_char(t.bj_datetime,'HH24') sj,t.obtid,t.t from pub_svc.t_Js_Obt_Hour_Temp  t where t.obtid='"
				+ id
				+ "'and sysdate-t.bj_datetime<=1 order by t.bj_datetime desc)c where rownum<=24 order by c.bj_datetime)";

		List<Map<String, Object>> hla = jdbcT.queryForList(sql);
		Map<String, Object> map = hla.get(0);
		double wd = Double.parseDouble(StringUtil.changeZero(map.get("temp")));

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String time = sdf.format(date);
		List<String> list = new ArrayList<String>();
		try {
			list = pkyl_lookx.getHour(time, 1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String sj = "";
		double temp = 0.0D;
		List<Double> l = new ArrayList<Double>();
		for (int i = 0; i < 24; i++) {
			for (int j = 0; j <= 1; j++) {
				sj = (String) list.get(i);

				temp = getJson1(id, sj).doubleValue();
				if ((temp == 0.0D) || (temp == 0.0D)) {
					temp = wd;
				}
			}
			l.add(Double.valueOf(temp));
		}
		Gson g = new Gson();
		String aa = g.toJson(l);

		return aa;
	}

	public String getMax(String id) {
		String maxnum = "";
		String sqlmax = "select max(t) t  from(select t.bj_datetime,to_char(t.bj_datetime,'HH24') sj,t.obtid,t.t from pub_svc.t_Js_Obt_Hour_Temp  t where t<999 and t.obtid='"
				+ id
				+ "'and sysdate-t.bj_datetime<=1 order by t.bj_datetime desc)c where rownum<=24 order by c.bj_datetime";
		List<Map<String, Object>> listmax = jdbcT.queryForList(sqlmax);
		Map<String, Object> map = listmax.get(0);
		maxnum = StringUtil.changeZero(map.get("t"));
		return maxnum;
	}

	public String getMin(String id) {
		String minnum = "";
		String sqlmin = "select min(t) t  from(select t.bj_datetime,to_char(t.bj_datetime,'HH24') sj,t.obtid,t.t from pub_svc.t_Js_Obt_Hour_Temp  t where t<999 and t.obtid='"
				+ id
				+ "'and sysdate-t.bj_datetime<=1 order by t.bj_datetime desc)c where rownum<=24 order by c.bj_datetime";
		List<Map<String, Object>> listmin = jdbcT.queryForList(sqlmin);
		Map<String, Object> map = listmin.get(0);
		minnum = StringUtil.changeZero(map.get("t"));

		return minnum;
	}
}
