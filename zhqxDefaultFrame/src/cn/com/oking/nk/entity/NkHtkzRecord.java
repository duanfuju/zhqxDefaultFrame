package cn.com.oking.nk.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * NK_HTKZ_RECORD:��ͬ����֮��ͬ��¼
 */
@Entity
@Table(name = "NK_HTKZ_RECORD")
public class NkHtkzRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id:id
	 */
	private String nkId;

	/**
	 * ���:���
	 */
	private String nkNum;

	/**
	 * ��ͬ˵��:��ͬ˵��
	 */
	private String htExplain;

	/**
	 * ����:����
	 */
	private String htType;

	/**
	 * ��ͬ���:��ͬ���
	 */
	private BigDecimal htMoney;

	/**
	 * ��ͬʱ��:��ͬʱ��
	 */
	private Date htDate;

	/**
	 * ������:������
	 */
	private String agent;

	public NkHtkzRecord() {
		super();
	}

	public NkHtkzRecord(String nkId, String nkNum, String htExplain,
			String htType, BigDecimal htMoney, Date htDate, String agent) {
		super();
		this.nkId = nkId;
		this.nkNum = nkNum;
		this.htExplain = htExplain;
		this.htType = htType;
		this.htMoney = htMoney;
		this.htDate = htDate;
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

	public void setHtExplain(String htExplain) {
		this.htExplain = htExplain;
	}

	@Column(name = "HT_EXPLAIN", length = 100)
	public String getHtExplain() {
		return htExplain;
	}

	public void setHtType(String htType) {
		this.htType = htType;
	}

	@Column(name = "HT_TYPE", length = 50)
	public String getHtType() {
		return htType;
	}

	public void setHtMoney(BigDecimal htMoney) {
		this.htMoney = htMoney;
	}

	@Column(name = "HT_MONEY")
	public BigDecimal getHtMoney() {
		return htMoney;
	}

	public void setHtDate(Date htDate) {
		this.htDate = htDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "HT_DATE")
	public Date getHtDate() {
		return htDate;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	@Column(name = "AGENT", length = 50)
	public String getAgent() {
		return agent;
	}

	public String toString() {
		return "NkHtkzRecord [nkId=" + nkId + ",nkNum=" + nkNum + ",htExplain="
				+ htExplain + ",htType=" + htType + ",htMoney=" + htMoney
				+ ",htDate=" + htDate + ",agent=" + agent + "]";
	}

}
