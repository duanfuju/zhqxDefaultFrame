package cn.com.oking.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * ELEMENTS:
 */
@Entity
@Table(name = "ELEMENTS")
public class Elements implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键:主键
	 */
	private String elementsId;

	/**
	 * 要素类型:要素类型
	 */
	private String elementsType;

	/**
	 * 要素名称:要素名称
	 */
	private String elementsName;

	/**
	 * 制图周期:制图周期
	 */
	private BigDecimal mappingCycle;

	/**
	 * 周期单位:周期单位
	 */
	private String cycleUnit;

	/**
	 * 下次制图时间:下次制图时间
	 */
	private Date nextTimeDrawing;

	/**
	 * 数据源:数据源
	 */
	private String dataSource;

	/**
	 * 条件参数:条件参数
	 */
	private String conditionParameters;

	/**
	 * 命名规则:命名规则
	 */
	private String namingRules;

	/**
	 * 文件路径:文件路径
	 */
	private String filePath;

	/**
	 * 状态:状态
	 */
	private String status;

	public Elements() {
		super();
	}

	public Elements(String elementsId, String elementsType,
			String elementsName, BigDecimal mappingCycle, String cycleUnit,
			Date nextTimeDrawing, String dataSource,
			String conditionParameters, String namingRules, String filePath,
			String status) {
		super();
		this.elementsId = elementsId;
		this.elementsType = elementsType;
		this.elementsName = elementsName;
		this.mappingCycle = mappingCycle;
		this.cycleUnit = cycleUnit;
		this.nextTimeDrawing = nextTimeDrawing;
		this.dataSource = dataSource;
		this.conditionParameters = conditionParameters;
		this.namingRules = namingRules;
		this.filePath = filePath;
		this.status = status;
	}

	public void setElementsId(String elementsId) {
		this.elementsId = elementsId;
	}

	@Id
	@Column(name = "ELEMENTS_ID", length = 50, nullable = false)
	public String getElementsId() {
		return elementsId;
	}

	public void setElementsType(String elementsType) {
		this.elementsType = elementsType;
	}

	@Column(name = "ELEMENTS_TYPE", length = 50)
	public String getElementsType() {
		return elementsType;
	}

	public void setElementsName(String elementsName) {
		this.elementsName = elementsName;
	}

	@Column(name = "ELEMENTS_NAME", length = 50)
	public String getElementsName() {
		return elementsName;
	}

	public void setMappingCycle(BigDecimal mappingCycle) {
		this.mappingCycle = mappingCycle;
	}

	@Column(name = "MAPPING_CYCLE")
	public BigDecimal getMappingCycle() {
		return mappingCycle;
	}

	public void setCycleUnit(String cycleUnit) {
		this.cycleUnit = cycleUnit;
	}

	@Column(name = "CYCLE_UNIT", length = 50)
	public String getCycleUnit() {
		return cycleUnit;
	}

	public void setNextTimeDrawing(Date nextTimeDrawing) {
		this.nextTimeDrawing = nextTimeDrawing;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "NEXT_TIME_DRAWING")
	public Date getNextTimeDrawing() {
		return nextTimeDrawing;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	@Column(name = "DATA_SOURCE", length = 50)
	public String getDataSource() {
		return dataSource;
	}

	public void setConditionParameters(String conditionParameters) {
		this.conditionParameters = conditionParameters;
	}

	@Column(name = "CONDITION_PARAMETERS", length = 50)
	public String getConditionParameters() {
		return conditionParameters;
	}

	public void setNamingRules(String namingRules) {
		this.namingRules = namingRules;
	}

	@Column(name = "NAMING_RULES", length = 50)
	public String getNamingRules() {
		return namingRules;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Column(name = "FILE_PATH", length = 50)
	public String getFilePath() {
		return filePath;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "STATUS", length = 50)
	public String getStatus() {
		return status;
	}

	public String toString() {
		return "Elements [elementsId=" + elementsId + ",elementsType="
				+ elementsType + ",elementsName=" + elementsName
				+ ",mappingCycle=" + mappingCycle + ",cycleUnit=" + cycleUnit
				+ ",nextTimeDrawing=" + nextTimeDrawing + ",dataSource="
				+ dataSource + ",conditionParameters=" + conditionParameters
				+ ",namingRules=" + namingRules + ",filePath=" + filePath
				+ ",status=" + status + "]";
	}

}
