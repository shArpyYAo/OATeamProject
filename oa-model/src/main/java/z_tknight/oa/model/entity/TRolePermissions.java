package z_tknight.oa.model.entity;


public class TRolePermissions {

	/**
	 * 角色权限关系编号
	 */
	private Integer rolePermissionsNo = null;

	/**
	 * 角色编号
	 */
	private Integer roleNo = null;

	/**
	 * 权限编号
	 */
	private Integer permissionNo = null;

	public void setRolePermissionsNo(Integer rolePermissionsNo) {
		this.rolePermissionsNo = rolePermissionsNo;
	}

	public Integer getRolePermissionsNo() {
		return this.rolePermissionsNo;
	}

	public void setRoleNo(Integer roleNo) {
		this.roleNo = roleNo;
	}

	public Integer getRoleNo() {
		return this.roleNo;
	}

	public void setPermissionNo(Integer permissionNo) {
		this.permissionNo = permissionNo;
	}

	public Integer getPermissionNo() {
		return this.permissionNo;
	}

}