package cn.com.oking.waterdata;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import cn.com.oking.util.StringUtil;

@Component
public class GetPkyl {
	@Resource(name = "jdbcPub_svc")
	private JdbcTemplate jdbcT;

	/**
	 * 一小时、三小时、六小时、十二小时、二十四小时累计降雨量
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getJysxt() {
		String sql = "select * from pub_svc.hla_pkylpxt order by hour24r desc";

		List<Map<String, Object>> list = jdbcT.queryForList(sql);

		return list;
	}

	/**
	 * 获取逐三小时降雨量
	 * 
	 * @param obtid
	 *            站点号
	 * @param time
	 *            结束时间
	 * @return
	 * @throws Exception
	 */
	public Map<String, List<?>> getHourRain(String obtid, String time,
			String interval) throws Exception {
		List<String> list = getHour(time, interval);
		String sj = "";
		double pkyl = 0.0D;
		List<Double> l = new ArrayList<Double>();
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j <= 1; j++) {
				sj = (String) list.get(i);

				pkyl = getHourOneRain(obtid, sj, time).doubleValue();
			}
			l.add(Double.valueOf(pkyl));
		}

		Map<String, List<?>> map = new HashMap<String, List<?>>();
		map.put("time", list);
		map.put("data", l);

		return map;
	}

	/**
	 * 
	 * @param obtid
	 *            站点号
	 * @param interval
	 *            二十四小时制的小时数
	 * @param time
	 *            时间，格式为：yyyy-mm-dd 24hh:mm:ss
	 * @return
	 * @throws Exception
	 */
	public Double getHourOneRain(String obtid, String sj, String time)
			throws Exception {
		String sql = "select * from (select sj, (case when hourr>999 then 0 else hourr end)hourr,(case when hour1r>999 then 0 else hour1r end)hour1r,hour3r from(select t.bj_datetime,to_char(t.bj_datetime,'HH24') sj,t.obtid,t.hourr,t.hour1r,(hour3r-hourr) as hour3r,t.hour24r,t.R202N,t.R52N from pub_svc.t_Js_Obt_Hour_rain  t where t.obtid='"
				+ obtid
				+ "'and to_date('"
				+ time
				+ "','yyyy-mm-dd hh24:mi:ss')-t.bj_datetime>=0  order by t.bj_datetime desc)c where rownum<=24 order by c.bj_datetime desc) where sj="
				+ sj + "";

		List<Map<String, Object>> list = jdbcT.queryForList(sql);
		if (list.size() <= 0) {
			String sql2 = "select *from (select sj, (case when hourr>999 then 0 else hourr end)hourr,(case when hour1r>999 then 0 else hour1r end)hour1r  from(select t.bj_datetime,to_char(t.bj_datetime,'HH24') sj,t.obtid,t.hourr,t.hour1r,t.hour24r,t.R202N,t.R52N from pub_svc.t_Js_Obt_Hour_rain  t where t.obtid='"
					+ obtid
					+ "' order by t.bj_datetime desc)c where rownum<=24 order by c.bj_datetime)where sj="
					+ sj + "";

			list = jdbcT.queryForList(sql2);
		}

		double b = 0.0D;
		if ((list != null) && (list.size() != 0)) {
			Map<String, Object> map = list.get(0);
			String bb = map.get("hour3r").toString();
			if (!StringUtil.isNotEmpty(bb)) {
				b = 0.0D;
			}
		} else {
			b = 0.0D;
		}
		return Double.valueOf(b);
	}

	/**
	 * 获取x轴时间
	 * 
	 * @param time
	 * @return
	 * @throws Exception
	 */
	public List<String> getHour(String time, String internal) throws Exception {

		List<String> ll = new ArrayList<String>();

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		date = dateFormat.parse(time);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int _internal = Integer.parseInt(internal);
		int temp = hour;

		do {
			temp += _internal;
			if (temp >= 24) {
				temp -= 24;
			}
			ll.add(temp + "");
		} while (temp != hour);


		return ll;
	}
}
