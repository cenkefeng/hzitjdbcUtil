package com.hzit.feng.dao;

import com.hzit.feng.entity.PictureInfo;

public interface PictureInfoDao {
	// ���ͼƬ��Ϣ
	public int addPictureInfo(PictureInfo pictureInfo);

	// ͨ��picID��ѯͼƬ��Ϣ
	public PictureInfo findInfoByPid(int picId);

	// ͨ��picIDɾ��ͼƬ��Ϣ
	public int deletePictureInfo(int picId);
}
