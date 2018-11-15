package com.zebra.zebraerp.biz.service.impl;

import com.zebra.zebraerp.dal.mapper.ProvinceMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zebra.zebraerp.dal.dataobject.ProvinceDO;
import com.zebra.zebraerp.biz.service.ProvinceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @ClassName: ProvinceServiceImpl
 * @Description: by CodeGenerate
 * @author 
 * 
 */
@Service
@Transactional
public class ProvinceServiceImpl implements ProvinceService {

	 private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ProvinceMapper masterProvinceMapper;
    @Autowired
	private ProvinceMapper slaveProvinceMapper;
	
	@Override
	public ProvinceDO queryProvinceById(String provinceCode) {

		ProvinceDO cProvince = this.slaveProvinceMapper.selectProvinceById(provinceCode);
		return cProvince;		
	}

	@Override
	public List<ProvinceDO> queryProvinceByPage(ProvinceDO provinceDO) {

		List<ProvinceDO> list = this.slaveProvinceMapper.selectProvincePage(provinceDO);
		return list;
	}
	
	@Override
	public List<ProvinceDO> queryProvinceList(ProvinceDO provinceDO) {
		List<ProvinceDO> list = this.slaveProvinceMapper.selectProvinceList(provinceDO);
		return list;
	}

	@Override
	public void createProvince(ProvinceDO provinceDO) {
		this.masterProvinceMapper.insertProvince(provinceDO);
	}

	@Override
	public int modifyProvince(ProvinceDO provinceDO) {
		int num = this.masterProvinceMapper.updateProvince(provinceDO);
		return num;
	}

	@Override
	public int modifyProvinceSelective(ProvinceDO provinceDO) {
		int num = this.masterProvinceMapper.updateProvinceSelective(provinceDO);
		return num;
	}

	@Override
	public int removeProvince(String provinceCode) {
		int num = this.masterProvinceMapper.deleteProvince(provinceCode);
		return num;
	}
	
}