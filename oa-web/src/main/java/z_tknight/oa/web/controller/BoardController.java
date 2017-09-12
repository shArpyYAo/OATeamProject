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
	@RequestMapping(value="/findBoard/{userNo}", method={RequestMethod.POST})
	@ResponseBody
	public ResponeResult selectBoardDetailByNo(
			HttpServletRequest request, @PathVariable("userNo") Integer boardNo) {
		Integer userNo = CaseUtil.caseInt(request.getSession().getAttribute("userNo"), null);
		
		return boardService.selectBoard(userNo, boardNo);
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
}
