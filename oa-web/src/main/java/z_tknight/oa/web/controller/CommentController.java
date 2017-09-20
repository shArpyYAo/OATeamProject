package z_tknight.oa.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import z_tknight.oa.commons.util.CaseUtil;
import z_tknight.oa.commons.util.ResponeResult;
import z_tknight.oa.commons.util.StringUtil;
import z_tknight.oa.service.baseService.CommentService;
import z_tknight.oa.web.annotation.LogInfo;

@Controller
@RequestMapping("/comment")
public class CommentController {

	/** 卡片评论业务逻辑接口 */
	@Autowired
	private CommentService commentService;

	/**
	 * 添加评论
	 * @param request [HttpServletRequest]请求对象
	 * @param cardNo [Integer]添加评论的目标卡片
	 * @param comment [String]评论内容
	 * @return
	 */
	@LogInfo("添加评论")
	@RequestMapping(value="/addComment", method={RequestMethod.POST})
	@ResponseBody
	public ResponeResult addComment(HttpServletRequest request, 
			Integer cardNo, String comment) {
		Integer userNo = CaseUtil.caseInt(request.getSession().getAttribute("userNo"), null);
		// 参数必须全部有效
		if(cardNo == null || userNo == null || StringUtil.isEmpty(comment)) {
			return ResponeResult.build(400, "参数不合法");
		}
		return commentService.addComment(userNo, cardNo, comment);
	}
	
	/**
	 * 删除评论
	 * @param request [HttpServletRequest]请求对象
	 * @param commentNo [Integer]评论编号
	 * @return
	 */
	@LogInfo("删除评论")
	@RequestMapping(value="/deleteComment", method={RequestMethod.POST})
	@ResponseBody
	public ResponeResult deleteComment(HttpServletRequest request, Integer commentNo) {
		Integer userNo = CaseUtil.caseInt(request.getSession().getAttribute("userNo"), null);
		// 参数必须全部有效
		if(commentNo == null || userNo == null) {
			return ResponeResult.build(400, "参数不合法");
		}
		return commentService.deleteComment(userNo, commentNo);
	}
	
}
