package com.zebra.zebraerp.biz.service;

import java.util.List;

import com.zebra.zebraerp.dal.dataobject.BatteryDO;
import com.zebra.zebraerp.dal.dataobject.BikeDO;
import com.zebra.zebraerp.dal.dataobject.businessObject.BatteryBindStaffBO;

/**
 * 电池
 * 
 * @author owen
 */
public interface BatteryService {

    /**
     * 添加电池信息
     * 
     * @param batteryDO
     */
    void addBattery(BatteryDO batteryDO);

    /**
     * 修改电池信息
     * 
     * @param batteryDO
     */
    void editBattery(BatteryDO batteryDO);

    /**
     * 删除电池信息
     *
     * @param batteryCode
     */
    void deleteBattery(String batteryCode);

    /**
     * 捆绑电池信息， 电池与员工的关系
     * 
     * @param
     */
    void editBatteryBindStaff(BatteryBindStaffBO batteryBindStaffBO);

    /**
     * 获取电池信息
     * 
     * @param batteryDO
     * @return
     */
    List<BatteryDO> queryBatteryList(BatteryDO batteryDO);

    /**
     * 获取电池辆数
     * 
     * @param
     * @return
     */
    int queryBatteryCount(BatteryDO batteryDO);
    
    /**
     * 获取电池信息，根据主键 batteryCode
     * @param batteryCode
     * @return
     */
    BatteryDO queryBatteryByPk(String batteryCode);

}
