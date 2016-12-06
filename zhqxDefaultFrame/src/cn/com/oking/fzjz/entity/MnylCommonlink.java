package cn.com.oking.fzjz.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * MNYL_COMMONLINK:ģ������_��������
 */
@Entity
@Table(name = "MNYL_COMMONLINK")
public class MnylCommonlink implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID:ID
	 */
	private String linkId;

	/**
	 * ��������:��������
	 */
	private String linkName;

	/**
	 * ��������:��������
	 */
	private String linkDescription;

	/**
	 * ���ӵ�ַ:���ӵ�ַ
	 */
	private String linkLocation;

	/**
	 * ��ɫ����:��ɫ����
	 */
	private String roleId;

	public MnylCommonlink() {
		super();
	}

	public MnylCommonlink(String linkId, String linkName,
			String linkDescription, String linkLocation, String roleId) {
		super();
		this.linkId = linkId;
		this.linkName = linkName;
		this.linkDescription = linkDescription;
		this.linkLocation = linkLocation;
		this.roleId = roleId;
	}

	public void setLinkId(String linkId) {
		this.linkId = linkId;
	}

	@Id
	@Column(name = "LINK_ID", length = 50, nullable = false)
	public String getLinkId() {
		return linkId;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	@Column(name = "LINK_NAME", length = 50)
	public String getLinkName() {
		return linkName;
	}

	public void setLinkDescription(String linkDescription) {
		this.linkDescription = linkDescription;
	}

	@Column(name = "LINK_DESCRIPTION", length = 200)
	public String getLinkDescription() {
		return linkDescription;
	}

	public void setLinkLocation(String linkLocation) {
		this.linkLocation = linkLocation;
	}

	@Column(name = "LINK_LOCATION", length = 500)
	public String getLinkLocation() {
		return linkLocation;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Column(name = "ROLE_ID", length = 50)
	public String getRoleId() {
		return roleId;
	}

	public String toString() {
		return "MnylCommonlink [linkId=" + linkId + ",linkName=" + linkName
				+ ",linkDescription=" + linkDescription + ",linkLocation="
				+ linkLocation + ",roleId=" + roleId + "]";
	}

}
