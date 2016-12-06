package cn.com.oking.caiyun;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component	
public class getList {
	@Resource(name = "jdbcPub_svc")
	private JdbcTemplate jdbcT;
	
	public List getone(String id)throws Exception{
		String sql = "select * from(select * from pub_svc.caiyun_yj  where status='未确认' order by lastdate desc)where id='" + id + "'";
		List<Map<String, Object>> list = jdbcT.queryForList(sql);
		return list;
	}
	
	public  List getList() throws Exception {
	    String sql = "select * from pub_svc.caiyun_yj  where status='未确认' order by lastdate desc";
	    List<Map<String, Object>> list = jdbcT.queryForList(sql);
		return list;
	  }

	  public  List newfive() throws Exception
	  {
	    String sql = "select * from (select * from pub_svc.caiyun_yj order by lastdate desc )where rownum<=5";
	    List<Map<String, Object>> list = jdbcT.queryForList(sql);
		return list;
	  }

	  public  List newdate() throws Exception
	  {
	    String sql = "select * from pub_svc.caiyun_yj t where  t.status='未确认' order by lastdate desc";
	    List<Map<String, Object>> list = jdbcT.queryForList(sql);
		return list;
	  }
	
}
