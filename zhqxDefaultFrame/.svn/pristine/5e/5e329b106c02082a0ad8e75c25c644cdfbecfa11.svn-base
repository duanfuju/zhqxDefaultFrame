package cn.com.oking.link;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component	
public class getHrefItem {
	
	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcT;
	/**
	 * 根据模块ID获取链接集合
	 * @return
	 * @throws Exception
	 * @author Hla
	 */
	public List<Map<String, Object>> getList(String  mid) throws Exception{
		String sql="select id, itemurl, itemname, opentype, owneruser, moduleid, colnum, ordernum, itemtype, para1, para2 from href_item where moduleid='"+mid+"' order by ordernum";
		List<Map<String, Object>> list=jdbcT.queryForList(sql);
		return list;
	}
}
