package com.lighting.front.dto;

import java.io.Serializable;

public class PageDTO implements Serializable {

	/**
	 * 默认序列化ID
	 */
	private static final long serialVersionUID = 1L;

	// 每页默认显示条数 (10条)
	private final static int DEFAULT_SIZE_PER_PAGE = 10;
	// 默认为第一页
	private final static int DEFAULT_CURRENT_PAGE = 0;

	// 每页显示条数
	private int sizePerPage;
	// 当前页
	private int currentPage;
	// 记录的总条数
	private long totalCount;
	// 除了TopXX条	 
	private long excludeCount;

	public PageDTO() {
		this.currentPage = DEFAULT_CURRENT_PAGE;
		this.sizePerPage = DEFAULT_SIZE_PER_PAGE;
	}

	public PageDTO(int currentPage) {
		this();
		this.currentPage = currentPage;
	}

	public PageDTO(int currentPage, int sizePerPage) {
		this.currentPage = currentPage;
		this.sizePerPage = sizePerPage;
	}

	public PageDTO(int currentPage, int sizePerPage, long totalCount) {
		this.currentPage = currentPage;
		this.sizePerPage = sizePerPage;
		this.totalCount = totalCount;
	}

	public int getSizePerPage() {
		return sizePerPage;
	}

	public void setSizePerPage(int sizePerPage) {
		this.sizePerPage = sizePerPage;
	}

	public int getCurrentPage() {
		if (currentPage <=0) {
			return 0;
		}
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public long getExcludeCount() {
		return excludeCount;
	}

	public void setExcludeCount(long excludeCount) {
		this.excludeCount = excludeCount;
	}

	/**
	 * 覆盖Object基类的toString方法
	 */
	@Override
	public String toString() {
		return "{sizePerPage: " + sizePerPage + ",totalCount: " + totalCount
				+ ",currentPage: " + currentPage + ", excludeCount: "
				+ excludeCount + "}";
	}
}
