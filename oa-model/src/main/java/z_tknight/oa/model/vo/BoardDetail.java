package z_tknight.oa.model.vo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import z_tknight.oa.model.entity.TBoard;

/**
 * 看板详细信息
 * <pre>
 * 包含看板信息,看板中列表信息以及看板中卡片信息
 * </pre>
 * 
 * @author 随心
 *
 */
public class BoardDetail {

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
	 * 看板所有者编号
	 */
	private Integer userNo = null;

	/** 看板中列表详细信息 */
	private List<ListDetail> lists = new ArrayList<ListDetail>();

	public BoardDetail() {};
	
	public BoardDetail(TBoard board) {
		this.boardNo = board.getBoardNo();
		this.boardName = board.getBoardName();
		this.boardSpaceNo = board.getBoardSpaceNo();
		this.displayNo = board.getDisplayNo();
		this.endTime = board.getEndTime();
		this.startTime = board.getStartTime();
		this.userNo = board.getUserNo();
	}
	
	public Integer getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(Integer boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public Integer getDisplayNo() {
		return displayNo;
	}

	public void setDisplayNo(Integer displayNo) {
		this.displayNo = displayNo;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public Integer getBoardSpaceNo() {
		return boardSpaceNo;
	}

	public void setBoardSpaceNo(Integer boardSpaceNo) {
		this.boardSpaceNo = boardSpaceNo;
	}

	public Integer getUserNo() {
		return userNo;
	}

	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}

	public List<ListDetail> getLists() {
		return lists;
	}

	public void setLists(List<ListDetail> lists) {
		this.lists = lists;
	}
	
}
