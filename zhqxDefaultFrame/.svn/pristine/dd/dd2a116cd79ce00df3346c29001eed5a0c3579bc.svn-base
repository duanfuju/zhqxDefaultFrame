package cn.com.oking.waterdata;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class GetYlsbt {
	@Resource(name = "jdbcPub_svc")
	private JdbcTemplate jdbcT;

	public List<Map<String, Object>> getYlsbt() {
		String sql = "select * from (select * from pub_svc.NUIST_ZHYB_RT  where filetype='Rain' order by filetime desc ) where rownum<=24 order by filetime asc";
		List<Map<String, Object>> list = jdbcT.queryForList(sql);
		return list;
	}

}
