package z_tknight.oa.service.baseService;

import z_tknight.oa.commons.util.ResponeResult;
import z_tknight.oa.model.entity.TUser;

public interface UserService {

	public ResponeResult userLogin(String userName,String password);
	public ResponeResult userCheckEmail(String email);
	public ResponeResult userRegister(TUser user);
	/**
	 * 根据用户昵称,模糊查询用户
	 * @param nickName [String]用户昵称
	 * @return
	 */
	public ResponeResult findUser(String nickName);
}
