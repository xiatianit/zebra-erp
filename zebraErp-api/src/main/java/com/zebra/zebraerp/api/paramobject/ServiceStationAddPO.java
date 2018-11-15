package com.zebra.zebraerp.api.paramobject;

/**
 * 新增服务站
 * 
 * @author owen
 *
 */
public class ServiceStationAddPO {

    /** 地理位置经纬度，如：120.145156,30.1516 */
    private String  location;

    /** 服务站名称 */
    private String  serviceStationName;

    /** 服务站状态：1、正常开放 2、关闭 */
    private Integer serviceStationStatus;

    /** 区域id（对应高德官方库的abcode） */
    private String  zoneCode;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getServiceStationName() {
        return serviceStationName;
    }

    public void setServiceStationName(String serviceStationName) {
        this.serviceStationName = serviceStationName;
    }

    public Integer getServiceStationStatus() {
        return serviceStationStatus;
    }

    public void setServiceStationStatus(Integer serviceStationStatus) {
        this.serviceStationStatus = serviceStationStatus;
    }

    public String getZoneCode() {
        return zoneCode;
    }

    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
    }

}
