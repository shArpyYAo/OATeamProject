package z_tknight.oa.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import z_tknight.oa.commons.util.CaseUtil;
import z_tknight.oa.commons.util.ResponeResult;
import z_tknight.oa.service.baseService.BoardService;
import z_tknight.oa.web.annotation.LogInfo;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@LogInfo("新增看板")
	@RequestMapping(value="/addBoard", method={RequestMethod.POST})
	@ResponseBody
	public ResponeResult addBoard(HttpServletRequest request, 
			String newBoardName, Integer boardSpaceNo) {

		Integer userNo = CaseUtil.caseInt(request.getSession().getAttribute("userNo"), null);
		//判断是否登录，判断面板名称是否为空
		if(userNo == null) {
			return ResponeResult.build(400, "用户没有登录");
		}
		if(newBoardName==null || newBoardName.equals("")) {
			return ResponeResult.build(400, "面板名称不能为空");
		}
		
		return boardService.addBoard(boardSpaceNo, newBoardName, userNo);
	}

	@LogInfo("逻辑删除看板")
	@RequestMapping(value="/deleteBoard", method={RequestMethod.POST})
	@ResponseBody
	public ResponeResult deleteBoard(HttpServletRequest request, Integer boardNo) {
		
		Integer userNo = CaseUtil.caseInt(request.getSession().getAttribute("userNo"), null);
		//判断是否登录，判断面板名称是否为空
		if(userNo == null) {
			return ResponeResult.build(400, "用户没有登录");
		}
		return boardService.deleteBoard(userNo, boardNo);
	}
	
	@LogInfo("修改看板顺序")
	@RequestMapping(value="/updateBoardOrder", method={RequestMethod.POST})
	@ResponseBody
	public ResponeResult updateBoardOrder(HttpServletRequest request, String boardOrder, 
			String newBoardOrder, Integer boardSpaceNo) {
		
		Integer userNo = CaseUtil.caseInt(request.getSession().getAttribute("userNo"), null);
		//判断是否登录
		if(userNo == null) {
			return ResponeResult.build(400, "用户没有登录");
		}
		
		return boardService.updateBoardOrder(boardOrder, newBoardOrder, boardSpaceNo, userNo);
	}
}
