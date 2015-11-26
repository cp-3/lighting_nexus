package com.lighting.front.dto;

import java.io.Serializable;

/**
 * @desc 头像信息DTO
 * @author Bill
 * @createtime : 2015年3月22日
 */
public class HeadImageDTO extends BaseDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
     * 用户ID
     */
    private String userId;
    /**
     * 品牌名称
     */
    private byte[] headImage;
    
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public byte[] getHeadImage() {
		return headImage;
	}
	public void setHeadImage(byte[] headImage) {
		this.headImage = headImage;
	}
}
