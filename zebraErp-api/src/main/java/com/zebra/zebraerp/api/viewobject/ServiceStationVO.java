package com.zebra.zebraerp.api.viewobject;

/**
 * 新增服务站
 *
 * @author owen
 */
public class ServiceStationVO {

    /**
     * 服务站ID
     */
    private Long id;

    /**
     * 地理位置经纬度，如：120.145156,30.1516
     */
    private String location;

    /**
     * 服务站名称
     */
    private String serviceStationName;
    /**
     * 服务站所在地址
     */
    private String serviceStationAddress;

    /**
     * 服务站状态：1、正常开放 2、关闭
     */
    private Integer serviceStationStatus;

    /**
     * 所属加盟商编号
     */
    private String franchiserCode;

    /**
     * 所属加盟商名称
     */
    private String franchiserName;
    /**
     * 录入时间
     */
    private String createTime;
   /* *//**
     * 停放车辆数量
     *//*
    private Integer bikeNum;*/
    /**
     * 停车点数量
     */
    private Integer siteNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getServiceStationAddress() {
        return serviceStationAddress;
    }

    public void setServiceStationAddress(String serviceStationAddress) {
        this.serviceStationAddress = serviceStationAddress;
    }

    public Integer getServiceStationStatus() {
        return serviceStationStatus;
    }

    public void setServiceStationStatus(Integer serviceStationStatus) {
        this.serviceStationStatus = serviceStationStatus;
    }

    public String getFranchiserCode() {
        return franchiserCode;
    }

    public void setFranchiserCode(String franchiserCode) {
        this.franchiserCode = franchiserCode;
    }

    public String getFranchiserName() {
        return franchiserName;
    }

    public void setFranchiserName(String franchiserName) {
        this.franchiserName = franchiserName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

   /* public Integer getBikeNum() {
        return bikeNum;
    }

    public void setBikeNum(Integer bikeNum) {
        this.bikeNum = bikeNum;
    }*/

    public Integer getSiteNum() {
        return siteNum;
    }

    public void setSiteNum(Integer siteNum) {
        this.siteNum = siteNum;
    }
}
