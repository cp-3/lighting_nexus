package com.lighting.front.web.rest;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lighting.front.biz.service.CollectService;
import com.lighting.front.biz.util.IdUtils;
import com.lighting.front.dto.CollectProductInfoDTO;
import com.lighting.front.web.constants.ErrorMessage;
import com.lighting.front.web.constants.WebConstants;
import com.lighting.front.web.util.StringUtils;
import com.paic.pafa.web.BaseRest;

/**
 * @DESC 收藏产品信息Controller
 * @author Bill
 * @createtime: 2015年3月8日
 */
@Controller
@RequestMapping(value = "/light")
public class CollectRestController extends BaseRest {
	protected Log logger = LogFactory.getLog(CollectRestController.class);
	@Autowired
	private CollectService collectService;
	
	/**
	 * @desc 查询用户收藏产品列表 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/get-collect-list")
	public HashMap<String,Object> getCollectList(@RequestParam(value = "userId", required = true) String userId) {
		logger.info("进入CollectRestController的getCollectList方法............");
		logger.info("userId======"+userId);
		HashMap<String,Object> json = new HashMap<String,Object>();
		List<CollectProductInfoDTO> list = collectService.queryCollectList(userId);
		logger.info("查询用户收藏的产品信息列表成功........");
		logger.info("list=="+list);
		json.put("data",  list);
		json.put("retCode",  WebConstants.RETURN_SUCCESS_CODE);
		json.put("retMsg",  WebConstants.RETURN_SUCCESS_MSG);
		return json;
	}
	
	/** @desc 收藏产品 
	 * @param userId 用户ID
	 * @param email 注册邮箱
	 * @param productId 产品ID
	 * @return
	 */
	@RequestMapping(value = "/collect")
	public HashMap<String,Object> collect(@RequestParam(value = "userId", required = true) String userId,
										  @RequestParam(value = "email", required = false) String email,
										  @RequestParam(value = "productId", required = true) String productId) {
		logger.info("进入CollectRestController的collect方法............");
		logger.info("userId=" +userId+ " ||  productId="+productId+ " ||  email="+email);
		HashMap<String,Object> json = new HashMap<String,Object>();
		String collectId = userId+productId;
		
		if(collectService.isCollected(collectId)){
			logger.warn("该产品已被收藏........");
			json.put("retCode",  WebConstants.RETURN_FAIL_CODE);
			json.put("retMsg",  "您已经收藏了该产品！");
			return json;
		}
		
		if(collectService.collect(userId, productId, email)){
			logger.info("收藏成功........");
			json.put("collectId",  collectId);
			json.put("retCode",  WebConstants.RETURN_SUCCESS_CODE);
			json.put("retMsg",  WebConstants.RETURN_SUCCESS_MSG);
			return json;
		}
		logger.warn("收藏失败........");
		json.put("retCode",  WebConstants.RETURN_FAIL_CODE);
		json.put("retMsg",  WebConstants.RETURN_FAIL_MSG);
		return json;
	}
	
	/** @desc 取消收藏产品 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/cancel-collect")
	public HashMap<String,Object> cancelCollect(@RequestParam(value = "collectId", required = false) String collectId) {
		logger.info("进入CollectRestController的cancelCollect方法............");
		logger.info("collectId=" + collectId);
		HashMap<String,Object> json = new HashMap<String,Object>();
		if(collectService.cancelCollect(collectId)){
			logger.info("取消收藏成功........");
			json.put("retCode",  WebConstants.RETURN_SUCCESS_CODE);
			json.put("retMsg",  WebConstants.RETURN_SUCCESS_MSG);
			return json;
		}
		logger.warn("取消收藏失败........");
		json.put("retCode",  WebConstants.RETURN_FAIL_CODE);
		json.put("retMsg",  WebConstants.RETURN_FAIL_MSG);
		return json;
	}
	
	/**
	 * @desc 编辑或新增收藏产品信息
	 * @param 。。。。。。
	 * @return
	 */
	@RequestMapping(value = "/edit-collect-info")
	public HashMap<String,String> editCollectProductInfo(@RequestParam(value = "collectId", required = false) String collectId,
												  @RequestParam(value = "userId", required = true) String userId,
												  @RequestParam(value = "productId", required = false) String productId,
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
		logger.info("进入CollectRestController的editCollectProductInfo()方法............");
		HashMap<String,String> json = new HashMap<String,String>();
		CollectProductInfoDTO webDto = new CollectProductInfoDTO();
		webDto.setCollectId(collectId);
		webDto.setUserId(userId);
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
		//判断collectId是否为空，为空则是新增，非空则是编辑
		if(StringUtils.isEmpty(collectId)){
			String _productId = IdUtils.getUUID();
			webDto.setProductId(_productId);
			webDto.setCollectId(userId+_productId);
			logger.info("webDto======"+webDto);
			if(collectService.addCollectProduct(webDto)){
				logger.info("新增【"+userId+"】产品信息成功........");
				json.put("collectId",  webDto.getCollectId());
				json.put("retCode",  WebConstants.RETURN_SUCCESS_CODE);
				json.put("retMsg",  WebConstants.RETURN_SUCCESS_MSG);
				return json;
			}
			logger.warn("新增【"+userId+"】产品信息失败........");
			json.put("retCode",  WebConstants.RETURN_FAIL_CODE);
			json.put("retMsg",  ErrorMessage.EMAIL_IS_REGISTED);
			return json;
		}else{
			logger.info("webDto======"+webDto);
			if(collectService.editCollectProduct(webDto)){
				logger.info("更新【"+userId+"】收藏产品信息成功........");
				json.put("collectId",  webDto.getCollectId());
				json.put("retCode",  WebConstants.RETURN_SUCCESS_CODE);
				json.put("retMsg",  WebConstants.RETURN_SUCCESS_MSG);
				return json;
			}
			logger.warn("更新【"+userId+"】收藏产品信息失败........");
			json.put("retCode",  WebConstants.RETURN_FAIL_CODE);
			json.put("retMsg",  "更新产品信息失败!");
			return json;
		}
	}
	
	/**
	 * @desc 添加收藏产品信息
	 * @param 。。。。。。
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/add-collect-product-info")
	public HashMap<String,String> addCollectProductInfo(HttpServletRequest request) throws IOException,IllegalAccessException,InvocationTargetException{
		logger.info("进入ProductRestController的addCollectProductInfo()方法............");
		HashMap<String,String> json = new HashMap<String,String>();
		request.setCharacterEncoding("utf-8"); 
		DiskFileItemFactory factory = new DiskFileItemFactory(); //为解析类提供配置信息
		ServletFileUpload sfu = new ServletFileUpload(factory); //创建解析类的实例
		sfu.setFileSizeMax(1024*400); //开始解析
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		try { 
			List<FileItem> items = sfu.parseRequest(request); 
			//区分表单域 
			for (int i = 0; i < items.size(); i++) {
				FileItem item = items.get(i); 
				if(!item.isFormField()){
					//获得文件名 
					logger.info("fileName:"+item.getName());
					logger.info("field Name:"+item.getFieldName());
					logger.info("fileName byte[]:"+item.get());
					paramMap.put(item.getFieldName(), item.get());
				}else{
					logger.info(item.getString()+ ": "+item.getFieldName());
					paramMap.put(item.getFieldName(), new String(item.getString().getBytes("iso-8859-1"),"utf-8"));
				}
			} 
		} catch (Exception e) { 
			e.printStackTrace(); 
		} 
		logger.info("paramMap:"+paramMap);
		
		CollectProductInfoDTO webDto = new CollectProductInfoDTO();
		webDto.setProductId(IdUtils.getUUID());
		webDto.setUserId(paramMap.get("userId").toString());
		webDto.setCollectId(webDto.getUserId()+webDto.getProductId());
		webDto.setProductName(paramMap.get("productName").toString());
		webDto.setModelType(paramMap.get("modelType").toString());
		webDto.setInstallType(paramMap.get("installType").toString());
		webDto.setFunctionType(paramMap.get("functionType").toString());
		webDto.setLightSouType(paramMap.get("lightSouType").toString());
		webDto.setLightStrength(paramMap.get("lightStrength").toString());
		webDto.setSize(paramMap.get("size").toString());
		webDto.setRefPrice(paramMap.get("refPrice").toString());
		webDto.setBrandId(paramMap.get("brandId").toString());
		webDto.setBrandName(paramMap.get("brandName").toString());
		webDto.setPower(paramMap.get("power").toString());
		webDto.setColorTemp(paramMap.get("colorTemp").toString());
		webDto.setShowColAttr(paramMap.get("showColAttr").toString());
		webDto.setProjectName(paramMap.get("projectName").toString());
		webDto.setAddress(paramMap.get("address").toString());
		webDto.setDeliveryTime(paramMap.get("deliveryTime").toString());
		webDto.setWarrPeriod(paramMap.get("warrPeriod").toString());
		webDto.setUniformity(paramMap.get("uniformity").toString());
		webDto.setCutoffAngle(paramMap.get("cutoffAngle").toString());
		webDto.setRemark(paramMap.get("remark").toString());
		webDto.setAppearanceImg((byte[])paramMap.get("appearanceImgFile"));
		webDto.setSizeImg((byte[])paramMap.get("sizeImgFile"));
		webDto.setGradingImg((byte[])paramMap.get("gradingImgFile"));
		webDto.setBackupImg((byte[])paramMap.get("backupImgFile"));
		logger.info("webDto======"+webDto);
		if(collectService.addCollectProductInfo(webDto)){
			logger.info("添加收藏产品信息成功........");
			json.put("retCode",  WebConstants.RETURN_SUCCESS_CODE);
			json.put("retMsg",  WebConstants.RETURN_SUCCESS_MSG);
		}else{
			logger.warn("添加收藏产品信息失败........");
			json.put("retCode",  WebConstants.RETURN_FAIL_CODE);
			json.put("retMsg",  ErrorMessage.EMAIL_IS_REGISTED);
		}
		return json;
	}
}
