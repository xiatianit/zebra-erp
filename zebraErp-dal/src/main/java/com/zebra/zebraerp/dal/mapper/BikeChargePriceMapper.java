package com.zebra.zebraerp.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zebra.zebraerp.dal.dataobject.BikeChargePriceDO;

/**
 * 单车定价表MAPPER
 * 
 * @ClassName: BikeChargePriceMapper
 * @Description: by CodeGenerate
 * @author 
 * 
 */

public interface BikeChargePriceMapper {

	/** 添加 */
	public int insertBikeChargePrice(BikeChargePriceDO bikeChargePriceDO);

	/** 根据主键查询 */
	public BikeChargePriceDO selectBikeChargePriceById(Long id);

	/** 查询列表 */
	public List<BikeChargePriceDO> selectBikeChargePriceList(BikeChargePriceDO bikeChargePriceDO);
	
	/** 分页计数 */
	public int selectBikeChargePriceCount(BikeChargePriceDO bikeChargePriceDO);
	
	/** 分页查找 */
	public List<BikeChargePriceDO> selectBikeChargePricePage(BikeChargePriceDO bikeChargePriceDO);

	/** 完全修改 */
	public int updateBikeChargePrice(BikeChargePriceDO bikeChargePriceDO);

	/** 选择性修改 */
	public int updateBikeChargePriceSelective(BikeChargePriceDO bikeChargePriceDO);

	/** 删除 */
	public int deleteBikeChargePrice(Long id);
}