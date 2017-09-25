package z_tknight.oa.model.vo;

import z_tknight.oa.model.entity.TUser;

/**
 * 用户详细信息
 * 
 * @author 随心
 *
 */
public class UserDetail {

	/**
	 * 用户编号
	 */
	private Integer userNo = null;

	/**
	 * 昵称
	 */
	private String nickName = null;
	
	/**
	 * 介绍
	 */
	private String introduction = null;

	public UserDetail() {}
	
	public UserDetail(TUser user) {
		this.userNo = user.getUserNo();
		this.nickName = user.getNickName();
		this.introduction = user.getIntroduction();
	}
	
	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Integer getUserNo() {
		return userNo;
	}

	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
}
