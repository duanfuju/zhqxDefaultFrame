package cn.com.oking.em.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * EM_CONTENT_LIST:内容列表
 */
@Entity
@Table(name = "EM_CONTENT_LIST")
public class EmContentList implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键:主键
	 */
	private String clId;

	/**
	 * 内容编号:内容编号
	 */
	private String clNum;

	/**
	 * 描述:描述
	 */
	private String description;

	/**
	 * 内容URL:内容URL
	 */
	private String url;

	/**
	 * 显示大小:显示大小
	 */
	private String displaySize;

	/**
	 * 图片路径:图片路径
	 */
	private String imgSrc;

	public EmContentList() {
		super();
	}

	public EmContentList(String clId, String clNum, String description,
			String url, String displaySize, String imgSrc) {
		super();
		this.clId = clId;
		this.clNum = clNum;
		this.description = description;
		this.url = url;
		this.displaySize = displaySize;
		this.imgSrc = imgSrc;
	}

	public void setClId(String clId) {
		this.clId = clId;
	}

	@Id
	@Column(name = "CL_ID", length = 50, nullable = false)
	public String getClId() {
		return clId;
	}

	public void setClNum(String clNum) {
		this.clNum = clNum;
	}

	@Column(name = "CL_NUM", length = 50)
	public String getClNum() {
		return clNum;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "DESCRIPTION", length = 200)
	public String getDescription() {
		return description;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "URL", length = 500)
	public String getUrl() {
		return url;
	}

	public void setDisplaySize(String displaySize) {
		this.displaySize = displaySize;
	}

	@Column(name = "DISPLAY_SIZE", length = 50)
	public String getDisplaySize() {
		return displaySize;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	@Column(name = "IMG_SRC", length = 200)
	public String getImgSrc() {
		return imgSrc;
	}

	public String toString() {
		return "EmContentList [clId=" + clId + ",clNum=" + clNum
				+ ",description=" + description + ",url=" + url
				+ ",displaySize=" + displaySize + ",imgSrc=" + imgSrc + "]";
	}

}
