package z_tknight.oa.model.entity;


public class TComment {

	/**
	 * 评论编号
	 */
	private Integer commentId = null;

	/**
	 * 评论内容
	 */
	private String comment = null;

	/**
	 * 所属卡片编号
	 */
	private Integer cardNo = null;

	/**
	 * 评论发起用户编号
	 */
	private Integer userNo = null;

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public Integer getCommentId() {
		return this.commentId;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getComment() {
		return this.comment;
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