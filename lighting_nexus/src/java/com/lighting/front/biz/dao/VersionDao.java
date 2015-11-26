package com.lighting.front.biz.dao;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.lighting.front.biz.util.IdUtils;
import com.paic.pafa.biz.dao.BaseDAO;

/**
 * @desc 版本DAO
 * @author ganchungen
 * @since 2014-10-08
 */
@Service("versionDao")
public class VersionDao extends BaseDAO {
	protected Log logger = LogFactory.getLog(this.getClass());
	

	public void addVerisonInfo(String email){
		logger.info("进入VersionDao的addVerisonInfo()方法...........");
		HashMap<String,Object> condition = new HashMap<String,Object>();
		condition.put("id", IdUtils.getUUID());
		condition.put("email", email);
		logger.info("condition==:"+condition);
		this._insert("version-info-insert", condition);
	}
	
	/**
	 * @desc 查询用户版本信息
	 * @param LoginInfoDTO
	 * @return boolean
	 */
	@SuppressWarnings("unchecked")
	public HashMap<String,Object> queryVersionInfoByEmail(String email){
		logger.info("email==:"+email);
		HashMap<String,Object> versionInfo = (HashMap<String, Object>) this._queryForObject("query-version-by-email", email);
		logger.info("versionInfo---->"+versionInfo);
		return versionInfo;
	}
	
	/**
	 * @desc 更新发现版本信息 
	 * @param null
	 * @return boolean
	 */
	public boolean updateD_versionInfo(){
		HashMap<String,Object> condition = new HashMap<String,Object>();
		int code = this._update("update-d-version-info", condition);
		logger.info("code---->" + code);
		return true;
	}
	
	/**
	 * @desc 更新报告版本信息 
	 * @param UserInfoDTO
	 * @return boolean
	 */
	public boolean updateR_versionInfo(String email){
		logger.info("开始进入VersionDao的updateR_versionInfo方法。。。。。。email="+email);
		HashMap<String,Object> condition = new HashMap<String,Object>();
		condition.put("email", email);
		int code = this._update("update-r-version-info", condition);
		logger.info("code---->" + code);
		return true;
	}
	
	/**
	 * @desc 更新报告版本信息 
	 * @param UserInfoDTO
	 * @return boolean
	 */
	public boolean updateB_versionInfo(){
		logger.info("开始进入VersionDao的updateB_versionInfo方法。。。。。。");
		HashMap<String,Object> condition = new HashMap<String,Object>();
		int code = this._update("update-b-version-info", condition);
		logger.info("code---->" + code);
		return true;
	}
}
