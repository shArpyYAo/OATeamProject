package z_tknight.oa.model.entity;


public class TCardHistory {

	/**
	 * 卡片操作记录编号
	 */
	private Integer historyNo = null;

	/**
	 * 操作用户
	 */
	private Integer fromUserId = null;

	/**
	 * 被操作用户
	 */
	private Integer toUserId = null;

	/**
	 * 操作前所属列表名称
	 */
	private String fromListName = null;

	/**
	 * 操作后所属列表名称
	 */
	private String toListName = null;

	/**
	 * 操作前卡片内容
	 */
	private String fromCardTitle = null;

	/**
	 * 操作后卡片内容
	 */
	private String toCardTitle = null;

	/**
	 * 所属看板空间编号
	 */
	private Integer boardSpaceNo = null;

	/**
	 * 所属看板编号
	 */
	private Integer boardNo = null;

	public void setHistoryNo(Integer historyNo) {
		this.historyNo = historyNo;
	}

	public Integer getHistoryNo() {
		return this.historyNo;
	}

	public void setFromUserId(Integer fromUserId) {
		this.fromUserId = fromUserId;
	}

	public Integer getFromUserId() {
		return this.fromUserId;
	}

	public void setToUserId(Integer toUserId) {
		this.toUserId = toUserId;
	}

	public Integer getToUserId() {
		return this.toUserId;
	}

	public void setFromListName(String fromListName) {
		this.fromListName = fromListName;
	}

	public String getFromListName() {
		return this.fromListName;
	}

	public void setToListName(String toListName) {
		this.toListName = toListName;
	}

	public String getToListName() {
		return this.toListName;
	}

	public void setFromCardTitle(String fromCardTitle) {
		this.fromCardTitle = fromCardTitle;
	}

	public String getFromCardTitle() {
		return this.fromCardTitle;
	}

	public void setToCardTitle(String toCardTitle) {
		this.toCardTitle = toCardTitle;
	}

	public String getToCardTitle() {
		return this.toCardTitle;
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