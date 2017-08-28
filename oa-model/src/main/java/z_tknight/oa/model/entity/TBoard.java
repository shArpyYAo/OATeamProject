package z_tknight.oa.model.entity;

import java.sql.Timestamp;

public class TBoard {

	/**
	 * 看板空间编号
	 */
	private Integer boardNo = null;

	/**
	 * 看板空间名称
	 */
	private String boardName = null;

	/**
	 * 看板可见性编号
	 */
	private Integer displayNo = null;

	/**
	 * 看板有效起始时间
	 */
	private Timestamp startTime = null;

	/**
	 * 看板有效截止时间
	 */
	private Timestamp endTime = null;

	/**
	 * 所属看板空间编号
	 */
	private Integer boardSpaceNo = null;

	/**
	 * 删除标记
	 */
	private Boolean isDelete = null;

	/**
	 * 看板所有者编号
	 */
	private Integer userNo = null;

	public void setBoardNo(Integer boardNo) {
		this.boardNo = boardNo;
	}

	public Integer getBoardNo() {
		return this.boardNo;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public String getBoardName() {
		return this.boardName;
	}

	public void setDisplayNo(Integer displayNo) {
		this.displayNo = displayNo;
	}

	public Integer getDisplayNo() {
		return this.displayNo;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setBoardSpaceNo(Integer boardSpaceNo) {
		this.boardSpaceNo = boardSpaceNo;
	}

	public Integer getBoardSpaceNo() {
		return this.boardSpaceNo;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Boolean isIsDelete() {
		return this.isDelete;
	}

	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}

	public Integer getUserNo() {
		return this.userNo;
	}

}