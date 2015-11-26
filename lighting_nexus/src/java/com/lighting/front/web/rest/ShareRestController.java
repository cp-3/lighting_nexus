package com.lighting.front.web.rest;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lighting.front.biz.service.ShareService;
import com.lighting.front.biz.util.IdUtils;
import com.lighting.front.dto.CollectProductInfoDTO;
import com.lighting.front.dto.ShareDownloadRecordInfoDTO;
import com.lighting.front.dto.ShareInfoDTO;
import com.lighting.front.web.constants.WebConstants;
import com.paic.pafa.web.BaseRest;

/**
 * @DESC 分享功能
 * @author Bill
 * @createtime: 2015年5月8日
 */
@Controller
@RequestMapping(value = "/light")
public class ShareRestController extends BaseRest {
	protected Log logger = LogFactory.getLog(ShareRestController.class);
	@Autowired
	private ShareService shareService;
	
	/**
	 * @desc 分享收藏产品信息，可以一次分享多个收藏产品 
	 * @param userId 用户ID
	 * @param collectIds 收藏产品信息id串，逗号分隔
	 * @return HashMap
	 */
	@RequestMapping(value = "/share-collect-infos")
	public HashMap<String,Object> shareCollectInfos(@RequestParam(value = "userId", required = true) String userId,
			  									    @RequestParam(value = "collectIds", required = true) String collectIds) {
		logger.info("进入ShareRestController的shareCollectInfos方法............");
		ShareInfoDTO dto = new ShareInfoDTO();
		dto.setCollectIds(collectIds);
		dto.setId(IdUtils.getUUID());
		dto.setUserId(userId);
		dto.setState("1");//状态：0--无效，1--有效
		logger.info("ShareInfoDTO=="+dto);
		HashMap<String,Object> json = new HashMap<String,Object>();
		String shareCode = shareService.shareCollectInfos(dto);
		json.put("shareCode",  shareCode);
		json.put("retCode",  WebConstants.RETURN_SUCCESS_CODE);
		json.put("retMsg",  WebConstants.RETURN_SUCCESS_MSG);
		return json;
	}
	
	/**
	 * @desc 下载分享 
	 * @param shareCode 用户分享码
	 * @return HashMap
	 */
	@RequestMapping(value = "/share-collect-download")
	public HashMap<String,Object> shareCollectDownLoad(@RequestParam(value = "userId", required = true) String userId,
													   @RequestParam(value = "email", required = true) String email,
													   @RequestParam(value = "shareCode", required = true) String shareCode) {
		logger.info("进入ShareRestController的shareCollectDownLoad方法............shareCode=="+shareCode);
		HashMap<String,Object> json = new HashMap<String,Object>();
		ShareInfoDTO dto = new ShareInfoDTO();
		dto.setUserId(userId);
		dto.setShareCode(shareCode);
		dto.setEmail(email);
		logger.info("ShareInfoDTO=="+dto);
		List<CollectProductInfoDTO> downLoadList = shareService.shareCollectDownLoad(dto);
		if(null==downLoadList || downLoadList.size()==0){
			json.put("retCode",  WebConstants.RETURN_FAIL_CODE);
			json.put("retMsg",  "分享码不存在或者该分享已被取消。");
		}else{
			json.put("downLoadInfoList",  downLoadList);
			json.put("retCode",  WebConstants.RETURN_SUCCESS_CODE);
			json.put("retMsg",  WebConstants.RETURN_SUCCESS_MSG);
		}
		
		return json;
	}
	
	/**
	 * @desc 查询下载分享记录信息列表 
	 * @param userId 用户ID
	 * @return HashMap
	 */
	@RequestMapping(value = "/qry-share-download-infos")
	public HashMap<String,Object> qryShareInfos(@RequestParam(value = "userId", required = true) String userId) {
		logger.info("进入ShareRestController的shareCollectDownLoad方法............userId=="+userId);
		HashMap<String,Object> json = new HashMap<String,Object>();
		List<ShareDownloadRecordInfoDTO> downLoadList = shareService.qryShareDownLoadRecordInfos(userId);
		json.put("downLoadRecordList",  downLoadList);
		json.put("retCode",  WebConstants.RETURN_SUCCESS_CODE);
		json.put("retMsg",  WebConstants.RETURN_SUCCESS_MSG);
		return json;
	}
	
	/**
	 * @desc 取消分享 
	 * @param userId 用户ID
	 * @param shareCode 用户分享码
	 * @return HashMap
	 */
	@RequestMapping(value = "/cancel-share")
	public HashMap<String,Object> cancelShare(@RequestParam(value = "userId", required = true) String userId,
										      @RequestParam(value = "shareCode", required = true) String shareCode) {
		logger.info("进入ShareRestController的cancelShare方法............");
		HashMap<String,Object> json = new HashMap<String,Object>();
		ShareInfoDTO dto = new ShareInfoDTO();
		dto.setUserId(userId);
		dto.setShareCode(shareCode);
		dto.setState("0");//状态：0--无效，1--有效
		logger.info("ShareInfoDTO=="+dto);
		if(shareService.cancelShare(dto)){
			json.put("retCode",  WebConstants.RETURN_SUCCESS_CODE);
			json.put("retMsg",  WebConstants.RETURN_SUCCESS_MSG);
		}else{
			json.put("retCode",  WebConstants.RETURN_FAIL_CODE);
			json.put("retMsg",  WebConstants.RETURN_FAIL_MSG);
		}
		return json;
	}
	
}
