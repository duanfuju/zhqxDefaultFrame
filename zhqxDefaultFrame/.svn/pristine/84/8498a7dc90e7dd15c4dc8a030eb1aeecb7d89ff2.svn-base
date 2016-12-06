package cn.com.oking.waterdata;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import cn.com.oking.util.StringUtil;
/**
 * @author sglei
 * @date 2016-1-13
 */
@Component
public class GetChsw {
	@Resource(name = "jdbcPub_svc")
	private JdbcTemplate jdbcT;

	public String getmax(String name) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d1 = new Date();
		long zt = d1.getTime() - 82800000L;
		long lt = d1.getTime();
		String ztime = sdf.format(new Date(zt)).substring(0, 16);
		String time = sdf.format(new Date(lt)).substring(0, 16);
		String sql = "select  max(sw) sw from (select distinct* from (select sw, to_char(time,'hh24')as sj,time from pub_svc.pub_dep_sl_ccsw where  name = '"
				+ name
				+ "' and time in\n"
				+ "(\n"
				+ "select min(time) from pub_svc.pub_dep_sl_ccsw where name = '"
				+ name
				+ "'\n"
				+ "and time >=to_date('"
				+ ztime
				+ "','yyyy-mm-dd hh24:mi') and time <to_date('"
				+ time
				+ "','yyyy-mm-dd hh24:mi')\n"
				+ "group by to_char(time,'hh24'))\n"
				+ "order by to_char(time,'hh24') ) order by time asc)";

		List<Map<String, Object>> list = jdbcT.queryForList(sql);
		Map<String, Object> vs = list.get(0);
		String str = StringUtil.changeZero(vs.get("SW"));
		return str;
	}

	public String getmin(String name) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d1 = new Date();
		long zt = d1.getTime() - 82800000L;
		long lt = d1.getTime();
		String ztime = sdf.format(new Date(zt)).substring(0, 16);
		String time = sdf.format(new Date(lt)).substring(0, 16);
		String sql = "select  min(sw) sw from (select distinct* from (select sw, to_char(time,'hh24')as sj,time from pub_svc.pub_dep_sl_ccsw where  name = '"
				+ name
				+ "' and time in\n"
				+ "(\n"
				+ "select min(time) from pub_svc.pub_dep_sl_ccsw where name = '"
				+ name
				+ "'\n"
				+ "and time >=to_date('"
				+ ztime
				+ "','yyyy-mm-dd hh24:mi') and time <to_date('"
				+ time
				+ "','yyyy-mm-dd hh24:mi')\n"
				+ "group by to_char(time,'hh24'))\n"
				+ "order by to_char(time,'hh24') ) order by time asc)";

		List<Map<String, Object>> list = jdbcT.queryForList(sql);
		Map<String, Object> vs = list.get(0);
		String str = StringUtil.changeZero(vs.get("SW"));

		return str;
	}

	public String getJson(String name) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d1 = new Date();
		long zt = d1.getTime() - 82800000L;
		long lt = d1.getTime();
		String ztime = sdf.format(new Date(zt)).substring(0, 16);
		String time = sdf.format(new Date(lt)).substring(0, 16);
		String sql = "select distinct* from (select sw, to_char(time,'hh24')as sj,time from pub_svc.pub_dep_sl_ccsw where  name = '"
				+ name
				+ "' and time in\n"
				+ "(\n"
				+ "select min(time) from pub_svc.pub_dep_sl_ccsw where name = '"
				+ name
				+ "'\n"
				+ "and time >=to_date('"
				+ ztime
				+ "','yyyy-mm-dd hh24:mi') and time <to_date('"
				+ time
				+ "','yyyy-mm-dd hh24:mi')\n"
				+ "group by to_char(time,'hh24'))\n"
				+ "order by to_char(time,'hh24') ) order by time asc";

		List<Map<String, Object>> list = jdbcT.queryForList(sql);
		if ((list == null) || (list.size() <= 0)) {
			String hsql = "select distinct* from (select sw, to_char(time,'hh24')as sj,time from pub_svc.pub_dep_sl_ccsw where  name = '"
					+ name
					+ "' and time in\n"
					+ "(\n"
					+ "select min(time) from pub_svc.pub_dep_sl_ccsw where name = '"
					+ name
					+ "'\n"
					+ "and time >=to_date('2014-08-03 15:36','yyyy-mm-dd hh24:mi') and time <to_date('2014-08-04 14:36','yyyy-mm-dd hh24:mi')\n"
					+ "group by to_char(time,'hh24'))\n"
					+ "order by to_char(time,'hh24') ) order by time asc";

			list = jdbcT.queryForList(hsql);
		}

		String yJson = "";
		double b = 0.0D;
		String c = "";

		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < list.size(); j++) {
				Map<String, Object> vs = list.get(j);
				b = Double.parseDouble(vs.get("SW").toString());
				c = c + String.valueOf(b) + ",";
			}
			int num = c.length();
			c = c.substring(0, num - 1);
			yJson = "[" + c + "]";
		}

		return yJson;
	}
}