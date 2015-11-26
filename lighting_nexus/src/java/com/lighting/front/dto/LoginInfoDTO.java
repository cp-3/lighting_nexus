package com.lighting.front.dto;

import java.io.Serializable;

/**
 * @登陆信息DTO
 * @author Bill
 * @createtime : 2015年3月8日
 */
public class LoginInfoDTO extends BaseDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4216595863898981059L;
	/**
	 * 邮箱地址
	 */
	private String eMail;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 设备ID
	 */
	private String deviceId;
	/**
	 * token
	 */
	private String token;
	
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
