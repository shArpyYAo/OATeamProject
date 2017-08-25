package z_tknight.oa.model.entity;


public class TUserNotice {

	/**
	 * 通知记录编号
	 */
	private Integer noticeNo = null;

	/**
	 * 操作用户
	 */
	private Integer fromUserId = null;

	/**
	 * 被操作用户
	 */
	private Integer toUserId = null;

	/**
	 * 所属列表名称
	 */
	private String listName = null;

	/**
	 * 所属看板空间编号
	 */
	private Integer boardSpaceNo = null;

	/**
	 * 所属看板空间名称
	 */
	private String boardSpaceName = null;

	/**
	 * 所属看板编号
	 */
	private Integer boardNo = null;

	/**
	 * 所属看板名称
	 */
	private String boardName = null;

	/**
	 * 操作卡片编号
	 */
	private Integer cardNo = null;

	/**
	 * 操作卡片内容
	 */
	private String cardTitle = null;

	public void setNoticeNo(Integer noticeNo) {
		this.noticeNo = noticeNo;
	}

	public Integer getNoticeNo() {
		return this.noticeNo;
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

	public void setListName(String listName) {
		this.listName = listName;
	}

	public String getListName() {
		return this.listName;
	}

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

}