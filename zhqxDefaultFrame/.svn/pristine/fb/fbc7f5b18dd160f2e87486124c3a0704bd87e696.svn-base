package cn.com.oking.nk.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;

/**
 * NK_BALANCE_OF_PAYMENT:收支控制
 */
@Entity
@Table(name = "NK_BALANCE_OF_PAYMENT")
public class NkBalanceOfPayment implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id:id
	 */
	private String id;

	/**
	 * 文件编号:文件编号
	 */
	private String nkNum;

	/**
	 * 文档名称:文档名称
	 */
	private String nkName;

	/**
	 * 更新时间:更新时间
	 */
	private Date updateTime;

	/**
	 * 状态:状态
	 */
	private String nkType;

	/**
	 * 文件编号:文件编号
	 */
	private String fileid;

	public NkBalanceOfPayment() {
		super();
	}

	public NkBalanceOfPayment(String id, String nkNum, String nkName,
			Date updateTime, String nkType, String fileid) {
		super();
		this.id = id;
		this.nkNum = nkNum;
		this.nkName = nkName;
		this.updateTime = updateTime;
		this.nkType = nkType;
		this.fileid = fileid;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Id
	@Column(name = "ID", length = 50, nullable = false)
	public String getId() {
		return id;
	}

	public void setNkNum(String nkNum) {
		this.nkNum = nkNum;
	}

	@Column(name = "NK_NUM", length = 1000)
	public String getNkNum() {
		return nkNum;
	}

	public void setNkName(String nkName) {
		this.nkName = nkName;
	}

	@Column(name = "NK_NAME", length = 1000)
	public String getNkName() {
		return nkName;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATE_TIME")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setNkType(String nkType) {
		this.nkType = nkType;
	}

	@Column(name = "NK_TYPE", length = 10)
	public String getNkType() {
		return nkType;
	}

	public void setFileid(String fileid) {
		this.fileid = fileid;
	}

	@Column(name = "FILEID", length = 50)
	public String getFileid() {
		return fileid;
	}

	public String toString() {
		return "NkBalanceOfPayment [id=" + id + ",nkNum=" + nkNum + ",nkName="
				+ nkName + ",updateTime=" + updateTime + ",nkType=" + nkType
				+ ",fileid=" + fileid + "]";
	}

}
