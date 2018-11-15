package com.zebra.zebraerp.biz.service;

import java.util.List;


import com.zebra.zebraerp.dal.dataobject.CityDO;

/**
 * 城市信息表Service
 *
 * @ClassName: CityService
 * @Description: by CodeGenerate
 * @author 
 * 
 */
public interface CityService {

	/**
	 * 根据id查询
	 * 
	 * @param cityCode
	 * @return
	 */
	 CityDO queryCityById(String cityCode);

	/**
	 * 分页查询
	 * 
	 * @param cityDO
	 * @return
	 */
	 List<CityDO> queryCityByPage(CityDO cityDO);
	
	/**
	 * 查询列表
	 * 
	 * @param cityDO
	 * @return
	 */
	 List<CityDO> queryCityList(CityDO cityDO);

	/**
	 * 创建
	 * 
	 * @param cityDO
	 * @return
	 */
	 void createCity(CityDO cityDO);

	/**
	 * 修改
	 * 
	 * @param cityDO
	 * @return
	 */
	 int modifyCity(CityDO cityDO);

	/**
	 * 选择性修改
	 * 
	 * @param cityDO
	 * @return
	 */
	  int modifyCitySelective(CityDO cityDO);

	/**
	 * 删除
	 * 
	 * @param cityCode
	 * @return
	 */
	 int removeCity(String cityCode);
	
}