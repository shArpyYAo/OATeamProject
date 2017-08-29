package z_tknight.oa.model.entity;


public class TCardOrder {

	/**
	 * 顺序编号
	 */
	private Integer orderNo = null;

	/**
	 * 列表编号
	 */
	private Integer listNo = null;

	/**
	 * 卡片顺序
	 */
	private String cardOrder = null;

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getOrderNo() {
		return this.orderNo;
	}

	public void setListNo(Integer listNo) {
		this.listNo = listNo;
	}

	public Integer getListNo() {
		return this.listNo;
	}

	public void setCardOrder(String cardOrder) {
		this.cardOrder = cardOrder;
	}

	public String getCardOrder() {
		return this.cardOrder;
	}

}