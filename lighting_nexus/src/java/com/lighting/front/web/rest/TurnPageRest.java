package com.lighting.front.web.rest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lighting.front.web.constants.WebConstants;
import com.paic.pafa.web.BaseController;

/**
 * 
 * @desc 
 * @author ganchungen
 * @since2014-10-29
 */
//@Controller
public class TurnPageRest extends BaseController {
	protected Log logger = LogFactory.getLog(this.getClass());

	@RequestMapping(value="/turnPage.do")
	public String turnPage( @RequestParam(value = "username", required = false) String username,
							@RequestParam(value = "currentpage", required = false) String currentpage,
							ModelMap model) throws JSONException{
		logger.info("进入turnPage........................."+currentpage);
		logger.info("username is: "+username);
//		List<MyCoinInfosDTO> list = new ArrayList<MyCoinInfosDTO>();
		int num = Integer.parseInt(currentpage);
//		for(int i=0;i<10;i++){
//			MyCoinInfosDTO coinInfo = new MyCoinInfosDTO();
//			coinInfo.setCoinCout(num*10+i);
//			list.add(coinInfo);
//		}
//		logger.info("------>"+list);
//		UserInfosInSessionDTO userDto = userManagerService.qryUserBasicInfos(username);
//		if(null!=userDto){ 
//			logger.info("抱歉，用户名："+username+" 已被注册！！");
//			json.put("retCode",  WebConstants.RETURN_FAIL_CODE);//不可用返回001
//			json.put("retMsg", "抱歉，用户名："+username+" 已被注册！！");
//		}else{
//			logger.info("恭喜你，此用户名:"+username+" 可用！!");
//		model.put("result",  list);//可用返回000
//		model.put("currentpage",  currentpage);
//		model.put("totalCount",  list.size());
		model.put("retCode",  WebConstants.RETURN_SUCCESS_CODE);//可用返回000
		model.put("retMsg",  WebConstants.RETURN_SUCCESS_MSG);
//		}
		return "turnpageview";
	}

}
