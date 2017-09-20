package z_tknight.oa.service.baseServiceImpl;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import z_tknight.oa.commons.util.ResponeResult;
import z_tknight.oa.model.entity.TCard;
import z_tknight.oa.model.entity.TComment;
import z_tknight.oa.persist.complex.mapper.AuthorizationMapper;
import z_tknight.oa.persist.mapper.TCardMapper;
import z_tknight.oa.persist.mapper.TCommentMapper;
import z_tknight.oa.service.baseService.CommentService;

/**
 * 卡片评论业务逻辑实现类
 * 
 * @author 随心
 *
 */
@Service
public class CommentServiceImpl implements CommentService {

	/** 评论操作持久层接口 */
	@Autowired
	private TCommentMapper commentMapper;
	/** 授权操作持久层接口 */
	@Autowired
	private AuthorizationMapper authorizMapper;
	/** 卡片操作持久层接口 */
	@Autowired
	private TCardMapper cardMapper;
	
	/** 删除评论 */
	@Override
	public ResponeResult deleteComment(Integer userNo, Integer commentNo) {
		TComment comment = commentMapper.selectByPrimaryKey(commentNo);
		if(comment == null) {
			return ResponeResult.build(400, "参数异常");
		} else {
			if(comment.getUserNo() != userNo) {
				return ResponeResult.build(403, "操作权限不足,请及时充值");
			} else {
				TCard card = cardMapper.selectByPrimaryKey(comment.getCardNo());
				if(card == null) {
					return ResponeResult.build(400, "参数异常");
				} else {
					// 授权
					Integer permission = authorizMapper.canSelectBoard(userNo, card.getBoardNo());
					if(permission < 1 || permission > 2) {
						return ResponeResult.build(403, "操作权限不足,请及时充值");
					} else {
						commentMapper.deleteByPrimaryKey(commentNo);
						return ResponeResult.build(200, "操作成功");
					}
				}
			}
		}
	}
	
	/** 添加评论 */
	@Override
	public ResponeResult addComment(Integer userNo, Integer cardNo, String comment) {
		TCard card = cardMapper.selectByPrimaryKey(cardNo);
		if(card == null) {
			return ResponeResult.build(400, "参数异常");
		} else {
			// 授权
			Integer permission = authorizMapper.canSelectBoard(userNo, card.getBoardNo());
			if(permission < 1 || permission > 3) {
				return ResponeResult.build(403, "操作权限不足,请及时充值");
			} else {
				// 添加评论
				TComment c = new TComment();
				c.setCardNo(cardNo);
				c.setComment(comment);
				c.setUserNo(userNo);
				c.setCommentTime(new Timestamp(new Date().getTime()));
				commentMapper.insertSelective(c);
				return ResponeResult.build(200, "操作成功", c);
			}
		}
	}

}
