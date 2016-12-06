package cn.com.oking.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * MONITOR_SYS_LOG:
 */
@Entity
@Table(name = "MONITOR_SYS_LOG")
public class MonitorSysLog implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 系统ID:系统ID
	 */
	private String dataid;

	/**
	 * 预警时间:预警时间
	 */
	private Date warningtime;

	/**
	 * 最后正常运行时间:最后正常运行时间
	 */
	private Date lastdate;

	/**
	 * 异常类型:异常类型
	 */
	private String errtype;

	/**
	 * 处理人:处理人
	 */
	private String updateby;

	/**
	 * 处理时间:处理时间
	 */
	private Date updatetime;

	/**
	 * 原因说明:原因说明
	 */
	private String description;

	/**
	 * 备注:备注
	 */
	private String remark;

	/**
	 * 信息ID:信息ID
	 */
	private String messageid;

	/**
	 * 监测记录ID:监测记录ID
	 */
	private String logid;

	/**
	 * 延迟时间:延迟时间
	 */
	private String delaytime;

	/**
	 * 提示信息:提示信息
	 */
	private String warnmsg;

	/**
	 * 已解除:已解除
	 */
	private String lifted;

	public MonitorSysLog() {
		super();
	}

	public MonitorSysLog(String dataid, Date warningtime, Date lastdate,
			String errtype, String updateby, Date updatetime,
			String description, String remark, String messageid, String logid,
			String delaytime, String warnmsg, String lifted) {
		super();
		this.dataid = dataid;
		this.warningtime = warningtime;
		this.lastdate = lastdate;
		this.errtype = errtype;
		this.updateby = updateby;
		this.updatetime = updatetime;
		this.description = description;
		this.remark = remark;
		this.messageid = messageid;
		this.logid = logid;
		this.delaytime = delaytime;
		this.warnmsg = warnmsg;
		this.lifted = lifted;
	}

	public void setDataid(String dataid) {
		this.dataid = dataid;
	}

	@Column(name = "DATAID", length = 10)
	public String getDataid() {
		return dataid;
	}

	public void setWarningtime(Date warningtime) {
		this.warningtime = warningtime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "WARNINGTIME")
	public Date getWarningtime() {
		return warningtime;
	}

	public void setLastdate(Date lastdate) {
		this.lastdate = lastdate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LASTDATE")
	public Date getLastdate() {
		return lastdate;
	}

	public void setErrtype(String errtype) {
		this.errtype = errtype;
	}

	@Column(name = "ERRTYPE", length = 20)
	public String getErrtype() {
		return errtype;
	}

	public void setUpdateby(String updateby) {
		this.updateby = updateby;
	}

	@Column(name = "UPDATEBY", length = 20)
	public String getUpdateby() {
		return updateby;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATETIME")
	public Date getUpdatetime() {
		return updatetime;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "DESCRIPTION", length = 2000)
	public String getDescription() {
		return description;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "REMARK", length = 2000)
	public String getRemark() {
		return remark;
	}

	public void setMessageid(String messageid) {
		this.messageid = messageid;
	}

	@Column(name = "MESSAGEID", length = 10)
	public String getMessageid() {
		return messageid;
	}

	public void setLogid(String logid) {
		this.logid = logid;
	}

	@Id
	@Column(name = "LOGID", length = 10, nullable = false)
	public String getLogid() {
		return logid;
	}

	public void setDelaytime(String delaytime) {
		this.delaytime = delaytime;
	}

	@Column(name = "DELAYTIME", length = 30)
	public String getDelaytime() {
		return delaytime;
	}

	public void setWarnmsg(String warnmsg) {
		this.warnmsg = warnmsg;
	}

	@Column(name = "WARNMSG", length = 200)
	public String getWarnmsg() {
		return warnmsg;
	}

	public void setLifted(String lifted) {
		this.lifted = lifted;
	}

	@Column(name = "LIFTED", length = 10)
	public String getLifted() {
		return lifted;
	}

	public String toString() {
		return "MonitorSysLog [dataid=" + dataid + ",warningtime="
				+ warningtime + ",lastdate=" + lastdate + ",errtype=" + errtype
				+ ",updateby=" + updateby + ",updatetime=" + updatetime
				+ ",description=" + description + ",remark=" + remark
				+ ",messageid=" + messageid + ",logid=" + logid + ",delaytime="
				+ delaytime + ",warnmsg=" + warnmsg + ",lifted=" + lifted + "]";
	}

}
