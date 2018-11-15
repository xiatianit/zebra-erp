package com.zebra.zebraerp.api.converter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.zebra.pony.util.DateUtil;
import org.springframework.beans.BeanUtils;

import com.zebra.zebraerp.api.paramobject.ServiceStationAddPO;
import com.zebra.zebraerp.api.paramobject.ServiceStationEditPO;
import com.zebra.zebraerp.api.viewobject.ServiceStationVO;
import com.zebra.zebraerp.dal.dataobject.ServiceStationDO;

/**
 * 服务站转换
 *
 * @author owen
 */
public class ServiceStationConverter {

    /**
     * @param serviceStationAddPO
     * @return ServiceStationDO
     */
    public static ServiceStationDO serviceStationAddPO2ServiceStationDO(ServiceStationAddPO serviceStationAddPO) {
        if (serviceStationAddPO == null) {
            return null;
        }
        ServiceStationDO serviceStationDO = new ServiceStationDO();
        BeanUtils.copyProperties(serviceStationAddPO, serviceStationDO);

        String location = serviceStationAddPO.getLocation();
        String[] jingweidu = location.split(",");
        serviceStationDO.setLongitude(new BigDecimal(jingweidu[0]));
        serviceStationDO.setLatitude(new BigDecimal(jingweidu[1]));
        return serviceStationDO;
    }


    /**
     * @param
     * @return ServiceStationDO
     */
    public static ServiceStationDO serviceStationEditPO2ServiceStationDO(ServiceStationEditPO serviceStationEditPO) {
        if (serviceStationEditPO == null) {
            return null;
        }
        ServiceStationDO serviceStationDO = new ServiceStationDO();
        BeanUtils.copyProperties(serviceStationEditPO, serviceStationDO);

        String location = serviceStationEditPO.getLocation();
        String[] jingweidu = location.split(",");
        serviceStationDO.setLongitude(new BigDecimal(jingweidu[0]));
        serviceStationDO.setLatitude(new BigDecimal(jingweidu[1]));
        return serviceStationDO;
    }


    /**
     * @param serviceStationDO
     * @return ServiceStationVO
     */
    public static ServiceStationVO serviceStationDO2ServiceStationVO(ServiceStationDO serviceStationDO) {
        if (serviceStationDO == null) {
            return null;
        }
        ServiceStationVO serviceStationVO = new ServiceStationVO();
        BeanUtils.copyProperties(serviceStationDO, serviceStationVO);
        //日期转换
        serviceStationVO.setCreateTime(DateUtil.formatyyyyMMdd(serviceStationDO.getCreateTime().longValue()));
        serviceStationVO.setLocation(serviceStationDO.getLongitude() + "," + serviceStationDO.getLatitude());
        return serviceStationVO;
    }

    /**
     * @param
     * @return ServiceStationVO
     */
    public static List<ServiceStationVO> serviceStationDO2ServiceStationVO(List<ServiceStationDO> serviceStationDOList) {
        if (serviceStationDOList == null) {
            return null;
        }

        List<ServiceStationVO> serviceStationVOList = new ArrayList<ServiceStationVO>(serviceStationDOList.size());
        ServiceStationVO serviceStationVO = null;
        for (ServiceStationDO serviceStationDO : serviceStationDOList) {
            serviceStationVO = ServiceStationConverter.serviceStationDO2ServiceStationVO(serviceStationDO);
            serviceStationVOList.add(serviceStationVO);
        }

        return serviceStationVOList;
    }

}
