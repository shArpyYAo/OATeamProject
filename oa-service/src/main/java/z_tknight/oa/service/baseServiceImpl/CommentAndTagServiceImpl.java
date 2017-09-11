package z_tknight.oa.service.baseServiceImpl;

import java.sql.Timestamp;
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
import z_tknight.oa.model.entity.TCard;
import z_tknight.oa.model.entity.TCardTag;
import z_tknight.oa.model.entity.TCardTagExample;
import z_tknight.oa.model.entity.TComment;
import z_tknight.oa.model.entity.TTag;
import z_tknight.oa.persist.mapper.TBoardMapper;
import z_tknight.oa.persist.mapper.TBoardSpaceMapper;
import z_tknight.oa.persist.mapper.TBoardUserMapper;
import z_tknight.oa.persist.mapper.TCardMapper;
import z_tknight.oa.persist.mapper.TCardTagMapper;
import z_tknight.oa.persist.mapper.TCommentMapper;
import z_tknight.oa.service.baseService.CommentAndTagService;

/**
 * 
* @ClassName: CommentAndTagServiceImpl 
* @Description: 对卡片的评论和标签的各种操作
* @author：XHX
* @date 2017年9月6日 上午9:01:39 
*
 */
@Service
public class CommentAndTagServiceImpl implements CommentAndTagService {

	@Autowired
	private TCardMapper cardMapper;
	@Autowired
	private TBoardMapper boardMapper;
	@Autowired
	private TBoardUserMapper boardUserMapper;
	@Autowired
	private TBoardSpaceMapper boardSpaceMapper;
	@Autowired
	private TCommentMapper commentMapper; 
	@Autowired
	private TCardTagMapper cardTagMapper;
	
	/**
	 * @Description: 判断用户是否是面板空间的所有人，或看板的所有人或成员
	 * @author：XHX
	 */
	private boolean userPower(Integer userNo, Integer cardNo) {
		
		TCard card = cardMapper.selectByPrimaryKey(cardNo);
		//判断卡片编号是否存在
		if(card == null) {
			return false;
		}
		//判断用户是否是面板的所有人
		TBoard board = boardMapper.selectByPrimaryKey(card.getBoardNo());
		if(board.getUserNo() != userNo) {
			TBoardUserExample boardUserExample = new TBoardUserExample();
			Criteria criteria = boardUserExample.createCriteria();
			criteria.andUserNoEqualTo(userNo);
			criteria.andBoardNoEqualTo(board.getBoardNo());
			List<TBoardUser> boardUserList = boardUserMapper.selectByExample(boardUserExample);
			//判断用户是否是面板成员
			if(boardUserList == null || boardUserList.size() == 0) {
				TBoardSpace boardSpace = boardSpaceMapper.selectByPrimaryKey(board.getBoardSpaceNo());
				//判断用户是否是面板空间的所有人
				if(boardSpace.getUserNo() != userNo) {
					return false;
				}
			}
		}
		return true;
	}
	/**
	 * @Description: 卡片增加评论
	 * @author：XHX
	 */
	@Override
	public ResponeResult addComment(Integer userNo, Integer cardNo, String comment) {

		try{
			if(userPower(userNo, cardNo) == false) {
				return ResponeResult.build(400, "数据不合法");
			}
			TComment commentPojo = new TComment();
			commentPojo.setCardNo(cardNo);
			commentPojo.setComment(comment);
			commentPojo.setCommentTime(new Timestamp(System.currentTimeMillis()));
			commentPojo.setUserNo(userNo);
			commentMapper.insertSelective(commentPojo);
			
			return ResponeResult.ok(commentPojo);
		}catch(Exception e) {
			return ResponeResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		
	}
	/**
	 * @Description: 卡片删除评论
	 * @author：XHX
	 */
	@Override
	public ResponeResult deleteComment(Integer userNo, Integer cardNo, Integer commentNo) {

		try{
			
			if(userPower(userNo, cardNo) == false) {
				return ResponeResult.build(400, "数据不合法");
			}
			//判断评论是否匹配卡片
			TComment comment = commentMapper.selectByPrimaryKey(commentNo);
			if(comment == null || comment.getCardNo() != cardNo) {
				return ResponeResult.build(400, "数据不合法");
			}
			commentMapper.deleteByPrimaryKey(commentNo);
			
			return ResponeResult.ok("删除成功");
		}catch(Exception e) {
			return ResponeResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	/**
	 * @Description: 卡片增加标签
	 * @author：XHX
	 */
	@Override
	public ResponeResult cardAddTag(Integer userNo, Integer cardNo, Integer tagNo, String tagName) {

		try{
			if(userPower(userNo, cardNo) == false) {
				return ResponeResult.build(400, "数据不合法");
			}
			TCardTag cardTag = new TCardTag();
			cardTag.setCardNo(cardNo);
			cardTag.setTagNo(tagNo);
			cardTagMapper.insertSelective(cardTag);
			
			return ResponeResult.ok(tagName);
		}catch(Exception e) {
			return ResponeResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	/**
	 * @Description: 卡片删除标签
	 * @author：XHX
	 */
	@Override
	public ResponeResult cardDeleteTag(Integer userNo, Integer cardNo, Integer tagNo) {
		
		try{
			
			if(userPower(userNo, cardNo) == false) {
				return ResponeResult.build(400, "数据不合法");
			}
			//判断标签是否匹配卡片
			TCardTagExample example = new TCardTagExample();
			TCardTagExample.Criteria criteria = example.createCriteria();
			criteria.andCardNoEqualTo(cardNo);
			criteria.andTagNoEqualTo(tagNo);
			List<TCardTag> cardTag = cardTagMapper.selectByExample(example);
			if(cardTag == null || cardTag.size() == 0) {
				return ResponeResult.build(400, "数据不合法");
			}
			cardTagMapper.deleteByPrimaryKey(cardTag.get(0).getRelationNo());
			return ResponeResult.ok("删除成功");
		}catch(Exception e) {
			return ResponeResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
}
