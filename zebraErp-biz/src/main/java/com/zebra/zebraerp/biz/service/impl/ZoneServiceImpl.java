package com.zebra.zebraerp.biz.service.impl;

import com.zebra.zebraerp.dal.mapper.ZoneMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zebra.zebraerp.dal.dataobject.ZoneDO;
import com.zebra.zebraerp.biz.service.ZoneService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @ClassName: ZoneServiceImpl
 * @Description: by CodeGenerate
 * @author 
 * 
 */
@Service
@Transactional
public class ZoneServiceImpl implements ZoneService {

	 private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ZoneMapper masterZoneMapper;
    @Autowired
	private ZoneMapper slaveZoneMapper;
	
	@Override
	public ZoneDO queryZoneById(String zoneCode) {

		ZoneDO cZone = this.slaveZoneMapper.selectZoneById(zoneCode);
		return cZone;		
	}

	@Override
	public List<ZoneDO> queryZoneByPage(ZoneDO zoneDO) {

		List<ZoneDO> list = this.slaveZoneMapper.selectZonePage(zoneDO);
		return list;
	}
	
	@Override
	public List<ZoneDO> queryZoneList(ZoneDO zoneDO) {
		List<ZoneDO> list = this.slaveZoneMapper.selectZoneList(zoneDO);
		return list;
	}

	@Override
	public void createZone(ZoneDO zoneDO) {
		this.masterZoneMapper.insertZone(zoneDO);
	}

	@Override
	public int modifyZone(ZoneDO zoneDO) {
		int num = this.masterZoneMapper.updateZone(zoneDO);
		return num;
	}

	@Override
	public int modifyZoneSelective(ZoneDO zoneDO) {
		int num = this.masterZoneMapper.updateZoneSelective(zoneDO);
		return num;
	}

	@Override
	public int removeZone(String zoneCode) {
		int num = this.masterZoneMapper.deleteZone(zoneCode);
		return num;
	}
	
}