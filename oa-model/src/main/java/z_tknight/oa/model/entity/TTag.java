package z_tknight.oa.model.entity;


public class TTag {

	/**
	 * 标签编号
	 */
	private Integer tagNo = null;

	/**
	 * 标签内容
	 */
	private String tagName = null;

	/**
	 * 所属看板空间编号
	 */
	private Integer boardSpaceNo = null;

	/**
	 * 所属看板编号
	 */
	private Integer boardNo = null;

	public void setTagNo(Integer tagNo) {
		this.tagNo = tagNo;
	}

	public Integer getTagNo() {
		return this.tagNo;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getTagName() {
		return this.tagName;
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