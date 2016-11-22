package com.hzit.feng.dao.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import com.hzit.feng.dao.PictureInfoDao;
import com.hzit.feng.entity.PictureInfo;
import com.hzit.feng.util.DBHelp;

public class PictureInfoDaoImpl extends DBHelp implements PictureInfoDao {

	@Override
	public int addPictureInfo(PictureInfo pictureInfo) {
		openOracle();
		InputStream input=null;
		try {
			con.setAutoCommit(false);
			ps=con.prepareStatement("intsert into pictureinfo values(PICID_SEQ,?,?)");
			ps.setString(1, pictureInfo.getPicName());
			//创建输入流
			input=new ByteArrayInputStream(pictureInfo.getPicContent());
			ps.setBinaryStream(2, input,input.available());
			rs=ps.executeQuery();
			con.commit();
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
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

	@Override
	public PictureInfo findInfoByPid(int picId) {
		openOracle();
		InputStream input=null;
		try {
			con.setAutoCommit(false);
			ps=con.prepareStatement("select * from pictureinfo where picid=?");
			ps.setInt(1, picId);
			rs=ps.executeQuery();
			if(rs.next()){
				PictureInfo p=new PictureInfo();
				p.setPicId(rs.getInt(1));
				p.setPicName(rs.getString(2));
				Blob b=rs.getBlob(3);
				input=b.getBinaryStream();
				byte [] bt=new byte[(int) b.length()];
				input.read(bt);
				p.setPicContent(bt);
				return p;
			}
			con.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			close();
		}
		return null;
		
	}

	@Override
	public int deletePictureInfo(int picId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
