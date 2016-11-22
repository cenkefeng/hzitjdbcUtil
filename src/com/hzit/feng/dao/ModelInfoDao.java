package com.hzit.feng.dao;

import java.util.List;
import com.hzit.feng.entity.ModelInfo;

public interface ModelInfoDao {
	/**
	 * 增加
	 */
	public int addModelInfo(ModelInfo modelInfo);

	/**
	 * 修改
	 */
	public int updateModelInfo(ModelInfo modelInfo);

	/**
	 * 删除
	 */
	public int deleteModelInfoById(int mId);

	/**
	 * 查询所有信息
	 */
	public List<ModelInfo> findAllModelInfo();

	/**
	 * 通过模块名 模糊查询信息
	 */
	public List<ModelInfo> findModelInfoByModelName(String mName);

	/**
	 * 通过模块ID查询用户信息
	 */
	public ModelInfo findModelInfoByMid(int mId);

	/**
	 * 通过模块名 模糊查询信息
	 */
	public List<ModelInfo> findModelInfoByRolseColumnName(String key, String value);
}
