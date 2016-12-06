package cn.com.oking.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * DROPDOWN_MENU_MANAGE_MAIN:ÏÂÀ­²Ëµ¥¹ÜÀí_Ö÷±í
 */
@Entity
@Table(name = "DROPDOWN_MENU_MANAGE_MAIN")
public class DropdownMenuManageMain implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Ö÷¼üID:Ö÷¼üID
	 */
	private String id;

	/**
	 * ÃèÊö:ÃèÊö
	 */
	private String describe;

	/**
	 * ¹Ø¼ü×Ö¶Î:¹Ø¼ü×Ö¶Î
	 */
	private String name;

	/**
	 * ÅÅÐò×Ö¶Î:ÅÅÐò×Ö¶Î
	 */
	private BigDecimal orderby;

	public DropdownMenuManageMain() {
		super();
	}

	public DropdownMenuManageMain(String id, String describe, String name,
			BigDecimal orderby) {
		super();
		this.id = id;
		this.describe = describe;
		this.name = name;
		this.orderby = orderby;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Id
	@Column(name = "ID", length = 50, nullable = false)
	public String getId() {
		return id;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	@Column(name = "DESCRIBE", length = 500)
	public String getDescribe() {
		return describe;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "NAME", length = 50)
	public String getName() {
		return name;
	}

	public void setOrderby(BigDecimal orderby) {
		this.orderby = orderby;
	}

	@Column(name = "ORDERBY")
	public BigDecimal getOrderby() {
		return orderby;
	}

	public String toString() {
		return "DropdownMenuManageMain [id=" + id + ",describe=" + describe
				+ ",name=" + name + ",orderby=" + orderby + "]";
	}

}
