package cn.com.oking.em.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * EM_MONITORING:视频监控
 */
@Entity
@Table(name = "EM_MONITORING")
public class EmMonitoring implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID:
	 */
	private String id;

	/**
	 * 视频监控:视频监控
	 */
	private String sname;

	/**
	 * 设备编号:设备编号
	 */
	private String equipmentnum;

	/**
	 * 安装位置:安装位置
	 */
	private String location;

	/**
	 * 主管部门:主管部门
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
	 * PARENTID:
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
	 * 路径地址:路径地址
	 */
	private String path;

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

	/**
	 * 状态:状态
	 */
	private String status;

	public EmMonitoring() {
		super();
	}

	public EmMonitoring(String id, String sname, String equipmentnum,
			String location, String dept, String contraces, String phone,
			String parentid, String longitude, String latitude, String path,
			String x, String y, String remark, String status) {
		super();
		this.id = id;
		this.sname = sname;
		this.equipmentnum = equipmentnum;
		this.location = location;
		this.dept = dept;
		this.contraces = contraces;
		this.phone = phone;
		this.parentid = parentid;
		this.longitude = longitude;
		this.latitude = latitude;
		this.path = path;
		this.x = x;
		this.y = y;
		this.remark = remark;
		this.status = status;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Id
	@Column(name = "ID", length = 50, nullable = false)
	public String getId() {
		return id;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	@Column(name = "SNAME", length = 100)
	public String getSname() {
		return sname;
	}

	public void setEquipmentnum(String equipmentnum) {
		this.equipmentnum = equipmentnum;
	}

	@Column(name = "EQUIPMENTNUM", length = 30)
	public String getEquipmentnum() {
		return equipmentnum;
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

	public void setPath(String path) {
		this.path = path;
	}

	@Column(name = "PATH", length = 100)
	public String getPath() {
		return path;
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

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "status", length = 100)
	public String getStatus() {
		return status;
	}

	public String toString() {
		return "EmMonitoring [id=" + id + ",sname=" + sname + ",equipmentnum="
				+ equipmentnum + ",location=" + location + ",dept=" + dept
				+ ",contraces=" + contraces + ",phone=" + phone + ",parentid="
				+ parentid + ",longitude=" + longitude + ",latitude="
				+ latitude + ",path=" + path + ",x=" + x + ",y=" + y
				+ ",remark=" + remark + ",status=" + status + "]";
	}

}
