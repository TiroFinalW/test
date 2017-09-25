package com.jielan.model;

import java.util.Date;

/**
 * 用户表
 * ------------------------------------------------------------
 */

public class User {
	private int id;
	private String openid;// 获取用的openId
	private String phone;// 用户的手机号码
	private String wx_image;// 微信头像
	private String wx_name;//微信名称
	private Date createDate;// 用户进入的时间
	private Integer sigin_count;//最长签到次数
	private Date siginDate;//签到的时间
	private double peach;//用户的桃子
	private int retroactiveCard;//用户补签卡
	private Date signoffDate;//断签时间
	private double nextpeach; //下次签到桃子数

	public Date getSiginDate() {
		return siginDate;
	}
	public void setSiginDate(Date siginDate) {
		this.siginDate = siginDate;
	}
	public User() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getSigin_count() {
		return sigin_count;
	}

	public void setSigin_count(Integer sigin_count) {
		this.sigin_count = sigin_count;
	}

	public String getOpenid() {
		return openid;
	}

	public String getWx_name() {
		return wx_name;
	}

	public void setWx_name(String wx_name) {
		this.wx_name = wx_name;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWx_image() {
		return wx_image;
	}

	public void setWx_image(String wx_image) {
		this.wx_image = wx_image;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public double getPeach() {
		return peach;
	}

	public void setPeach(double peach) {
		this.peach = peach;
	}

	public int getRetroactiveCard() {
		return retroactiveCard;
	}

	public void setRetroactiveCard(int retroactiveCard) {
		this.retroactiveCard = retroactiveCard;
	}

	public Date getSignoffDate() {
		return signoffDate;
	}

	public void setSignoffDate(Date signoffDate) {
		this.signoffDate = signoffDate;
	}

	public double getNextpeach() {
		return nextpeach;
	}

	public void setNextpeach(double nextpeach) {
		this.nextpeach = nextpeach;
	}
}
