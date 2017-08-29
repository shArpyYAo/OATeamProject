package z_tknight.oa.model.entity;


public class TBoardSpace {

	/**
	 * 看板空间编号
	 */
	private Integer boardSpaceNo = null;

	/**
	 * 看板空间名称
	 */
	private String boardSpaceName = null;

	/**
	 * 看板空间摘要
	 */
	private String summary = null;

	/**
	 * 看板空间类型
	 */
	private Integer categoryNo = null;

	/**
	 * 看板空间所有者编号
	 */
	private Integer userNo = null;

	/**
	 * 所属的公司编号
	 */
	private Integer companyNo = null;

	/**
	 * 删除标记
	 */
	private Boolean isDelete = null;

	public void setBoardSpaceNo(Integer boardSpaceNo) {
		this.boardSpaceNo = boardSpaceNo;
	}

	public Integer getBoardSpaceNo() {
		return this.boardSpaceNo;
	}

	public void setBoardSpaceName(String boardSpaceName) {
		this.boardSpaceName = boardSpaceName;
	}

	public String getBoardSpaceName() {
		return this.boardSpaceName;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setCategoryNo(Integer categoryNo) {
		this.categoryNo = categoryNo;
	}

	public Integer getCategoryNo() {
		return this.categoryNo;
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

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Boolean isIsDelete() {
		return this.isDelete;
	}

}