package cn.com.oking.em.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * EM_SUPPLIES:应急物资
 */
@Entity
@Table(name = "EM_SUPPLIES")
public class EmSupplies implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID:
	 */
	private String id;

	/**
	 * 物资编码:物资编码
	 */
	private String itemnum;

	/**
	 * 物资名称:物资名称
	 */
	private String description;

	/**
	 * 物资型号:物资型号
	 */
	private String model;

	/**
	 * 数量:数量
	 */
	private String quantity;

	/**
	 * 计量单位:计量单位
	 */
	private String unit;

	/**
	 * 物资分类:物资分类
	 */
	private String itemtype;

	/**
	 * 仓库:仓库
	 */
	private String location;

	/**
	 * 负责人:负责人
	 */
	private String contraces;

	/**
	 * 负责部门:负责部门
	 */
	private String dept;

	/**
	 * 电话:电话
	 */
	private String phone;

	private EmStore store;
	
	@Transient
	public EmStore getStore() {
		return store;
	}

	public void setStore(EmStore store) {
		this.store = store;
	}

	public EmSupplies() {
		super();
	}

	public EmSupplies(String id, String itemnum, String description,
			String model, String quantity, String unit, String itemtype,
			String location, String contraces, String dept, String phone) {
		super();
		this.id = id;
		this.itemnum = itemnum;
		this.description = description;
		this.model = model;
		this.quantity = quantity;
		this.unit = unit;
		this.itemtype = itemtype;
		this.location = location;
		this.contraces = contraces;
		this.dept = dept;
		this.phone = phone;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Id
	@Column(name = "ID", length = 50, nullable = false)
	public String getId() {
		return id;
	}

	public void setItemnum(String itemnum) {
		this.itemnum = itemnum;
	}

	@Column(name = "ITEMNUM", length = 50)
	public String getItemnum() {
		return itemnum;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "DESCRIPTION", length = 50)
	public String getDescription() {
		return description;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Column(name = "MODEL", length = 50)
	public String getModel() {
		return model;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@Column(name = "QUANTITY", length = 50)
	public String getQuantity() {
		return quantity;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Column(name = "UNIT", length = 50)
	public String getUnit() {
		return unit;
	}

	public void setItemtype(String itemtype) {
		this.itemtype = itemtype;
	}

	@Column(name = "ITEMTYPE", length = 50)
	public String getItemtype() {
		return itemtype;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Column(name = "LOCATION", length = 50)
	public String getLocation() {
		return location;
	}

	public void setContraces(String contraces) {
		this.contraces = contraces;
	}

	@Column(name = "CONTRACES", length = 50)
	public String getContraces() {
		return contraces;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Column(name = "DEPT", length = 50)
	public String getDept() {
		return dept;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "PHONE", length = 20)
	public String getPhone() {
		return phone;
	}

	public String toString() {
		return "EmSupplies [id=" + id + ",itemnum=" + itemnum + ",description="
				+ description + ",model=" + model + ",quantity=" + quantity
				+ ",unit=" + unit + ",itemtype=" + itemtype + ",location="
				+ location + ",contraces=" + contraces + ",dept=" + dept
				+ ",phone=" + phone + "]";
	}

}
