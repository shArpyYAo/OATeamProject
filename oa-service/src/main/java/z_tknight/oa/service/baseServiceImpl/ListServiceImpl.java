package z_tknight.oa.service.baseServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import z_tknight.oa.commons.util.ExceptionUtil;
import z_tknight.oa.commons.util.ResponeResult;
import z_tknight.oa.model.entity.TBoard;
import z_tknight.oa.model.entity.TBoardSpace;
import z_tknight.oa.model.entity.TBoardUser;
import z_tknight.oa.model.entity.TBoardUserExample;
import z_tknight.oa.model.entity.TBoardUserExample.Criteria;
import z_tknight.oa.model.entity.TList;
import z_tknight.oa.persist.mapper.TBoardMapper;
import z_tknight.oa.persist.mapper.TBoardSpaceMapper;
import z_tknight.oa.persist.mapper.TBoardUserMapper;
import z_tknight.oa.persist.mapper.TListMapper;
import z_tknight.oa.service.baseService.ListService;

/**
 * 
* @ClassName: ListServiceImpl 
* @Description: 对列表的各种操作
* @author：XHX
* @date 2017年9月2日 下午6:14:29 
*
 */
@Service
public class ListServiceImpl implements ListService {

	@Autowired
	private TBoardMapper boardMapper;
	@Autowired
	private TListMapper listMapper;
	@Autowired
	private TBoardUserMapper boardUserMapper;
	@Autowired
	private TBoardSpaceMapper boardSpaceMapper;
	
	/**
	 * @Description: 判断看板编号是否存在
	 * 判断用户是否是面板的所有人，或成员，或看板空间的所有人
	 * 新建列表
	 * 修改看板的列表顺序
	 * @author：XHX
	 */
	@Override
	public ResponeResult addList(Integer userNo, String listName, Integer boardNo) {

		try {
			TBoard board = boardMapper.selectByPrimaryKey(boardNo);
			//判断看板编号是否存在
			if(board == null) {
				return ResponeResult.build(400, "数据不合法");
			}
			TBoardSpace boardSpace = boardSpaceMapper.selectByPrimaryKey(board.getBoardSpaceNo());
			//判断用户是否是面板的所有人
			if(board.getUserNo() != userNo) {
				TBoardUserExample boardUserExample = new TBoardUserExample();
				Criteria criteria = boardUserExample.createCriteria();
				criteria.andUserNoEqualTo(userNo);
				criteria.andBoardNoEqualTo(boardNo);
				List<TBoardUser> boardUserList = boardUserMapper.selectByExample(boardUserExample);
				//判断用户是否是面板成员
				if(boardUserList == null || boardUserList.size() == 0) {
					//判断用户是否是面板空间的所有人
					if(boardSpace.getUserNo() != userNo) {
						return ResponeResult.build(400, "没权限创建列表");
					}
				}
			}
			//新增列表
			TList list = new TList();
			list.setBoardNo(boardNo);
			list.setBoardSpaceNo(boardSpace.getBoardSpaceNo());
			list.setIsDelete(false);
			list.setListName(listName);
			listMapper.insertSelective(list);
			//修改看板的列表顺序
			if(board.getListOrder() == null || board.getListOrder().equals("")) {
				board.setListOrder(list.getListNo().toString());
			}
			else {
				board.setListOrder(board.getListOrder() + "," + list.getListNo().toString());
			}
			boardMapper.updateByPrimaryKeySelective(board);
			return ResponeResult.ok(list);
		}catch(Exception e) {
			return ResponeResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		
	}

	/**
	 * @Description: 判断用户是否是看板的所有人或成员，或面板空间的所有人
	 * 修改列表名称
	 * @author：XHX
	 */
	@Override
	public ResponeResult updateListName(Integer userNo, String newListName, Integer listNo) {
		
		try {
			
			TList list = listMapper.selectByPrimaryKey(listNo);
			
			TBoard board = boardMapper.selectByPrimaryKey(list.getBoardNo());
			//判断用户是否是面板的所有人
			if(board.getUserNo() != userNo) {
				TBoardSpace boardSpace = boardSpaceMapper.selectByPrimaryKey(board.getBoardSpaceNo());
				TBoardUserExample boardUserExample = new TBoardUserExample();
				Criteria criteria = boardUserExample.createCriteria();
				criteria.andUserNoEqualTo(userNo);
				criteria.andBoardNoEqualTo(board.getBoardNo());
				List<TBoardUser> boardUserList = boardUserMapper.selectByExample(boardUserExample);
				//判断用户是否是面板成员
				if(boardUserList == null || boardUserList.size() == 0) {
					//判断用户是否是面板空间的所有人
					if(boardSpace.getUserNo() != userNo) {
						return ResponeResult.build(400, "没权限修改列表名称");
					}
				}
			}
			//修改列表名称
			list.setListName(newListName);
			listMapper.updateByPrimaryKeySelective(list);
			return ResponeResult.ok("修改列表名称成功");
		}catch(Exception e) {
			return ResponeResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}

	/**
	 * @Description: 判断用户是否看板的所有人或成员，或看板空间的所有人
	 * 根据列表编号删除列表
	 * 修改看板的列表顺序
	 * @author：XHX
	 */
	@Override
	public ResponeResult deleteList(Integer listNo, Integer userNo) {

		try {
			
			TList list = listMapper.selectByPrimaryKey(listNo);
			
			if(list == null) {
				return ResponeResult.build(400, "数据不合法");
			}
			
			TBoard board = boardMapper.selectByPrimaryKey(list.getBoardNo());
			//判断用户是否是面板的所有人
			if(board.getUserNo() != userNo) {
				TBoardSpace boardSpace = boardSpaceMapper.selectByPrimaryKey(board.getBoardSpaceNo());
				TBoardUserExample boardUserExample = new TBoardUserExample();
				Criteria criteria = boardUserExample.createCriteria();
				criteria.andUserNoEqualTo(userNo);
				criteria.andBoardNoEqualTo(board.getBoardNo());
				List<TBoardUser> boardUserList = boardUserMapper.selectByExample(boardUserExample);
				//判断用户是否是面板成员
				if(boardUserList == null || boardUserList.size() == 0) {
					//判断用户是否是面板空间的所有人
					if(boardSpace.getUserNo() != userNo) {
						return ResponeResult.build(400, "没权限修改列表名称");
					}
				}
			}
			//删除列表
			listMapper.deleteByPrimaryKey(listNo);
			//修改列表的顺序
			String listOrder = board.getListOrder();
			String [] order= listOrder.split(",");
			//如果看板中只有一个列表，直接设置为null
			if(order.length<=1) {
				board.setListOrder(null);
			}
			//如果看板中有多个列表，则找出要删除的哪个列表，用后面的编号覆盖掉
			else {
				for(int i=0;i<order.length;i++) {
					if(order[i].equals(listNo.toString())) {
						for(int j=i+1;j<order.length;j++) {
							order[j-1] = order[j];
						}
					}
				}
				String a = order[0];
				for(int i=1;i<order.length-1;i++) {
					a = a + "," + order[i];
				}
				board.setListOrder(a);
			}
			boardMapper.updateByPrimaryKey(board);
			
			return ResponeResult.ok("删除列表成功");
		}catch(Exception e) {
			return ResponeResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}

	/**
	 * @Description: 判断看板是否已经被删除
	 * 判断用户是否为看板空间的所有人或面板的所有人或成员
	 * 判断原列表顺序是否正确
	 * 修改面板上列表的排序顺序
	 * @author：XHX
	 */
	@Override
	public ResponeResult updateListOrder(String listOrder, String newListOrder, Integer boardNo, Integer userNo) {

		try {
			TBoard board = boardMapper.selectByPrimaryKey(boardNo);
			//判断面板空间是否已经被删除
			if(board.isIsDelete()) {
				return ResponeResult.build(400, "面板已经删除");
			}
			//判断用户是否是面板的所有人
			if(board.getUserNo() != userNo) {
				TBoardUserExample boardUserExample = new TBoardUserExample();
				Criteria criteria = boardUserExample.createCriteria();
				criteria.andUserNoEqualTo(userNo);
				criteria.andBoardNoEqualTo(boardNo);
				List<TBoardUser> boardUserList = boardUserMapper.selectByExample(boardUserExample);
				//判断用户是否是面板成员
				if(boardUserList == null || boardUserList.size() == 0) {
					TBoardSpace boardSpace = boardSpaceMapper.selectByPrimaryKey(board.getBoardSpaceNo());
					//判断用户是否是面板空间的所有人
					if(boardSpace.getUserNo() != userNo) {
						return ResponeResult.build(400, "没权限修改列表顺序");
					}
				}
			}
			//判断原面板顺序是否正确
			if(!board.getListOrder().equals(listOrder)) {
				return ResponeResult.build(400, "列表顺序出错");
			}else {
				board.setListOrder(newListOrder);
				boardMapper.updateByPrimaryKeySelective(board);
				return ResponeResult.ok("修改列表顺序成功");
			}
		}catch(Exception e) {
			return ResponeResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}

}
