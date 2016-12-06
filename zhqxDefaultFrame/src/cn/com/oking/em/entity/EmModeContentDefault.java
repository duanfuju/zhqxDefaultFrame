package cn.com.oking.em.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * EM_MODE_CONTENT_DEFAULT:模式内容
 */
@Entity
@Table(name = "EM_MODE_CONTENT_DEFAULT")
public class EmModeContentDefault implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键:主键
	 */
	private String mcId;

	/**
	 * 内容ID:内容ID
	 */
	private String clNum;

	/**
	 * 内容描述:内容描述
	 */
	private String description;

	/**
	 * 内容URL:内容URL
	 */
	private String url;

	/**
	 * 行:行
	 */
	private BigDecimal line;

	/**
	 * 列:列
	 */
	private BigDecimal col;

	/**
	 * 序号:序号
	 */
	private BigDecimal orderid;

	/**
	 * 模式编号:模式编号
	 */
	private String mcNum;

	/**
	 * 图片路径:图片路径
	 */
	private String imgSrc;

	/**
	 * 显示大小:显示大小
	 */
	private String displaysize;

	/**
	 * 显示模式ID:显示模式ID
	 */
	private String dmId;

	public EmModeContentDefault() {
		super();
	}

	public EmModeContentDefault(String mcId, String clNum, String description,
			String url, BigDecimal line, BigDecimal col, BigDecimal orderid,
			String mcNum, String imgSrc, String displaysize, String dmId) {
		super();
		this.mcId = mcId;
		this.clNum = clNum;
		this.description = description;
		this.url = url;
		this.line = line;
		this.col = col;
		this.orderid = orderid;
		this.mcNum = mcNum;
		this.imgSrc = imgSrc;
		this.displaysize = displaysize;
		this.dmId = dmId;
	}

	public void setMcId(String mcId) {
		this.mcId = mcId;
	}

	@Id
	@Column(name = "MC_ID", length = 50, nullable = false)
	public String getMcId() {
		return mcId;
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

	public void setLine(BigDecimal line) {
		this.line = line;
	}

	@Column(name = "LINE")
	public BigDecimal getLine() {
		return line;
	}

	public void setCol(BigDecimal col) {
		this.col = col;
	}

	@Column(name = "COL")
	public BigDecimal getCol() {
		return col;
	}

	public void setOrderid(BigDecimal orderid) {
		this.orderid = orderid;
	}

	@Column(name = "ORDERID")
	public BigDecimal getOrderid() {
		return orderid;
	}

	public void setMcNum(String mcNum) {
		this.mcNum = mcNum;
	}

	@Column(name = "MC_NUM", length = 50)
	public String getMcNum() {
		return mcNum;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	@Column(name = "IMG_SRC", length = 200)
	public String getImgSrc() {
		return imgSrc;
	}

	public void setDisplaysize(String displaysize) {
		this.displaysize = displaysize;
	}

	@Column(name = "DISPLAYSIZE", length = 50)
	public String getDisplaysize() {
		return displaysize;
	}

	public void setDmId(String dmId) {
		this.dmId = dmId;
	}

	@Column(name = "DM_ID", length = 50)
	public String getDmId() {
		return dmId;
	}

	public String toString() {
		return "EmModeContentDefault [mcId=" + mcId + ",clNum=" + clNum
				+ ",description=" + description + ",url=" + url + ",line="
				+ line + ",col=" + col + ",orderid=" + orderid + ",mcNum="
				+ mcNum + ",imgSrc=" + imgSrc + ",displaysize=" + displaysize
				+ ",dmId=" + dmId + "]";
	}

}
