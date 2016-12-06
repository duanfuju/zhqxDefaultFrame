package cn.com.oking.dataInterface.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;


import cn.com.oking.entity.MonitorSysList;

import com.bstek.dorado.hibernate.HibernateDao;


@Repository
public class MonitorSysListDao extends HibernateDao<MonitorSysList,Long> {
	
	public List<Map<String, Object>> getEffectiveData(){
		String sql="select dataid, dataname, ipaddress, port, testurl, retmsg, loginurl, period, nvl(overtime,0)overtime, to_char(lastdate,'yyyy-mm-dd hh24:mi')lastdate, status from monitor_sys_list where status='有效'";
		Session session = super.getSession();
		SQLQuery query=session.createSQLQuery(sql);   
		List<Object> os = query.list();
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		for (int i = 0; i < os.size(); i++) {
			Object[] o= (Object[]) os.get(i);
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("dataid", o[0]);
			map.put("dataname", o[1]);
			map.put("ipaddress", o[2]);
			map.put("port", o[3]);
			map.put("testurl", o[4]);
			map.put("retmsg", o[5]);
			map.put("loginurl", o[6]);
			map.put("period", o[7]);
			map.put("overtime", o[8]);
			map.put("lastdate", o[9]);
			map.put("status", o[10]);
			list.add(map);
		}
		return list;
	}
	
	public List<Map<String, Object>> getData(){
		String sql="select dataid, dataname, ipaddress, port, testurl, retmsg, loginurl, period, nvl(overtime,0)overtime, to_char(lastdate,'yyyy-mm-dd hh24:mi')lastdate, status from monitor_sys_list";
		Session session = super.getSession();
		SQLQuery query=session.createSQLQuery(sql);   
		List<Object> os = query.list();
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		for (int i = 0; i < os.size(); i++) {
			Object[] o= (Object[]) os.get(i);
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("dataid", o[0]);
			map.put("dataname", o[1]);
			map.put("ipaddress", o[2]);
			map.put("port", o[3]);
			map.put("testurl", o[4]);
			map.put("retmsg", o[5]);
			map.put("loginurl", o[6]);
			map.put("period", o[7]);
			map.put("overtime", o[8]);
			map.put("lastdate", o[9].toString());
			map.put("status", o[10]);
			list.add(map);
		}
		return list;
	}
	
	
	public List<Map<String, Object>> getErrorData(){
		String sql="select dataid, dataname, ipaddress, port, testurl, retmsg, loginurl, period, nvl(overtime,0)overtime, to_char(lastdate,'yyyy-mm-dd hh24:mi')lastdate, status from monitor_sys_list where status='无效'";
		Session session = super.getSession();
		SQLQuery query=session.createSQLQuery(sql);   
		List<Object> os = query.list();
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		for (int i = 0; i < os.size(); i++) {
			Object[] o= (Object[]) os.get(i);
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("dataid", o[0]);
			map.put("dataname", o[1]);
			map.put("ipaddress", o[2]);
			map.put("port", o[3]);
			map.put("testurl", o[4]);
			map.put("retmsg", o[5]);
			map.put("loginurl", o[6]);
			map.put("period", o[7]);
			map.put("overtime", o[8]);
			map.put("lastdate", o[9].toString());
			map.put("status", o[10]);
			list.add(map);
		}
		return list;
	}
}




