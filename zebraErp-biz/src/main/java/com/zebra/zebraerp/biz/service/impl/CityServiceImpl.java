package com.zebra.zebraerp.biz.service.impl;

import com.zebra.zebraerp.dal.mapper.CityMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zebra.zebraerp.dal.dataobject.CityDO;
import com.zebra.zebraerp.biz.service.CityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @ClassName: CityServiceImpl
 * @Description: by CodeGenerate
 * @author 
 * 
 */
@Service
@Transactional
public class CityServiceImpl implements CityService {

	 private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private CityMapper masterCityMapper;
    @Autowired
	private CityMapper slaveCityMapper;
	
	@Override
	public CityDO queryCityById(String cityCode) {

		CityDO cCity = this.slaveCityMapper.selectCityById(cityCode);
		return cCity;		
	}

	@Override
	public List<CityDO> queryCityByPage(CityDO cityDO) {

		List<CityDO> list = this.slaveCityMapper.selectCityPage(cityDO);
		return list;
	}
	
	@Override
	public List<CityDO> queryCityList(CityDO cityDO) {
		List<CityDO> list = this.slaveCityMapper.selectCityList(cityDO);
		return list;
	}

	@Override
	public void createCity(CityDO cityDO) {
		this.masterCityMapper.insertCity(cityDO);
	}

	@Override
	public int modifyCity(CityDO cityDO) {
		int num = this.masterCityMapper.updateCity(cityDO);
		return num;
	}

	@Override
	public int modifyCitySelective(CityDO cityDO) {
		int num = this.masterCityMapper.updateCitySelective(cityDO);
		return num;
	}

	@Override
	public int removeCity(String cityCode) {
		int num = this.masterCityMapper.deleteCity(cityCode);
		return num;
	}
	
}