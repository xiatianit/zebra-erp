package com.zebra.zebraerp.dal.dataobject.businessObject;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 针对 电车关联服务店 业务对象处理
 *
 * @author owen
 */
@Data
public class BikeBindSiteBO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private List<String> bikeCodeList;

    private Long siteId;
    private String siteName;
    private String cityCode;
    private String cityName;
    private String zoneCode;
    private String zoneName;

    public List<String> getBikeCodeList() {
        return bikeCodeList;
    }

    public void setBikeCodeList(List<String> bikeCodeList) {
        this.bikeCodeList = bikeCodeList;
    }

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getZoneCode() {
        return zoneCode;
    }

    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }
}
