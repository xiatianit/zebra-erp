package com.zebra.zebraerp.dal.dataobject.businessObject;

import java.io.Serializable;
import java.util.List;

/**
 * 针对 电车关联投放点 业务对象处理
 * 
 * @author owen
 */
public class BikeBindStaffBO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private List<String>      bikeCodeList;

    private Long              sid;

    public List<String> getBikeCodeList() {
        return bikeCodeList;
    }

    public void setBikeCodeList(List<String> bikeCodeList) {
        this.bikeCodeList = bikeCodeList;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

}
