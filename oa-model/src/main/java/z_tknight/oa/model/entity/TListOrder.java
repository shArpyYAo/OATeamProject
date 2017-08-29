package z_tknight.oa.model.entity;


public class TListOrder {

	/**
	 * 顺序编号
	 */
	private Integer orderNo = null;

	/**
	 * 看板编号
	 */
	private Integer boardNo = null;

	/**
	 * 列表顺序
	 */
	private String listOrder = null;

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getOrderNo() {
		return this.orderNo;
	}

	public void setBoardNo(Integer boardNo) {
		this.boardNo = boardNo;
	}

	public Integer getBoardNo() {
		return this.boardNo;
	}

	public void setListOrder(String listOrder) {
		this.listOrder = listOrder;
	}

	public String getListOrder() {
		return this.listOrder;
	}

}