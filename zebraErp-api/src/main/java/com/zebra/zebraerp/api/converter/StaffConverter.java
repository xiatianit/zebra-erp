package com.zebra.zebraerp.api.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.zebra.zebraerp.api.paramobject.StaffBaseAddPO;
import com.zebra.zebraerp.api.paramobject.StaffBaseEditPO;
import com.zebra.zebraerp.api.viewobject.StaffBaseVO;
import com.zebra.zebraerp.dal.dataobject.StaffBaseDO;

/**
 * 员工转换
 * 
 * @author owen
 *
 */
public class StaffConverter {

    public static StaffBaseDO staffBaseAddPO2BStaffBaseDO(StaffBaseAddPO staffBaseAddPO) {
        if (staffBaseAddPO == null) {
            return null;
        }
        StaffBaseDO staffBaseDO = new StaffBaseDO();
        BeanUtils.copyProperties(staffBaseAddPO, staffBaseDO);
        return staffBaseDO;
    }

    public static StaffBaseDO staffBaseEditPO2BStaffBaseDO(StaffBaseEditPO staffBaseEditPO) {
        if (staffBaseEditPO == null) {
            return null;
        }
        StaffBaseDO staffBaseDO = new StaffBaseDO();
        BeanUtils.copyProperties(staffBaseEditPO, staffBaseDO);
        return staffBaseDO;
    }

    public static StaffBaseVO staffBaseDO2BStaffBaseVO(StaffBaseDO StaffBaseDO) {
        if (StaffBaseDO == null) {
            return null;
        }
        StaffBaseVO StaffBaseVO = new StaffBaseVO();
        BeanUtils.copyProperties(StaffBaseDO, StaffBaseVO);
        return StaffBaseVO;
    }

    public static List<StaffBaseVO> staffBaseDO2BStaffBaseVO(List<StaffBaseDO> StaffBaseDOList) {
        if (StaffBaseDOList == null) {
            return null;
        }

        List<StaffBaseVO> StaffBaseVOList = new ArrayList<StaffBaseVO>(StaffBaseDOList.size());
        StaffBaseVO staffBaseVO = null;
        for (StaffBaseDO StaffBaseDO : StaffBaseDOList) {
            staffBaseVO = StaffConverter.staffBaseDO2BStaffBaseVO(StaffBaseDO);
            StaffBaseVOList.add(staffBaseVO);
        }
        return StaffBaseVOList;
    }

}
