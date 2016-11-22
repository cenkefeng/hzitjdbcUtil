package com.hzit.feng.test;

import java.util.List;

import org.junit.Test;

import com.hzit.feng.dao.UserInfoDao;
import com.hzit.feng.dao.procedureImpl.UseinfoDaoProcedureImpl;
import com.hzit.feng.entity.UserInfo;

public class TestProcedure {
	UserInfoDao udaop=new UseinfoDaoProcedureImpl();
	@Test
	public void pro(){
		List<UserInfo> list=udaop.findAllUserInfo();
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
}
