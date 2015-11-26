package com.lighting.front.biz.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lighting.front.dto.BrandInfoDTO;
import com.paic.pafa.biz.dao.BaseDAO;

/**
 * @desc 品牌DAO
 * @author ganchungen
 * @since 2014-09-26
 */
@Service("brandDao")
public class BrandDao extends BaseDAO{

	/**
	 * @desc 获取品牌信息列表
	 * @param null
	 * @return List<BrandInfoDTO>
	 */
	@SuppressWarnings("unchecked")
	public List<BrandInfoDTO> getAllBrandInfo(){
		logger.info("进入BrandDao的getAllBrandInfo()方法...........");
		List<BrandInfoDTO> brandInfoList =  (List<BrandInfoDTO>) this._list("get-all-brand-info", "");
		logger.info("brandInfoList==="+brandInfoList);
		return brandInfoList;
	}
	
	/**
	 * @desc 获取品牌信息
	 * @param String brandId
	 * @return BrandInfoDTO
	 */
	public BrandInfoDTO getBrandInfo(String brandId){
		logger.info("进入BrandDao的getBrandInfo()方法...........");
		logger.info("brandId==:"+brandId);
		BrandInfoDTO brandInfo =  (BrandInfoDTO) this._queryForObject("get-brand-info", brandId);
		logger.info("BrandInfoDTO==="+brandInfo);
		return brandInfo;
	}
	
	/**
	 * @desc新增品牌信息
	 * @param BrandInfoDTO brandInfo
	 * @return boolean
	 */
	public boolean addBrandInfo(BrandInfoDTO brandInfo){
		logger.info("进入BrandDao的addBrandInfo()方法...........");
//		HashMap<String,Object> condition = new HashMap<String,Object>();
		logger.info("BrandInfoDTO==:"+brandInfo);
		BrandInfoDTO brandInfo2 = this._insert("add-brand-info", brandInfo);
		logger.info("BrandInfoDTO2---->"+brandInfo2);
		return true;
	}
	
	/**
	 * @desc 更新品牌信息 
	 * @param BrandInfoDTO brandInfo
	 * @return boolean
	 */
	public boolean updateBrandInfo(BrandInfoDTO brandInfo){
		logger.info("进入BrandDao的updateBrandInfo()方法...........");
		logger.info("BrandInfoDTO==:"+brandInfo);
		int code = this._update("update-brand-info", brandInfo);
		logger.info("code---->" + code);
		return true;
	}
}
