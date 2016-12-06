package cn.com.oking.dataInterface.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * MONITOR_LIST:
 */
@Entity
@Table(name = "MONITOR_LIST")
public class MonitorList implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID:
	 */
	private String id;

	/**
	 * DATAID:
	 */
	private String dataid;

	/**
	 * DATANAME:
	 */
	private String dataname;

	/**
	 * DATASOURCE:
	 */
	private String datasource;

	/**
	 * OWNERUSER:
	 */
	private String owneruser;

	/**
	 * OBJECTNAME:
	 */
	private String objectname;

	/**
	 * OBJATTRIBUTE:
	 */
	private String objattribute;

	/**
	 * DATATYPE:
	 */
	private String datatype;

	/**
	 * PERIOD:
	 */
	private BigDecimal period;

	/**
	 * OVERTIME:
	 */
	private BigDecimal overtime;

	/**
	 * STATUS:
	 */
	private String status;

	/**
	 * NEXTDATE:
	 */
	private Date nextdate;

	/**
	 * FORMAT:
	 */
	private String format;

	/**
	 * LASTDATE:
	 */
	private Date lastdate;

	/**
	 * WHERESQL:
	 */
	private String wheresql;

	public MonitorList() {
		super();
	}

	public MonitorList(String id, String dataid, String dataname,
			String datasource, String owneruser, String objectname,
			String objattribute, String datatype, BigDecimal period,
			BigDecimal overtime, String status, Date nextdate, String format,
			Date lastdate, String wheresql) {
		super();
		this.id = id;
		this.dataid = dataid;
		this.dataname = dataname;
		this.datasource = datasource;
		this.owneruser = owneruser;
		this.objectname = objectname;
		this.objattribute = objattribute;
		this.datatype = datatype;
		this.period = period;
		this.overtime = overtime;
		this.status = status;
		this.nextdate = nextdate;
		this.format = format;
		this.lastdate = lastdate;
		this.wheresql = wheresql;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Id
	@Column(name = "ID", length = 50, nullable = false)
	public String getId() {
		return id;
	}

	public void setDataid(String dataid) {
		this.dataid = dataid;
	}

	@Column(name = "DATAID", length = 10)
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

	public void setDatasource(String datasource) {
		this.datasource = datasource;
	}

	@Column(name = "DATASOURCE", length = 20)
	public String getDatasource() {
		return datasource;
	}

	public void setOwneruser(String owneruser) {
		this.owneruser = owneruser;
	}

	@Column(name = "OWNERUSER", length = 20)
	public String getOwneruser() {
		return owneruser;
	}

	public void setObjectname(String objectname) {
		this.objectname = objectname;
	}

	@Column(name = "OBJECTNAME", length = 50)
	public String getObjectname() {
		return objectname;
	}

	public void setObjattribute(String objattribute) {
		this.objattribute = objattribute;
	}

	@Column(name = "OBJATTRIBUTE", length = 200)
	public String getObjattribute() {
		return objattribute;
	}

	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}

	@Column(name = "DATATYPE", length = 20)
	public String getDatatype() {
		return datatype;
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

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "STATUS", length = 20)
	public String getStatus() {
		return status;
	}

	public void setNextdate(Date nextdate) {
		this.nextdate = nextdate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "NEXTDATE")
	public Date getNextdate() {
		return nextdate;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	@Column(name = "FORMAT", length = 200)
	public String getFormat() {
		return format;
	}

	public void setLastdate(Date lastdate) {
		this.lastdate = lastdate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LASTDATE")
	public Date getLastdate() {
		return lastdate;
	}

	public void setWheresql(String wheresql) {
		this.wheresql = wheresql;
	}

	@Column(name = "WHERESQL", length = 1000)
	public String getWheresql() {
		return wheresql;
	}

	public String toString() {
		return "MonitorList [id=" + id + ",dataid=" + dataid + ",dataname="
				+ dataname + ",datasource=" + datasource + ",owneruser="
				+ owneruser + ",objectname=" + objectname + ",objattribute="
				+ objattribute + ",datatype=" + datatype + ",period=" + period
				+ ",overtime=" + overtime + ",status=" + status + ",nextdate="
				+ nextdate + ",format=" + format + ",lastdate=" + lastdate
				+ ",wheresql=" + wheresql + "]";
	}

}
