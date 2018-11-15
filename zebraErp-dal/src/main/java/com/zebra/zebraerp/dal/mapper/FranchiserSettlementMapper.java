package com.zebra.zebraerp.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zebra.zebraerp.dal.dataobject.FranchiserSettlementDO;

/**
 * 加盟商结算申请表MAPPER
 * 
 * @ClassName: FranchiserSettlementMapper
 * @Description: by CodeGenerate
 * @author 
 * 
 */

public interface FranchiserSettlementMapper {

	/** 添加 */
	void insertFranchiserSettlement(FranchiserSettlementDO franchiserSettlementDO);

	/** 根据主键查询 */
	public FranchiserSettlementDO selectFranchiserSettlementById(Long id);

	/** 查询列表 */
	public List<FranchiserSettlementDO> selectFranchiserSettlementList(FranchiserSettlementDO franchiserSettlementDO);
	
	/** 分页计数 */
	public int selectFranchiserSettlementCount(FranchiserSettlementDO franchiserSettlementDO);
	
	/** 分页查找 */
	public List<FranchiserSettlementDO> selectFranchiserSettlementPage(FranchiserSettlementDO franchiserSettlementDO);

	/** 完全修改 */
	public int updateFranchiserSettlement(FranchiserSettlementDO franchiserSettlementDO);

	/** 选择性修改 */
	public int updateFranchiserSettlementSelective(FranchiserSettlementDO franchiserSettlementDO);

	/** 删除 */
	public int deleteFranchiserSettlement(Long id);
}