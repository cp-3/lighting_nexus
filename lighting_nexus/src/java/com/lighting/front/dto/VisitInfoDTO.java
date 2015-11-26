package com.lighting.front.dto;

import java.io.Serializable;

/**
 * @desc 产品收藏信息DTO
 * @author ganchungen
 * @since 2014-10-02
 */
public class VisitInfoDTO extends BaseDTO implements Serializable {

	private static final long serialVersionUID = 2703915949327105353L;
	/**
	 * 产品ID
	 */
	private String productId;
	/**
	 * 用户ID
	 */
	private String userId;
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
