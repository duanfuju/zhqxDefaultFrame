package cn.com.oking.link;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class update {
	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcT;
	
	public int updateBatch(String[] id,String[] order)throws Exception{
		//拼接sql
		String sql="begin ";
		for (int i = 0; i < id.length; i++) {
			sql+="update href_item hi set hi.ordernum='"+order[i]+"' where hi.id='"+id[i]+"';";
		}
		sql+=" end;";
		//把sql语句中的换行符替换成空格
		sql=sql.replace("r\n", " ").replace('\n', ' ');
		int num=jdbcT.update(sql);
		return num;
	}
}
