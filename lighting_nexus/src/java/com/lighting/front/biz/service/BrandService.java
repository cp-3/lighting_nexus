package com.lighting.front.biz.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lighting.front.biz.dao.BrandDao;
import com.lighting.front.biz.dao.VersionDao;
import com.lighting.front.dto.BrandInfoDTO;

/**
 * @desc 品牌信息service
 * @author ganchungen
 * @since 2014-09-26
 */
@Service("brandService")
public class BrandService{
	protected Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	private BrandDao brandDao;
	@Autowired
	private VersionDao versionDao;
	
	/**
	 * @desc 获取品牌信息列表
	 * @param null
	 * @return List<BrandInfoDTO>
	 */
	public List<BrandInfoDTO> getAllBrandInfo(){
		logger.info("进入BrandService的getAllBrandInfo方法。。。。。。");
		return brandDao.getAllBrandInfo();
	}
	
	/**
	 * @desc 获取品牌信息
	 * @param brandId 品牌ID
	 * @return BrandInfoDTO
	 */
	public BrandInfoDTO getBrandInfo(String brandId) {
		logger.info("进入BrandService的getBrandInfo方法。。。。。。");
		return brandDao.getBrandInfo(brandId);
	}
	
	/**
	 * @desc 添加品牌信息
	 * @param BrandInfoDTO brandInfo 品牌信息
	 * @return boolean
	 */
	public boolean addBrandInfo(BrandInfoDTO brandInfo) {
		logger.info("进入BrandService的addBrandInfo方法。。。。。。");
		if(brandDao.addBrandInfo(brandInfo))
			return versionDao.updateB_versionInfo();
		return false;
	}
	
	/**
	 * @desc 更新品牌信息
	 * @param BrandInfoDTO brandInfo 品牌信息
	 * @return boolean
	 */
	public boolean updateBrandInfo(BrandInfoDTO brandInfo) {
		logger.info("进入BrandService的updateBrandInfo方法。。。。。。");
		if(brandDao.updateBrandInfo(brandInfo))
			return versionDao.updateB_versionInfo();
		return false;
	}
}