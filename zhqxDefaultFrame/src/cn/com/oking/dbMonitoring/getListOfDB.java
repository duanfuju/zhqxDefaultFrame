package cn.com.oking.dbMonitoring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class getListOfDB {  
	//zhqx的数据源
	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcZhqx;
	//pub_svc的数据源
	@Resource(name = "jdbcPub_svc")
	private JdbcTemplate jdbcPub_svc;
	//sqpt的数据源
	@Resource(name = "jdbcSqpt")
	private JdbcTemplate jdbcSqpt;
	
	/**
	 * 
	 * @param user	判断是哪个用户
	 * @return
	 */
	public List<Map<String, Object>> findByUser(String user){
		List<Map<String, Object>> AllList= new ArrayList<Map<String,Object>>();
		JdbcTemplate jdbc=null;
		if (user.equalsIgnoreCase("zhqx")) {
			jdbc=jdbcZhqx;
		}else if (user.equalsIgnoreCase("pub_svc")) {
			jdbc=jdbcPub_svc;
		}else if (user.equalsIgnoreCase("sqpt")) {
			jdbc=jdbcSqpt;
		}else{
			return null;
		}
		//0.数据库版本号(version)
		AllList.addAll(getList(jdbc, "select * from product_component_version p where p.product like 'Oracle%'"));
		//1.product操作系统()
		AllList.addAll(getList(jdbc, "select product from (select product,rownum rownumber from product_component_version p where rownum >= 1 )where rownumber=4"));
		//2.数据库名称()Instance_name、创建时间()
		AllList.addAll(getList(jdbc, "select name as Instance_name,created as db_created_time from v$database"));
		//3.运行时间()
		AllList.addAll(getList(jdbc, "select to_char(startup_time,'yyyy-MM-dd HH24:MI:SS') started_at,"
										+" TRUNC(sysdate - (startup_time))||'day(s),'||TRUNC(24*((sysdate-startup_time) -TRUNC(sysdate-startup_time)))"
										+" ||'hour(s),'||MOD(TRUNC(1440*((SYSDATE-startup_time)-"
										+" TRUNC(sysdate-startup_time))),60)"
										+" ||'minutes(s),'||MOD(TRUNC(86400*((SYSDATE-STARTUP_TIME)-"
										+" TRUNC(SYSDATE-startup_time))),60)"
										+" ||'seconds' uptime"
										+" from v$instance"));
		if (getList(jdbc, "select * from v$osstat").size()==0) {
			List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("value", 0);
			list.add(map);
			AllList.addAll(list);
			AllList.addAll(list);
			AllList.addAll(list);
		}else{
			//4-5主机cpu利用率	AVG_BUSY_TIME/(AVG_IDLE_TIME+AVG_BUSY_TIME)
			AllList.addAll(getList(jdbc, "select * from v$osstat o where o.STAT_NAME='AVG_BUSY_TIME'"));
			AllList.addAll(getList(jdbc, "select * from v$osstat o where o.STAT_NAME='AVG_IDLE_TIME'"));
			//6.cpu的数量(cpu_num)
			AllList.addAll(getList(jdbc, "select value from v$osstat v where v.STAT_NAME='NUM_CPUS'"));
		}
		//7.数据库允许的最大连接数(db_allow_max_connect_num)
		AllList.addAll(getList(jdbc, "select value as db_allow_max_connect_num from v$parameter where name = 'processes'"));
		//8.当前的数据库连接数(db_connect_num)
		AllList.addAll(getList(jdbc, "select count(*) as db_connect_num from v$process "));
		//9.当前连接的会话数(current_connect_session)
		AllList.addAll(getList(jdbc, "select count(*) as current_connect_session from v$session "));
		//10.当前打开的游标数(current_open_cursor)
		AllList.addAll(getList(jdbc, "select count(*) as current_open_cursor from v$open_cursor "));
		//11.并发连接数(active_num)
		AllList.addAll(getList(jdbc, "select count(*) as active_num from v$session where status='ACTIVE'"));
		//12.高速缓冲区(db_block_size)	
		AllList.addAll(getList(jdbc, "select value as db_block_size   from v$parameter where name='db_block_size'"));
		//13.数据缓冲区命中率(Buffer_Cache_Hit_Ratio)
		AllList.addAll(getList(jdbc, "select 1 - ((physical.value - direct.value - lobs.value) / logical.value) as Buffer_Cache_Hit_Ratio "
				+" from v$sysstat physical,v$sysstat direct,v$sysstat lobs,v$sysstat logical"
				+" where physical.name = 'physical reads'"
				+" and direct.name='physical reads direct'"
				+" and lobs.name='physical reads direct (lob)'"
				+" and logical.name='session logical reads'"));
		//14.日志缓冲区(log_buffer)
		AllList.addAll(getList(jdbc, "select value as log_buffer   from v$parameter where name='log_buffer'"));
		//15.大型池(large_pool_size)
		AllList.addAll(getList(jdbc, "select value as large_pool_size   from v$parameter where name='large_pool_size'"));
		//16.共享池(shared_pool_size)
		AllList.addAll(getList(jdbc, "select value as shared_pool_size   from v$parameter where name='shared_pool_size'"));
		//17.java池(java_pool_size)
		AllList.addAll(getList(jdbc, "select value as java_pool_size   from v$parameter where name='java_pool_size'"));
		//18-21.SGA
		AllList.addAll(getList(jdbc, "select name,value From v$sga"));
		//22.表空间使用率()
		AllList.addAll(getList(jdbc, "select a.tablespace_name,a.bytes/1024/1024 as sum_MB,(a.bytes-b.bytes)/1024/1024 as used_MB,b.bytes/1024/1024 as free_MB,round(((a.bytes-b.bytes)/a.bytes)*100,2) as percent_used" 
										+" from "
										+" (select tablespace_name,sum(bytes) bytes from dba_data_files group by tablespace_name) a," 
										+" (select tablespace_name,sum(bytes) bytes,max(bytes) largest from dba_free_space group by tablespace_name) b" 
										+" where a.tablespace_name=b.tablespace_name and b.tablespace_name=(select default_tablespace from dba_users where username='"+user.toUpperCase()+"')"
										+" order by ((a.bytes-b.bytes)/a.bytes) desc"));
		
		return AllList;
	}
	
	/**
	 * 
	 * @param user	判断是哪个数据源
	 * @param sql	执行的是哪个sql语句
	 * @return
	 */
	private List<Map<String, Object>> getList(JdbcTemplate jdbc,String sql){
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		try {
			list = jdbc.queryForList(sql);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}
}
