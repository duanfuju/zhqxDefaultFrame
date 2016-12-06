package cn.com.oking.meeting.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.com.oking.meeting.dao.meetingListDao;
import cn.com.oking.meeting.entity.*;
import cn.com.oking.meeting.util.integrationUtil;
import cn.com.oking.util.ConfigUtil;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;


@Component
public class meetingListAction {


	/***********
	 * 未结束或未开始的会议
	 * @param obj
	 * @return
	 ****/
	// meetingListAction#getMeetingSumList
	@DataProvider
	public Collection<meetingEntity> getMeetingSumList(Map<String,Object> obj){
		Collection<meetingEntity> tl = null;
		try{
			String xmlStr = "";			
			//xmlStr = integrationUtil.getMeetingSumList("http://218.2.99.67/integration/xml","admin","admin","2015-05-01T00:00:01","2015-06-20T00:00:01");
			xmlStr = integrationUtil.getMeetingSumList(ConfigUtil.getValue("meeting_strUrl"),
														ConfigUtil.getValue("meeting_userName"),
														ConfigUtil.getValue("meeting_password"),"2015-05-01T00:00:01","2095-06-20T00:00:01");
			tl = new ArrayList<meetingEntity>();
			meetingListDao meetingDao = new meetingListDao();;
			tl = meetingDao.getMeetingSumList(xmlStr);       
		}catch(Exception e){
				e.printStackTrace();
		}
		return tl;
	}
	
	

	/***********
	 * 未结束或未开始的会议
	 * @param obj
	 * @return
	 ****/
	// meetingListAction#getMeetingPrivateList
	@DataProvider
	public Collection<meetingEntity> getMeetingPrivateList(Map<String,Object> obj){
		Collection<meetingEntity> tl = null;
		try{
			String xmlStr = "";			
//			xmlStr = integrationUtil.getMeetingPrivateList("http://218.2.99.67/integration/xml","admin","admin");
			xmlStr = integrationUtil.getMeetingPrivateList(ConfigUtil.getValue("meeting_strUrl"),
															ConfigUtil.getValue("meeting_userName"),
															ConfigUtil.getValue("meeting_password"));
			tl = new ArrayList<meetingEntity>();
			meetingListDao meetingDao = new meetingListDao();;
			tl = meetingDao.getMeetingPrivateList(xmlStr);       
		}catch(Exception e){
				e.printStackTrace();
		}
		return tl;
	}
	
	
	/*************
	 * 历史会议列表
	 * @param obj
	 * @return
	 */
	// meetingListAction#getMeetingHisList
	@DataProvider
	public Collection<meetingEntity> getMeetingHisList(Map<String,Object> obj){
		Collection<meetingEntity> tl = null;
		try{
			String xmlStr = "";			
			//xmlStr = integrationUtil.getMeetingHisList("http://218.2.99.67/integration/xml","admin","admin","0","1000","true","2015-05-01T00:00:01","2015-05-20T00:00:01");
			xmlStr = integrationUtil.getMeetingHisList(ConfigUtil.getValue("meeting_strUrl"),
														ConfigUtil.getValue("meeting_userName"),
														ConfigUtil.getValue("meeting_password"),"0","1000","true","2015-05-01T00:00:01","2095-05-20T00:00:01");
			tl = new ArrayList<meetingEntity>();
			meetingListDao meetingDao = new meetingListDao();;
			tl = meetingDao.getMeetingHisList(xmlStr);       
		}catch(Exception e){
				e.printStackTrace();
		}
		return tl;
	}
	
	
	
	// meetingListAction#startMeeting
	@DataResolver
	@Transactional
	public String startMeeting(meetingEntity entity){
		meetingListDao mlDao = new meetingListDao();
		String xmlStr = "";	
		String confKey = "";
		String xmlTocken = "";
		String tocken = "";
		try{			
			//获得confKey
			confKey = entity.getConfKey();
			//根据confKey调用“获得加入会议接口 joinMeeting”，返回xmlTocken	
			if(!confKey.equals("null")&&!confKey.equals("")){
//				xmlTocken = integrationUtil.getStartMeetingToken("admin","admin","admin","管理员",confKey,"","a@b.com","http://218.2.99.67");	
				xmlTocken = integrationUtil.getStartMeetingToken(ConfigUtil.getValue("meeting_userName"),
																	ConfigUtil.getValue("meeting_password"),"admin","管理员",confKey,"admin","a@b.com",
																	ConfigUtil.getValue("meeting_webBaseUrl"));	
				System.out.println("xmlTocken========" + xmlTocken);
			}
			//解析加入会议XML，得到加入会议token，ciURL
			if(!xmlTocken.equals("") &&!"F".equals(xmlTocken.substring(1)))
				tocken = mlDao.getStartMeetingToken(xmlTocken);	
			//提交到接口地址，启动会议客户端
			if(tocken.equals("") &&"F".equals(tocken.substring(1)))
				tocken = "FFAILURE";					     
		}catch(Exception e){
				e.printStackTrace();
		}
		
		return tocken;
	}
	
	
	// meetingListAction#joinMeeting
	@DataResolver
	@Transactional
	public String joinMeeting(meetingEntity entity){
		meetingListDao mlDao = new meetingListDao();
		String xmlStr = "";	
		String confKey = "";
		String xmlTocken = "";
		String tocken = "";
		try{
			
			//获得confKey
			confKey = entity.getConfKey();
			//根据confKey调用“获得加入会议接口 joinMeeting”，返回xmlTocken	
			if(!confKey.equals("null")&&!confKey.equals("")){
				//xmlTocken = integrationUtil.getJoinMeetingToken("admin","admin",confKey,"","a@b.com","http://218.2.99.67");	
				xmlTocken = integrationUtil.getJoinMeetingToken(ConfigUtil.getValue("meeting_userName"),							
																ConfigUtil.getValue("meeting_password"),confKey,"admin","a@b.com",
																ConfigUtil.getValue("meeting_webBaseUrl"));	
				System.out.println("xmlTocken========" + xmlTocken);
			}
			//解析加入会议XML，得到加入会议token，ciURL
			if(!xmlTocken.equals("") &&!"F".equals(xmlTocken.substring(1)))
				tocken = mlDao.getJoinMeetingToken(xmlTocken);	
			//提交到接口地址，启动会议客户端
			if(tocken.equals("") &&"F".equals(tocken.substring(1)))
				tocken = "FFAILURE";					     
		}catch(Exception e){
				e.printStackTrace();
		}
		
		return tocken;
	}
}
