package cn.com.oking.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * WATER_PICTURE:
 */
@Entity
@Table(name = "WATER_PICTURE")
public class WaterPicture implements Serializable {

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
	 * SITEID:
	 */
	private String siteid;

	public WaterPicture() {
		super();
	}

	public WaterPicture(String filename, String filedir, Date filetime,
			String siteid) {
		super();
		this.filename = filename;
		this.filedir = filedir;
		this.filetime = filetime;
		this.siteid = siteid;
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

	@Column(name = "FILEDIR", length = 100)
	public String getFiledir() {
		return filedir;
	}

	public void setFiletime(Date filetime) {
		this.filetime = filetime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FILETIME")
	public Date getFiletime() {
		return filetime;
	}

	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}

	@Column(name = "SITEID", length = 50)
	public String getSiteid() {
		return siteid;
	}

	public String toString() {
		return "WaterPicture [filename=" + filename + ",filedir=" + filedir
				+ ",filetime=" + filetime + ",siteid=" + siteid + "]";
	}

}
