package com.hzit.feng.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import com.hzit.feng.dao.ModelInfoDao;
import com.hzit.feng.entity.ModelInfo;

import com.hzit.feng.util.DBHelp;

public class ModelInfoDaoImpl extends DBHelp implements ModelInfoDao {
	/**
	 * 增加
	 */
	@Override
	public int addModelInfo(ModelInfo modelInfo) {
		openOracle();
		try {
			return update(con, "insert into modelinfo values(MID_SEQ.nextval,?,?,?,?,?)", modelInfo.getmName(),
					modelInfo.getmUrl(), modelInfo.getmOrder(), modelInfo.getmLevel(), modelInfo.getmParentId());
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
	public int updateModelInfo(ModelInfo modelInfo) {
		openOracle();
		try {
			return update(con, "update modelinfo set mname=?,murl=?,morder=?,mlevel=?,mparentid=? where mid=?",
					modelInfo.getmName(), modelInfo.getmUrl(), modelInfo.getmOrder(), modelInfo.getmLevel(),
					modelInfo.getmParentId(), modelInfo.getmId());
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
	public int deleteModelInfoById(int mId) {
		openOracle();
		try {
			return update(con, "delete from modelinfo where mid=?", mId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		} finally {
			close();
		}
	}

	/**
	 * 查询所有模块信息
	 */
	@Override
	public List<ModelInfo> findAllModelInfo() {
		openOracle();
		List<ModelInfo> mlist = null;
		try {
			mlist = query(con, "select * from ModelInfo order by mid", new BeanListHandler<ModelInfo>(ModelInfo.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			close();
		}
		return mlist;

	}

	/**
	 * 通过模块名 模糊查询
	 */
	@Override
	public List<ModelInfo> findModelInfoByModelName(String mName) {
		openOracle();
		List<ModelInfo> mlist = null;
		try {
			mlist = query(con, "select * from ModelInfo where rolsename like ?",
					new BeanListHandler<ModelInfo>(ModelInfo.class), "%" + mName + "%");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			close();
		}
		return mlist;
	}

	/**
	 * 通过模块ID 查询信息
	 */
	@Override
	public ModelInfo findModelInfoByMid(int mId) {
		ModelInfo model = null;
		try {
			model = query(con, "select * from ModelInfo where userId=?", new BeanHandler<ModelInfo>(ModelInfo.class),
					mId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			close();
		}
		return model;
	}

	@Override
	public List<ModelInfo> findModelInfoByRolseColumnName(String key, String value) {
		// TODO Auto-generated method stub
		return null;
	}

}
