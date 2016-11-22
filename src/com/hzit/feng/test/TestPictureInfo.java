package com.hzit.feng.test;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import org.junit.Test;

import com.hzit.feng.dao.PictureInfoDao;
import com.hzit.feng.dao.impl.PictureInfoDaoImpl;
import com.hzit.feng.entity.PictureInfo;



public class TestPictureInfo {
	//���ͼƬ��Ϣ
	@Test
	public void add() throws Exception{
		//��ȡD���ϵ�һ��ͼƬ�ļ���Ȼ��浽���ݿ���
		@SuppressWarnings("resource")
		FileInputStream fs=new FileInputStream("D:/shamo.jpg");
		PictureInfo pic=new PictureInfo();
		pic.setPicName("ɳĮ");
		//���ļ���ת����byte����
		byte bt[]=new byte[fs.available()];
		fs.read(bt);
		pic.setPicContent(bt);
		PictureInfoDao picDao=new PictureInfoDaoImpl();
		int num=picDao.addPictureInfo(pic);
		System.out.println("������ݳɹ�"+num);
	}
	//ͨ��picID��ѯͼƬ��Ϣ
	@Test
	public void selectById() throws Exception{
		PictureInfoDao picDao=new PictureInfoDaoImpl();
		PictureInfo pic=picDao.findInfoByPid(2);
		byte[] content=pic.getPicContent();
		for(byte b:content){
			System.out.println(b);
		}
		FileOutputStream fos=new FileOutputStream("D:/"+pic.getPicName());
		fos.write(content);
		fos.close();
	}
	
}
