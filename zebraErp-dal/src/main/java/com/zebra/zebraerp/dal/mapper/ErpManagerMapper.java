package com.zebra.zebraerp.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zebra.zebraerp.dal.dataobject.ErpManagerDO;

/**
 * erp管理员表MAPPER
 * 
 * @ClassName: ErpManagerMapper
 * @Description: by CodeGenerate
 * @author 
 * 
 */

public interface ErpManagerMapper {

	/** 添加 */
	void insertErpManager(ErpManagerDO erpManagerDO);

	/** 根据主键查询 */
	 ErpManagerDO selectErpManagerById(Long id);

	/** 查询列表 */
	List<ErpManagerDO> selectErpManagerList(ErpManagerDO erpManagerDO);
	
	/** 分页计数 */
	 int selectErpManagerCount(ErpManagerDO erpManagerDO);
	
	/** 分页查找 */
	 List<ErpManagerDO> selectErpManagerPage(ErpManagerDO erpManagerDO);

	/** 完全修改 */
	 int updateErpManager(ErpManagerDO erpManagerDO);

	/** 选择性修改 */
	 int updateErpManagerSelective(ErpManagerDO erpManagerDO);

	/** 删除 */
	 int deleteErpManager(Long id);

	 int deleteByFranchiserCode(String franchiserCode);
}