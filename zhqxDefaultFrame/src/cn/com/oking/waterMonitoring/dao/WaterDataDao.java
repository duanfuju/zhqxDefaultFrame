package cn.com.oking.waterMonitoring.dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bstek.dorado.hibernate.HibernateDao;


import cn.com.oking.entity.WaterData;


@Repository
public class WaterDataDao  extends HibernateDao<WaterData, Long>{

	
	
	
	/**
	 * 根据站点编号获取最近30天的数据
	 * @param siteid
	 * @return
	 */
	public List<WaterData> findBySiteid(String siteid){
		String sql ="select wd_id, wd_date, wd_results from "
				+" (select wd_id, wd_date, wd_results, siteid from water_data where siteid='"+siteid+"' order by wd_date desc)"
				+" order by wd_date";
		Session session = super.getSession();
		SQLQuery query=session.createSQLQuery(sql);   
		List<Object> os = query.list();
		List<WaterData> list=new ArrayList<WaterData>();
		for (int i = 0; i < os.size(); i++) {
			Object[] o= (Object[]) os.get(i);
			WaterData wd=new WaterData();
			wd.setWdId(o[0].toString());
			wd.setWdDate((Date)o[1]);
			wd.setWdResults(new BigDecimal(o[2].toString()));
			list.add(wd);
		}
		return list;
	}
	
	
	/**
	 * 监测点编号获取积水量最新的
	 * @param siteid
	 * @return
	 */
	public WaterData findByCurrent(String siteid){
		String sql ="select  wd_results  from water_data where siteid='"+siteid+"' order by wd_date desc ";
		Session session = super.getSession();
		SQLQuery query=session.createSQLQuery(sql);   
		List<Object> o = query.list();
		WaterData l=new WaterData();
		String result=o.get(0).toString();
		l.setWdResults(new BigDecimal(result));
		return l;
	}
	/**
	 * 根据监测点编号和数据量来查询
	 * @param siteid
	 * @param number
	 * @return
	 */
	public WaterData findByTime(String siteid,String number){
		String sql ="select wd_date, wd_results from "
			+" (select  wd_id, wd_date, wd_results, siteid  from water_data where siteid='"+siteid+"' and sysdate-wd_date<="+number+"  order by wd_results desc)"
			+" where rownum =1";
		Session session = super.getSession();
		SQLQuery query=session.createSQLQuery(sql);   
		List<Object> ls = query.list();
		WaterData l=new WaterData();
		Object[] o=(Object[]) ls.get(0);
		l.setWdResults(new BigDecimal(o[1].toString()));
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd hh24:mm:ss");
		try {
			l.setWdDate(sim.parse(o[0].toString()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	
	
	/**
	 * 根据监测点编号和数据量来查询
	 * @param siteid
	 * @param number
	 * @return
	 */
	public Map<String, Object> findByTimeWithObject(String siteid,String number){
		String sql ="select to_char(wd_date,'yyyy-mm-dd hh24:mi')wd_date, nvl(wd_results,0)wd_results from "
			+" (select  wd_id, wd_date, wd_results, siteid  from water_data where siteid='"+siteid+"' and sysdate-wd_date<="+number+"  order by wd_results desc)"
			+" where rownum =1";
		Session session = super.getSession();
		SQLQuery query=session.createSQLQuery(sql);   
		List<Object> os = query.list();
		Map<String, Object> map=new HashMap<String, Object>();
		if (os.size()>0) {
			Object[] o= (Object[]) os.get(0);
			map.put("wd_date", o[0]);	
			map.put("wd_results", o[1]);	
		}else{
			map.put("wd_date", "-");	
			map.put("wd_results","-");
		}
		return map;
	}
	
	public Map<String, Object> findMax(String siteid){
		String sql ="select wd_date,wd_results "
			+" from(select wd_results,wd_date from water_data wd where wd.siteid='"+siteid+"' order by wd_results desc )"
			+" where rownum =1";
		Session session = super.getSession();
		SQLQuery query=session.createSQLQuery(sql);   
		List<Object> os = query.list();
		Map<String, Object> map=new HashMap<String, Object>();
		if (os.size()>0) {
			Object[] o= (Object[]) os.get(0);
			map.put("wd_date", o[0]);	
			map.put("wd_results", o[1]);	
		}else{
			map.put("wd_date", "-");	
			map.put("wd_results","-");
		}
		return map;
	}
	
}
