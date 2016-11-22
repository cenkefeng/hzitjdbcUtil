package com.hzit.feng.test;


import java.util.List;
import org.junit.Test;
import com.hzit.feng.dao.UserInfoDao;
import com.hzit.feng.dao.impl.UserInfoDaoImpl;
import com.hzit.feng.entity.UserInfo;

public class TestUserInfo {
	UserInfo u=new UserInfo();
	UserInfoDao udao=new UserInfoDaoImpl();
	
	//增加的测试
	@Test
	public void add(){
		u.setUserName("仓老师");
		u.setUserPwd("adminddd");
		u.setUserStatus("启用");

		int num=udao.addUserInfo(u);
		System.out.println("受影响"+num+"行");
	}
	//修改
	@Test
	public  void updat(){
		u=udao.findUserInfoByUserId(1980);
		u.setUserName("周星星");
		u.setUserPwd("adminzhou");
		u.setUserStatus("禁用");
		
	
		int num=udao.updateUserInfo(u);
		System.out.println("受影响"+num+"行");
	}
	//删除
	@Test
	public  void delete(){
		int num=udao.deleteUserInfoById(8912);
		System.out.println("受影响"+num+"行");
	}
	//查询所有用户信息
	@Test
	public  void findAll(){
		List<UserInfo> list=udao.findAllUserInfo();
		for( UserInfo user: list){
			System.out.println(
					"用户id:"+user.getUserId()+
					"\t用户名:"+user.getUserName()+
					"\t密码:"+user.getUserPwd()+
					"\t状态:"+user.getUserStatus()+
					"\t创建时间:"+user.getCreateTime()
					);
		}
	}
	//通过用户名 模糊查询用户信息
	@Test
	public void findInfobyUserName(){
		List<UserInfo> list=udao.findUserInfoByUserName("星");
		for( UserInfo user: list){
			System.out.println(
					"用户id:"+user.getUserId()+
					"\t用户名:"+user.getUserName()+
					"\t密码:"+user.getUserPwd()+
					"\t状态:"+user.getUserStatus()+
					"\t创建时间:"+user.getCreateTime()
					);
		}
	}
	//通过用户名ID 查询用户信息
	@Test
	public void findInfoByUid(){
		UserInfo user=udao.findUserInfoByUserId(1981);
				
					System.out.println(
							"用户id:"+user.getUserId()+
							"\t用户名:"+user.getUserName()+
							"\t密码:"+user.getUserPwd()+
							"\t状态:"+user.getUserStatus()+
							"\t创建时间:"+user.getCreateTime()
							);
				
	}
	
	//通过用户ID查询用户详细信息（含用户所拥有的角色）
	@Test
	public void findUandRByUId(){
		/*UserInfo user=udao.findAllUserInfoAndRolseById(10005);
		System.out.println("用户名是："+user.getUserName());
		List<RolseInfo> rlist=user.getRolseInfo();
		System.out.println("其所拥有的角色是：");
		for(RolseInfo r:rlist){
			System.out.println(r.getRolseName());
		}*/
	}
	
}
