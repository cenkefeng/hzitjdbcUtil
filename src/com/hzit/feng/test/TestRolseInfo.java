package com.hzit.feng.test;

import java.util.List;

import org.junit.Test;

import com.hzit.feng.dao.RolseInfoDao;
import com.hzit.feng.dao.impl.RolseInfoDaoImpl;
import com.hzit.feng.entity.RolseInfo;


public class TestRolseInfo {
	RolseInfo r = new RolseInfo();
	RolseInfoDao rdao = new RolseInfoDaoImpl();

	// 增加的测试
	@Test
	public void add() {
		r.setRolseName("大大BOSS");
		r.setRolseDes("&&&&&&&&&&");
		int num = rdao.addRolseInfo(r);
		System.out.println("影响的行" + num);
	}

	// 修改
	@Test
	public void update() {
		r = rdao.findRolseInfoByRolseId(8906);
		r.setRolseName("");
		r.setRolseDes("增删改查");
		int num = rdao.updateRolseInfo(r);
		System.out.println("影响的行" + num);
	}

	// 删除
	@Test
	public void delete() {
		int num = rdao.deleteRolseInfoById(8905);
		System.out.println("影响的行" + num);
	}

	// 查询所有用角色信息
	@Test
	public void findAll() {
		List<RolseInfo> list = rdao.findAllRolseInfo();
		for (RolseInfo rolse : list) {
			System.out.println(
					"角色ID：" + rolse.getRolseId() + "\t角色名称：" + rolse.getRolseName() + "\t角色描述：" + rolse.getRolseDes());
		}
	}

	// 通过角色名 模糊查询
	@Test
	public void findInfobyRolseName() {

		List<RolseInfo> list = rdao.findRolseInfoByRolseName("师");
		for (RolseInfo rolse : list) {
			System.out.println(
					"角色ID：" + rolse.getRolseId() + "\t角色名称：" + rolse.getRolseName() + "\t角色描述：" + rolse.getRolseDes());
		}

	}

	// 通过角色名ID 查询
	@Test
	public void findInfoByRid() {

		RolseInfo rolse = rdao.findByRoleId(20002);
		System.out.println(
				"角色ID：" + rolse.getRolseId() + "\t角色名称：" + rolse.getRolseName() + "\t角色描述：" + rolse.getRolseDes());

	}

	// 通过角色ID查询用户信息
	@Test
	public void findUserinfoByRid() {
		/*RolseInfo rolse = rdao.findByRoleId(20001);
		System.out.println("角色名称是：" + rolse.getRolseName());
		List<UserInfo> ulist = rolse.getUserInfo();
		System.out.println("此角色名称下的用户信息有：");
		for (UserInfo user : ulist) {
			System.out.println("用户名：" + user.getUserName() + "\t密码：" + user.getUserPwd() + "\t状态："
					+ user.getUserStatus() + "\t创建时间：" + user.getCreateTime());
		}*/
	}
}
