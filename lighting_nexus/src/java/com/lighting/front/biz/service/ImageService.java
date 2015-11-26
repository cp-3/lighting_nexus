package com.lighting.front.biz.service;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lighting.front.biz.dao.ImageDao;
import com.lighting.front.biz.dao.VersionDao;
import com.lighting.front.dto.CollectProductInfoDTO;
import com.lighting.front.dto.HeadImageDTO;

/**
 * @desc 图片service
 * @author ganchungen
 * @since 2014-09-26
 */
@Service("imageService")
public class ImageService{
	protected Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	private ImageDao imageDao;
	@Autowired
	private VersionDao versionDao;
	
	public void testUploadImage(String id,String imageStr){
		imageDao.testUploadImage(id, imageStr);
	}
	
	public String testGetImage(String id){
		return imageDao.testGetImage(id);
	}

	
	/**
	 * @desc 保存图片信息
	 * @param InputStream
	 * @return boolean
	 */
	public boolean saveHeadImage(HeadImageDTO headImage) {
		logger.info("进入ImageService的saveHeadImage()方法........");
		imageDao.saveHeadImage(headImage);
		return true;
	}
	
	/**
	 * @获取头像信息
	 * @param userId
	 * @return HeadImageDTO
	 */
	public HeadImageDTO getHeadImage(String userId){
		return imageDao.getHeadImage(userId);
	}
	
	/**
	 * @获取产品图片信息
	 * @param productId
	 * @param imageType
	 * @return ProductInfoDTO
	 */
	public CollectProductInfoDTO getProductImage(String productId){
		return imageDao.getProductImage(productId);
	}
	
	/**
	 * @获取产品图片信息
	 * @param productId
	 * @param imageType
	 * @return ProductInfoDTO
	 */
	public CollectProductInfoDTO getCollectProductImage(String collectId){
		return imageDao.getCollectProductImage(collectId);
	}
	
	/**
	 * @desc 上传收藏产品图片信息 
	 * @param HashMap<String, Object> paramMap
	 * @param imageType
	 * @return boolean
	 */
	public boolean uploadCollectProductImageInfo(HashMap<String, Object> paramMap) {
		logger.info("进入ProductService的uploadCollectProductImageInfo()方法........");
		return imageDao.uploadCollectProductImageInfo(paramMap);
	}
}