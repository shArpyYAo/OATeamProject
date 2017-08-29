package z_tknight.oa.model.entity;


public class TDepartment {

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
	 * 上级部门编号
	 */
	private Integer superiorDeptNo = null;

	/**
	 * 部门所属看板空间编号
	 */
	private Integer tBoardSpace = null;

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

	public void setSuperiorDeptNo(Integer superiorDeptNo) {
		this.superiorDeptNo = superiorDeptNo;
	}

	public Integer getSuperiorDeptNo() {
		return this.superiorDeptNo;
	}

	public void setTBoardSpace(Integer tBoardSpace) {
		this.tBoardSpace = tBoardSpace;
	}

	public Integer getTBoardSpace() {
		return this.tBoardSpace;
	}

}