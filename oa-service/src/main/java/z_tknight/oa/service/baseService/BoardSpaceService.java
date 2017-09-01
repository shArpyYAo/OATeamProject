package z_tknight.oa.service.baseService;

import java.util.List;

import z_tknight.oa.commons.util.ResponeResult;
import z_tknight.oa.model.vo.BoardSpaceAndBoard;

public interface BoardSpaceService {

	public List<BoardSpaceAndBoard> selectBoardSpaceByUserId (int userId);
	public ResponeResult deleteBoardSpace(Integer userNo,Integer boardSpaceNo);
	public ResponeResult addBoardSpace(Integer userNo, String boardSpaceName);
	public ResponeResult updateBoardSpace(Integer userNo, Integer boardSpaceNo, String newBoardSpaceName, String newSummary);
	
}
