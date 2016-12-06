package cn.com.oking.em.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * EM_RESPONSES_PLAN:应急预案
 */
@Entity
@Table(name = "EM_RESPONSES_PLAN")
public class EmResponsesPlan implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID:
	 */
	private String id;

	/**
	 * 编号:编号
	 */
	private String plannum;

	/**
	 * 预案名称:预案名称
	 */
	private String planname;

	/**
	 * 签发日期:签发日期
	 */
	private Date issuedate;

	/**
	 * 预案内容:预案内容
	 */
	private String content;

	/**
	 * 状态:状态
	 */
	private String status;

	/**
	 * 文件编号:文件编号
	 */
	private String fileid;

	/**
	 * 文件名称:文件名称
	 */
	private String filename;

	public EmResponsesPlan() {
		super();
	}

	public EmResponsesPlan(String id, String plannum, String planname,
			Date issuedate, String content, String status, String fileid,
			String filename) {
		super();
		this.id = id;
		this.plannum = plannum;
		this.planname = planname;
		this.issuedate = issuedate;
		this.content = content;
		this.status = status;
		this.fileid = fileid;
		this.filename = filename;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Id
	@Column(name = "ID", length = 50, nullable = false)
	public String getId() {
		return id;
	}

	public void setPlannum(String plannum) {
		this.plannum = plannum;
	}

	@Column(name = "PLANNUM", length = 500)
	public String getPlannum() {
		return plannum;
	}

	public void setPlanname(String planname) {
		this.planname = planname;
	}

	@Column(name = "PLANNAME", length = 200)
	public String getPlanname() {
		return planname;
	}

	public void setIssuedate(Date issuedate) {
		this.issuedate = issuedate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ISSUEDATE")
	public Date getIssuedate() {
		return issuedate;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "CONTENT", length = 200)
	public String getContent() {
		return content;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "STATUS", length = 10)
	public String getStatus() {
		return status;
	}

	public void setFileid(String fileid) {
		this.fileid = fileid;
	}

	@Column(name = "FILEID", length = 50)
	public String getFileid() {
		return fileid;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Column(name = "FILENAME", length = 1000)
	public String getFilename() {
		return filename;
	}

	public String toString() {
		return "EmResponsesPlan [id=" + id + ",plannum=" + plannum
				+ ",planname=" + planname + ",issuedate=" + issuedate
				+ ",content=" + content + ",status=" + status + ",fileid="
				+ fileid + ",filename=" + filename + "]";
	}

}
