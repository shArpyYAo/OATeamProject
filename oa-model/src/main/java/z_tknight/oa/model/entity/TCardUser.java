package z_tknight.oa.model.entity;


public class TCardUser {

	/**
	 * 关系编号
	 */
	private Integer relationNo = null;

	/**
	 * 卡片编号
	 */
	private Integer cardNo = null;

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

	public void setCardNo(Integer cardNo) {
		this.cardNo = cardNo;
	}

	public Integer getCardNo() {
		return this.cardNo;
	}

	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}

	public Integer getUserNo() {
		return this.userNo;
	}

}