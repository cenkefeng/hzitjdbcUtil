package com.hzit.feng.test;

import java.util.List;

import org.junit.Test;

import com.hzit.feng.dao.ModelInfoDao;
import com.hzit.feng.dao.impl.ModelInfoDaoImpl;
import com.hzit.feng.entity.ModelInfo;



public class TestModelInfo {
	ModelInfo m=new ModelInfo();
	ModelInfoDao mdao=new ModelInfoDaoImpl();
	//���ӵĲ���
	@Test
	public  void add(){
		m.setmName("ѧԱ��Ϣ�޸�");
		m.setmUrl("www.xiugai.com");
		m.setmOrder(3);
		m.setmLevel(2);
		m.setmParentId(30001);
		int num=mdao.addModelInfo(m);
		System.out.println("��Ӱ�����"+num);
	}
	//�޸�
	@Test
	public  void updat(){
		m=mdao.findModelInfoByMid(30006);
		m.setmName("ѧԱ��Ϣ�޸�");
		m.setmUrl("www.xiugaidddd.com");
		m.setmOrder(3);
		m.setmLevel(2);
		
		int num=mdao.addModelInfo(m);
		System.out.println("��Ӱ�����"+num);
	}
	//ɾ��
	@Test
	public  void delete(){
		int num=mdao.deleteModelInfoById(30006);
		System.out.println("��Ӱ�����"+num);
	}
	//��ѯ����ģ����Ϣ
	@Test
	public  void findAll(){
		List<ModelInfo> list=mdao.findAllModelInfo();
		for( ModelInfo model: list){
			System.out.println(
					"ģ��id:"+model.getmId()+
					"\tģ������:"+model.getmName()+
					"\tģ��URL:"+model.getmUrl()+
					"\tģ��λ��:"+model.getmOrder()+
					"\tģ��ȼ�:"+model.getmLevel()+
					"\tģ�鸸��id:"+model.getmParentId()
					);
		}
	}
	//����ģ������ģ����ѯ
	@Test	
	public void findInfobyUserName(){
		@SuppressWarnings("unused")
		ModelInfoDao mdao=new ModelInfoDaoImpl();
		/*List<ModelInfo> list=mdao.findAllModelInfo("��Ϣ");
		System.out.println(list.toString());
		for( ModelInfo model: list){
			System.out.println(
					"ģ��id:"+model.getmId()+
					"\tģ������:"+model.getmName()+
					"\tģ��URL:"+model.getmUrl()+
					"\tģ��λ��:"+model.getmOrder()+
					"\tģ��ȼ�:"+model.getmLevel()+
					"\tģ�鸸��id:"+model.getmParentId()
					);
		}*/
	}
	//ͨ��ģ��ID ��ѯ��Ϣ
	@Test
	public void findInfoByUid(){
		/*List<ModelInfo> list=mdao.findAllModelInfo(30001);
		
		for( ModelInfo model: list){
			System.out.println(
					"ģ��id:"+model.getmId()+
					"\tģ������:"+model.getmName()+
					"\tģ��URL:"+model.getmUrl()+
					"\tģ��λ��:"+model.getmOrder()+
					"\tģ��ȼ�:"+model.getmLevel()+
					"\tģ�鸸��id:"+model.getmParentId()
					);
		}*/
	}
}
