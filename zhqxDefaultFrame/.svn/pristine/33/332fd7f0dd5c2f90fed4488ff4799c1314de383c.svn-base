package cn.com.oking.portlet;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PortalDao {
	
	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemp;
	
	public String checkUser(String username){
		String sql="select t.name_ name from bdf2_role t,bdf2_role_member t1 where t.id_=t1.role_id_ and t1.username_='"+username+"'";
		Map<String, Object> rs;	
		try {
			rs = jdbcTemp.queryForMap(sql);
			return rs.get("name").toString();
		} catch (DataAccessException e) {
			e.printStackTrace();
			return "error";
		}
	}
}
