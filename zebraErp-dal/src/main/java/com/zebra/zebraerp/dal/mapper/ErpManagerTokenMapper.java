package com.zebra.zebraerp.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zebra.zebraerp.dal.dataobject.ErpManagerTokenDO;

/**
 * erp管理员token表MAPPER
 * 
 * @ClassName: ErpManagerTokenMapper
 * @Description: by CodeGenerate
 * @author 
 * 
 */

public interface ErpManagerTokenMapper {

	/** 添加 */
	public int insertErpManagerToken(ErpManagerTokenDO erpManagerTokenDO);

	/** 根据主键查询 */
	public ErpManagerTokenDO selectErpManagerTokenById(Long id);

	/** 根据token查询 */
	 ErpManagerTokenDO selectErpManagerTokenByToken(String token);

	/** 根据managerId查询 */
	 ErpManagerTokenDO selectErpManagerTokenByManagerId(Long managerId);

	/** 查询列表 */
	public List<ErpManagerTokenDO> selectErpManagerTokenList(ErpManagerTokenDO erpManagerTokenDO);
	
	/** 分页计数 */
	public int selectErpManagerTokenCount(ErpManagerTokenDO erpManagerTokenDO);
	
	/** 分页查找 */
	public List<ErpManagerTokenDO> selectErpManagerTokenPage(ErpManagerTokenDO erpManagerTokenDO);

	/** 完全修改 */
	public int updateErpManagerToken(ErpManagerTokenDO erpManagerTokenDO);

	/** 选择性修改 */
	public int updateErpManagerTokenSelective(ErpManagerTokenDO erpManagerTokenDO);

	/** 删除 */
	public int deleteErpManagerToken(Long id);
}