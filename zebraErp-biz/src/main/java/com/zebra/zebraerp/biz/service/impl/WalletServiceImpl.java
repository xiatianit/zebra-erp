package com.zebra.zebraerp.biz.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zebra.zebraerp.dal.mapper.WalletMapper;
import com.zebra.zebraerp.dal.dataobject.WalletDO;
import com.zebra.zebraerp.biz.service.WalletService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @ClassName: WalletServiceImpl
 * @Description: by CodeGenerate
 * @author 
 * 
 */
@Service
@Transactional
public class WalletServiceImpl implements WalletService {

	 private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private WalletMapper masterWalletMapper;
    @Autowired
	private WalletMapper slaveWalletMapper;
	
	@Override
	public WalletDO queryWalletById(long uid) {

		WalletDO cWallet = this.slaveWalletMapper.selectWalletById(uid);
		return cWallet;		
	}

	@Override
	public List<WalletDO> queryWalletByPage(WalletDO walletDO) {

		List<WalletDO> list = this.slaveWalletMapper.selectWalletPage(walletDO);
		return list;
	}
	
	@Override
	public List<WalletDO> queryWalletList(WalletDO walletDO) {
		List<WalletDO> list = this.slaveWalletMapper.selectWalletList(walletDO);
		return list;
	}

	@Override
	public void createWallet(WalletDO walletDO) {
		this.masterWalletMapper.insertWallet(walletDO);
	}

	@Override
	public int modifyWallet(WalletDO walletDO) {
		int num = this.masterWalletMapper.updateWallet(walletDO);
		return num;
	}

	@Override
	public int modifyWalletSelective(WalletDO walletDO) {
		int num = this.masterWalletMapper.updateWalletSelective(walletDO);
		return num;
	}

	@Override
	public int removeWallet(long uid) {
		int num = this.masterWalletMapper.deleteWallet(uid);
		return num;
	}
	
}