package com.zebra.zebraerp.biz.service;

import java.util.List;


import com.zebra.zebraerp.dal.dataobject.ZoneDO;

/**
 * 区域信息表Service
 *
 * @ClassName: ZoneService
 * @Description: by CodeGenerate
 * @author 
 * 
 */
public interface ZoneService {

	/**
	 * 根据id查询
	 * 
	 * @param zoneCode
	 * @return
	 */
	 ZoneDO queryZoneById(String zoneCode);

	/**
	 * 分页查询
	 * 
	 * @param zoneDO
	 * @return
	 */
	 List<ZoneDO> queryZoneByPage(ZoneDO zoneDO);
	
	/**
	 * 查询列表
	 * 
	 * @param zoneDO
	 * @return
	 */
	 List<ZoneDO> queryZoneList(ZoneDO zoneDO);

	/**
	 * 创建
	 * 
	 * @param zoneDO
	 * @return
	 */
	 void createZone(ZoneDO zoneDO);

	/**
	 * 修改
	 * 
	 * @param zoneDO
	 * @return
	 */
	 int modifyZone(ZoneDO zoneDO);

	/**
	 * 选择性修改
	 * 
	 * @param zoneDO
	 * @return
	 */
	  int modifyZoneSelective(ZoneDO zoneDO);

	/**
	 * 删除
	 * 
	 * @param zoneCode
	 * @return
	 */
	 int removeZone(String zoneCode);
	
}