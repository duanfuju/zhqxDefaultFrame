package cn.com.oking.link;


import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.bstek.dorado.annotation.Expose;

@Component
public class delete {
	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcT;
	
	
	public int del(String id)throws Exception{
		String sql="delete from href_item where id='"+id+"'";
		int num=jdbcT.update(sql);
		return num;
	}
	

}
