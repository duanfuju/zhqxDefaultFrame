package cn.com.oking.fzjz.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * MNYL_RESULTRECORD:模拟演练_演练结果记录
 */
@Entity
@Table(name = "MNYL_RESULTRECORD")
public class MnylResultrecord implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id:id
	 */
	private String id;

	/**
	 * 基础信息编号:基础信息编号
	 */
	private String ylId;

	/**
	 * 题目类型:题目类型
	 */
	private String ptype;

	/**
	 * 选项所属问题（脚本主表）:选项所属问题（脚本主表）
	 */
	private String answerId;

	/**
	 * 题目简介:题目简介
	 */
	private String title;

	/**
	 * 题目的详细介绍:题目的详细介绍
	 */
	private String problem;

	/**
	 * 选项文本:选项文本
	 */
	private String optionText;

	/**
	 * 选项选择记录:选项选择记录
	 */
	private String optionChoose;

	/**
	 * 选项答案:选项答案
	 */
	private String optionIstrue;

	/**
	 * 选项类型:选项类型
	 */
	private String optionType;

	public MnylResultrecord() {
		super();
	}

	public MnylResultrecord(String id, String ylId, String ptype,
			String answerId, String title, String problem, String optionText,
			String optionChoose, String optionIstrue, String optionType) {
		super();
		this.id = id;
		this.ylId = ylId;
		this.ptype = ptype;
		this.answerId = answerId;
		this.title = title;
		this.problem = problem;
		this.optionText = optionText;
		this.optionChoose = optionChoose;
		this.optionIstrue = optionIstrue;
		this.optionType = optionType;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Id
	@Column(name = "ID", length = 50, nullable = false)
	public String getId() {
		return id;
	}

	public void setYlId(String ylId) {
		this.ylId = ylId;
	}

	@Column(name = "YL_ID", length = 50)
	public String getYlId() {
		return ylId;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	@Column(name = "PTYPE", length = 50)
	public String getPtype() {
		return ptype;
	}

	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}

	@Column(name = "ANSWER_ID", length = 50)
	public String getAnswerId() {
		return answerId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "TITLE", length = 50)
	public String getTitle() {
		return title;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	@Column(name = "PROBLEM", length = 500)
	public String getProblem() {
		return problem;
	}

	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}

	@Column(name = "OPTION_TEXT", length = 500)
	public String getOptionText() {
		return optionText;
	}

	public void setOptionChoose(String optionChoose) {
		this.optionChoose = optionChoose;
	}

	@Column(name = "OPTION_CHOOSE", length = 50)
	public String getOptionChoose() {
		return optionChoose;
	}

	public void setOptionIstrue(String optionIstrue) {
		this.optionIstrue = optionIstrue;
	}

	@Column(name = "OPTION_ISTRUE", length = 50)
	public String getOptionIstrue() {
		return optionIstrue;
	}

	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}

	@Column(name = "OPTION_TYPE", length = 50)
	public String getOptionType() {
		return optionType;
	}

	public String toString() {
		return "MnylResultrecord [id=" + id + ",ylId=" + ylId + ",ptype="
				+ ptype + ",answerId=" + answerId + ",title=" + title
				+ ",problem=" + problem + ",optionText=" + optionText
				+ ",optionChoose=" + optionChoose + ",optionIstrue="
				+ optionIstrue + ",optionType=" + optionType + "]";
	}

}
