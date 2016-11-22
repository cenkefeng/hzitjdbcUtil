package com.hzit.feng.dao;

import java.util.List;

import com.hzit.feng.entity.UserInfo;

/**
 * ��������ݿ�ķ��ʵķ���
 * 
 * @author Administrator
 *
 */
public interface UserInfoDao {
	/**
	 * ����
	 */
	public int addUserInfo(UserInfo userInfo);

	/**
	 * �޸�
	 */
	public int updateUserInfo(UserInfo userInfo);

	/**
	 * ɾ��
	 */
	public int deleteUserInfoById(int userId);

	/**
	 * ��ѯ�����û���Ϣ
	 */
	public List<UserInfo> findAllUserInfo();

	/**
	 * ͨ���û��� ģ����ѯ�û���Ϣ
	 */
	public List<UserInfo> findUserInfoByUserName(String userName);

	/**
	 * �����û���ģ����ѯ
	 * @param key
	 * @param value
	 * @return
	 */
	public List<UserInfo> findUserInfoByUserColumnName(String key, String value);

	/**
	 * ͨ���û���ID ��ѯ�û���Ϣ
	 */
	public UserInfo findUserInfoByUserId(int userId);

	/**
	 * ͨ���û�ID��ѯ�û���ϸ��Ϣ�����û���ӵ�еĽ�ɫ��
	 */
	public UserInfo findUserInfoAndRolseById(int userId);

}
