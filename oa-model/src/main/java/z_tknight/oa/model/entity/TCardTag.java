package z_tknight.oa.model.entity;


public class TCardTag {

	/**
	 * 关系编号
	 */
	private Integer relationNo = null;

	/**
	 * 卡片编号
	 */
	private Integer cardNo = null;

	/**
	 * 标签编号
	 */
	private Integer tagNo = null;

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

	public void setTagNo(Integer tagNo) {
		this.tagNo = tagNo;
	}

	public Integer getTagNo() {
		return this.tagNo;
	}

}