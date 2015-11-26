package com.lighting.front.biz.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lighting.front.biz.dao.PDFDao;
import com.lighting.front.dto.CollectProductInfoDTO;

/**
 * @desc 收藏产品信息service
 * @author ganchungen
 * @since 2014-09-26
 */
@Service("pdfService")
public class PDFService{
	protected Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	private PDFDao pdfDao;
		
	/**
	 * @desc 获取收藏产品信息
	 * @param collectId 收藏ID
	 * @return CollectProductInfoDTO
	 */
	public CollectProductInfoDTO qryCollectProductInfo(String collectId) {
		logger.info("进入PDFService的qryCollectProductInfo方法。。。。。。");
		return pdfDao.qryCollectProductInfo(collectId);
	}
	
}