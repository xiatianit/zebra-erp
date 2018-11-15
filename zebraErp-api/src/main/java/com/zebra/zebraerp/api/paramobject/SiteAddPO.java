package com.zebra.zebraerp.api.paramobject;

/**
 * 投放点
 * 
 * @author owen
 */
public class SiteAddPO {

    /** 地理位置经纬度，如：120.145156,30.1516 */
    private String  location;

    /** 投放点名称 */
    private String  siteName;

    /** 投放点状态：1、正常开放 2、关闭 */
    private Integer siteStatus;

    /** 区域id（对应高德官方库的abcode） */
    private String  zoneCode;

    private String franchiserName;

    private String franchiserCode;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public Integer getSiteStatus() {
        return siteStatus;
    }

    public void setSiteStatus(Integer siteStatus) {
        this.siteStatus = siteStatus;
    }

    public String getZoneCode() {
        return zoneCode;
    }

    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
    }

    public String getFranchiserName() {
        return franchiserName;
    }

    public void setFranchiserName(String franchiserName) {
        this.franchiserName = franchiserName;
    }

    public String getFranchiserCode() {
        return franchiserCode;
    }

    public void setFranchiserCode(String franchiserCode) {
        this.franchiserCode = franchiserCode;
    }
}
