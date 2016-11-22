package com.hzit.feng.test;

import java.sql.Connection;

import org.junit.Test;

import com.hzit.feng.util.DBHelp;




public class TestLianJie {
	@Test
	public void DBlianjie(){
		DBHelp d=new DBHelp();
		for(int i=0;i<100;i++){
			Connection con= d.openOracle();
			System.out.println(i+":"+con);
		}
		
		
	}
}
