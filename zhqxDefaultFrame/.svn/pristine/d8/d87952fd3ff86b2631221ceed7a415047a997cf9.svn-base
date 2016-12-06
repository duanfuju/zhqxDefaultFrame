package net.fenet.dorado.bd;

import com.bstek.dorado.data.db.DBStatement;
import com.bstek.dorado.utils.variant.VariantSet;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class tq
{
  public static List getTQ(String name)
    throws Exception
  {
    String sql = "SELECT *from (select *from pub_svc.weather_live_info where station_name='" + name + "'  order by OBSERV_TIMES desc )  where rownum=1 order by OBSERV_TIMES desc";
    DBStatement dbs = new DBStatement();
    dbs.setSql(sql);
    List list = dbs.queryForList();
    return list;
  }

  public static String getWzlist() throws Exception {
	    String sql = "select * from (select  to_char(substr(wz.wznr,1,1000)) nr,wz.fbsj rq,rownum from pkwz.wz_wz wz where wz.sslmbh='12' order by wz.fbsj desc) where rownum=1";
	    DBStatement dbs = new DBStatement();
	    dbs.setSql(sql);
	    List list = dbs.queryForList();
	    String json = "";
	    for (int i = 0; i < list.size(); i++) {
	      VariantSet v = (VariantSet)list.get(i);
	      String nr = v.getString("nr");
	      String rq = v.getString("rq");
	      json = "{\"wznr\":\"" + nr + "\",\"fbsj\":\"" + rq + "\"}";
	    }
	    json = "[" + json + "]";
	    return json;
	  }
  
  public static String getlist(String id) throws Exception {
    String sql = "SELECT *from (select *from pub_svc.weather_live_info where station_num='" + id + "'  order by OBSERV_TIMES desc )  where rownum=1 order by OBSERV_TIMES desc";
    DBStatement dbs = new DBStatement();
    dbs.setSql(sql);
    List list = dbs.queryForList();
    String json = "";
    for (int i = 0; i < list.size(); i++) {
      VariantSet v = (VariantSet)list.get(i);
      String stationid = v.getString("station_num");
      String js24 = v.getString("autoprecipamount");
      String temp = v.getString("drybulb_temp");
      String wind = v.getString("maxwind_d10ms");
      String windsd = v.getString("maxwind_v_2");
      String time = v.getString("observ_times");
      String sd = v.getString("rel_humidity");
      String name = v.getString("station_name");
      String hourr = v.getString("hourr");
      json = json + "{\"stationid\":\"" + stationid + "\",\"js24\":\"" + js24 + "\",\"temp\":\"" + temp + "\",\"wind\":\"" + wind + "\",\"windsd\":\"" + windsd + "\",\"time\":\"" + time + "\",\"sd\":\"" + sd + "\",\"name\":\"" + name + "\",\"hourr\":\"" + hourr + "\"},";
    }
    json = json.substring(0, json.length() - 1);
    json = "[" + json + "]";
    return json;
  }
  /**
   * 测试
   * @param args
   */
  	public static void main(String[] args) {
  		String datetime="2013-10-17%2020";
  		 datetime = datetime.replace("%20", " ");
  		String s[]=datetime.split("-");
		int s_i[]=new int[5];
		for (int i = 0; i < s.length-1; i++) {
			s_i[i]=Integer.valueOf(s[i]);
		}
		//年：s_i[0]   月：s_i[1]	日：d_i[0]	时：d_i[1]
		if (s_i[0]>=2016) {
			System.out.println( "超出时间范围");
		}
  		
	}

 
  public static String getListByHour(String id,String datetime) throws Exception {
	  String error="";
	  String json = "";
	  String stationname="";
	  //String bj_datetime="";
	  String hour24R="";
	  String MAXT="";
	  String VVP1M="";
	  String WD10DD="";
	  String WD10DF="";
	  //浏览器会将空格转换成%20
	  datetime = datetime.replace("%20", " ");
	  //判断datetime的格式是否正确
	  String el="^\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}";
	  Pattern p = Pattern.compile(el);    
      Matcher m = p.matcher(datetime);    
      if(m.matches()){
    	//判断datetime的是否超出时间范围 2016.01.01 01		超出则返回字符串 	"超出时间范围"
    	String s[]=datetime.split("-");
  		int s_i[]=new int[5];
  		for (int i = 0; i < s.length-1; i++) {
  			s_i[i]=Integer.valueOf(s[i]);
  		}
  		if (s_i[0]<2016) {
  			return "超出时间范围";
  		}
		//判断自动站是否存在，不存在则返回字符串"自动站不存在"
  		
    	String sql_station="select * from pub_svc.weather_station s where s.station_num='"+id+"'";	
    	DBStatement dbs = new DBStatement();
 	    dbs.setSql(sql_station);
 	    try {
			List list = dbs.queryForList();
			if (list.size()==0) {
				return "自动站不存在!!!";
			}
			for (int i = 0; i < list.size(); i++) {
			      VariantSet v = (VariantSet)list.get(i);
			      stationname = v.getString("station_name");
			      error+="stationname:"+stationname;
			}
			//查询雨量的
			String sql_rain="select obtid,bj_datetime,hour24R from pub_svc.t_js_obt_hour_rain  where bj_datetime= to_date('"+datetime+":00:00','yyyy-mm-dd hh24:mi:ss') and obtid='"+id+"'";
			dbs = new DBStatement();
			dbs.setSql(sql_rain);
			System.out.println(dbs.getSql());
			List list_rain = dbs.queryForList();
			for (int i = 0; i < list_rain.size(); i++) {
			      VariantSet v = (VariantSet)list_rain.get(i);
			      hour24R = v.getString("hour24R");
			      //bj_datetime = v.getString("bj_datetime");
			      error+=",hour24R:"+hour24R;
			}
			//查询温度的
			String sql_temp="SELECT OBTID,BJ_DATETIME,MAXT FROM pub_svc.T_JS_OBT_HOUR_TEMP  where bj_datetime= to_date('"+datetime+":00:00','yyyy-mm-dd hh24:mi:ss') and obtid='"+id+"'";
			dbs = new DBStatement();
			dbs.setSql(sql_temp);
			System.out.println(dbs.getSql());
			List list_temp = dbs.queryForList();
			for (int i = 0; i < list_temp.size(); i++) {
			      VariantSet v = (VariantSet)list_temp.get(i);
			      MAXT = v.getString("MAXT");
			      error+=",MAXT:"+MAXT;
			}
			//查询能见度的
			String sql_cloud="SELECT OBTID,BJ_DATETIME,VVP1M FROM pub_svc.T_JS_OBT_HOUR_CLOUD where bj_datetime= to_date('"+datetime+":00:00','yyyy-mm-dd hh24:mi:ss') and obtid='"+id+"'";
			dbs = new DBStatement();
			dbs.setSql(sql_cloud);
			System.out.println(dbs.getSql());
			List list_cloud = dbs.queryForList();
			for (int i = 0; i <list_cloud.size(); i++) {
			      VariantSet v = (VariantSet)list_cloud.get(i);
			      VVP1M = v.getString("VVP1M");
			      error+=",error:"+error;
			}
			//查询风速的
			String sql_wind="SELECT OBTID,BJ_DATETIME,WD10DD,WD10DF FROM pub_svc.T_JS_OBT_HOUR_WIND  where bj_datetime= to_date('"+datetime+":00:00','yyyy-mm-dd hh24:mi:ss') and obtid='"+id+"'";
			dbs = new DBStatement();
			dbs.setSql(sql_wind);
			System.out.println(dbs.getSql());
			List list_wind = dbs.queryForList();
			for (int i = 0; i < list_wind.size(); i++) {
			      VariantSet v = (VariantSet)list_wind.get(i);
			      WD10DD = v.getString("WD10DD");
			      WD10DF = v.getString("WD10DF");
			      error+=",WD10DD:"+WD10DD+",WD10DF:"+WD10DF;
			}
			
			json = "[{\"stationid\":\"" + id + "\",\"stationname\":\"" + stationname 
					+ "\",\"bj_datetime\":\"" + datetime + "\",\"hour24R\":\"" + hour24R 
					+ "\",\"MAXT\":\"" + MAXT + "\",\"VVP1M\":\"" + VVP1M 
					+ "\",\"WD10DD\":\"" + WD10DD + "\",\"WD10DF\":\"" + WD10DF + "\"}]";
		    return json;
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return "有错误!!!"+error;
		}
      }else{   
          return "日期格式错误";
      }   
	}
  
  
  
  
  
  
  
}