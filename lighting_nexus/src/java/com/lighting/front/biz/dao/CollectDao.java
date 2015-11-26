package com.lighting.front.biz.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.lighting.front.dto.CollectProductInfoDTO;
import com.paic.pafa.biz.dao.BaseDAO;

/**
 * @desc 收藏产品DAO
 * @author ganchungen
 * @since 2014-10-08
 */
@Service("collectDao")
public class CollectDao extends BaseDAO {
	protected Log logger = LogFactory.getLog(this.getClass());
	
	/**
	 * @desc 查询用户收藏产品列表 
	 * @param userId
	 * @return List<CollectProductInfoDTO>
	 */
	@SuppressWarnings("unchecked")
	public List<CollectProductInfoDTO> queryCollectList(String userId){
		logger.info("userId==:"+userId);
		List<CollectProductInfoDTO> list =  (List<CollectProductInfoDTO>) this._list("query-collect-list", userId);
		logger.info("list---->"+list);
		return list;
	}
	
	/**
	 * @desc 查询收藏ID 
	 * @param userId
	 * @return List<CollectProductInfoDTO>
	 */
	public String queryCollectById(String collectId){
		logger.info("collectId==:"+collectId);
		String _collectId =  (String) this._queryForObject("query-collect-by-collectId", collectId);
		logger.info("collectId---->"+_collectId);
		return _collectId;
	}
	
	/**
	 * @desc 新增产品信息 
	 * @param ProductInfoDTO
	 * @return boolean
	 */
	public boolean addCollectProduct(CollectProductInfoDTO dto){
		HashMap<String,Object> condition = new HashMap<String,Object>();
		condition.put("collectId", dto.getCollectId());
		condition.put("productId", dto.getProductId());
		condition.put("userId", dto.getUserId());
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
		HashMap<String, Object> retMap = this._insert("collect-product-info", condition);
		logger.info("retMap---->"+retMap);
		return true;
	}
	
	/**
	 * @desc 更新产品信息 
	 * @param ProductInfoDTO
	 * @return boolean
	 */
	public boolean editCollectProduct(CollectProductInfoDTO dto){
		HashMap<String,Object> condition = new HashMap<String,Object>();
		condition.put("collectId", dto.getCollectId());
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
		HashMap<String, Object> retMap = this._insert("edit-collect-product-info", condition);
		logger.info("retMap---->"+retMap);
		return true;
	}
	
	/**
	 * @desc 收藏产品信息 
	 * @param CollectProductInfoDTO
	 * @return boolean
	 */
	public boolean collectProduct(CollectProductInfoDTO dto){
		HashMap<String,Object> condition = new HashMap<String,Object>();
		condition.put("collectId", dto.getCollectId());
		condition.put("userId", dto.getUserId());
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
		HashMap<String, Object> retMap = this._insert("collect-product-info", condition);
		logger.info("retMap---->"+retMap);
		return true;
	}
	
	/**
	 * @desc 收藏产品信息 
	 * @param collectId
	 * @return boolean
	 */
	public boolean cancelCollect(String collectId){
		int code = this._delete("cancel-collect-product-info", collectId);
		logger.info("code---->"+code);
		return true;
	}
	
	/**
	 * @desc 查询产品信息 
	 * @param productId
	 * @return CollectProductInfoDTO
	 */
	public CollectProductInfoDTO queryProductInfo(String productId){
		logger.info("productId==:"+productId);
		CollectProductInfoDTO productInfo =  (CollectProductInfoDTO) this._queryForObject("query-product-info", productId);
		logger.info("productInfo---->"+productInfo);
		return productInfo;
	}
	
	/**
	 * @desc 查询收藏产品信息 
	 * @param collectId
	 * @return CollectProductInfoDTO
	 */
	public CollectProductInfoDTO queryCollectInfo(String collectId){
		logger.info("collectId==:"+collectId);
		CollectProductInfoDTO productInfo =  (CollectProductInfoDTO) this._queryForObject("query-collect-info", collectId);
		logger.info("productInfo---->"+productInfo);
		return productInfo;
	}
}
