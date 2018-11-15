package com.zebra.zebraerp.dal.dataobject;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 用户订单表DO
 *
 * @author
 * @ClassName: UserOrderDO
 * @Description: by CodeGenerate
 */
@Data
@ToString
public class UserOrderListDO extends PageDO implements Serializable {

    /**
     * 订单ID ( 主键 )
     */
    private String orderId;
    /**
     * 用户ID
     */
    private Long uid;
    /**
     * 订单是否已被加盟商申请结算
     */
    private Integer isApply;
    /**
     * 订单所属的申请结算记录ID
     */
    private Long settlementId;
    /**
     * 支付状态
     */
    private Integer payStatus;
    /**
     * 订单状态
     */
    private Integer orderStatus;
    /**
     * 单车列表
     */
    private List<String> bikeCodeList;
}