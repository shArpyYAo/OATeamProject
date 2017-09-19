package z_tknight.oa.model.vo;

import java.sql.Timestamp;

/**
 * 评论详情
 * 
 * @author 随心
 *
 */
public class CommentDetail {

	/** 评论编号 */
	private Integer commentNo = null;

	/** 评论内容 */
	private String comment = null;

	/** 评论发起用户编号 */
	private Integer userNo = null;
	
	/** 评论用户昵称 */
	private String nickName = null;

	/** 评论时间 */
	private Timestamp commentTime = null;

	public Integer getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(Integer commentNo) {
		this.commentNo = commentNo;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getUserNo() {
		return userNo;
	}

	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Timestamp getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(Timestamp commentTime) {
		this.commentTime = commentTime;
	}
	
}
