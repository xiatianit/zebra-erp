package com.zebra.zebraerp.biz.service;

import java.util.List;


import com.zebra.zebraerp.dal.dataobject.UserOrderBatchDO;
import com.zebra.zebraerp.dal.dataobject.UserOrderDO;
import com.zebra.zebraerp.dal.dataobject.UserOrderListDO;
import com.zebra.zebraerp.dal.dataobject.UserOrderSettlementDO;
import com.zebra.zebraerp.dal.dataobject.businessObject.FranchiserBikeUseBO;
import com.zebra.zebraerp.dal.dataobject.businessObject.FranchiserOperateBO;

/**
 * 用户订单表Service
 *
 * @author
 * @ClassName: UserOrderService
 * @Description: by CodeGenerate
 */
public interface UserOrderService {

    /**
     * 根据id查询
     *
     * @param orderId
     * @return
     */
    UserOrderDO queryUserOrderById(long orderId);

    /**
     * 分页查询
     *
     * @param userOrderListDO
     * @return
     */
    List<UserOrderDO> queryUserOrderByPage(UserOrderListDO userOrderListDO);

    /**
     * 查询用户订单数量
     *
     * @param userOrderListDO
     * @return
     */
    Integer queryUserOrderCount(UserOrderListDO userOrderListDO);

    /**
     * 查询列表
     *
     * @param userOrderDO
     * @return
     */
    List<UserOrderDO> queryUserOrderList(UserOrderDO userOrderDO);

    /**
     * @param userOrderSettlementDO
     * @return
     */
    List<UserOrderDO> queryUserOrderListByAppyTime(UserOrderSettlementDO userOrderSettlementDO);

    /**
     * 创建
     *
     * @param userOrderDO
     * @return
     */
    void createUserOrder(UserOrderDO userOrderDO);

    /**
     * 修改
     *
     * @param userOrderDO
     * @return
     */
    int modifyUserOrder(UserOrderDO userOrderDO);

    /**
     * 选择性修改
     *
     * @param userOrderDO
     * @return
     */
    int modifyUserOrderSelective(UserOrderDO userOrderDO);

    /**
     * 批量更新用户订单
     *
     * @param userOrderBatchDO
     * @return
     */
    int batchModifyUserOrder(UserOrderBatchDO userOrderBatchDO);

    /**
     * 根据bikeCode查询用户订单
     *
     * @param bikeCodeList
     * @return
     */
    List<UserOrderDO> queryUserOrderByBikeCodeList(List<String> bikeCodeList);

    /**
     * 查询加盟商整体运营情况
     * @param franchiserOperateBO
     * @return
     */
    List<FranchiserBikeUseBO> queryFranchiserBikeUseInfo(FranchiserOperateBO franchiserOperateBO);

    /**
     * 删除
     *
     * @param orderId
     * @return
     */
    int removeUserOrder(String orderId);

}