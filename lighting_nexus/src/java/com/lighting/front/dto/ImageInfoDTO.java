package com.lighting.front.dto;

import java.io.Serializable;

/**
 * @desc 图片信息DTO
 * @author Bill
 * @createtime : 2015年3月22日
 */
public class ImageInfoDTO extends BaseDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
     * 品牌ID
     */
    private String id;
    /**
     * 品牌名称
     */
    private byte[] photo;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
}
