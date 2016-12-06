package cn.com.oking.link;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component	
public class linkAdd {
	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcT;
	
	       
	
	public int getxh(String v1)throws Exception{
		String sql="select max(ordernum) ordernum from href_item t where moduleid='"+v1+"'";
		Map<String, Object> map=null;
		int a=0;
		try {
			map = jdbcT.queryForMap(sql);
			a=Integer.valueOf(map.get("ordernum").toString())+1;
		} catch (Exception e) {
			e.printStackTrace();
			a+=1;
		}
		return a;
	}

	public int add(String v1,String v2,String v3)throws Exception{
		String sql="insert into href_item (id,itemurl,itemname,opentype,owneruser,moduleid,colnum,ordernum,itemtype)values('"+System.currentTimeMillis()+"','"+v2+"','"+v1+"','_blank','hla','"+v3+"',1,"+getxh(v3)+",1)";
		int num=jdbcT.update(sql);
		return num;
	}
}
