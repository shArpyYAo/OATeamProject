package z_tknight.oa.service.baseServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import z_tknight.oa.commons.util.CaseUtil;
import z_tknight.oa.commons.util.CollectionUtil;
import z_tknight.oa.commons.util.ExceptionUtil;
import z_tknight.oa.commons.util.ResponeResult;
import z_tknight.oa.commons.util.StringUtil;
import z_tknight.oa.model.entity.TBoard;
import z_tknight.oa.model.entity.TBoardExample;
import z_tknight.oa.model.entity.TBoardSpace;
import z_tknight.oa.model.entity.TBoardSpaceUser;
import z_tknight.oa.model.entity.TBoardSpaceUserExample;
import z_tknight.oa.model.entity.TUser;
import z_tknight.oa.model.vo.BoardSpaceAndBoard;
import z_tknight.oa.model.vo.UserDetail;
import z_tknight.oa.persist.complex.mapper.AuthorizationMapper;
import z_tknight.oa.persist.complex.mapper.BoardSpaceAndBoardMapper;
import z_tknight.oa.persist.mapper.TBoardMapper;
import z_tknight.oa.persist.mapper.TBoardSpaceMapper;
import z_tknight.oa.persist.mapper.TBoardSpaceUserMapper;
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
	/** 看板空间和看板复杂操作持久层接口 */
	@Autowired
	private BoardSpaceAndBoardMapper bsbmapper;
	/** 授权认证持久层接口 */
	@Autowired
	private AuthorizationMapper authorizMapper;
	/** 看板空间和用户关系持久层接口 */
	@Autowired
	private TBoardSpaceUserMapper boardSpaceUserMapper;

	/** 查询看板空间成员 */
	@Override
	public ResponeResult findUser(Integer userNo, Integer boardSpaceNo) {
		// 判断发起操作用户是否是看板所有人
		int permission = authorizMapper.isBoardSpaceMember(boardSpaceNo, userNo);
		if(permission != 1 && permission != 2) {
			return ResponeResult.build(400, "参数不合法");
		} else {
			// 查询看板空间成员
			List<TUser> users = bsbmapper.selectBoardSpaceMember(boardSpaceNo);
			if(CollectionUtil.isEmpty(users)) {
				return ResponeResult.build(400, "操作异常");
			} else {
				// 转换成用户详情
				List<UserDetail> userDetails = new ArrayList<>(users.size());
				for(TUser user : users) {
					userDetails.add(new UserDetail(user));
				}
				return ResponeResult.build(200, "操作成功", userDetails);
			}
		}
	}
	
	/** 删除看板空间用户 */
	@Override
	public ResponeResult deleteUser(Integer userNo, Integer targetUserNo, Integer boardSpaceNo) {
		// 判断发起操作用户是否是看板所有人
		// 判断待添加用户是否是看板成员或所有人
		if(authorizMapper.isBoardSpaceMember(boardSpaceNo, userNo) != 1 ||
				authorizMapper.isBoardSpaceMember(boardSpaceNo, targetUserNo) != 2) {
			return ResponeResult.build(400, "参数不合法");
		} else {
			// 删除看板空间成员
			TBoardSpaceUserExample example = new TBoardSpaceUserExample();
			TBoardSpaceUserExample.Criteria criteria = example.createCriteria();
			criteria.andBoardSpaceNoEqualTo(boardSpaceNo);
			criteria.andUserNoEqualTo(targetUserNo);
			boardSpaceUserMapper.deleteByExample(example);
			return ResponeResult.build(200, "操作成功");
		}
	}
	
	/** 添加看板空间用户 */
	@Override
	public ResponeResult addUser(Integer userNo, Integer targetUserNo, Integer boardSpaceNo) {
		// 判断发起操作用户是否是看板成员或所有人
		// 判断待添加用户是否不是看板成员或所有人
		if(authorizMapper.isBoardSpaceMember(boardSpaceNo, userNo) == 0 ||
				authorizMapper.isBoardSpaceMember(boardSpaceNo, targetUserNo) != 0) {
			return ResponeResult.build(400, "参数不合法");
		} else {
			// 目标用户添加为看板空间成员
			TBoardSpaceUser bsu = new TBoardSpaceUser();
			bsu.setBoardSpaceNo(boardSpaceNo);
			bsu.setUserNo(targetUserNo);
			boardSpaceUserMapper.insertSelective(bsu);
			return ResponeResult.build(200, "操作成功");
		}
	}
	
	/**
	 * @Description: 根据用户名查询用户相关的面板空间以及面板，再进行排序
	 * @author：XHX
	 */
	@Override
	public List<BoardSpaceAndBoard> selectBoardSpaceByUserId(int userId) {
		// 获取所有用户需要显示的看板空间,并继而获得需要查询的看板编号
		List<TBoardSpace> tbsList = bsbmapper.selectBoardSpaceByUserNo(userId);
		List<Integer> boardNos = new ArrayList<Integer>();
		
		for(TBoardSpace tbs : tbsList) {
			// 根据看板编号获得有序的看板对象
			getBoardNoByOrder(boardNos, tbs.getBoardOrder());
		}
		// 查询看板信息
		TBoardExample example = new TBoardExample();
		if(CollectionUtil.isNotEmpty(boardNos)) {
			TBoardExample.Criteria c = example.createCriteria();
			c.andBoardNoIn(boardNos);
		}
		List<TBoard> boards = tBoardMapper.selectByExample(example);
		// 获取有序的看板空间及看板信息
		return getOrderlyBoardSpaceAndBoard(tbsList, boards, userId);
	}
	
	/**
	 * 获取一个有序的看板空间及其看板信息对象集合
	 * @param tbsList [List<TBoardSpace>]看板空间集合
	 * @param boards [List<TBoard>]看板集合
	 * @param userNo [Integer]用户编号
	 * @return
	 */
	private static List<BoardSpaceAndBoard> getOrderlyBoardSpaceAndBoard(
			List<TBoardSpace> tbsList, List<TBoard> boards, Integer userNo) {
		// 返回结果集
		List<BoardSpaceAndBoard> tbsbList = new ArrayList<BoardSpaceAndBoard>(tbsList.size());
		BoardSpaceAndBoard tbsb;
		int index = -1;
		// 获取个人看板空间的下标
		for(int i = 0; i < tbsList.size(); i ++) {
			if(tbsList.get(i).getCategoryNo() == 1) {
				index = i;
				break;
			}
		}
		// 把个人空间放在第一位
		if(index != -1 && index != 0) {
			TBoardSpace tmp = tbsList.get(0);
			tbsList.set(0, tbsList.get(index));
			tbsList.set(index, tmp);
		}
		// 看板分类和排序
		for(int i = 0; i < tbsList.size(); i ++) {
			tbsb = new BoardSpaceAndBoard();
			setAttributes(tbsb, tbsList.get(i));
			String[] boardNos = StringUtil.split(tbsList.get(i).getBoardOrder(), ",");
			// 遍历看板空间中所有的看板编号
			for(String boardNo : boardNos) {
				// FIXBUG 修复了看板空间成员可以看见所有看板（即便看板设置了仅看板成员可见）
				// 把看板从看板集合中删除并取出
				TBoard board = remove(boards, CaseUtil.caseInt(boardNo));
				// 看板为空或用户不是看板空间所有人、不是看板所有人、看板仅允许看板成员观看的看板
				if(board == null || 
						(userNo != tbsb.getUserNo() && userNo != board.getUserNo() && 
						board.getDisplayNo() == 1)) {
					continue;
				} else {
					// 然后添加到看板空间的对象属性中
					tbsb.gettBoard().add(board);
				}
			}
			tbsbList.add(tbsb);
		}
		return tbsbList;
	}
	
	/**
	 * 给看板空间及其看板数据对象安装数据
	 * @param tbsb [BoardSpaceAndBoard]看板空间及其看板数据对象
	 * @param tbs [TBoardSpace]待安装的看板空间信息
	 */
	private static void setAttributes(BoardSpaceAndBoard tbsb, TBoardSpace tbs) {
		tbsb.setBoardSpaceName(tbs.getBoardSpaceName());
		tbsb.setBoardSpaceNo(tbs.getBoardSpaceNo());
		tbsb.setCategoryNo(tbs.getCategoryNo());
		tbsb.setSummary(tbs.getSummary());
		tbsb.setUserNo(tbs.getUserNo());
	}
	
	/**
	 * 返回集合中指定看板编号的看板
	 * @param boards [List<TBoard>]看板列表
	 * @param boardSpaceNo [int]看板编号
	 * @return
	 */
	private static TBoard remove(List<TBoard> boards, int boardNo) {
		for(int i = 0; i < boards.size(); i ++) {
			if(boards.get(i).getBoardNo() == boardNo) {
				return boards.remove(i);
			}
		}
		return null;
	}
	
	/**
	 * 通过看板顺序字符串获取看板编号
	 * <pre>
	 * 看板顺序格式为:[编号],[编号],[编号],...[编号]
	 * </pre>
	 * @param boardNos [List<Integer>]看板编号列表
	 * @param order [String]看板顺序字符串
	 */
	private static void getBoardNoByOrder(List<Integer> boardNos, String order) {
		String[] nos = StringUtil.split(order, ",");
		for(String no : nos) {
			boardNos.add(CaseUtil.caseInt(no));
		}
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
