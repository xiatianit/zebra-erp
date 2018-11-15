package com.zebra.zebraerp.dal.dataobject.businessObject;

import java.io.Serializable;
import java.util.List;

/**
 * 针对 关联服务站 业务对象处理
 * @author owen
 */
public class SiteBO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private List<String> siteIdList;

    private Long       serviceStationId;

    public List<String> getSiteIdList() {
        return siteIdList;
    }

    public void setSiteIdList(List<String> siteIdList) {
        this.siteIdList = siteIdList;
    }

    public Long getServiceStationId() {
        return serviceStationId;
    }

    public void setServiceStationId(Long serviceStationId) {
        this.serviceStationId = serviceStationId;
    }

}
