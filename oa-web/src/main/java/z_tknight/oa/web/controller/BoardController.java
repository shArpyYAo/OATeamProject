package z_tknight.oa.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	/**
	 * 查询指定看板的所有列表，以及列表的所有卡片
	 * @param request [HttpServletRequest]请求对象
	 * @param boardNo [Integer]看板编号(restful)
	 * @return
	 */
	@LogInfo("查询看板内容")
	@RequestMapping(value="/findBoard/{boardNo}", method={RequestMethod.POST})
	@ResponseBody
	public ResponeResult selectBoardDetailByNo(
			HttpServletRequest request, @PathVariable("boardNo") Integer boardNo) {
		Integer userNo = CaseUtil.caseInt(request.getSession().getAttribute("userNo"), null);
		if(userNo == null) {
			return ResponeResult.build(400, "参数不合法");
		} else {
			return boardService.selectBoard(userNo, boardNo);
		}
	}
	
	@LogInfo("新增看板")
	@RequestMapping(value="/addBoard", method={RequestMethod.POST})
	@ResponseBody
	public ResponeResult addBoard(HttpServletRequest request, 
			String newBoardName, Integer boardSpaceNo) {

		Integer userNo = CaseUtil.caseInt(request.getSession().getAttribute("userNo"), null);
		
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
		
		return boardService.deleteBoard(userNo, boardNo);
	}
	
	@LogInfo("修改看板顺序")
	@RequestMapping(value="/updateBoardOrder", method={RequestMethod.POST})
	@ResponseBody
	public ResponeResult updateBoardOrder(HttpServletRequest request, String boardOrder, 
			String newBoardOrder, Integer boardSpaceNo) {
		
		Integer userNo = CaseUtil.caseInt(request.getSession().getAttribute("userNo"), null);
		
		return boardService.updateBoardOrder(boardOrder, newBoardOrder, boardSpaceNo, userNo);
	}
	
	@LogInfo("查询看板成员")
	@RequestMapping(value="/findUser", method={RequestMethod.POST})
	@ResponseBody
	public ResponeResult findUser(HttpServletRequest request, Integer boardNo) {
		Integer userNo = CaseUtil.caseInt(request.getSession().getAttribute("userNo"), null);
		if(userNo == null || boardNo == null) {
			return ResponeResult.build(400, "参数不合法");
		} else {
			return boardService.findUser(userNo, boardNo);
		}
	}
	
	@LogInfo("添加看板成员")
	@RequestMapping(value="/addUser", method={RequestMethod.POST})
	@ResponseBody
	public ResponeResult addUser(HttpServletRequest request, Integer boardNo, Integer targetUserNo) {
		Integer userNo = CaseUtil.caseInt(request.getSession().getAttribute("userNo"), null);
		if(userNo == null || targetUserNo == null || boardNo == null) {
			return ResponeResult.build(400, "参数不合法");
		} else {
			return boardService.addUser(userNo, targetUserNo, boardNo);
		}
	}
	
	@LogInfo("删除看板成员")
	@RequestMapping(value="/deleteUser", method={RequestMethod.POST})
	@ResponseBody
	public ResponeResult deleteUser(HttpServletRequest request, Integer boardNo, Integer targetUserNo) {
		Integer userNo = CaseUtil.caseInt(request.getSession().getAttribute("userNo"), null);
		if(userNo == null || targetUserNo == null || boardNo == null) {
			return ResponeResult.build(400, "参数不合法");
		} else {
			return boardService.deleteUser(userNo, targetUserNo, boardNo);
		}
	}
	
}
