package cn.com.oking.em.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * EM_STORE:物资仓库
 */
@Entity
@Table(name = "EM_STORE")
public class EmStore implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID:
	 */
	private String id;

	/**
	 * 编号:编号
	 */
	private String storenum;

	/**
	 * 仓库名称:仓库名称
	 */
	private String storename;

	/**
	 * 详细说明:详细说明
	 */
	private String details;

	/**
	 * 主管部门:主管部门
	 */
	private String dept;

	/**
	 * 联系人姓名:联系人姓名
	 */
	private String contraces;

	/**
	 * 联系人电话:联系人电话
	 */
	private String phone;

	/**
	 * 位置:位置
	 */
	private String location;

	/**
	 * 经度:经度
	 */
	private String longitude;

	/**
	 * 纬度:纬度
	 */
	private String latitude;

	/**
	 * 图片路径:图片路径
	 */
	private String photo;

	/**
	 * 横坐标值:横坐标值
	 */
	private String x;

	/**
	 * 纵坐标值:纵坐标值
	 */
	private String y;

	/**
	 * 备注:备注
	 */
	private String remark;

	public EmStore() {
		super();
	}

	public EmStore(String id, String storenum, String storename,
			String details, String dept, String contraces, String phone,
			String location, String longitude, String latitude, String photo,
			String x, String y, String remark) {
		super();
		this.id = id;
		this.storenum = storenum;
		this.storename = storename;
		this.details = details;
		this.dept = dept;
		this.contraces = contraces;
		this.phone = phone;
		this.location = location;
		this.longitude = longitude;
		this.latitude = latitude;
		this.photo = photo;
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

	public void setStorenum(String storenum) {
		this.storenum = storenum;
	}

	@Column(name = "STORENUM", length = 20)
	public String getStorenum() {
		return storenum;
	}

	public void setStorename(String storename) {
		this.storename = storename;
	}

	@Column(name = "STORENAME", length = 100)
	public String getStorename() {
		return storename;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Column(name = "DETAILS", length = 1000)
	public String getDetails() {
		return details;
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

	public void setLocation(String location) {
		this.location = location;
	}

	@Column(name = "LOCATION", length = 200)
	public String getLocation() {
		return location;
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

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Column(name = "PHOTO", length = 100)
	public String getPhoto() {
		return photo;
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
		return "EmStore [id=" + id + ",storenum=" + storenum + ",storename="
				+ storename + ",details=" + details + ",dept=" + dept
				+ ",contraces=" + contraces + ",phone=" + phone + ",location="
				+ location + ",longitude=" + longitude + ",latitude="
				+ latitude + ",photo=" + photo + ",x=" + x + ",y=" + y
				+ ",remark=" + remark + "]";
	}

}
