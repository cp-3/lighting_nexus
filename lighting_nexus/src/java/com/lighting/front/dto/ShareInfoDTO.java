package com.lighting.front.dto;

import java.io.Serializable;

/**
 * @desc 分享收藏产品信息DTO
 * @author Bill
 * @createtime : 2015年3月22日
 */
public class ShareInfoDTO extends BaseDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
     * 表ID
     */
    private String id;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 收藏产品id串，逗号分隔
     */
    private String collectIds;
    /**
     * 4位分享码
     */
    private String shareCode;
    /**
     * 状态
     * 0--无效，1--有效
     */
    private String state;
    /**
     * 邮箱（用户名）
     */
    private String email;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCollectIds() {
		return collectIds;
	}
	public void setCollectIds(String collectIds) {
		this.collectIds = collectIds;
	}
	public String getShareCode() {
		return shareCode;
	}
	public void setShareCode(String shareCode) {
		this.shareCode = shareCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
