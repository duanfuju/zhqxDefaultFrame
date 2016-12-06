package cn.com.oking.meeting.dao;


import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;


import cn.com.oking.meeting.entity.*;


public class LiveListDao {	
	/**
	 * 根据response返回的xml  查询直播列表
	 * @param result
	 * @return
	 */
	public Collection<LiveListEntity> getLiveSumList(String result){
		List<LiveListEntity> liveList = new ArrayList<LiveListEntity>();
		LiveListEntity liveEntity = null;
		SAXBuilder sb = new SAXBuilder();
		StringReader xml = new StringReader(result);
		try {
			Document doc = sb.build(xml);
			Element root = doc.getRootElement();
			Element header = root.getChild("header");
			String returnStr = header.getChildText("result");
			if ("SUCCESS".equals(returnStr)){
				Element  body = root.getChild("body");
				Element meetings = null;
				if (body!=null)
					 meetings = body.getChild("meetings");
				if (meetings!=null){
					List mtListTemp =  meetings.getChildren("meeting");
					
					Iterator it = mtListTemp.iterator();
					while (it!=null&&it.hasNext()) {
						Element el = (Element)it.next();						
						liveEntity = new LiveListEntity();
												
						liveEntity.setConfKey(el.getChild("confKey").getText());
						liveEntity.setSubject(el.getChild("subject").getText());
						liveEntity.setStartTime(el.getChild("startTime").getText());
						liveEntity.setEndTime(el.getChild("endTime").getText());
						liveEntity.setHostName(el.getChild("hostName").getText());
						String s = el.getChild("status").getText();
						if (s.equals("0"))
						   s="未开始";
						else if(s.equals("1"))
						   s="已开始";
						else if(s.equals("2"))
						   s="已结束";
						else
						   s="";
						liveEntity.setStatus(s);		
						liveList.add(liveEntity);
					}
				}
			} else {
				System.out.println("获取视频直播列表失败");
			}
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return liveList;
	}	
	
	/**
	 * 根据response返回的xml  查询会议历史记录列表
	 * @param result
	 * @return
	 */
	public Collection<meetingEntity> getMeetingHisList(String result){
		List<meetingEntity> mtList = new ArrayList<meetingEntity>();
		meetingEntity mtEntity = null;
		SAXBuilder sb = new SAXBuilder();
		StringReader xml = new StringReader(result);
		try {
			Document doc = sb.build(xml);
			Element root = doc.getRootElement();
			Element header = root.getChild("header");
			String returnStr = header.getChildText("result");
			if ("SUCCESS".equals(returnStr)){
				Element  body = root.getChild("body");
				Element meetings = null;
				if (body!=null)
					 meetings = body.getChild("historyMeetings");
				if (meetings!=null){
					List mtListTemp =  meetings.getChildren("historyMeeting");
					
					Iterator it = mtListTemp.iterator();
					while (it!=null&&it.hasNext()) {
						Element el = (Element)it.next();						
						mtEntity = new meetingEntity();
												
						mtEntity.setConfKey(el.getChild("confId").getText());
						mtEntity.setSubject(el.getChild("subject").getText());
						mtEntity.setStartTime(el.getChild("startTime").getText());
						mtEntity.setEndTime(el.getChild("endTime").getText());
						mtEntity.setConferenceType(el.getChild("conferenceType").getText());
						
						mtList.add(mtEntity);
					}
				}
			} else {
				System.out.println("获取会议列表失败");
			}
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mtList;
	}

	
	/*********
	 * 获得开始会议的token
	 */
	public String getStartLiveToken(String result){
		String token = "";
		String ciURL = "";
		SAXBuilder sb = new SAXBuilder();
		StringReader xml = new StringReader(result);
		try {
			Document doc = sb.build(xml);
			Element root = doc.getRootElement();
			Element header = root.getChild("header");
			String returnStr = header.getChildText("result");
			if ("SUCCESS".equals(returnStr)){
				Element  body = root.getChild("body");
				if (body!=null)
					token = body.getChild("token").getText();
					ciURL = body.getChild("ciURL").getText();
			} else {
				token = "F" + returnStr;
			}
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return token;
	}
	
	/*********
	 * 获得加入会议的token
	 */
	public String getJoinLiveToken(String result){
		String token = "";
		String ciURL = "";
		SAXBuilder sb = new SAXBuilder();
		StringReader xml = new StringReader(result);
		try {
			Document doc = sb.build(xml);
			Element root = doc.getRootElement();
			Element header = root.getChild("header");
			String returnStr = header.getChildText("result");
			if ("SUCCESS".equals(returnStr)){
				Element  body = root.getChild("body");
				if (body!=null)
					token = body.getChild("token").getText();
					ciURL = body.getChild("ciURL").getText();
			} else {
				token = "F" + returnStr;
			}
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return token;
	}
}
