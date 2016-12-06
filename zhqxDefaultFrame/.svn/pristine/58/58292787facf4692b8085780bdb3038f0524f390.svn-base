package cn.com.oking.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * WATER_DATA:
 */
@Entity
@Table(name = "WATER_DATA")
public class WaterData implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * WD_ID:
	 */
	private String wdId;

	/**
	 * WD_DATE:
	 */
	private Date wdDate;

	/**
	 * WD_RESULTS:
	 */
	private BigDecimal wdResults;

	/**
	 * SITEID:
	 */
	private String siteid;

	public WaterData() {
		super();
	}

	public WaterData(String wdId, Date wdDate, BigDecimal wdResults,
			String siteid) {
		super();
		this.wdId = wdId;
		this.wdDate = wdDate;
		this.wdResults = wdResults;
		this.siteid = siteid;
	}

	public void setWdId(String wdId) {
		this.wdId = wdId;
	}

	@Id
	@Column(name = "WD_ID", length = 50, nullable = false)
	public String getWdId() {
		return wdId;
	}

	public void setWdDate(Date wdDate) {
		this.wdDate = wdDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "WD_DATE")
	public Date getWdDate() {
		return wdDate;
	}

	public void setWdResults(BigDecimal wdResults) {
		this.wdResults = wdResults;
	}

	@Column(name = "WD_RESULTS")
	public BigDecimal getWdResults() {
		return wdResults;
	}

	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}

	@Column(name = "SITEID", length = 50)
	public String getSiteid() {
		return siteid;
	}

	public String toString() {
		return "WaterData [wdId=" + wdId + ",wdDate=" + wdDate + ",wdResults="
				+ wdResults + ",siteid=" + siteid + "]";
	}

}
