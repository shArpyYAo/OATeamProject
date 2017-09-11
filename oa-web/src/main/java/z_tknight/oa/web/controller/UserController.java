package z_tknight.oa.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import z_tknight.oa.commons.util.ResponeResult;
import z_tknight.oa.commons.util.StringUtil;
import z_tknight.oa.model.entity.TUser;
import z_tknight.oa.service.baseService.UserService;


@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/checkEmail")
	@ResponseBody
	public ResponeResult userCheckEmail(@RequestParam(value="email",required=true) String email) {
		
		return userService.userCheckEmail(email);
		
	}
	
	@RequestMapping(value="/register", method={RequestMethod.POST})
	@ResponseBody
	public ResponeResult userRegister(TUser user) {
		
		if(StringUtil.isEmpty(user.getPassword()) ||
				StringUtil.isEmpty(user.getUserName()) ||
				StringUtil.isEmpty(user.getNickName())) {
			return ResponeResult.build(400, "数据不能为空");
		} else {
			ResponeResult result = userService.userCheckEmail(user.getUserName());
			if(result.getStatus() == 200) { 
				return userService.userRegister(user);
			}
			return result;
		}
		
	}

	@RequestMapping(value="/login", method={RequestMethod.POST})
	@ResponseBody
	public ResponeResult userLogin(String userName, String password, HttpServletRequest request) {
		
		if(StringUtil.isEmpty(password) ||
				StringUtil.isEmpty(password)) {
			return ResponeResult.build(400, "数据不能为空");
		} else {
			ResponeResult result = userService.userLogin(userName, password);
			if(result.getStatus().equals(200)){
				Integer userNo = (Integer)result.getData();
				request.getSession().setAttribute("userNo", userNo);
			}
			return result;
		}
	}
}
