package com.lighting.front.biz.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lighting.front.biz.dao.UserDao;
import com.lighting.front.dto.LoginInfoDTO;
import com.lighting.front.dto.MailInfoDTO;
import com.lighting.front.dto.UserInfoDTO;
import com.lighting.front.util.MailSendUtils;
import com.lighting.front.web.constants.WebConstants;

/**
 * @desc 会员注册service
 * @author ganchungen
 * @since 2014-09-26
 */
@Service("userService")
public class UserService{
	protected Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	private UserDao userDao;
	
	/**
	 * @desc 更新用户信息
	 * @param UserInfoDTO
	 * @return boolean
	 */
	public boolean updateInfo(UserInfoDTO userInfo) {
		logger.info("进入UserService的updateInfo()方法........");
		if(userDao.updateInfo(userInfo)){
			logger.info("更新成功......");
			return true;
		}
		logger.warn("更新失败......");
		return false;
	}
	
	/**
	 * @desc 找回密码--发送密码
	 * @param UserInfoDTO
	 * @return boolean
	 */
	public boolean sendPassword(String email) {
		logger.info("进入UserService的sendPassword()方法........");
		LoginInfoDTO dto = new LoginInfoDTO();
		dto.seteMail(email);
		String password = userDao.queryPasswordByEmail(dto);
		//生成激活链接
		String content = "亲,您的登陆密码为【" + password + "】请妥善保管，谢谢！";
		logger.info("发送内容："+content);
		MailInfoDTO info = new MailInfoDTO();
		info.setContent(content);
		info.setToAddress(dto.geteMail());
		info.setSubject("【"+WebConstants.APP_NAME+"】找回密码邮件");
		try {
			MailSendUtils.sendTextMail(info);
			logger.info("找回密码邮件发送成功。。。。。。");
		} catch (Exception e) {
			logger.warn("邮件发送异常："+ e.getMessage());
			return false;
		}
		return true;
	}
	
	/**
	 * @desc 查询用户信息 
	 * @param String email
	 * @return UserInfoDTO
	 */
	public UserInfoDTO queryUserInfo(String email){
		return userDao.queryUserInfo(email);
	}
	
	/**
	 * @desc 查询邮箱 
	 * @param String userId
	 * @return String
	 */
	public String queryEmail(String userId){
		return userDao.queryEmail(userId);
	}
	
	/**
	 * @desc 更新用户头像地址信息 
	 * @param iconUrl
	 * @return boolean
	 */
	public boolean updateIconInfo(String iconUrl, String userId){
		return userDao.updateIconInfo(iconUrl, userId);
	}
}