package com.zebra.zebraerp.biz.service.impl;

import java.util.List;

import com.zebra.zebraerp.biz.service.ZoneService;
import com.zebra.zebraerp.dal.dataobject.ZoneDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zebra.zebraerp.biz.service.ServiceStationService;
import com.zebra.zebraerp.common.Exception.ZebraerpException;
import com.zebra.zebraerp.common.constant.ZebraerpConstant;
import com.zebra.pony.util.JsonUtil;
import com.zebra.pony.util.DateUtil;
import com.zebra.zebraerp.dal.dataobject.ServiceStationDO;
import com.zebra.zebraerp.dal.mapper.ServiceStationMapper;
import org.springframework.transaction.annotation.Transactional;

/**
 * 服务车站
 * 
 * @author owen
 *
 */
@Service
@Transactional
public class ServiceStationServiceImpl implements ServiceStationService {

    private final static Logger  logger = LoggerFactory.getLogger(ServiceStationServiceImpl.class);

    @Autowired
    private ServiceStationMapper masterServiceStationMapper;

    @Autowired
    private ServiceStationMapper slaveServiceStationMapper;

    @Autowired
    private ZoneService zoneService;

    /**
     * 新增服务站点信息
     */
    @Override
    public void addServiceStation(ServiceStationDO serviceStationDO) {
        logger.info("新增服务站信息，serviceStationDO={}", JsonUtil.getJsonFromObject(serviceStationDO));
        try {
            // 1、根据传过来的zoneCode信息，来获取该区域对应的基本信息
            ZoneDO zoneDO = zoneService.queryZoneById(serviceStationDO.getZoneCode());
            if (zoneDO == null) {
                throw new ZebraerpException("不存在该区域，zoneCode=" + serviceStationDO.getZoneCode());
            }

            serviceStationDO.setZoneCode(zoneDO.getZoneCode());
            serviceStationDO.setZoneName(zoneDO.getZoneName());
            serviceStationDO.setProvinceCode(zoneDO.getProvinceCode());
            serviceStationDO.setProvinceName(zoneDO.getProvinceName());
            serviceStationDO.setCityCode(zoneDO.getCityCode());
            serviceStationDO.setCityName(zoneDO.getCityName());
            serviceStationDO.setCreateTime(DateUtil.getCurrentTimeSeconds());
            serviceStationDO.setFunctionType(ZebraerpConstant.SERVICE_STATION_FUNCTION_TYPE_1);
            masterServiceStationMapper.insert(serviceStationDO);
        } catch (Exception e) {
            logger.error("新增服务站信息，serviceStationDO={},e={}", JsonUtil.getJsonFromObject(serviceStationDO), e);
            throw new ZebraerpException("新增服务站信息失败");
        }
    }

    /**
     * 修改服务站点信息 TODO 看是否还有其他步骤需处理的。什么情况下不能修改
     */
    @Override
    public void editServiceStation(ServiceStationDO serviceStationDO) {
        logger.info("修改服务站信息，serviceStationDO={}", JsonUtil.getJsonFromObject(serviceStationDO));
        try {
            int effectRows = masterServiceStationMapper.update(serviceStationDO);
            if (effectRows == 0) {
                throw new ZebraerpException("不存在该服务区域，serviceStationDO=" + JsonUtil.getJsonFromObject(serviceStationDO));
            }
        } catch (Exception e) {
            logger.error("修改服务站信息，serviceStationDO={},e={}", JsonUtil.getJsonFromObject(serviceStationDO), e);
            throw new ZebraerpException("修改服务站信息失败");
        }
    }

    /**
     * 删除服务站信息 TODO 看是否还有其他步骤需处理的。什么情况下不能删除
     */
    @Override
    public void delServiceStation(Long id) {
        logger.info("删除服务站信息，id={}", id);
        try {
            int effectRows = masterServiceStationMapper.delete(id);
            if (effectRows == 0) {
                throw new ZebraerpException("删除服务站信息，id={}" + id);
            }
        } catch (Exception e) {
            logger.error("删除服务站信息，id={},e={}", id, e);
            throw new ZebraerpException("删除服务站信息失败");
        }
    }

    /**
     * 获取服务站列表信息
     */
    @Override
    public List<ServiceStationDO> queryServiceStationList(ServiceStationDO serviceStationDO) {
        return slaveServiceStationMapper.selectByCondition(serviceStationDO);
    }

    /**
     * 针对列表查询分页处理
     */
    @Override
    public int queryServiceStationCount(ServiceStationDO serviceStationDO) {
        return slaveServiceStationMapper.selectCountByCondition(serviceStationDO);
    }

    /**
     * 获取单个服务站信息
     */
    @Override
    public ServiceStationDO queryServiceStationByPk(Long id) {
        return slaveServiceStationMapper.selectByPk(id);
    }

}
