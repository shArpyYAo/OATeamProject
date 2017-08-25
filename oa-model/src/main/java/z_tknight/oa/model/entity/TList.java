package z_tknight.oa.model.entity;


public class TList {

	/**
	 * 列表编号
	 */
	private Integer listNo = null;

	/**
	 * 列表名称
	 */
	private String listName = null;

	/**
	 * 所属看板空间编号
	 */
	private Integer boardSpaceNo = null;

	/**
	 * 所属看板编号
	 */
	private Integer boardNo = null;

	public void setListNo(Integer listNo) {
		this.listNo = listNo;
	}

	public Integer getListNo() {
		return this.listNo;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public String getListName() {
		return this.listName;
	}

	public void setBoardSpaceNo(Integer boardSpaceNo) {
		this.boardSpaceNo = boardSpaceNo;
	}

	public Integer getBoardSpaceNo() {
		return this.boardSpaceNo;
	}

	public void setBoardNo(Integer boardNo) {
		this.boardNo = boardNo;
	}

	public Integer getBoardNo() {
		return this.boardNo;
	}

}