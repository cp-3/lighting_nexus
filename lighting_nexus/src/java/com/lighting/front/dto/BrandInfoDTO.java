package com.lighting.front.dto;

import java.io.Serializable;

/**
 * @desc 品牌信息DTO
 * @author Bill
 * @createtime : 2015年3月22日
 */
public class BrandInfoDTO extends BaseDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
     * 品牌ID
     */
    private String brandId;
    /**
     * 品牌名称
     */
    private String brandName;
    /**
     * 品牌所属地
     */
    private String belongAddr;
    /**
     * 品牌地址
     */
    private String address;
    /**
     * 品牌全称
     */
    private String brandAllName;
    /**
     * 联系电话
     */
    private String telephone;
    /**
     * 传真
     */
    private String fax;
    /**
     * 联系人
     */
    private String linkMan;
    /**
     * 邮箱（电邮）
     */
    private String email;
    /**
     * 网址
     */
    private String webSite;
    /**
     * 微信号
     */
    private String weChat;
    /**
     * 质保期
     */
    private String warrPeriod;
    /**
     * 介绍
     */
    private String description;

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getBelongAddr() {
		return belongAddr;
	}

	public void setBelongAddr(String belongAddr) {
		this.belongAddr = belongAddr;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBrandAllName() {
		return brandAllName;
	}

	public void setBrandAllName(String brandAllName) {
		this.brandAllName = brandAllName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getLinkMan() {
		return linkMan;
	}

	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getWeChat() {
		return weChat;
	}

	public void setWeChat(String weChat) {
		this.weChat = weChat;
	}

	public String getWarrPeriod() {
		return warrPeriod;
	}

	public void setWarrPeriod(String warrPeriod) {
		this.warrPeriod = warrPeriod;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
