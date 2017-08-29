package z_tknight.oa.model.entity;


public class TPermission {

	/**
	 * 权限编号
	 */
	private Integer permissionNo = null;

	/**
	 * 权限名
	 */
	private String permissionName = null;

	public void setPermissionNo(Integer permissionNo) {
		this.permissionNo = permissionNo;
	}

	public Integer getPermissionNo() {
		return this.permissionNo;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public String getPermissionName() {
		return this.permissionName;
	}

}