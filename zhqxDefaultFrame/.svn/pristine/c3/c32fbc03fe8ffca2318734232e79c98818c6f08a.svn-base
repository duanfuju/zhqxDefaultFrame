package cn.com.oking.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * WATER_STATION_MANAGER:站点管理
 */
@Entity
@Table(name = "WATER_STATION_MANAGER")
public class WaterStationManager implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键:主键
	 */
	private String id;

	/**
	 * 站点编号:站点编号
	 */
	private String stationNum;

	/**
	 * 地点:地点
	 */
	private String place;

	public WaterStationManager() {
		super();
	}

	public WaterStationManager(String id, String stationNum, String place) {
		super();
		this.id = id;
		this.stationNum = stationNum;
		this.place = place;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Id
	@Column(name = "ID", length = 50, nullable = false)
	public String getId() {
		return id;
	}

	public void setStationNum(String stationNum) {
		this.stationNum = stationNum;
	}

	@Column(name = "STATION_NUM", length = 50)
	public String getStationNum() {
		return stationNum;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@Column(name = "PLACE", length = 200)
	public String getPlace() {
		return place;
	}

	public String toString() {
		return "WaterStationManager [id=" + id + ",stationNum=" + stationNum
				+ ",place=" + place + "]";
	}

}
