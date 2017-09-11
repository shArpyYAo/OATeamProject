package z_tknight.oa.model.vo;

import java.util.ArrayList;
import java.util.List;

import z_tknight.oa.model.entity.TCard;

/**
 * 列表相信信息
 * <pre>
 * 包含列表信息及列表中卡片信息
 * </pre>
 * 
 * @author 随心
 *
 */
public class ListDetail {

	/**
	 * 列表编号
	 */
	private Integer listNo = null;

	/**
	 * 列表名称
	 */
	private String listName = null;
	
	/** 卡片详细信息 */
	private List<CardDetail> cards = new ArrayList<CardDetail>();

	public Integer getListNo() {
		return listNo;
	}

	public void setListNo(Integer listNo) {
		this.listNo = listNo;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public List<CardDetail> getCards() {
		return cards;
	}

	public void setCards(List<CardDetail> cards) {
		this.cards = cards;
	}
	
}
