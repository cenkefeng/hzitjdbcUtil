package com.hzit.feng.test;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import org.junit.Test;

import com.hzit.feng.dao.PictureInfoDao;
import com.hzit.feng.dao.impl.PictureInfoDaoImpl;
import com.hzit.feng.entity.PictureInfo;



public class TestPictureInfo {
	//添加图片信息
	@Test
	public void add() throws Exception{
		//读取D盘上的一个图片文件，然后存到数据库中
		@SuppressWarnings("resource")
		FileInputStream fs=new FileInputStream("D:/shamo.jpg");
		PictureInfo pic=new PictureInfo();
		pic.setPicName("沙漠");
		//将文件流转换成byte数组
		byte bt[]=new byte[fs.available()];
		fs.read(bt);
		pic.setPicContent(bt);
		PictureInfoDao picDao=new PictureInfoDaoImpl();
		int num=picDao.addPictureInfo(pic);
		System.out.println("添加数据成功"+num);
	}
	//通过picID查询图片信息
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
