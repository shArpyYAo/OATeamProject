package z_tknight.oa.service.baseService;

import z_tknight.oa.commons.util.ResponeResult;

/**
 * 卡片评论业务逻辑接口
 * 
 * @author 随心
 *
 */
public interface CommentService {

	/**
	 * 添加评论
	 * @param userNo [Integer]用户编号
	 * @param cardNo [Integer]添加评论的目标卡片
	 * @param comment [String]评论内容
	 * @return
	 */
	public ResponeResult addComment(Integer userNo, Integer cardNo, String comment);
	
	/**
	 * 删除评论
	 * @param userNo [Integer]用户编号
	 * @param commentNo [Integer]评论编号
	 * @return
	 */
	public ResponeResult deleteComment(Integer userNo, Integer commentNo);
}
