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
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lighting.front.biz.service.ImageService;
import com.lighting.front.biz.service.UserService;
import com.lighting.front.util.PropertiesConfigUtil;
import com.lighting.front.web.constants.WebConstants;
import com.paic.pafa.web.BaseRest;

/**
 * @图片上传
 * @author Bill
 * @createtime : 2015年4月19日
 */
@Controller
@RequestMapping(value = "/light")
public class UpLoadRest extends BaseRest{
	protected Log logger = LogFactory.getLog(UpLoadRest.class);
		
	@Autowired
	private UserService userService;
	@Autowired
	private ImageService imageService;
	
	/**
	 * @头像上传
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/upload-test")
	public HashMap<String,String> uploadHeadIcon(@RequestParam(value = "userId", required = false) String userId,
												 HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
		logger.info("开始进入UpLoadRest的uploadHeadIcon方法。。。。。。。userId=="+userId);
//		userId = "450d9bd6Aca16A4393Abae9Aa3de8f9ff01f";
		String address = PropertiesConfigUtil.getProperty("lighting.address.url");
		HashMap<String,String> json = new HashMap<String,String>();
		request.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html;charset=utf-8"); 
		DiskFileItemFactory factory = new DiskFileItemFactory(); //为解析类提供配置信息
		ServletFileUpload sfu = new ServletFileUpload(factory); //创建解析类的实例
		sfu.setFileSizeMax(1024*400); //开始解析
		//每个表单域中数据会封装到一个对应的FileItem对象上 ,头像文档存放地址
	    String icon_document_dir = PropertiesConfigUtil.getProperty("head.icon.dir");
	    //获得存放文件的物理路径, upload下的某个文件夹 得到当前在线的用户 找到对应的文件夹 
		logger.info("icon path:"+icon_document_dir); 
		String fileName = "";
		try { 
			List<FileItem> items = sfu.parseRequest(request); 
			//区分表单域 
			for (int i = 0; i < items.size(); i++) {
				FileItem item = items.get(i); 
				//isFormField为true，表示这不是文件上传表单域
				if(!item.isFormField()){ 
					//获得文件名 
					fileName = item.getName(); 
					fileName = userId +".jpg";
					logger.info(fileName);
					//该方法在某些平台(操作系统),会返回路径+文件名 
//					fileName = fileName.substring(fileName.lastIndexOf("/")+1); 
					File file = new File(icon_document_dir+"\\"+fileName);
//					if(!file.exists()){ 
						item.write(file); 
						//将上传图片的名字记录到数据库中
//						InputStream fileIs = item.get().getInputStream();
//						logger.info("保存结果："+imageService.saveImage(item.get()));
//					} 
				}else{
					userId = item.getName(); 
					logger.info("userId1===="+userId);
					logger.info("userId2===="+item.getString());
					logger.info("userId3===="+item.getFieldName());
				}
			} 
		} catch (Exception e) { 
			e.printStackTrace(); 
		} 
		String iconUrl = address+"/lighting/icon/"+fileName;
		logger.info("iconUrl=="+iconUrl);
//		userService.updateIconInfo(iconUrl, userId);
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
//	@RequestMapping(value = "/get-head-icon")
	public void getHeadIcon(@RequestParam(value = "id", required = false) String id,
							HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
		logger.info("开始进入UpLoadRest的getHeadIcon方法。。。。。。。id=="+id);
//		ImageInfoDTO dto = imageService.getImageInfo(id);
        try {
        	OutputStream out = response.getOutputStream();  
//			out.write(dto.getPhoto());
			out.flush(); 
		    out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
