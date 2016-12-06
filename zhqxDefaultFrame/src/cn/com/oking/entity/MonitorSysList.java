package cn.com.oking.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * MONITOR_SYS_LIST:
 */
@Entity
@Table(name = "MONITOR_SYS_LIST")
public class MonitorSysList implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ϵͳID:ϵͳID
	 */
	private String dataid;

	/**
	 * ϵͳ����:ϵͳ����
	 */
	private String dataname;

	/**
	 * ��������ַ:��������ַ
	 */
	private String ipaddress;

	/**
	 * �˿�:�˿�
	 */
	private String port;

	/**
	 * ���Ե�ַ:���Ե�ַ
	 */
	private String testurl;

	/**
	 * ������Ϣ:������Ϣ
	 */
	private String retmsg;

	/**
	 * ������ҳ:������ҳ
	 */
	private String loginurl;

	/**
	 * ���Ƶ��:���Ƶ��
	 */
	private BigDecimal period;

	/**
	 * ��ʱԤ��:��ʱԤ��
	 */
	private BigDecimal overtime;

	/**
	 * �����������ʱ��:�����������ʱ��
	 */
	private Date lastdate;

	/**
	 * ״̬:״̬
	 */
	private String status;

	public MonitorSysList() {
		super();
	}

	public MonitorSysList(String dataid, String dataname, String ipaddress,
			String port, String testurl, String retmsg, String loginurl,
			BigDecimal period, BigDecimal overtime, Date lastdate, String status) {
		super();
		this.dataid = dataid;
		this.dataname = dataname;
		this.ipaddress = ipaddress;
		this.port = port;
		this.testurl = testurl;
		this.retmsg = retmsg;
		this.loginurl = loginurl;
		this.period = period;
		this.overtime = overtime;
		this.lastdate = lastdate;
		this.status = status;
	}

	public void setDataid(String dataid) {
		this.dataid = dataid;
	}

	@Id
	@Column(name = "DATAID", length = 30, nullable = false)
	public String getDataid() {
		return dataid;
	}

	public void setDataname(String dataname) {
		this.dataname = dataname;
	}

	@Column(name = "DATANAME", length = 30)
	public String getDataname() {
		return dataname;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	@Column(name = "IPADDRESS", length = 20)
	public String getIpaddress() {
		return ipaddress;
	}

	public void setPort(String port) {
		this.port = port;
	}

	@Column(name = "PORT", length = 20)
	public String getPort() {
		return port;
	}

	public void setTesturl(String testurl) {
		this.testurl = testurl;
	}

	@Column(name = "TESTURL", length = 100)
	public String getTesturl() {
		return testurl;
	}

	public void setRetmsg(String retmsg) {
		this.retmsg = retmsg;
	}

	@Column(name = "RETMSG", length = 100)
	public String getRetmsg() {
		return retmsg;
	}

	public void setLoginurl(String loginurl) {
		this.loginurl = loginurl;
	}

	@Column(name = "LOGINURL", length = 100)
	public String getLoginurl() {
		return loginurl;
	}

	public void setPeriod(BigDecimal period) {
		this.period = period;
	}

	@Column(name = "PERIOD")
	public BigDecimal getPeriod() {
		return period;
	}

	public void setOvertime(BigDecimal overtime) {
		this.overtime = overtime;
	}

	@Column(name = "OVERTIME")
	public BigDecimal getOvertime() {
		return overtime;
	}

	public void setLastdate(Date lastdate) {
		this.lastdate = lastdate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LASTDATE")
	public Date getLastdate() {
		return lastdate;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "STATUS", length = 20)
	public String getStatus() {
		return status;
	}

	public String toString() {
		return "MonitorSysList [dataid=" + dataid + ",dataname=" + dataname
				+ ",ipaddress=" + ipaddress + ",port=" + port + ",testurl="
				+ testurl + ",retmsg=" + retmsg + ",loginurl=" + loginurl
				+ ",period=" + period + ",overtime=" + overtime + ",lastdate="
				+ lastdate + ",status=" + status + "]";
	}

}
