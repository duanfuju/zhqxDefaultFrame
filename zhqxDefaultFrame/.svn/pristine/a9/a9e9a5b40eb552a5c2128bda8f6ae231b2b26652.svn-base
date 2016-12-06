package cn.com.oking.nk.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * TAB_CONTROL:菜单管理
 */
@Entity
@Table(name = "TAB_CONTROL")
public class TabControl implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键:主键
	 */
	private String id;

	/**
	 * 关联编号:关联编号
	 */
	private String associateId;

	/**
	 * 关联JSP:关联JSP
	 */
	private String link;

	/**
	 * 关联JSP参数:关联JSP参数
	 */
	private String params;

	/**
	 * TAB名称:TAB名称
	 */
	private String tabName;

	/**
	 * 序列号:序列号
	 */
	private BigDecimal orderNum;

	public TabControl() {
		super();
	}

	public TabControl(String id, String associateId, String link,
			String params, String tabName, BigDecimal orderNum) {
		super();
		this.id = id;
		this.associateId = associateId;
		this.link = link;
		this.params = params;
		this.tabName = tabName;
		this.orderNum = orderNum;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Id
	@Column(name = "ID", length = 50, nullable = false)
	public String getId() {
		return id;
	}

	public void setAssociateId(String associateId) {
		this.associateId = associateId;
	}

	@Column(name = "ASSOCIATE_ID", length = 50)
	public String getAssociateId() {
		return associateId;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Column(name = "LINK", length = 50)
	public String getLink() {
		return link;
	}

	public void setParams(String params) {
		this.params = params;
	}

	@Column(name = "PARAMS", length = 200)
	public String getParams() {
		return params;
	}

	public void setTabName(String tabName) {
		this.tabName = tabName;
	}

	@Column(name = "TAB_NAME", length = 50)
	public String getTabName() {
		return tabName;
	}

	public void setOrderNum(BigDecimal orderNum) {
		this.orderNum = orderNum;
	}

	@Column(name = "ORDER_NUM")
	public BigDecimal getOrderNum() {
		return orderNum;
	}

	public String toString() {
		return "TabControl [id=" + id + ",associateId=" + associateId
				+ ",link=" + link + ",params=" + params + ",tabName=" + tabName
				+ ",orderNum=" + orderNum + "]";
	}

}
