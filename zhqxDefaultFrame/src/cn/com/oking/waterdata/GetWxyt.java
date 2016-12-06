package cn.com.oking.waterdata;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class GetWxyt {
	@Resource(name = "jdbcPub_svc")
	private JdbcTemplate jdbcT;

	public List<Map<String, Object>> getWxyt() {
		String sql = "select filename from (select filename,rownum rn from (SELECT filename from (select filename from pub_svc.nuist_td_weixing  order by filename desc )  where rownum<=6 order by filename desc) where rownum <7 order by filename desc)";

		List<Map<String, Object>> list = jdbcT.queryForList(sql);

		return list;
	}

}
