package cn.com.oking.dataInterface.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * MONITOR_ADMIN:
 */
@Entity
@Table(name = "MONITOR_ADMIN")
public class MonitorAdmin implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * DATAID:
	 */
	private String dataid;

	/**
	 * ADMINNAME:
	 */
	private String adminname;

	/**
	 * PHONENUM:
	 */
	private String phonenum;

	/**
	 * EPHONENUM:
	 */
	private String ephonenum;

	/**
	 * ID:
	 */
	private String id;

	/**
	 * ADMINTYPE:
	 */
	private String admintype;

	public MonitorAdmin() {
		super();
	}

	public MonitorAdmin(String dataid, String adminname, String phonenum,
			String ephonenum, String id, String admintype) {
		super();
		this.dataid = dataid;
		this.adminname = adminname;
		this.phonenum = phonenum;
		this.ephonenum = ephonenum;
		this.id = id;
		this.admintype = admintype;
	}

	public void setDataid(String dataid) {
		this.dataid = dataid;
	}

	@Column(name = "DATAID", length = 10)
	public String getDataid() {
		return dataid;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	@Column(name = "ADMINNAME", length = 20)
	public String getAdminname() {
		return adminname;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	@Column(name = "PHONENUM", length = 20)
	public String getPhonenum() {
		return phonenum;
	}

	public void setEphonenum(String ephonenum) {
		this.ephonenum = ephonenum;
	}

	@Column(name = "EPHONENUM", length = 20)
	public String getEphonenum() {
		return ephonenum;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Id
	@Column(name = "ID", length = 30, nullable = false)
	public String getId() {
		return id;
	}

	public void setAdmintype(String admintype) {
		this.admintype = admintype;
	}

	@Column(name = "ADMINTYPE", length = 20)
	public String getAdmintype() {
		return admintype;
	}

	public String toString() {
		return "MonitorAdmin [dataid=" + dataid + ",adminname=" + adminname
				+ ",phonenum=" + phonenum + ",ephonenum=" + ephonenum + ",id="
				+ id + ",admintype=" + admintype + "]";
	}

}
