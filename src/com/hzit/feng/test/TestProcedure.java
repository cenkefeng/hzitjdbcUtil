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
					"�û�id:"+user.getUserId()+
					"\t�û���:"+user.getUserName()+
					"\t����:"+user.getUserPwd()+
					"\t״̬:"+user.getUserStatus()+
					"\t����ʱ��:"+user.getCreateTime()
					);
		}
	}
}
