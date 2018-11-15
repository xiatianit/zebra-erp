package com.zebra.zebraerp.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zebra.zebraerp.dal.dataobject.ServiceStationDO;

public interface ServiceStationMapper {

    /******************基础的增删改查********************/
    /**
     * 查询
     *
     * @param id
     * @return
     */
    ServiceStationDO selectByPk(@Param("id") Long id);

    /**
     * 插入
     *
     * @param serviceStationDO
     * @return
     */
    int insert(ServiceStationDO serviceStationDO);

    /**
     * 更新
     *
     * @param serviceStationDO
     * @return
     */
    int update(ServiceStationDO serviceStationDO);
    
    /**
     * 删除服务站信息
     * @param id
     */
    int delete(@Param("id") Long id);
    
    /**
     * 获取服务站信息
     * @param serviceStationDO
     * @return
     */
    List<ServiceStationDO> selectByCondition(ServiceStationDO serviceStationDO);
    
    /**
     * 获取服务站信息个数
     * @param serviceStationDO
     * @return
     */
    int selectCountByCondition(ServiceStationDO serviceStationDO);
  

}
