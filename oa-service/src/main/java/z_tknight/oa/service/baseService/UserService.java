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
	/**
	 * 根据用户编号,查询用户信息
	 * @param userNo [Integer]用户编号
	 * @return
	 */
	public ResponeResult findUserInfo(Integer userNo);
	/**
	 * 修改用户昵称
	 * @param userNo [Integer]用户编号
	 * @param newNickName [String]新的用户昵称
	 * @param newIntroduction [String]新的用户简介
	 * @return
	 */
	public ResponeResult updateNickName(Integer userNo, String newNickName, String newIntroduction);
	
	/**
	 * 修改用户昵称
	 * @param userNo [Integer]用户编号
	 * @param oldPassword [String]旧密码
	 * @param newPassword [String]新密码
	 * @return
	 */
	public ResponeResult updatePassword(Integer userNo, String oldPassword, String newPassword);

	
}
