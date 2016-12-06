package cn.com.oking.em.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * EM_JJTZ_FB:紧急通知
 */
@Entity
@Table(name = "EM_JJTZ_FB")
public class EmJjtzFb implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * id:id
	 */
	private String id;

	/**
	 * 紧急通知建议ID:紧急通知建议ID
	 */
	private String jjtzId;

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
	 * 引用标准ID:引用标准ID
	 */
	private String bzId;

	/**
	 * 关联的紧急通知建议ID:关联的紧急通知建议ID
	 */
	private String tzjyId;

	/**
	 * 建立人:建立人
	 */
	private String createby;

	/**
	 * 建立时间:建立时间
	 */
	private Date createdate;

	/**
	 * 批准人:批准人
	 */
	private String appby;

	/**
	 * 批准时间:批准时间
	 */
	private Date appdate;

	/**
	 * 发布人:发布人
	 */
	private String pubby;

	/**
	 * 发布时间:发布时间
	 */
	private Date pubdate;

	public EmJjtzFb() {
		super();
	}

	public EmJjtzFb(String id, String jjtzId, String subject, String zhlx,
			String status, String content, String bzId, String tzjyId,
			String createby, Date createdate, String appby, Date appdate,
			String pubby, Date pubdate) {
		super();
		this.id = id;
		this.jjtzId = jjtzId;
		this.subject = subject;
		this.zhlx = zhlx;
		this.status = status;
		this.content = content;
		this.bzId = bzId;
		this.tzjyId = tzjyId;
		this.createby = createby;
		this.createdate = createdate;
		this.appby = appby;
		this.appdate = appdate;
		this.pubby = pubby;
		this.pubdate = pubdate;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Id
	@Column(name = "ID", length = 50, nullable = false)
	public String getId() {
		return id;
	}

	public void setJjtzId(String jjtzId) {
		this.jjtzId = jjtzId;
	}

	@Column(name = "JJTZ_ID", length = 20)
	public String getJjtzId() {
		return jjtzId;
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

	public void setBzId(String bzId) {
		this.bzId = bzId;
	}

	@Column(name = "BZ_ID", length = 20)
	public String getBzId() {
		return bzId;
	}

	public void setTzjyId(String tzjyId) {
		this.tzjyId = tzjyId;
	}

	@Column(name = "TZJY_ID", length = 20)
	public String getTzjyId() {
		return tzjyId;
	}

	public void setCreateby(String createby) {
		this.createby = createby;
	}

	@Column(name = "CREATEBY", length = 20)
	public String getCreateby() {
		return createby;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATEDATE")
	public Date getCreatedate() {
		return createdate;
	}

	public void setAppby(String appby) {
		this.appby = appby;
	}

	@Column(name = "APPBY", length = 20)
	public String getAppby() {
		return appby;
	}

	public void setAppdate(Date appdate) {
		this.appdate = appdate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "APPDATE")
	public Date getAppdate() {
		return appdate;
	}

	public void setPubby(String pubby) {
		this.pubby = pubby;
	}

	@Column(name = "PUBBY", length = 20)
	public String getPubby() {
		return pubby;
	}

	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PUBDATE")
	public Date getPubdate() {
		return pubdate;
	}

	public String toString() {
		return "EmJjtzFb [id=" + id + ",jjtzId=" + jjtzId + ",subject="
				+ subject + ",zhlx=" + zhlx + ",status=" + status + ",content="
				+ content + ",bzId=" + bzId + ",tzjyId=" + tzjyId
				+ ",createby=" + createby + ",createdate=" + createdate
				+ ",appby=" + appby + ",appdate=" + appdate + ",pubby=" + pubby
				+ ",pubdate=" + pubdate + "]";
	}

}
