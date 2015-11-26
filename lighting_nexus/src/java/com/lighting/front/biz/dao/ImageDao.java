package com.lighting.front.biz.dao;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.lighting.front.dto.CollectProductInfoDTO;
import com.lighting.front.dto.HeadImageDTO;
import com.paic.pafa.biz.dao.BaseDAO;

/**
 * @desc 图片DAO
 * @author ganchungen
 * @since 2014-10-08
 */
@Service("imageDao")
public class ImageDao extends BaseDAO {
	protected Log logger = LogFactory.getLog(this.getClass());
	
	public void testUploadImage(String id,String imageStr){
		logger.info("进入ImageDao的testUploadImage()方法...........");
		HashMap<String,String> condition = new HashMap<String,String>();
		condition.put("id", id);
		condition.put("photo", imageStr);
		this._insert("test-upload-image", condition);
	}
	
	public String testGetImage(String id){
		logger.info("进入ImageDao的testUploadImage()方法...........");
		logger.info("id==="+ id);
		return this._getString("get-image-test", id);
	}

	/**
	 * @保存头像图片信息
	 * @param image
	 */
	public void saveHeadImage(HeadImageDTO image){
		logger.info("进入ImageDao的saveHeadImage()方法...........");
		logger.info("image----:"+image);
		this._insert("save-head-image-info", image);
	}
	
	/**
	 * @获取头像信息
	 * @param userId
	 * @return HeadImageDTO
	 */
	public HeadImageDTO getHeadImage(String userId){
		logger.info("进入ImageDao的getHeadImage()方法...........");
		logger.info("userId----:"+userId);
		HeadImageDTO dto = (HeadImageDTO) this._getObject("get-head-image-info", userId);
		logger.info("HeadImageDTO:"+dto);
		return dto;
	}
	
	/**
	 * @获取产品图片信息
	 * @param productId
	 * @param imageType
	 * @return CollectProductInfoDTO
	 */
	public CollectProductInfoDTO getProductImage(String productId){
		logger.info("进入ImageDao的getProductImage()方法...........");
		HashMap<String,String> condition = new HashMap<String,String>();
		condition.put("productId", productId);
		logger.info("condition----:"+condition);
		CollectProductInfoDTO dto = (CollectProductInfoDTO) this._getObject("get-product-image-info", condition);
		logger.info("CollectProductInfoDTO1:"+dto);
		return dto;
	}
	
	/**
	 * @获取收藏产品图片信息
	 * @param collectId
	 * @param imageType
	 * @return CollectProductInfoDTO
	 */
	public CollectProductInfoDTO getCollectProductImage(String collectId){
		logger.info("进入ImageDao的getCollectProductImage()方法...........");
		HashMap<String,String> condition = new HashMap<String,String>();
		condition.put("collectId", collectId);
		logger.info("condition----:"+condition);
		CollectProductInfoDTO dto = (CollectProductInfoDTO) this._getObject("get-collect-product-image-info", condition);
		logger.info("CollectProductInfoDTO2:"+dto);
		return dto;
	}
	
	/**
	 * @desc 上传产品图片信息 
	 * @param HashMap<String, Object> paramMap
	 * @return boolean
	 */
	public boolean uploadCollectProductImageInfo(HashMap<String, Object> paramMap){
		logger.info("进入ImageDao的uploadCollectProductImageInfo()方法...........");
//		String imageType = paramMap.get("imageType").toString();
//		logger.info("imageType==:"+imageType);
		CollectProductInfoDTO dto = new CollectProductInfoDTO();
		dto.setCollectId((String)paramMap.get("collectId"));
		logger.info("dto===================="+dto);
		int code = -1;
//		if("1".equals(imageType)){
//			dto.setAppearanceImg((byte[])paramMap.get("appearanceImgFile"));
//			code = this._update("upload-appearance-image-info", dto);
//		}else if("2".equals(imageType)){
//			dto.setSizeImg((byte[])paramMap.get("sizeImgFile"));
//			code = this._update("upload-size-image-info", dto);
//		}else if("3".equals(imageType)){
//			dto.setGradingImg((byte[])paramMap.get("gradingImgFile"));
//			code = this._update("upload-grading-image-info", dto);
//		}else if("4".equals(imageType)){
//			dto.setBackupImg((byte[])paramMap.get("backupImgFile"));
//			code = this._update("upload-backup-image-info", dto);
//		}else{
			dto.setAppearanceImg((byte[])paramMap.get("appearanceImgFile"));
			dto.setSizeImg((byte[])paramMap.get("sizeImgFile"));
			dto.setGradingImg((byte[])paramMap.get("gradingImgFile"));
			dto.setBackupImg((byte[])paramMap.get("backupImgFile"));
			code = this._update("upload-all-image-info", dto);
//		}
		logger.info("code---->"+code);
		return true;
	}
}
