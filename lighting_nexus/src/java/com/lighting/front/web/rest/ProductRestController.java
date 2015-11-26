package com.lighting.front.web.rest;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lighting.front.biz.service.ProductService;
import com.lighting.front.dto.ProductInfoDTO;
import com.lighting.front.dto.VisitInfoDTO;
import com.lighting.front.web.constants.ErrorMessage;
import com.lighting.front.web.constants.WebConstants;
import com.lighting.front.web.util.StringUtils;
import com.paic.pafa.web.BaseRest;

/**
 * @DESC 产品信息Controller
 * @author Bill
 * @createtime: 2015年3月8日
 */
@Controller
@RequestMapping(value = "/light")
public class ProductRestController extends BaseRest {
	protected Log logger = LogFactory.getLog(ProductRestController.class);
	@Autowired
	private ProductService productService;
	
	/**
	 * @desc 查询所有产品列表 
	 * @param null
	 * @return
	 */
	@RequestMapping(value = "/get-all-product")
	public HashMap<String,Object> getAllProduct() {
		logger.info("进入ProductRestController的getAllProduct方法............");
		HashMap<String,Object> json = new HashMap<String,Object>();
		List<ProductInfoDTO> list = productService.getAllProduct();
		logger.info("查询成功........");
		logger.info("list=="+list);
		json.put("data",  list);
		json.put("retCode",  WebConstants.RETURN_SUCCESS_CODE);
		json.put("retMsg",  WebConstants.RETURN_SUCCESS_MSG);
		return json;
	}
	
	/**
	 * @desc 编辑或信息产品信息
	 * @param 。。。。。。
	 * @return
	 */
	@RequestMapping(value = "/edit-product-info")
	public HashMap<String,String> editProductInfo(@RequestParam(value = "productId", required = false) String productId,
												  @RequestParam(value = "productName", required = false) String productName,
												  @RequestParam(value = "modelType", required = false) String modelType,
												  @RequestParam(value = "installType", required = false) String installType,
												  @RequestParam(value = "functionType", required = false) String functionType,
												  @RequestParam(value = "lightStrength", required = false) String lightStrength,
												  @RequestParam(value = "lightSouType", required = false) String lightSouType,
												  @RequestParam(value = "size", required = false) String size,
												  @RequestParam(value = "brandName", required = false) String brandName,
												  @RequestParam(value = "brandId", required = false) String brandId,
												  @RequestParam(value = "power", required = false) String power,
												  @RequestParam(value = "colorTemp", required = false) String colorTemp,
												  @RequestParam(value = "showColAttr", required = false) String showColAttr,
												  @RequestParam(value = "projectName", required = false) String projectName,
												  @RequestParam(value = "address", required = false) String address,
												  @RequestParam(value = "refPrice", required = false) String refPrice,
												  @RequestParam(value = "deliveryTime", required = false) String deliveryTime,
												  @RequestParam(value = "warrPeriod", required = false) String warrPeriod,
												  @RequestParam(value = "uniformity", required = false) String uniformity,
												  @RequestParam(value = "cutoffAngle", required = false) String cutoffAngle,
												  @RequestParam(value = "remark", required = false) String remark
			) {
		logger.info("进入ProductRestController的editProductInfo()方法............");
		HashMap<String,String> json = new HashMap<String,String>();
		if(StringUtils.isEmpty(productId)){
			json.put("retCode",  WebConstants.RETURN_FAIL_CODE);
			json.put("retMsg",  ErrorMessage.PRODUCT_ID_CAN_NOT_NULL);
			json.put("result",  "产品ID不能为空！");
			return json;
		}
		ProductInfoDTO webDto = new ProductInfoDTO();
		webDto.setProductId(productId);
		webDto.setProductName(productName);
		webDto.setModelType(modelType);
		webDto.setInstallType(installType);
		webDto.setFunctionType(functionType);
		webDto.setLightSouType(lightSouType);
		webDto.setLightStrength(lightStrength);
		webDto.setSize(size);
		webDto.setRefPrice(refPrice);
		webDto.setBrandId(brandId);
		webDto.setBrandName(brandName);
		webDto.setPower(power);
		webDto.setColorTemp(colorTemp);
		webDto.setShowColAttr(showColAttr);
		webDto.setProjectName(projectName);
		webDto.setAddress(address);
		webDto.setDeliveryTime(deliveryTime);
		webDto.setWarrPeriod(warrPeriod);
		webDto.setUniformity(uniformity);
		webDto.setCutoffAngle(cutoffAngle);
		webDto.setRemark(remark);
		logger.info("webDto======"+webDto);
		//判断产品ID是否为空
//		if(StringUtils.isEmpty(productId)){
//			webDto.setProductId(IdUtils.getUUID());
//			if(productService.addProduct(webDto)){
//				logger.info("新增产品信息成功........");
//				json.put("productId",  webDto.getProductId());
//				json.put("retCode",  WebConstants.RETURN_SUCCESS_CODE);
//				json.put("retMsg",  WebConstants.RETURN_SUCCESS_MSG);
//				return json;
//			}
//			logger.warn("新增产品信息失败........");
//			json.put("retCode",  WebConstants.RETURN_FAIL_CODE);
//			json.put("retMsg",  ErrorMessage.EMAIL_IS_REGISTED);
//			return json;
//		}else{
			if(productService.editProduct(webDto)){
				logger.info("更新产品信息成功........");
				json.put("productId",  webDto.getProductId());
				json.put("retCode",  WebConstants.RETURN_SUCCESS_CODE);
				json.put("retMsg",  WebConstants.RETURN_SUCCESS_MSG);
				return json;
			}
			logger.warn("更新产品信息失败........");
			json.put("retCode",  WebConstants.RETURN_FAIL_CODE);
			json.put("retMsg",  "更新产品信息失败!");
			return json;
//		}
	}

	/**
	 * @desc 记录访问信息 
	 * @param null
	 * @return
	 */
	@RequestMapping(value = "/record-access")
	public HashMap<String,Object> recordVisit(@RequestParam(value = "userId", required = true) String userId,
			  								  @RequestParam(value = "productId", required = true) String productId) {
		logger.info("进入ProductRestController的recordVisit方法............");
		VisitInfoDTO webDto = new VisitInfoDTO();
		webDto.setProductId(productId);
		webDto.setUserId(userId);
		logger.info("VisitInfoDTO=="+webDto);
		HashMap<String,Object> json = new HashMap<String,Object>();
		if(productService.recordAccess(webDto)){
			logger.info("记录成功........");
			json.put("retCode",  WebConstants.RETURN_SUCCESS_CODE);
			json.put("retMsg",  WebConstants.RETURN_SUCCESS_MSG);
			return json;
		}
		logger.warn("记录失败........");
		json.put("retCode",  WebConstants.RETURN_FAIL_CODE);
		json.put("retMsg",  WebConstants.RETURN_FAIL_MSG);
		return json;
	}
}
