package com.zebra.zebraerp.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zebra.zebraerp.dal.dataobject.FranchiserBaseDO;

/**
 * 加盟商基础信息表MAPPER
 * 
 * @ClassName: FranchiserBaseMapper
 * @Description: by CodeGenerate
 * @author 
 * 
 */

public interface FranchiserBaseMapper {

	/** 添加 */
	 int insertFranchiserBase(FranchiserBaseDO franchiserBaseDO);

	/** 根据主键查询 */
	 FranchiserBaseDO selectFranchiserBaseById(String franchiserCode);

	/** 根据账号查询 */
	 FranchiserBaseDO selectFranchiserBaseByPhone(String phone);

	/** 根据账号查询 */
	FranchiserBaseDO selectFranchiserBaseByName(String name);

	/** 查询列表 */
	 List<FranchiserBaseDO> selectFranchiserBaseList(FranchiserBaseDO franchiserBaseDO);
	
	/** 分页计数 */
	 int selectFranchiserBaseCount(FranchiserBaseDO franchiserBaseDO);
	
	/** 分页查找 */
	 List<FranchiserBaseDO> selectFranchiserBasePage(FranchiserBaseDO franchiserBaseDO);

	/** 完全修改 */
	 int updateFranchiserBase(FranchiserBaseDO franchiserBaseDO);

	/** 选择性修改 */
	 int updateFranchiserBaseSelective(FranchiserBaseDO franchiserBaseDO);

	/** 删除 */
	 int deleteFranchiserBase(String franchiserCode);
}