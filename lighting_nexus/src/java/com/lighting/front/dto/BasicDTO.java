package com.lighting.front.dto;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 
 * @description
 * @author GANCHUNGEN512
 * @date 2014-8-13
 */
public class BasicDTO {
	
	// 注入分页VO
	private PageDTO pageDTO = new PageDTO();
	
	public String toString() {
		try {
			return ToStringBuilder.reflectionToString(this,
					ToStringStyle.MULTI_LINE_STYLE);
		} catch (Throwable e) {
			return getClass().getName();
		}
	}

	public PageDTO getPageDTO() {
		return pageDTO;
	}

	public void setPageDTO(PageDTO pageDTO) {
		this.pageDTO = pageDTO;
	}

}
