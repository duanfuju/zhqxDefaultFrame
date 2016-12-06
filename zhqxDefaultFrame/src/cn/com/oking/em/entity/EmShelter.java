package cn.com.oking.em.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.*;



/**
 * EM_SHELTER:避难场所
 */
@Entity
@Table(name = "EM_SHELTER")
public class EmShelter implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键:主键
	 */
	private String id;

	/**
	 * 避难场所:避难场所
	 */
	private String placename;

	/**
	 * 位置:位置
	 */
	private String location;

	/**
	 * 部门:部门
	 */
	private String dept;

	/**
	 * 负责人:负责人
	 */
	private String contraces;

	/**
	 * 联系电话:联系电话
	 */
	private String phone;

	/**
	 * 父编号:父编号
	 */
	private String parentid;

	/**
	 * 经度:经度
	 */
	private String longitude;

	/**
	 * 纬度:纬度
	 */
	private String latitude;

	/**
	 * RES1:
	 */
	private String res1;

	/**
	 * RES2:
	 */
	private String res2;

	/**
	 * X:
	 */
	private String x;

	/**
	 * Y:
	 */
	private String y;

	/**
	 * 备注:备注
	 */
	private String remark;
	
	private List<EmShelter> emshelters;
	
	
	

	public EmShelter() {
		super();
	}
	
	@Transient
	public List<EmShelter> getEmshelters() {
		return emshelters;
	}

	public void setEmshelters(List<EmShelter> emshelters) {
		this.emshelters = emshelters;
	}

	public EmShelter(String id, String placename, String location, String dept,
			String contraces, String phone, String parentid, String longitude,
			String latitude, String res1, String res2, String x, String y,
			String remark) {
		super();
		this.id = id;
		this.placename = placename;
		this.location = location;
		this.dept = dept;
		this.contraces = contraces;
		this.phone = phone;
		this.parentid = parentid;
		this.longitude = longitude;
		this.latitude = latitude;
		this.res1 = res1;
		this.res2 = res2;
		this.x = x;
		this.y = y;
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

	public void setPlacename(String placename) {
		this.placename = placename;
	}

	@Column(name = "PLACENAME", length = 100)
	public String getPlacename() {
		return placename;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Column(name = "LOCATION", length = 200)
	public String getLocation() {
		return location;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Column(name = "DEPT", length = 30)
	public String getDept() {
		return dept;
	}

	public void setContraces(String contraces) {
		this.contraces = contraces;
	}

	@Column(name = "CONTRACES", length = 30)
	public String getContraces() {
		return contraces;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "PHONE", length = 20)
	public String getPhone() {
		return phone;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	@Column(name = "PARENTID", length = 50)
	public String getParentid() {
		return parentid;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Column(name = "LONGITUDE", length = 20)
	public String getLongitude() {
		return longitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	@Column(name = "LATITUDE", length = 20)
	public String getLatitude() {
		return latitude;
	}

	public void setRes1(String res1) {
		this.res1 = res1;
	}

	@Column(name = "RES1", length = 100)
	public String getRes1() {
		return res1;
	}

	public void setRes2(String res2) {
		this.res2 = res2;
	}

	@Column(name = "RES2", length = 100)
	public String getRes2() {
		return res2;
	}

	public void setX(String x) {
		this.x = x;
	}

	@Column(name = "X", length = 20)
	public String getX() {
		return x;
	}

	public void setY(String y) {
		this.y = y;
	}

	@Column(name = "Y", length = 20)
	public String getY() {
		return y;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "REMARK", length = 2000)
	public String getRemark() {
		return remark;
	}

	public String toString() {
		return "EmShelter [id=" + id + ",placename=" + placename + ",location="
				+ location + ",dept=" + dept + ",contraces=" + contraces
				+ ",phone=" + phone + ",parentid=" + parentid + ",longitude="
				+ longitude + ",latitude=" + latitude + ",res1=" + res1
				+ ",res2=" + res2 + ",x=" + x + ",y=" + y + ",remark=" + remark
				+ "]";
	}

}
