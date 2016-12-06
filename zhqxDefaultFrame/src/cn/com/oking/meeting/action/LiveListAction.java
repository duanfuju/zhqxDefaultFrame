package cn.com.oking.meeting.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.com.oking.meeting.dao.LiveListDao;
import cn.com.oking.meeting.entity.*;
import cn.com.oking.meeting.util.integrationUtil;
import cn.com.oking.util.ConfigUtil;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;


@Component
public class LiveListAction {


	/***********
	 * 未结束或未开始的会议
	 * @param obj
	 * @return
	 ****/
	//LiveListAction#getLiveSumList
	@DataProvider
	public Collection<LiveListEntity> getLiveSumList(Map<String,Object> obj){
		Collection<LiveListEntity> tl = null;
		try{
			String xmlStr = "";			
//			xmlStr = integrationUtil.getLiveSumList("http://218.2.99.67/integration/xml","admin","admin","2015-05-01T00:00:01","2015-06-20T00:00:01");
			xmlStr = integrationUtil.getLiveSumList(ConfigUtil.getValue("meeting_strUrl"),
													ConfigUtil.getValue("meeting_userName"),
													ConfigUtil.getValue("meeting_password"),
													"2015-05-01T00:00:01","2015-06-20T00:00:01");
			tl = new ArrayList<LiveListEntity>();
			LiveListDao liveDao = new LiveListDao();;
			tl = liveDao.getLiveSumList(xmlStr);       
		}catch(Exception e){
				e.printStackTrace();
		}
		return tl;
	}
	
	
	// LiveListAction#startLive
	@DataResolver
	@Transactional
	public String startLive(LiveListEntity entity){
		LiveListDao mlDao = new LiveListDao();
		String xmlStr = "";	
		String confKey = "";
		String xmlTocken = "";
		String tocken = "";
		try{			
			//获得confKey
			confKey = entity.getConfKey();
			//根据confKey调用“获得加入会议接口 joinMeeting”，返回xmlTocken	
			if(!confKey.equals("null")&&!confKey.equals("")){
//				xmlTocken = integrationUtil.getStartLiveToken("admin","admin","admin","管理员",confKey,"123","a@b.com","http://218.2.99.67");	
				xmlTocken = integrationUtil.getStartLiveToken(ConfigUtil.getValue("meeting_userName"),
															ConfigUtil.getValue("meeting_password"),
															"admin","管理员",confKey,"admin","a@b.com",
															ConfigUtil.getValue("meeting_webBaseUrl"));	
				System.out.println("xmlTocken========" + xmlTocken);
			}
			//解析加入会议XML，得到加入会议token，ciURL
			if(!xmlTocken.equals("") &&!"F".equals(xmlTocken.substring(1)))
				tocken = mlDao.getStartLiveToken(xmlTocken);	
			//提交到接口地址，启动会议客户端
			if(tocken.equals("") &&"F".equals(tocken.substring(1)))
				tocken = "FFAILURE";					     
		}catch(Exception e){
				e.printStackTrace();
		}
		
		return tocken;
	}
	
	
	// LiveListAction#joinLive
	@DataResolver
	@Transactional
	public String joinLive(LiveListEntity entity){
		LiveListDao mlDao = new LiveListDao();
		String xmlStr = "";	
		String confKey = "";
		String xmlTocken = "";
		String tocken = "";
		try{
			
			//获得confKey
			confKey = entity.getConfKey();
			//根据confKey调用“获得加入会议接口 joinMeeting”，返回xmlTocken	
			if(!confKey.equals("null")&&!confKey.equals("")){
			//	xmlTocken = integrationUtil.getJoinLiveToken("admin","admin","admin","管理员",confKey,"123","a@b.com","http://218.2.99.67");	
				xmlTocken = integrationUtil.getJoinLiveToken(ConfigUtil.getValue("meeting_userName"),
															ConfigUtil.getValue("meeting_password"),"admin","管理员",confKey,"admin","a@b.com",
															ConfigUtil.getValue("meeting_webBaseUrl"));	
				//System.out.println("xmlTocken========" + xmlTocken);
			}
			//解析加入会议XML，得到加入会议token，ciURL
			if(!xmlTocken.equals("") &&!"F".equals(xmlTocken.substring(1)))
				tocken = mlDao.getJoinLiveToken(xmlTocken);	
			//提交到接口地址，启动会议客户端
			if(tocken.equals("") &&"F".equals(tocken.substring(1)))
				tocken = "FFAILURE";					     
		}catch(Exception e){
				e.printStackTrace();
		}
		
		return tocken;
	}
}
