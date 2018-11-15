package com.zebra.zebraerp.biz.service;

import java.util.List;

import com.zebra.zebraerp.dal.dataobject.BikeDO;
import com.zebra.zebraerp.dal.dataobject.StaffBaseDO;


/**
 * 员工
 * @author owen
 */
public interface StaffService {

    /**
     * 添加员工信息
     * @param staffBaseDO
     */
    void addStaffBase(StaffBaseDO staffBaseDO);
    
    /**
     * 修改员工信息
     * @param staffBaseDO
     */
    void editStaffBase(StaffBaseDO staffBaseDO);

    /**
     * 删除员工
     * @param sid
     */
    void deleteStaffBase(Long sid);
    
    /**
     * 获取员工信息
     * @param staffBaseDO
     * @return
     */
    List<StaffBaseDO> queryStaffBaseList(StaffBaseDO staffBaseDO);
    
    /**
     * 获取员工辆数
     * @param staffBaseDO
     * @return
     */
    int queryStaffBaseCount(StaffBaseDO staffBaseDO);
    
    
    /**
     * 获取员工基本信息，根据主键 sid
     * @param
     * @return
     */
    StaffBaseDO queryStaffBaseByPk(Long sid);
    
}
