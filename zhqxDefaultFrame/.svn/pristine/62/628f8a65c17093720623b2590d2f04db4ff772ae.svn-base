package cn.com.oking.em.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * EM_TEAM:应急队伍管理
 */
@Entity
@Table(name = "EM_TEAM")
public class EmTeam implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 项目:项目
	 */
	private String duties;

	/**
	 * 姓名:姓名
	 */
	private String name;

	/**
	 * 单位或镇街场:单位或镇街场
	 */
	private String institutions;

	/**
	 * 部门:部门
	 */
	private String dept;

	/**
	 * 职务:职务
	 */
	private String position;

	/**
	 * 手机号码:手机号码
	 */
	private String phone;

	/**
	 * 办公电话:办公电话
	 */
	private String tel;

	/**
	 * 备注:备注
	 */
	private String remark;

	/**
	 * 应急领导小组、镇街场分管领导、部门联络员:应急领导小组、镇街场分管领导、部门联络员
	 */
	private String teamtype;

	/**
	 * 有效、无效:有效、无效
	 */
	private String status;

	/**
	 * YORN,默认为N:YORN,默认为N
	 */
	private String isdefault;

	/**
	 * 名单显示顺序:名单显示顺序
	 */
	private BigDecimal ordernum;

	/**
	 * EM_ID:
	 */
	private String emId;

	/**
	 * 性别:性别
	 */
	private String gender;

	/**
	 * 年龄:年龄
	 */
	private BigDecimal age;

	/**
	 * 学历:学历
	 */
	private String educations;

	/**
	 * 行业类别:行业类别
	 */
	private String icategory;

	public EmTeam() {
		super();
	}

	public EmTeam(String duties, String name, String institutions, String dept,
			String position, String phone, String tel, String remark,
			String teamtype, String status, String isdefault,
			BigDecimal ordernum, String emId, String gender, BigDecimal age,
			String educations, String icategory) {
		super();
		this.duties = duties;
		this.name = name;
		this.institutions = institutions;
		this.dept = dept;
		this.position = position;
		this.phone = phone;
		this.tel = tel;
		this.remark = remark;
		this.teamtype = teamtype;
		this.status = status;
		this.isdefault = isdefault;
		this.ordernum = ordernum;
		this.emId = emId;
		this.gender = gender;
		this.age = age;
		this.educations = educations;
		this.icategory = icategory;
	}

	public void setDuties(String duties) {
		this.duties = duties;
	}

	@Column(name = "DUTIES", length = 20)
	public String getDuties() {
		return duties;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "NAME", length = 20)
	public String getName() {
		return name;
	}

	public void setInstitutions(String institutions) {
		this.institutions = institutions;
	}

	@Column(name = "INSTITUTIONS", length = 100)
	public String getInstitutions() {
		return institutions;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Column(name = "DEPT", length = 30)
	public String getDept() {
		return dept;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Column(name = "POSITION", length = 30)
	public String getPosition() {
		return position;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "PHONE", length = 100)
	public String getPhone() {
		return phone;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "TEL", length = 20)
	public String getTel() {
		return tel;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "REMARK", length = 500)
	public String getRemark() {
		return remark;
	}

	public void setTeamtype(String teamtype) {
		this.teamtype = teamtype;
	}

	@Column(name = "TEAMTYPE", length = 20)
	public String getTeamtype() {
		return teamtype;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "STATUS", length = 20)
	public String getStatus() {
		return status;
	}

	public void setIsdefault(String isdefault) {
		this.isdefault = isdefault;
	}

	@Column(name = "ISDEFAULT", length = 10)
	public String getIsdefault() {
		return isdefault;
	}

	public void setOrdernum(BigDecimal ordernum) {
		this.ordernum = ordernum;
	}

	@Column(name = "ORDERNUM")
	public BigDecimal getOrdernum() {
		return ordernum;
	}

	public void setEmId(String emId) {
		this.emId = emId;
	}

	@Id
	@Column(name = "EM_ID", length = 50, nullable = false)
	public String getEmId() {
		return emId;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "GENDER", length = 10)
	public String getGender() {
		return gender;
	}

	public void setAge(BigDecimal age) {
		this.age = age;
	}

	@Column(name = "AGE")
	public BigDecimal getAge() {
		return age;
	}

	public void setEducations(String educations) {
		this.educations = educations;
	}

	@Column(name = "EDUCATIONS", length = 50)
	public String getEducations() {
		return educations;
	}

	public void setIcategory(String icategory) {
		this.icategory = icategory;
	}

	@Column(name = "ICATEGORY", length = 50)
	public String getIcategory() {
		return icategory;
	}

	public String toString() {
		return "EmTeam [duties=" + duties + ",name=" + name + ",institutions="
				+ institutions + ",dept=" + dept + ",position=" + position
				+ ",phone=" + phone + ",tel=" + tel + ",remark=" + remark
				+ ",teamtype=" + teamtype + ",status=" + status + ",isdefault="
				+ isdefault + ",ordernum=" + ordernum + ",emId=" + emId
				+ ",gender=" + gender + ",age=" + age + ",educations="
				+ educations + ",icategory=" + icategory + "]";
	}

}
