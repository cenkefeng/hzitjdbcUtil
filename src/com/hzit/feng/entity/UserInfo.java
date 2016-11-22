package com.hzit.feng.entity;

import java.util.List;

public class UserInfo implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userId;
	private String userName;
	private String userPwd;
	private String userStatus;
	private String createTime;
	private List<RolseInfo> rolseInfo;

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + ", userStatus="
				+ userStatus + ", createTime=" + createTime + ", rolseInfo=" + rolseInfo + "]";
	}

	public UserInfo() {

	}

	public List<RolseInfo> getRolseInfo() {
		return rolseInfo;
	}

	public void setRolseInfo(List<RolseInfo> rolseInfo) {
		this.rolseInfo = rolseInfo;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}
