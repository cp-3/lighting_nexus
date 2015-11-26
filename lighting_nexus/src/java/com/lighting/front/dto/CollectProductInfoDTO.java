package com.lighting.front.dto;

import java.io.Serializable;

/**
 * @desc 产品收藏信息DTO
 * @author ganchungen
 * @since 2014-10-02
 */
public class CollectProductInfoDTO extends ProductInfoDTO implements Serializable {

	private static final long serialVersionUID = 2703915949327105353L;
	/**
	 * 收藏ID
	 */
	private String collectId;
	/**
	 * 用户ID
	 */
	private String userId;
	
	public String getCollectId() {
		return collectId;
	}
	public void setCollectId(String collectId) {
		this.collectId = collectId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
