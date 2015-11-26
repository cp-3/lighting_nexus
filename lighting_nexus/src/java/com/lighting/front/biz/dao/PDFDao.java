package com.lighting.front.biz.dao;

import org.springframework.stereotype.Service;

import com.lighting.front.dto.CollectProductInfoDTO;
import com.paic.pafa.biz.dao.BaseDAO;

/**
 * @desc 品牌DAO
 * @author ganchungen
 * @since 2014-09-26
 */
@Service("pdfDao")
public class PDFDao extends BaseDAO{

	/**
	 * @desc 获取品牌信息
	 * @param String collectId
	 * @return CollectProductInfoDTO
	 */
	public CollectProductInfoDTO qryCollectProductInfo(String collectId){
		logger.info("进入PDFDao的qryCollectProductInfo()方法...........");
		logger.info("collectId==:"+collectId);
		CollectProductInfoDTO collectInfo =  (CollectProductInfoDTO) this._queryForObject("query-collect-product-info", collectId);
		logger.info("CollectProductInfoDTO==="+collectInfo);
		return collectInfo;
	}
	
}
