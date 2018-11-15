package com.zebra.zebraerp.biz.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zebra.zebraerp.dal.mapper.BikeChargePriceMapper;
import com.zebra.zebraerp.dal.dataobject.BikeChargePriceDO;
import com.zebra.zebraerp.biz.service.BikeChargePriceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @ClassName: BikeChargePriceServiceImpl
 * @Description: by CodeGenerate
 * @author 
 * 
 */
@Service
@Transactional
public class BikeChargePriceServiceImpl implements BikeChargePriceService {

	 private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private BikeChargePriceMapper masterBikeChargePriceMapper;
    @Autowired
	private BikeChargePriceMapper slaveBikeChargePriceMapper;
	
	@Override
	public BikeChargePriceDO queryBikeChargePriceById(long id) {

		BikeChargePriceDO cBikeChargePrice = this.slaveBikeChargePriceMapper.selectBikeChargePriceById(id);
		return cBikeChargePrice;		
	}

	@Override
	public List<BikeChargePriceDO> queryBikeChargePriceByPage(BikeChargePriceDO bikeChargePriceDO) {

		List<BikeChargePriceDO> list = this.slaveBikeChargePriceMapper.selectBikeChargePricePage(bikeChargePriceDO);
		return list;
	}
	
	@Override
	public List<BikeChargePriceDO> queryBikeChargePriceList(BikeChargePriceDO bikeChargePriceDO) {
		List<BikeChargePriceDO> list = this.slaveBikeChargePriceMapper.selectBikeChargePriceList(bikeChargePriceDO);
		return list;
	}

	@Override
	public void createBikeChargePrice(BikeChargePriceDO bikeChargePriceDO) {
		this.masterBikeChargePriceMapper.insertBikeChargePrice(bikeChargePriceDO);
	}

	@Override
	public int modifyBikeChargePrice(BikeChargePriceDO bikeChargePriceDO) {
		int num = this.masterBikeChargePriceMapper.updateBikeChargePrice(bikeChargePriceDO);
		return num;
	}

	@Override
	public int modifyBikeChargePriceSelective(BikeChargePriceDO bikeChargePriceDO) {
		int num = this.masterBikeChargePriceMapper.updateBikeChargePriceSelective(bikeChargePriceDO);
		return num;
	}

	@Override
	public int removeBikeChargePrice(long id) {
		int num = this.masterBikeChargePriceMapper.deleteBikeChargePrice(id);
		return num;
	}
	
}