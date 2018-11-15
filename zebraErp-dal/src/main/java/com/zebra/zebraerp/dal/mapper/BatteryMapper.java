package com.zebra.zebraerp.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zebra.zebraerp.dal.dataobject.BatteryDO;
import com.zebra.zebraerp.dal.dataobject.businessObject.BatteryBindStaffBO;

public interface BatteryMapper {

    /****************** 基础的增删改查 ********************/
    /**
     * 查询
     *
     * @param
     * @return
     */
    BatteryDO selectByPk(@Param("batteryCode") String batteryCode);

    /**
     * 插入
     *
     * @param batteryDO
     * @return
     */
    int insert(BatteryDO batteryDO);

    /**
     * 更新
     *
     * @param batteryDO
     * @return
     */
    int update(BatteryDO batteryDO);

    /**
     * 删除
     * @param batteryCode
     * @return
     */
    int delete(String batteryCode);

    /**
     * 捆绑电池信息， 电池与员工的关系
     * 
     * @param
     */
    int updateBatteryBindStaff(BatteryBindStaffBO batteryBindStaffBO);

    /**
     * 获取电池信息信息
     * 
     * @param batteryDO
     * @return
     */
    List<BatteryDO> selectByCondition(BatteryDO batteryDO);

    /**
     * 获取电池信息个数
     * 
     * @param batteryDO
     * @return
     */
    int selectCountByCondition(BatteryDO batteryDO);

}
