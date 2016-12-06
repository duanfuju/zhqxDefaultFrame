package cn.com.oking.dataInterface.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * HREF_MODULE:超链接模块
 */
@Entity
@Table(name = "HREF_MODULE")
public class HrefModule implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 模块ID:模块ID
	 */
	private String id;

	/**
	 * 模块名称:模块名称
	 */
	private String modulename;

	/**
	 * 详细描述:详细描述
	 */
	private String description;

	/**
	 * 列号:列号
	 */
	private BigDecimal colnum;

	/**
	 * 序号:序号
	 */
	private BigDecimal ordernum;

	/**
	 * 菜单ID:菜单ID
	 */
	private String menuid;

	/**
	 * 模块类型:模块类型
	 */
	private String moduletype;

	public HrefModule() {
		super();
	}

	public HrefModule(String id, String modulename, String description,
			BigDecimal colnum, BigDecimal ordernum, String menuid,
			String moduletype) {
		super();
		this.id = id;
		this.modulename = modulename;
		this.description = description;
		this.colnum = colnum;
		this.ordernum = ordernum;
		this.menuid = menuid;
		this.moduletype = moduletype;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Id
	@Column(name = "ID", length = 30, nullable = false)
	public String getId() {
		return id;
	}

	public void setModulename(String modulename) {
		this.modulename = modulename;
	}

	@Column(name = "MODULENAME", length = 30)
	public String getModulename() {
		return modulename;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "DESCRIPTION", length = 100)
	public String getDescription() {
		return description;
	}

	public void setColnum(BigDecimal colnum) {
		this.colnum = colnum;
	}

	@Column(name = "COLNUM")
	public BigDecimal getColnum() {
		return colnum;
	}

	public void setOrdernum(BigDecimal ordernum) {
		this.ordernum = ordernum;
	}

	@Column(name = "ORDERNUM")
	public BigDecimal getOrdernum() {
		return ordernum;
	}

	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}

	@Column(name = "MENUID", length = 100)
	public String getMenuid() {
		return menuid;
	}

	public void setModuletype(String moduletype) {
		this.moduletype = moduletype;
	}

	@Column(name = "MODULETYPE", length = 30)
	public String getModuletype() {
		return moduletype;
	}

	public String toString() {
		return "HrefModule [id=" + id + ",modulename=" + modulename
				+ ",description=" + description + ",colnum=" + colnum
				+ ",ordernum=" + ordernum + ",menuid=" + menuid
				+ ",moduletype=" + moduletype + "]";
	}

}
