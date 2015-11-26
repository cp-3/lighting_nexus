package com.lighting.front.biz.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lighting.front.biz.dao.RegisterDao;
import com.lighting.front.biz.dao.VersionDao;
import com.lighting.front.dto.RegisterInfosDTO;
import com.lighting.front.web.constants.WebConstants;

/**
 * @desc 会员注册service
 * @author ganchungen
 * @since 2014-09-26
 */
@Service("registerService")
public class RegisterService{
	protected Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	private RegisterDao registerDao;
	@Autowired
	private VersionDao versionDao;
	
	/**
	 * @desc会员注册接口
	 * @param RegisterInfosDTO
	 * @return boolean
	 */
	public boolean register(RegisterInfosDTO dto) {
		logger.info("进入RegisterService的register()方法........");
		dto.setStatus("1");//0--未激活  1--已激活
		dto.setUserType(WebConstants.USER_TYPE_PRIVATE);
//		try {
//			dto.setPassword(SHADevUtils.encryptPwd(dto.getPassword()));
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			return false;
//		}
		if(registerDao.register(dto)){
			logger.info("注册成功......");
			versionDao.addVerisonInfo(dto.geteMail());//新增用户版本信息
			return true;
		}
		
//		//生成激活链接
//		String key = System.currentTimeMillis()+ValidateCodeUtils.getValidateCode(ValidateCodeUtils.OTHER_TYPE, 10, 60);
//		String encodeKey = "";
//		try {
//			encodeKey = URLEncoder.encode(key,"utf-8");
//		} catch (UnsupportedEncodingException e) {
//			logger.warn("encode编码异常："+e.getMessage());
//			encodeKey = key;
//		}
//		if(registerDao.insertJihuoKey(encodeKey,dto.geteMail())){
//			String serverUrl = PropertiesConfigUtil.getProperty("light.server.url");
//			String content = "亲,点此链接激活【"+WebConstants.APP_NAME+"】注册信息。链接："+serverUrl+"light/jihuo.do?key="+encodeKey;
//			logger.info("发送内容："+content);
//			MailInfoDTO info = new MailInfoDTO();
//			info.setContent(content);
//			info.setToAddress(dto.geteMail());
//			info.setSubject("【"+WebConstants.APP_NAME+"】注册激活邮件");
//			
//			try {
//				MailSendUtils.sendTextMail(info);
//				logger.info("激活邮件发送成功。。。。。。");
//			} catch (Exception e) {
//				logger.warn("邮件发送异常："+ e.getMessage());
//			}
//		}
		logger.warn("注册失败......");
		return false;
	}

	/**
	 * 判断用户名是否存在
	 * @param userName 用户名
	 * @return 用户名存在,返回true;否则,返回false
	 */
	public boolean isUserExists(String email) {
		logger.info("判断【"+email+"】是否已经被注册。。。。。");
		if(!"".equals(registerDao.queryByEmail(email))){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 激活注册用户
	 * @param key 激活key
	 * @return boolean
	 */
	public boolean jihuo(String key) {
		logger.info("判断【"+key+"】是否已经被激活。。。。。");
		String keyValue = registerDao.queryByKey(key);
		if("".equals(keyValue) || null == keyValue){
			return false;
		}else{
			return registerDao.jihuo(key);
		}
	}
}