package cn.com.oking.em.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.com.oking.em.entity.EmCzfaJyAdvice;

import com.bstek.dorado.hibernate.HibernateDao;

@Repository
public class EmCzfaJyAdviceDao extends HibernateDao<EmCzfaJyAdvice, Long>{
	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcT;
	
	public List<Map<String, Object>> findDataListById(String id){
		String sql="select jya.dept dept,jya.responses res,jy.response_level lev,jy.zhlx zhlx" 
					+"  from em_czfa_jy jy,em_czfa_jy_advice jya"
					+"  where jy.id=jya.czfa_jy_id and jy.id='"+id+"'"
					+"  order by jya.type ";
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
