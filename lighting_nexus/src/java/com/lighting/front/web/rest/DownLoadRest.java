package com.lighting.front.web.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.paic.pafa.web.BaseRest;

/**
 * @图片上传
 * @author Bill
 * @createtime : 2015年4月19日
 */
@Controller
@RequestMapping(value = "/light")
public class DownLoadRest extends BaseRest{
	protected Log logger = LogFactory.getLog(DownLoadRest.class);
		
	/**
	 * @下载PDF
	 * @param request
	 * @param response
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/pdf/download")
	public void downloadPdf(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
		logger.info("开始进入DownLoadRest的downloadPdf方法。。。。。。。");
		String filepath = "";
		filepath = "/usr/local/tomcat8/webapps/lighting/pdf/LN_1.pdf";
//		filepath = "E:\\LN_1.pdf";
		File file = new File(filepath);
		InputStream inputStream = null;
		OutputStream outputStream = null;
		byte[] b= new byte[1024];
		int len = 0;
		try {
			inputStream = new FileInputStream(file);
			outputStream = response.getOutputStream();
			response.setContentType("application/force-download");
			String filename = file.getName();
			logger.info("filename=="+filename);
			response.addHeader("Content-Disposition","attachment; filename=" + URLEncoder.encode(filename, "UTF-8"));
			response.setContentLength( (int) file.length( ) );
			while((len = inputStream.read(b)) != -1){
				outputStream.write(b, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(inputStream != null){
				try {
					inputStream.close();
					inputStream = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(outputStream != null){
				try {
					outputStream.flush();
					outputStream.close();
					outputStream = null;
				} catch (IOException e) {
					logger.info("==========================================18");
					e.printStackTrace();
				}
			}
		}
	}
	
}
