package cn.com.oking.nk.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * NK_CGKZ_RECORD:采购控制之采购记录
 */
@Entity
@Table(name = "NK_CGKZ_RECORD")
public class NkCgkzRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id:id
	 */
	private String nkId;

	/**
	 * 编号:编号
	 */
	private String nkNum;

	/**
	 * 采购说明:采购说明
	 */
	private String cgExplain;

	/**
	 * 类型:类型
	 */
	private String cgType;

	/**
	 * 采购金额:采购金额
	 */
	private BigDecimal cgMoney;

	/**
	 * 采购时间:采购时间
	 */
	private Date cgDate;

	/**
	 * 经办人:经办人
	 */
	private String agent;

	public NkCgkzRecord() {
		super();
	}

	public NkCgkzRecord(String nkId, String nkNum, String cgExplain,
			String cgType, BigDecimal cgMoney, Date cgDate, String agent) {
		super();
		this.nkId = nkId;
		this.nkNum = nkNum;
		this.cgExplain = cgExplain;
		this.cgType = cgType;
		this.cgMoney = cgMoney;
		this.cgDate = cgDate;
		this.agent = agent;
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

	public void setCgExplain(String cgExplain) {
		this.cgExplain = cgExplain;
	}

	@Column(name = "CG_EXPLAIN", length = 100)
	public String getCgExplain() {
		return cgExplain;
	}

	public void setCgType(String cgType) {
		this.cgType = cgType;
	}

	@Column(name = "CG_TYPE", length = 50)
	public String getCgType() {
		return cgType;
	}

	public void setCgMoney(BigDecimal cgMoney) {
		this.cgMoney = cgMoney;
	}

	@Column(name = "CG_MONEY")
	public BigDecimal getCgMoney() {
		return cgMoney;
	}

	public void setCgDate(Date cgDate) {
		this.cgDate = cgDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CG_DATE")
	public Date getCgDate() {
		return cgDate;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	@Column(name = "AGENT", length = 50)
	public String getAgent() {
		return agent;
	}

	public String toString() {
		return "NkCgkzRecord [nkId=" + nkId + ",nkNum=" + nkNum + ",cgExplain="
				+ cgExplain + ",cgType=" + cgType + ",cgMoney=" + cgMoney
				+ ",cgDate=" + cgDate + ",agent=" + agent + "]";
	}

}
