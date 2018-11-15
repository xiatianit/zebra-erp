package com.zebra.zebraerp.dal.dataobject.businessObject;

import java.io.Serializable;
import java.util.List;

/**
 * 针对 电池关联服务员工服务站 业务对象处理
 * 
 * @author owen
 */
public class BatteryBindStaffBO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private List<String>      batteryCodeList;

    private Long              sid;

    public List<String> getBatteryCodeList() {
        return batteryCodeList;
    }

    public void setBatteryCodeList(List<String> batteryCodeList) {
        this.batteryCodeList = batteryCodeList;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

}
