package com.lighting.front.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @desc 产品信息DTO
 * @author ganchungen
 * @since 2014-10-02
 */
public class ProductInfoDTO extends BaseDTO implements Serializable {

	private static final long serialVersionUID = 2703915949327105353L;
	/**
	 * 产品ID
	 */
	private String productId;
	/**
	 * 产品名称
	 */
	private String productName;
	/**
	 * 型号
	 */
	private String modelType;
	/**
	 * 安装类型
	 * 1--轨道
	 * 2--埋入式
	 * 3--明装
	 * 4--吊装
	 * 5--明装壁灯
	 * 6--埋入式壁灯
	 * 7--地埋
	 * 8--其他
	 */
	private String installType;
	/**
	 * 功能类型
	 * 1--圆形光斑
	 * 2--圆形光斑可调角度
	 * 3--椭圆光斑
	 * 4--洗墙灯
	 * 5--投影灯
	 * 6--掠射光
	 * 7--上出光
	 * 8--下出光
	 * 9--上下出光
	 * 10--侧出光
	 * 11--其他
	 */
	private String functionType;
	/**
	 * 光强
	 */
	private String lightStrength;
	/**
	 * 尺寸
	 */
	private String size;
	/**
	 * 光源类型
	 * 1--LED
	 * 2--卤素灯
	 * 3--金卤灯
	 * 4--紧凑型荧光灯
	 * 5--直管荧光灯
	 * 6--其他
	 */
	private String lightSouType;
	/**
	 * 功率
	 */
	private String power;
	/**
	 * 色温
	 */
	private String colorTemp;
	/**
	 * 显色性
	 */
	private String showColAttr;
	/**
	 * 工程名
	 */
	private String projectName;
	/**
	 * 图片
	 */
	private String imageUrl;
	/**
	 * 品牌名称
	 */
	private String brandName	;
	/**
	 * 品牌ID
	 */
	private String brandId;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 参考价
	 */
	private String refPrice;
	/**
	 * 货期
	 */
	private String deliveryTime;
	/**
	 * 保修期
	 */
	private String warrPeriod;
	/**
	 * 均匀度
	 */
	private String uniformity;
	/**
	 * 截光角
	 */
	private String cutoffAngle;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 创建日期
	 */
	private Date dateCreate;
	/**
	 * 更新日期
	 */
	private Date dateUpdate;
	/**
	 * 收藏日期
	 */
	private String collectDate;
	/**
	 * 外观图片
	 */
	private byte[] appearanceImg;
	/**
	 * 尺寸图片
	 */
	private byte[] sizeImg;
	/**
	 * 配光图片
	 */
	private byte[] gradingImg;
	/**
	 * 备用图片
	 */
	private byte[] backupImg;
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getModelType() {
		return modelType;
	}
	public void setModelType(String modelType) {
		this.modelType = modelType;
	}
	public String getInstallType() {
		return installType;
	}
	public void setInstallType(String installType) {
		this.installType = installType;
	}
	public String getFunctionType() {
		return functionType;
	}
	public void setFunctionType(String functionType) {
		this.functionType = functionType;
	}
	public String getLightStrength() {
		return lightStrength;
	}
	public void setLightStrength(String lightStrength) {
		this.lightStrength = lightStrength;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getLightSouType() {
		return lightSouType;
	}
	public void setLightSouType(String lightSouType) {
		this.lightSouType = lightSouType;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public String getColorTemp() {
		return colorTemp;
	}
	public void setColorTemp(String colorTemp) {
		this.colorTemp = colorTemp;
	}
	public String getShowColAttr() {
		return showColAttr;
	}
	public void setShowColAttr(String showColAttr) {
		this.showColAttr = showColAttr;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getBrandId() {
		return brandId;
	}
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRefPrice() {
		return refPrice;
	}
	public void setRefPrice(String refPrice) {
		this.refPrice = refPrice;
	}
	public String getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public String getWarrPeriod() {
		return warrPeriod;
	}
	public void setWarrPeriod(String warrPeriod) {
		this.warrPeriod = warrPeriod;
	}
	public String getUniformity() {
		return uniformity;
	}
	public void setUniformity(String uniformity) {
		this.uniformity = uniformity;
	}
	public String getCutoffAngle() {
		return cutoffAngle;
	}
	public void setCutoffAngle(String cutoffAngle) {
		this.cutoffAngle = cutoffAngle;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getDateCreate() {
		return dateCreate;
	}
	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}
	public Date getDateUpdate() {
		return dateUpdate;
	}
	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}
	public String getCollectDate() {
		return collectDate;
	}
	public void setCollectDate(String collectDate) {
		this.collectDate = collectDate;
	}
	public byte[] getAppearanceImg() {
		return appearanceImg;
	}
	public void setAppearanceImg(byte[] appearanceImg) {
		this.appearanceImg = appearanceImg;
	}
	public byte[] getSizeImg() {
		return sizeImg;
	}
	public void setSizeImg(byte[] sizeImg) {
		this.sizeImg = sizeImg;
	}
	public byte[] getGradingImg() {
		return gradingImg;
	}
	public void setGradingImg(byte[] gradingImg) {
		this.gradingImg = gradingImg;
	}
	public byte[] getBackupImg() {
		return backupImg;
	}
	public void setBackupImg(byte[] backupImg) {
		this.backupImg = backupImg;
	}
}
