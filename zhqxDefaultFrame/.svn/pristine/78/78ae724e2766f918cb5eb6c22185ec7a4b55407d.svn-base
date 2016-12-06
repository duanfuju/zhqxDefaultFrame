package cn.com.oking.em.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * EM_DOCDEMO:文档模板
 */
@Entity
@Table(name = "EM_DOCDEMO")
public class EmDocdemo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id:id
	 */
	private String id;

	/**
	 * 文件编号:文件编号
	 */
	private String docnum;

	/**
	 * 文档名称:文档名称
	 */
	private String docname;

	/**
	 * 状态:状态
	 */
	private String status;

	/**
	 * 文件编号:文件编号
	 */
	private String fileid;

	/**
	 * 文件名称:文件名称
	 */
	private String filename;

	public EmDocdemo() {
		super();
	}

	public EmDocdemo(String id, String docnum, String docname, String status,
			String fileid, String filename) {
		super();
		this.id = id;
		this.docnum = docnum;
		this.docname = docname;
		this.status = status;
		this.fileid = fileid;
		this.filename = filename;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Id
	@Column(name = "ID", length = 50, nullable = false)
	public String getId() {
		return id;
	}

	public void setDocnum(String docnum) {
		this.docnum = docnum;
	}

	@Column(name = "DOCNUM", length = 1000)
	public String getDocnum() {
		return docnum;
	}

	public void setDocname(String docname) {
		this.docname = docname;
	}

	@Column(name = "DOCNAME", length = 1000)
	public String getDocname() {
		return docname;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "STATUS", length = 10)
	public String getStatus() {
		return status;
	}

	public void setFileid(String fileid) {
		this.fileid = fileid;
	}

	@Column(name = "FILEID", length = 50)
	public String getFileid() {
		return fileid;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Column(name = "FILENAME", length = 1000)
	public String getFilename() {
		return filename;
	}

	public String toString() {
		return "EmDocdemo [id=" + id + ",docnum=" + docnum + ",docname="
				+ docname + ",status=" + status + ",fileid=" + fileid
				+ ",filename=" + filename + "]";
	}

}
