package cn.com.oking.meeting.util;

import java.io.*;
import java.net.HttpURLConnection;    
import java.net.URL;    
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.HashMap;    
import java.util.Iterator;    
import java.util.Map;    
import java.util.Map.Entry; 

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import cn.com.oking.meeting.entity.FixedMeetingEntity;
import cn.com.oking.meeting.entity.ReserveMeetingEntity;


public class integrationUtil {    
     static String strUrl = "http://218.2.99.67/integration/xml";
  
        
    public static String send(String urlAddr, String sendData) throws Exception {    
    	HttpURLConnection conn = null;     
        boolean isSuccess = false; 

        StringBuffer sb=new StringBuffer("");
            StringBuffer params = new StringBuffer();    
   
            params.append(sendData);
            
            try{    
                URL url = new URL(urlAddr);    
                conn = (HttpURLConnection)url.openConnection();    
   
                conn.setDoOutput(true);    
                conn.setRequestMethod("POST");    
                conn.setUseCaches(false);    
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");    
                conn.setRequestProperty("Content-Length", String.valueOf(params.length()));    
                conn.setDoInput(true);    
                conn.connect();    
   
                OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");    
                out.write(params.toString());    
                out.flush();    
                out.close();    
            
                int code = conn.getResponseCode();
                if (code != 200) {    
                	System.out.println("ERROR===" + code);    
                } else {    
                isSuccess = true;    
                //System.out.println(conn.getContentType());
                BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));

     		   	String s="";
     		   	
     		   	while((s=br.readLine())!=null)
     		   	{     
     		   		sb.append(s+"\r\n");    
     		   	}
     		   		br.close();
     		   
               
            }    
        }catch(Exception ex){   
        	System.out.println("SendPostMessage is error");
            ex.printStackTrace();    
        }finally{    
            conn.disconnect();    
        }    
        return sb.toString();  
    } 
    
    /***********
     * 获取未执行的会议列表
     * @param strUrl
     * @param userName
     * @param password
     * @param startDate
     * @param endDate
     * @return
     */
    public static String getMeetingSumList(String strUrl,String userName,String password,String startDate,String endDate)
    {
    	String result = "";
    	try
		{
    		integrationUtil sp = new integrationUtil();
			
			String url = strUrl;
			String strXML = "<?xml version='1.0' encoding='UTF-8'?>";
	        strXML += "<Message><header>";
	        strXML += "<action>" + "listSummaryMeeting" + "</action>";
	        strXML += "<service>" + "meeting" + "</service>";
	        strXML += "<type>" + "xml" + "</type>";
	        strXML += "<userName>" + userName + "</userName>";
	        strXML += "<password>" + password + "</password>";
	        strXML += "<version>50</version>";
	        strXML += "</header>";
	        //body开始
	        strXML += "<body>";
	        strXML += "<startDateStart>" + startDate + "</startDateStart>";
	        strXML += "<startDateEnd>" + endDate + "</startDateEnd>";
	        strXML += "<timeZoneId>" + "45" + "</timeZoneId>";
	        strXML += "</body>";
	        strXML += "</Message>";
			
			result = sp.send(url,strXML);
        }
    	catch(Exception e){
			System.out.println(e.toString());
    	}
    	
    	return result;
    }
    
    /***********
     * 获取我安排的会议列表
     * @param strUrl
     * @param userName
     * @param password
     * @param startDate
     * @param endDate
     * @return
     */
    public static String getMeetingPrivateList(String strUrl,String userName,String password)
    {
    	String result = "";
    	try
		{
    		integrationUtil sp = new integrationUtil();
			
			String url = strUrl;
			String strXML = "<?xml version='1.0' encoding='UTF-8'?>";
	        strXML += "<Message><header>";
	        strXML += "<action>" + "listSummaryMeeting" + "</action>";
	        strXML += "<service>" + "meeting" + "</service>";
	        strXML += "<type>" + "xml" + "</type>";
	        strXML += "<userName>" + userName + "</userName>";
	        strXML += "<password>" + password + "</password>";
	        strXML += "<version>50</version>";
	        strXML += "</header>";
	        //body开始
	        strXML += "<body>";
	        strXML += "<timeZoneId>" + "45" + "</timeZoneId>";
	        strXML += "</body>";
	        strXML += "</Message>";
			
			result = sp.send(url,strXML);
        }
    	catch(Exception e){
			System.out.println(e.toString());
    	}
    	
    	return result;
    }
    
    
    /***********
     * 获取历史会议列表
     * @param strUrl
     * @param userName
     * @param password
     * @param startDate
     * @param endDate
     * @return
     */
    public static String getMeetingHisList(String strUrl,String userName,String password,String startFrom,String maxNum,String openType,String startTime,String endTime)
    {
    	String result = "";
    	try
		{
    		integrationUtil sp = new integrationUtil();
			
			String url = strUrl;
			System.out.println("getMeetingListurl=====" + url);
			String strXML = "<?xml version='1.0' encoding='UTF-8'?>";
	        strXML += "<Message><header>";
	        strXML += "<action>" + "listHistoryMeeting" + "</action>";
	        strXML += "<service>" + "meeting" + "</service>";
	        strXML += "<type>" + "xml" + "</type>";
	        strXML += "<userName>admin</userName>";
	        strXML += "<password>admin</password>";
	        strXML += "<version>50</version>";
	        strXML += "</header>";
	        //body开始
	        strXML += "<body>";
	        strXML += "<startFrom>" + startFrom + "</startFrom>";
	        strXML += "<maximumNum>" + maxNum + "</maximumNum>";
	        strXML += "<openType>" + openType + "</openType>";
	        strXML += "<startTime>" + startTime + "</startTime>";
	        strXML += "<endTime>" + endTime + "</endTime>";
	        strXML += "</body>";
	        strXML += "</Message>";
			
	        result =  sp.send(url,strXML);
        }
    	catch(Exception e){
			System.out.println(e.toString());
    	}
    	
    	return result;
    }
    
    
    /***********
     * 获取未执行的会议列表
     * @param strUrl
     * @param userName
     * @param password
     * @param startDate
     * @param endDate
     * @return
     */
    public static String getLiveSumList(String strUrl,String userName,String password,String startDate,String endDate)
    {
    	String result = "";
    	try
		{
    		integrationUtil sp = new integrationUtil();
			
			String url = strUrl;
			String strXML = "<?xml version='1.0' encoding='UTF-8'?>";
	        strXML += "<Message><header>";
	        strXML += "<action>" + "listSummaryMeeting" + "</action>";
	        strXML += "<service>" + "live" + "</service>";
	        strXML += "<type>" + "xml" + "</type>";
	        strXML += "<userName>" + userName + "</userName>";
	        strXML += "<password>" + password + "</password>";
	        strXML += "<version>50</version>";
	        strXML += "</header>";
	        //body开始
	        strXML += "<body>";
	        strXML += "<startDateStart>" + startDate + "</startDateStart>";
	        strXML += "<startDateEnd>" + endDate + "</startDateEnd>";
	        strXML += "<timeZoneId>" + "45" + "</timeZoneId>";
	        strXML += "</body>";
	        strXML += "</Message>";
			
			result = sp.send(url,strXML);
        }
    	catch(Exception e){
			System.out.println(e.toString());
    	}
    	
    	return result;
    }
    
 
    /****************
     * 获取启动会议信息
     * @param hostName
     * @param displayName
     * @param confKey
     * @param meetingPwd
     * @param meetingEmail
     * @param webBaseUrl
     * @return
     */
    public static String getStartMeetingToken(String userName,String passwd,String hostName,String displayName,String confKey,String meetingPwd,String meetingEmail,String webBaseUrl)
    {
    	String result = "";
    	try
		{
    		integrationUtil sp = new integrationUtil();
			
			String url = strUrl;
			
			String xmlStr="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"+
			"<Message>"+
			"<header>"+
			"<action>startMeeting</action>"+
			"<service>meeting</service>"+
			"<type>xml</type>"+
			"<siteName>box</siteName>"+
			"<userName>" + userName + "</userName>"+
			"<password>" + passwd + "</password>"+
			"<version>50</version>"+
			"</header>"+

			"<body>"+
			"<hostName>"+hostName+"</hostName>"+
			"<displayName>"+displayName+"</displayName>"+
			"<confKey>"+confKey+"</confKey>"+
			"<meetingPwd>"+meetingPwd+"</meetingPwd>"+
			"<email>"+meetingEmail+"</email>"+
			"<webBaseUrl>"+webBaseUrl+"</webBaseUrl>"+
			"</body>"+
			"</Message>";

			result = sp.send(url,xmlStr);
			
        }
    	catch(Exception e){
			System.out.println(e.toString());
    	}
    	
    	return result;
    }

	/************
	 * 获取加入会议的信息
	 * @param attendeeName
	 * @param displayName
	 * @param confKey
	 * @param meetingPwd
	 * @param meetingEmail
	 * @param webBaseUrl
	 * @return
	 */
    public static String getJoinMeetingToken(String attendeeName ,String displayName,String confKey,String meetingPwd,String meetingEmail,String webBaseUrl)
    {
    	String result = "";
    	try
		{
    		integrationUtil sp = new integrationUtil();
			
			String url = strUrl;
			
			String xmlStr="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"+
			"<Message>"+
			"<header>"+
			"<action>joinMeeting</action>"+
			"<service>meeting</service>"+
			"<type>xml</type>"+
			"<userName>admin</userName>"+
			"<password>admin</password>"+
			"<version>50</version>"+
			"</header>"+

			"<body>"+
			"<attendeeName>"+attendeeName+"</attendeeName>"+
			"<confKey>"+confKey+"</confKey>"+
			"<meetingPwd>"+meetingPwd+"</meetingPwd>"+
			"<email>"+meetingEmail+"</email>"+
			"<webBaseUrl>"+webBaseUrl+"</webBaseUrl>"+
			"</body>"+
			"</Message>";

			result = sp.send(url,xmlStr);
			
        }
    	catch(Exception e){
			System.out.println(e.toString());
    	}
    	
    	return result;
    }
    
    
    /****************
     * 获取启动直播信息
     * @param hostName
     * @param displayName
     * @param confKey
     * @param meetingPwd
     * @param meetingEmail
     * @param webBaseUrl
     * @return
     */
    public static String getStartLiveToken(String userName,String passwd,String hostName,String displayName,String confKey,String meetingPwd,String meetingEmail,String webBaseUrl)
    {
    	String result = "";
    	try
		{
    		integrationUtil sp = new integrationUtil();
			
			String url = strUrl;
			
			String xmlStr="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"+
			"<Message>"+
			"<header>"+
			"<action>startMeeting</action>"+
			"<service>live</service>"+
			"<type>xml</type>"+
			"<siteName>box</siteName>"+
			"<userName>" + userName + "</userName>"+
			"<password>" + passwd + "</password>"+
			"<version>50</version>"+
			"</header>"+

			"<body>"+
			"<hostName>"+hostName+"</hostName>"+
			"<displayName>"+displayName+"</displayName>"+
			"<confKey>"+confKey+"</confKey>"+
			"<meetingPwd>"+meetingPwd+"</meetingPwd>"+
			"<email>"+meetingEmail+"</email>"+
			"<webBaseUrl>"+webBaseUrl+"</webBaseUrl>"+
			"</body>"+
			"</Message>";

			result = sp.send(url,xmlStr);
			
        }
    	catch(Exception e){
			System.out.println(e.toString());
    	}
    	
    	return result;
    }
    
	/************
	 * 获取加入直播的信息---嘉宾
	 * @param attendeeName
	 * @param displayName
	 * @param confKey
	 * @param meetingPwd
	 * @param meetingEmail
	 * @param webBaseUrl
	 * @return
	 */
    public static String getJoinLiveToken(String userName,String password,String attendeeName ,String displayName,String confKey,String meetingPwd,String meetingEmail,String webBaseUrl)
    {
    	String result = "";
    	try
		{
    		integrationUtil sp = new integrationUtil();
			
			String url = strUrl;
			
			String xmlStr="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"+
			"<Message>"+
			"<header>"+
			"<action>joinMeeting</action>"+
			"<service>live</service>"+
			"<type>xml</type>"+
			"<siteName>box</siteName>"+
			"<userName>"+userName+"</userName>"+
			"<password>"+password+"</password>"+
			"<version>50</version>"+
			"</header>"+

			"<body>"+
			"<attendeeName>"+attendeeName+"</attendeeName>"+
			"<confKey>"+confKey+"</confKey>"+
			"<meetingPwd>"+meetingPwd+"</meetingPwd>"+
			"<email>"+meetingEmail+"</email>"+
			"<webBaseUrl>"+webBaseUrl+"</webBaseUrl>"+
			"</body>"+
			"</Message>";

			result = sp.send(url,xmlStr);
			
        }
    	catch(Exception e){
			System.out.println(e.toString());
    	}
    	
    	return result;
    }
    
    /***********
     * 创建预约会议
     * @return
     */
    public static String createReserveMeeting(String strUrl,String userName,String password,String webBaseUrl,String meetingPsw,ReserveMeetingEntity rmEntity)
    {
    	String result = "";
    	try
		{
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		
    		GregorianCalendar cal = new GregorianCalendar();  
    		
    		cal.setTime(rmEntity.getStartTime());
    		cal.add(10, -8);
    		String st = sdf.format(cal.getTime()).replace(" ", "T");
    		
    		cal.setTime(rmEntity.getEndTime());
    		cal.add(10, -8);
    		String et = sdf.format(cal.getTime()).replace(" ", "T");
    		
    		integrationUtil sp = new integrationUtil();
    		
    		
			String url = strUrl;
			String strXML = "<?xml version='1.0' encoding='UTF-8'?>";
	        strXML += "<Message><header>";
	        strXML += "<action>" + "createReserveMeeting" + "</action>";
	        strXML += "<service>" + "meeting" + "</service>";
	        strXML += "<type>" + "xml" + "</type>";
	        strXML += "<userName>" + userName + "</userName>";
	        strXML += "<password>" + password + "</password>";
	        strXML += "<version>50</version>";
	        strXML += "</header>";
	        //body开始
	        strXML += "<body>";
	        strXML += "<subject>" + rmEntity.getSubject() + "</subject>";
	        strXML += "<startTime>" + st + "</startTime>";
	        strXML += "<endTime>" + et + "</endTime>";
	        strXML += "<timeZoneId>" + "45" + "</timeZoneId>";
	        strXML += "<attendeeAmount>" + rmEntity.getAttendeeAmount() + "</attendeeAmount>";
	        strXML += "<hostName>" + rmEntity.getHostName() + "</hostName>";
	        strXML += "<creator>" + userName + "</creator>";
	        strXML += "<openType>" + rmEntity.getOpenType() + "</openType>";
	        strXML += "<passwd>" + meetingPsw + "</passwd>";
	        strXML += "<conferencePattern>" + rmEntity.getConferencePattern() + "</conferencePattern>";
	        strXML += "<mailTemplateLocal>" + "zh_CN" + "</mailTemplateLocal>";
	        strXML += "<webBaseUrl>" + webBaseUrl + "</webBaseUrl>";
	        strXML += "</body>";
	        strXML += "</Message>";
			
			result = sp.send(url,strXML);
        }
    	catch(Exception e){
			System.out.println(e.toString());
    	}
    	
    	return result;
    }
    
    /***********
     * 创建固定会议
     * @return
     */
    public static String createFixedMeeting(String strUrl,String userName,String password,String webBaseUrl,String meetingPsw,FixedMeetingEntity fmEntity)
    {
    	String result = "";
    	//String pswd = fmEntity.getPasswd()==null?"":fmEntity.getPasswd();
    	try
		{
    		integrationUtil sp = new integrationUtil();
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		
    		GregorianCalendar cal = new GregorianCalendar();  
    		
    		cal.setTime(fmEntity.getStartTime());
    		cal.add(10, -8);
    		String st = sdf.format(cal.getTime()).replace(" ", "T");
    		
    		cal.setTime(fmEntity.getEndTime());
    		cal.add(10, -8);
    		String et = sdf.format(cal.getTime()).replace(" ", "T");
    		
			String url = strUrl;
			String strXML = "<?xml version='1.0' encoding='UTF-8'?>";
	        strXML += "<Message><header>";
	        strXML += "<action>" + "createFixedMeeting" + "</action>";
	        strXML += "<service>" + "meeting" + "</service>";
	        strXML += "<type>" + "xml" + "</type>";
	        strXML += "<userName>" + userName + "</userName>";
	        strXML += "<password>" + password + "</password>";
	        strXML += "<version>50</version>";
	        strXML += "</header>";
	        //body开始
	        strXML += "<body>";
	        strXML += "<subject>" + fmEntity.getSubject() + "</subject>";
	        strXML += "<startTime>" + st + "</startTime>";
	        strXML += "<endTime>" + et + "</endTime>";
	        strXML += "<timeZoneId>" + "45" + "</timeZoneId>";
	        strXML += "<attendeeAmount>" + fmEntity.getAttendeeAmount() + "</attendeeAmount>";
	        strXML += "<hostName>" + fmEntity.getHostName() + "</hostName>";
	        strXML += "<creator>" + userName + "</creator>";
	        strXML += "<openType>" + fmEntity.getOpenType() + "</openType>";
	        strXML += "<passwd>" + meetingPsw + "</passwd>";
	        strXML += "<conferencePattern>" + fmEntity.getConferencePattern() + "</conferencePattern>";
	        strXML += "<mailTemplateLocal>" + "zh_CN" + "</mailTemplateLocal>";
	        strXML += "<beforehandTime>"+fmEntity.getBeforehandTime()+"</beforehandTime>";
	        strXML += "<webBaseUrl>" + webBaseUrl + "</webBaseUrl>";
	        strXML += "</body>";
	        strXML += "</Message>";
			
			result = sp.send(url,strXML);
        }
    	catch(Exception e){
			System.out.println(e.toString());
    	}
    	
    	return result;
    }

    public static String eliminateXMLHead(String xml)
	{
		String srcEx="<\\?(.*)\\?>";
		return xml.replaceAll(srcEx, "");
	}    
    
    public static void main(String[] args) throws UnsupportedEncodingException {

    	// 58.49.53.10 换成会议服务器的访问地址
    	//(String userName,String passwd,String hostName,String displayName,String confKey,String meetingPwd,String meetingEmail,String webBaseUrl)
    	String meetingTocken = integrationUtil.getStartMeetingToken("admin","admin","admin","管理员","62202629","","","http://218.2.99.67");
    	//String meetingList = integrationUtil.getMeetingHisList("http://218.2.99.67/integration/xml","admin","admin","0","1000","true","2015-05-01T00:00:01","2015-05-11T00:00:01");
    	//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
    	//java.util.Date date=new java.util.Date();  
    	//String str=sdf.format(date).replace(" ", "T");

    	System.out.println(meetingTocken);
    	
    	
  }
}
