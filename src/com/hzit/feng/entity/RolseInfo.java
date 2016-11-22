package com.hzit.feng.entity;

import java.util.List;

public class RolseInfo implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int rolseId;
	private String rolseName;
	private String rolseDes;
	private List<UserInfo> userInfo;

	@Override
	public String toString() {
		return "RolseInfo [rolseId=" + rolseId + ", rolseName=" + rolseName + ", rolseDes=" + rolseDes + ", userInfo="
				+ userInfo + "]";
	}

	public RolseInfo() {

	}

	public List<UserInfo> getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(List<UserInfo> userInfo) {
		this.userInfo = userInfo;
	}

	public int getRolseId() {
		return rolseId;
	}

	public void setRolseId(int rolseId) {
		this.rolseId = rolseId;
	}

	public String getRolseName() {
		return rolseName;
	}

	public void setRolseName(String rolseName) {
		this.rolseName = rolseName;
	}

	public String getRolseDes() {
		return rolseDes;
	}

	public void setRolseDes(String rolseDes) {
		this.rolseDes = rolseDes;
	}

}
