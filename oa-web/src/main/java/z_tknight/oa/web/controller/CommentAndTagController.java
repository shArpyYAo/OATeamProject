package z_tknight.oa.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import z_tknight.oa.commons.util.CaseUtil;
import z_tknight.oa.commons.util.ResponeResult;
import z_tknight.oa.service.baseService.CommentAndTagService;
import z_tknight.oa.web.annotation.LogInfo;

@Controller
@RequestMapping("/comment")
public class CommentAndTagController {

	@Autowired
	private CommentAndTagService commentAndTagService;
	
	@LogInfo("新增卡片评论")
	@RequestMapping(value="/addComment", method={RequestMethod.POST})
	@ResponseBody
	public ResponeResult addComment(HttpServletRequest request, Integer cardNo, String comment) {
		
		if(comment == null || comment.equals("")) {
			return ResponeResult.build(400, "评论不能为空");
		}
		Integer userNo = CaseUtil.caseInt(request.getSession().getAttribute("userNo"), null);
		if(userNo == null) {
			return ResponeResult.build(400, "用户没有登录");
		}
		return commentAndTagService.addComment(userNo, cardNo, comment);
	}
	
	@LogInfo("删除卡片评论")
	@RequestMapping(value="/deleteComment", method={RequestMethod.POST})
	@ResponseBody
	public ResponeResult deleteComment(HttpServletRequest request, Integer cardNo, Integer commentNo) {
		
		request.getSession().setAttribute("userNo", 1);
		Integer userNo = CaseUtil.caseInt(request.getSession().getAttribute("userNo"), null);
		if(userNo == null) {
			return ResponeResult.build(400, "用户没有登录");
		}
		return commentAndTagService.deleteComment(userNo, cardNo, commentNo);
	}
	
	@LogInfo("卡片新增标签")
	@RequestMapping(value="/addCardTag", method={RequestMethod.POST})
	@ResponseBody
	public ResponeResult addCardTag(HttpServletRequest request, Integer cardNo, Integer tagNo, String tagName) {
		
		Integer userNo = CaseUtil.caseInt(request.getSession().getAttribute("userNo"), null);
		if(userNo == null) {
			return ResponeResult.build(400, "用户没有登录");
		}
		return commentAndTagService.cardAddTag(userNo, cardNo, tagNo, tagName);
	}
	
	@LogInfo("卡片删除标签")
	@RequestMapping(value="/deleteCardTag", method={RequestMethod.POST})
	@ResponseBody
	public ResponeResult deleteCardTag(HttpServletRequest request, Integer cardNo, Integer tagNo) {
		
		Integer userNo = CaseUtil.caseInt(request.getSession().getAttribute("userNo"), null);
		if(userNo == null) {
			return ResponeResult.build(400, "用户没有登录");
		}
		return commentAndTagService.cardDeleteTag(userNo, cardNo, tagNo);
	}
}
