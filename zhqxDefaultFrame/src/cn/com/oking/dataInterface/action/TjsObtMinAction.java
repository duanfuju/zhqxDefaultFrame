package cn.com.oking.dataInterface.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.com.oking.util.StringUtil;

import com.bstek.dorado.annotation.DataProvider;

@Component
public class TjsObtMinAction {

	@Resource(name = "jdbcPub_svc")
	private JdbcTemplate jdbcT;
	public static int PAGESIZE = 10;

	@DataProvider
	@Transactional
	public Map<String, Object> getPageInfo(
			java.util.Map<String, Object> parameter) {// tjsObtMinAction#getPageInfo
		Map<String, Object> map = new HashMap<String, Object>();

		Date edate = new Date();
		String _startTime = "";
		String _endTime = "";
		String _obtid = "";

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		if (parameter != null) {
			_obtid = StringUtil.changNull(parameter.get("obtid"));
			_endTime = StringUtil.changNull(parameter.get("bjTime"));
		}
		if (_endTime.equals("")) {
			Date now = new Date();
			_endTime = sdf.format(now);
		}
		try {
			edate = sdf.parse(_endTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 获取前一天时间
		_startTime = sdf.format(new Date(edate.getTime() - 1 * 24 * 60 * 60
				* 1000));

		int allCount = getAllCount(_obtid, _startTime, _endTime);
		int allPages = (allCount - 1) / PAGESIZE + 1;

		map.put("allcount", allCount);
		map.put("pagesize", PAGESIZE);
		map.put("allpage", allPages);

		return map;
	}

	@DataProvider
	@Transactional
	public List<Map<String, Object>> getList(
			java.util.Map<String, Object> parameter) {// tjsObtMinAction#getList
		Date edate = new Date();
		int start = 1;
		int end = 1;
		int _curpage = 1;
		String _startTime = "";
		String _endTime = "";
		String _obtid = "";

		if (parameter != null) {
			_obtid = StringUtil.changNull(parameter.get("obtid"));
			_endTime = StringUtil.changNull(parameter.get("bjTime"));
			_curpage = Integer.parseInt(parameter.get("curpage").toString());
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		if (_endTime.equals("")) {
			Date now = new Date();
			_endTime = sdf.format(now);
		}
		try {
			edate = sdf.parse(_endTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 获取前一天时间
		_startTime = sdf.format(new Date(edate.getTime() - 1 * 24 * 60 * 60
				* 1000));

		start = (_curpage - 1) * PAGESIZE + 1;
		end = _curpage * PAGESIZE;

		String sql = "select * from (select rownum rn,obtid,ddatetime,bj_datetime from T_JS_OBT_10MIN_AWS_ALLELE where obtid like'"
				+ _obtid
				+ "' and BJ_DATETIME between to_date('"
				+ _startTime
				+ "',\'yyyy-mm-dd hh24:mi:ss\') and to_date('"
				+ _endTime
				+ "',\'yyyy-mm-dd hh24:mi:ss\') order by bj_datetime desc) where rn>='"
				+ start + "' and rn<='" + end + "'";
		List<Map<String, Object>> list = jdbcT.queryForList(sql);

		return list;

	}

	public int getAllCount(String _obtid, String _startTime, String _endTime) {
		List<Map<String, Object>> list = null;
		try {
			String sql = "select count(*) recordCount from(select obtid,ddatetime,bj_datetime from T_JS_OBT_10MIN_AWS_ALLELE where obtid like '"
					+ _obtid
					+ "' and bj_datetime between to_date('"
					+ _startTime
					+ "',\'yyyy-mm-dd hh24:mi:ss\') and to_date('"
					+ _endTime + "',\'yyyy-mm-dd hh24:mi:ss\'))";
			list = jdbcT.queryForList(sql);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return Integer.parseInt(list.get(0).get("recordCount").toString());
	}

}
