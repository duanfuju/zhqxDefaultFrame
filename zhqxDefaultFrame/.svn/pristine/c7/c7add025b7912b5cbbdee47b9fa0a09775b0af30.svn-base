package cn.com.oking.waterMonitoring.action;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import com.bstek.dorado.annotation.DataProvider;

import cn.com.oking.entity.TJsObtMinRain;
import cn.com.oking.entity.WaterData;
import cn.com.oking.util.StringUtil;
import cn.com.oking.waterMonitoring.dao.TJsObtMinRainDao;
import cn.com.oking.waterMonitoring.dao.WaterDataDao;

@Component			
public class WaterDataAction {
	@Resource
	private WaterDataDao dao;
	@Resource
	private TJsObtMinRainDao tdao;
	@Resource(name = "jdbcsqlserver")
	private JdbcTemplate jdbcsqlserver;
	
	@Transactional
	@DataProvider
	public List<Map<String, Object>> getData2(String obtid){
		if (!StringUtil.isNotEmpty(obtid)) {
			obtid="M6713";
		}//数据分析界面的数据提供
		List<TJsObtMinRain> ls=tdao.findByObtid(obtid);
		List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
		for (int i = 0; i < ls.size(); i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			TJsObtMinRain tj=ls.get(i);
			map.put("ddatetime",tj.getDdatetime());
			map.put("hour1r",tj.getHour1r());
			list.add(map);
		}
		return list;
	}
	
	@Transactional
	@DataProvider
	public List<Map<String, Object>> getData1(String siteid){
		if (!StringUtil.isNotEmpty(siteid)) {
			siteid="1";
		}//数据分析界面的数据提供
		List<WaterData> ls=dao.findBySiteid(siteid);
		List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
		for (int i = 0; i < ls.size(); i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			WaterData wd=ls.get(i);
			map.put("wdResults",wd.getWdResults());
			map.put("wdDate",wd.getWdDate());
			list.add(map);
		}
		return list;
	}
	@Transactional
	@DataProvider
	public List<Map<String, Object>> getData(String siteid){
		if (!StringUtil.isNotEmpty(siteid)) {
			siteid="1";
		}
		List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
		//当前积水深度
		Map<String, Object> map1 = new HashMap<String, Object>();
		WaterData current=dao.findByCurrent(siteid);		
		map1.put("wdResults",current.getWdResults());
		map1.put("wdDate",new Date());
		map1.put("wdId", "current");
		list.add(map1);
		return list;
	}
	@Transactional
	@DataProvider
	public List<Map<String, Object>> getData3(String siteid){
		if (!StringUtil.isNotEmpty(siteid)) {
			siteid="1";
		}
		List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
		//1个月的最大积水深度
		Map<String, Object> map2 = new HashMap<String, Object>();
		Map<String, Object> month=dao.findByTimeWithObject(siteid, "30");
		map2.put("wdDate",month.get("wd_date"));
		map2.put("wdResults",month.get("wd_results"));
		map2.put("wdId", "month");
		list.add(map2);
		//一个季度最大积水深度
		Map<String, Object> map3 = new HashMap<String, Object>();
		Map<String, Object> quarter=dao.findByTimeWithObject(siteid, "90");
		map3.put("wdDate",quarter.get("wd_date"));
		map3.put("wdResults",quarter.get("wd_results"));
		map3.put("wdId", "quarter");
		list.add(map3);
		//一年最大积水深度
		Map<String, Object> map4 = new HashMap<String, Object>();
		Map<String, Object> year=dao.findByTimeWithObject(siteid, "365");
		map4.put("wdDate",year.get("wd_date"));
		map4.put("wdResults",year.get("wd_results"));
		map4.put("wdId", "year");
		list.add(map4);
		
		//历史最大积水深度
		Map<String, Object> map5 = new HashMap<String, Object>();
		Map<String, Object> max=dao.findMax(siteid);
		map5.put("wdDate",year.get("wd_date"));
		map5.put("wdResults",year.get("wd_results"));
		map5.put("wdId", "max");
		list.add(map5);
		return list;
	}
	
	
	
	 	/*sqlserver数据库*/
	 	@DataProvider		
		@Transactional
		public List<Map<String, Object>> findByStartDateAndEndDate(Map<String, Object> params){
			String sdate;
			String edate;
			String	siteid="";
			String sql="";
			List<Map<String, Object>> list=null;
			try {
				if (params.containsKey("siteid")) {
					siteid=params.get("siteid").toString();
					if (params.containsKey("sdate")) {
						sdate=params.get("sdate").toString();
						edate=params.get("edate").toString();
						sql="select CONVERT(varchar(100),tm,120)tm,rz from ST_RTU80SWFB_RSVR_H where stcd='"+siteid+"' and tm > '"+sdate+"' and tm< '"+edate+"' order by TM desc";
					}else{
						sql="select CONVERT(varchar(100),tm,120)tm,rz from ST_RTU80SWFB_RSVR_H where stcd='"+siteid+"' order by TM desc";
					}
				}
				list=jdbcsqlserver.queryForList(sql);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			return list;
		}

	 	
	 	
	 	
	 	/*oracle数据库
		public void findByStartDateAndEndDate(Page<WaterData> page,Map<String, Object> params){
			Date sdate;
			Date edate;
			String	siteid="";
			try {
				if (params.containsKey("siteid")) {
					siteid=params.get("siteid").toString();
					if (params.containsKey("sdate")) {
						SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
						sdate=sdf.parse(params.get("sdate").toString());
						edate=sdf.parse(params.get("edate").toString());
						String hql="from WaterData where siteid='"+siteid+"' and wdDate > ? and wdDate< ?";
						dao.find(page,hql,new Object[]{sdate,edate});
					}else{
						dao.find(page,"from WaterData where siteid='"+siteid+"'");
					}
				}
			} catch (ParseException e) {
				dao.find(page,"from WaterData");
				e.printStackTrace();
			}
		}*/
}
