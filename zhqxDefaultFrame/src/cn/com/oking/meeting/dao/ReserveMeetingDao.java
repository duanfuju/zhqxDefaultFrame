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

public class ReserveMeetingDao {	
	
	/*********
	 * 获得会议启动的token
	 */
	public String getStartMeetingToken(String result){
		String tocken = "";
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
					tocken = body.getChild("token").getText();
					ciURL = body.getChild("ciURL").getText();
			} else {
				tocken = "F" + returnStr;
			}
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tocken;
	}
	
	
	/*********
	 * 解析会议会议新增成功后返回的XML。得到confKey
	 */
	public String getStartMeetingConfKey(String result){
		String confKey = "";
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
					confKey = body.getChild("confKey").getText();
			} else {
				confKey = "F" + returnStr;
			}
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return confKey;
	}
}
