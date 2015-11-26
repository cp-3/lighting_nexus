package com.lighting.front.dto;

import java.io.Serializable;

/**
 * @desc 用户注册信息DTO
 * @author ganchungen
 * @since 2014-10-02
 */
public class UserInfoDTO extends BaseDTO implements Serializable {

	private static final long serialVersionUID = 2703915949327105353L;
	/**
	 * 用户ID
	 */
	private String userId;
	/**
	 * email
	 */
	private String email;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 用户类型
	 * P--个人客户，B--企业客户
	 */
	private String userType;
	/**
	 * 用户状态
	 * 0--未激活  1--已激活
	 */
	private String status;
	/**
	 * 性别
	 * M--男，F--女
	 */
	private String sex;
	/**
	 * 职业
	 */
	private String profession;
	/**
	 * 地区
	 */
	private String area;
	/**
	 * 关注的特点
	 */
	private String concern;
	/**
	 * 设备号
	 */
	private String deviceId;
	/**
	 * token
	 */
	private String token;
	/**
	 * 头像信息URL
	 */
	private String iconUrl;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getConcern() {
		return concern;
	}
	public void setConcern(String concern) {
		this.concern = concern;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getIconUrl() {
		return iconUrl;
	}
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}
}
