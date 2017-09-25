package z_tknight.oa.service.baseService;

import java.util.List;

import z_tknight.oa.commons.util.ResponeResult;
import z_tknight.oa.model.vo.BoardSpaceAndBoard;

public interface BoardSpaceService {

	public List<BoardSpaceAndBoard> selectBoardSpaceByUserId (int userId);
	public ResponeResult deleteBoardSpace(Integer userNo,Integer boardSpaceNo);
	public ResponeResult addBoardSpace(Integer userNo, String boardSpaceName);
	public ResponeResult updateBoardSpace(Integer userNo, Integer boardSpaceNo, String newBoardSpaceName, String newSummary);

	/**
	 * 查询看板空间用户
	 * @param userNo [Integer]发起操作用户编号
	 * @param boardSpaceNo [Integer]看板空间编号
	 * @return
	 */
	public ResponeResult findUser(Integer userNo, Integer boardSpaceNo);

	
	/**
	 * 添加指定看板空间用户
	 * @param userNo [Integer]发起操作用户编号
	 * @param targetUserNo [Integer]待添加用户编号
	 * @param boardSpaceNo [Integer]看板空间编号
	 * @return
	 */
	public ResponeResult addUser(Integer userNo, Integer targetUserNo, Integer boardSpaceNo);

	/**
	 * 删除看板空间用户
	 * @param userNo [Integer]发起操作用户编号
	 * @param targetUserNo [Integer]待删除用户编号
	 * @param boardSpaceNo [Integer]看板空间编号
	 * @return
	 */
	public ResponeResult deleteUser(Integer userNo, Integer targetUserNo, Integer boardSpaceNo);
	
}
