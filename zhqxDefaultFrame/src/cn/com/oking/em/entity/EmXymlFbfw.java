package cn.com.oking.em.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * EM_XYML_FBFW:指令发布范围
 */
@Entity
@Table(name = "EM_XYML_FBFW")
public class EmXymlFbfw implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID:
	 */
	private String id;

	/**
	 * 指令编号:指令编号
	 */
	private String zlbhId;

	/**
	 * 通知内容:通知内容
	 */
	private String content;

	/**
	 * 部门:部门
	 */
	private String dept;

	/**
	 * 联系人:联系人
	 */
	private String contact;

	/**
	 * 联系电话:联系电话
	 */
	private String telnum;

	/**
	 * 固定电话:固定电话
	 */
	private String phone;

	/**
	 * 电子邮件地址:电子邮件地址
	 */
	private String email;

	/**
	 * 短信通知:短信通知
	 */
	private String isphone;

	/**
	 * 邮件通知:邮件通知
	 */
	private String isemail;

	public EmXymlFbfw() {
		super();
	}

	public EmXymlFbfw(String id, String zlbhId, String content, String dept,
			String contact, String telnum, String phone, String email,
			String isphone, String isemail) {
		super();
		this.id = id;
		this.zlbhId = zlbhId;
		this.content = content;
		this.dept = dept;
		this.contact = contact;
		this.telnum = telnum;
		this.phone = phone;
		this.email = email;
		this.isphone = isphone;
		this.isemail = isemail;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Id
	@Column(name = "ID", length = 50, nullable = false)
	public String getId() {
		return id;
	}

	public void setZlbhId(String zlbhId) {
		this.zlbhId = zlbhId;
	}

	@Column(name = "ZLBH_ID", length = 20)
	public String getZlbhId() {
		return zlbhId;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "CONTENT", length = 200)
	public String getContent() {
		return content;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Column(name = "DEPT", length = 20)
	public String getDept() {
		return dept;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Column(name = "CONTACT", length = 20)
	public String getContact() {
		return contact;
	}

	public void setTelnum(String telnum) {
		this.telnum = telnum;
	}

	@Column(name = "TELNUM", length = 20)
	public String getTelnum() {
		return telnum;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "PHONE", length = 20)
	public String getPhone() {
		return phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "EMAIL", length = 60)
	public String getEmail() {
		return email;
	}

	public void setIsphone(String isphone) {
		this.isphone = isphone;
	}

	@Column(name = "ISPHONE", length = 2)
	public String getIsphone() {
		return isphone;
	}

	public void setIsemail(String isemail) {
		this.isemail = isemail;
	}

	@Column(name = "ISEMAIL", length = 2)
	public String getIsemail() {
		return isemail;
	}

	public String toString() {
		return "EmXymlFbfw [id=" + id + ",zlbhId=" + zlbhId + ",content="
				+ content + ",dept=" + dept + ",contact=" + contact
				+ ",telnum=" + telnum + ",phone=" + phone + ",email=" + email
				+ ",isphone=" + isphone + ",isemail=" + isemail + "]";
	}

}
