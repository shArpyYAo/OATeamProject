package z_tknight.oa.model.entity;


public class TBoardSpaceUser {

	/**
	 * 关系编号
	 */
	private Integer relationNo = null;

	/**
	 * 看板空间编号
	 */
	private Integer boardSpaceNo = null;

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

	public void setBoardSpaceNo(Integer boardSpaceNo) {
		this.boardSpaceNo = boardSpaceNo;
	}

	public Integer getBoardSpaceNo() {
		return this.boardSpaceNo;
	}

	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}

	public Integer getUserNo() {
		return this.userNo;
	}

}