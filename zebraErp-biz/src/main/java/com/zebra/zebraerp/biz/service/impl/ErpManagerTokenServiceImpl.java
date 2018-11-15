package com.zebra.zebraerp.biz.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zebra.zebraerp.dal.mapper.ErpManagerTokenMapper;
import com.zebra.zebraerp.dal.dataobject.ErpManagerTokenDO;
import com.zebra.zebraerp.biz.service.ErpManagerTokenService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @ClassName: ErpManagerTokenServiceImpl
 * @Description: by CodeGenerate
 * @author 
 * 
 */
@Service
@Transactional
public class ErpManagerTokenServiceImpl implements ErpManagerTokenService {

	 private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ErpManagerTokenMapper masterErpManagerTokenMapper;
    @Autowired
	private ErpManagerTokenMapper slaveErpManagerTokenMapper;
	
	@Override
	public ErpManagerTokenDO queryErpManagerTokenById(long id) {

		ErpManagerTokenDO cErpManagerToken = this.slaveErpManagerTokenMapper.selectErpManagerTokenById(id);
		return cErpManagerToken;		
	}

	@Override
	public ErpManagerTokenDO queryErpManagerTokenByToken(String token) {
		ErpManagerTokenDO cErpManagerToken = this.slaveErpManagerTokenMapper.selectErpManagerTokenByToken(token);
		return cErpManagerToken;
	}

	@Override
	public ErpManagerTokenDO queryErpManagerTokenByManagerId(long managerId) {
		ErpManagerTokenDO cErpManagerToken = this.slaveErpManagerTokenMapper.selectErpManagerTokenByManagerId(managerId);
		return cErpManagerToken;
	}

	@Override
	public List<ErpManagerTokenDO> queryErpManagerTokenByPage(ErpManagerTokenDO erpManagerTokenDO) {

		List<ErpManagerTokenDO> list = this.slaveErpManagerTokenMapper.selectErpManagerTokenPage(erpManagerTokenDO);
		return list;
	}
	
	@Override
	public List<ErpManagerTokenDO> queryErpManagerTokenList(ErpManagerTokenDO erpManagerTokenDO) {
		List<ErpManagerTokenDO> list = this.slaveErpManagerTokenMapper.selectErpManagerTokenList(erpManagerTokenDO);
		return list;
	}

	@Override
	public void createErpManagerToken(ErpManagerTokenDO erpManagerTokenDO) {
		this.masterErpManagerTokenMapper.insertErpManagerToken(erpManagerTokenDO);
	}

	@Override
	public int modifyErpManagerToken(ErpManagerTokenDO erpManagerTokenDO) {
		int num = this.masterErpManagerTokenMapper.updateErpManagerToken(erpManagerTokenDO);
		return num;
	}

	@Override
	public int modifyErpManagerTokenSelective(ErpManagerTokenDO erpManagerTokenDO) {
		int num = this.masterErpManagerTokenMapper.updateErpManagerTokenSelective(erpManagerTokenDO);
		return num;
	}

	@Override
	public int removeErpManagerToken(long id) {
		int num = this.masterErpManagerTokenMapper.deleteErpManagerToken(id);
		return num;
	}
	
}