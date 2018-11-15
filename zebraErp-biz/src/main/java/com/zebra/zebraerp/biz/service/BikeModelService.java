package com.zebra.zebraerp.biz.service;

import java.util.List;


import com.zebra.zebraerp.dal.dataobject.BikeModelDO;

/**
 * 单车类型表Service
 *
 * @ClassName: BikeModelService
 * @Description: by CodeGenerate
 * @author 
 * 
 */
public interface BikeModelService {

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	 BikeModelDO queryBikeModelById(long id);

	/**
	 * 分页查询
	 * 
	 * @param bikeModelDO
	 * @return
	 */
	 List<BikeModelDO> queryBikeModelByPage(BikeModelDO bikeModelDO);
	
	/**
	 * 查询列表
	 * 
	 * @param bikeModelDO
	 * @return
	 */
	 List<BikeModelDO> queryBikeModelList(BikeModelDO bikeModelDO);

	/**
	 * 创建
	 * 
	 * @param bikeModelDO
	 * @return
	 */
	 void createBikeModel(BikeModelDO bikeModelDO);

	/**
	 * 修改
	 * 
	 * @param bikeModelDO
	 * @return
	 */
	 int modifyBikeModel(BikeModelDO bikeModelDO);

	/**
	 * 选择性修改
	 * 
	 * @param bikeModelDO
	 * @return
	 */
	  int modifyBikeModelSelective(BikeModelDO bikeModelDO);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	 int removeBikeModel(long id);
	
}