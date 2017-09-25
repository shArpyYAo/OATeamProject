package z_tknight.oa.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import z_tknight.oa.commons.util.CaseUtil;
import z_tknight.oa.commons.util.ResponeResult;
import z_tknight.oa.commons.util.StringUtil;
import z_tknight.oa.model.entity.TUser;
import z_tknight.oa.service.baseService.UserService;
import z_tknight.oa.web.annotation.LogInfo;


@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@LogInfo("检测邮箱")
	@RequestMapping(value="/checkEmail", method={RequestMethod.POST})
	@ResponseBody
	public ResponeResult userCheckEmail(@RequestParam("email") String email) {
		
		return userService.userCheckEmail(email);
		
	}
	
	@LogInfo("用户注册")
	@RequestMapping(value="/register", method={RequestMethod.POST})
	@ResponseBody
	public ResponeResult userRegister(HttpServletRequest request,TUser user) {
		
		if(StringUtil.isEmpty(user.getPassword()) ||
				StringUtil.isEmpty(user.getUserName()) ||
				StringUtil.isEmpty(user.getNickName())) {
			return ResponeResult.build(400, "数据不能为空");
		} else {
			ResponeResult result = userService.userCheckEmail(user.getUserName());
			if(result.getStatus() == 200) { 
				request.getSession().setAttribute("userNo", result.getData());
				return userService.userRegister(user);
			}
			return result;
		}
		
	}
	
	@LogInfo("用户登录")
	@RequestMapping(value="/login", method={RequestMethod.POST})
	@ResponseBody
	public ResponeResult userLogin(String userName, String password, HttpServletRequest request) {
		
		if(StringUtil.isEmpty(password) ||
				StringUtil.isEmpty(password)) {
			return ResponeResult.build(400, "数据不能为空");
		} else {
		
			ResponeResult result = userService.userLogin(userName, password);
			if(result.getStatus().equals(200)){
				request.getSession().setAttribute("userNo", result.getData());
				result.setData(null); // 不返回任何数据
			}
			return result;
		}
		
	}
	
	@LogInfo("查询用户")
	@RequestMapping(value="/findUser", method={RequestMethod.POST})
	@ResponseBody
	public ResponeResult findUser(HttpServletRequest request, String nickName) {
		Integer userNo = CaseUtil.caseInt( request.getSession().getAttribute("userNo"), null);
		if(userNo == null || StringUtil.isEmpty(nickName)) {
			return ResponeResult.build(400, "参数不合法");
		} else {
			return userService.findUser(nickName);
		}
	}
	
	@LogInfo("查询个人信息")
	@RequestMapping(value="/findUserInfo", method={RequestMethod.POST})
	@ResponseBody
	public ResponeResult findUserInfo(HttpServletRequest request) {
		Integer userNo = CaseUtil.caseInt( request.getSession().getAttribute("userNo"), null);
		if(userNo == null) {
			return ResponeResult.build(400, "参数不合法");
		} else {
			return userService.findUserInfo(userNo);
		}
	}
	
	@LogInfo("修改昵称")
	@RequestMapping(value="/updateNickName", method={RequestMethod.POST})
	@ResponseBody
	public ResponeResult updateNickName(HttpServletRequest request, String newNickName, String newIntroduction) {
		Integer userNo = CaseUtil.caseInt( request.getSession().getAttribute("userNo"), null);
		if(userNo == null || StringUtil.isEmpty(newNickName)) {
			return ResponeResult.build(400, "参数不合法");
		} else {
			return userService.updateNickName(userNo, newNickName, newIntroduction);
		}
	}
	
	@LogInfo("修改密码")
	@RequestMapping(value="/updatePassword", method={RequestMethod.POST})
	@ResponseBody
	public ResponeResult updatePassword(HttpServletRequest request, String oldPassword, String newPassword) {
		Integer userNo = CaseUtil.caseInt( request.getSession().getAttribute("userNo"), null);
		if(userNo == null || StringUtil.isEmpty(oldPassword) || StringUtil.isEmpty(newPassword)) {
			return ResponeResult.build(400, "参数不合法");
		} else {
			return userService.updatePassword(userNo, oldPassword, newPassword);
		}
	}
	
}
