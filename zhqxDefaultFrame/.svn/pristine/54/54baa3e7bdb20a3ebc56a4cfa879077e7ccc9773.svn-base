package cn.com.oking.em.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * EM_XYML_JY:EM_XYML_JY

 */
@Entity
@Table(name = "EM_XYML_JY")
public class EmXymlJy implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID:
	 */
	private String id;

	/**
	 * 响应命令建议编号:响应命令建议编号
	 */
	private String xymlId;

	/**
	 * 响应命令建议主题:响应命令建议主题
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
	 * 建立人:建立人
	 */
	private String createby;

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
	 * 启动条件:启动条件
	 */
	private String conditions;

	/**
	 * 实际情况:实际情况
	 */
	private String situation;

	/**
	 * 紧急通知ID:紧急通知ID
	 */
	private String jjtzId;

	/**
	 * 命令分类:命令分类
	 */
	private String command;

	public EmXymlJy() {
		super();
	}

	public EmXymlJy(String id, String xymlId, String subject, String zhlx,
			String status, String content, String createby, Date createdate,
			String updateby, Date updatedate, String bzId, String conditions,
			String situation, String jjtzId, String command) {
		super();
		this.id = id;
		this.xymlId = xymlId;
		this.subject = subject;
		this.zhlx = zhlx;
		this.status = status;
		this.content = content;
		this.createby = createby;
		this.createdate = createdate;
		this.updateby = updateby;
		this.updatedate = updatedate;
		this.bzId = bzId;
		this.conditions = conditions;
		this.situation = situation;
		this.jjtzId = jjtzId;
		this.command = command;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Id
	@Column(name = "ID", length = 50, nullable = false)
	public String getId() {
		return id;
	}

	public void setXymlId(String xymlId) {
		this.xymlId = xymlId;
	}

	@Column(name = "XYML_ID", length = 50)
	public String getXymlId() {
		return xymlId;
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

	public void setCreateby(String createby) {
		this.createby = createby;
	}

	@Column(name = "CREATEBY", length = 50)
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

	public void setUpdateby(String updateby) {
		this.updateby = updateby;
	}

	@Column(name = "UPDATEBY", length = 50)
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

	@Column(name = "BZ_ID", length = 50)
	public String getBzId() {
		return bzId;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	@Column(name = "CONDITIONS", length = 2000)
	public String getConditions() {
		return conditions;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	@Column(name = "SITUATION", length = 2000)
	public String getSituation() {
		return situation;
	}

	public void setJjtzId(String jjtzId) {
		this.jjtzId = jjtzId;
	}

	@Column(name = "JJTZ_ID", length = 20)
	public String getJjtzId() {
		return jjtzId;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	@Column(name = "COMMAND", length = 100)
	public String getCommand() {
		return command;
	}

	public String toString() {
		return "EmXymlJy [id=" + id + ",xymlId=" + xymlId + ",subject="
				+ subject + ",zhlx=" + zhlx + ",status=" + status + ",content="
				+ content + ",createby=" + createby + ",createdate="
				+ createdate + ",updateby=" + updateby + ",updatedate="
				+ updatedate + ",bzId=" + bzId + ",conditions=" + conditions
				+ ",situation=" + situation + ",jjtzId=" + jjtzId + ",command="
				+ command + "]";
	}

}
