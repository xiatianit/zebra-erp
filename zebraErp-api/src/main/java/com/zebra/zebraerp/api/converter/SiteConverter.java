package com.zebra.zebraerp.api.converter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.zebra.zebraerp.api.Interceptor.RequestLocalInfo;
import org.springframework.beans.BeanUtils;

import com.zebra.zebraerp.api.paramobject.SiteAddPO;
import com.zebra.zebraerp.api.paramobject.SiteEditPO;
import com.zebra.zebraerp.api.viewobject.SiteVO;
import com.zebra.zebraerp.dal.dataobject.SiteDO;

/**
 * 投放点转换
 *
 * @author owen
 */
public class SiteConverter {

    /**
     * @param siteAddPO
     * @return
     */
    public static SiteDO siteAddPO2SiteDO(SiteAddPO siteAddPO) {
        if (siteAddPO == null) {
            return null;
        }
        SiteDO siteDO = new SiteDO();
        BeanUtils.copyProperties(siteAddPO, siteDO);

        String location = siteAddPO.getLocation();
        String[] jingweidu = location.split(",");
        siteDO.setLongitude(new BigDecimal(jingweidu[0]));
        siteDO.setLatitude(new BigDecimal(jingweidu[1]));
        return siteDO;
    }

    /**
     * @param siteEditPO
     * @return
     */
    public static SiteDO siteEditPO2SiteDO(SiteEditPO siteEditPO) {
        if (siteEditPO == null) {
            return null;
        }
        SiteDO siteDO = new SiteDO();
        BeanUtils.copyProperties(siteEditPO, siteDO);
        String location = siteEditPO.getLocation();
        String[] jingweidu = location.split(",");
        siteDO.setLongitude(new BigDecimal(jingweidu[0]));
        siteDO.setLatitude(new BigDecimal(jingweidu[1]));
        return siteDO;
    }

    /**
     * @param siteDO
     * @return
     */
    public static SiteVO siteDODO2SiteVO(SiteDO siteDO) {
        if (siteDO == null) {
            return null;
        }
        SiteVO siteVO = new SiteVO();
        BeanUtils.copyProperties(siteDO, siteVO);
        siteVO.setLocation(siteDO.getLongitude() + "," + siteDO.getLatitude());
        //siteVO.setBikeCount(siteDO.getBikeNum());
        return siteVO;
    }

    /**
     * @param siteDOList
     * @return
     */
    public static List<SiteVO> siteDODO2SiteVO(List<SiteDO> siteDOList) {
        if (siteDOList == null) {
            return null;
        }

        List<SiteVO> siteVOList = new ArrayList<SiteVO>(siteDOList.size());
        SiteVO siteVO = null;

        for (SiteDO siteDO : siteDOList) {
            siteVO = SiteConverter.siteDODO2SiteVO(siteDO);
            siteVOList.add(siteVO);
        }

        return siteVOList;
    }

    // /**
    // * @param serviceStationAddPO
    // * @return ServiceStationDO
    // */
    // public static ServiceStationDO serviceStationEditPO2ServiceStationDO(ServiceStationEditPO serviceStationEditPO) {
    // if (serviceStationEditPO == null) {
    // return null;
    // }
    // ServiceStationDO serviceStationDO = new ServiceStationDO();
    // BeanUtils.copyProperties(serviceStationEditPO, serviceStationDO);
    //
    // String location = serviceStationEditPO.getServiceStationLocation();
    // String[] jingweidu = location.split(",");
    // serviceStationDO.setLatitude(new BigDecimal(jingweidu[0]));
    // serviceStationDO.setLongitude(new BigDecimal(jingweidu[1]));
    // return serviceStationDO;
    // }
    //
    //
    // /**
    // * @param serviceStationDO
    // * @return ServiceStationVO
    // */
    // public static ServiceStationVO serviceStationDO2ServiceStationVO(ServiceStationDO serviceStationDO) {
    // if (serviceStationDO == null) {
    // return null;
    // }
    // ServiceStationVO serviceStationVO = new ServiceStationVO();
    // BeanUtils.copyProperties(serviceStationDO, serviceStationVO);
    //
    // serviceStationVO.setLocation(serviceStationDO.getLatitude()+","+serviceStationDO.getLongitude());
    // return serviceStationVO;
    // }
    //
    // /**
    // * @param serviceStationDO
    // * @return ServiceStationVO
    // */
    // public static List<ServiceStationVO> serviceStationDO2ServiceStationVO(List<ServiceStationDO> serviceStationDOList) {
    // if (serviceStationDOList == null) {
    // return null;
    // }
    //
    // List<ServiceStationVO> serviceStationVOList = new ArrayList<ServiceStationVO>(serviceStationDOList.size());
    // ServiceStationVO serviceStationVO = null;
    // for( ServiceStationDO serviceStationDO : serviceStationDOList){
    // serviceStationVO = SiteConverter.serviceStationDO2ServiceStationVO(serviceStationDO);
    // serviceStationVOList.add(serviceStationVO);
    // }
    //
    // return serviceStationVOList;
    // }
    //
}
