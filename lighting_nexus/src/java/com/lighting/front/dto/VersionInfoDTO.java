package com.lighting.front.dto;

import java.io.Serializable;

/**
 * @desc 品牌信息DTO
 * @author Bill
 * @createtime : 2015年3月22日
 */
public class VersionInfoDTO extends BaseDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
     * 邮箱
     */
    private String email;
    /**
     * 发现版本号
     */
    private int d_version;
    /**
     * 报告版本号
     */
    private int r_version;
    
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getD_version() {
		return d_version;
	}
	public void setD_version(int d_version) {
		this.d_version = d_version;
	}
	public int getR_version() {
		return r_version;
	}
	public void setR_version(int r_version) {
		this.r_version = r_version;
	}
}
