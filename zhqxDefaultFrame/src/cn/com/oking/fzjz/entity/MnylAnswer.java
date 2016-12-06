package cn.com.oking.fzjz.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * MNYL_ANSWER:ģ������_�ű��ӱ�(��)
 */
@Entity
@Table(name = "MNYL_ANSWER")
public class MnylAnswer implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID:ID
	 */
	private String id;

	/**
	 * ѡ���ı�:ѡ���ı�
	 */
	private String optionText;

	/**
	 * ѡ���:ѡ���
	 */
	private String optionIstrue;

	/**
	 * ѡ����������(�ű�����):ѡ����������(�ű�����)
	 */
	private String answerId;

	/**
	 * ѡ������:ѡ������
	 */
	private String optionType;

	public MnylAnswer() {
		super();
	}

	public MnylAnswer(String id, String optionText, String optionIstrue,
			String answerId, String optionType) {
		super();
		this.id = id;
		this.optionText = optionText;
		this.optionIstrue = optionIstrue;
		this.answerId = answerId;
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

	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}

	@Column(name = "OPTION_TEXT", length = 500)
	public String getOptionText() {
		return optionText;
	}

	public void setOptionIstrue(String optionIstrue) {
		this.optionIstrue = optionIstrue;
	}

	@Column(name = "OPTION_ISTRUE", length = 50)
	public String getOptionIstrue() {
		return optionIstrue;
	}

	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}

	@Column(name = "ANSWER_ID", length = 50)
	public String getAnswerId() {
		return answerId;
	}

	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}

	@Column(name = "OPTION_TYPE", length = 50)
	public String getOptionType() {
		return optionType;
	}

	public String toString() {
		return "MnylAnswer [id=" + id + ",optionText=" + optionText
				+ ",optionIstrue=" + optionIstrue + ",answerId=" + answerId
				+ ",optionType=" + optionType + "]";
	}

}
