package com.zebra.zebraerp.biz.service;

import java.util.List;

import com.zebra.zebraerp.dal.dataobject.SiteDO;
import com.zebra.zebraerp.dal.dataobject.businessObject.SiteBO;


/**
 * 投放点
 * @author owen
 */
public interface SiteService {

    /**
     * 添加投放点信息
     * @param siteDO
     */
    void addSite(SiteDO siteDO);
    
    /**
     * 修改投放点信息
     * @param siteDO
     */
    void editSite(SiteDO siteDO);
    
    /**
     * 解绑投放点信息，与服务站解除关系
     * @param id
     */
    void editSiteUnbind(Long id);
    
    /**
     * 捆绑投放点信息，与服务站解除关系
     * @param siteBO
     */
    void editSitebind(SiteBO siteBO);
    
    /**
     * 删除投放点信息
     * @param id
     */
    void delSite(Long id);
    
    /**
     * 获取投放点信息
     * @param
     * @return
     */
    List<SiteDO> querySiteList(SiteDO siteDO);
    
    /**
     * 获取投放点个数
     * @param
     * @return
     */
    int querySiteCount(SiteDO siteDO);
    
    /**
     * 获取投放点信息，根据主键ID
     * @param id
     * @return
     */
    SiteDO querySiteByPk(Long id);

    /**
     *根据服务点ID 获取停放点列表
     * @param serviceStationId
     * @return
     */
    List<SiteDO> queryByServiceStationId(Long serviceStationId);
    
}
