package com.hzit.feng.test;

import java.util.List;

import org.junit.Test;

import com.hzit.feng.dao.RolseInfoDao;
import com.hzit.feng.dao.impl.RolseInfoDaoImpl;
import com.hzit.feng.entity.RolseInfo;


public class TestRolseInfo {
	RolseInfo r = new RolseInfo();
	RolseInfoDao rdao = new RolseInfoDaoImpl();

	// ���ӵĲ���
	@Test
	public void add() {
		r.setRolseName("���BOSS");
		r.setRolseDes("&&&&&&&&&&");
		int num = rdao.addRolseInfo(r);
		System.out.println("Ӱ�����" + num);
	}

	// �޸�
	@Test
	public void update() {
		r = rdao.findRolseInfoByRolseId(8906);
		r.setRolseName("");
		r.setRolseDes("��ɾ�Ĳ�");
		int num = rdao.updateRolseInfo(r);
		System.out.println("Ӱ�����" + num);
	}

	// ɾ��
	@Test
	public void delete() {
		int num = rdao.deleteRolseInfoById(8905);
		System.out.println("Ӱ�����" + num);
	}

	// ��ѯ�����ý�ɫ��Ϣ
	@Test
	public void findAll() {
		List<RolseInfo> list = rdao.findAllRolseInfo();
		for (RolseInfo rolse : list) {
			System.out.println(
					"��ɫID��" + rolse.getRolseId() + "\t��ɫ���ƣ�" + rolse.getRolseName() + "\t��ɫ������" + rolse.getRolseDes());
		}
	}

	// ͨ����ɫ�� ģ����ѯ
	@Test
	public void findInfobyRolseName() {

		List<RolseInfo> list = rdao.findRolseInfoByRolseName("ʦ");
		for (RolseInfo rolse : list) {
			System.out.println(
					"��ɫID��" + rolse.getRolseId() + "\t��ɫ���ƣ�" + rolse.getRolseName() + "\t��ɫ������" + rolse.getRolseDes());
		}

	}

	// ͨ����ɫ��ID ��ѯ
	@Test
	public void findInfoByRid() {

		RolseInfo rolse = rdao.findByRoleId(20002);
		System.out.println(
				"��ɫID��" + rolse.getRolseId() + "\t��ɫ���ƣ�" + rolse.getRolseName() + "\t��ɫ������" + rolse.getRolseDes());

	}

	// ͨ����ɫID��ѯ�û���Ϣ
	@Test
	public void findUserinfoByRid() {
		/*RolseInfo rolse = rdao.findByRoleId(20001);
		System.out.println("��ɫ�����ǣ�" + rolse.getRolseName());
		List<UserInfo> ulist = rolse.getUserInfo();
		System.out.println("�˽�ɫ�����µ��û���Ϣ�У�");
		for (UserInfo user : ulist) {
			System.out.println("�û�����" + user.getUserName() + "\t���룺" + user.getUserPwd() + "\t״̬��"
					+ user.getUserStatus() + "\t����ʱ�䣺" + user.getCreateTime());
		}*/
	}
}
