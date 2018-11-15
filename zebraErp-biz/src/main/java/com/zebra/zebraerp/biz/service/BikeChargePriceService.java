package com.zebra.zebraerp.biz.service;

import java.util.List;


import com.zebra.zebraerp.dal.dataobject.BikeChargePriceDO;

/**
 * 单车定价表Service
 *
 * @ClassName: BikeChargePriceService
 * @Description: by CodeGenerate
 * @author 
 * 
 */
public interface BikeChargePriceService {

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	 BikeChargePriceDO queryBikeChargePriceById(long id);

	/**
	 * 分页查询
	 * 
	 * @param bikeChargePriceDO
	 * @return
	 */
	 List<BikeChargePriceDO> queryBikeChargePriceByPage(BikeChargePriceDO bikeChargePriceDO);
	
	/**
	 * 查询列表
	 * 
	 * @param bikeChargePriceDO
	 * @return
	 */
	 List<BikeChargePriceDO> queryBikeChargePriceList(BikeChargePriceDO bikeChargePriceDO);

	/**
	 * 创建
	 * 
	 * @param bikeChargePriceDO
	 * @return
	 */
	 void createBikeChargePrice(BikeChargePriceDO bikeChargePriceDO);

	/**
	 * 修改
	 * 
	 * @param bikeChargePriceDO
	 * @return
	 */
	 int modifyBikeChargePrice(BikeChargePriceDO bikeChargePriceDO);

	/**
	 * 选择性修改
	 * 
	 * @param bikeChargePriceDO
	 * @return
	 */
	  int modifyBikeChargePriceSelective(BikeChargePriceDO bikeChargePriceDO);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	 int removeBikeChargePrice(long id);
	
}