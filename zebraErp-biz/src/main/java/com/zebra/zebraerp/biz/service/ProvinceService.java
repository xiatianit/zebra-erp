package com.zebra.zebraerp.biz.service;

import java.util.List;


import com.zebra.zebraerp.dal.dataobject.ProvinceDO;

/**
 * 省份信息表Service
 *
 * @ClassName: ProvinceService
 * @Description: by CodeGenerate
 * @author 
 * 
 */
public interface ProvinceService {

	/**
	 * 根据id查询
	 * 
	 * @param provinceCode
	 * @return
	 */
	 ProvinceDO queryProvinceById(String provinceCode);

	/**
	 * 分页查询
	 * 
	 * @param provinceDO
	 * @return
	 */
	 List<ProvinceDO> queryProvinceByPage(ProvinceDO provinceDO);
	
	/**
	 * 查询列表
	 * 
	 * @param provinceDO
	 * @return
	 */
	 List<ProvinceDO> queryProvinceList(ProvinceDO provinceDO);

	/**
	 * 创建
	 * 
	 * @param provinceDO
	 * @return
	 */
	 void createProvince(ProvinceDO provinceDO);

	/**
	 * 修改
	 * 
	 * @param provinceDO
	 * @return
	 */
	 int modifyProvince(ProvinceDO provinceDO);

	/**
	 * 选择性修改
	 * 
	 * @param provinceDO
	 * @return
	 */
	  int modifyProvinceSelective(ProvinceDO provinceDO);

	/**
	 * 删除
	 * 
	 * @param provinceCode
	 * @return
	 */
	 int removeProvince(String provinceCode);
	
}