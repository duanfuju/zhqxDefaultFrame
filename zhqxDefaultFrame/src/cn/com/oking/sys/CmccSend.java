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
		String returnvalue =CmccSend.sendCmcc("13611592894","短信测试111");
		System.out.println(returnvalue);
	}
	
	
	@DataResolver
	public  static String  sendCmcc(String cmcclist,String msg){
		
		String result = "";
		try {
			//String value = smsSend(password, appId, "13611592894", "203 04测试了！email 11 203 04  测试了！", extendcode, true, messageFormat, sendMethodType,intfid, intfname);
			String value = smsSend("webservice", "0007", cmcclist, msg, "013", true, "GB2312", "Long","webservice", "webservice");
			System.out.println(value);
			/*
			if(cn.com.oking.util.StringUtil.isNum(value)){
				result = "发布成功";
			}else{
				result = "发布失败";
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
	 * 发送短信
	 * @param password 接口密码
	 * @param appId 应用ID
	 * @param destNum 目标手机号码
	 * @param message 发送内容
	 */
	public static void smsSend(String password ,String appId,String destNum,String message,String intfid,String intfname){
		SmsSend sms = new SmsSend(password,appId,destNum,message,intfid,intfname);
		  String value = sms.send();
		System.out.println("发送短信后返回的序列号为："+value);
	}
	
	/**
	 * 发送短信
	 * @param password 接口密码
	 * @param appid  应用ID
	 * @param destNum 目标手机号码
	 * @param msg 发送内容
	 * @param extendcode 扩展码
	 * @param deliveryResult 回执标志 true返回回执；false不返回回执
	 * 
	 */
	public static void smsSend(String password,String appid,String destNum,String msg,String extendcode,
			boolean deliveryResult,String intfid,String intfname){
		
		//构造对象
		SmsSend sms = new SmsSend(password,appid,destNum,msg,extendcode,deliveryResult,intfid,intfname);
		//返回结果
		  String value = sms.send();
		  
		System.out.println("发送短信后返回的序列号为："+value);
	}
	
	/**
	 * 发送短信（全参）
	 * @param password 接口密码
	 * @param appid  应用ID
	 * @param destNum   目标手机号码
	 * @param msg  发送内容
	 * @param extendcode 扩展码
	 * @param deliveryResult 回执标志 true返回回执；false不返回回执
	 * @param messageFormat  编码
	 * @param sendMethodType 发送类型
	 */
	public static String smsSend(String password,String appid,String destNum,String msg,String extendcode,
			boolean deliveryResult,String messageFormat,String sendMethodType,String intfid,String intfname){
		SmsSend sms = new SmsSend(password,appid,destNum,msg,extendcode,deliveryResult,messageFormat,sendMethodType,intfid,intfname);
		  String value = sms.send();
		System.out.println("发送短信后返回的序列号为："+value);
		return value;
	}
	
	/**
	 * 获取短信回执状态
	 * @param password 接口密码可以为空
	 * @param appId  应用ID不能为空
	 * @param requestIdentifier  待查询短信的序列号不能空
	 */
	public static String getSmsDelivery(String password,String appId,String requestIdentifier,String intfid,String intfname){
		GetSmsDelivery getSmsDelivery = new GetSmsDelivery(password,appId,requestIdentifier,intfid,intfname);
		org.csapi.www.schema.sms.DeliveryInformation[] information = getSmsDelivery.getDeliverySms().getDeliveryStatus();
		String info = "";
		if(information!=null){
			for(int i=0;i<information.length;i++){
				System.out.println("短信回执的状态是："+information[i].getDeliveryStatus());
				info =  "短信回执的状态是："+information[i].getDeliveryStatus();
			}
			
		}else {
			System.out.println("没有相关信息");
			info =  "没有相关信息";
		}
		return info;
	}
	
	/**
	 * 获取上行短信
	 * @param password 接口密码可以为空
	 * @param appId   应用ID不能为空
	 */
	public static void getReceiveSms(String password,String appId,String intfid,String intfname){
		GetReceiveSms getReceiveSms = new GetReceiveSms(password,appId,intfid,intfname);
		SMSMessage[] value=getReceiveSms.getReSms().getReceivedSms();
		if(value!=null){
			for(int i=0;i<value.length;i++){
				System.out.println("上行短信的内容是："+value[i].getMessage());
			}
		}else{
			System.out.println("没有相关信息");
		}
	}
	
	/**
	 * 
	 * @param passw 接口密码
	 * @param appid 应用id
	 * @param destNum 下发手机号码
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
		 System.out.println("push发送短信 value = "+value);
	}

	/**
	 * 获取短信回执状态
	 * @param password 接口密码可以为空
	 * @param appId  应用ID不能为空
	 * @param requestIdentifier  待查询短信的序列号不能空
	 */
	public static void getPushDelivery(String password,String appId,String requestIdentifier,String intfid,String intfname){
		GetPushDelivery getSmsDelivery = new GetPushDelivery(password,appId,requestIdentifier,intfid,intfname);
		org.csapi.www.schema.wap.DeliveryInformation[] information = getSmsDelivery.getDeliveryPush().getResult();
		
		if(information!=null){
			for(int i=0;i<information.length;i++){
				System.out.println("短信回执的状态是："+information[i].getStatus());
			}
			
		}else {
			System.out.println("没有相关信息");
		}
	}
}
