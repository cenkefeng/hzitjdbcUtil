package com.hzit.feng.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;

public class DBHeUti extends QueryRunner{
	private static String driverClass;
	private static String url;
	private static String username;
	private static String userpwd;
	private static BasicDataSource bs;
	
	protected Connection con=null;
	protected Statement sta=null;
	protected ResultSet rs=null;
	protected ResultSetMetaData rsm=null;
	protected PreparedStatement ps=null;

		static{
			Properties p=new Properties();
			try{
				p.load(String.class.getResourceAsStream("/jdbc.properties"));
				driverClass=p.getProperty("driverClassgx");
				url=p.getProperty("urlgx");
				username=p.getProperty("usernamegx");
				userpwd=p.getProperty("userpwdgx");
				bs=new BasicDataSource();
				//数据连接池
				bs.setDriverClassName(driverClass);
				bs.setUrl(url);
				bs.setUsername(username);
				bs.setPassword(userpwd);
				bs.setMaxActive(50);
				bs.setMaxIdle(5);
				bs.setMaxWait(2000);
			
				
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			
		}
		/**
		 * 打开oracle数据库连接池
		 * DBCP连接池
		 * @return 
		 */
		
		public Connection openGx() 
		{
			/*//加载驱动
			try {
				Class.forName(driverClass);
				con=DriverManager.getConnection(url,username,userpwd);
				System.out.println("打开连接");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			try {
				con=bs.getConnection();
				System.out.println("打开连接");
				return con;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
			
		}
		
		
	/*	//打开MySQL数据库连接
		public void openMySQL() 
		{
			//加载驱动
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://feng/studb","cenkefeng","feng");
				//System.out.println(con+"连接成功");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
*/
		//关闭数据库连接
		public void close(){
			try {
				if(ps!=null) ps.close();
				if(sta!=null) sta.close();
				if(con!=null) con.close();
				System.out.println("关闭连接");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//执行增删改操作
		/*public int executeSQL(String... sql) {
			int sum=0;
			try {
				openMySQL();
				con.setAutoCommit(false);
				sta=con.createStatement();
				for(int i=0;sql!=null&&i<sql.length;i++){
					sum+=sta.executeUpdate(sql[i]);
				}
				con.commit();
				return sum;
			} catch (Exception e) {
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}
				return -1;
			}finally{
				close();
			}

		}*/
		
		//升级版的增删改executeSQL
		public int executeSQL(SuperSQL ...superSql) {
			int sum=0;
			try {
				openGx();
				con.setAutoCommit(false);
				//创建SQL语句执行对象 
				for(int i=0;i<superSql.length;i++){//循环多条sql语句
					ps=con.prepareStatement(superSql[i].getSql());
					//给sql语句传过来的参数赋值
					for(int j=0;j<superSql[i].getParamter().length;j++){//循环sql语句中所带有的参数
						ps.setObject(j+1, superSql[i].getParamter()[j]);
					}
					sum+=ps.executeUpdate();
				}
				con.commit();
				return sum;
			} catch (Exception e) {
				
				e.printStackTrace();
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}
				return -1;
			}finally{
				close();
			}

		}
		/*//查询单条sql语句
		public void executeSelect(){
			
			try {
				openMySQL();
				con.setAutoCommit(false);
				sta=con.createStatement();
				String sql="select * from grade";
				rs=sta.executeQuery(sql);
				//获取查询到的列
				 rsm=rs.getMetaData();
				int c_count=rsm.getColumnCount();
				System.out.println("总共有"+c_count+"列");
				for(int i=1;i<=c_count;i++){
					System.out.println(rsm.getColumnName(i)+"\t");
				}
				while(rs.next()){
					String id=rs.getString(1);
					String name=rs.getString(2);
					System.out.println(id+"\t"+name);
					
				}
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			
		}
		*/
		//用集合方式查询
		public List<Map<String,Object>> findBySQL(String sql,Object... parameter){
			List<Map<String,Object>> data=new ArrayList<>();
			try {
				openGx();
				//sta=con.createStatement();
				ps=con.prepareStatement(sql);
				//rs=sta.executeQuery(sql);
				for(int i=0;i<parameter.length;i++){
					ps.setObject(i+1, parameter[i]);
				}
				System.out.println(sql);
				rs=ps.executeQuery();
				rsm=ps.getMetaData();
				int c_count=rsm.getColumnCount();
				//将ResultSet中的数据转移到集合中
				while(rs.next()){
					Map<String,Object> row=new HashMap<String, Object>();
					for(int i=1;i<=c_count;i++){
						row.put(rsm.getColumnName(i), rs.getObject(i));
					}
					data.add(row);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}finally{
				close();
			}
			return data;
		}
		
}
