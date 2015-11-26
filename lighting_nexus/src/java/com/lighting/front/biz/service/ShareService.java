package com.lighting.front.biz.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lighting.front.biz.dao.CollectDao;
import com.lighting.front.biz.dao.ShareDao;
import com.lighting.front.dto.CollectProductInfoDTO;
import com.lighting.front.dto.ShareDownloadRecordInfoDTO;
import com.lighting.front.dto.ShareInfoDTO;
import com.lighting.front.util.ValidateCodeUtils;

/**
 * @desc 分享收藏信息service
 * @author ganchungen
 * @since 2014-09-26
 */
@Service("shareService")
public class ShareService{
	protected Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	private ShareDao shareDao;
	@Autowired
	private CollectDao collectDao;
	
	/**
	 * @desc 获取品牌信息列表
	 * @param null
	 * @return List<BrandInfoDTO>
	 */
	public String shareCollectInfos(ShareInfoDTO dto){
		logger.info("进入ShareService的ShareInfoDTO方法。。。。。。");
		boolean bool = true;
		String sc = ValidateCodeUtils.getValidateCode(ValidateCodeUtils.OTHER_TYPE, 11, 15);
		String shareCode = "";
		while(bool){
			shareCode =  shareDao.qryShareCode(sc);
			if(null==shareCode || "".equals(shareCode)){
				logger.info("分享码【"+sc+"】可以使用");
				shareCode = sc;
				bool = false;
			}else{
				logger.info("分享码【"+shareCode+"】已存在！，重新生成......");
				sc = ValidateCodeUtils.getValidateCode(ValidateCodeUtils.OTHER_TYPE, 11, 15);
			}
		}
		logger.info("shareCode=="+shareCode);
		dto.setShareCode(shareCode);
		if(shareDao.addShareCodeInfo(dto))
			return shareCode;
		else
			return "";
	}
	
	/**
	 * @desc 下载分享信息
	 * =======================================================
	 * 1.查询分享信息
	 * 2.根据收藏id串，查询出收藏信息
	 * 3.将收藏信息导入到该用户的收藏中
	 * 4.记录下载信息
	 * 5.返回分享码中收藏信息列表
	 * 注：步骤2和3通过循环实现
	 * =======================================================
	 * @param ShareInfoDTO
	 * @return List<BrandInfoDTO>
	 */
	public List<CollectProductInfoDTO> shareCollectDownLoad(ShareInfoDTO dto){
		logger.info("进入ShareService的shareCollectDownLoad方法。。。。。。");
		List<CollectProductInfoDTO> list = new ArrayList<CollectProductInfoDTO>();
		ShareInfoDTO shareInfo = shareDao.qryShareCodeInfo(dto);
		logger.info("ShareInfoDTO=="+shareInfo);
		if(null!=shareInfo){
			String[] collectids = shareInfo.getCollectIds().split("#");
			logger.info("collectids=="+collectids);
			for(int i=0; i<collectids.length; i++){
				CollectProductInfoDTO collectInfo = collectDao.queryCollectInfo(collectids[i]);
				if(null!=collectInfo){
					collectInfo.setUserId(dto.getUserId());
					collectInfo.setCollectId(dto.getUserId()+collectInfo.getProductId());
					list.add(collectInfo);
					try{
						collectDao.collectProduct(collectInfo);
					}catch(Exception e){
						logger.warn(collectInfo.getCollectId()+"该收藏信息用户已存在。");
					}
				}
			}
			
			if(list.size()>0){
				try{
					if(shareDao.qryShareDownLoadRecordInfo(dto.getUserId(), dto.getShareCode())>0){
						logger.info("下载分享记录已存在，无需记录.");
					}else{
						shareDao.addShareDownloadRecordInfo(dto.getShareCode(), dto.getEmail(), dto.getUserId());
					}
				}catch(Exception e){
					logger.warn(e.getMessage(),e);
					logger.warn("下载信息记录已存在!");
				}
			}
		}
		return list;
	}
	
	/**
	 * @desc 查询分享下载记录信息列表
	 * @param userId
	 * @return List<ShareDownloadRecordInfoDTO>
	 */
	public List<ShareDownloadRecordInfoDTO> qryShareDownLoadRecordInfos(String userId){
		logger.info("进入ShareService的qryShareDownLoadRecordInfos方法。。。。。。");
		return shareDao.qryShareDownLoadRecordInfos(userId);
	}
	
	/**
	 * @desc 取消分享
	 * @param userId
	 * @param shareCode
	 * @return List<ShareDownloadRecordInfoDTO>
	 */
	public boolean cancelShare(ShareInfoDTO dto){
		logger.info("进入ShareService的cancelShare方法。。。。。。");
		return shareDao.cancelShare(dto);
	}
}