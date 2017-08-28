package z_tknight.oa.model.entity;


public class Department {

	/**
	 * 部门编号
	 */
	private Integer deptNo = null;

	/**
	 * 部门名称
	 */
	private String deptName = null;

	/**
	 * 部门所有者编号
	 */
	private Integer userNo = null;

	/**
	 * 部门所属公司编号
	 */
	private Integer companyNo = null;

	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}

	public Integer getDeptNo() {
		return this.deptNo;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptName() {
		return this.deptName;
	}

	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}

	public Integer getUserNo() {
		return this.userNo;
	}

	public void setCompanyNo(Integer companyNo) {
		this.companyNo = companyNo;
	}

	public Integer getCompanyNo() {
		return this.companyNo;
	}

}