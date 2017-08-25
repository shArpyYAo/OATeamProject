package z_tknight.oa.model.entity;


public class TBoardOrder {

	/**
	 * 顺序编号
	 */
	private Integer orderNo = null;

	/**
	 * 看板空间编号
	 */
	private Integer boardSpaceNo = null;

	/**
	 * 看板顺序
	 */
	private String boardOrder = null;

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getOrderNo() {
		return this.orderNo;
	}

	public void setBoardSpaceNo(Integer boardSpaceNo) {
		this.boardSpaceNo = boardSpaceNo;
	}

	public Integer getBoardSpaceNo() {
		return this.boardSpaceNo;
	}

	public void setBoardOrder(String boardOrder) {
		this.boardOrder = boardOrder;
	}

	public String getBoardOrder() {
		return this.boardOrder;
	}

}