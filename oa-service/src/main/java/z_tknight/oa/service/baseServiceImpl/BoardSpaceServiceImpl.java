package z_tknight.oa.service.baseServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import z_tknight.oa.model.entity.TBoardExample;
import z_tknight.oa.model.entity.TBoardSpace;
import z_tknight.oa.commons.util.ExceptionUtil;
import z_tknight.oa.commons.util.ResponeResult;
import z_tknight.oa.model.entity.BoardSpaceAndBoard;
import z_tknight.oa.model.entity.TBoard;
import z_tknight.oa.model.entity.TBoardSpaceExample;
import z_tknight.oa.model.entity.TBoardSpaceExample.Criteria;
import z_tknight.oa.model.entity.TUser;
import z_tknight.oa.persist.mapper.TBoardMapper;
import z_tknight.oa.persist.mapper.TBoardSpaceMapper;
import z_tknight.oa.persist.mapper.TUserMapper;
import z_tknight.oa.service.baseService.BoardSpaceService;

/**
 * 
* @ClassName: BoardSpaceServiceImpl 
* @Description: 对面板空间的操作
* @author：XHX
* @date 2017年8月31日 下午3:01:22 
*
 */
@Service
public class BoardSpaceServiceImpl implements BoardSpaceService  {

	@Autowired
	private TBoardSpaceMapper tBoardSpaceMapper;
	@Autowired
	private TBoardMapper tBoardMapper;
	@Autowired
	private TUserMapper userMapper;
	
	/**
	 * @Description: 根据用户名查询用户相关的面板空间以及面板，再进行排序
	 * @author：XHX
	 */
	@Override
	public List<BoardSpaceAndBoard> selectBoardSpaceByUserId(int userId) {

		List<BoardSpaceAndBoard> boardSpaceAndBoardList = new ArrayList<BoardSpaceAndBoard>();
		
		TBoardSpaceExample boardSpaceExample = new TBoardSpaceExample();
		Criteria criteria1 = boardSpaceExample.createCriteria();
		criteria1.andUserNoEqualTo(userId);
		List<TBoardSpace> boardSpaceList = tBoardSpaceMapper.selectByExample(boardSpaceExample);
		
		TBoardExample boardExample = new TBoardExample();
		TBoardExample.Criteria criteria2 = boardExample.createCriteria();
		criteria2.andUserNoEqualTo(userId);
		List<TBoard> boardList = tBoardMapper.selectByExample(boardExample);
		
		for(int i = 0;i < boardSpaceList.size();i++){
			String[] boardOrder = boardSpaceList.get(i).getBoardOrder().split(",");
			List<TBoard> board = new ArrayList<TBoard>();
			
			for(int k = 0; k < boardOrder.length;k++){
				for(int j = 0; j < boardList.size(); j++){
					if(boardList.get(j).getBoardNo().toString().equals(boardOrder[k])
							&&boardList.get(j).getBoardSpaceNo().equals(boardSpaceList.get(i).getBoardSpaceNo())){
						board.add(boardList.get(j));
					}
				}
			}
			BoardSpaceAndBoard boardSpaceAndBoard = new BoardSpaceAndBoard();
			boardSpaceAndBoard.settBoard(board);
			boardSpaceAndBoard.setBoardSpaceNo(boardSpaceList.get(i).getBoardSpaceNo());
			boardSpaceAndBoard.setBoardSpaceName(boardSpaceList.get(i).getBoardSpaceName());
			boardSpaceAndBoardList.add(boardSpaceAndBoard);
			
		}
		
		return boardSpaceAndBoardList;
	}

	/**
	 * @Description: 判断用户名是否为面板的所有人
	 * 判断面板空间是否可删
	 * 根据面板空间编号删除面板空间
	 * @author：XHX
	 */
	@Override
	public ResponeResult deleteBoardSpace(Integer userNo, Integer boardSpaceNo) {

		try{
			TBoardSpace boardSpace = tBoardSpaceMapper.selectByPrimaryKey(boardSpaceNo);
			
			//判断用户是否为面板的所有人
			if(boardSpace.getUserNo()!=userNo) {
				return ResponeResult.build(400, "用户没有权限删除");
			}
			//判断是否为个人面板
			if(boardSpace.getBoardSpaceName().equals("个人面板")) {
				return ResponeResult.build(400, "无法删除个人面板");
			}
			//根据面板空间编号，从逻辑上删除面板空间
			boardSpace.setIsDelete(true);
			tBoardSpaceMapper.updateByPrimaryKeySelective(boardSpace);
			return ResponeResult.ok("删除成功");
		}catch(Exception e){
			return ResponeResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	/**
	 * @Description: 判断用户是否存在，新建看板空间
	 * @author：XHX
	 */
	@Override
	public ResponeResult addBoardSpace(Integer userNo, String boardSpaceName) {

		try{
			if(userMapper.selectByPrimaryKey(userNo) == null) {
				return ResponeResult.build(400, "用户不存在");
			}
			
			TBoardSpace boardSpace = new TBoardSpace();
			
			boardSpace.setBoardSpaceName(boardSpaceName);
			boardSpace.setIsDelete(false);
			boardSpace.setSummary(boardSpaceName);
			boardSpace.setUserNo(userNo);
			boardSpace.setCategoryNo(2);
			
			tBoardSpaceMapper.insertSelective(boardSpace);
			
			return ResponeResult.ok(boardSpace);
			
		}catch(Exception e) {
			return ResponeResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}

	/**
	 * @Description: 判断用户是否存在
	 * 判断用户是否是面板空间的所有人
	 * 判断面板空间是否已删除
	 * 判断面板空间是否是普通项目
	 * 修改面板空间
	 * @author：XHX
	 */
	@Override
	public ResponeResult updateBoardSpace(Integer userNo, Integer boardSpaceNo, String newBoardSpaceName,
			String newSummary) {
		
		try{
			if(userMapper.selectByPrimaryKey(userNo) == null) {
				return ResponeResult.build(400, "用户不存在");
			}
			
			TBoardSpace boardSpace = tBoardSpaceMapper.selectByPrimaryKey(boardSpaceNo);
			if(boardSpace.getUserNo()!=userNo) {
				return ResponeResult.build(400, "用户没有权限修改");
			}
			//判断是否为个人面板空间
			if(boardSpace.getCategoryNo()==1) {
				return ResponeResult.build(400, "无法修改个人面板");
			}
			//判断面板空间是否已经删除
			if(boardSpace.isIsDelete()==true) {
				return ResponeResult.build(400, "面板空间已经删除");
			}
			
			boardSpace.setBoardSpaceName(newBoardSpaceName);
			boardSpace.setSummary(newSummary);
			tBoardSpaceMapper.updateByPrimaryKeySelective(boardSpace);
		}catch(Exception e) {
			return ResponeResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		return ResponeResult.ok();
	}
}
