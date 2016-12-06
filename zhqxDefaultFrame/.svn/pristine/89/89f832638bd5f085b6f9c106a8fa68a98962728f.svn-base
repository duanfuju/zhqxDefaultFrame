package cn.com.oking.sys;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.stereotype.Component;

import cn.com.oking.util.StringUtil;

import com.bstek.bdf2.core.orm.jdbc.JdbcDao;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;


@Component
public class MonitorMsgDao extends JdbcDao {

	/**
	 * 查询发送列表
	 * @return
	 */
	@DataProvider
	public List<MonitorMsg> getSendList(){
		String sql = "SELECT messageid,sendto,content,feedback,shortmessage,  "+
			       "to_char(createtime,'yyyy-MM-dd HH:mm:ss') createtime,  "+
			        "to_char(sendtime,'yyyy-MM-dd HH:mm:ss') sendtime,  "+
			        "phonenum  "+
			        "from monitor_msg where feedback is null";
		List<MonitorMsg> ml = this.getNamedParameterJdbcTemplate().query(sql, new MonitorMsgMapper());
		return ml;
	}
	
	/**
	 * 
	 * @param id 
	 */
	@DataResolver
	public void push(String id){
		if(StringUtil.isNotEmpty(id)){
			String sql = "update monitor_msg set sendtime=sysdate,feedback='send' where messageid = :messageid";
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("messageid", id);
			this.getNamedParameterJdbcTemplate().update(sql, map);
		}
	}
	
	
}
