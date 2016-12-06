package cn.com.oking.fzjz.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * MNYL_DEPTDEFINITION:模拟演练_部门定义
 */
@Entity
@Table(name = "MNYL_DEPTDEFINITION")
public class MnylDeptdefinition implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 部门编号:部门编号
	 */
	private String deptId;

	/**
	 * 部门名称:部门名称
	 */
	private String deptName;

	/**
	 * 部门描述:部门描述
	 */
	private String deptDescription;

	public MnylDeptdefinition() {
		super();
	}

	public MnylDeptdefinition(String deptId, String deptName,
			String deptDescription) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptDescription = deptDescription;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	@Id
	@Column(name = "DEPT_ID", length = 50, nullable = false)
	public String getDeptId() {
		return deptId;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Column(name = "DEPT_NAME", length = 50)
	public String getDeptName() {
		return deptName;
	}

	public void setDeptDescription(String deptDescription) {
		this.deptDescription = deptDescription;
	}

	@Column(name = "DEPT_DESCRIPTION", length = 500)
	public String getDeptDescription() {
		return deptDescription;
	}

	public String toString() {
		return "MnylDeptdefinition [deptId=" + deptId + ",deptName=" + deptName
				+ ",deptDescription=" + deptDescription + "]";
	}

}
