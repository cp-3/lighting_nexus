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
import com.lighting.front.dto.UserInfoDTO;
import com.lighting.front.web.constants.ErrorMessage;
import com.lighting.front.web.constants.WebConstants;
import com.lighting.front.web.util.StringUtils;
import com.paic.pafa.web.BaseRest;

/**
 * @DESC 个人设置
 * @author Bill
 * @createtime: 2015年3月8日
 */
@Controller
@RequestMapping(value = "/light")
public class UserSetRestController extends BaseRest {
	protected Log logger = LogFactory.getLog(UserSetRestController.class);
	@Autowired
	private UserService userService;
	@Autowired
	private RegisterService registerService;
	
	/**
	 * @desc 用户信息更新
	 * @param userId
	 * @param profession
	 * @param concern
	 * @param area
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/info-update")
	public HashMap<String,String> infoUpdate(@RequestParam(value = "userId", required = true) String userId,
											 @RequestParam(value = "profession", required = false) String profession,
											 @RequestParam(value = "concern", required = false) String concern,
											 @RequestParam(value = "area", required = false) String area,
											 @RequestParam(value = "password", required = false) String password
										) {
		logger.info("进入UserSetRestController的infoUpdate方法............");
		HashMap<String,String> json = new HashMap<String,String>();
		if(StringUtils.isEmpty(userId)){
			json.put("retCode",  WebConstants.RETURN_FAIL_CODE);
			json.put("retMsg",  ErrorMessage.USERID_CAN_NOT_NULL);
			json.put("result",  ErrorMessage.USERID_CAN_NOT_NULL);
			return json;
		}
		UserInfoDTO userInfo = new UserInfoDTO();
		userInfo.setUserId(userId);
		userInfo.setProfession(profession);
		userInfo.setConcern(concern);
		userInfo.setArea(area);
		userInfo.setPassword(password);
		logger.info("UserInfoDTO======"+userInfo);
		if(userService.updateInfo(userInfo)){
			logger.info("用户信息更新成功........");
			json.put("retCode",  WebConstants.RETURN_SUCCESS_CODE);
			json.put("retMsg",  WebConstants.RETURN_SUCCESS_MSG);
		}else{
			logger.warn("更新用户信息失败........");
			json.put("retCode",  WebConstants.RETURN_FAIL_CODE);
			json.put("retMsg",  WebConstants.RETURN_FAIL_MSG);
		}
		return json;
	}
	
	/**
	 * @desc 找回密码--发送密码
	 * @param email
	 * @return
	 */
	@RequestMapping(value = "/send-password")
	public HashMap<String,String> sendPassword(@RequestParam(value = "email", required = true) String email) {
		logger.info("进入UserSetRestController的sendCode方法............");
		logger.info("email======"+email);
		
		HashMap<String,String> json = new HashMap<String,String>();
		//判断该邮箱是否已被注册
		if(!registerService.isUserExists(email)){
			json.put("retCode",  WebConstants.RETURN_FAIL_CODE);
			json.put("retMsg",  ErrorMessage.EMAIL_IS_NOT_REGISTED);
			json.put("result",  "该邮箱未被注册，发送失败！");
			return json;
		}
		if(userService.sendPassword(email)){
			logger.info("用户密码发送成功........");
			json.put("retCode",  WebConstants.RETURN_SUCCESS_CODE);
			json.put("retMsg",  WebConstants.RETURN_SUCCESS_MSG);
		}else{
			logger.warn("用户密码发送失败........");
			json.put("retCode",  WebConstants.RETURN_FAIL_CODE);
			json.put("retMsg",  WebConstants.RETURN_FAIL_MSG);
		}
		return json;
	}
}
