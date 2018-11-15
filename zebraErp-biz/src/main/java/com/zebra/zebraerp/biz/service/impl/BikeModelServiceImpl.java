package com.zebra.zebraerp.biz.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zebra.zebraerp.dal.mapper.BikeModelMapper;
import com.zebra.zebraerp.dal.dataobject.BikeModelDO;
import com.zebra.zebraerp.biz.service.BikeModelService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @ClassName: BikeModelServiceImpl
 * @Description: by CodeGenerate
 * @author 
 * 
 */
@Service
@Transactional
public class BikeModelServiceImpl implements BikeModelService {

	 private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private BikeModelMapper masterBikeModelMapper;
    @Autowired
	private BikeModelMapper slaveBikeModelMapper;
	
	@Override
	public BikeModelDO queryBikeModelById(long id) {

		BikeModelDO cBikeModel = this.slaveBikeModelMapper.selectBikeModelById(id);
		return cBikeModel;		
	}

	@Override
	public List<BikeModelDO> queryBikeModelByPage(BikeModelDO bikeModelDO) {

		List<BikeModelDO> list = this.slaveBikeModelMapper.selectBikeModelPage(bikeModelDO);
		return list;
	}
	
	@Override
	public List<BikeModelDO> queryBikeModelList(BikeModelDO bikeModelDO) {
		List<BikeModelDO> list = this.slaveBikeModelMapper.selectBikeModelList(bikeModelDO);
		return list;
	}

	@Override
	public void createBikeModel(BikeModelDO bikeModelDO) {
		this.masterBikeModelMapper.insertBikeModel(bikeModelDO);
	}

	@Override
	public int modifyBikeModel(BikeModelDO bikeModelDO) {
		int num = this.masterBikeModelMapper.updateBikeModel(bikeModelDO);
		return num;
	}

	@Override
	public int modifyBikeModelSelective(BikeModelDO bikeModelDO) {
		int num = this.masterBikeModelMapper.updateBikeModelSelective(bikeModelDO);
		return num;
	}

	@Override
	public int removeBikeModel(long id) {
		int num = this.masterBikeModelMapper.deleteBikeModel(id);
		return num;
	}
	
}