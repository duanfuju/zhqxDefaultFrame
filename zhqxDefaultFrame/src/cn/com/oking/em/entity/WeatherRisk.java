package cn.com.oking.em.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * WEATHER_RISK:
 */
@Entity
@Table(name = "WEATHER_RISK")
public class WeatherRisk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * FILENAME:
	 */
	private String filename;

	/**
	 * FILEDIR:
	 */
	private String filedir;

	/**
	 * FILETIME:
	 */
	private Date filetime;

	/**
	 * FILETYPE:
	 */
	private String filetype;

	public WeatherRisk() {
		super();
	}

	public WeatherRisk(String filename, String filedir, Date filetime,
			String filetype) {
		super();
		this.filename = filename;
		this.filedir = filedir;
		this.filetime = filetime;
		this.filetype = filetype;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Id
	@Column(name = "FILENAME", length = 50, nullable = false)
	public String getFilename() {
		return filename;
	}

	public void setFiledir(String filedir) {
		this.filedir = filedir;
	}

	@Column(name = "FILEDIR", length = 50)
	public String getFiledir() {
		return filedir;
	}

	public void setFiletime(Date filetime) {
		this.filetime = filetime;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FILETIME")
	public Date getFiletime() {
		return filetime;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	@Column(name = "FILETYPE", length = 50)
	public String getFiletype() {
		return filetype;
	}

	public String toString() {
		return "WeatherRisk [filename=" + filename + ",filedir=" + filedir
				+ ",filetime=" + filetime + ",filetype=" + filetype + "]";
	}

}
