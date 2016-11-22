package com.hzit.feng.entity;

public class ModelInfo implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int mId;
	private String mName;
	private String mUrl;
	private int mOrder;
	private int mLevel;
	private int mParentId;

	@Override
	public String toString() {
		return "ModelInfo [mId=" + mId + ", mName=" + mName + ", mUrl=" + mUrl + ", mOrder=" + mOrder + ", mLevel="
				+ mLevel + ", mParentId=" + mParentId + "]";
	}

	public ModelInfo() {

	}

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmUrl() {
		return mUrl;
	}

	public void setmUrl(String mUrl) {
		this.mUrl = mUrl;
	}

	public int getmOrder() {
		return mOrder;
	}

	public void setmOrder(int mOrder) {
		this.mOrder = mOrder;
	}

	public int getmLevel() {
		return mLevel;
	}

	public void setmLevel(int mLevel) {
		this.mLevel = mLevel;
	}

	public int getmParentId() {
		return mParentId;
	}

	public void setmParentId(int mParentId) {
		this.mParentId = mParentId;
	}
}
