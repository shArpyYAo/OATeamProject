package z_tknight.oa.model.vo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import z_tknight.oa.model.entity.TCard;
import z_tknight.oa.model.entity.TTag;

/**
 * 卡片详细信息
 * <pre>
 * 
 * </pre>
 * 
 * @author 随心
 *
 */
public class CardDetail {

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

	/** 所属列表编号 */
	private Integer listNo = null;
	
	/**
	 * 截止时间
	 */
	private Timestamp endTime = null;
	
	/** 标签对象 */
	private List<TagDetail> tags = new ArrayList<TagDetail>();

	/** 评论信息 */
	private List<CommentDetail> comments;
	
	public CardDetail() {}
	
	public CardDetail(TCard card) {
		this.cardNo = card.getCardNo();
		this.cardTitle = card.getCardTitle();
		this.workLoad = card.getWorkLoad();
		this.endTime = card.getEndTime();
		this.listNo = card.getListNo();
	}

	public List<CommentDetail> getComments() {
		return comments;
	}

	public void setComments(List<CommentDetail> comments) {
		this.comments = comments;
	}

	public Integer getCardNo() {
		return cardNo;
	}

	public void setCardNo(Integer cardNo) {
		this.cardNo = cardNo;
	}

	public String getCardTitle() {
		return cardTitle;
	}

	public void setCardTitle(String cardTitle) {
		this.cardTitle = cardTitle;
	}

	public Double getWorkLoad() {
		return workLoad;
	}

	public void setWorkLoad(Double workLoad) {
		this.workLoad = workLoad;
	}

	public Integer getListNo() {
		return listNo;
	}

	public void setListNo(Integer listNo) {
		this.listNo = listNo;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public List<TagDetail> getTags() {
		return tags;
	}

	public void setTags(List<TagDetail> tags) {
		this.tags = tags;
	}

}
