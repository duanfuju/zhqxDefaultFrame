package cn.com.oking.link;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component	
public class getModule {
	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcT;
	
	/**
	 * 查询
	 * @param menuid	模块编号
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getList(String menuid) throws Exception{
		List<Map<String, Object>> list=null;
		try {
			String sql="select id, modulename, description, colnum, ordernum, menuid, moduletype from href_module where menuid='"+menuid+"' order by ordernum";
			list = jdbcT.queryForList(sql);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}
	
	/**
	 * 查询(编辑时的查询方法)
	 * @param menuid
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getListById(String id) throws Exception{
		List<Map<String, Object>> list=null;
		try {
			String sql="select id, modulename, description, colnum, ordernum, menuid, moduletype from href_module where id='"+id+"' order by ordernum";
			list = jdbcT.queryForList(sql);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}
}
      