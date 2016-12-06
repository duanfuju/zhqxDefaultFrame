package cn.com.oking.sys;

import java.util.Date;

public class MonitorMsg {

	private String messageid;
	private String sendto;
	private String content;
	private String feedback;
	private String shortmessage;
	private Date createtime;
	private Date sendtime;
	private String phonenum;
	public String getMessageid() {
		return messageid;
	}
	public void setMessageid(String messageid) {
		this.messageid = messageid;
	}
	public String getSendto() {
		return sendto;
	}
	public void setSendto(String sendto) {
		this.sendto = sendto;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getShortmessage() {
		return shortmessage;
	}
	public void setShortmessage(String shortmessage) {
		this.shortmessage = shortmessage;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getSendtime() {
		return sendtime;
	}
	public void setSendtime(Date sendtime) {
		this.sendtime = sendtime;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	} 
	
	
	
	
}
