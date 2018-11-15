package com.zebra.zebraerp.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zebra.zebraerp.dal.dataobject.WalletDO;

/**
 * 用户钱包表MAPPER
 * 
 * @ClassName: WalletMapper
 * @Description: by CodeGenerate
 * @author 
 * 
 */

public interface WalletMapper {

	/** 添加 */
	public int insertWallet(WalletDO walletDO);

	/** 根据主键查询 */
	public WalletDO selectWalletById(Long uid);

	/** 查询列表 */
	public List<WalletDO> selectWalletList(WalletDO walletDO);
	
	/** 分页计数 */
	public int selectWalletCount(WalletDO walletDO);
	
	/** 分页查找 */
	public List<WalletDO> selectWalletPage(WalletDO walletDO);

	/** 完全修改 */
	public int updateWallet(WalletDO walletDO);

	/** 选择性修改 */
	public int updateWalletSelective(WalletDO walletDO);

	/** 删除 */
	public int deleteWallet(Long uid);
}