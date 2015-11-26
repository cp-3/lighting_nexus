package com.lighting.front.web.rest;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lighting.front.biz.service.BrandService;
import com.lighting.front.biz.util.IdUtils;
import com.lighting.front.dto.BrandInfoDTO;
import com.lighting.front.web.constants.WebConstants;
import com.paic.pafa.web.BaseRest;

/**
 * @DESC 个人设置
 * @author Bill
 * @createtime: 2015年3月8日
 */
@Controller
@RequestMapping(value = "/light")
public class BrandRestController extends BaseRest {
	protected Log logger = LogFactory.getLog(BrandRestController.class);
	@Autowired
	private BrandService brandService;
	
	/**
	 * @desc 查询品牌信息列表 
	 * @param null
	 * @return HashMap
	 */
	@RequestMapping(value = "/get-all-brand-info")
	public HashMap<String,Object> getAllBrandInfo() {
		logger.info("进入BrandRestController的getAllBrandInfo方法............");
		HashMap<String,Object> json = new HashMap<String,Object>();
		List<BrandInfoDTO> brandInfoList = brandService.getAllBrandInfo();
		logger.info("brandInfoList=="+brandInfoList);
		json.put("data",  brandInfoList);
		json.put("retCode",  WebConstants.RETURN_SUCCESS_CODE);
		json.put("retMsg",  WebConstants.RETURN_SUCCESS_MSG);
		return json;
	}
	
	/**
	 * @desc 查询品牌信息 
	 * @param brandId
	 * @return HashMap
	 */
	@RequestMapping(value = "/get-brand-info")
	public HashMap<String,Object> getBrandInfo(@RequestParam(value = "brandId", required = true) String brandId) {
		logger.info("进入BrandRestController的getBrandInfo方法............");
		HashMap<String,Object> json = new HashMap<String,Object>();
		BrandInfoDTO brandInfo = brandService.getBrandInfo(brandId);
		logger.info("BrandInfoDTO=="+brandInfo);
		json.put("data",  brandInfo);
		json.put("retCode",  WebConstants.RETURN_SUCCESS_CODE);
		json.put("retMsg",  WebConstants.RETURN_SUCCESS_MSG);
		return json;
	}
	
	/**
	 * @desc 编辑品牌信息（新增、更新） 
	 * @param brandId
	 * @return HashMap
	 */
	@RequestMapping(value = "/edit-brand-info")
	public HashMap<String,Object> editBrandInfo(@RequestParam(value = "brandId", required = false) String brandId,
												@RequestParam(value = "brandName", required = false) String brandName,
												@RequestParam(value = "belongAddr", required = false) String belongAddr,
												@RequestParam(value = "address", required = false) String address,
												@RequestParam(value = "brandAllName", required = false) String brandAllName,
												@RequestParam(value = "telephone", required = false) String telephone,
												@RequestParam(value = "fax", required = false) String fax,
												@RequestParam(value = "linkMan", required = false) String linkMan,
												@RequestParam(value = "email", required = false) String email,
												@RequestParam(value = "webSite", required = false) String webSite,
												@RequestParam(value = "weChat", required = false) String weChat,
												@RequestParam(value = "warrPeriod", required = false) String warrPeriod,
												@RequestParam(value = "description", required = false) String description) {
		logger.info("进入BrandRestController的editBrandInfo方法............");
		HashMap<String,Object> json = new HashMap<String,Object>();
		BrandInfoDTO brandInfo = new BrandInfoDTO();
		brandInfo.setAddress(address);
		brandInfo.setBelongAddr(belongAddr);
		brandInfo.setBrandAllName(brandAllName);
		brandInfo.setBrandId(brandId);
		brandInfo.setBrandName(brandName);
		brandInfo.setDescription(description);
		brandInfo.setFax(fax);
		brandInfo.setLinkMan(linkMan);
		brandInfo.setTelephone(telephone);
		brandInfo.setEmail(email);
		brandInfo.setWebSite(webSite);
		brandInfo.setWeChat(weChat);
		brandInfo.setWarrPeriod(warrPeriod);
		logger.info("BrandInfoDTO=="+brandInfo);
		if(StringUtils.isEmpty(brandId)){
			logger.info("新增品牌信息.....");
			brandInfo.setBrandId(IdUtils.getUUID());
			brandService.addBrandInfo(brandInfo);
			json.put("data",  brandInfo);
			json.put("retCode",  WebConstants.RETURN_SUCCESS_CODE);
			json.put("retMsg",  WebConstants.RETURN_SUCCESS_MSG);
			return json;
		}else{
			logger.info("更新品牌信息.....");
			brandService.updateBrandInfo(brandInfo);
			json.put("data",  brandInfo);
			json.put("retCode",  WebConstants.RETURN_SUCCESS_CODE);
			json.put("retMsg",  WebConstants.RETURN_SUCCESS_MSG);
			return json;
		}
//		
//		logger.warn("失败.....");
//		json.put("retCode",  WebConstants.RETURN_SUCCESS_CODE);
//		json.put("retMsg",  WebConstants.RETURN_SUCCESS_MSG);
//		return json;
	}
}
