package z_tknight.oa.model.vo;

import java.sql.Timestamp;

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

	/**
	 * 截止时间
	 */
	private Timestamp endTime = null;

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

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

}
