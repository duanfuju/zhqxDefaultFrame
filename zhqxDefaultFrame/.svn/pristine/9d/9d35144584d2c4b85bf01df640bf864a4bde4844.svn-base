package cn.com.oking.fzjz.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * MNYL_ROLEDEFINITION:模拟演练_角色定义
 */
@Entity
@Table(name = "MNYL_ROLEDEFINITION")
public class MnylRoledefinition implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 角色编号:角色编号
	 */
	private String roleId;

	/**
	 * 角色名称:角色名称
	 */
	private String roleName;

	/**
	 * 角色描述:角色描述
	 */
	private String roleDescription;

	public MnylRoledefinition() {
		super();
	}

	public MnylRoledefinition(String roleId, String roleName,
			String roleDescription) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleDescription = roleDescription;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Id
	@Column(name = "ROLE_ID", length = 50, nullable = false)
	public String getRoleId() {
		return roleId;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Column(name = "ROLE_NAME", length = 50)
	public String getRoleName() {
		return roleName;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	@Column(name = "ROLE_DESCRIPTION", length = 500)
	public String getRoleDescription() {
		return roleDescription;
	}

	public String toString() {
		return "MnylRoledefinition [roleId=" + roleId + ",roleName=" + roleName
				+ ",roleDescription=" + roleDescription + "]";
	}

}
