package cn.com.oking.dataInterface.entity;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class MonitorVStatus implements Serializable{
	private String dataname;
	private String datastatus;
	private Date lastdate;
	private String delaytime;
	private String overtime;
	private String ordernum;
	
	public String getDelaytime() {
		return delaytime;
	}
	public void setDelaytime(String delaytime) {
		this.delaytime = delaytime;
	}
	public String getDataname() {
		return dataname;
	}
	public void setDataname(String dataname) {
		this.dataname = dataname;
	}
	public String getDatastatus() {
		return datastatus;
	}
	public void setDatastatus(String datastatus) {
		this.datastatus = datastatus;
	}
	public Date getLastdate() {
		return lastdate;
	}
	public void setLastdate(Date lastdate) {
		this.lastdate = lastdate;
	}
	public String getOvertime() {
		return overtime;
	}
	public void setOvertime(String overtime) {
		this.overtime = overtime;
	}
	public String getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}
	
	public MonitorVStatus() {
		super();
	}
	public MonitorVStatus(String dataname, String datastatus, Date lastdate,
			String delaytime, String overtime, String ordernum) {
		super();
		this.dataname = dataname;
		this.datastatus = datastatus;
		this.lastdate = lastdate;
		this.delaytime = delaytime;
		this.overtime = overtime;
		this.ordernum = ordernum;
	}
	@Override
	public String toString() {
		return "MonitorVStatus [dataname=" + dataname + ", datastatus="
				+ datastatus + ", lastdate=" + lastdate + ", delaytime="
				+ delaytime + ", overtime=" + overtime + ", ordernum="
				+ ordernum + "]";
	}
	
	
}
