package z_tknight.oa.model.entity;

import java.sql.Timestamp;

public class OperationLog {

	/**
	 * 操作日志编号
	 */
	private Integer logNo = null;

	/**
	 * 操作用户编号
	 */
	private Integer userNo = null;

	/**
	 * 操作描述
	 */
	private String operation = null;

	/**
	 * 操作异常信息
	 */
	private String exception = null;

	/**
	 * 接口调用方法名
	 */
	private String methodName = null;

	/**
	 * 传入参数
	 */
	private String params = null;

	/**
	 * 客户端ip
	 */
	private String ip = null;

	/**
	 * 操作起始时间
	 */
	private Timestamp beginTime = null;

	/**
	 * 操作时间
	 */
	private Long operationTime = null;

	/**
	 * 请求url
	 */
	private String url = null;

	/**
	 * 操作成功与否
	 */
	private Boolean state = null;

	public void setLogNo(Integer logNo) {
		this.logNo = logNo;
	}

	public Integer getLogNo() {
		return this.logNo;
	}

	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}

	public Integer getUserNo() {
		return this.userNo;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getOperation() {
		return this.operation;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getException() {
		return this.exception;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getMethodName() {
		return this.methodName;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getParams() {
		return this.params;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getIp() {
		return this.ip;
	}

	public void setBeginTime(Timestamp beginTime) {
		this.beginTime = beginTime;
	}

	public Timestamp getBeginTime() {
		return this.beginTime;
	}

	public void setOperationTime(Long operationTime) {
		this.operationTime = operationTime;
	}

	public Long getOperationTime() {
		return this.operationTime;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return this.url;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public Boolean isState() {
		return this.state;
	}

}