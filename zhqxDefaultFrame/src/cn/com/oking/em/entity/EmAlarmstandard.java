package cn.com.oking.em.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * EM_ALARMSTANDARD:Ԥ����׼
 */
@Entity
@Table(name = "EM_ALARMSTANDARD")
public class EmAlarmstandard implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID:ID
	 */
	private String id;

	/**
	 * ���:���
	 */
	private String anumber;

	/**
	 * �ֺ�����:�ֺ�����
	 */
	private String disastertype;

	/**
	 * �ֺ��ȼ�:�ֺ��ȼ�
	 */
	private String disasterlevel;

	/**
	 * �ֺ�����:�ֺ�����
	 */
	private String disastername;

	/**
	 * Ԥ����׼:Ԥ����׼
	 */
	private String alarmstandard;

	/**
	 * �������ʽ:�������ʽ
	 */
	private String condition;

	/**
	 * ��ע:��ע
	 */
	private String remark;

	public EmAlarmstandard() {
		super();
	}

	public EmAlarmstandard(String id, String anumber, String disastertype,
			String disasterlevel, String disastername, String alarmstandard,
			String condition, String remark) {
		super();
		this.id = id;
		this.anumber = anumber;
		this.disastertype = disastertype;
		this.disasterlevel = disasterlevel;
		this.disastername = disastername;
		this.alarmstandard = alarmstandard;
		this.condition = condition;
		this.remark = remark;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Id
	@Column(name = "ID", length = 50, nullable = false)
	public String getId() {
		return id;
	}

	public void setAnumber(String anumber) {
		this.anumber = anumber;
	}

	@Column(name = "ANUMBER", length = 50)
	public String getAnumber() {
		return anumber;
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

	@Column(name = "DISASTERLEVEL", length = 10)
	public String getDisasterlevel() {
		return disasterlevel;
	}

	public void setDisastername(String disastername) {
		this.disastername = disastername;
	}

	@Column(name = "DISASTERNAME", length = 50)
	public String getDisastername() {
		return disastername;
	}

	public void setAlarmstandard(String alarmstandard) {
		this.alarmstandard = alarmstandard;
	}

	@Column(name = "ALARMSTANDARD", length = 200)
	public String getAlarmstandard() {
		return alarmstandard;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	@Column(name = "CONDITION", length = 50)
	public String getCondition() {
		return condition;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "REMARK", length = 1000)
	public String getRemark() {
		return remark;
	}

	public String toString() {
		return "EmAlarmstandard [id=" + id + ",anumber=" + anumber
				+ ",disastertype=" + disastertype + ",disasterlevel="
				+ disasterlevel + ",disastername=" + disastername
				+ ",alarmstandard=" + alarmstandard + ",condition=" + condition
				+ ",remark=" + remark + "]";
	}

}
