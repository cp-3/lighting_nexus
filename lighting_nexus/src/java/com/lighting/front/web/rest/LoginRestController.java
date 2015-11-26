package com.lighting.front.web.rest;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lighting.front.biz.service.LoginService;
import com.lighting.front.biz.service.UserService;
import com.lighting.front.dto.LoginInfoDTO;
import com.lighting.front.dto.UserInfoDTO;
import com.lighting.front.dto.UserInfosInSessionDTO;
import com.lighting.front.web.constants.ErrorMessage;
import com.lighting.front.web.constants.WebConstants;
import com.lighting.front.web.util.StringUtils;
import com.lighting.front.web.util.WebUtils;
import com.paic.pafa.web.BaseRest;

/**
 * @DESC 登陆Rest
 * @author Bill
 * @createtime: 2015年3月8日
 */
@Controller
@RequestMapping(value = "/light")
public class LoginRestController extends BaseRest {
	protected Log logger = LogFactory.getLog(LoginRestController.class);
	@Autowired
	private LoginService loginService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login")
	public HashMap<String,Object> login(@RequestParam(value = "email", required = true) String email,
										@RequestParam(value = "password", required = true) String password,
										@RequestParam(value = "deviceId", required = true) String deviceId,
										@RequestParam(value = "token", required = true) String token) {
		logger.info("进入LoginRestController的login方法............");
		logger.info("email="+email+" || password="+password+" || deviceId="+deviceId+" || token="+token);
		HashMap<String,Object> json = new HashMap<String,Object>();
		if(StringUtils.isEmpty(email)){
			json.put("retCode",  WebConstants.RETURN_FAIL_CODE);
			json.put("retMsg",  ErrorMessage.EMAIL_IS_NOT_NULL);
			json.put("result",  "email为空，登陆失败！");
			json.put("functionType",  WebConstants.FUNCTION_TYPE_REGISTER);
			return json;
		}
		
		LoginInfoDTO loginInfo = new LoginInfoDTO();
		loginInfo.seteMail(email);
		loginInfo.setPassword(password);
		loginInfo.setDeviceId(deviceId);
		loginInfo.setToken(token);
		if(!StringUtils.isEmpty(password)){
			if(loginService.validatePassword_1(loginInfo)){
				logger.info("密码登陆，用户信息验证成功........");
				UserInfosInSessionDTO sessionDto = new UserInfosInSessionDTO();
				HashMap<String,Object> versionInfo = loginService.queryVersionInfo(email);
				UserInfoDTO userInfo = userService.queryUserInfo(email);
				//==============更新deviceid 和 token===================
				logger.info("开始更新用户deviceid和token信息.........");
				UserInfoDTO updateInfo = new UserInfoDTO();
				updateInfo.setUserId(userInfo.getUserId());
				updateInfo.setDeviceId(deviceId);
				updateInfo.setToken(token);
				userService.updateInfo(updateInfo);
				logger.info("更新完成.........");
				//===================================================
				userInfo.setDeviceId(deviceId);
				sessionDto.seteMail(email);
				WebUtils.saveUserInfo(sessionDto); // 维护用户信息进session
				json.put("data", userInfo);
				json.put("d_version",  versionInfo.get("d_version").toString());
				json.put("r_version",  versionInfo.get("r_version").toString());
				json.put("b_version",  versionInfo.get("b_version").toString());
				json.put("retCode",  WebConstants.RETURN_SUCCESS_CODE);
				json.put("retMsg",  WebConstants.RETURN_SUCCESS_MSG);
				json.put("functionType",  WebConstants.FUNCTION_TYPE_LOGIN);
				return json;
			}
			logger.warn("密码登陆，用户信息验证失败........");
			json.put("retCode",  WebConstants.RETURN_FAIL_CODE);
			json.put("retMsg",  "邮箱或密码错误！");
			json.put("functionType",  WebConstants.FUNCTION_TYPE_LOGIN);
			return json;
		}
		
		if(loginService.validatePassword_2(loginInfo)){
			logger.info("非密码登陆，用户信息验证成功........");
			UserInfosInSessionDTO sessionDto = new UserInfosInSessionDTO();
			HashMap<String,Object> versionInfo = loginService.queryVersionInfo(email);
			UserInfoDTO userInfo = userService.queryUserInfo(email);
			sessionDto.seteMail(email);
			WebUtils.saveUserInfo(sessionDto); // 维护用户信息进session
			json.put("data", userInfo);
			json.put("d_version",  versionInfo.get("d_version").toString());
			json.put("r_version",  versionInfo.get("r_version").toString());
			json.put("retCode",  WebConstants.RETURN_SUCCESS_CODE);
			json.put("retMsg",  WebConstants.RETURN_SUCCESS_MSG);
			json.put("functionType",  WebConstants.FUNCTION_TYPE_LOGIN);
			return json;
		}
		logger.warn("非密码登陆失败........");
		json.put("retCode",  WebConstants.RETURN_FAIL_CODE);
		json.put("retMsg",  "非密码登陆失败！");
		json.put("functionType",  WebConstants.FUNCTION_TYPE_LOGIN);
		return json;
	}
	
	/**
	 * 退出
	 * @return
	 */
	@RequestMapping(value = "/login-out")
	public HashMap<String,String> loginOut() {
		WebUtils.loginOut();
		HashMap<String,String> json = new HashMap<String,String>();
		json.put("retCode",  WebConstants.RETURN_SUCCESS_CODE);
		json.put("retMsg",  WebConstants.RETURN_SUCCESS_MSG);
		return json;
	}
}
