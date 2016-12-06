package cn.com.oking.em.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.com.oking.em.entity.EmCzfaMlAdvice;

import com.bstek.dorado.hibernate.HibernateDao;

@Repository
public class EmCzfaMlAdviceDao extends HibernateDao<EmCzfaMlAdvice, String>{
	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcT;
	
	public List<Map<String, Object>> findDataListById(String id){
		String sql="select ml.zhlx zhlx,ml.response_level lev,mla.dept,mla.responses res " 
				   +" from em_czfa_ml ml,em_czfa_ml_advice mla "
			       +" where ml.id=mla.czfa_jy_id and ml.id='"+id+"'"
			       +" order by mla.type";
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
