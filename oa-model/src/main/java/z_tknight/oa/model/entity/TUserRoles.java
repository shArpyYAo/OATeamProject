package z_tknight.oa.model.entity;


public class TUserRoles {

	/**
	 * 用户角色关系编号
	 */
	private Integer userRolesNo = null;

	/**
	 * 用户编号
	 */
	private Integer userNo = null;

	/**
	 * 角色编号
	 */
	private Integer roleNo = null;

	public void setUserRolesNo(Integer userRolesNo) {
		this.userRolesNo = userRolesNo;
	}

	public Integer getUserRolesNo() {
		return this.userRolesNo;
	}

	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}

	public Integer getUserNo() {
		return this.userNo;
	}

	public void setRoleNo(Integer roleNo) {
		this.roleNo = roleNo;
	}

	public Integer getRoleNo() {
		return this.roleNo;
	}

}