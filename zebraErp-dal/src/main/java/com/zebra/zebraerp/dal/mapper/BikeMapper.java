package com.zebra.zebraerp.dal.mapper;

import java.util.List;

import com.zebra.zebraerp.dal.dataobject.BikeCountDO;
import org.apache.ibatis.annotations.Param;

import com.zebra.zebraerp.dal.dataobject.BikeDO;
import com.zebra.zebraerp.dal.dataobject.businessObject.BikeBindStaffBO;
import com.zebra.zebraerp.dal.dataobject.businessObject.BikeBindSiteBO;

public interface BikeMapper {

    /******************基础的增删改查********************/
    /**
     * 查询
     *
     * @param
     * @return
     */
    BikeDO selectByPk(@Param("bikeCode") String bikeCode);

    /**
     * 插入
     *
     * @param bikeDO
     * @return
     */
    int insert(BikeDO bikeDO);
    
    /**
     * 更新
     *
     * @param bikeDO
     * @return
     */
    int update(BikeDO bikeDO);

    /**
     * 删除
     * @param bikeCode
     * @return
     */
    int delete(@Param("bikeCode") String bikeCode);
    
    /**
     * 捆绑投放点信息， 电车与投放点的关系
     * @param bikeBindSiteBO
     */
    int updateBikeBindSite(BikeBindSiteBO bikeBindSiteBO);
    
    /**
     * 捆绑投放点信息， 电车与员工的关系
     * @param bikeBindSidBO
     */
    int updateBikeBindStaff(BikeBindStaffBO bikeBindSidBO);
    
    /**
     * 解绑投放点信息， 电车与投放点的关系
     * @param
     */
    int updateBikeUnBindSite(@Param("bikeCode") String bikeCode);
    
    /**
     * 解绑投放点信息， 电车与员工的关系
     * @param
     */
    int updateBikeUnBindStaff(@Param("bikeCode") String bikeCode);
    
    /**
     * 获取电车信息信息
     * @param
     * @return
     */
    List<BikeDO> selectByCondition(BikeDO bikeDO);

    /**
     * 根据条件查询电车
     * @param bikeDO
     * @return
     */
    List<BikeDO> selectBikeByCondition(BikeDO bikeDO);
    
    /**
     * 获取电车信息个数
     * @param
     * @return
     */
    int selectCountByCondition(BikeDO bikeDO);
    /**
     * 查询加盟商每日运营单车数量
     * @param bikeCountDO
     * @return
     */
    int selectFranchiserOperaBikeCountByDay(BikeCountDO bikeCountDO);

}
