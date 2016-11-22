package com.hzit.feng.dao;

import java.util.List;
import com.hzit.feng.entity.RolseInfo;

/**
 * ��������ݿ�ķ��ʵķ���
 * 
 * @author Administrator
 *
 */
public interface RolseInfoDao {
	/**
	 * ����
	 */
	public int addRolseInfo(RolseInfo rolseInfo);

	/**
	 * �޸�
	 */
	public int updateRolseInfo(RolseInfo rolseInfo);

	/**
	 * ɾ��
	 */
	public int deleteRolseInfoById(int rolseId);

	/**
	 * ��ѯ���н�ɫ��Ϣ
	 */
	public List<RolseInfo> findAllRolseInfo();

	/**
	 * ͨ���û��� ģ����ѯ��ɫ��Ϣ
	 */
	public List<RolseInfo> findRolseInfoByRolseName(String rolseName);

	/**
	 * ��������ģ����ѯ
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public List<RolseInfo> findRolseInfoByRolseColumnName(String key, String value);

	/**
	 * ͨ����ɫID ��ѯ��ɫ��Ϣ
	 */
	public RolseInfo findRolseInfoByRolseId(int rolseId);

	/**
	 * ͨ����ɫID��ѯ�û���Ϣ
	 */
	public RolseInfo findByRoleId(int rolseId);

}
