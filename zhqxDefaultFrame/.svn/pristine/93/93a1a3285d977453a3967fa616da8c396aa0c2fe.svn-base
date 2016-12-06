package cn.com.oking.sys;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.jdbc.core.RowMapper;

import cn.com.oking.util.StringUtil;

public class MonitorMsgMapper implements RowMapper<MonitorMsg> {
	
	private SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Override
	public MonitorMsg mapRow(ResultSet rs, int num) throws SQLException {
		MonitorMsg msg = new MonitorMsg();
		msg.setMessageid(rs.getString("messageid"));
		msg.setSendto(rs.getString("sendto"));
		msg.setContent(rs.getString("content"));
		msg.setFeedback(rs.getString("feedback"));
		msg.setShortmessage(rs.getString("shortmessage"));
		msg.setPhonenum(rs.getString("phonenum"));
		
		try {
			String createtime = rs.getString("createtime");
			if(StringUtil.isNotEmpty(createtime)){
				msg.setCreatetime(sf.parse(createtime));
			}
			
			String sendtime = rs.getString("sendtime");
			if(StringUtil.isNotEmpty(sendtime)){
				msg.setSendtime(sf.parse(sendtime));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return msg;
	}
	
}
