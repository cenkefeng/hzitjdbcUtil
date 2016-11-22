package com.hzit.feng.test;

import java.util.List;

import org.junit.Test;

import com.hzit.feng.dao.ModelInfoDao;
import com.hzit.feng.dao.impl.ModelInfoDaoImpl;
import com.hzit.feng.entity.ModelInfo;



public class TestModelInfo {
	ModelInfo m=new ModelInfo();
	ModelInfoDao mdao=new ModelInfoDaoImpl();
	//增加的测试
	@Test
	public  void add(){
		m.setmName("学员信息修改");
		m.setmUrl("www.xiugai.com");
		m.setmOrder(3);
		m.setmLevel(2);
		m.setmParentId(30001);
		int num=mdao.addModelInfo(m);
		System.out.println("受影响的行"+num);
	}
	//修改
	@Test
	public  void updat(){
		m=mdao.findModelInfoByMid(30006);
		m.setmName("学员信息修改");
		m.setmUrl("www.xiugaidddd.com");
		m.setmOrder(3);
		m.setmLevel(2);
		
		int num=mdao.addModelInfo(m);
		System.out.println("受影响的行"+num);
	}
	//删除
	@Test
	public  void delete(){
		int num=mdao.deleteModelInfoById(30006);
		System.out.println("受影响的行"+num);
	}
	//查询所有模块信息
	@Test
	public  void findAll(){
		List<ModelInfo> list=mdao.findAllModelInfo();
		for( ModelInfo model: list){
			System.out.println(
					"模块id:"+model.getmId()+
					"\t模块名称:"+model.getmName()+
					"\t模块URL:"+model.getmUrl()+
					"\t模块位置:"+model.getmOrder()+
					"\t模块等级:"+model.getmLevel()+
					"\t模块父类id:"+model.getmParentId()
					);
		}
	}
	//根据模块名称模糊查询
	@Test	
	public void findInfobyUserName(){
		@SuppressWarnings("unused")
		ModelInfoDao mdao=new ModelInfoDaoImpl();
		/*List<ModelInfo> list=mdao.findAllModelInfo("信息");
		System.out.println(list.toString());
		for( ModelInfo model: list){
			System.out.println(
					"模块id:"+model.getmId()+
					"\t模块名称:"+model.getmName()+
					"\t模块URL:"+model.getmUrl()+
					"\t模块位置:"+model.getmOrder()+
					"\t模块等级:"+model.getmLevel()+
					"\t模块父类id:"+model.getmParentId()
					);
		}*/
	}
	//通过模块ID 查询信息
	@Test
	public void findInfoByUid(){
		/*List<ModelInfo> list=mdao.findAllModelInfo(30001);
		
		for( ModelInfo model: list){
			System.out.println(
					"模块id:"+model.getmId()+
					"\t模块名称:"+model.getmName()+
					"\t模块URL:"+model.getmUrl()+
					"\t模块位置:"+model.getmOrder()+
					"\t模块等级:"+model.getmLevel()+
					"\t模块父类id:"+model.getmParentId()
					);
		}*/
	}
}
