package com.hzit.feng.dao;

import java.util.List;
import com.hzit.feng.entity.ModelInfo;

public interface ModelInfoDao {
	/**
	 * ����
	 */
	public int addModelInfo(ModelInfo modelInfo);

	/**
	 * �޸�
	 */
	public int updateModelInfo(ModelInfo modelInfo);

	/**
	 * ɾ��
	 */
	public int deleteModelInfoById(int mId);

	/**
	 * ��ѯ������Ϣ
	 */
	public List<ModelInfo> findAllModelInfo();

	/**
	 * ͨ��ģ���� ģ����ѯ��Ϣ
	 */
	public List<ModelInfo> findModelInfoByModelName(String mName);

	/**
	 * ͨ��ģ��ID��ѯ�û���Ϣ
	 */
	public ModelInfo findModelInfoByMid(int mId);

	/**
	 * ͨ��ģ���� ģ����ѯ��Ϣ
	 */
	public List<ModelInfo> findModelInfoByRolseColumnName(String key, String value);
}
