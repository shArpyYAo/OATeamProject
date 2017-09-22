package z_tknight.oa.service.baseServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import z_tknight.oa.commons.util.CollectionUtil;
import z_tknight.oa.commons.util.ExceptionUtil;
import z_tknight.oa.commons.util.ResponeResult;
import z_tknight.oa.model.entity.TBoardSpace;
import z_tknight.oa.model.entity.TUser;
import z_tknight.oa.model.entity.TUserExample;
import z_tknight.oa.model.entity.TUserExample.Criteria;
import z_tknight.oa.model.vo.UserDetail;
import z_tknight.oa.persist.mapper.TBoardSpaceMapper;
import z_tknight.oa.persist.mapper.TUserMapper;
import z_tknight.oa.service.baseService.UserService;

@Service
public class UserServiceImpl implements UserService {

	/**
	 * slf4j日志配置
	 */
	private static final Logger _LOG = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	TUserMapper userMapper;
	@Autowired
	TBoardSpaceMapper boardSpaceMapper;

	/** 查询用户 */
	@Override
	public ResponeResult findUser(String nickName) {
		// 模糊查询
		TUserExample example = new TUserExample();
		TUserExample.Criteria criteria = example.createCriteria();
		criteria.andNickNameLike("%" + nickName + "%");
		List<TUser> users = userMapper.selectByExample(example);
		if(CollectionUtil.isEmpty(users)) {
			return ResponeResult.build(200, "操作成功");
		} else {
			// 转为vo对象
			List<UserDetail> userDetails = new ArrayList<>(users.size());
			for(TUser user : users) {
				userDetails.add(new UserDetail(user));
			}
			return ResponeResult.build(200, "操作成功", userDetails);
		}
	}
	
	@Override
	public ResponeResult userLogin(String userName, String password) {
		
		TUserExample example = new TUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(userName);
		List<TUser> userList = userMapper.selectByExample(example);
		if(userList==null || userList.size()==0){
			return ResponeResult.build(400, "用户名或密码错误");
		}
		TUser user = userList.get(0);
		if(!password.equals(user.getPassword())){
			return ResponeResult.build(400, "用户名或密码错误");
		}
		return ResponeResult.ok(user.getUserNo());
	}

	@Override
	public ResponeResult userCheckEmail(String email) {
		
		if(!email.matches("^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\\.[a-zA-Z0-9_-]{2,3}){1,2})$")){
			return ResponeResult.build(400, "邮箱不合法");
		}
		
		TUserExample example = new TUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(email);
		List<TUser> userList = userMapper.selectByExample(example);
		if(userList.size()==0||userList==null) {
			return ResponeResult.ok("邮箱可用");
		}
		return ResponeResult.build(400, "邮箱已被注册");
	}

	@Override
	public ResponeResult userRegister(TUser user) {
		
		try{
			userMapper.insertSelective(user);
			TBoardSpace boardSpace = new TBoardSpace();
			boardSpace.setBoardSpaceName("个人面板");
			
			_LOG.debug("新增用户的编号："+user.getUserNo());
			
			boardSpace.setUserNo(user.getUserNo());
			boardSpace.setSummary("个人面板");
			boardSpace.setCategoryNo(1);
			boardSpace.setIsDelete(false);
			boardSpaceMapper.insertSelective(boardSpace);
		}catch(Exception e){
			return ResponeResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		
		
		return ResponeResult.ok(user.getUserNo());
	}

}
