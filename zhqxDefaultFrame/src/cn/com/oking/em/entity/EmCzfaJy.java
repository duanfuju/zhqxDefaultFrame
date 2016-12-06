package cn.com.oking.em.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * EM_CZFA_JY:处置方案建议
 */
@Entity
@Table(name = "EM_CZFA_JY")
public class EmCzfaJy implements Serializable {

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
	 * 灾害类型:灾害类型
	 */
	private String zhlx;

	/**
	 * 引用标准ID:引用标准ID
	 */
	private String bzId;

	/**
	 * 状态:状态
	 */
	private String status;

	/**
	 * 响应级别:响应级别
	 */
	private String responseLevel;

	/**
	 * 命令编号:命令编号
	 */
	private String orderNumber;

	/**
	 * 建立人:建立人
	 */
	private String createby;

	/**
	 * 发布时间:发布时间
	 */
	private Date createdate;

	public EmCzfaJy() {
		super();
	}

	public EmCzfaJy(String id, String jjtzId, String zhlx, String bzId,
			String status, String responseLevel, String orderNumber,
			String createby, Date createdate) {
		super();
		this.id = id;
		this.jjtzId = jjtzId;
		this.zhlx = zhlx;
		this.bzId = bzId;
		this.status = status;
		this.responseLevel = responseLevel;
		this.orderNumber = orderNumber;
		this.createby = createby;
		this.createdate = createdate;
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

	@Column(name = "JJTZ_ID", length = 50)
	public String getJjtzId() {
		return jjtzId;
	}

	public void setZhlx(String zhlx) {
		this.zhlx = zhlx;
	}

	@Column(name = "ZHLX", length = 30)
	public String getZhlx() {
		return zhlx;
	}

	public void setBzId(String bzId) {
		this.bzId = bzId;
	}

	@Column(name = "BZ_ID", length = 20)
	public String getBzId() {
		return bzId;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "STATUS", length = 20)
	public String getStatus() {
		return status;
	}

	public void setResponseLevel(String responseLevel) {
		this.responseLevel = responseLevel;
	}

	@Column(name = "RESPONSE_LEVEL", length = 20)
	public String getResponseLevel() {
		return responseLevel;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	@Column(name = "ORDER_NUMBER", length = 50)
	public String getOrderNumber() {
		return orderNumber;
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

	public String toString() {
		return "EmCzfaJy [id=" + id + ",jjtzId=" + jjtzId + ",zhlx=" + zhlx
				+ ",bzId=" + bzId + ",status=" + status + ",responseLevel="
				+ responseLevel + ",orderNumber=" + orderNumber + ",createby="
				+ createby + ",createdate=" + createdate + "]";
	}

}
