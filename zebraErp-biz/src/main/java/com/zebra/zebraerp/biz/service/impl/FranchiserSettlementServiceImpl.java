package com.zebra.zebraerp.biz.service.impl;

import com.zebra.pony.util.DateUtil;
import com.zebra.zebraerp.biz.service.UserOrderService;
import com.zebra.zebraerp.common.Exception.ZebraerpException;
import com.zebra.zebraerp.common.enums.FranchiserOrderApplyStatusEnum;
import com.zebra.zebraerp.common.enums.SettlementStatusEnum;
import com.zebra.zebraerp.common.enums.UserOrderPayStatusEnum;
import com.zebra.zebraerp.common.util.CollectionUtils;
import com.zebra.zebraerp.dal.dataobject.UserOrderBatchDO;
import com.zebra.zebraerp.dal.dataobject.UserOrderDO;
import com.zebra.zebraerp.dal.dataobject.UserOrderSettlementDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zebra.zebraerp.dal.mapper.FranchiserSettlementMapper;
import com.zebra.zebraerp.dal.dataobject.FranchiserSettlementDO;
import com.zebra.zebraerp.biz.service.FranchiserSettlementService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author
 * @ClassName: FranchiserSettlementServiceImpl
 * @Description: by CodeGenerate
 */
@Service
@Transactional
public class FranchiserSettlementServiceImpl implements FranchiserSettlementService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private FranchiserSettlementMapper masterFranchiserSettlementMapper;
    @Autowired
    private FranchiserSettlementMapper slaveFranchiserSettlementMapper;
    @Autowired
    private UserOrderService userOrderService;

    @Override
    public FranchiserSettlementDO queryFranchiserSettlementById(long id) {

        FranchiserSettlementDO cFranchiserSettlement = this.slaveFranchiserSettlementMapper.selectFranchiserSettlementById(id);
        return cFranchiserSettlement;
    }

    @Override
    public List<FranchiserSettlementDO> queryFranchiserSettlementByPage(FranchiserSettlementDO franchiserSettlementDO) {

        List<FranchiserSettlementDO> list = this.slaveFranchiserSettlementMapper.selectFranchiserSettlementPage(franchiserSettlementDO);
        return list;
    }

    @Override
    public Integer queryFranchiserSettlementCount(FranchiserSettlementDO franchiserSettlementDO) {
        return this.slaveFranchiserSettlementMapper.selectFranchiserSettlementCount(franchiserSettlementDO);
    }

    @Override
    public List<FranchiserSettlementDO> queryFranchiserSettlementList(FranchiserSettlementDO franchiserSettlementDO) {
        List<FranchiserSettlementDO> list = this.slaveFranchiserSettlementMapper.selectFranchiserSettlementList(franchiserSettlementDO);
        return list;
    }

    @Override
    public void createFranchiserSettlement(FranchiserSettlementDO franchiserSettlementDO) {
        this.masterFranchiserSettlementMapper.insertFranchiserSettlement(franchiserSettlementDO);
    }

    @Override
    public int modifyFranchiserSettlement(FranchiserSettlementDO franchiserSettlementDO) {
        int num = this.masterFranchiserSettlementMapper.updateFranchiserSettlement(franchiserSettlementDO);
        return num;
    }

    @Override
    public int modifyFranchiserSettlementSelective(FranchiserSettlementDO franchiserSettlementDO) {
        int num = this.masterFranchiserSettlementMapper.updateFranchiserSettlementSelective(franchiserSettlementDO);
        return num;
    }

    @Override
    public int removeFranchiserSettlement(long id) {
        int num = this.masterFranchiserSettlementMapper.deleteFranchiserSettlement(id);
        return num;
    }

    @Override
    public void franchiserSettlementApply(String franchiserCode, String franchiserName, Integer appyTime) {
        //查询当前加盟商当前申请时间日期之前的所有未申请过结算并且是用户已经支付过的订单，生成申请结算记录
        UserOrderSettlementDO userOrderSettlementDO = new UserOrderSettlementDO();
        userOrderSettlementDO.setFranchiserCode(franchiserCode);
        userOrderSettlementDO.setAppyTime(DateUtil.getTodayStartTimeSeconds());
        userOrderSettlementDO.setIsApply(FranchiserOrderApplyStatusEnum.NOT_APPLY.getApplyStatusCode());
        userOrderSettlementDO.setPayStatus(UserOrderPayStatusEnum.HAVE_PAY.getPayStatusCode());
        List<UserOrderDO> userOrderDOList = userOrderService.queryUserOrderListByAppyTime(userOrderSettlementDO);
        Double settlementAmount = 0.0;
        List<String> orderIds = new ArrayList<>();
        if (CollectionUtils.isEmpty(userOrderDOList)) {
            throw new ZebraerpException("没有未申请结算的用户订单");
        }
        for (UserOrderDO userOrderDO : userOrderDOList) {
            settlementAmount = settlementAmount + userOrderDO.getPayAmount();
            orderIds.add(userOrderDO.getOrderId());
        }
        //生成申请结算记录
        FranchiserSettlementDO franchiserSettlementDO = new FranchiserSettlementDO();
        franchiserSettlementDO.setFranchiserName(franchiserName);
        franchiserSettlementDO.setFranchiserCode(franchiserCode);
        franchiserSettlementDO.setStatus(SettlementStatusEnum.WAIT_TRANSFER.getTransferStatusCode());
        franchiserSettlementDO.setSettlementAmount(settlementAmount);
        franchiserSettlementDO.setApplyTime(new Date());
        masterFranchiserSettlementMapper.insertFranchiserSettlement(franchiserSettlementDO);
        //更新查询到的订单的申请结算记录和申请结算的ID
        UserOrderBatchDO userOrderBatchDO = new UserOrderBatchDO();
        userOrderBatchDO.setIsApply(FranchiserOrderApplyStatusEnum.HAVED_APPLY.getApplyStatusCode());
        userOrderBatchDO.setSettlementId(franchiserSettlementDO.getId());
        userOrderBatchDO.setOrderIds(orderIds);
        userOrderService.batchModifyUserOrder(userOrderBatchDO);
    }
}