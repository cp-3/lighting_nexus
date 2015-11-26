package com.lighting.front.web.rest;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lighting.front.biz.service.RegisterService;
import com.lighting.front.biz.service.UserService;
import com.lighting.front.biz.util.IdUtils;
import com.lighting.front.dto.RegisterInfosDTO;
import com.lighting.front.dto.UserInfoDTO;
import com.lighting.front.dto.UserInfosInSessionDTO;
import com.lighting.front.web.constants.ErrorMessage;
import com.lighting.front.web.constants.WebConstants;
import com.lighting.front.web.util.StringUtils;
import com.lighting.front.web.util.WebUtils;
import com.paic.pafa.web.BaseRest;

/**
 * @desc 注册
 * @author Bill
 * @createtime : 2015年3月8日
 */
@Controller
@RequestMapping(value = "/light")
public class RegistRestController extends BaseRest {
	protected Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	private RegisterService registerService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/regist")
	public HashMap<String,Object> regist(@RequestParam(value = "email", required = true) String email,
										 @RequestParam(value = "password", required = true) String password,
										 @RequestParam(value = "deviceId", required = true) String deviceId,
										 @RequestParam(value = "token", required = true) String token
						  				) {
		logger.info("进入RegistRestController的regist方法............");
		HashMap<String,Object> json = new HashMap<String,Object>();
		logger.info("email======"+email+" || password===="+password);
		if(StringUtils.isEmpty(email)){
			json.put("retCode",  WebConstants.RETURN_FAIL_CODE);
			json.put("retMsg",  ErrorMessage.EMAIL_IS_NOT_NULL);
			json.put("result",  "email为空，注册失败！");
			json.put("functionType",  WebConstants.FUNCTION_TYPE_REGISTER);
			return json;
		}
		if(StringUtils.isEmpty(password)){
			json.put("retCode",  WebConstants.RETURN_FAIL_CODE);
			json.put("retMsg",  ErrorMessage.PASSWORD_IS_NOT_NULL);
			json.put("result",  "密码为空，注册失败！");
			json.put("functionType",  WebConstants.FUNCTION_TYPE_REGISTER);
			return json;
		}
		
		//判断该邮箱是否已被注册
		if(registerService.isUserExists(email)){
			json.put("retCode",  WebConstants.RETURN_FAIL_CODE);
			json.put("retMsg",  ErrorMessage.EMAIL_IS_REGISTED);
			json.put("result",  "该邮箱已被注册，注册失败！");
			json.put("functionType",  WebConstants.FUNCTION_TYPE_REGISTER);
			return json;
		}
		
		String userId = IdUtils.getUUID();
		RegisterInfosDTO registInfo = new RegisterInfosDTO();
		registInfo.setUserId(userId);
		registInfo.seteMail(email);
		registInfo.setPassword(password);
		registInfo.setDeviceId(deviceId);
		registInfo.setToken(token);
		if(registerService.register(registInfo)){
			UserInfosInSessionDTO sessionDto = new UserInfosInSessionDTO();
			sessionDto.seteMail(email);
			WebUtils.saveUserInfo(sessionDto); // 维护用户信息进session
			UserInfoDTO userInfo = userService.queryUserInfo(email);
			logger.info("注册成功........");
			json.put("data", userInfo);
			json.put("result",  "注册成功........");
			json.put("retCode",  WebConstants.RETURN_SUCCESS_CODE);
			json.put("retMsg", WebConstants.RETURN_SUCCESS_MSG);
		}else{
			logger.warn("注册失败........");
			json.put("retCode",  WebConstants.RETURN_FAIL_CODE);
			json.put("retMsg",  WebConstants.RETURN_FAIL_MSG);
			json.put("result",  "注册失败！");
			json.put("functionType",  WebConstants.FUNCTION_TYPE_REGISTER);
		}
		return json;
	}
}
