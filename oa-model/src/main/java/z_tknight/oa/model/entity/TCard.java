package z_tknight.oa.model.entity;

import java.sql.Timestamp;

public class TCard {

	/**
	 * 卡片编号
	 */
	private Integer cardNo = null;

	/**
	 * 卡片内容
	 */
	private String cardTitle = null;

	/**
	 * 工作量
	 */
	private Double workLoad = null;

	/**
	 * 截止时间
	 */
	private Timestamp endTime = null;

	/**
	 * 所属看板空间编号
	 */
	private Integer boardSpaceNo = null;

	/**
	 * 所属看板编号
	 */
	private Integer boardNo = null;

	/**
	 * 所属列表编号
	 */
	private Integer listNo = null;

	/**
	 * 所属的列表名称
	 */
	private String listName = null;

	/**
	 * 删除标记
	 */
	private Boolean isDelete = null;

	public void setCardNo(Integer cardNo) {
		this.cardNo = cardNo;
	}

	public Integer getCardNo() {
		return this.cardNo;
	}

	public void setCardTitle(String cardTitle) {
		this.cardTitle = cardTitle;
	}

	public String getCardTitle() {
		return this.cardTitle;
	}

	public void setWorkLoad(Double workLoad) {
		this.workLoad = workLoad;
	}

	public Double getWorkLoad() {
		return this.workLoad;
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

	public void setBoardNo(Integer boardNo) {
		this.boardNo = boardNo;
	}

	public Integer getBoardNo() {
		return this.boardNo;
	}

	public void setListNo(Integer listNo) {
		this.listNo = listNo;
	}

	public Integer getListNo() {
		return this.listNo;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public String getListName() {
		return this.listName;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Boolean isIsDelete() {
		return this.isDelete;
	}

}