package com.zebra.zebraerp.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zebra.zebraerp.dal.dataobject.BikeModelDO;

/**
 * 单车类型表MAPPER
 * 
 * @ClassName: BikeModelMapper
 * @Description: by CodeGenerate
 * @author 
 * 
 */

public interface BikeModelMapper {

	/** 添加 */
	public int insertBikeModel(BikeModelDO bikeModelDO);

	/** 根据主键查询 */
	public BikeModelDO selectBikeModelById(Long id);

	/** 查询列表 */
	public List<BikeModelDO> selectBikeModelList(BikeModelDO bikeModelDO);
	
	/** 分页计数 */
	public int selectBikeModelCount(BikeModelDO bikeModelDO);
	
	/** 分页查找 */
	public List<BikeModelDO> selectBikeModelPage(BikeModelDO bikeModelDO);

	/** 完全修改 */
	public int updateBikeModel(BikeModelDO bikeModelDO);

	/** 选择性修改 */
	public int updateBikeModelSelective(BikeModelDO bikeModelDO);

	/** 删除 */
	public int deleteBikeModel(Long id);
}