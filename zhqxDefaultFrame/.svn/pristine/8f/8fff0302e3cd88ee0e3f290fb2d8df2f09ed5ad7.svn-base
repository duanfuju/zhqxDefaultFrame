package cn.com.oking.meeting.action;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.com.oking.meeting.dao.FixedMeetingDao;
import cn.com.oking.meeting.entity.*;
import cn.com.oking.meeting.util.integrationUtil;
import cn.com.oking.util.ConfigUtil;

import com.bstek.dorado.annotation.DataResolver;


@Component
public class FixedMeetingAction {
	
	// FixedMeetingAction#createFixedMeeting
	@DataResolver
	@Transactional
	public String createFixedMeeting(FixedMeetingEntity et){
		
		FixedMeetingDao fmDao = new FixedMeetingDao();
		String xmlStr = "";	
		String confKey = "";
		String xmlToken = "";
		String token = "";
		
		try{

			//调用新增方法
			//xmlStr = integrationUtil.createFixedMeeting("http://218.2.99.67/integration/xml","admin","admin","http://218.2.99.67",et);
			xmlStr = integrationUtil.createFixedMeeting(ConfigUtil.getValue("meeting_strUrl"),
														ConfigUtil.getValue("meeting_userName"),
														ConfigUtil.getValue("meeting_password"),
														ConfigUtil.getValue("meeting_webBaseUrl"),"admin",et);
			
			//解析新增返回结果，获得confKey
			confKey = fmDao.getStartMeetingConfKey(xmlStr);
			System.out.println("confKey========" + confKey);
			//将confkey返回到界面
			if(!confKey.equals("")&&!"F".equals(confKey.substring(1)))			
				et.setConfKey(confKey);			
						     
		}catch(Exception e){
				e.printStackTrace();
		}
		return confKey;
	}
	
	
	// FixedMeetingAction#startFixedMeeting
	@DataResolver
	@Transactional
	public String startFixedMeeting(FixedMeetingEntity entity){
		FixedMeetingDao fmDao = new FixedMeetingDao();
		String xmlStr = "";	
		String confKey = "";
		String xmlTocken = "";
		String tocken = "";
		try{
			
			//获得confKey
			confKey = entity.getConfKey();
			//如果confkey为空,新增
			if(confKey==null||confKey.equals("FFAILURE")||confKey.equals("")){
				//调用新增方法			//服务地址		用户名  密码	服务器地址
				//xmlStr = integrationUtil.createFixedMeeting("http://218.2.99.67/integration/xml","admin","admin","http://218.2.99.67",entity);
				xmlStr = integrationUtil.createFixedMeeting(ConfigUtil.getValue("meeting_strUrl"),
															ConfigUtil.getValue("meeting_userName"),
															ConfigUtil.getValue("meeting_password"),
															ConfigUtil.getValue("meeting_webBaseUrl"),"admin",entity);
				//解析新增返回结果，获得confKey
				confKey = fmDao.getStartMeetingConfKey(xmlStr);
			}	
			//根据confKey调用“获得读取会议启动接口 startMeeting”，返回xmlTocken	
			if(!confKey.equals("null")&&!confKey.equals("")){
				entity.setConfKey(confKey);						//用户名  密码 （前两个）
				//xmlTocken = integrationUtil.getStartMeetingToken("admin","admin","admin","管理员",confKey,"","","http://218.2.99.67");	
				xmlTocken = integrationUtil.getStartMeetingToken(ConfigUtil.getValue("meeting_strUrl"),
																ConfigUtil.getValue("meeting_userName"),"admin","管理员",confKey,"admin","a@b.com",
																ConfigUtil.getValue("meeting_webBaseUrl"));	
				System.out.println("xmlTocken========" + xmlTocken);
			}
			//解析会议启动XML，得到会议启动token，ciURL
			if(!xmlTocken.equals("") &&!"F".equals(xmlTocken.substring(1)))
				tocken = fmDao.getStartMeetingToken(xmlTocken);	
			//提交到接口地址，启动会议客户端
			if(tocken.equals("") &&"F".equals(tocken.substring(1)))
				tocken = "FFAILURE";					     
		}catch(Exception e){
				e.printStackTrace();
		}
		
		return tocken;
	}

}
