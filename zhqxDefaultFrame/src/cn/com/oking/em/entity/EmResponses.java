package cn.com.oking.em.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * EM_RESPONSES:防范应对
 */
@Entity
@Table(name = "EM_RESPONSES")
public class EmResponses implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID:ID
	 */
	private String id;

	/**
	 * 预警标准编号:预警标准编号
	 */
	private String alarmstandardnum;

	/**
	 * 灾害类型:灾害类型
	 */
	private String disastertype;

	/**
	 * 预警等级:预警等级
	 */
	private String disasterlevel;

	/**
	 * 部门:部门
	 */
	private String dept;

	/**
	 * 应对措施:应对措施
	 */
	private String response;

	/**
	 * 相关预案:相关预案
	 */
	private String relevantplans;

	/**
	 * 措施类型:措施类型
	 */
	private String measurestype;

	public EmResponses() {
		super();
	}

	public EmResponses(String id, String alarmstandardnum, String disastertype,
			String disasterlevel, String dept, String response,
			String relevantplans, String measurestype) {
		super();
		this.id = id;
		this.alarmstandardnum = alarmstandardnum;
		this.disastertype = disastertype;
		this.disasterlevel = disasterlevel;
		this.dept = dept;
		this.response = response;
		this.relevantplans = relevantplans;
		this.measurestype = measurestype;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Id
	@Column(name = "ID", length = 50, nullable = false)
	public String getId() {
		return id;
	}

	public void setAlarmstandardnum(String alarmstandardnum) {
		this.alarmstandardnum = alarmstandardnum;
	}

	@Column(name = "ALARMSTANDARDNUM", length = 50)
	public String getAlarmstandardnum() {
		return alarmstandardnum;
	}

	public void setDisastertype(String disastertype) {
		this.disastertype = disastertype;
	}

	@Column(name = "DISASTERTYPE", length = 50)
	public String getDisastertype() {
		return disastertype;
	}

	public void setDisasterlevel(String disasterlevel) {
		this.disasterlevel = disasterlevel;
	}

	@Column(name = "DISASTERLEVEL", length = 50)
	public String getDisasterlevel() {
		return disasterlevel;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Column(name = "DEPT", length = 100)
	public String getDept() {
		return dept;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	@Column(name = "RESPONSE", length = 1000)
	public String getResponse() {
		return response;
	}

	public void setRelevantplans(String relevantplans) {
		this.relevantplans = relevantplans;
	}

	@Column(name = "RELEVANTPLANS", length = 50)
	public String getRelevantplans() {
		return relevantplans;
	}

	public void setMeasurestype(String measurestype) {
		this.measurestype = measurestype;
	}

	@Column(name = "MEASURESTYPE", length = 50)
	public String getMeasurestype() {
		return measurestype;
	}

	public String toString() {
		return "EmResponses [id=" + id + ",alarmstandardnum="
				+ alarmstandardnum + ",disastertype=" + disastertype
				+ ",disasterlevel=" + disasterlevel + ",dept=" + dept
				+ ",response=" + response + ",relevantplans=" + relevantplans
				+ ",measurestype=" + measurestype + "]";
	}

}
