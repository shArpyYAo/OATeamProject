package z_tknight.oa.model.dto;

import z_tknight.oa.model.entity.TBoard;
import z_tknight.oa.model.entity.TBoardSpace;

/**
 * 看板空间和看板数据传输对象
 * 
 * @author 随心
 *
 */
public class BoardSpaceAndBoardDto {

	private TBoardSpace boardSpace;
	
	private TBoard board;

	public TBoardSpace getBoardSpace() {
		return boardSpace;
	}

	public void setBoardSpace(TBoardSpace boardSpace) {
		this.boardSpace = boardSpace;
	}

	public TBoard getBoard() {
		return board;
	}

	public void setBoard(TBoard board) {
		this.board = board;
	}
	
}
