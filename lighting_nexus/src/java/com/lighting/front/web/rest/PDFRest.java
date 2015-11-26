package com.lighting.front.web.rest;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lighting.front.biz.service.BrandService;
import com.lighting.front.biz.service.PDFService;
import com.lighting.front.biz.service.ProductService;
import com.lighting.front.dto.BrandInfoDTO;
import com.lighting.front.dto.CollectProductInfoDTO;
import com.lighting.front.util.PDFUtil;
import com.lighting.front.web.constants.WebConstants;
import com.paic.pafa.web.BaseRest;

/**
 * @desc PDF REST
 * @author Bill
 * @createtime : 2015年4月5日
 */
@Controller
@RequestMapping(value = "/light")
public class PDFRest extends BaseRest {
	private Log logger = LogFactory.getLog(PDFRest.class);
	
	@Autowired
	private PDFService pdfService;
	@Autowired
	private ProductService productService;
	@Autowired
	private BrandService brandService;
	/**
	 * 生成PDF文件
	 * @return
	 */
	@RequestMapping(value = "/build-pdf")
	public HashMap<String,String> buildPdf(String pdfId) {
		logger.info("开始进入PdfRest访问buildPdf方法......pdfId=="+pdfId);
		PDFUtil.buildPDF_1(pdfId);
		logger.info("buildPdf结束......");
		HashMap<String,String> json = new HashMap<String,String>();
		json.put("retCode",  WebConstants.RETURN_SUCCESS_CODE);
		json.put("retMsg",  WebConstants.RETURN_SUCCESS_MSG);
		return json;
	}
	
	/**
	 * @desc分享产品报告
	 * @return
	 */
	@RequestMapping(value = "/share-product-info")
	public HashMap<String,String> shareProductInfo(@RequestParam(value = "collectId", required = false) String collectId,
												   @RequestParam(value = "productId", required = false) String productId) {
		logger.info("开始进入PdfRest访问shareProductInfo方法......");
		logger.info("collectId=="+collectId+"  || productId=="+productId);
		String brandId = "";
		CollectProductInfoDTO collectInfo = null;
		HashMap<String,String> json = new HashMap<String,String>();
		if(StringUtils.isEmpty(collectId) && StringUtils.isEmpty(productId)){
			json.put("retCode",  WebConstants.RETURN_FAIL_CODE);
			json.put("retMsg",  "参数错误！");
			return json;
		}
		
		if(!StringUtils.isEmpty(collectId)){
			collectInfo = pdfService.qryCollectProductInfo(collectId);
			logger.info("collectInfo1=="+collectInfo);
			brandId = collectInfo.getBrandId();
		}
		
		if(!StringUtils.isEmpty(productId)){
			collectInfo = productService.queryProductInfo(productId);
			logger.info("collectInfo2=="+collectInfo);
			brandId = collectInfo.getBrandId();
		}
		
		BrandInfoDTO brandInfo = brandService.getBrandInfo(brandId);
		logger.info("brandInfo=="+brandInfo);
		String url = PDFUtil.buildPDF(collectInfo,brandInfo);
		json.put("url",  url);
		json.put("retCode",  WebConstants.RETURN_SUCCESS_CODE);
		json.put("retMsg",  WebConstants.RETURN_SUCCESS_MSG);
		return json;
	}
}
