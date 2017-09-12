package z_tknight.oa.model.vo;

import z_tknight.oa.model.entity.TTag;

/**
 * 标签详细信息
 * 
 * @author 随心
 *
 */
public class TagDetail {

	/**
	 * 标签编号
	 */
	private Integer tagNo = null;

	/**
	 * 标签内容
	 */
	private String tagName = null;

	/** 所在的卡片编号 */
	private Integer cardNo = null;
	
	/**
	 * 所属看板编号
	 */
	private Integer boardNo = null;
	
	/** 无参构造 */
	public TagDetail() {}
	
	/** 有参构造 */
	public TagDetail(TTag tag) {
		this.tagNo = tag.getTagNo();
		this.tagName = tag.getTagName();
		this.boardNo = tag.getBoardNo();
	}

	public Integer getTagNo() {
		return tagNo;
	}

	public void setTagNo(Integer tagNo) {
		this.tagNo = tagNo;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Integer getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(Integer boardNo) {
		this.boardNo = boardNo;
	}

	public Integer getCardNo() {
		return cardNo;
	}

	public void setCardNo(Integer cardNo) {
		this.cardNo = cardNo;
	}
	
}
