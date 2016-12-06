package cn.com.oking.em.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * EM_JJTZ_JY:紧急通知建议
 */
@Entity
@Table(name = "EM_JJTZ_JY")
public class EmJjtzJy implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID:
	 */
	private String id;

	/**
	 * 紧急通知建议ID:紧急通知建议ID
	 */
	private String tzjyId;

	/**
	 * 紧急通知主题:紧急通知主题
	 */
	private String subject;

	/**
	 * 灾害类型:灾害类型
	 */
	private String zhlx;

	/**
	 * 状态:状态
	 */
	private String status;

	/**
	 * 紧急通知内容:紧急通知内容
	 */
	private String content;

	/**
	 * 生成时间:生成时间
	 */
	private Date createdate;

	/**
	 * 操作人:操作人
	 */
	private String updateby;

	/**
	 * 操作时间:操作时间
	 */
	private Date updatedate;

	/**
	 * 引用标准ID:引用标准ID
	 */
	private String bzId;

	/**
	 * 建立人:建立人
	 */
	private String createby;

	public EmJjtzJy() {
		super();
	}

	public EmJjtzJy(String id, String tzjyId, String subject, String zhlx,
			String status, String content, Date createdate, String updateby,
			Date updatedate, String bzId, String createby) {
		super();
		this.id = id;
		this.tzjyId = tzjyId;
		this.subject = subject;
		this.zhlx = zhlx;
		this.status = status;
		this.content = content;
		this.createdate = createdate;
		this.updateby = updateby;
		this.updatedate = updatedate;
		this.bzId = bzId;
		this.createby = createby;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Id
	@Column(name = "ID", length = 50, nullable = false)
	public String getId() {
		return id;
	}

	public void setTzjyId(String tzjyId) {
		this.tzjyId = tzjyId;
	}

	@Column(name = "TZJY_ID", length = 20)
	public String getTzjyId() {
		return tzjyId;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Column(name = "SUBJECT", length = 200)
	public String getSubject() {
		return subject;
	}

	public void setZhlx(String zhlx) {
		this.zhlx = zhlx;
	}

	@Column(name = "ZHLX", length = 30)
	public String getZhlx() {
		return zhlx;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "STATUS", length = 20)
	public String getStatus() {
		return status;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "CONTENT", length = 2000)
	public String getContent() {
		return content;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATEDATE")
	public Date getCreatedate() {
		return createdate;
	}

	public void setUpdateby(String updateby) {
		this.updateby = updateby;
	}

	@Column(name = "UPDATEBY", length = 30)
	public String getUpdateby() {
		return updateby;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATEDATE")
	public Date getUpdatedate() {
		return updatedate;
	}

	public void setBzId(String bzId) {
		this.bzId = bzId;
	}

	@Column(name = "BZ_ID", length = 20)
	public String getBzId() {
		return bzId;
	}

	public void setCreateby(String createby) {
		this.createby = createby;
	}

	@Column(name = "CREATEBY", length = 50)
	public String getCreateby() {
		return createby;
	}

	public String toString() {
		return "EmJjtzJy [id=" + id + ",tzjyId=" + tzjyId + ",subject="
				+ subject + ",zhlx=" + zhlx + ",status=" + status + ",content="
				+ content + ",createdate=" + createdate + ",updateby="
				+ updateby + ",updatedate=" + updatedate + ",bzId=" + bzId
				+ ",createby=" + createby + "]";
	}

}
