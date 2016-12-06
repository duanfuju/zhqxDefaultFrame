package cn.com.oking.waterdata;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class GetPkfsSx {
	@Resource(name = "jdbcPub_svc")
	private JdbcTemplate jdbcT;

	public double getJson1(String id, String sj) {
		String sql = "select * from (select sj, (case when wd10df>999 then 0 else wd10df end)wd10df  from(select t.bj_datetime,to_char(t.bj_datetime,'HH24') sj,t.obtid,t.WD10DF  from pub_svc.t_Js_Obt_Hour_wind  t where t.obtid='"
				+ id
				+ "'and sysdate-t.bj_datetime<=1 order by t.bj_datetime desc)c where rownum<=24 order by c.bj_datetime) where sj="
				+ sj + " ";
		List<Map<String, Object>> list = jdbcT.queryForList(sql);
		if (list.size() <= 0) {
			String sql2 = "select *from  (select  sj, (case when wd10df>999 then 0 else wd10df end)wd10df  from(select t.bj_datetime,to_char(t.bj_datetime,'HH24') sj,t.obtid,t.WD10DF  from pub_svc.t_Js_Obt_Hour_wind  t where t.obtid='"
					+ id
					+ "' order by t.bj_datetime desc)c where rownum<=24 order by c.bj_datetime) where sj="
					+ sj + " ";
			list = jdbcT.queryForList(sql2);
		}

		double b = 0.0D;
		if ((list != null) && (list.size() != 0)) {
			Map<String, Object> vs = list.get(0);
			String bb = vs.get("wd10df").toString();

			if ((bb.equals("")) || (bb == null)) {
				b = 0.0D;
			} else {
				b = Double.parseDouble(bb);
			}
		} else {
			b = 0.0D;
		}
		return b;
	}

	public String getJson2(String id) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String time = sdf.format(date);
		List<String> list = new ArrayList<String>();
		try {
			list = pkyl_lookx.getHour(time, 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String sj = "";
		double temp = 0.0D;
		List<String> l = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			sj = list.get(i);
			temp = getJson1(id, sj);
			l.add(String.valueOf(temp));
		}

		return l.toString();
	}

	public String getMax(String id) {
		String maxnum = "";
		String sqlmax = "select max(wd10df) wd10df  from(select  (case when wd10df>999 then 0 else wd10df end)wd10df  from(select t.bj_datetime,to_char(t.bj_datetime,'HH24') sj,t.obtid,t.WD10DF  from pub_svc.t_Js_Obt_Hour_wind  t where t.obtid='"
				+ id
				+ "'and sysdate-t.bj_datetime<=1 order by t.bj_datetime desc)c where rownum<=24 order by c.bj_datetime)";
		List<Map<String, Object>> listmax = jdbcT.queryForList(sqlmax);
		Map<String, Object> vsmax = listmax.get(0);
		maxnum = vsmax.get("wd10df").toString();
		return maxnum;
	}

	public String getMin(String id) {
		String minnum = "";
		String sqlmin = "select min(wd10df) wd10df  from(select  (case when wd10df>999 then 0 else wd10df end)wd10df  from(select t.bj_datetime,to_char(t.bj_datetime,'HH24') sj,t.obtid,t.WD10DF  from pub_svc.t_Js_Obt_Hour_wind  t where t.obtid='"
				+ id
				+ "'and sysdate-t.bj_datetime<=1 order by t.bj_datetime desc)c where rownum<=24 order by c.bj_datetime)";
		List<Map<String, Object>> listmin = jdbcT.queryForList(sqlmin);
		Map<String, Object> vsmin = listmin.get(0);
		minnum = vsmin.get("wd10df").toString();
		return minnum;
	}
}