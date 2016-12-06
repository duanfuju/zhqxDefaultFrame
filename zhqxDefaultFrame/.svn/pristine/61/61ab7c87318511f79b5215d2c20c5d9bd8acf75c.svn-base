package cn.com.oking.nk.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;

/**
 * NK_CGKZ_GCKZ:采购控制之过程控制
 */
@Entity
@Table(name = "NK_CGKZ_GCKZ")
public class NkCgkzGckz implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键:主键
	 */
	private String id;

	/**
	 * 文件编号:文件编号
	 */
	private String nkNum;

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
	private String gcType;

	/**
	 * 文件关联编号:文件关联编号
	 */
	private String fileid;

	/**
	 * 备注:备注
	 */
	private String remark;

	public NkCgkzGckz() {
		super();
	}

	public NkCgkzGckz(String id, String nkNum, String content, Date upDate,
			String gcType, String fileid, String remark) {
		super();
		this.id = id;
		this.nkNum = nkNum;
		this.content = content;
		this.upDate = upDate;
		this.gcType = gcType;
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

	public void setNkNum(String nkNum) {
		this.nkNum = nkNum;
	}

	@Column(name = "NK_NUM", length = 50)
	public String getNkNum() {
		return nkNum;
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

	public void setGcType(String gcType) {
		this.gcType = gcType;
	}

	@Column(name = "GC_TYPE", length = 8)
	public String getGcType() {
		return gcType;
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
		return "NkCgkzGckz [id=" + id + ",nkNum=" + nkNum + ",content="
				+ content + ",upDate=" + upDate + ",gcType=" + gcType
				+ ",fileid=" + fileid + ",remark=" + remark + "]";
	}

}
