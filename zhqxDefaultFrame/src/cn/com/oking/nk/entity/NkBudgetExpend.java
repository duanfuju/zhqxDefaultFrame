package cn.com.oking.nk.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * NK_BUDGET_EXPEND:支出情况
 */
@Entity
@Table(name = "NK_BUDGET_EXPEND")
public class NkBudgetExpend implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id:id
	 */
	private String id;

	/**
	 * 内容:内容
	 */
	private String content;

	/**
	 * 收入预算:收入预算
	 */
	private BigDecimal revenueBudget;

	/**
	 * 实际收入:实际收入
	 */
	private BigDecimal realRevenue;

	/**
	 * 支出预算:支出预算
	 */
	private BigDecimal expendBudget;

	/**
	 * 实际支出:实际支出
	 */
	private BigDecimal realExpend;

	/**
	 * 状态:状态
	 */
	private String status;

	/**
	 * 父编号:父编号
	 */
	private String parentId;

	/**
	 * 关联编号:关联编号
	 */
	private String associateId;

	public NkBudgetExpend() {
		super();
	}

	public NkBudgetExpend(String id, String content, BigDecimal revenueBudget,
			BigDecimal realRevenue, BigDecimal expendBudget,
			BigDecimal realExpend, String status, String parentId,
			String associateId) {
		super();
		this.id = id;
		this.content = content;
		this.revenueBudget = revenueBudget;
		this.realRevenue = realRevenue;
		this.expendBudget = expendBudget;
		this.realExpend = realExpend;
		this.status = status;
		this.parentId = parentId;
		this.associateId = associateId;
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

	@Column(name = "CONTENT", length = 500)
	public String getContent() {
		return content;
	}

	public void setRevenueBudget(BigDecimal revenueBudget) {
		this.revenueBudget = revenueBudget;
	}

	@Column(name = "REVENUE_BUDGET")
	public BigDecimal getRevenueBudget() {
		return revenueBudget;
	}

	public void setRealRevenue(BigDecimal realRevenue) {
		this.realRevenue = realRevenue;
	}

	@Column(name = "REAL_REVENUE")
	public BigDecimal getRealRevenue() {
		return realRevenue;
	}

	public void setExpendBudget(BigDecimal expendBudget) {
		this.expendBudget = expendBudget;
	}

	@Column(name = "EXPEND_BUDGET")
	public BigDecimal getExpendBudget() {
		return expendBudget;
	}

	public void setRealExpend(BigDecimal realExpend) {
		this.realExpend = realExpend;
	}

	@Column(name = "REAL_EXPEND")
	public BigDecimal getRealExpend() {
		return realExpend;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "STATUS", length = 16)
	public String getStatus() {
		return status;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	@Column(name = "PARENT_ID", length = 50)
	public String getParentId() {
		return parentId;
	}

	public void setAssociateId(String associateId) {
		this.associateId = associateId;
	}

	@Column(name = "ASSOCIATE_ID", length = 50)
	public String getAssociateId() {
		return associateId;
	}

	public String toString() {
		return "NkBudgetExpend [id=" + id + ",content=" + content
				+ ",revenueBudget=" + revenueBudget + ",realRevenue="
				+ realRevenue + ",expendBudget=" + expendBudget
				+ ",realExpend=" + realExpend + ",status=" + status
				+ ",parentId=" + parentId + ",associateId=" + associateId + "]";
	}

}
