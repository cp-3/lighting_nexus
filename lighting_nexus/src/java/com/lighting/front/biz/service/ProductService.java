package com.lighting.front.biz.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lighting.front.biz.dao.CollectDao;
import com.lighting.front.biz.dao.ProductDao;
import com.lighting.front.biz.dao.VersionDao;
import com.lighting.front.dto.CollectProductInfoDTO;
import com.lighting.front.dto.ProductInfoDTO;
import com.lighting.front.dto.VisitInfoDTO;
import com.lighting.front.util.DateUtils;

/**
 * @desc 会员注册service
 * @author ganchungen
 * @since 2014-09-26
 */
@Service("productService")
public class ProductService{
	protected Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	private ProductDao productDao;
	@Autowired
	private VersionDao versionDao;
	@Autowired
	private CollectDao collectDao;
	
	/**
	 * @desc 新增产品信息 
	 * @param ProductInfoDTO
	 * @return boolean
	 */
	public boolean addProduct(ProductInfoDTO dto) {
		logger.info("进入ProductService的addProductInfo()方法........");
		if(productDao.addProduct(dto))
			return versionDao.updateD_versionInfo();
		return false;
	}
	
	/**
	 * @desc 新增产品信息 
	 * @param ProductInfoDTO
	 * @return boolean
	 */
	public boolean editProduct(ProductInfoDTO dto) {
		logger.info("进入ProductService的editProduct()方法........");
		if(productDao.editProduct(dto))
			return versionDao.updateD_versionInfo();
		return false;
	}
	
	/**
	 * @desc 查询用户收藏产品列表 
	 * @param userId
	 * @return List<ProductInfoDTO>
	 */
	public List<ProductInfoDTO> getAllProduct() {
		logger.info("进入ProductService的getAllProduct()方法........");
		List<ProductInfoDTO> retList = new ArrayList<ProductInfoDTO>();
		List<ProductInfoDTO> list = productDao.getAllProduct();
		if(null!=list){
			for(int i=0;i<list.size();i++){
				ProductInfoDTO dto = list.get(i);
				dto.setCollectDate(DateUtils.getStringDate(dto.getDateUpdate(), "yyyy-MM"));
				retList.add(dto);
			}
		}
		logger.info("retList====="+retList);
		return retList;
	}
	
	/**
	 * @desc 查询产品信息 
	 * @param String productId
	 * @return CollectProductInfoDTO
	 */
	public CollectProductInfoDTO queryProductInfo(String productId) {
		logger.info("进入ProductService的queryProductInfo()方法........");
		return collectDao.queryProductInfo(productId);
	}
	
	/**
	 * @desc 查询用户收藏产品列表 
	 * @param VisitInfoDTO webDto
	 * @return boolean
	 */
	public boolean recordAccess(VisitInfoDTO webDto) {
		logger.info("进入ProductService的recordVisit()方法........");
		return productDao.recordAccess(webDto);
	}
}