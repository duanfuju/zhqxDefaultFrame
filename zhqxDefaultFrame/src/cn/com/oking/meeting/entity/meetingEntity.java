package cn.com.oking.meeting.entity;

public class meetingEntity {
	private String confKey;      //会议号
	private String subject;      //会议主题
	private String hostName;     //主持人名字
	private String startTime;    //
	private String endTime;      //
	private String timeZoneId;
	private String status;
	private String duringTime;
	private String confType;
	private String conferenceType;
	private String token;           //参数加密字符串
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getConferenceType() {
		return conferenceType;
	}
	public void setConferenceType(String conferenceType) {
		this.conferenceType = conferenceType;
	}
	public String getConfKey() {
		return confKey;
	}
	public void setConfKey(String confKey) {
		this.confKey = confKey;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getTimeZoneId() {
		return timeZoneId;
	}
	public void setTimeZoneId(String timeZoneId) {
		this.timeZoneId = timeZoneId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDuringTime() {
		return duringTime;
	}
	public void setDuringTime(String duringTime) {
		this.duringTime = duringTime;
	}
	public String getConfType() {
		return confType;
	}
	public void setConfType(String confType) {
		this.confType = confType;
	}
	
	

}
