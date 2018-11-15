package com.zebra.zebraerp.biz.service;

import java.util.List;


import com.zebra.zebraerp.dal.dataobject.ErpManagerDO;
import com.zebra.zebraerp.dal.dataobject.businessObject.ManagerLoginBO;

/**
 * erp管理员表Service
 *
 * @ClassName: ErpManagerService
 * @Description: by CodeGenerate
 * @author 
 * 
 */
public interface ErpManagerService {

	ManagerLoginBO erpManagerLogin(String phone, String password);

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	 ErpManagerDO queryErpManagerById(long id);

	/**
	 * 分页查询
	 * 
	 * @param erpManagerDO
	 * @return
	 */
	 List<ErpManagerDO> queryErpManagerByPage(ErpManagerDO erpManagerDO);
	
	/**
	 * 查询列表
	 * 
	 * @param erpManagerDO
	 * @return
	 */
	 List<ErpManagerDO> queryErpManagerList(ErpManagerDO erpManagerDO);

	/**
	 * 创建
	 * 
	 * @param erpManagerDO
	 * @return
	 */
	void createErpManager(ErpManagerDO erpManagerDO);

	/**
	 * 修改
	 * 
	 * @param erpManagerDO
	 * @return
	 */
	 int modifyErpManager(ErpManagerDO erpManagerDO);

	/**
	 * 选择性修改
	 * 
	 * @param erpManagerDO
	 * @return
	 */
	  int modifyErpManagerSelective(ErpManagerDO erpManagerDO);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	 int removeErpManager(long id);

	 int deleteByFranchiserCode(String franchiserCode);
	
}