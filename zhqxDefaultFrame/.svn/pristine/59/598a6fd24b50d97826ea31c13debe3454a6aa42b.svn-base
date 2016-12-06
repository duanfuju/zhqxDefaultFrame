package cn.com.oking.fzjz.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * MNYL_BASEINFO:模拟演练_基础信息表
 */
@Entity
@Table(name = "MNYL_BASEINFO")
public class MnylBaseinfo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID:ID
	 */
	private String ylId;

	/**
	 * 演练模式:演练模式
	 */
	private String drillMode;

	/**
	 * 角色选择:角色选择
	 */
	private String roleSelection;

	/**
	 * 部门:部门
	 */
	private String dept;

	/**
	 * 典型案例:典型案例
	 */
	private String zhCase;

	/**
	 * 灾害类型:灾害类型
	 */
	private String zhLx;

	/**
	 * 灾害开始时间:灾害开始时间
	 */
	private Date zhStartTime;

	/**
	 * 灾害结束时间:灾害结束时间
	 */
	private Date zhEndTime;

	/**
	 * 灾害持续时间:灾害持续时间
	 */
	private String zhContinuedTime;

	/**
	 * 演练开始时间:演练开始时间
	 */
	private Date ylStartTime;

	/**
	 * 演练结束时间:演练结束时间
	 */
	private Date ylEndTime;

	/**
	 * 演练人员:演练人员
	 */
	private String ylPerson;

	/**
	 * 演练状态:演练状态
	 */
	private String ylStatus;

	public MnylBaseinfo() {
		super();
	}

	public MnylBaseinfo(String ylId, String drillMode, String roleSelection,
			String dept, String zhCase, String zhLx, Date zhStartTime,
			Date zhEndTime, String zhContinuedTime, Date ylStartTime,
			Date ylEndTime, String ylPerson, String ylStatus) {
		super();
		this.ylId = ylId;
		this.drillMode = drillMode;
		this.roleSelection = roleSelection;
		this.dept = dept;
		this.zhCase = zhCase;
		this.zhLx = zhLx;
		this.zhStartTime = zhStartTime;
		this.zhEndTime = zhEndTime;
		this.zhContinuedTime = zhContinuedTime;
		this.ylStartTime = ylStartTime;
		this.ylEndTime = ylEndTime;
		this.ylPerson = ylPerson;
		this.ylStatus = ylStatus;
	}

	public void setYlId(String ylId) {
		this.ylId = ylId;
	}

	@Id
	@Column(name = "YL_ID", length = 50, nullable = false)
	public String getYlId() {
		return ylId;
	}

	public void setDrillMode(String drillMode) {
		this.drillMode = drillMode;
	}

	@Column(name = "DRILL_MODE", length = 50)
	public String getDrillMode() {
		return drillMode;
	}

	public void setRoleSelection(String roleSelection) {
		this.roleSelection = roleSelection;
	}

	@Column(name = "ROLE_SELECTION", length = 50)
	public String getRoleSelection() {
		return roleSelection;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Column(name = "DEPT", length = 50)
	public String getDept() {
		return dept;
	}

	public void setZhCase(String zhCase) {
		this.zhCase = zhCase;
	}

	@Column(name = "ZH_CASE", length = 200)
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

	public void setYlStartTime(Date ylStartTime) {
		this.ylStartTime = ylStartTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "YL_START_TIME")
	public Date getYlStartTime() {
		return ylStartTime;
	}

	public void setYlEndTime(Date ylEndTime) {
		this.ylEndTime = ylEndTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "YL_END_TIME")
	public Date getYlEndTime() {
		return ylEndTime;
	}

	public void setYlPerson(String ylPerson) {
		this.ylPerson = ylPerson;
	}

	@Column(name = "YL_PERSON", length = 50)
	public String getYlPerson() {
		return ylPerson;
	}

	public void setYlStatus(String ylStatus) {
		this.ylStatus = ylStatus;
	}

	@Column(name = "YL_STATUS", length = 50)
	public String getYlStatus() {
		return ylStatus;
	}

	public String toString() {
		return "MnylBaseinfo [ylId=" + ylId + ",drillMode=" + drillMode
				+ ",roleSelection=" + roleSelection + ",dept=" + dept
				+ ",zhCase=" + zhCase + ",zhLx=" + zhLx + ",zhStartTime="
				+ zhStartTime + ",zhEndTime=" + zhEndTime + ",zhContinuedTime="
				+ zhContinuedTime + ",ylStartTime=" + ylStartTime
				+ ",ylEndTime=" + ylEndTime + ",ylPerson=" + ylPerson
				+ ",ylStatus=" + ylStatus + "]";
	}

}
