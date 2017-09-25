package com.jielan.model;

import com.jielan.model.query.PageQuery;

import java.util.Date;

/**
 * <p> 创建时间：2016-7-24 下午11:25:26 </p>
 * <p> 项目名称：hz_CheckIn </p>
 * <p> 包	  名：com.jielan.cmq.model </p>
 * <p> 作	   者：Mcin </p>
 * <p> 类   介   绍：后台添加活动	</p>
 * <p> JDK 版 本：1.7.0_80 </p>
------------------------------------------------------------
 */

public class Activity  {
	private int id;//id
	private String name;
	private String activityurl; //活动地址
	private String imgurl; //图片地址
	private int status; //0下线 1上线
	private Date createTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActivityurl() {
		return activityurl;
	}

	public void setActivityurl(String activityurl) {
		this.activityurl = activityurl;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
