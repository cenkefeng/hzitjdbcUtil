package com.hzit.feng.dao;

import java.util.List;

import com.hzit.feng.entity.UserInfo;

/**
 * 定义对数据库的访问的方法
 * 
 * @author Administrator
 *
 */
public interface UserInfoDao {
	/**
	 * 增加
	 */
	public int addUserInfo(UserInfo userInfo);

	/**
	 * 修改
	 */
	public int updateUserInfo(UserInfo userInfo);

	/**
	 * 删除
	 */
	public int deleteUserInfoById(int userId);

	/**
	 * 查询所有用户信息
	 */
	public List<UserInfo> findAllUserInfo();

	/**
	 * 通过用户名 模糊查询用户信息
	 */
	public List<UserInfo> findUserInfoByUserName(String userName);

	/**
	 * 根据用户名模糊查询
	 * @param key
	 * @param value
	 * @return
	 */
	public List<UserInfo> findUserInfoByUserColumnName(String key, String value);

	/**
	 * 通过用户名ID 查询用户信息
	 */
	public UserInfo findUserInfoByUserId(int userId);

	/**
	 * 通过用户ID查询用户详细信息（含用户所拥有的角色）
	 */
	public UserInfo findUserInfoAndRolseById(int userId);

}
