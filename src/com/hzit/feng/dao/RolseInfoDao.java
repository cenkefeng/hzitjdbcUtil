package com.hzit.feng.dao;

import java.util.List;
import com.hzit.feng.entity.RolseInfo;

/**
 * 定义对数据库的访问的方法
 * 
 * @author Administrator
 *
 */
public interface RolseInfoDao {
	/**
	 * 增加
	 */
	public int addRolseInfo(RolseInfo rolseInfo);

	/**
	 * 修改
	 */
	public int updateRolseInfo(RolseInfo rolseInfo);

	/**
	 * 删除
	 */
	public int deleteRolseInfoById(int rolseId);

	/**
	 * 查询所有角色信息
	 */
	public List<RolseInfo> findAllRolseInfo();

	/**
	 * 通过用户名 模糊查询角色信息
	 */
	public List<RolseInfo> findRolseInfoByRolseName(String rolseName);

	/**
	 * 根据列名模糊查询
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public List<RolseInfo> findRolseInfoByRolseColumnName(String key, String value);

	/**
	 * 通过角色ID 查询角色信息
	 */
	public RolseInfo findRolseInfoByRolseId(int rolseId);

	/**
	 * 通过角色ID查询用户信息
	 */
	public RolseInfo findByRoleId(int rolseId);

}
