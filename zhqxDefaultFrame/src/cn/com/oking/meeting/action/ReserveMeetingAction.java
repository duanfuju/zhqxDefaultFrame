package cn.com.oking.meeting.action;



import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.com.oking.meeting.dao.ReserveMeetingDao;
import cn.com.oking.meeting.entity.*;
import cn.com.oking.meeting.util.integrationUtil;
import cn.com.oking.util.ConfigUtil;

import com.bstek.dorado.annotation.DataResolver;


@Component
public class ReserveMeetingAction {
	
	// ReserveMeetingAction#createReserveMeeting
	@DataResolver
	@Transactional
	public String createReserveMeeting(ReserveMeetingEntity entity){
		ReserveMeetingDao rmDao = new ReserveMeetingDao();
		String xmlStr = "";	
		String confKey = "";
		String xmlToken = "";
		String token = "";
		try{

			//������������
//			xmlStr = integrationUtil.createReserveMeeting("http://218.2.99.67/integration/xml","admin","admin","http://218.2.99.67",entity);
			xmlStr = integrationUtil.createReserveMeeting(ConfigUtil.getValue("meeting_strUrl"),
															ConfigUtil.getValue("meeting_userName"),							
															ConfigUtil.getValue("meeting_password"),
															ConfigUtil.getValue("meeting_webBaseUrl"),"admin",entity);
			//�����������ؽ�������confKey
			confKey = rmDao.getStartMeetingConfKey(xmlStr);
			//����confKey���á���ö�ȡ���������ӿ� startMeeting��������xmlTocken
			if(!confKey.equals("")&&!"F".equals(confKey.substring(1)))			
				//xmlToken = integrationUtil.getStartMeetingToken("admin","admin","admin","����Ա",confKey,"","","http://218.2.99.67");
					xmlToken = integrationUtil.getStartMeetingToken(ConfigUtil.getValue("meeting_userName"),							
																	ConfigUtil.getValue("meeting_password"),"admin","����Ա",confKey,"admin","a@b.com",
																	ConfigUtil.getValue("meeting_webBaseUrl"));
	
			//������������XML���õ���������token��ciURL
			if(!xmlToken.equals("") &&!"F".equals(xmlToken.substring(1)))
				token = rmDao.getStartMeetingToken(xmlToken);				
			//�ύ���ӿڵ�ַ����������ͻ���
			if(token.equals("") ||"F".equals(token.substring(1)))
				token = "FFAILURE";			
		}catch(Exception e){
				e.printStackTrace();
		}
		
		return token;
	}
	
	// ReserveMeetingAction#joinReserveMeeting
	@DataResolver
	@Transactional
	public String joinReserveMeeting(ReserveMeetingEntity entity){
		String token = "";
		
		return token;
		
	}
}
