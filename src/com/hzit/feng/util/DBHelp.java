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



public class DBHelp extends QueryRunner {
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
				driverClass=p.getProperty("driverClass");
				url=p.getProperty("url");
				username=p.getProperty("username");
				userpwd=p.getProperty("userpwd");
				bs=new BasicDataSource();
				//�������ӳ�
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
		 * ��oracle���ݿ����ӳ�
		 * DBCP���ӳ�
		 * @return 
		 */
		
		public Connection openOracle() 
		{
			/*//��������
			try {
				Class.forName(driverClass);
				con=DriverManager.getConnection(url,username,userpwd);
				System.out.println("������");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			try {
				con=bs.getConnection();
				System.out.println("������");
				return con;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
			
		}
		
	/*	//��MySQL���ݿ�����
		public void openMySQL() 
		{
			//��������
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://feng/studb","cenkefeng","feng");
				//System.out.println(con+"���ӳɹ�");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
*/
		//�ر����ݿ�����
		public void close(){
			try {
				if(ps!=null) ps.close();
				if(sta!=null) sta.close();
				if(con!=null) con.close();
				System.out.println("�ر�����");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//ִ����ɾ�Ĳ���
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
		
		//���������ɾ��executeSQL
		public int executeSQL(SuperSQL ...superSql) {
			int sum=0;
			try {
				openOracle();
				con.setAutoCommit(false);
				//����SQL���ִ�ж��� 
				for(int i=0;i<superSql.length;i++){//ѭ������sql���
					ps=con.prepareStatement(superSql[i].getSql());
					//��sql��䴫�����Ĳ�����ֵ
					for(int j=0;j<superSql[i].getParamter().length;j++){//ѭ��sql����������еĲ���
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
		/*//��ѯ����sql���
		public void executeSelect(){
			
			try {
				openMySQL();
				con.setAutoCommit(false);
				sta=con.createStatement();
				String sql="select * from grade";
				rs=sta.executeQuery(sql);
				//��ȡ��ѯ������
				 rsm=rs.getMetaData();
				int c_count=rsm.getColumnCount();
				System.out.println("�ܹ���"+c_count+"��");
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
		//�ü��Ϸ�ʽ��ѯ
		public List<Map<String,Object>> findBySQL(String sql,Object... parameter){
			List<Map<String,Object>> data=new ArrayList<>();
			try {
				openOracle();
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
				//��ResultSet�е�����ת�Ƶ�������
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


