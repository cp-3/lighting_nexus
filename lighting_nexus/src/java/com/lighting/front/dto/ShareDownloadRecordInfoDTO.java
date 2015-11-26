package com.lighting.front.dto;

import java.io.Serializable;

/**
 * @desc 分享下载记录信息DTO
 * @author Bill
 * @createtime : 2015年3月22日
 */
public class ShareDownloadRecordInfoDTO extends BaseDTO implements Serializable{

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
     * 用户名
     */
    private String userName;
    /**
     * 4位分享码
     */
    private String shareCode;
    
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getShareCode() {
		return shareCode;
	}
	public void setShareCode(String shareCode) {
		this.shareCode = shareCode;
	}
}
