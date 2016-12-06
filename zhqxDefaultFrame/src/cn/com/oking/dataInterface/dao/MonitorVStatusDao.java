package cn.com.oking.dataInterface.dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;



import cn.com.oking.dataInterface.entity.MonitorVStatus;

import com.bstek.dorado.hibernate.HibernateDao;

@Repository
public class MonitorVStatusDao extends HibernateDao<MonitorVStatus,Long> {

	public List<Map<String, Object>> getData(){
		String sql="select dataname,datastatus,lastdate,nvl(delaytime,0)delaytime,nvl(overtime,0)overtime,ordernum,detaillist from monitor_v_status";
		Session session = super.getSession();
		SQLQuery query=session.createSQLQuery(sql);   
		List<Object> os = query.list();
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		for (int i = 0; i < os.size(); i++) {
			Object[] o= (Object[]) os.get(i);
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("dataname", o[0]);
			map.put("datastatus", o[1]);
			map.put("lastdate", o[2]);
			map.put("delaytime", o[3]);
			map.put("overtime", o[4]);
			map.put("ordernum", o[5]);
			map.put("detaillist", o[6]);
			list.add(map);
		}
		return list;
	}
	
	public List<Map<String, Object>> getErrorData(){
		String sql="select dataname,datastatus,lastdate,nvl(delaytime,0)delaytime,nvl(overtime,0)overtime,ordernum,detaillist from monitor_v_status where datastatus='“Ï≥£'";
		Session session = super.getSession();
		SQLQuery query=session.createSQLQuery(sql);   
		List<Object> os = query.list();
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		for (int i = 0; i < os.size(); i++) {
			Object[] o= (Object[]) os.get(i);
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("dataname", o[0]);
			map.put("datastatus", o[1]);
			map.put("lastdate", o[2]);
			map.put("delaytime", o[3]);
			map.put("overtime", o[4]);
			map.put("ordernum", o[5]);
			map.put("detaillist", o[6]);
			list.add(map);
		}
		return list;
	}
}
