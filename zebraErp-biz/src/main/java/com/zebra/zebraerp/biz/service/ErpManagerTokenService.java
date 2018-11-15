package com.zebra.zebraerp.biz.service;

import java.util.List;


import com.zebra.zebraerp.dal.dataobject.ErpManagerTokenDO;

/**
 * erp管理员token表Service
 *
 * @ClassName: ErpManagerTokenService
 * @Description: by CodeGenerate
 * @author 
 * 
 */
public interface ErpManagerTokenService {

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	 ErpManagerTokenDO queryErpManagerTokenById(long id);

	/**
	 * 根据token查询
	 *
	 * @param token
	 * @return
	 */
	ErpManagerTokenDO queryErpManagerTokenByToken(String token);

	/**
	 * 根据managerId查询
	 *
	 * @param managerId
	 * @return
	 */
	ErpManagerTokenDO queryErpManagerTokenByManagerId(long managerId);

	/**
	 * 分页查询
	 * 
	 * @param erpManagerTokenDO
	 * @return
	 */
	 List<ErpManagerTokenDO> queryErpManagerTokenByPage(ErpManagerTokenDO erpManagerTokenDO);
	
	/**
	 * 查询列表
	 * 
	 * @param erpManagerTokenDO
	 * @return
	 */
	 List<ErpManagerTokenDO> queryErpManagerTokenList(ErpManagerTokenDO erpManagerTokenDO);

	/**
	 * 创建
	 * 
	 * @param erpManagerTokenDO
	 * @return
	 */
	 void createErpManagerToken(ErpManagerTokenDO erpManagerTokenDO);

	/**
	 * 修改
	 * 
	 * @param erpManagerTokenDO
	 * @return
	 */
	 int modifyErpManagerToken(ErpManagerTokenDO erpManagerTokenDO);

	/**
	 * 选择性修改
	 * 
	 * @param erpManagerTokenDO
	 * @return
	 */
	  int modifyErpManagerTokenSelective(ErpManagerTokenDO erpManagerTokenDO);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	 int removeErpManagerToken(long id);
	
}