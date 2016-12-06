package cn.com.oking.nk.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * NK_NOTES:票据管理
 */
@Entity
@Table(name = "NK_NOTES")
public class NkNotes implements Serializable {

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
	 * 票据名称:票据名称
	 */
	private String noteName;

	/**
	 * 业务类型:业务类型
	 */
	private String businessTypes;

	/**
	 * 发票代码:发票代码
	 */
	private String invoiceCode;

	/**
	 * 起讫编号:起讫编号
	 */
	private String allNumbers;

	/**
	 * 票据份数:票据份数
	 */
	private BigDecimal noteNum;

	/**
	 * 备注:备注
	 */
	private String remarks;

	/**
	 * 办理时间:办理时间
	 */
	private Date dealTime;

	/**
	 * 经办人:经办人
	 */
	private String dealPeople;

	public NkNotes() {
		super();
	}

	public NkNotes(String nkId, String nkNum, String noteName,
			String businessTypes, String invoiceCode, String allNumbers,
			BigDecimal noteNum, String remarks, Date dealTime, String dealPeople) {
		super();
		this.nkId = nkId;
		this.nkNum = nkNum;
		this.noteName = noteName;
		this.businessTypes = businessTypes;
		this.invoiceCode = invoiceCode;
		this.allNumbers = allNumbers;
		this.noteNum = noteNum;
		this.remarks = remarks;
		this.dealTime = dealTime;
		this.dealPeople = dealPeople;
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

	public void setNoteName(String noteName) {
		this.noteName = noteName;
	}

	@Column(name = "NOTE_NAME", length = 200)
	public String getNoteName() {
		return noteName;
	}

	public void setBusinessTypes(String businessTypes) {
		this.businessTypes = businessTypes;
	}

	@Column(name = "BUSINESS_TYPES", length = 20)
	public String getBusinessTypes() {
		return businessTypes;
	}

	public void setInvoiceCode(String invoiceCode) {
		this.invoiceCode = invoiceCode;
	}

	@Column(name = "INVOICE_CODE", length = 30)
	public String getInvoiceCode() {
		return invoiceCode;
	}

	public void setAllNumbers(String allNumbers) {
		this.allNumbers = allNumbers;
	}

	@Column(name = "ALL_NUMBERS", length = 50)
	public String getAllNumbers() {
		return allNumbers;
	}

	public void setNoteNum(BigDecimal noteNum) {
		this.noteNum = noteNum;
	}

	@Column(name = "NOTE_NUM")
	public BigDecimal getNoteNum() {
		return noteNum;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name = "REMARKS", length = 500)
	public String getRemarks() {
		return remarks;
	}

	public void setDealTime(Date dealTime) {
		this.dealTime = dealTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DEAL_TIME")
	public Date getDealTime() {
		return dealTime;
	}

	public void setDealPeople(String dealPeople) {
		this.dealPeople = dealPeople;
	}

	@Column(name = "DEAL_PEOPLE", length = 20)
	public String getDealPeople() {
		return dealPeople;
	}

	public String toString() {
		return "NkNotes [nkId=" + nkId + ",nkNum=" + nkNum + ",noteName="
				+ noteName + ",businessTypes=" + businessTypes
				+ ",invoiceCode=" + invoiceCode + ",allNumbers=" + allNumbers
				+ ",noteNum=" + noteNum + ",remarks=" + remarks + ",dealTime="
				+ dealTime + ",dealPeople=" + dealPeople + "]";
	}

}
