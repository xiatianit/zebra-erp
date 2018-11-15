package com.zebra.zebraerp.biz.service;

import java.util.List;


import com.zebra.zebraerp.dal.dataobject.WalletDO;

/**
 * 用户钱包表Service
 *
 * @ClassName: WalletService
 * @Description: by CodeGenerate
 * @author 
 * 
 */
public interface WalletService {

	/**
	 * 根据id查询
	 * 
	 * @param uid
	 * @return
	 */
	 WalletDO queryWalletById(long uid);

	/**
	 * 分页查询
	 * 
	 * @param walletDO
	 * @return
	 */
	 List<WalletDO> queryWalletByPage(WalletDO walletDO);
	
	/**
	 * 查询列表
	 * 
	 * @param walletDO
	 * @return
	 */
	 List<WalletDO> queryWalletList(WalletDO walletDO);

	/**
	 * 创建
	 * 
	 * @param walletDO
	 * @return
	 */
	 void createWallet(WalletDO walletDO);

	/**
	 * 修改
	 * 
	 * @param walletDO
	 * @return
	 */
	 int modifyWallet(WalletDO walletDO);

	/**
	 * 选择性修改
	 * 
	 * @param walletDO
	 * @return
	 */
	  int modifyWalletSelective(WalletDO walletDO);

	/**
	 * 删除
	 * 
	 * @param uid
	 * @return
	 */
	 int removeWallet(long uid);
	
}