package cn.com.oking.nrfb;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class getTab {
	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcT;

	/**
	 * ²éÑ¯
	 * 
	 * @param menuid
	 *            Ä£¿é±àºÅ
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getList(String uid) throws Exception {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			String sql = "select link,params,tab_name from tab_control where associate_id='"
					+ uid + "' order by order_num";
			list = jdbcT.queryForList(sql);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}
}
