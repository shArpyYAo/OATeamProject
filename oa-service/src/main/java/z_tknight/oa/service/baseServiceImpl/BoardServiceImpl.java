package z_tknight.oa.service.baseServiceImpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import z_tknight.oa.commons.util.ArrayUtil;
import z_tknight.oa.commons.util.CollectionUtil;
import z_tknight.oa.commons.util.ExceptionUtil;
import z_tknight.oa.commons.util.ResponeResult;
import z_tknight.oa.commons.util.StringUtil;
import z_tknight.oa.model.entity.TBoard;
import z_tknight.oa.model.entity.TBoardSpace;
import z_tknight.oa.model.entity.TBoardSpaceExample;
import z_tknight.oa.model.entity.TBoardSpaceUser;
import z_tknight.oa.model.entity.TBoardSpaceUserExample;
import z_tknight.oa.model.entity.TBoardUser;
import z_tknight.oa.model.entity.TBoardUserExample;
import z_tknight.oa.model.entity.TCard;
import z_tknight.oa.model.entity.TCardExample;
import z_tknight.oa.model.entity.TList;
import z_tknight.oa.model.entity.TListExample;
import z_tknight.oa.model.entity.TUser;
import z_tknight.oa.model.vo.BoardDetail;
import z_tknight.oa.model.vo.CardDetail;
import z_tknight.oa.model.vo.ListDetail;
import z_tknight.oa.model.vo.TagDetail;
import z_tknight.oa.model.vo.UserDetail;
import z_tknight.oa.persist.complex.mapper.AuthorizationMapper;
import z_tknight.oa.persist.complex.mapper.BoardSpaceAndBoardMapper;
import z_tknight.oa.persist.complex.mapper.CardDetailMapper;
import z_tknight.oa.persist.mapper.TBoardMapper;
import z_tknight.oa.persist.mapper.TBoardSpaceMapper;
import z_tknight.oa.persist.mapper.TBoardSpaceUserMapper;
import z_tknight.oa.persist.mapper.TBoardUserMapper;
import z_tknight.oa.persist.mapper.TCardMapper;
import z_tknight.oa.persist.mapper.TListMapper;
import z_tknight.oa.service.baseService.BoardService;
import z_tknight.oa.service.helper.PermissionHelper;
import z_tknight.oa.service.helper.ResponseResultHelper;

/**
 * 
* @ClassName: BoardServiceImpl 
* @Description: 对面板的各种操作
* @author：XHX
* @date 2017年9月1日 上午10:44:18 
*
 */
@Service
public class BoardServiceImpl implements BoardService {

	/** 看板持久层接口 */
	@Autowired
	private TBoardMapper boardMapper;
	/** 看板空间持久层接口 */
	@Autowired
	private TBoardSpaceMapper boardSpaceMapper;
	/** 看板空间和用户关系持久层接口 */
	@Autowired
	private TBoardSpaceUserMapper boardSpaceUserMapper;
	/** 列表持久层接口 */
	@Autowired
	private TListMapper listMapper;
	/** 卡片持久层接口 */
	@Autowired
	private TCardMapper cardMapper;
	/** 卡片和标签持久层接口 */
	@Autowired
	private CardDetailMapper cardDetailMapper;
	/** 授权持久层接口 */
	@Autowired
	private AuthorizationMapper authorizMapper;
	/** 看板用户关系表操作持久层接口 */
	@Autowired
	private TBoardUserMapper boardUserMapper;
	/** 看板空间和看板复杂操作持久层接口 */
	@Autowired
	private BoardSpaceAndBoardMapper bsbMapper;
	
	/** 查询看板成员 */
	@Override
	public ResponeResult findUser(Integer userNo, Integer boardNo) {
		int permission = authorizMapper.canSelectBoard(userNo, boardNo);
		if(permission < 1 || permission > 3) {
			return ResponeResult.build(400, "参数不合法");
		} else {
			TBoard board = boardMapper.selectByPrimaryKey(boardNo);
			if(board == null || board.isIsDelete()) {
				return ResponeResult.build(400, "参数不合法");
			} else {
				// 查询看板成员
				List<TUser> users = bsbMapper.selectBoardMember(boardNo);
				if(CollectionUtil.isEmpty(users)) {
					return ResponeResult.build(400, "参数异常");
				} else {
					List<UserDetail> userDetails = new ArrayList<>(users.size());
					for(TUser user : users) {
						userDetails.add(new UserDetail(user));
					}
					return ResponeResult.build(200, "操作成功", userDetails);
				}
			}
		}
	}
	
	/** 添加看板成员 */
	@Override
	public ResponeResult addUser(Integer userNo, Integer targetUserNo, Integer boardNo) {
		// 获得看板所在看板空间
		TBoard board = boardMapper.selectByPrimaryKey(boardNo);
		TBoardSpace boardSpace = boardSpaceMapper.selectByPrimaryKey(board.getBoardSpaceNo());
		if(board == null || boardSpace == null) {
			return ResponeResult.build(400, "参数不合法");
		} else {
			// 验证操作发起用户权限
			int tmp = authorizMapper.canSelectBoard(userNo, boardNo);
			if(tmp < 1 || tmp > 3) {
				return ResponeResult.build(400, "参数不合法");
			} else {
				// 验证被操作用户权限
				tmp = authorizMapper.canSelectBoard(targetUserNo, boardNo);
				if(tmp == 2 || tmp == 3 || tmp > 4) {
					return ResponeResult.build(400, "参数不合法");
				} else {
					// 添加用户关系
					TBoardUser boardUser = new TBoardUser();
					boardUser.setBoardNo(boardNo);
					boardUser.setUserNo(targetUserNo);
					boardUserMapper.insertSelective(boardUser);
					// 当前看板空间为个人空间且目标用户不是看板空间所有人
					if(boardSpace.getCategoryNo() == 1 && boardSpace.getUserNo() != targetUserNo) {
						// 目标用户在自己的个人空间添加该看板
						addBoardToSpace(boardNo, targetUserNo);
						// 目标用户同时升级为看板空间成员
						addToBoardSpace(boardSpace.getBoardSpaceNo(), targetUserNo);
					}
					return ResponeResult.build(200, "操作成功");
				}
			}
		}
	}
	
	/**
	 * 用户添加为看板空间成员
	 * @param boardSpace [Integer]看板空间编号
	 * @param userNo [Integer]用户编号
	 */
	private void addToBoardSpace(Integer boardSpaceNo, Integer userNo) {
		// 添加用户为看板空间成员
		TBoardSpaceUser boardSpaceUser = new TBoardSpaceUser();
		boardSpaceUser.setBoardSpaceNo(boardSpaceNo);
		boardSpaceUser.setUserNo(userNo);
		boardSpaceUserMapper.insert(boardSpaceUser);
	}
	
	/**
	 * 把指定看板放入指定用户的个人空间中
	 * @param boardNo [Integer]看板编号
	 * @param userNo [Integer]用户编号
	 */
	private void addBoardToSpace(Integer boardNo, Integer userNo) {
		// 取出用户的个人空间
		TBoardSpaceExample example = new TBoardSpaceExample();
		TBoardSpaceExample.Criteria criteria = example.createCriteria();
		criteria.andUserNoEqualTo(userNo);
		criteria.andCategoryNoEqualTo(1);
		List<TBoardSpace> boardSpaces = boardSpaceMapper.selectByExample(example);
		if(CollectionUtil.isEmpty(boardSpaces)) {
			return;
		} else {
			// 在看板顺序末尾添加上看板编号
			TBoardSpace boardSpace = boardSpaces.get(0);
			if(StringUtil.isEmpty(boardSpace.getBoardOrder())) {
				boardSpace.setBoardOrder(boardNo + "");
			} else {
				boardSpace.setBoardOrder(
						boardSpace.getBoardOrder() + "," + boardNo);
			}
			boardSpaceMapper.updateByPrimaryKeySelective(boardSpace);
		}
	}
	
	/** 删除看板成员 */
	@Override
	public ResponeResult deleteUser(Integer userNo, Integer targetUserNo, Integer boardNo) {
		// 获得看板所在看板空间
		TBoard board = boardMapper.selectByPrimaryKey(boardNo);
		TBoardSpace boardSpace = boardSpaceMapper.selectByPrimaryKey(board.getBoardSpaceNo());
		if(board == null || boardSpace == null) {
			return ResponeResult.build(400, "参数不合法");
		} else {
			// 验证操作发起用户权限:用户是看板空间所有人或看板所有人或看板成员
			int tmp = authorizMapper.canSelectBoard(userNo, boardNo);
			if(tmp < 1 || tmp > 3) {
				return ResponeResult.build(400, "参数不合法");
			} else {
				// 验证被操作用户权限:用户是看板成员
				tmp = authorizMapper.canSelectBoard(targetUserNo, boardNo);
				if(tmp != 3) {
					return ResponeResult.build(400, "参数不合法");
				} else {
					// 删除用户关系
					TBoardUserExample example = new TBoardUserExample();
					TBoardUserExample.Criteria criteria = example.createCriteria();
					criteria.andBoardNoEqualTo(boardNo);
					criteria.andUserNoEqualTo(targetUserNo);
					boardUserMapper.deleteByExample(example);
					// 当前看板空间为个人空间且目标用户不是看板空间所有人
					if(boardSpace.getCategoryNo() == 1 && boardSpace.getUserNo() != targetUserNo) {
						// 目标用户在自己的个人空间移除该看板
						deleteBoardToSpace(boardNo, targetUserNo);
						// 尝试取消目标用户看板空间成员的身份
						deleteFromBoardSpace(boardSpace.getBoardSpaceNo(), targetUserNo);
					}
					return ResponeResult.build(200, "操作成功");
				}
			}
		}
	}
	
	/**
	 * 取消用户看板空间成员的身份
	 * @param boardSpace [Integer]看板空间编号
	 * @param userNo [Integer]用户编号
	 */
	private void deleteFromBoardSpace(Integer boardSpaceNo, Integer userNo) {
		// 添加用户为看板空间成员
		TBoardSpaceUserExample example = new TBoardSpaceUserExample();
		TBoardSpaceUserExample.Criteria criteria = example.createCriteria();
		criteria.andBoardSpaceNoEqualTo(boardSpaceNo);
		criteria.andUserNoEqualTo(userNo);
		boardSpaceUserMapper.deleteByExample(example);
	}
	
	/**
	 * 把指定看板从指定用户的个人空间中删除
	 * @param boardNo [Integer]看板编号
	 * @param userNo [Integer]用户编号
	 */
	private void deleteBoardToSpace(Integer boardNo, Integer userNo) {
		// 取出用户的个人空间
		TBoardSpaceExample example = new TBoardSpaceExample();
		TBoardSpaceExample.Criteria criteria = example.createCriteria();
		criteria.andUserNoEqualTo(userNo);
		criteria.andCategoryNoEqualTo(1);
		List<TBoardSpace> boardSpaces = boardSpaceMapper.selectByExample(example);
		if(CollectionUtil.isEmpty(boardSpaces)) {
			return;
		} else {
			// 移除看板空间中看板顺序中的指定看板编号
			TBoardSpace boardSpace = boardSpaces.get(0);
			boardSpace.setBoardOrder(
					removeNoInOrder(boardSpace.getBoardOrder(), boardNo));
		}
	}
	
	/**
	 * 移除编号顺序中的指定编号
	 * @param order [Stirng]编号顺序
	 * @param boardNo [Integer]编号
	 * @return
	 */
	private String removeNoInOrder(String order, Integer no) {
		if(StringUtil.isEmpty(order)) {
			return order;
		} else {
			if(order.equals(no + "")) { // 唯一编号
				return null;
			} else if(order.startsWith(no + ",")) { // 前缀编号
				return order.replaceAll("^" + no + ",", "");
			} else if(order.endsWith("," + no)) { // 后缀编号
				return order.replaceAll("," + no + "$", "");
			} else { // 中间编号
				return order.replaceAll("," + no + ",", ",");
			}
		}
	}
	
	/**
	 * 查询指定看板的所有列表，以及列表的所有卡片
	 * @param userNo [Integer]用户编号
	 * @param boardNo [Integer]看板编号
	 * @return
	 */
	public ResponeResult selectBoard(Integer userNo, Integer boardNo) {
		if(PermissionHelper.canSelectBoard(userNo, boardNo)) {
			// 查询看板及其列表、卡片信息
			return getBoardDetail(boardNo);
		} else {
			// 用户无权进行此操作
			return ResponseResultHelper.forbidden();
		}
	}
	
	/**
	 * 查询指定看板的所有列表，以及列表的所有卡片
	 * @param boardNo [Integer]看板编号
	 * @return
	 */
	private ResponeResult getBoardDetail(Integer boardNo) {
		TBoard board = boardMapper.selectByPrimaryKey(boardNo);
		if(board == null || board.isIsDelete()) {
			return ResponseResultHelper.badRequest("看板不存在");
		} else {
			// 看板详细信息对象
			BoardDetail boardDetail = new BoardDetail(board);
			// 按看板对象中列表顺序获得列表对象集合
			List<TList> lists = getListByBoard(board);
			if(CollectionUtil.isEmpty(lists)) { // 列表为空,提前返回
				return ResponeResult.build(200, "查询成功",boardDetail);
			} else {
				// 按列表对象中卡片编号顺序获得卡片对象集合
				List<CardDetail> cards = getCardByLists(lists);
				// 遍历安装数据
				ListDetail listDetail = null;
				CardDetail cardDetail = null;
				int cardIndex = 0;
				for(int i = 0; i < lists.size(); i ++) {
					listDetail = new ListDetail(lists.get(i));
					// 判断卡片集合是否为空,避免空指针异常
					for(; cards != null && cardIndex < cards.size(); cardIndex ++) {
						cardDetail = cards.get(cardIndex);
						if(cardDetail.getListNo() == listDetail.getListNo()) {
							// 安装卡片详细信息到列表详细信息中
							listDetail.getCards().add(cardDetail);
						} else {
							break;
						}
					}
					// 安装列表详细信息到看板详细信息中
					boardDetail.getLists().add(listDetail);
				}
				return ResponeResult.build(200, "查询成功", boardDetail);
			}
		}
	}
	
	/**
	 * 根据列表集合按顺序获取列表中所有的卡片
	 * @param lists [List<TList>]列表顺序
	 * @return [List<TCard>] 返回有顺序的卡片集合,如果为空则返回null
	 */
	private List<CardDetail> getCardByLists(List<TList> lists) {
		if(CollectionUtil.isEmpty(lists)) {
			return null;
		} else {
			// 需要查询的卡片编号(需要顺序排列)
			List<Integer> cardNos = new ArrayList<Integer>();
			String[] order;
			for(TList list : lists) {
				// 避免空指针
				order = StringUtil.split(list.getCardOrder(), ",");
				if(ArrayUtil.isNotEmpty(order)) {
					// 按顺序解析当前列表的卡片编号
					cardNos.addAll(ArrayUtil.getIntList(order));
				}
			}
			if(CollectionUtil.isEmpty(cardNos)) {
				return null;
			} else {
				// 查询卡片信息
				TCardExample example = new TCardExample();
				TCardExample.Criteria criteria = example.createCriteria();
				criteria.andCardNoIn(cardNos);
				example.setOrderByClause(orderByNo("card_no", cardNos)); // 排序
				// 获取有序的卡片对象
				List<TCard> cards = cardMapper.selectByExample(example);
				List<TagDetail> tagDetails = cardDetailMapper.selectTagsByCards(cardNos);
				List<CardDetail> cardDetails = new ArrayList<CardDetail>(cards.size());
				// 遍历创建卡片详细信息对象并安装标签详细信息
				CardDetail cDetail = null;
				TagDetail tDetail = null;
				for(int i = 0, k = 0; i < cards.size(); i ++) {
					cDetail = new CardDetail(cards.get(i));
					for(; k < tagDetails.size(); k ++) {
						tDetail = tagDetails.get(k);
						if(tDetail.getCardNo() == cDetail.getCardNo()) {
							// 安装标签详细信息
							cDetail.getTags().add(tDetail);
						}
					}
					// 卡片详细信息载入列表
					cardDetails.add(cDetail);
				}
				return cardDetails;
			}
		}
	}
	
	/**
	 * 获取指定看板的所有的列表集合
	 * @param board [TBoard]看板信息
	 * @return [List<TList>]查询成功返回列表集合,如果集合为空返回null
	 */
	private List<TList> getListByBoard(TBoard board) {
		if(board == null) {
			return null;
		} else {
			// 获取所有列表编号
			List<Integer> listNos = ArrayUtil.getIntList(
					StringUtil.split(board.getListOrder(), ","));
			// 获取列表
			if(CollectionUtil.isNotEmpty(listNos)) {
				TListExample example = new TListExample();
				TListExample.Criteria criteria = example.createCriteria();
				criteria.andListNoIn(listNos);
				example.setOrderByClause(orderByNo("list_no", listNos)); // 排序
				return listMapper.selectByExample(example);
			} else {
				// 看板中无列表返回空集合
				return null;
			}
		}
	}
	
	/**
	 * 拼接出field函数排序使用到的语句
	 * <pre>
	 * 该方法用于获取特定顺序的列表数据、卡片数据
	 * </pre>
	 * @param fieldName [String]字段名
	 * @param nos [List<Integer>]编号列表
	 * @return
	 */
	private String orderByNo(String fieldName, List<Integer> nos) {
		if(CollectionUtil.isEmpty(nos)) {
			return null;
		} else {
			StringBuilder sBuilder = new StringBuilder("field(" + fieldName + "");
			for(int i = 0; i < nos.size(); i ++) {
				sBuilder.append("," + nos.get(i));
			}
			sBuilder.append(")");
			return sBuilder.toString();
		}
	}
	
	/**
	 * @Description: 判断用户是否是看板空间的所有人或成员
	 * 新增看板
	 * 修改看板空间的顺序
	 * @author：XHX
	 */
	@Override
	public ResponeResult addBoard(Integer boardSpaceNo, String boardName, Integer userNo) {
		try{
			
			TBoardSpace boardSpace = boardSpaceMapper.selectByPrimaryKey(boardSpaceNo);
			//判断用户是否面板空间所有人，或是面板空间成员
			if(boardSpace == null) {
				return ResponeResult.build(400, "没有该面板空间");
			}
			if(boardSpace.getUserNo() != userNo) {
				TBoardSpaceUserExample  boardSpaceUserExample = new TBoardSpaceUserExample();
				TBoardSpaceUserExample.Criteria criteria = boardSpaceUserExample.createCriteria();
				criteria.andUserNoEqualTo(userNo);
				criteria.andBoardSpaceNoEqualTo(boardSpaceNo);
				List<TBoardSpaceUser> boardSpaceUsers = boardSpaceUserMapper.selectByExample(boardSpaceUserExample);
				if(boardSpaceUsers==null || boardSpaceUsers.size()==0) {
					return ResponeResult.build(400, "没有权利创建面板");
				}
			}
			//新增面板
			TBoard board = new TBoard();
			board.setBoardName(boardName);
			board.setBoardSpaceNo(boardSpaceNo);
			board.setDisplayNo(2);
			
			Timestamp ts = new Timestamp(System.currentTimeMillis());
			board.setEndTime(ts);
			
			board.setIsDelete(false);
			board.setUserNo(userNo);
			
			boardMapper.insertSelective(board);
			System.out.println(board.getBoardNo());
			//修改面板空间的顺序
			if(boardSpace.getBoardOrder() == null || boardSpace.getBoardOrder().equals("")) {
				boardSpace.setBoardOrder(board.getBoardNo().toString());
			}
			else{
				boardSpace.setBoardOrder(boardSpace.getBoardOrder()+","+board.getBoardNo());
			}
			
			boardSpaceMapper.updateByPrimaryKeySelective(boardSpace);
			
			return ResponeResult.build(200, "新建面板成功", board);
		}catch(Exception e) {
			return ResponeResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		
	}

	/**
	 * @Description: 判断看板是否存在
	 * 判断用户是否为看板或看板空间的所有人
	 * 逻辑上删除看板
	 * 修改面板空间上面板的排序顺序
	 * @author：XHX
	 */
	@Override
	public ResponeResult deleteBoard(Integer userNo, Integer boardNo) {

		try{
			TBoard board = boardMapper.selectByPrimaryKey(boardNo);
			if(board == null) {
				return ResponeResult.build(400, "面板不存在");
			}
			TBoardSpace boardSpace = boardSpaceMapper.selectByPrimaryKey(board.getBoardSpaceNo());
			//判断用户是否是面版或面板空间的所有人
			if(board.getUserNo() == userNo || boardSpace.getUserNo() == userNo) {
				board.setIsDelete(true);
				boardMapper.updateByPrimaryKeySelective(board);
				
				String boardOrder = boardSpace.getBoardOrder();
				String [] order= boardOrder.split(",");
				//如果面板空间中只有一个面板，直接设置为null
				if(order.length<=1) {
					boardSpace.setBoardOrder(null);
				}
				//如果面板空间中有多个面板，则找出要删除的哪个面板，用后面的编号覆盖掉
				else {
					for(int i=0;i<order.length;i++) {
						if(order[i].equals(boardNo.toString())) {
							for(int j=i+1;j<order.length;j++) {
								order[j-1] = order[j];
							}
						}
					}
					String a = order[0];
					for(int i=1;i<order.length-1;i++) {
						a = a + "," + order[i];
					}
					boardSpace.setBoardOrder(a);
				}
				boardSpaceMapper.updateByPrimaryKey(boardSpace);
				
				return ResponeResult.ok("删除成功");
			}else {
				return ResponeResult.build(400, "没有权限修改");
			}
		}catch(Exception e) {
			return ResponeResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}

	/**
	 * @Description: 判断看板空间是否已经被删除
	 * 判断用户是否为看板空间的所有人或面板空间的成员
	 * 判断原面板顺序是否正确
	 * 修改面板空间上面板的排序顺序
	 * @author：XHX
	 */
	@Override
	public ResponeResult updateBoardOrder(String boardOrder, String newBoardOrder, Integer boardSpaceNo, Integer userNo) {

		try {
			TBoardSpace boardSpace = boardSpaceMapper.selectByPrimaryKey(boardSpaceNo);
			//判断面板空间是否已经被删除
			if(boardSpace.isIsDelete()) {
				return ResponeResult.build(400, "面板已经删除");
			}
			//判断用户是否是面板空间的所有人
			if(boardSpace.getUserNo() != userNo) {
				TBoardSpaceUserExample  boardSpaceUserExample = new TBoardSpaceUserExample();
				TBoardSpaceUserExample.Criteria criteria = boardSpaceUserExample.createCriteria();
				criteria.andUserNoEqualTo(userNo);
				criteria.andBoardSpaceNoEqualTo(boardSpaceNo);
				List<TBoardSpaceUser> boardSpaceUsers = boardSpaceUserMapper.selectByExample(boardSpaceUserExample);
				//判断用户是否是面板空间的成员
				if(boardSpaceUsers==null || boardSpaceUsers.size()==0) {
					return ResponeResult.build(400, "没有权限修改面板顺序");
				}
			}
			//判断原面板顺序是否正确
			if(!boardSpace.getBoardOrder().equals(boardOrder)) {
				return ResponeResult.build(400, "面板顺序出错");
			}else {
				boardSpace.setBoardOrder(newBoardOrder);
				boardSpaceMapper.updateByPrimaryKeySelective(boardSpace);
				return ResponeResult.ok("修改面板顺序成功");
			}
		}catch(Exception e) {
			return ResponeResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		
	}


}
