package com.lighting.front.biz.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lighting.front.biz.dao.CollectDao;
import com.lighting.front.biz.dao.VersionDao;
import com.lighting.front.dto.CollectProductInfoDTO;
import com.lighting.front.util.DateUtils;

/**
 * @desc 会员注册service
 * @author ganchungen
 * @since 2014-09-26
 */
@Service("collectService")
public class CollectService{
	protected Log logger = LogFactory.getLog(this.getClass());
	@Autowired
	private UserService userService;
	@Autowired
	private CollectDao collectDao;
	@Autowired
	private VersionDao versionDao;
	
	/**
	 * @desc 查询用户收藏产品列表 
	 * @param userId
	 * @return List<CollectProductInfoDTO>
	 */
	public List<CollectProductInfoDTO> queryCollectList(String userId) {
		logger.info("进入CollectService的queryCollectList()方法........");
		List<CollectProductInfoDTO> retList = new ArrayList<CollectProductInfoDTO>();
		List<CollectProductInfoDTO> list = collectDao.queryCollectList(userId);
		if(null!=list){
			for(int i=0;i<list.size();i++){
				CollectProductInfoDTO dto = list.get(i);
				dto.setCollectDate(DateUtils.getStringDate(dto.getDateUpdate(), "yyyy-MM"));
				retList.add(dto);
			}
		}
		logger.info("retList====="+retList);
		return retList;
	}
	
	/**
	 * @desc 查询用户收藏产品列表 
	 * @param userId
	 * @return List<CollectProductInfoDTO>
	 */
	public boolean isCollected(String collectId) {
		logger.info("进入CollectService的isCollected()方法........");
		String _collectId = collectDao.queryCollectById(collectId);
		if(StringUtils.isEmpty(_collectId))
			return false;
		return true;
	}
	
	/**
	 * @desc 收藏产品牌信息 
	 * @param userId ， productId
	 * @return boolean
	 */
	public boolean collect(String userId, String productId, String email) {
		logger.info("进入CollectService的collect()方法........");
		CollectProductInfoDTO collectInfo = collectDao.queryProductInfo(productId);
		collectInfo.setUserId(userId);
		collectInfo.setCollectId(userId+productId);
		if(collectDao.collectProduct(collectInfo))
			return versionDao.updateR_versionInfo(email);
		return false;
	}
	
	/**
	 * @desc 添加收藏产品牌信息 
	 * @param CollectProductInfoDTO dto
	 * @return boolean
	 */
	public boolean addCollectProductInfo(CollectProductInfoDTO collectInfo) {
		logger.info("进入addCollectProductInfo的collect()方法........");
		return collectDao.collectProduct(collectInfo);
	}
	
	/**
	 * @desc 取消收藏产品牌信息 
	 * @param collectId
	 * @return boolean
	 */
	public boolean cancelCollect(String collectId) {
		logger.info("进入CollectService的cancelCollect()方法........");
		return collectDao.cancelCollect(collectId);
	}
	
	/**
	 * @desc 新增收藏产品信息 
	 * @param CollectProductInfoDTO
	 * @return boolean
	 */
	public boolean addCollectProduct(CollectProductInfoDTO dto) {
		logger.info("进入CollectService的addCollectProduct()方法........");
		if(collectDao.addCollectProduct(dto)){
			String email =  userService.queryEmail(dto.getUserId());
			return versionDao.updateR_versionInfo(email);
		}
		return false;
	}
	
	/**
	 * @desc 编辑收藏产品信息 
	 * @param CollectProductInfoDTO
	 * @return boolean
	 */
	public boolean editCollectProduct(CollectProductInfoDTO dto) {
		logger.info("进入CollectService的editProduct()方法........");
		if(collectDao.editCollectProduct(dto)){
			String email =  userService.queryEmail(dto.getUserId());
			return versionDao.updateR_versionInfo(email);
		}
		return false;
	}
}