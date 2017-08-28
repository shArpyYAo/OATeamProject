package z_tknight.oa.model.entity;


public class TCompany {

	/**
	 * 公司编号
	 */
	private Integer companyNo = null;

	/**
	 * 公司名称
	 */
	private String companyName = null;

	/**
	 * 公司所有者编号
	 */
	private Integer userNo = null;

	public void setCompanyNo(Integer companyNo) {
		this.companyNo = companyNo;
	}

	public Integer getCompanyNo() {
		return this.companyNo;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}

	public Integer getUserNo() {
		return this.userNo;
	}

}