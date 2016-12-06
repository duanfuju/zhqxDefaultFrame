package cn.com.oking.nrfb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.bstek.bdf2.core.context.ContextHolder;

@Component
public class getWzWz {
	@Resource(name = "jdbcSqpt")
	private JdbcTemplate jdbcT;

	/**
	 * ²éÑ¯
	 * 
	 * @param menuid
	 *            Ä£¿é±àºÅ
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getReady(String mid, String currentPageStr) {
		int currentPage = 1;
		int pageSize = 10;
		if (currentPageStr == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.valueOf(currentPageStr);
		}
		if (currentPage < 1) {
			currentPage = 1;
		}
		getWzWz dao = ContextHolder.getBean("getWzWz");
		int allCount = dao.getAllCount(mid);
		int allPages = (allCount - 1) / pageSize + 1;
		if (currentPage > allPages) {
			currentPage = allPages;
		}

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			list = dao.getList(mid, currentPage, pageSize);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < list.size(); i++) { // datetime to date
			Map<String, Object> map = list.get(i);
			String fbsj = map.get("fbsj").toString();
			Object gjz = map.get("gjz");
			if (gjz == null) {
				list.get(i).put("gjz", "--");
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date;
			try {
				date = sdf.parse(fbsj);
				fbsj = sdf.format(date);
				list.get(i).put("fbsj", fbsj);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (list.size() == 0) {
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("allcount", allCount);
			m.put("curpage", currentPage);
			m.put("pagesize", pageSize);
			m.put("allpage", allPages);
			list.add(m);
		} else {
			list.get(0).put("allpage", allPages);
			list.get(0).put("curpage", currentPage);
			list.get(0).put("pagesize", pageSize);
			list.get(0).put("allcount", allCount);
		}
		return list;
	}

	public List<Map<String, Object>> getList(String mid, int currentPage,
			int pageSize) throws Exception {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();

		try {
			int start = (currentPage - 1) * pageSize + 1;
			int end = currentPage * pageSize;
			String sql = "select * from(select  rownum rn, wzbh,fjmc,fjbm,t2.fbsj,t2.wzbt,t2.gjz from wz_fj t1,wz_wz t2 where  t1.wzbh =t2.bh(+) and t2.sslmbh='"
					+ mid
					+ "' order by t2.fbsj desc) where rn>='"
					+ start
					+ "' and rn<='" + end + "'";
			System.err.println("!!!!!!!!!!!!" + sql);
			list = jdbcT.queryForList(sql);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}

	public int getAllCount(String mid) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			String sql = "select  count(*) recordCount from wz_fj t1,wz_wz t2 where t1.wzbh =t2.bh(+) and t2.sslmbh='"
					+ mid + "'";
			list = jdbcT.queryForList(sql);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return Integer.parseInt(list.get(0).get("recordCount").toString());
	}

}
