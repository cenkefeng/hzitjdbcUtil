package com.hzit.feng.entity;

import java.util.Arrays;


public class PictureInfo implements java.io.Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int picId;
	private String picName;
	private byte[] picContent;

	public PictureInfo(){}
	// private Blob picContent;
	public int getPicId() {
		return picId;
	}

	public void setPicId(int picId) {
		this.picId = picId;
	}

	public String getPicName() {
		return picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}

	public byte[] getPicContent() {
		return picContent;
	}

	public void setPicContent(byte[] picContent) {
		this.picContent = picContent;
	}

	@Override
	public String toString() {
		return "PictureInfo [picId=" + picId + ", picName=" + picName + ", picContent=" + Arrays.toString(picContent)
				+ "]";
	}

}
