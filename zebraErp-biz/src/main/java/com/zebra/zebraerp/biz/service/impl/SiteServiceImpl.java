package com.zebra.zebraerp.biz.service.impl;

import java.util.List;

import com.zebra.zebraerp.biz.service.ZoneService;
import com.zebra.zebraerp.dal.dataobject.ZoneDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zebra.zebraerp.biz.service.SiteService;
import com.zebra.zebraerp.common.Exception.ZebraerpException;
import com.zebra.pony.util.JsonUtil;
import com.zebra.zebraerp.dal.dataobject.SiteDO;
import com.zebra.zebraerp.dal.dataobject.businessObject.SiteBO;
import com.zebra.zebraerp.dal.mapper.SiteMapper;
import org.springframework.transaction.annotation.Transactional;

/**
 * 投放区
 *
 * @author owen
 */
@Service
@Transactional
public class SiteServiceImpl implements SiteService {

    private final static Logger logger = LoggerFactory.getLogger(SiteServiceImpl.class);

    @Autowired
    private SiteMapper masterSiteMapper;

    @Autowired
    private SiteMapper slaveSiteMapper;

    @Autowired
    private ZoneService zoneService;

    /**
     * 添加投放点信息
     *
     * @param siteDO
     */
    public void addSite(SiteDO siteDO) {
        logger.info("新增投放点，siteDO={}", JsonUtil.getJsonFromObject(siteDO));
        try {
            // 1、根据传过来的zoneCode信息，来获取该区域对应的基本信息
            ZoneDO zoneDO = zoneService.queryZoneById(siteDO.getZoneCode());
            if (zoneDO == null) {
                throw new ZebraerpException("不存在该区域，zoneCode=" + siteDO.getZoneCode());
            }

            siteDO.setZoneCode(zoneDO.getZoneCode());
            siteDO.setZoneName(zoneDO.getZoneName());
            siteDO.setProvinceCode(zoneDO.getProvinceCode());
            siteDO.setProvinceName(zoneDO.getProvinceName());
            siteDO.setCityCode(zoneDO.getCityCode());
            siteDO.setCityName(zoneDO.getCityName());
            masterSiteMapper.insert(siteDO);
        } catch (Exception e) {
            logger.error("新增投放点，serviceStationDO={},e={}", JsonUtil.getJsonFromObject(siteDO), e);
            throw new ZebraerpException("新增点投放点失败");
        }
    }


    /**
     * 修改投放点信息
     *
     * @param siteDO
     */
    public void editSite(SiteDO siteDO) {
        logger.info("修改投放点，siteDO={}", JsonUtil.getJsonFromObject(siteDO));
        try {
            masterSiteMapper.update(siteDO);
        } catch (Exception e) {
            logger.error("修改投放点，serviceStationDO={},e={}", JsonUtil.getJsonFromObject(siteDO), e);
            throw new ZebraerpException("修改点投放点失败");
        }
    }


    /**
     * 解绑投放点信息，与服务站解除关系
     *
     * @param id
     */
    public void editSiteUnbind(Long id) {

        logger.info("解绑投放点，id={}", id);
        try {
            int effectRows = masterSiteMapper.updateUnbind(id);
            if (effectRows == 0) {
                throw new ZebraerpException("不存在该投放点，id=" + id);
            }
        } catch (Exception e) {
            logger.error("解绑投放点，id={},e={}", id, e);
            throw new ZebraerpException("解绑点投放点失败");
        }
    }

    /**
     * 捆绑投放点信息，与服务站解除关系
     *
     * @param siteBO
     */
    public void editSitebind(SiteBO siteBO) {
        logger.info("捆绑投放点，siteBO={}", JsonUtil.getJsonFromObject(siteBO));
        try {
            int effectRows = masterSiteMapper.updateBind(siteBO);
            if (effectRows == 0) {
                throw new ZebraerpException("不存在该投放点，id=" + JsonUtil.getJsonFromObject(siteBO));
            }
        } catch (Exception e) {
            logger.error("捆绑投放点，siteBO={},e={}", JsonUtil.getJsonFromObject(siteBO), e);
            throw new ZebraerpException("捆绑点投放点失败");
        }
    }

    @Override
    public void delSite(Long id) {
        try {
            int i = masterSiteMapper.delete(id);
        } catch (Exception e) {
            logger.error("删除投放点异常,e={}", e);
            throw new ZebraerpException("删除投放点失败");
        }

    }

    /**
     * 获取投放点数据
     */
    @Override
    public List<SiteDO> querySiteList(SiteDO siteDO) {
        return slaveSiteMapper.selectByCondition(siteDO);
    }

    /**
     * 获取投放点COUNT
     */
    @Override
    public int querySiteCount(SiteDO siteDO) {
        return slaveSiteMapper.selectCountByCondition(siteDO);
    }

    /**
     * 获取单个投放点信息
     */
    @Override
    public SiteDO querySiteByPk(Long id) {
        return slaveSiteMapper.selectByPk(id);
    }

    @Override
    public List<SiteDO> queryByServiceStationId(Long serviceStationId) {
        return slaveSiteMapper.selectByServiceStationId(serviceStationId);
    }
}
