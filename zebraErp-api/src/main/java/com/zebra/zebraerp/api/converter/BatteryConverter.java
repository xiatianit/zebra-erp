package com.zebra.zebraerp.api.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.zebra.zebraerp.api.paramobject.BatteryAddPO;
import com.zebra.zebraerp.api.paramobject.BatteryEditPO;
import com.zebra.zebraerp.api.viewobject.BatteryVO;
import com.zebra.zebraerp.dal.dataobject.BatteryDO;

/**
 * 电池转换
 * 
 * @author owen
 *
 */
public class BatteryConverter {

    public static BatteryDO batteryAddPO2BBatteryDO(BatteryAddPO batteryAddPO) {
        if (batteryAddPO == null) {
            return null;
        }
        BatteryDO batteryDO = new BatteryDO();
        BeanUtils.copyProperties(batteryAddPO, batteryDO);
        return batteryDO;
    }

    public static BatteryDO batteryEditPO2BBatteryDO(BatteryEditPO batteryEditPO) {
        if (batteryEditPO == null) {
            return null;
        }
        BatteryDO batteryDO = new BatteryDO();
        BeanUtils.copyProperties(batteryEditPO, batteryDO);
        return batteryDO;
    }

    public static BatteryVO batteryDO2BBatteryVO(BatteryDO batteryDO) {
        if (batteryDO == null) {
            return null;
        }
        BatteryVO batteryVO = new BatteryVO();
        BeanUtils.copyProperties(batteryDO, batteryVO);
        batteryVO.setLocation(batteryDO.getLatitude() + "," + batteryDO.getLongitude());
        return batteryVO;
    }

    public static List<BatteryVO> batteryDO2BBatteryVO(List<BatteryDO> batteryDOList) {
        if (batteryDOList == null) {
            return null;
        }

        List<BatteryVO> batteryVOList = new ArrayList<BatteryVO>(batteryDOList.size());
        BatteryVO batteryVO = null;
        for (BatteryDO batteryDO : batteryDOList) {
            batteryVO = BatteryConverter.batteryDO2BBatteryVO(batteryDO);
            batteryVOList.add(batteryVO);
        }
        return batteryVOList;
    }

}
