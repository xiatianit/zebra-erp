package com.zebra.zebraerp.biz.service;

import java.util.List;

import com.zebra.zebraerp.dal.dataobject.ServiceStationDO;


/**
 * 服务站
 * 
 * @author owen
 *
 */
public interface ServiceStationService {

    /**
     * 添加服务站信息
     * @param serviceStationDO
     */
    void addServiceStation(ServiceStationDO serviceStationDO);
    
    /**
     * 修改服务站信息
     * @param serviceStationDO
     */
    void editServiceStation(ServiceStationDO serviceStationDO);
    
    /**
     * 删除服务站信息
     * @param id
     */
    void delServiceStation(Long id);
    
    /**
     * 获取服务站信息
     * @param serviceStationDO
     * @return
     */
    List<ServiceStationDO> queryServiceStationList(ServiceStationDO serviceStationDO);
    
    /**
     * 获取服务站信息个数
     * @param serviceStationDO
     * @return
     */
    int queryServiceStationCount(ServiceStationDO serviceStationDO);
    
    /**
     * 获取服务站信息，根据主键ID
     * @param id
     * @return
     */
    ServiceStationDO queryServiceStationByPk(Long id);
    
}
