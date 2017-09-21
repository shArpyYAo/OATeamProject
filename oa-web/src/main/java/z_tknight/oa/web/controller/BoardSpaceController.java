package z_tknight.oa.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import z_tknight.oa.commons.util.CaseUtil;
import z_tknight.oa.commons.util.ResponeResult;
import z_tknight.oa.service.baseService.BoardSpaceService;
import z_tknight.oa.web.annotation.LogInfo;


@Controller
@RequestMapping("/boardSpace")
public class BoardSpaceController {
	
	@Autowired
	private BoardSpaceService boardSpaceService;

	@LogInfo("查询个人所有看板空间和看板")
	@RequestMapping(value="/selectBoardSpaceByUserId", method={RequestMethod.POST})
	@ResponseBody
	public ResponeResult selectBoardSpaceByUserId(HttpServletRequest request) {
		Integer userNo = 
				CaseUtil.caseInt(request.getSession().getAttribute("userNo"), null);
		if(userNo == null) {
			return ResponeResult.build(400, "用户未登录");
		} else {
			return ResponeResult.build(
					200, "操作成功", boardSpaceService.selectBoardSpaceByUserId(userNo));
		}
	}
	
	@LogInfo("删除面板空间")
	@RequestMapping(value="/deleteBoardSpace", method={RequestMethod.POST})
	@ResponseBody
	public ResponeResult deleteBoardSpace(Integer boardSpaceNo, HttpServletRequest request) {
		
		Integer userNo = CaseUtil.caseInt(request.getSession().getAttribute("userNo"), null);
		
		return boardSpaceService.deleteBoardSpace(userNo, boardSpaceNo);
	}
	
	@LogInfo("新建面板空间")
	@RequestMapping(value="/addBoardSpace", method={RequestMethod.POST})
	@ResponseBody
	public ResponeResult addBoardSpace(String boardSpaceName, HttpServletRequest request) {
		
		Integer userNo = CaseUtil.caseInt(request.getSession().getAttribute("userNo"), null);
		
		return boardSpaceService.addBoardSpace(userNo, boardSpaceName);
	}
	
	@LogInfo("修改面板空间")
	@RequestMapping(value="/updateBoardSpace", method={RequestMethod.POST})
	@ResponseBody
	public ResponeResult updateBoardSpace(Integer boardSpaceNo, String newBoardSpaceName, String newSummary,
			HttpServletRequest request) {
		
		Integer userNo = CaseUtil.caseInt(request.getSession().getAttribute("userNo"), null);
		
		if(newBoardSpaceName == null||newBoardSpaceName.equals("")) {
			return ResponeResult.build(400, "面板空间不能为空");
		}
		return boardSpaceService.updateBoardSpace(userNo, boardSpaceNo, newBoardSpaceName, newSummary);
	}
	
	@LogInfo("添加看板空间成员")
	@RequestMapping(value="/addUser", method={RequestMethod.POST})
	@ResponseBody
	public ResponeResult addUser(HttpServletRequest request, Integer boardSpaceNo, Integer targetUserNo) {
		Integer userNo = CaseUtil.caseInt(request.getSession().getAttribute("userNo"), null);
		if(userNo == null || targetUserNo == null || boardSpaceNo == null) {
			return ResponeResult.build(400, "参数不合法");
		} else {
			return boardSpaceService.addUser(userNo, targetUserNo, boardSpaceNo);
		}
	}
	
	@LogInfo("删除看板空间成员")
	@RequestMapping(value="/deleteUser", method={RequestMethod.POST})
	@ResponseBody
	public ResponeResult deleteUser(HttpServletRequest request, Integer boardSpaceNo, Integer targetUserNo) {
		Integer userNo = CaseUtil.caseInt(request.getSession().getAttribute("userNo"), null);
		if(userNo == null || targetUserNo == null || boardSpaceNo == null) {
			return ResponeResult.build(400, "参数不合法");
		} else {
			return boardSpaceService.deleteUser(userNo, targetUserNo, boardSpaceNo);
		}
	}
}
