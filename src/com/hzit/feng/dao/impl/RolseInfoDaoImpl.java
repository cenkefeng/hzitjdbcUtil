package com.hzit.feng.dao.impl;

import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import com.hzit.feng.dao.RolseInfoDao;
import com.hzit.feng.entity.RolseInfo;
import com.hzit.feng.util.DBHelp;

public class RolseInfoDaoImpl extends DBHelp implements RolseInfoDao {
	/**
	 * 增加
	 */
	@Override
	public int addRolseInfo(RolseInfo rolseInfo) {
		openOracle();
		try {
			return update(con, "insert into rolseinfo values(ROLSEID_SEQ.nextval,?,?)", rolseInfo.getRolseName(),
					rolseInfo.getRolseDes());
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
	public int updateRolseInfo(RolseInfo rolseInfo) {
		openOracle();
		try {
			return update(con, "update rolseinfo set rolsename=?,rolsedes=? where rolseid=?", rolseInfo.getRolseName(),
					rolseInfo.getRolseDes(), rolseInfo.getRolseId());
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
	public int deleteRolseInfoById(int rolseId) {
		openOracle();
		try {
			return update(con, "delete from rolseinfo where rolseid = ?", rolseId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		} finally {
			close();
		}

	}

	/**
	 * 查询所有角色信息
	 */
	@Override
	public List<RolseInfo> findAllRolseInfo() {
		openOracle();
		List<RolseInfo> rlist = null;
		try {
			rlist = query(con, "select * from rolseinfo order by rolseid",
					new BeanListHandler<RolseInfo>(RolseInfo.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			close();
		}
		return rlist;
	}

	/**
	 * 通过角色ID 查询角色信息
	 */
	@Override
	public RolseInfo findByRoleId(int rolseId) {
		openOracle();
		RolseInfo rolse = null;
		try {
			rolse = query(con, "select * from rolseinfo where rolseid=?", new BeanHandler<RolseInfo>(RolseInfo.class),
					rolseId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			close();
		}
		return rolse;
	}

	/**
	 * 通过角色名模糊查询用户信息
	 */
	@Override
	public List<RolseInfo> findRolseInfoByRolseName(String rolseName) {
		openOracle();
		List<RolseInfo> rlist = null;
		try {
			rlist = query(con, "select * from rolseinfo where rolsename like ?",
					new BeanListHandler<RolseInfo>(RolseInfo.class), "%" + rolseName + "%");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			close();
		}
		return rlist;
	}

	/**
	 * 根据列名模糊查询
	 */
	@Override
	public List<RolseInfo> findRolseInfoByRolseColumnName(String key, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 通过角色ID 查询角色信息
	 */
	@Override
	public RolseInfo findRolseInfoByRolseId(int rolseId) {
		openOracle();
		RolseInfo rolse = null;
		try {
			rolse = query(con, "select * from RolseInfo where userId=?", new BeanHandler<RolseInfo>(RolseInfo.class),
					rolseId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			close();
		}
		return rolse;
	}

}
