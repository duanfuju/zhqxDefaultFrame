package cn.com.oking.nk.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;

/**
 * NK_XMKZ_RECORD:��Ŀ����֮��Ŀ��¼
 */
@Entity
@Table(name = "NK_XMKZ_RECORD")
public class NkXmkzRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id:id
	 */
	private String nkId;

	/**
	 * ��Ŀ����:��Ŀ����
	 */
	private String xmCode;

	/**
	 * ��Ŀ����:��Ŀ����
	 */
	private String xmName;

	/**
	 * ��ʼ����:��ʼ����
	 */
	private Date startDate;

	/**
	 * ��������:��������
	 */
	private Date endDate;

	/**
	 * ��Ŀ״̬:��Ŀ״̬
	 */
	private String xmState;

	/**
	 * ��Ŀ������:��Ŀ������
	 */
	private String xmPeople;

	public NkXmkzRecord() {
		super();
	}

	public NkXmkzRecord(String nkId, String xmCode, String xmName,
			Date startDate, Date endDate, String xmState, String xmPeople) {
		super();
		this.nkId = nkId;
		this.xmCode = xmCode;
		this.xmName = xmName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.xmState = xmState;
		this.xmPeople = xmPeople;
	}

	public void setNkId(String nkId) {
		this.nkId = nkId;
	}

	@Id
	@Column(name = "NK_ID", length = 50, nullable = false)
	public String getNkId() {
		return nkId;
	}

	public void setXmCode(String xmCode) {
		this.xmCode = xmCode;
	}

	@Column(name = "XM_CODE", length = 50)
	public String getXmCode() {
		return xmCode;
	}

	public void setXmName(String xmName) {
		this.xmName = xmName;
	}

	@Column(name = "XM_NAME", length = 50)
	public String getXmName() {
		return xmName;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "START_DATE")
	public Date getStartDate() {
		return startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "END_DATE")
	public Date getEndDate() {
		return endDate;
	}

	public void setXmState(String xmState) {
		this.xmState = xmState;
	}

	@Column(name = "XM_STATE", length = 16)
	public String getXmState() {
		return xmState;
	}

	public void setXmPeople(String xmPeople) {
		this.xmPeople = xmPeople;
	}

	@Column(name = "XM_PEOPLE", length = 50)
	public String getXmPeople() {
		return xmPeople;
	}

	public String toString() {
		return "NkXmkzRecord [nkId=" + nkId + ",xmCode=" + xmCode + ",xmName="
				+ xmName + ",startDate=" + startDate + ",endDate=" + endDate
				+ ",xmState=" + xmState + ",xmPeople=" + xmPeople + "]";
	}

}
