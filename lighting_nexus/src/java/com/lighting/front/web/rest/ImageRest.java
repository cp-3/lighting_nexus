package com.lighting.front.web.rest;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lighting.front.biz.service.ImageService;
import com.lighting.front.biz.service.UserService;
import com.lighting.front.dto.CollectProductInfoDTO;
import com.lighting.front.dto.HeadImageDTO;
import com.lighting.front.util.PropertiesConfigUtil;
import com.lighting.front.web.constants.ErrorMessage;
import com.lighting.front.web.constants.WebConstants;
import com.paic.pafa.web.BaseRest;

/**
 * @图片上传
 * @author Bill
 * @createtime : 2015年4月19日
 */
@Controller
@RequestMapping(value = "/light")
public class ImageRest extends BaseRest{
	protected Log logger = LogFactory.getLog(ImageRest.class);
		
	@Autowired
	private UserService userService;
	@Autowired
	private ImageService imageService;
	
	@RequestMapping(value = "/upload-image-test")
	public HashMap<String,String> testUploadImage(@RequestParam(value = "collectId", required = false) String collectId,
												  @RequestParam(value = "appearanceImgFile", required = false) String appearanceImgFile,
												  @RequestParam(value = "imageType", required = false) String imageType) throws UnsupportedEncodingException{
		HashMap<String,String> json = new HashMap<String,String>();
		logger.info("collectId=="+collectId);
		logger.info("appearanceImgFile=="+appearanceImgFile);
		imageService.testUploadImage(collectId, appearanceImgFile);
		json.put("retCode",  WebConstants.RETURN_SUCCESS_CODE);
		json.put("retMsg",  WebConstants.RETURN_SUCCESS_MSG);
		return json;
		
	}
	@RequestMapping(value = "/get-image-test")
	public HashMap<String,String> testGetImage(@RequestParam(value = "collectId", required = false) String collectId) throws UnsupportedEncodingException{
//	public void testGetImage(@RequestParam(value = "collectId", required = false) String collectId,HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
		HashMap<String,String> json = new HashMap<String,String>();
		logger.info("collectId=="+collectId);
		String imageStr = imageService.testGetImage(collectId);
		json.put("imageStr",  imageStr);
		json.put("retCode",  WebConstants.RETURN_SUCCESS_CODE);
		json.put("retMsg",  WebConstants.RETURN_SUCCESS_MSG);
		return json;
//		String imageStr = imageService.testGetImage(collectId);
//		try {
//        	OutputStream out = response.getOutputStream();
//        	out.write(imageStr.getBytes());
//			out.flush(); 
//		    out.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
	}
	
	/**
	 * @头像上传
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/upload-head-image")
	public HashMap<String,String> uploadHeadImage(@RequestParam(value = "userId", required = false) String userId,
												  HttpServletRequest request, 
												  HttpServletResponse response) throws UnsupportedEncodingException{
		logger.info("开始进入ImageRest的uploadHeadImage方法。。。。。。。userId=="+userId);
		userId = "450d9bd6Aca16A4393Abae9Aa3de8f9ff01f";
		HashMap<String,String> json = new HashMap<String,String>();
		request.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html;charset=utf-8"); 
		DiskFileItemFactory factory = new DiskFileItemFactory(); //为解析类提供配置信息
		ServletFileUpload sfu = new ServletFileUpload(factory); //创建解析类的实例
		sfu.setFileSizeMax(1024*400); //开始解析
		try { 
			List<FileItem> items = sfu.parseRequest(request); 
			//区分表单域 
			for (int i = 0; i < items.size(); i++) {
				FileItem item = items.get(i); 
				//isFormField为true，表示这不是文件上传表单域
				if(!item.isFormField()){
					HeadImageDTO image = new HeadImageDTO();
					image.setUserId(userId);
					image.setHeadImage(item.get());
					boolean result = imageService.saveHeadImage(image);
					logger.info("保存结果："+result);
				}
			} 
		} catch (Exception e) { 
			e.printStackTrace(); 
		} 
		json.put("retCode",  WebConstants.RETURN_SUCCESS_CODE);
		json.put("retMsg",  WebConstants.RETURN_SUCCESS_MSG);
		return json;
	}
	
	/**
	 * @头像上传
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/get-head-image")
	public void getHeadImage(@RequestParam(value = "userId", required = false) String userId,
							 HttpServletRequest request, 
							 HttpServletResponse response) throws UnsupportedEncodingException{
		logger.info("开始进入ImageRest的getHeadImage方法。。。。。。。userId=="+userId);
		HeadImageDTO dto = imageService.getHeadImage(userId);
        try {
        	OutputStream out = response.getOutputStream();
        	if(null!=dto)
        		out.write(dto.getHeadImage());
        	else
        		out.write(null);
			out.flush(); 
		    out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @产品图片获取
	 * @param productId 产品ID
	 * @param imageType 图片类型：1--外观图片，2--尺寸图片,3--配光图片,4--备用图片
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/get-product-image")
	public void getProductImage(@RequestParam(value = "productId", required = false) String productId,
								@RequestParam(value = "collectId", required = false) String collectId,
								@RequestParam(value = "imageType", required = false) String imageType,
							    HttpServletRequest request, 
							    HttpServletResponse response){
		logger.info("开始进入ImageRest的getProductImage方法。。。。。。。productId=="+productId);
		logger.info("imageType:【"+imageType+"】|| 1--外观图片，2--尺寸图片,3--配光图片,4--备用图片");
/**
 * 以下为从服务器目录下读取图片
 */
//		String dir = PropertiesConfigUtil.getProperty("product.image.dir");
//        try {
//        	FileInputStream fis =new FileInputStream (dir+productId+".jpg");
//        	int size = fis.available(); 
//        	byte data[] = new byte[size];
//        	fis.read(data);
//        	fis.close();
//        	OutputStream out = response.getOutputStream();  
//        	out.write(data);
//			out.flush(); 
//		    out.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
/**
 * 以下为从DB获取图片信息		
 */
		CollectProductInfoDTO dto = null;
		if(!StringUtils.isEmpty(productId)){
			dto = imageService.getProductImage(productId);
		}else{
			dto = imageService.getCollectProductImage(collectId);
		}
        try {
        	OutputStream out = response.getOutputStream();
        	if(null!=dto){
        		if("1".equalsIgnoreCase(imageType))
        			out.write(dto.getAppearanceImg());
        		else if("2".equalsIgnoreCase(imageType))
        			out.write(dto.getSizeImg());
        		else if("3".equalsIgnoreCase(imageType))
        			out.write(dto.getGradingImg());
        		else
        			out.write(dto.getBackupImg());
        	}else{
        		out.write(null);
        	}
			out.flush(); 
		    out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @产品图片信息上传，上传到目录下
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/upload-product-image")
	public HashMap<String,String> uploadProductImage(@RequestParam(value = "productId", required = false) String productId,
												  	HttpServletRequest request, 
												  	HttpServletResponse response) throws UnsupportedEncodingException{
		logger.info("开始进入ImageRest的uploadProductImage方法。。。。。。。productId=="+productId);
		HashMap<String,String> json = new HashMap<String,String>();
		request.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html;charset=utf-8"); 
		DiskFileItemFactory factory = new DiskFileItemFactory(); //为解析类提供配置信息
		ServletFileUpload sfu = new ServletFileUpload(factory); //创建解析类的实例
		sfu.setFileSizeMax(1024*1024); //开始解析
		try { 
			List<FileItem> items = sfu.parseRequest(request); 
			//区分表单域 
			for (int i = 0; i < items.size(); i++) {
				FileItem item = items.get(i); 
				//isFormField为true，表示这不是文件上传表单域
				if(!item.isFormField()){
					String dir = PropertiesConfigUtil.getProperty("product.image.dir");
					String fileName = dir + productId + ".jpg";
					logger.info("文件名："+fileName);
					File file = new File(fileName);
					item.write(file); 
				}
			} 
		} catch (Exception e) { 
			e.printStackTrace(); 
		} 
		json.put("retCode",  WebConstants.RETURN_SUCCESS_CODE);
		json.put("retMsg",  WebConstants.RETURN_SUCCESS_MSG);
		return json;
	}
	
	/**
	 * @desc 收藏产品图片信息上传，上传到DB中
	 * @param 。。。。。。
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/upload-collect-product-image-info")
	public HashMap<String, String> uploadCollectProductImageInfo(HttpServletRequest request) throws UnsupportedEncodingException{
		logger.info("进入ProductRestController的uploadCollectProductImageInfo()方法............");
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
		if(imageService.uploadCollectProductImageInfo(paramMap)){
			logger.info("收藏产品图片信息上传成功........");
			json.put("retCode",  WebConstants.RETURN_SUCCESS_CODE);
			json.put("retMsg",  WebConstants.RETURN_SUCCESS_MSG);
		}else{
			logger.warn("收藏产品图片信息上传失败........");
			json.put("retCode",  WebConstants.RETURN_FAIL_CODE);
			json.put("retMsg",  ErrorMessage.EMAIL_IS_REGISTED);
		}
		return json;
	}
}
