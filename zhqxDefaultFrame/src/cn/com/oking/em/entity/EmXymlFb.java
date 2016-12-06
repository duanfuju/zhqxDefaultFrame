package cn.com.oking.em.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * EM_XYML_FB:代拟指令和发布指令
 */
@Entity
@Table(name = "EM_XYML_FB")
public class EmXymlFb implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID:
	 */
	private String id;

	/**
	 * 指令编号:指令编号
	 */
	private String zlbhId;

	/**
	 * 指令内容:指令内容
	 */
	private String content;

	/**
	 * 灾害类型:灾害类型
	 */
	private String zhlx;

	/**
	 * 状态:状态
	 */
	private String status;

	/**
	 * 引用标准ID:引用标准ID
	 */
	private String bzId;

	/**
	 * 关联的响应命令建议id:关联的响应命令建议id
	 */
	private String xymlId;

	/**
	 * 紧急通知ID:紧急通知ID
	 */
	private String jjtzId;

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

	/**
	 * 相关通知:相关通知
	 */
	private String relatedNotice;

	/**
	 * 短信提醒:短信提醒
	 */
	private String sms;

	public EmXymlFb() {
		super();
	}

	public EmXymlFb(String id, String zlbhId, String content, String zhlx,
			String status, String bzId, String xymlId, String jjtzId,
			String createby, Date createdate, String appby, Date appdate,
			String pubby, Date pubdate, String relatedNotice, String sms) {
		super();
		this.id = id;
		this.zlbhId = zlbhId;
		this.content = content;
		this.zhlx = zhlx;
		this.status = status;
		this.bzId = bzId;
		this.xymlId = xymlId;
		this.jjtzId = jjtzId;
		this.createby = createby;
		this.createdate = createdate;
		this.appby = appby;
		this.appdate = appdate;
		this.pubby = pubby;
		this.pubdate = pubdate;
		this.relatedNotice = relatedNotice;
		this.sms = sms;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Id
	@Column(name = "ID", length = 50, nullable = false)
	public String getId() {
		return id;
	}

	public void setZlbhId(String zlbhId) {
		this.zlbhId = zlbhId;
	}

	@Column(name = "ZLBH_ID", length = 50)
	public String getZlbhId() {
		return zlbhId;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "CONTENT", length = 2000)
	public String getContent() {
		return content;
	}

	public void setZhlx(String zhlx) {
		this.zhlx = zhlx;
	}

	@Column(name = "ZHLX", length = 20)
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

	public void setBzId(String bzId) {
		this.bzId = bzId;
	}

	@Column(name = "BZ_ID", length = 20)
	public String getBzId() {
		return bzId;
	}

	public void setXymlId(String xymlId) {
		this.xymlId = xymlId;
	}

	@Column(name = "XYML_ID", length = 50)
	public String getXymlId() {
		return xymlId;
	}

	public void setJjtzId(String jjtzId) {
		this.jjtzId = jjtzId;
	}

	@Column(name = "JJTZ_ID", length = 20)
	public String getJjtzId() {
		return jjtzId;
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

	public void setRelatedNotice(String relatedNotice) {
		this.relatedNotice = relatedNotice;
	}

	@Column(name = "RELATED_NOTICE", length = 2000)
	public String getRelatedNotice() {
		return relatedNotice;
	}

	public void setSms(String sms) {
		this.sms = sms;
	}

	@Column(name = "SMS", length = 2000)
	public String getSms() {
		return sms;
	}

	public String toString() {
		return "EmXymlFb [id=" + id + ",zlbhId=" + zlbhId + ",content="
				+ content + ",zhlx=" + zhlx + ",status=" + status + ",bzId="
				+ bzId + ",xymlId=" + xymlId + ",jjtzId=" + jjtzId
				+ ",createby=" + createby + ",createdate=" + createdate
				+ ",appby=" + appby + ",appdate=" + appdate + ",pubby=" + pubby
				+ ",pubdate=" + pubdate + ",relatedNotice=" + relatedNotice
				+ ",sms=" + sms + "]";
	}

}
