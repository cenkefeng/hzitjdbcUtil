package com.hzit.feng.dao.impl;

import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import com.hzit.feng.dao.UserInfoDao;
import com.hzit.feng.entity.UserInfo;
import com.hzit.feng.util.DBHelp;

public class UserInfoDaoImpl extends DBHelp implements UserInfoDao {
	/**
	 * 增加
	 */
	@Override
	public int addUserInfo(UserInfo userInfo) {
		openOracle();
		try {
			return update(con, "insert into userinfo values(USERID_SEQ.nextval,?,?,?,sysdate)", userInfo.getUserName(),
					userInfo.getUserPwd(), userInfo.getUserStatus());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		} finally {
			close();
		}
	}

	/**
	 * 修改
	 */
	@Override
	public int updateUserInfo(UserInfo userInfo) {
		openOracle();
		try {
			return update(con, "update userinfo set username=?,userpwd=?," + "userstatus=? where userid=?",
					userInfo.getUserName(), userInfo.getUserPwd(), userInfo.getUserStatus(), userInfo.getUserId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		} finally {
			close();
		}
	}

	/**
	 * 删除
	 */
	@Override
	public int deleteUserInfoById(int userId) {
		openOracle();
		try {
			return update(con, "delete from userinfo where userid=?", userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		} finally {
			close();
		}
	}

	/**
	 * 查询所有用户信息
	 */
	@Override
	public List<UserInfo> findAllUserInfo() {
		openOracle();
		List<UserInfo> ulist = null;
		try {
			ulist = query(con, "select * from userinfo order by userid", new BeanListHandler<UserInfo>(UserInfo.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			close();
		}
		return ulist;
	}

	/**
	 * 根据用户名模糊查询
	 */
	@Override
	public List<UserInfo> findUserInfoByUserName(String userName) {
		openOracle();
		List<UserInfo> ulist = null;
		try {
			ulist = query(con, "select * from userinfo where username like ?",
					new BeanListHandler<UserInfo>(UserInfo.class), "%" + userName + "%");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			close();
		}
		return ulist;
	}

	/**
	 * 根据列名模糊查询
	 * 
	 */
	@Override
	public List<UserInfo> findUserInfoByUserColumnName(String key, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 通过用户名ID 查询用户信息
	 */
	@Override
	public UserInfo findUserInfoByUserId(int userId) {
		openOracle();
		UserInfo user = null;
		try {
			user = query(con, "select * from userinfo where userId=?", new BeanHandler<UserInfo>(UserInfo.class),
					userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			close();
		}
		return user;
	}

	/**
	 * 通过用户ID查询用户详细信息（含用户所拥有的角色）
	 */
	@Override
	public UserInfo findUserInfoAndRolseById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
