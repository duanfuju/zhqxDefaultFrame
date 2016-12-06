package cn.com.oking.nk.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;

/**
 * NK_ALL_ZCWJ:政策文件
 */
@Entity
@Table(name = "NK_ALL_ZCWJ")
public class NkAllZcwj implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键:主键
	 */
	private String id;

	/**
	 * 内容:内容
	 */
	private String content;

	/**
	 * 日期:日期
	 */
	private Date upDate;

	/**
	 * 类型:类型
	 */
	private String zcwjType;

	/**
	 * 文件关联编号:文件关联编号
	 */
	private String fileid;

	/**
	 * 备注:备注
	 */
	private String remark;

	public NkAllZcwj() {
		super();
	}

	public NkAllZcwj(String id, String content, Date upDate, String zcwjType,
			String fileid, String remark) {
		super();
		this.id = id;
		this.content = content;
		this.upDate = upDate;
		this.zcwjType = zcwjType;
		this.fileid = fileid;
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

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "CONTENT", length = 200)
	public String getContent() {
		return content;
	}

	public void setUpDate(Date upDate) {
		this.upDate = upDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UP_DATE")
	public Date getUpDate() {
		return upDate;
	}

	public void setZcwjType(String zcwjType) {
		this.zcwjType = zcwjType;
	}

	@Column(name = "ZCWJ_TYPE", length = 8)
	public String getZcwjType() {
		return zcwjType;
	}

	public void setFileid(String fileid) {
		this.fileid = fileid;
	}

	@Column(name = "FILEID", length = 50)
	public String getFileid() {
		return fileid;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "REMARK", length = 200)
	public String getRemark() {
		return remark;
	}

	public String toString() {
		return "NkAllZcwj [id=" + id + ",content=" + content + ",upDate="
				+ upDate + ",zcwjType=" + zcwjType + ",fileid=" + fileid
				+ ",remark=" + remark + "]";
	}

}
