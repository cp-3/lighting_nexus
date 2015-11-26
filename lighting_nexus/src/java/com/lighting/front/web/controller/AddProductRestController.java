package com.lighting.front.web.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lighting.front.biz.service.ProductService;
import com.lighting.front.biz.util.IdUtils;
import com.lighting.front.dto.ProductInfoDTO;
import com.lighting.front.web.constants.ErrorMessage;
import com.lighting.front.web.constants.WebConstants;
import com.paic.pafa.web.BaseController;

/**
 * @DESC 产品信息Controller
 * @author Bill
 * @createtime: 2015年3月8日
 */
@Controller
@RequestMapping(value = "/light")
public class AddProductRestController extends BaseController {
	protected Log logger = LogFactory.getLog(AddProductRestController.class);
	@Autowired
	private ProductService productService;
	
	/**
	 * @desc 添加信息产品信息
	 * @param 。。。。。。
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/add-product-info")
	public String addProductInfo(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws IOException,IllegalAccessException,InvocationTargetException{
		logger.info("进入ProductRestController的addProductInfo()方法............");
		request.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html;charset=utf-8"); 
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
		
		ProductInfoDTO webDto = new ProductInfoDTO();
		webDto.setProductId(IdUtils.getUUID());
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
		//判断产品ID是否为空
		webDto.setProductId(IdUtils.getUUID());
		if(productService.addProduct(webDto)){
			logger.info("新增产品信息成功........");
			model.put("productInfo",  webDto);
			model.put("retCode",  WebConstants.RETURN_SUCCESS_CODE);
			model.put("retMsg",  WebConstants.RETURN_SUCCESS_MSG);
		}else{
			logger.warn("新增产品信息失败........");
			model.put("retCode",  WebConstants.RETURN_FAIL_CODE);
			model.put("retMsg",  ErrorMessage.EMAIL_IS_REGISTED);
		}
		return "resultView";
	}
}
