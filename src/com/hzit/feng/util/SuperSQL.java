package com.hzit.feng.util;

public class SuperSQL {
	private String sql;
	private Object[] paramter;
	
	//¹¹ÔìÆ÷
	public SuperSQL(String sql,Object... paramter){
		this.sql=sql;
		this.paramter=paramter;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public Object[] getParamter() {
		return paramter;
	}

	public void setPramerte(Object[] paramter) {
		this.paramter = paramter;
	}
	
}
