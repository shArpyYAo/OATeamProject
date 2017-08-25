package z_tknight.oa.model.entity;


public class TUser {

	/**
	 * 用户编号
	 */
	private Integer userNo = null;

	/**
	 * 用户名
	 */
	private String userName = null;

	/**
	 * 密码
	 */
	private String password = null;

	/**
	 * 昵称
	 */
	private String nickName = null;

	/**
	 * 介绍
	 */
	private String introduction = null;

	/**
	 * 备用字段
	 */
	private Integer backUp = null;

	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}

	public Integer getUserNo() {
		return this.userNo;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getIntroduction() {
		return this.introduction;
	}

	public void setBackUp(Integer backUp) {
		this.backUp = backUp;
	}

	public Integer getBackUp() {
		return this.backUp;
	}

}