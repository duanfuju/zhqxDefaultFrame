package cn.com.oking.caiyun;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import cn.com.oking.util.KeyUtil;


@Repository
public class CaiyunYjDao{
	@Resource(name = "jdbcPub_svc")
	private JdbcTemplate jdbcT;
	
	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemp;

	
	/**
	 * 新增 
	 * @param longitude  经度
	 * @param latitude   纬度
	 * @return
	 */
	public void insert(String longitude,String latitude,String district)
	{
		
	    SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String date=sim.format(new Date());
	    String key=KeyUtil.getKey();
	   
	      String sql="insert into pub_svc.caiyun_yj"
	                  +" (id, yjid, description, district,warningtime, lastdate, longitude, latitude, status) "
	              +" values "
	                  +" ('"+key+"','"+key+"', '"+district+"未来一小时有雨', '"+district+"', " 
	                  +"to_date('"+date+"','yyyy-MM-dd hh24:mi:ss'),"
	                  +"to_date('"+date+"','yyyy-MM-dd hh24:mi:ss'), '"+longitude+"','"+latitude+"', '未确认')";
	     jdbcT.execute(sql);
	  }
	
	
	/**
	 * 修改
	 * @param longitude  经度
	 * @param latitude   纬度
	 * @return
	 */
	public void update(String id,String longitude,String latitude){
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sql="update pub_svc.caiyun_yj c set c.lastdate=to_date('"+sim.format(new Date())
													+"','yyyy-MM-dd hh24:mi:ss') ,c.longitude='"+longitude+"',c.latitude='"+latitude+"' where c.yjid='"+id+"'";
		jdbcT.execute(sql);
	}
	
	
	
	/**
	 * 查询
	 * @param longitude 经度
	 * @param latitude	纬度
	 * @return
	 */
	public String findMatchCondition(String district){
		String sql="select yjid,count(*)c from  pub_svc.caiyun_yj where lastdate >(sysdate -1/24) and district ='"+district+"'  group by yjid";
		Map<String, Object> rs;
		try {
			rs = jdbcT.queryForMap(sql);
		} catch (DataAccessException e) {
			return null;
		}
		return rs.get("yjid").toString();
	}
	
	public String isExists(){
		String sql="select count(*)c from  pub_svc.caiyun_yj where lastdate >(sysdate -3)";
		Map<String, Object> rs;	
		try {
			rs = jdbcT.queryForMap(sql);
			if (rs.size()>0) {
				return "have";
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			return "none";
		}
		return "have";
	}
	
	public String UserAuthentication(String name){
		String sql="select t.name_ rolename,t1.username_ from bdf2_role t,bdf2_role_member t1 " 
					+" where t.name_='气象台' and t.id_=t1.role_id_(+) "
					+" and t1.username_='"+name+"'";
		Map<String, Object> rs;	
		try {
			rs = jdbcTemp.queryForMap(sql);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return "no";
		}
		return "yes";
	}
}
