package cn.com.oking.em.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * EM_CZFA_JY_ADVICE:处置方案建议引用建议
 */
@Entity
@Table(name = "EM_CZFA_JY_ADVICE")
public class EmCzfaJyAdvice implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id:id
	 */
	private String id;

	/**
	 * 部门:部门
	 */
	private String dept;

	/**
	 * 防范应对:防范应对
	 */
	private String responses;

	/**
	 * 建议类型:建议类型
	 */
	private String type;

	/**
	 * 处置方案建议关联id:处置方案建议关联id
	 */
	private String czfaJyId;

	public EmCzfaJyAdvice() {
		super();
	}

	public EmCzfaJyAdvice(String id, String dept, String responses,
			String type, String czfaJyId) {
		super();
		this.id = id;
		this.dept = dept;
		this.responses = responses;
		this.type = type;
		this.czfaJyId = czfaJyId;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Id
	@Column(name = "ID", length = 50, nullable = false)
	public String getId() {
		return id;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Column(name = "DEPT", length = 100)
	public String getDept() {
		return dept;
	}

	public void setResponses(String responses) {
		this.responses = responses;
	}

	@Column(name = "RESPONSES", length = 2000)
	public String getResponses() {
		return responses;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "TYPE", length = 2)
	public String getType() {
		return type;
	}

	public void setCzfaJyId(String czfaJyId) {
		this.czfaJyId = czfaJyId;
	}

	@Column(name = "CZFA_JY_ID", length = 50)
	public String getCzfaJyId() {
		return czfaJyId;
	}

	public String toString() {
		return "EmCzfaJyAdvice [id=" + id + ",dept=" + dept + ",responses="
				+ responses + ",type=" + type + ",czfaJyId=" + czfaJyId + "]";
	}

}
