package com.hzit.feng.dao.procedureImpl;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hzit.feng.dao.UserInfoDao;
import com.hzit.feng.entity.UserInfo;
import com.hzit.feng.util.DBHeUti;

import oracle.jdbc.internal.OracleTypes;
/**
 * 使用PL/SQL的存储过程执行增删查改
 * @author Administrator
 *
 */
public class UseinfoDaoProcedureImpl extends DBHeUti implements UserInfoDao {
	CallableStatement cs;
	
	@Override
	public int addUserInfo(UserInfo userInfo) {
		openGx();
		
		return 0;
	}

	

	@Override
	public int updateUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUserInfoById(int userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<UserInfo> findAllUserInfo() {
		openGx();
		@SuppressWarnings("unchecked")
		ArrayList<UserInfo> returnValue=new ArrayList();
		try {
			cs=con.prepareCall("{call userManager.queryfuntion(?)}");
			cs.registerOutParameter(1, OracleTypes.CURSOR);//
			cs.execute();
			rs=(ResultSet) cs.getObject(1);
			while(rs.next()){
				UserInfo u=new UserInfo();
				u.setUserId(rs.getInt(1));
				u.setUserName(rs.getString(2));
				u.setUserPwd(rs.getString(3));
				u.setUserStatus(rs.getString(4));
				u.setCreateTime(rs.getString(5));
				returnValue.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			close();
		}
		return returnValue;
	}

	@Override
	public List<UserInfo> findUserInfoByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInfo> findUserInfoByUserColumnName(String key, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo findUserInfoByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo findUserInfoAndRolseById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
