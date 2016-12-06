package cn.com.oking.waterdata;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class GetTqld {
	@Resource(name = "jdbcPub_svc")
	private JdbcTemplate jdbcT;

	public List<Map<String, Object>> getTqld() {
		String sql = "select filename  from (select filename,filetime,rownum rn from (SELECT filename,filetime from (select filename,filetime from pub_svc.NUIST_BMPT_NJLD  order by filetime desc )  where rownum<=6 order by filetime desc) where rownum <7 order by filetime desc)";

		List<Map<String, Object>> list = jdbcT.queryForList(sql);

		return list;
	}

}
