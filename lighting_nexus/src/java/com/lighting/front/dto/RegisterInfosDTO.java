package com.lighting.front.dto;

import java.io.Serializable;

/**
 * @desc 用户注册信息DTO
 * @author ganchungen
 * @since 2014-10-02
 */
public class RegisterInfosDTO extends LoginInfoDTO implements Serializable {

	private static final long serialVersionUID = 2703915949327105353L;
	/**
	 * 用户ID
	 */
	private String userId;
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
	 * 设备号
	 */
	private String deviceId;
	/**
	 * token
	 */
	private String token;
	
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
}
