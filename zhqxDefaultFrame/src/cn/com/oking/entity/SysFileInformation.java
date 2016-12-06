package cn.com.oking.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;

/**
 * SYS_FILE_INFORMATION:ϵͳ�ļ��ϴ���Ϣ
 */
@Entity
@Table(name = "SYS_FILE_INFORMATION")
public class SysFileInformation implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ����:����
	 */
	private String id;

	/**
	 * ��ʾ·��:��ʾ·��
	 */
	private String showPath;

	/**
	 * �ļ�����(�ϴ�ǰ����):�ļ�����(�ϴ�ǰ����)
	 */
	private String fileName;

	/**
	 * �ļ��������:�ļ��������
	 */
	private String associationId;

	/**
	 * ˳��:˳��
	 */
	private String sort;

	/**
	 * ����·��:����·��
	 */
	private String savaPath;

	/**
	 * ʵ������:ʵ������
	 */
	private String realName;

	/**
	 * �ϴ���:�ϴ���
	 */
	private String upPeople;

	/**
	 * �ϴ�ʱ��:�ϴ�ʱ��
	 */
	private Date upTime;

	/**
	 * ɾ����:ɾ����
	 */
	private String delPeople;

	/**
	 * ɾ��״̬:ɾ��״̬
	 */
	private String delState;

	/**
	 * ɾ��ʱ��:ɾ��ʱ��
	 */
	private Date delTime;

	/**
	 * �ļ�ɾ��״̬:�ļ�ɾ��״̬
	 */
	private String delWjstate;

	/**
	 * �ļ�ɾ��ʱ��:�ļ�ɾ��ʱ��
	 */
	private Date delWjtime;

	public SysFileInformation() {
		super();
	}

	public SysFileInformation(String id, String showPath, String fileName,
			String associationId, String sort, String savaPath,
			String realName, String upPeople, Date upTime, String delPeople,
			String delState, Date delTime, String delWjstate, Date delWjtime) {
		super();
		this.id = id;
		this.showPath = showPath;
		this.fileName = fileName;
		this.associationId = associationId;
		this.sort = sort;
		this.savaPath = savaPath;
		this.realName = realName;
		this.upPeople = upPeople;
		this.upTime = upTime;
		this.delPeople = delPeople;
		this.delState = delState;
		this.delTime = delTime;
		this.delWjstate = delWjstate;
		this.delWjtime = delWjtime;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Id
	@Column(name = "ID", length = 30, nullable = false)
	public String getId() {
		return id;
	}

	public void setShowPath(String showPath) {
		this.showPath = showPath;
	}

	@Column(name = "SHOW_PATH", length = 200)
	public String getShowPath() {
		return showPath.trim();
	}

	public void setFileName(String fileName) {
		this.fileName = fileName.trim();
	}

	@Column(name = "FILE_NAME", length = 500)
	public String getFileName() {
		return fileName;
	}

	public void setAssociationId(String associationId) {
		this.associationId = associationId;
	}

	@Column(name = "ASSOCIATION_ID", length = 200)
	public String getAssociationId() {
		return associationId;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	@Column(name = "SORT", length = 30)
	public String getSort() {
		return sort;
	}

	public void setSavaPath(String savaPath) {
		this.savaPath = savaPath;
	}

	@Column(name = "SAVA_PATH", length = 200)
	public String getSavaPath() {
		return savaPath;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	@Column(name = "REAL_NAME", length = 50)
	public String getRealName() {
		return realName;
	}

	public void setUpPeople(String upPeople) {
		this.upPeople = upPeople;
	}

	@Column(name = "UP_PEOPLE", length = 200)
	public String getUpPeople() {
		return upPeople;
	}

	public void setUpTime(Date upTime) {
		this.upTime = upTime;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UP_TIME")
	public Date getUpTime() {
		return upTime;
	}

	public void setDelPeople(String delPeople) {
		this.delPeople = delPeople;
	}

	@Column(name = "DEL_PEOPLE", length = 200)
	public String getDelPeople() {
		return delPeople;
	}

	public void setDelState(String delState) {
		this.delState = delState;
	}

	@Column(name = "DEL_STATE", length = 200)
	public String getDelState() {
		return delState;
	}

	public void setDelTime(Date delTime) {
		this.delTime = delTime;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DEL_TIME")
	public Date getDelTime() {
		return delTime;
	}

	public void setDelWjstate(String delWjstate) {
		this.delWjstate = delWjstate;
	}

	@Column(name = "DEL_WJSTATE", length = 200)
	public String getDelWjstate() {
		return delWjstate;
	}

	public void setDelWjtime(Date delWjtime) {
		this.delWjtime = delWjtime;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DEL_WJTIME")
	public Date getDelWjtime() {
		return delWjtime;
	}

	public String toString() {
		return "SysFileInformation [id=" + id + ",showPath=" + showPath
				+ ",fileName=" + fileName + ",associationId=" + associationId
				+ ",sort=" + sort + ",savaPath=" + savaPath + ",realName="
				+ realName + ",upPeople=" + upPeople + ",upTime=" + upTime
				+ ",delPeople=" + delPeople + ",delState=" + delState
				+ ",delTime=" + delTime + ",delWjstate=" + delWjstate
				+ ",delWjtime=" + delWjtime + "]";
	}

}
