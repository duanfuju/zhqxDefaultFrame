package cn.com.oking.em.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * EM_STORE:���ʲֿ�
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
	 * ���:���
	 */
	private String storenum;

	/**
	 * �ֿ�����:�ֿ�����
	 */
	private String storename;

	/**
	 * ��ϸ˵��:��ϸ˵��
	 */
	private String details;

	/**
	 * ���ܲ���:���ܲ���
	 */
	private String dept;

	/**
	 * ��ϵ������:��ϵ������
	 */
	private String contraces;

	/**
	 * ��ϵ�˵绰:��ϵ�˵绰
	 */
	private String phone;

	/**
	 * λ��:λ��
	 */
	private String location;

	/**
	 * ����:����
	 */
	private String longitude;

	/**
	 * γ��:γ��
	 */
	private String latitude;

	/**
	 * ͼƬ·��:ͼƬ·��
	 */
	private String photo;

	/**
	 * ������ֵ:������ֵ
	 */
	private String x;

	/**
	 * ������ֵ:������ֵ
	 */
	private String y;

	/**
	 * ��ע:��ע
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
