package cn.com.oking.sys;


import org.csapi.www.schema.sms.SMSMessage;

import sms.push.GetPushDelivery;
import sms.push.PushSend;
import sms.sms.GetReceiveSms;
import sms.sms.GetSmsDelivery;
import sms.sms.SmsSend;

import com.bstek.dorado.annotation.DataResolver;

public class CmccSend {
	
	public static void main(String[] a){
		String returnvalue =CmccSend.sendCmcc("13611592894","���Ų���111");
		System.out.println(returnvalue);
	}
	
	
	@DataResolver
	public  static String  sendCmcc(String cmcclist,String msg){
		
		String result = "";
		try {
			//String value = smsSend(password, appId, "13611592894", "203 04�����ˣ�email 11 203 04  �����ˣ�", extendcode, true, messageFormat, sendMethodType,intfid, intfname);
			String value = smsSend("webservice", "0007", cmcclist, msg, "013", true, "GB2312", "Long","webservice", "webservice");
			System.out.println(value);
			/*
			if(cn.com.oking.util.StringUtil.isNum(value)){
				result = "�����ɹ�";
			}else{
				result = "����ʧ��";
			}
			if(cmcclist != null && !"".equals(cmcclist)){
				List<LogBean> lbs = new ArrayList<LogBean>();
				String[] users = cmcclist.split(",");
				String[] ress = value.split(",");
				LogBean lb = null;
				for(int i = 0;i<users.length;i++){
					lb = new LogBean();
					lb.setId(users[i]);
					lb.setName(ress[i]);
					lb.setResult(StringUtil.isNumber(ress[i])+"");
					lbs.add(lb);
				}
				sysLog.setSmsPuResult(new Gson().toJson(lbs));
				sysLogDao.saveLog(sysLog);
			}
			*/
		} catch (Exception e) {
			result = result+e.getMessage();
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * ���Ͷ���
	 * @param password �ӿ�����
	 * @param appId Ӧ��ID
	 * @param destNum Ŀ���ֻ�����
	 * @param message ��������
	 */
	public static void smsSend(String password ,String appId,String destNum,String message,String intfid,String intfname){
		SmsSend sms = new SmsSend(password,appId,destNum,message,intfid,intfname);
		  String value = sms.send();
		System.out.println("���Ͷ��ź󷵻ص����к�Ϊ��"+value);
	}
	
	/**
	 * ���Ͷ���
	 * @param password �ӿ�����
	 * @param appid  Ӧ��ID
	 * @param destNum Ŀ���ֻ�����
	 * @param msg ��������
	 * @param extendcode ��չ��
	 * @param deliveryResult ��ִ��־ true���ػ�ִ��false�����ػ�ִ
	 * 
	 */
	public static void smsSend(String password,String appid,String destNum,String msg,String extendcode,
			boolean deliveryResult,String intfid,String intfname){
		
		//�������
		SmsSend sms = new SmsSend(password,appid,destNum,msg,extendcode,deliveryResult,intfid,intfname);
		//���ؽ��
		  String value = sms.send();
		  
		System.out.println("���Ͷ��ź󷵻ص����к�Ϊ��"+value);
	}
	
	/**
	 * ���Ͷ��ţ�ȫ�Σ�
	 * @param password �ӿ�����
	 * @param appid  Ӧ��ID
	 * @param destNum   Ŀ���ֻ�����
	 * @param msg  ��������
	 * @param extendcode ��չ��
	 * @param deliveryResult ��ִ��־ true���ػ�ִ��false�����ػ�ִ
	 * @param messageFormat  ����
	 * @param sendMethodType ��������
	 */
	public static String smsSend(String password,String appid,String destNum,String msg,String extendcode,
			boolean deliveryResult,String messageFormat,String sendMethodType,String intfid,String intfname){
		SmsSend sms = new SmsSend(password,appid,destNum,msg,extendcode,deliveryResult,messageFormat,sendMethodType,intfid,intfname);
		  String value = sms.send();
		System.out.println("���Ͷ��ź󷵻ص����к�Ϊ��"+value);
		return value;
	}
	
	/**
	 * ��ȡ���Ż�ִ״̬
	 * @param password �ӿ��������Ϊ��
	 * @param appId  Ӧ��ID����Ϊ��
	 * @param requestIdentifier  ����ѯ���ŵ����кŲ��ܿ�
	 */
	public static String getSmsDelivery(String password,String appId,String requestIdentifier,String intfid,String intfname){
		GetSmsDelivery getSmsDelivery = new GetSmsDelivery(password,appId,requestIdentifier,intfid,intfname);
		org.csapi.www.schema.sms.DeliveryInformation[] information = getSmsDelivery.getDeliverySms().getDeliveryStatus();
		String info = "";
		if(information!=null){
			for(int i=0;i<information.length;i++){
				System.out.println("���Ż�ִ��״̬�ǣ�"+information[i].getDeliveryStatus());
				info =  "���Ż�ִ��״̬�ǣ�"+information[i].getDeliveryStatus();
			}
			
		}else {
			System.out.println("û�������Ϣ");
			info =  "û�������Ϣ";
		}
		return info;
	}
	
	/**
	 * ��ȡ���ж���
	 * @param password �ӿ��������Ϊ��
	 * @param appId   Ӧ��ID����Ϊ��
	 */
	public static void getReceiveSms(String password,String appId,String intfid,String intfname){
		GetReceiveSms getReceiveSms = new GetReceiveSms(password,appId,intfid,intfname);
		SMSMessage[] value=getReceiveSms.getReSms().getReceivedSms();
		if(value!=null){
			for(int i=0;i<value.length;i++){
				System.out.println("���ж��ŵ������ǣ�"+value[i].getMessage());
			}
		}else{
			System.out.println("û�������Ϣ");
		}
	}
	
	/**
	 * 
	 * @param passw �ӿ�����
	 * @param appid Ӧ��id
	 * @param destNum �·��ֻ�����
	 * @param subject 
	 * @param extendcode
	 * @param receiptRequest
	 * @param targetURL
	 * @param sendMethodType
	 * @param intfid
	 * @param intfname
	 */
	public static void sendPush(String passw,String appid,String destNum,String subject,String extendcode,
			boolean receiptRequest,String targetURL,String intfid,String intfname){
		
		PushSend pushSend = new PushSend(passw,appid,destNum,subject,extendcode,receiptRequest,targetURL,intfid,intfname);
		 String value = pushSend.send();
		 System.out.println("push���Ͷ��� value = "+value);
	}

	/**
	 * ��ȡ���Ż�ִ״̬
	 * @param password �ӿ��������Ϊ��
	 * @param appId  Ӧ��ID����Ϊ��
	 * @param requestIdentifier  ����ѯ���ŵ����кŲ��ܿ�
	 */
	public static void getPushDelivery(String password,String appId,String requestIdentifier,String intfid,String intfname){
		GetPushDelivery getSmsDelivery = new GetPushDelivery(password,appId,requestIdentifier,intfid,intfname);
		org.csapi.www.schema.wap.DeliveryInformation[] information = getSmsDelivery.getDeliveryPush().getResult();
		
		if(information!=null){
			for(int i=0;i<information.length;i++){
				System.out.println("���Ż�ִ��״̬�ǣ�"+information[i].getStatus());
			}
			
		}else {
			System.out.println("û�������Ϣ");
		}
	}
}
