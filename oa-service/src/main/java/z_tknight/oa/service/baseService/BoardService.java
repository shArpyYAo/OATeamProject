package z_tknight.oa.service.baseService;

import z_tknight.oa.commons.util.ResponeResult;

public interface BoardService {

	public ResponeResult addBoard(Integer boardSpaceNo, String boardName, Integer userNo);
	public ResponeResult deleteBoard(Integer userNo, Integer boardNo);
	public ResponeResult updateBoardOrder(String boardOrder, String newBoardOrder, Integer boardSpaceNo, Integer userNo);
}
