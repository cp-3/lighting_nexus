package com.lighting.front.biz.dao;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.lighting.front.dto.LoginInfoDTO;
import com.lighting.front.dto.UserInfoDTO;
import com.paic.pafa.biz.dao.BaseDAO;

/**
 * @desc 用户DAO
 * @author ganchungen
 * @since 2014-10-08
 */
@Service("userDao")
public class UserDao extends BaseDAO {
	protected Log logger = LogFactory.getLog(this.getClass());
	
	/**
	 * @desc 查询密码 
	 * @param LoginInfoDTO
	 * @return boolean
	 */
	public String queryPassword(LoginInfoDTO dto){
		HashMap<String,String> condition = new HashMap<String,String>();
		condition.put("email", dto.geteMail());
		condition.put("password", dto.getPassword());
		logger.info("condition==:"+condition);
		String password = (String) this._queryForObject("query-by-nameandpsw",condition);
		logger.info("password---->"+password);
		return password;
	}
	
	/**
	 * @desc 查询密码 
	 * @param LoginInfoDTO
	 * @return boolean
	 */
	@SuppressWarnings("unchecked")
	public String queryPasswordByEmail(LoginInfoDTO dto){
		logger.info("email==:"+dto.geteMail());
		HashMap<String, String> retMap = (HashMap<String, String>) this._queryForObject("query-psw-by-email", dto.geteMail());
		logger.info("retMap---->"+retMap);
		if(null==retMap){
			return "";
		}else{
			return retMap.get("password");
		}
	}
	
	/**
	 * @desc 查询用户信息，通过手机号、设备号及token 
	 * @param LoginInfoDTO
	 * @return boolean
	 */
	public boolean queryUserinfoBynonFirstLogin(LoginInfoDTO dto){
		HashMap<String,String> condition = new HashMap<String,String>();
		condition.put("email", dto.geteMail());
		condition.put("deviceId", dto.getDeviceId());
		condition.put("token", dto.getToken());
		logger.info("condition==:"+condition);
		String email = (String) this._queryForObject("query-count-non-first-login", condition);
		logger.info("email---->"+email);
		return !StringUtils.isEmpty(email);
	}
	
	/**
	 * @desc 更新用户信息 
	 * @param UserInfoDTO
	 * @return boolean
	 */
	public boolean updateInfo(UserInfoDTO userInfo){
		int code = this._update("update-user-info", userInfo);
		logger.info("code---->" + code);
		return true;
	}
	
	/**
	 * @desc 查询用户信息 
	 * @param String email
	 * @return UserInfoDTO
	 */
	public UserInfoDTO queryUserInfo(String email){
		logger.info("email==:"+email);
		UserInfoDTO userInfo = (UserInfoDTO) this._queryForObject("query-user-info-by-email",email);
		logger.info("UserInfoDTO---->"+userInfo);
		return userInfo;
	}
	
	/**
	 * @desc 查询邮箱 
	 * @param String userId
	 * @return String
	 */
	public String queryEmail(String userId){
		logger.info("userId==:"+userId);
		String email = (String) this._queryForObject("query-email-by-userId",userId);
		logger.info("email---->"+email);
		return email;
	}
	
	/**
	 * @desc 更新用户头像地址信息 
	 * @param iconUrl
	 * @return boolean
	 */
	public boolean updateIconInfo(String iconUrl, String userId){
		HashMap<String,String> condition = new HashMap<String,String>();
		condition.put("iconUrl", iconUrl);
		condition.put("userId", userId);
		logger.info("condition==:"+condition);
		int code = this._update("update-user-icon-info", condition);
		logger.info("code---->" + code);
		return true;
	}
}
