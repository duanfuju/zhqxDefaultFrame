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


public class meetingListDao {	
	/**
	 * 根据response返回的xml  查询会议列表
	 * @param result
	 * @return
	 */
	public Collection<meetingEntity> getMeetingSumList(String result){
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
					 meetings = body.getChild("meetings");
				if (meetings!=null){
					List mtListTemp =  meetings.getChildren("meeting");
					
					Iterator it = mtListTemp.iterator();
					while (it!=null&&it.hasNext()) {
						Element el = (Element)it.next();						
						mtEntity = new meetingEntity();
												
						mtEntity.setConfKey(el.getChild("confKey").getText());
						mtEntity.setSubject(el.getChild("subject").getText());
						mtEntity.setStartTime(el.getChild("startTime").getText());
						mtEntity.setEndTime(el.getChild("endTime").getText());
						mtEntity.setHostName(el.getChild("hostName").getText());
						String s = el.getChild("status").getText();
						if (s.equals("0"))
						   s="未开始";
						else if(s.equals("1"))
						   s="已开始";
						else if(s.equals("2"))
						   s="已结束";
						else
						   s="";
						mtEntity.setStatus(s);		
						
						String s1 = el.getChild("confType").getText();
						if (s1.equals("0")||s1.equals("0"))
						   s1="即时会议";
						else if(s1.equals("2"))
						   s1="固定会议";
						else
						   s1="其他会议";
						mtEntity.setConfType(s1);
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
	
	/**
	 * 根据response返回的xml  根据传入的USERNAME查询个人安排的会议列表
	 * @param result
	 * @return
	 */
	public Collection<meetingEntity> getMeetingPrivateList(String result){
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
					 meetings = body.getChild("meetings");
				if (meetings!=null){
					List mtListTemp =  meetings.getChildren("meeting");
					
					Iterator it = mtListTemp.iterator();
					while (it!=null&&it.hasNext()) {
						Element el = (Element)it.next();						
						mtEntity = new meetingEntity();
												
						mtEntity.setConfKey(el.getChild("confKey").getText());
						mtEntity.setSubject(el.getChild("subject").getText());
						mtEntity.setStartTime(el.getChild("startTime").getText());
						mtEntity.setEndTime(el.getChild("endTime").getText());
						mtEntity.setHostName(el.getChild("hostName").getText());
						String s = el.getChild("status").getText();
						if (s.equals("0"))
						   s="未开始";
						else if(s.equals("1"))
						   s="已开始";
						else if(s.equals("2"))
						   s="已结束";
						else
						   s="";
						mtEntity.setStatus(s);		
						
						String s1 = el.getChild("confType").getText();
						if (s1.equals("0")||s1.equals("0"))
						   s1="即时会议";
						else if(s1.equals("2"))
						   s1="固定会议";
						else
						   s1="其他会议";
						mtEntity.setConfType(s1);
						
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
	 * 获得加入会议的token
	 */
	public String getStartMeetingToken(String result){
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
	public String getJoinMeetingToken(String result){
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
