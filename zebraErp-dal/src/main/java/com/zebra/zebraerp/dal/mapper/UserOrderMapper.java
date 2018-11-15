package com.zebra.zebraerp.dal.mapper;

import java.util.List;

import com.zebra.zebraerp.dal.dataobject.*;
import com.zebra.zebraerp.dal.dataobject.FranchiserBikeOperateDO;

/**
 * 用户订单表MAPPER
 *
 * @author
 * @ClassName: UserOrderMapper
 * @Description: by CodeGenerate
 */

public interface UserOrderMapper {

    /**
     * 添加
     */
    public int insertUserOrder(UserOrderDO userOrderDO);

    /**
     * 根据主键查询
     */
    public UserOrderDO selectUserOrderById(Long orderId);

    /**
     * 查询列表
     */
    public List<UserOrderDO> selectUserOrderList(UserOrderDO userOrderDO);

    /**
     * 根据申请时间查询加盟商申请结算用户订单列表
     */
    List<UserOrderDO> selectUserOrderListByAppyTime(UserOrderSettlementDO userOrderSettlementDO);

    /**
     * 分页计数
     */
    int selectUserOrderCount(UserOrderListDO userOrderListDO);

    /**
     * 分页查找
     */
    List<UserOrderDO> selectUserOrderPage(UserOrderListDO userOrderListDO);

    /**
     * 完全修改
     */
    int updateUserOrder(UserOrderDO userOrderDO);

    /**
     * 选择性修改
     */
    int updateUserOrderSelective(UserOrderDO userOrderDO);

    /**
     * 批量更新用户订单
     *
     * @param userOrderBatchDO
     * @return
     */
    int batchUpdateUserOrder(UserOrderBatchDO userOrderBatchDO);

    /**
     * 查询用户订单列表
     *
     * @param userOrderListDO
     * @return
     */
    List<UserOrderDO> selectUserOrderListByBikeCodeList(UserOrderListDO userOrderListDO);

    /**
     * 查询加盟商单车使用情况
     *
     * @param bikeUseBO
     * @return
     */
    List<UserOrderDO> selectUserOrderListByFranchiserCode(FranchiserBikeOperateDO bikeUseBO);

    /**
     * 删除
     */
    int deleteUserOrder(String orderId);
}