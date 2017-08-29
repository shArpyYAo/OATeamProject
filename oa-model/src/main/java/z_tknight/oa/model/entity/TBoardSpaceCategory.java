package z_tknight.oa.model.entity;


public class TBoardSpaceCategory {

	/**
	 * 看板空间类别编号
	 */
	private Integer categoryNo = null;

	/**
	 * 看板空间类别名称
	 */
	private String categoryName = null;

	public void setCategoryNo(Integer categoryNo) {
		this.categoryNo = categoryNo;
	}

	public Integer getCategoryNo() {
		return this.categoryNo;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

}