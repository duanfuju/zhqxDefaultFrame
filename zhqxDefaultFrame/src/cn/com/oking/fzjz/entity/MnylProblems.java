package cn.com.oking.fzjz.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * MNYL_PROBLEMS:ģ������_�ű��������⣩
 */
@Entity
@Table(name = "MNYL_PROBLEMS")
public class MnylProblems implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID:ID
	 */
	private String id;

	/**
	 * ��Ŀ����:��Ŀ����
	 */
	private String ptype;

	/**
	 * ��Ŀ���:��Ŀ���
	 */
	private String title;

	/**
	 * ��Ŀ����ϸ����:��Ŀ����ϸ����
	 */
	private String problem;

	/**
	 * ����ʱ��:����ʱ��
	 */
	private Date openTime;

	/**
	 * ������ı��:������ı��
	 */
	private String caselibraryId;

	/**
	 * ����ģʽ:����ģʽ
	 */
	private String drillMode;

	/**
	 * ��ɫѡ��:��ɫѡ��
	 */
	private String roleSelection;

	/**
	 * ����:����
	 */
	private String dept;

	/**
	 * ���Ͱ���:���Ͱ���
	 */
	private String zhCase;

	/**
	 * �������:�������
	 */
	private String ylId;

	public MnylProblems() {
		super();
	}

	public MnylProblems(String id, String ptype, String title, String problem,
			Date openTime, String caselibraryId, String drillMode,
			String roleSelection, String dept, String zhCase, String ylId) {
		super();
		this.id = id;
		this.ptype = ptype;
		this.title = title;
		this.problem = problem;
		this.openTime = openTime;
		this.caselibraryId = caselibraryId;
		this.drillMode = drillMode;
		this.roleSelection = roleSelection;
		this.dept = dept;
		this.zhCase = zhCase;
		this.ylId = ylId;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Id
	@Column(name = "ID", length = 50, nullable = false)
	public String getId() {
		return id;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	@Column(name = "PTYPE", length = 50)
	public String getPtype() {
		return ptype;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "TITLE", length = 50)
	public String getTitle() {
		return title;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	@Column(name = "PROBLEM", length = 500)
	public String getProblem() {
		return problem;
	}

	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "OPEN_TIME")
	public Date getOpenTime() {
		return openTime;
	}

	public void setCaselibraryId(String caselibraryId) {
		this.caselibraryId = caselibraryId;
	}

	@Column(name = "CASELIBRARY_ID", length = 50)
	public String getCaselibraryId() {
		return caselibraryId;
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

	public void setYlId(String ylId) {
		this.ylId = ylId;
	}

	@Column(name = "YL_ID", length = 50)
	public String getYlId() {
		return ylId;
	}

	public String toString() {
		return "MnylProblems [id=" + id + ",ptype=" + ptype + ",title=" + title
				+ ",problem=" + problem + ",openTime=" + openTime
				+ ",caselibraryId=" + caselibraryId + ",drillMode=" + drillMode
				+ ",roleSelection=" + roleSelection + ",dept=" + dept
				+ ",zhCase=" + zhCase + ",ylId=" + ylId + "]";
	}

}
