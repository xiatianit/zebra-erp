package com.zebra.zebraerp.biz.service.impl;

import java.util.List;

import com.zebra.zebraerp.common.util.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zebra.zebraerp.biz.service.StaffService;
import com.zebra.zebraerp.common.Exception.ZebraerpException;
import com.zebra.pony.util.JsonUtil;
import com.zebra.pony.util.DateUtil;
import com.zebra.zebraerp.dal.dataobject.StaffBaseDO;
import com.zebra.zebraerp.dal.mapper.StaffBaseMapper;
import org.springframework.transaction.annotation.Transactional;

/**
 * 员工服务信息
 *
 * @author owen
 */
@Service
@Transactional
public class StaffServiceImpl implements StaffService {

    private final static Logger logger = LoggerFactory.getLogger(StaffServiceImpl.class);

    @Autowired
    private StaffBaseMapper masterStaffBaseMapper;

    @Autowired
    private StaffBaseMapper slaveStaffBaseMapper;

    /**
     * 新增员工基础信息
     */
    @Override
    public void addStaffBase(StaffBaseDO staffBaseDO) {
        StaffBaseDO staffBase = new StaffBaseDO();
        staffBase.setPhone(staffBaseDO.getPhone());
        List<StaffBaseDO> staffBaseDOList = this.slaveStaffBaseMapper.selectByCondition(staffBase);
        if (CollectionUtils.isNotEmpty(staffBaseDOList)) {
            throw new ZebraerpException(staffBase.getPhone() + "新增员工的电话已经存在请更换电话号码重新添加");
        }
        staffBaseDO.setRegisterTime(DateUtil.getCurrentTimeSeconds());
        int effectRows = masterStaffBaseMapper.insert(staffBaseDO);
        if (effectRows == 0) {
            throw new ZebraerpException("新增员工基础失败");
        }
    }

    /**
     * 修改员工基础信息
     */
    @Override
    public void editStaffBase(StaffBaseDO staffBaseDO) {
        logger.info("修改员工基础信息，staffBaseDO={}", JsonUtil.getJsonFromObject(staffBaseDO));
        StaffBaseDO staffBase = new StaffBaseDO();
        staffBase.setPhone(staffBaseDO.getPhone());
        List<StaffBaseDO> staffBaseDOList = this.slaveStaffBaseMapper.selectByCondition(staffBase);
        if (staffBaseDOList.size() > 1) {
            throw new ZebraerpException(staffBase.getPhone() + "修改员工的电话已经存在请更换电话号码重新添加");
        }
        int effectRows = masterStaffBaseMapper.update(staffBaseDO);
        if (effectRows == 0) {
            throw new ZebraerpException("修改员工基础失败");
        }

    }

    @Override
    public void deleteStaffBase(Long sid) {
        logger.info("删除员工基础信息，sid={}", sid);
        int i = masterStaffBaseMapper.delete(sid);
        if (i == 0) {
            throw new ZebraerpException("删除员工基础失败");
        }

    }

    /**
     * 获取员工基本信息集合
     */
    @Override
    public List<StaffBaseDO> queryStaffBaseList(StaffBaseDO staffBaseDO) {
        return slaveStaffBaseMapper.selectByCondition(staffBaseDO);
    }

    /**
     * 获取员工基本信息数量
     */
    @Override
    public int queryStaffBaseCount(StaffBaseDO staffBaseDO) {
        return slaveStaffBaseMapper.selectCountByCondition(staffBaseDO);
    }

    /**
     * 获取员工基本信息，根据主键 sid
     *
     * @param
     * @return
     */
    public StaffBaseDO queryStaffBaseByPk(Long sid) {
        return slaveStaffBaseMapper.selectByPk(sid);
    }

}
