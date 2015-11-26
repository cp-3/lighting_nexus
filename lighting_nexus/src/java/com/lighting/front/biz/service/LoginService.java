package com.lighting.front.biz.service;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lighting.front.biz.dao.UserDao;
import com.lighting.front.biz.dao.VersionDao;
import com.lighting.front.dto.LoginInfoDTO;
import com.lighting.front.web.util.StringUtils;

/**
 * @desc 会员登陆service
 * @author ganchungen
 * @since 2014-10-08
 */
@Service("loginService")
public class LoginService{
	protected Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private VersionDao versionDao;

	/**
	 * @desc 会员首次登陆接口
	 * @param LoginInfoDTO
	 * @return boolean
	 */
	public boolean validatePassword_1(LoginInfoDTO dto) {
//		String encryptPwd = "";//加密后的密码
//		try {
//			encryptPwd = SHADevUtils.encryptPwd(dto.getPassword());
//			dto.setPassword(encryptPwd);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			return false;
//		}
//		String comparePwd = userDao.queryPassword(dto);
		String password = userDao.queryPassword(dto);
		if(!StringUtils.isEmpty(password)){
			logger.info("验证通过.......");
//			versionDao.addVerisonInfo(dto.geteMail());//新增用户版本信息
			return true;
		}
		logger.warn("验证失败.......");
		return false;
	}

	/**
	 * @desc 会员非首次登陆接口
	 * @param LoginInfoDTO
	 * @return boolean
	 */
	public boolean validatePassword_2(LoginInfoDTO dto) {
		return userDao.queryUserinfoBynonFirstLogin(dto);
	}
	
	/**
	 * @desc 查询用户版本信息
	 * @param String email
	 * @return HashMap<String, Object>
	 */
	public HashMap<String, Object> queryVersionInfo(String email) {
		return versionDao.queryVersionInfoByEmail(email);
	}
}
