package cn.com.oking.em.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * EM_RESPONSES:����Ӧ��
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
	 * Ԥ����׼���:Ԥ����׼���
	 */
	private String alarmstandardnum;

	/**
	 * �ֺ�����:�ֺ�����
	 */
	private String disastertype;

	/**
	 * Ԥ���ȼ�:Ԥ���ȼ�
	 */
	private String disasterlevel;

	/**
	 * ����:����
	 */
	private String dept;

	/**
	 * Ӧ�Դ�ʩ:Ӧ�Դ�ʩ
	 */
	private String response;

	/**
	 * ���Ԥ��:���Ԥ��
	 */
	private String relevantplans;

	/**
	 * ��ʩ����:��ʩ����
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
