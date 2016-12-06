package cn.com.oking.em.entity;

import java.io.Serializable;


@SuppressWarnings("serial")
public class XEmSupplies extends EmSupplies implements Serializable {


	/**
	 * ����:����
	 */
	private String longitude;

	/**
	 * γ��:γ��
	 */
	private String latitude;

	

	public XEmSupplies(String longitude, String latitude) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
	}



	public String getLongitude() {
		return longitude;
	}



	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}



	public String getLatitude() {
		return latitude;
	}



	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}



	public XEmSupplies() {
		super();
	}
	

}
