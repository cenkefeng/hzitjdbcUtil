package com.hzit.feng.dao;

import com.hzit.feng.entity.PictureInfo;

public interface PictureInfoDao {
	// 添加图片信息
	public int addPictureInfo(PictureInfo pictureInfo);

	// 通过picID查询图片信息
	public PictureInfo findInfoByPid(int picId);

	// 通过picID删除图片信息
	public int deletePictureInfo(int picId);
}
