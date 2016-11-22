package com.hzit.feng.test;

import java.sql.Connection;

import org.junit.Test;

import com.hzit.feng.util.DBHeUti;

public class TestGx {

	@Test
	public void con(){
		DBHeUti d=new DBHeUti();
		@SuppressWarnings("unused")
		Connection con=d.openGx();
	}
	@Test
	public void findAll(){
		
	}
}
