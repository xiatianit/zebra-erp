package com.zebra.zebraerp.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zebra.zebraerp.dal.dataobject.SiteDO;
import com.zebra.zebraerp.dal.dataobject.businessObject.SiteBO;

public interface SiteMapper {

    /******************基础的增删改查********************/
    /**
     * 查询
     *
     * @param id
     * @return
     */
    SiteDO selectByPk(@Param("id") Long id);

    /**
     * 根据服务站ID查询服务点列表
     *
     * @param serviceStationId
     * @return
     */
    List<SiteDO> selectByServiceStationId(Long serviceStationId);

    /**
     * 插入
     *
     * @param siteDO
     * @return
     */
    int insert(SiteDO siteDO);

    /**
     * 更新
     *
     * @param siteDO
     * @return
     */
    int update(SiteDO siteDO);
    
    /**
     * 解绑 设置service_station_id为空
     * @param id
     * @return
     */
    int updateUnbind(@Param("id") Long id);
    
    /**
     * 捆绑 设置siteId ,service_station_id之间关系
     * @param siteBO
     * @return
     */
    int updateBind(SiteBO siteBO);
    
    /**
     * 删除投放点信息
     * @param id
     */
    int delete(@Param("id") Long id);
    
    /**
     * 获取投放点信息
     * @param
     * @return
     */
    List<SiteDO> selectByCondition(SiteDO siteDO);
    
    /**
     * 获取投放点信息个数
     * @param siteDO
     * @return
     */
    int selectCountByCondition(SiteDO siteDO);

}
