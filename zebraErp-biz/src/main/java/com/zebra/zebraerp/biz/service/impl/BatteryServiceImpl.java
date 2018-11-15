package com.zebra.zebraerp.biz.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zebra.pony.util.JsonUtil;
import com.zebra.zebraerp.biz.service.BatteryService;
import com.zebra.zebraerp.common.Exception.ZebraerpException;
import com.zebra.zebraerp.dal.dataobject.BatteryDO;
import com.zebra.zebraerp.dal.dataobject.businessObject.BatteryBindStaffBO;
import com.zebra.zebraerp.dal.mapper.BatteryMapper;
import org.springframework.transaction.annotation.Transactional;

/**
 * 电池服务信息
 *
 * @author owen
 */
@Service
@Transactional
public class BatteryServiceImpl implements BatteryService {

    private final static Logger logger = LoggerFactory.getLogger(BatteryServiceImpl.class);

    @Autowired
    private BatteryMapper masterBatteryMapper;

    @Autowired
    private BatteryMapper slaveBatteryMapper;

    /**
     * 新增电池基础信息
     */
    @Override
    public void addBattery(BatteryDO batteryDO) {
        logger.info("新增电池基础信息，BatteryDO={}", JsonUtil.getJsonFromObject(batteryDO));
        int effectRows = masterBatteryMapper.insert(batteryDO);
        if (effectRows == 0) {
            logger.error("新增电池基础信息失败，batteryDO={}", JsonUtil.getJsonFromObject(batteryDO));
            throw new ZebraerpException("新增电池基础失败");
        }
    }

    /**
     * 修改电池基础信息
     */
    @Override
    public void editBattery(BatteryDO batteryDO) {
        logger.info("修改电池基础信息，batteryDO={}", JsonUtil.getJsonFromObject(batteryDO));
        int effectRows = masterBatteryMapper.update(batteryDO);
        if (effectRows == 0) {
            logger.error("修改电池基础信息失败，batteryDO={}", JsonUtil.getJsonFromObject(batteryDO));
            throw new ZebraerpException("修改电池基础失败");
        }
    }

    @Override
    public void deleteBattery(String batteryCode) {
        logger.info("删除电池基础信息，batteryCode={}", batteryCode);
        int effectRows = masterBatteryMapper.delete(batteryCode);
        if (effectRows == 0) {
            logger.error("删除电池基础信息失败，batteryCode={}", batteryCode);
            throw new ZebraerpException("删除电池基础失败");
        }
    }

    /**
     * 捆绑电池与员工关系
     */
    @Override
    public void editBatteryBindStaff(BatteryBindStaffBO batteryBindStaffBO) {
        logger.info("捆绑电池信息， 电池与员工的关系，batteryBindStaffBO={}", JsonUtil.getJsonFromObject(batteryBindStaffBO));
        try {
            int effectRows = masterBatteryMapper.updateBatteryBindStaff(batteryBindStaffBO);
            if (effectRows == 0) {
                throw new ZebraerpException("捆绑投放点信息， 电池与员工失败");
            }
        } catch (Exception e) {
            logger.error("捆绑投放点信息， 电池与员工的关系，batteryBindStaffBO={},e={}", JsonUtil.getJsonFromObject(batteryBindStaffBO), e);
            throw new ZebraerpException("捆绑投放点信息， 电池与员工的关系失败");
        }
    }


    /**
     * 获取电池基本信息集合
     */
    @Override
    public List<BatteryDO> queryBatteryList(BatteryDO batteryDO) {
        return slaveBatteryMapper.selectByCondition(batteryDO);
    }

    /**
     * 获取电池基本信息数量
     */
    @Override
    public int queryBatteryCount(BatteryDO batteryDO) {
        return slaveBatteryMapper.selectCountByCondition(batteryDO);
    }

    /**
     * 获取电池信息，根据主键 batteryCode
     *
     * @param batteryCode
     * @return
     */
    public BatteryDO queryBatteryByPk(String batteryCode) {
        return slaveBatteryMapper.selectByPk(batteryCode);
    }

}
