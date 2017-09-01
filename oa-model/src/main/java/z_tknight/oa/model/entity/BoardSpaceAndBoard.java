package z_tknight.oa.model.entity;

import java.util.List;

public class BoardSpaceAndBoard {

	/**
	 * 看板空间编号
	 */
	private Integer boardSpaceNo = null;

	/**
	 * 看板空间名称
	 */
	private String boardSpaceName = null;

	/**
	 * 看板空间摘要
	 */
	private String summary = null;

	/**
	 * 看板空间类型
	 */
	private Integer categoryNo = null;

	/**
	 * 看板空间所有者编号
	 */
	private Integer userNo = null;
	
	private List<TBoard> tBoard = null;

	public void setBoardSpaceNo(Integer boardSpaceNo) {
		this.boardSpaceNo = boardSpaceNo;
	}

	public Integer getBoardSpaceNo() {
		return this.boardSpaceNo;
	}

	public void setBoardSpaceName(String boardSpaceName) {
		this.boardSpaceName = boardSpaceName;
	}

	public String getBoardSpaceName() {
		return this.boardSpaceName;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setCategoryNo(Integer categoryNo) {
		this.categoryNo = categoryNo;
	}

	public Integer getCategoryNo() {
		return this.categoryNo;
	}

	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}

	public Integer getUserNo() {
		return this.userNo;
	}

	public List<TBoard> gettBoard() {
		return tBoard;
	}

	public void settBoard(List<TBoard> tBoard) {
		this.tBoard = tBoard;
	}

}
