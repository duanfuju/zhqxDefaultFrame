package cn.com.oking.nk.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * NK_BUDGET:内控管理
 */
@Entity
@Table(name = "NK_BUDGET")
public class NkBudget implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id:id
	 */
	private String nkId;

	/**
	 * 业务编号:业务编号
	 */
	private String nkNum;

	/**
	 * 内容:内容
	 */
	private String content;

	/**
	 * 收入预算:收入预算
	 */
	private BigDecimal revenueBudget;

	/**
	 * 支出预算:支出预算
	 */
	private BigDecimal expendBudget;

	/**
	 * 实际收入:实际收入
	 */
	private BigDecimal realRevenue;

	/**
	 * 实际支出:实际支出
	 */
	private BigDecimal realExpend;

	/**
	 * 状态:状态
	 */
	private String status;

	/**
	 * 更新时间:更新时间
	 */
	private Date updateTime;

	/**
	 * 更新人员:更新人员
	 */
	private String updatePeople;

	/**
	 * 文件关联编号:文件关联编号
	 */
	private String fieldNum;

	public NkBudget() {
		super();
	}

	public NkBudget(String nkId, String nkNum, String content,
			BigDecimal revenueBudget, BigDecimal expendBudget,
			BigDecimal realRevenue, BigDecimal realExpend, String status,
			Date updateTime, String updatePeople, String fieldNum) {
		super();
		this.nkId = nkId;
		this.nkNum = nkNum;
		this.content = content;
		this.revenueBudget = revenueBudget;
		this.expendBudget = expendBudget;
		this.realRevenue = realRevenue;
		this.realExpend = realExpend;
		this.status = status;
		this.updateTime = updateTime;
		this.updatePeople = updatePeople;
		this.fieldNum = fieldNum;
	}

	public void setNkId(String nkId) {
		this.nkId = nkId;
	}

	@Id
	@Column(name = "NK_ID", length = 50, nullable = false)
	public String getNkId() {
		return nkId;
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

	public void setExpendBudget(BigDecimal expendBudget) {
		this.expendBudget = expendBudget;
	}

	@Column(name = "EXPEND_BUDGET")
	public BigDecimal getExpendBudget() {
		return expendBudget;
	}

	public void setRealRevenue(BigDecimal realRevenue) {
		this.realRevenue = realRevenue;
	}

	@Column(name = "REAL_REVENUE")
	public BigDecimal getRealRevenue() {
		return realRevenue;
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

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATE_TIME")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdatePeople(String updatePeople) {
		this.updatePeople = updatePeople;
	}

	@Column(name = "UPDATE_PEOPLE", length = 50)
	public String getUpdatePeople() {
		return updatePeople;
	}

	public void setFieldNum(String fieldNum) {
		this.fieldNum = fieldNum;
	}

	@Column(name = "FIELD_NUM", length = 50)
	public String getFieldNum() {
		return fieldNum;
	}

	public String toString() {
		return "NkBudget [nkId=" + nkId + ",nkNum=" + nkNum + ",content="
				+ content + ",revenueBudget=" + revenueBudget
				+ ",expendBudget=" + expendBudget + ",realRevenue="
				+ realRevenue + ",realExpend=" + realExpend + ",status="
				+ status + ",updateTime=" + updateTime + ",updatePeople="
				+ updatePeople + ",fieldNum=" + fieldNum + "]";
	}

}
