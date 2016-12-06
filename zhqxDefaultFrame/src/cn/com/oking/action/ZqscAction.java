package cn.com.oking.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ZqscAction {
	
	@Resource(name = "jdbcPhone")
	private JdbcTemplate jdbcPhone;
	
	@Resource(name = "jdbcSqpt")
	private JdbcTemplate jdbcSqpt;
	
	public List<Map<String, Object>> getDataBySqpt()throws Exception{
		String sql="select distinct streetname,communityname,disastertype,addressname,s.show_path showpath,s.real_name realname ,s.up_time uptime,other,communityname"
				+" from disaster d,sys_file_information s where d.file_id =s.association_id and s.up_time >=to_date('2015-01-01 00:00','yyyy-mm-dd hh24:mi') order by s.up_time desc";
		List<Map<String, Object>> list=null;
		try {
			list = jdbcSqpt.queryForList(sql);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}
	public List<Map<String, Object>> getDataByPhone()throws Exception{
		String sql="select id, file_name, save_path, real_name, x, y, description, upload_user, time, street, community, disaster, address from file_upload where time >=to_date('2015-01-01 00:00','yyyy-mm-dd hh24:mi') order by time desc";
		List<Map<String, Object>> list=null;
		try {
			list = jdbcPhone.queryForList(sql);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}
	
}
