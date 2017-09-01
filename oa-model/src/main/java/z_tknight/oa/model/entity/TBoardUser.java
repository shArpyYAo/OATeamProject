package z_tknight.oa.model.entity;


public class TBoardUser {

	/**
	 * 关系编号
	 */
	private Integer relationNo = null;

	/**
	 * 看板编号
	 */
	private Integer boardNo = null;

	/**
	 * 用户编号
	 */
	private Integer userNo = null;

	public void setRelationNo(Integer relationNo) {
		this.relationNo = relationNo;
	}

	public Integer getRelationNo() {
		return this.relationNo;
	}

	public void setBoardNo(Integer boardNo) {
		this.boardNo = boardNo;
	}

	public Integer getBoardNo() {
		return this.boardNo;
	}

	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}

	public Integer getUserNo() {
		return this.userNo;
	}

}