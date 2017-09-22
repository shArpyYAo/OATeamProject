package z_tknight.oa.service.baseService;

import z_tknight.oa.commons.util.ResponeResult;

public interface BoardService {

	public ResponeResult selectBoard(Integer userNo, Integer boardNo);
	public ResponeResult addBoard(Integer boardSpaceNo, String boardName, Integer userNo);
	public ResponeResult deleteBoard(Integer userNo, Integer boardNo);
	public ResponeResult updateBoardOrder(String boardOrder, String newBoardOrder, Integer boardSpaceNo, Integer userNo);
	
	/**
	 * 添加看板用户
	 * @param userNo [Integer]发起操作用户编号
	 * @param targetUserNo [Integer]待添加用户编号
	 * @param boardNo [Integer]看板编号
	 * @return
	 */
	public ResponeResult addUser(Integer userNo, Integer targetUserNo, Integer boardNo);

	/**
	 * 删除看板用户
	 * @param userNo [Integer]发起操作用户编号
	 * @param targetUserNo [Integer]待删除用户编号
	 * @param boardNo [Integer]看板编号
	 * @return
	 */
	public ResponeResult deleteUser(Integer userNo, Integer targetUserNo, Integer boardNo);
	
}
