package cn.com.oking.em.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * EM_DISPLAY_MODE:显示模式
 */
@Entity
@Table(name = "EM_DISPLAY_MODE")
public class EmDisplayMode implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键:主键
	 */
	private String dmId;

	/**
	 * 模式编号:模式编号
	 */
	private String dmNum;

	/**
	 * 描述:描述
	 */
	private String description;

	/**
	 * 状态:状态
	 */
	private String status;

	/**
	 * 类型:类型
	 */
	private String type;

	/**
	 * 模板:模板
	 */
	private String template;

	public EmDisplayMode() {
		super();
	}

	public EmDisplayMode(String dmId, String dmNum, String description,
			String status, String type, String template) {
		super();
		this.dmId = dmId;
		this.dmNum = dmNum;
		this.description = description;
		this.status = status;
		this.type = type;
		this.template = template;
	}

	public void setDmId(String dmId) {
		this.dmId = dmId;
	}

	@Id
	@Column(name = "DM_ID", length = 50, nullable = false)
	public String getDmId() {
		return dmId;
	}

	public void setDmNum(String dmNum) {
		this.dmNum = dmNum;
	}

	@Column(name = "DM_NUM", length = 50)
	public String getDmNum() {
		return dmNum;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "DESCRIPTION", length = 200)
	public String getDescription() {
		return description;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "STATUS", length = 8)
	public String getStatus() {
		return status;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "TYPE", length = 8)
	public String getType() {
		return type;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	@Column(name = "TEMPLATE", length = 50)
	public String getTemplate() {
		return template;
	}

	public String toString() {
		return "EmDisplayMode [dmId=" + dmId + ",dmNum=" + dmNum
				+ ",description=" + description + ",status=" + status
				+ ",type=" + type + ",template=" + template + "]";
	}

}
