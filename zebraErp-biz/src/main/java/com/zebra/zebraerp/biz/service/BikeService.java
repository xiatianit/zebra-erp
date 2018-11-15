package com.zebra.zebraerp.biz.service;

import java.util.List;

import com.zebra.zebraerp.dal.dataobject.BikeCountDO;
import com.zebra.zebraerp.dal.dataobject.BikeDO;
import com.zebra.zebraerp.dal.dataobject.businessObject.BikeBindSiteBO;
import com.zebra.zebraerp.dal.dataobject.businessObject.BikeBindStaffBO;
import com.zebra.zebraerp.dal.dataobject.businessObject.OperateInfoBO;


/**
 * 电车
 *
 * @author owen
 */
public interface BikeService {

    /**
     * 添加电车信息
     *
     * @param
     */
    void addBike(BikeDO bikeDO);

    /**
     * 修改电车信息
     *
     * @param
     */
    void editBike(BikeDO bikeDO);

    /**
     * 删除电车信息
     * @param bikeCode
     */
    void deleteBike(String bikeCode);

    /**
     * 捆绑投放点信息， 电车与投放点的关系
     *
     * @param
     */
    void editBikeBindSite(BikeBindSiteBO bikeBindSiteBO);


    /**
     * 捆绑投放点信息， 电车与员工的关系
     *
     * @param
     */
    void editBikeBindStaff(BikeBindStaffBO bikeBindSidBO);


    /**
     * 解绑投放点信息， 电车与投放点的关系
     *
     * @param
     */
    void editBikeUnBindSite(String bikeCode);

    /**
     * 解绑投放点信息， 电车与员工的关系
     *
     * @param
     */
    void editBikeUnBindStaff(String bikeCode);


    List<BikeDO> queryBikeListByCondition(BikeDO bikeDO);

    /**
     * 获取单车信息
     *
     * @param
     * @return
     */
    List<BikeDO> queryBikeList(BikeDO bikeDO);

    /**
     * 获取单车辆数
     *
     * @param bikeDO
     * @return
     */
    int queryBikeCount(BikeDO bikeDO);


    /**
     * 获取电车信息，根据主键 bikeCode
     *
     * @param
     * @return
     */
    BikeDO querySiteByPk(String bikeCode);

    /**
     * 查询运营商运营信息
     *
     * @return
     */
    OperateInfoBO queryFranchiserOperateInfo(String franchiserName, String franchiserCode);
    /**
     * 查询加盟商每天的运营车辆总数
     * @param bikeCountDO
     * @return
     */
    int queryBikeCountByDay(BikeCountDO bikeCountDO);

}
