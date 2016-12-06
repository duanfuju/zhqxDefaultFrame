package cn.com.oking.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * T_JS_OBT_MIN_RAIN:????????
 */
@Entity
@Table(name = "T_JS_OBT_MIN_RAIN")
public class TJsObtMinRain implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 日期和时间:日期和时间
	 */
	private Date ddatetime;

	/**
	 * 数据时间-北京时间:数据时间-北京时间
	 */
	private Date bjDatetime;

	/**
	 * 数据时间-年:数据时间-年
	 */
	private String year;

	/**
	 * 数据时间-月:数据时间-月
	 */
	private String month;

	/**
	 * 数据时间-日:数据时间-日
	 */
	private String day;

	/**
	 * 数据时间-小时:数据时间-小时
	 */
	private String hour;

	/**
	 * 数据时间-分:数据时间-分
	 */
	private String minute;

	/**
	 * 自动站点的代码，定长5个字符:自动站点的代码，定长5个字符
	 */
	private String obtid;

	/**
	 * 本小时的累计雨量（单位:0.1mm）:本小时的累计雨量（单位:0.1mm）
	 */
	private BigDecimal hourr;

	/**
	 * 过去3小时雨量:过去3小时雨量
	 */
	private BigDecimal hour3r;

	/**
	 * 过去6小时雨量:过去6小时雨量
	 */
	private BigDecimal hour6r;

	/**
	 * 过去12小时雨量:过去12小时雨量
	 */
	private BigDecimal hour12r;

	/**
	 * 过去24小时雨量:过去24小时雨量
	 */
	private BigDecimal hour24r;

	/**
	 * 人工加密观测降水量描述时间周期:人工加密观测降水量描述时间周期
	 */
	private BigDecimal rmdz;

	/**
	 * 人工加密观测想水量:人工加密观测想水量
	 */
	private BigDecimal rmjm;

	/**
	 * 小时蒸发量:小时蒸发量
	 */
	private BigDecimal rmzf;

	/**
	 * 20小时后雨量:20小时后雨量
	 */
	private BigDecimal r202n;

	/**
	 * 5小时后雨量:5小时后雨量
	 */
	private BigDecimal r52n;

	/**
	 * 过去1小时的降雨量:过去1小时的降雨量
	 */
	private BigDecimal hour1r;

	public TJsObtMinRain() {
		super();
	}

	public TJsObtMinRain(Date ddatetime, Date bjDatetime, String year,
			String month, String day, String hour, String minute, String obtid,
			BigDecimal hourr, BigDecimal hour3r, BigDecimal hour6r,
			BigDecimal hour12r, BigDecimal hour24r, BigDecimal rmdz,
			BigDecimal rmjm, BigDecimal rmzf, BigDecimal r202n,
			BigDecimal r52n, BigDecimal hour1r) {
		super();
		this.ddatetime = ddatetime;
		this.bjDatetime = bjDatetime;
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
		this.obtid = obtid;
		this.hourr = hourr;
		this.hour3r = hour3r;
		this.hour6r = hour6r;
		this.hour12r = hour12r;
		this.hour24r = hour24r;
		this.rmdz = rmdz;
		this.rmjm = rmjm;
		this.rmzf = rmzf;
		this.r202n = r202n;
		this.r52n = r52n;
		this.hour1r = hour1r;
	}

	public void setDdatetime(Date ddatetime) {
		this.ddatetime = ddatetime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DDATETIME", nullable = false)
	public Date getDdatetime() {
		return ddatetime;
	}

	public void setBjDatetime(Date bjDatetime) {
		this.bjDatetime = bjDatetime;
	}

	@Id
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "BJ_DATETIME", nullable = false)
	public Date getBjDatetime() {
		return bjDatetime;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Column(name = "YEAR", length = 4)
	public String getYear() {
		return year;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	@Column(name = "MONTH", length = 2)
	public String getMonth() {
		return month;
	}

	public void setDay(String day) {
		this.day = day;
	}

	@Column(name = "DAY", length = 2)
	public String getDay() {
		return day;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	@Column(name = "HOUR", length = 2)
	public String getHour() {
		return hour;
	}

	public void setMinute(String minute) {
		this.minute = minute;
	}

	@Column(name = "MINUTE", length = 2)
	public String getMinute() {
		return minute;
	}

	public void setObtid(String obtid) {
		this.obtid = obtid;
	}

	@Id
	@Column(name = "OBTID", length = 5, nullable = false)
	public String getObtid() {
		return obtid;
	}

	public void setHourr(BigDecimal hourr) {
		this.hourr = hourr;
	}

	@Column(name = "HOURR")
	public BigDecimal getHourr() {
		return hourr;
	}

	public void setHour3r(BigDecimal hour3r) {
		this.hour3r = hour3r;
	}

	@Column(name = "HOUR3R")
	public BigDecimal getHour3r() {
		return hour3r;
	}

	public void setHour6r(BigDecimal hour6r) {
		this.hour6r = hour6r;
	}

	@Column(name = "HOUR6R")
	public BigDecimal getHour6r() {
		return hour6r;
	}

	public void setHour12r(BigDecimal hour12r) {
		this.hour12r = hour12r;
	}

	@Column(name = "HOUR12R")
	public BigDecimal getHour12r() {
		return hour12r;
	}

	public void setHour24r(BigDecimal hour24r) {
		this.hour24r = hour24r;
	}

	@Column(name = "HOUR24R")
	public BigDecimal getHour24r() {
		return hour24r;
	}

	public void setRmdz(BigDecimal rmdz) {
		this.rmdz = rmdz;
	}

	@Column(name = "RMDZ")
	public BigDecimal getRmdz() {
		return rmdz;
	}

	public void setRmjm(BigDecimal rmjm) {
		this.rmjm = rmjm;
	}

	@Column(name = "RMJM")
	public BigDecimal getRmjm() {
		return rmjm;
	}

	public void setRmzf(BigDecimal rmzf) {
		this.rmzf = rmzf;
	}

	@Column(name = "RMZF")
	public BigDecimal getRmzf() {
		return rmzf;
	}

	public void setR202n(BigDecimal r202n) {
		this.r202n = r202n;
	}

	@Column(name = "R202N")
	public BigDecimal getR202n() {
		return r202n;
	}

	public void setR52n(BigDecimal r52n) {
		this.r52n = r52n;
	}

	@Column(name = "R52N")
	public BigDecimal getR52n() {
		return r52n;
	}

	public void setHour1r(BigDecimal hour1r) {
		this.hour1r = hour1r;
	}

	@Column(name = "HOUR1R")
	public BigDecimal getHour1r() {
		return hour1r;
	}

	public String toString() {
		return "TJsObtMinRain [ddatetime=" + ddatetime + ",bjDatetime="
				+ bjDatetime + ",year=" + year + ",month=" + month + ",day="
				+ day + ",hour=" + hour + ",minute=" + minute + ",obtid="
				+ obtid + ",hourr=" + hourr + ",hour3r=" + hour3r + ",hour6r="
				+ hour6r + ",hour12r=" + hour12r + ",hour24r=" + hour24r
				+ ",rmdz=" + rmdz + ",rmjm=" + rmjm + ",rmzf=" + rmzf
				+ ",r202n=" + r202n + ",r52n=" + r52n + ",hour1r=" + hour1r
				+ "]";
	}

}
