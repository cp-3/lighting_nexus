package com.lighting.front.biz.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lighting.front.biz.util.IdUtils;
import com.lighting.front.dto.ShareDownloadRecordInfoDTO;
import com.lighting.front.dto.ShareInfoDTO;
import com.paic.pafa.biz.dao.BaseDAO;

/**
 * @desc 分享收藏信息DAO
 * @author ganchungen
 * @since 2014-09-26
 */
@Service("shareDao")
public class ShareDao extends BaseDAO{

	/**
	 * @desc查询分享码
	 * @param String
	 * @return String
	 */
	public String qryShareCode(String ShareCode){
		logger.info("进入ShareDao的qryShareCode()方法...........");
		return this._getString("select-share-code", ShareCode);
	}
	
	/**
	 * @desc新增分享码信息
	 * @param ShareInfoDTO
	 * @return boolean
	 */
	public boolean addShareCodeInfo(ShareInfoDTO dto){
		logger.info("进入ShareDao的addShareCodeInfo()方法...........");
		ShareInfoDTO shareInfo = this._insert("add-share-code-info", dto);
		logger.info("ShareInfoDTO---->"+shareInfo);
		return true;
	}
	
	/**
	 * @desc新增分享下载记录信息
	 * @param ShareInfoDTO
	 * @return boolean
	 */
	public void addShareDownloadRecordInfo(String shareCode, String email, String userId){
		logger.info("进入ShareDao的addShareDownloadRecordInfo()方法...........");
		HashMap<String,String> condition = new HashMap<String,String>();
		condition.put("id", IdUtils.getUUID());
		condition.put("userId", userId);
		condition.put("shareCode", shareCode);
		condition.put("userName", email);
		logger.info("condition=="+condition);
		this._insert("add-share-download-record", condition);
	}
	
	/**
	 * @desc查询分享信息
	 * @param String
	 * @return ShareInfoDTO
	 */
	public ShareInfoDTO qryShareCodeInfo(ShareInfoDTO dto){
		logger.info("进入ShareDao的qryShareCodeInfo()方法...........");
		dto.setState("1");
		ShareInfoDTO shareInfo = (ShareInfoDTO) this._getObject("qry-share-info", dto);
		logger.info("ShareInfoDTO=="+shareInfo);
		return shareInfo;
	}
	
	/**
	 * @desc查询分享信息列表
	 * @param String
	 * @return List<ShareDownloadRecordInfoDTO>
	 */
	@SuppressWarnings("unchecked")
	public List<ShareDownloadRecordInfoDTO> qryShareDownLoadRecordInfos(String userId){
		logger.info("进入ShareDao的qryShareCodeInfo()方法...........");
		List<ShareDownloadRecordInfoDTO> recordList = (List<ShareDownloadRecordInfoDTO>) this._list("qry-share-download-record-infos", userId);
		logger.info("recordList=="+recordList);
		return recordList;
	}
	
	/**
	 * @desc查询分享信息
	 * @param String
	 * @return List<ShareDownloadRecordInfoDTO>
	 */
	public int qryShareDownLoadRecordInfo(String userId, String shareCode){
		logger.info("进入ShareDao的qryShareCodeInfo()方法...........");
		HashMap<String,String> condition = new HashMap<String,String>();
		condition.put("userId", userId);
		condition.put("shareCode", shareCode);
		logger.info("condition=="+condition);
		int count = this._getInt("qry-share-download-record-info", condition);
		logger.info("count=="+count);
		return count;
	}
	
	/**
	 * @desc取消分享码信息
	 * @param ShareInfoDTO 
	 * @return boolean
	 */
	public boolean cancelShare(ShareInfoDTO dto){
		logger.info("进入ShareDao的cancelShare()方法...........");
		int code = this._update("cancel-share-info", dto);
		logger.info("code---->"+code);
		if(code>0)
			return true;
		else
			return false;
	}
}
