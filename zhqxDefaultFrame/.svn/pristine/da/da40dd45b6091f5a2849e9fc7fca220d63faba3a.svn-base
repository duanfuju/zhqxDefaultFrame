package cn.com.oking.em.dao;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.com.oking.em.entity.EmXymlFb;

import com.bstek.dorado.hibernate.HibernateDao;


@Repository
public class EmXymlFbDao extends HibernateDao<EmXymlFb, Long>{
	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcT;
	
	public List<Map<String, Object>> findDataById(String id){
		String sql="select * from em_xyml_fb f ,em_alarmstandard d where f.bz_id=d.id and  f.id='"+id+"'";
		List<Map<String, Object>> list=null;
		try {
			list = jdbcT.queryForList(sql);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	} 
}
