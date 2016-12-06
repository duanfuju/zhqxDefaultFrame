package cn.com.oking.em.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * EM_JJTZ_FBFW:����֪ͨ������Χ
 */
@Entity
@Table(name = "EM_JJTZ_FBFW")
public class EmJjtzFbfw implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID:ID
	 */
	private String id;

	/**
	 * ����֪ͨID:����֪ͨID
	 */
	private String jjtzId;

	/**
	 * ֪ͨ����:֪ͨ����
	 */
	private String content;

	/**
	 * ����:����
	 */
	private String dept;

	/**
	 * ��ϵ��:��ϵ��
	 */
	private String contact;

	/**
	 * ��ϵ�绰:��ϵ�绰
	 */
	private String telnum;

	/**
	 * �̶��绰:�̶��绰
	 */
	private String phone;

	/**
	 * �����ʼ���ַ:�����ʼ���ַ
	 */
	private String email;

	/**
	 * ����֪ͨ:����֪ͨ
	 */
	private String isphone;

	/**
	 * �ʼ�֪ͨ:�ʼ�֪ͨ
	 */
	private String isemail;

	public EmJjtzFbfw() {
		super();
	}

	public EmJjtzFbfw(String id, String jjtzId, String content, String dept,
			String contact, String telnum, String phone, String email,
			String isphone, String isemail) {
		super();
		this.id = id;
		this.jjtzId = jjtzId;
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

	public void setJjtzId(String jjtzId) {
		this.jjtzId = jjtzId;
	}

	@Column(name = "JJTZ_ID", length = 20)
	public String getJjtzId() {
		return jjtzId;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "CONTENT", length = 2000)
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
		return "EmJjtzFbfw [id=" + id + ",jjtzId=" + jjtzId + ",content="
				+ content + ",dept=" + dept + ",contact=" + contact
				+ ",telnum=" + telnum + ",phone=" + phone + ",email=" + email
				+ ",isphone=" + isphone + ",isemail=" + isemail + "]";
	}

}