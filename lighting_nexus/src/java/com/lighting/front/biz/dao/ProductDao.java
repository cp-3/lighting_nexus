package com.lighting.front.biz.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.lighting.front.biz.util.IdUtils;
import com.lighting.front.dto.ProductInfoDTO;
import com.lighting.front.dto.VisitInfoDTO;
import com.paic.pafa.biz.dao.BaseDAO;

/**
 * @desc 产品DAO
 * @author ganchungen
 * @since 2014-10-08
 */
@Service("productDao")
public class ProductDao extends BaseDAO {
	protected Log logger = LogFactory.getLog(this.getClass());
	
	/**
	 * @desc 新增产品信息 
	 * @param ProductInfoDTO
	 * @return boolean
	 */
	public boolean addProduct(ProductInfoDTO dto){
//		HashMap<String,Object> condition = new HashMap<String,Object>();
//		condition.put("productId", dto.getProductId());
//		condition.put("productName", dto.getProductName());
//		condition.put("modelType", dto.getModelType());
//		condition.put("installType", dto.getInstallType());
//		condition.put("functionType", dto.getFunctionType());
//		condition.put("lightStrength", dto.getLightStrength());
//		condition.put("lightSouType", dto.getLightSouType());
//		condition.put("size", dto.getSize());
//		condition.put("refPrice", dto.getRefPrice());
//		condition.put("brandName", dto.getBrandName());
//		condition.put("brandId", dto.getBrandId());
//		condition.put("power", dto.getPower());
//		condition.put("colorTemp", dto.getColorTemp());
//		condition.put("showColAttr", dto.getShowColAttr());
//		condition.put("projectName", dto.getProjectName());
//		condition.put("address", dto.getAddress());
//		condition.put("deliveryTime", dto.getDeliveryTime());
//		condition.put("warrPeriod", dto.getWarrPeriod());
//		condition.put("uniformity", dto.getUniformity());
//		condition.put("cutoffAngle", dto.getCutoffAngle());
//		condition.put("remark", dto.getRemark());
//		condition.put("appearanceImg", dto.getAppearanceImg());
//		condition.put("backupImg", dto.getBackupImg());
//		condition.put("sizeImg", dto.getSizeImg());
//		condition.put("gradingImg", dto.getGradingImg());
//		logger.info("condition==:"+condition);
		this._insert("add-product-info", dto);
//		logger.info("retMap---->"+retMap);
		return true;
	}
	
	/**
	 * @desc 更新产品信息 
	 * @param ProductInfoDTO
	 * @return boolean
	 */
	public boolean editProduct(ProductInfoDTO dto){
		HashMap<String,Object> condition = new HashMap<String,Object>();
		condition.put("productId", dto.getProductId());
		condition.put("productName", dto.getProductName());
		condition.put("modelType", dto.getModelType());
		condition.put("installType", dto.getInstallType());
		condition.put("functionType", dto.getFunctionType());
		condition.put("lightStrength", dto.getLightStrength());
		condition.put("lightSouType", dto.getLightSouType());
		condition.put("size", dto.getSize());
		condition.put("refPrice", dto.getRefPrice());
		condition.put("brandName", dto.getBrandName());
		condition.put("brandId", dto.getBrandId());
		condition.put("power", dto.getPower());
		condition.put("colorTemp", dto.getColorTemp());
		condition.put("showColAttr", dto.getShowColAttr());
		condition.put("projectName", dto.getProjectName());
		condition.put("address", dto.getAddress());
		condition.put("deliveryTime", dto.getDeliveryTime());
		condition.put("warrPeriod", dto.getWarrPeriod());
		condition.put("uniformity", dto.getUniformity());
		condition.put("cutoffAngle", dto.getCutoffAngle());
		condition.put("remark", dto.getRemark());
		logger.info("condition==:"+condition);
		HashMap<String, Object> retMap = this._insert("edit-product-info", condition);
		logger.info("retMap---->"+retMap);
		return true;
	}
	
	/**
	 * @desc 查询所有产品列表 
	 * @param userId
	 * @return List<ProductInfoDTO>
	 */
	@SuppressWarnings("unchecked")
	public List<ProductInfoDTO> getAllProduct(){
		List<ProductInfoDTO> list =  (List<ProductInfoDTO>) this._list("get-all-product", "");
		logger.info("list---->"+list);
		return list;
	}
	
	/**
	 * @desc 记录访问信息 
	 * @param VisitInfoDTO
	 * @return boolean
	 */
	public boolean recordAccess(VisitInfoDTO webDto){
		HashMap<String,Object> condition = new HashMap<String,Object>();
		condition.put("id", System.currentTimeMillis()+IdUtils.getUUID());
		condition.put("productId", webDto.getProductId());
		condition.put("userId", webDto.getUserId());
		logger.info("condition==:"+condition);
		HashMap<String, Object> retMap = this._insert("record-access-info", condition);
		logger.info("retMap---->"+retMap);
		return true;
	}
}
