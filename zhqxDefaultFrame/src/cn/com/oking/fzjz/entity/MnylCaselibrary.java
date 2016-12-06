package cn.com.oking.fzjz.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * MNYL_CASELIBRARY:模拟演练_典型灾害案例库
 */
@Entity
@Table(name = "MNYL_CASELIBRARY")
public class MnylCaselibrary implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID:ID
	 */
	private String zhId;

	/**
	 * 典型案例描述:典型案例描述
	 */
	private String zhCase;

	/**
	 * 灾害类型:灾害类型
	 */
	private String zhLx;

	/**
	 * 开始时间:开始时间
	 */
	private Date zhStartTime;

	/**
	 * 结束时间:结束时间
	 */
	private Date zhEndTime;

	/**
	 * 持续时间:持续时间
	 */
	private String zhContinuedTime;

	public MnylCaselibrary() {
		super();
	}

	public MnylCaselibrary(String zhId, String zhCase, String zhLx,
			Date zhStartTime, Date zhEndTime, String zhContinuedTime) {
		super();
		this.zhId = zhId;
		this.zhCase = zhCase;
		this.zhLx = zhLx;
		this.zhStartTime = zhStartTime;
		this.zhEndTime = zhEndTime;
		this.zhContinuedTime = zhContinuedTime;
	}

	public void setZhId(String zhId) {
		this.zhId = zhId;
	}

	@Id
	@Column(name = "ZH_ID", length = 200, nullable = false)
	public String getZhId() {
		return zhId;
	}

	public void setZhCase(String zhCase) {
		this.zhCase = zhCase;
	}

	@Column(name = "ZH_CASE", length = 50)
	public String getZhCase() {
		return zhCase;
	}

	public void setZhLx(String zhLx) {
		this.zhLx = zhLx;
	}

	@Column(name = "ZH_LX", length = 50)
	public String getZhLx() {
		return zhLx;
	}

	public void setZhStartTime(Date zhStartTime) {
		this.zhStartTime = zhStartTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ZH_START_TIME")
	public Date getZhStartTime() {
		return zhStartTime;
	}

	public void setZhEndTime(Date zhEndTime) {
		this.zhEndTime = zhEndTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ZH_END_TIME")
	public Date getZhEndTime() {
		return zhEndTime;
	}

	public void setZhContinuedTime(String zhContinuedTime) {
		this.zhContinuedTime = zhContinuedTime;
	}

	@Column(name = "ZH_CONTINUED_TIME", length = 50)
	public String getZhContinuedTime() {
		return zhContinuedTime;
	}

	public String toString() {
		return "MnylCaselibrary [zhId=" + zhId + ",zhCase=" + zhCase + ",zhLx="
				+ zhLx + ",zhStartTime=" + zhStartTime + ",zhEndTime="
				+ zhEndTime + ",zhContinuedTime=" + zhContinuedTime + "]";
	}

}
