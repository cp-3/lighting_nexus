package com.lighting.front.biz.dao;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.lighting.front.biz.util.IdUtils;
import com.lighting.front.dto.RegisterInfosDTO;
import com.paic.pafa.biz.dao.BaseDAO;

/**
 * @desc 会员注册DAO
 * @author ganchungen
 * @since 2014-09-26
 */
@Service("registerDao")
public class RegisterDao extends BaseDAO{

	/**
	 * @desc会员注册接口
	 * @param regMap
	 * @return boolean
	 */
	public boolean register(RegisterInfosDTO dto){
		logger.info("进入RegisterDaoImpl的register()方法...........");
		HashMap<String,Object> condition = new HashMap<String,Object>();
		condition.put("userId", dto.getUserId());
		condition.put("email", dto.geteMail());
		condition.put("password", dto.getPassword());
		condition.put("usertype", dto.getUserType());
		condition.put("status", dto.getStatus());
		condition.put("deviceId", dto.getDeviceId());
		condition.put("token", dto.getToken());
		logger.info("condition==:"+condition);
		HashMap<String, Object> retMap = this._insert("light-regist", condition);
		logger.info("retMap---->"+retMap);
		return true;
	}

	/**
	 * @desc 会员注册email验证接口
	 * @param String email
	 * @return boolean
	 */
	@SuppressWarnings({ "unchecked" })
	public String queryByEmail(String email){
		Object obj =  this._queryForObject("query-by-email", email);
		HashMap<String,String> resultMap = (HashMap<String,String>)obj;
		logger.info("resultMap==="+resultMap);
		if(null==resultMap)
			return "";
		else
			return (String) resultMap.get("email");
	}
	
	/**
	 * @desc 注册激活key存储
	 * @param String
	 * @return boolean
	 */
	public boolean insertJihuoKey(String key, String email){
		logger.info("进入RegisterDaoImpl的insertJihuoKey()方法...........");
		HashMap<String,Object> condition = new HashMap<String,Object>();
		condition.put("id", IdUtils.getUUID());
		condition.put("email", email);
		condition.put("keyvalue", key);
		condition.put("status", "0");
		logger.info("condition==:"+condition);
		HashMap<String, Object> retMap = this._insert("light-regist-key-insert", condition);
		logger.info("retMap---->"+retMap);
		return true;
	}

	/**
	 * @desc 查询激活key是否存在
	 * @param String key
	 * @return boolean
	 */
	@SuppressWarnings({ "unchecked" })
	public String queryByKey(String key){
		Object obj =  this._queryForObject("query-by-key", key);
		HashMap<String,String> resultMap = (HashMap<String,String>)obj;
		logger.info("resultMap==="+resultMap);
		if(null==resultMap)
			return "";
		else
			return (String) resultMap.get("keyvalue");
	}
	
	/**
	 * @desc 会员注册激活
	 * @param String key
	 * @return boolean
	 */
	public boolean jihuo(String key){
		int code1 =  this._update("regist-key-jihuo", key);
		int code2 =  this._update("regist-jihuo", key);
		logger.info("code1==="+code1 + " || code2==="+code2);
		if(code1>0 && code2>0)
			return true;
		else 
			return false;
	}
}
