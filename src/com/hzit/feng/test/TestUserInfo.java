package com.hzit.feng.test;


import java.util.List;
import org.junit.Test;
import com.hzit.feng.dao.UserInfoDao;
import com.hzit.feng.dao.impl.UserInfoDaoImpl;
import com.hzit.feng.entity.UserInfo;

public class TestUserInfo {
	UserInfo u=new UserInfo();
	UserInfoDao udao=new UserInfoDaoImpl();
	
	//���ӵĲ���
	@Test
	public void add(){
		u.setUserName("����ʦ");
		u.setUserPwd("adminddd");
		u.setUserStatus("����");

		int num=udao.addUserInfo(u);
		System.out.println("��Ӱ��"+num+"��");
	}
	//�޸�
	@Test
	public  void updat(){
		u=udao.findUserInfoByUserId(1980);
		u.setUserName("������");
		u.setUserPwd("adminzhou");
		u.setUserStatus("����");
		
	
		int num=udao.updateUserInfo(u);
		System.out.println("��Ӱ��"+num+"��");
	}
	//ɾ��
	@Test
	public  void delete(){
		int num=udao.deleteUserInfoById(8912);
		System.out.println("��Ӱ��"+num+"��");
	}
	//��ѯ�����û���Ϣ
	@Test
	public  void findAll(){
		List<UserInfo> list=udao.findAllUserInfo();
		for( UserInfo user: list){
			System.out.println(
					"�û�id:"+user.getUserId()+
					"\t�û���:"+user.getUserName()+
					"\t����:"+user.getUserPwd()+
					"\t״̬:"+user.getUserStatus()+
					"\t����ʱ��:"+user.getCreateTime()
					);
		}
	}
	//ͨ���û��� ģ����ѯ�û���Ϣ
	@Test
	public void findInfobyUserName(){
		List<UserInfo> list=udao.findUserInfoByUserName("��");
		for( UserInfo user: list){
			System.out.println(
					"�û�id:"+user.getUserId()+
					"\t�û���:"+user.getUserName()+
					"\t����:"+user.getUserPwd()+
					"\t״̬:"+user.getUserStatus()+
					"\t����ʱ��:"+user.getCreateTime()
					);
		}
	}
	//ͨ���û���ID ��ѯ�û���Ϣ
	@Test
	public void findInfoByUid(){
		UserInfo user=udao.findUserInfoByUserId(1981);
				
					System.out.println(
							"�û�id:"+user.getUserId()+
							"\t�û���:"+user.getUserName()+
							"\t����:"+user.getUserPwd()+
							"\t״̬:"+user.getUserStatus()+
							"\t����ʱ��:"+user.getCreateTime()
							);
				
	}
	
	//ͨ���û�ID��ѯ�û���ϸ��Ϣ�����û���ӵ�еĽ�ɫ��
	@Test
	public void findUandRByUId(){
		/*UserInfo user=udao.findAllUserInfoAndRolseById(10005);
		System.out.println("�û����ǣ�"+user.getUserName());
		List<RolseInfo> rlist=user.getRolseInfo();
		System.out.println("����ӵ�еĽ�ɫ�ǣ�");
		for(RolseInfo r:rlist){
			System.out.println(r.getRolseName());
		}*/
	}
	
}
