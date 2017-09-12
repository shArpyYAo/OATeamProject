package z_tknight.oa.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import z_tknight.oa.commons.util.CaseUtil;
import z_tknight.oa.commons.util.ResponeResult;
import z_tknight.oa.service.baseService.ListService;
import z_tknight.oa.web.annotation.LogInfo;

@Controller
@RequestMapping("/list")
public class ListController {

	@Autowired
	private ListService listService;
	
	@LogInfo("新增列表")
	@RequestMapping(value="/addList", method={RequestMethod.POST})
	@ResponseBody
	public ResponeResult addList(HttpServletRequest request, String listName, Integer boardNo) {
		
		if(listName ==null || listName.equals("")) {
			return ResponeResult.build(400, "列表名称不能为空");
		}
		
		Integer userNo = CaseUtil.caseInt(request.getSession().getAttribute("userNo"), null);
		
		return listService.addList(userNo, listName, boardNo);
	}
	
	@LogInfo("修改列表名称")
	@RequestMapping(value="/updateListName", method={RequestMethod.POST})
	@ResponseBody
	public ResponeResult updateListName(HttpServletRequest request, String newListName, Integer listNo) {
		
		if(newListName ==null || newListName.equals("")) {
			return ResponeResult.build(400, "列表名称不能为空");
		}
		Integer userNo = CaseUtil.caseInt(request.getSession().getAttribute("userNo"), null);
		
		return listService.updateListName(userNo, newListName, listNo);
	}
	
	@LogInfo("删除列表")
	@RequestMapping(value="/deleteList", method={RequestMethod.POST})
	@ResponseBody
	public ResponeResult deleteList(HttpServletRequest request, Integer listNo) {
		
		Integer userNo = CaseUtil.caseInt(request.getSession().getAttribute("userNo"), null);
		
		return listService.deleteList(listNo, userNo);
	}
	
	@LogInfo("修改列表顺序")
	@RequestMapping(value="/updateListOrder", method={RequestMethod.POST})
	@ResponseBody
	public ResponeResult updateListOrder(HttpServletRequest request, String listOrder, 
			String newListOrder, Integer boardNo) {
		
		Integer userNo = CaseUtil.caseInt(request.getSession().getAttribute("userNo"), null);
		
		return listService.updateListOrder(listOrder, newListOrder, boardNo, userNo);
	}
}
