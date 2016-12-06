package cn.com.oking.meeting.dao;

import java.io.IOException;
import java.io.StringReader;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class FixedMeetingDao {
	
	/*********
	 * 获得会议启动的token
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
