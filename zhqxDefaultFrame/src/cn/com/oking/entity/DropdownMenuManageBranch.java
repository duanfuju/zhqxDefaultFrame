package cn.com.oking.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * DROPDOWN_MENU_MANAGE_BRANCH:�����˵�����_�ӱ�
 */
@Entity
@Table(name = "DROPDOWN_MENU_MANAGE_BRANCH")
public class DropdownMenuManageBranch implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ����ID:����ID
	 */
	private String id;

	/**
	 * ��ʾֵ:��ʾֵ
	 */
	private String key;

	/**
	 * ʵ��ֵ:ʵ��ֵ
	 */
	private String value;

	/**
	 * �����ֶ�:�����ֶ�
	 */
	private BigDecimal orderby;

	/**
	 * �����ֶ�:�����ֶ�
	 */
	private String associationNumber;

	public DropdownMenuManageBranch() {
		super();
	}

	public DropdownMenuManageBranch(String id, String key, String value,
			BigDecimal orderby, String associationNumber) {
		super();
		this.id = id;
		this.key = key;
		this.value = value;
		this.orderby = orderby;
		this.associationNumber = associationNumber;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Id
	@Column(name = "ID", length = 50, nullable = false)
	public String getId() {
		return id;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Column(name = "KEY", length = 100)
	public String getKey() {
		return key;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Column(name = "VALUE", length = 100)
	public String getValue() {
		return value;
	}

	public void setOrderby(BigDecimal orderby) {
		this.orderby = orderby;
	}

	@Column(name = "ORDERBY")
	public BigDecimal getOrderby() {
		return orderby;
	}

	public void setAssociationNumber(String associationNumber) {
		this.associationNumber = associationNumber;
	}

	@Column(name = "ASSOCIATION_NUMBER", length = 50)
	public String getAssociationNumber() {
		return associationNumber;
	}

	public String toString() {
		return "DropdownMenuManageBranch [id=" + id + ",key=" + key + ",value="
				+ value + ",orderby=" + orderby + ",associationNumber="
				+ associationNumber + "]";
	}

}
