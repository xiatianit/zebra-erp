package com.zebra.zebraerp.biz.service.impl;

import com.zebra.pony.util.DateUtil;
import com.zebra.zebraerp.biz.service.BikeService;
import com.zebra.zebraerp.common.enums.UserOrderPayStatusEnum;
import com.zebra.zebraerp.common.enums.UserOrderStatusEnum;
import com.zebra.zebraerp.common.util.CollectionUtils;
import com.zebra.zebraerp.common.util.DoubleUtil;
import com.zebra.zebraerp.dal.dataobject.*;
import com.zebra.zebraerp.dal.dataobject.FranchiserBikeOperateDO;
import com.zebra.zebraerp.dal.dataobject.businessObject.FranchiserBikeUseBO;
import com.zebra.zebraerp.dal.dataobject.businessObject.FranchiserOperateBO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.zebra.zebraerp.dal.mapper.UserOrderMapper;
import com.zebra.zebraerp.biz.service.UserOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author
 * @ClassName: UserOrderServiceImpl
 * @Description: by CodeGenerate
 */
@Service
@Transactional
public class UserOrderServiceImpl implements UserOrderService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserOrderMapper masterUserOrderMapper;
    @Autowired
    private UserOrderMapper slaveUserOrderMapper;
    @Autowired
    private BikeService bikeService;

    @Override
    public UserOrderDO queryUserOrderById(long orderId) {

        UserOrderDO cUserOrder = this.slaveUserOrderMapper.selectUserOrderById(orderId);
        return cUserOrder;
    }

    @Override
    public List<UserOrderDO> queryUserOrderByPage(UserOrderListDO userOrderListDO) {
        List<UserOrderDO> list = this.slaveUserOrderMapper.selectUserOrderPage(userOrderListDO);
        return list;
    }

    @Override
    public Integer queryUserOrderCount(UserOrderListDO userOrderListDO) {
        return this.slaveUserOrderMapper.selectUserOrderCount(userOrderListDO);
    }

    @Override
    public List<UserOrderDO> queryUserOrderList(UserOrderDO userOrderDO) {
        List<UserOrderDO> list = this.slaveUserOrderMapper.selectUserOrderList(userOrderDO);
        return list;
    }

    @Override
    public List<UserOrderDO> queryUserOrderListByAppyTime(UserOrderSettlementDO userOrderSettlementDO) {
        List<UserOrderDO> userOrderDOList = this.slaveUserOrderMapper.selectUserOrderListByAppyTime(userOrderSettlementDO);
        return userOrderDOList;
    }

    @Override
    public void createUserOrder(UserOrderDO userOrderDO) {
        this.masterUserOrderMapper.insertUserOrder(userOrderDO);
    }

    @Override
    public int modifyUserOrder(UserOrderDO userOrderDO) {
        int num = this.masterUserOrderMapper.updateUserOrder(userOrderDO);
        return num;
    }

    @Override
    public int modifyUserOrderSelective(UserOrderDO userOrderDO) {
        int num = this.masterUserOrderMapper.updateUserOrderSelective(userOrderDO);
        return num;
    }

    @Override
    public int batchModifyUserOrder(UserOrderBatchDO userOrderBatchDO) {
        int num = this.masterUserOrderMapper.batchUpdateUserOrder(userOrderBatchDO);
        return num;
    }

    @Override
    public List<UserOrderDO> queryUserOrderByBikeCodeList(List<String> bikeCodeList) {
        UserOrderListDO userOrderListDO = new UserOrderListDO();
        userOrderListDO.setBikeCodeList(bikeCodeList);
        userOrderListDO.setPayStatus(UserOrderPayStatusEnum.HAVE_PAY.getPayStatusCode());
        userOrderListDO.setOrderStatus(UserOrderStatusEnum.OVER_RIDE.getOrderStatusCode());
        return this.slaveUserOrderMapper.selectUserOrderListByBikeCodeList(userOrderListDO);
    }

    @Override
    public List<FranchiserBikeUseBO> queryFranchiserBikeUseInfo(FranchiserOperateBO franchiserOperateBO) {
        FranchiserBikeOperateDO franchiserBikeOperateDO = new FranchiserBikeOperateDO();
        BeanUtils.copyProperties(franchiserOperateBO, franchiserBikeOperateDO);
        List<UserOrderDO> userOrderDOList = this.slaveUserOrderMapper.selectUserOrderListByFranchiserCode(franchiserBikeOperateDO);
        Map<String, List<UserOrderDO>> userOrderDayMap = new TreeMap<>();
        List<UserOrderDO> userOrderList;
        //根据日期分组
        if (CollectionUtils.isNotEmpty(userOrderDOList)) {
            for (UserOrderDO userOrderDO : userOrderDOList) {
                String date = DateUtil.formatyyyyMMdd(userOrderDO.getStartTime().longValue());
                List<UserOrderDO> userOrderDOS = userOrderDayMap.get(date);
                if (CollectionUtils.isNotEmpty(userOrderDOS)) {
                    userOrderDOS.add(userOrderDO);
                    userOrderDayMap.put(date, userOrderDOS);
                } else {
                    userOrderList = new ArrayList<>();
                    userOrderList.add(userOrderDO);
                    userOrderDayMap.put(date, userOrderList);
                }
            }
        }
        List<FranchiserBikeUseBO> franchiserBikeUseBOList = new ArrayList<>();
        FranchiserBikeUseBO franchiserBikeUseBO;
        //遍历分组后的map
        Iterator<Map.Entry<String, List<UserOrderDO>>> entries = userOrderDayMap.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, List<UserOrderDO>> entry = entries.next();
            String day = entry.getKey();
            BikeCountDO bikeCountDO = new BikeCountDO();
            bikeCountDO.setOperaDay(day);
            bikeCountDO.setFranchiserCode(franchiserOperateBO.getFranchiserCode());
            bikeCountDO.setFranchiserName(franchiserOperateBO.getFranchiserName());
            //今日单车运营总数
            int todayOperaTotalNum = bikeService.queryBikeCountByDay(bikeCountDO);
            //今日总收入
            Double todayIncom = 0.0;
            //今日单车使用数量
            Map<String, Integer> dayBikeUseNumMap = new HashMap<>();
            //今日用户数量
            Map<Long, Integer> dayUserNumMap = new HashMap<>();
            List<UserOrderDO> dayOrderList = entry.getValue();
            for (UserOrderDO userOrderDO : dayOrderList) {
                if (null != userOrderDO.getPayAmount()){
                    todayIncom = todayIncom + userOrderDO.getPayAmount();
                }
                Integer num = dayBikeUseNumMap.get(userOrderDO.getBikeCode());
                if (null == num) {
                    dayBikeUseNumMap.put(userOrderDO.getBikeCode(), 1);
                }
                Integer userNum = dayUserNumMap.get(userOrderDO.getUid());
                if (null == userNum) {
                    dayUserNumMap.put(userOrderDO.getUid(), 1);
                }
            }
            franchiserBikeUseBO = new FranchiserBikeUseBO();
            //日期
            franchiserBikeUseBO.setDateTime(day);
            //今日收入
            franchiserBikeUseBO.setDayIncom(todayIncom);
            //今日订单数量
            franchiserBikeUseBO.setDayOrderNum(dayOrderList.size());
            //今日单车使用量
            franchiserBikeUseBO.setDayBikeUseNum(dayBikeUseNumMap.size());
            //今日用户数量
            franchiserBikeUseBO.setDayUserNum(dayUserNumMap.size());
            //今日单车总数量
            franchiserBikeUseBO.setTotalBikeNum(todayOperaTotalNum);
            //笔单价 -- 总收入除以订单数量
            Double orderEveryTimePay = 0.0;
            if (dayOrderList.size() > 0 ){
                orderEveryTimePay = DoubleUtil.divide(todayIncom, (double) dayOrderList.size(), 2);
            }
            franchiserBikeUseBO.setOrderEveryPay(orderEveryTimePay);
            //客均单 -- 总订单数除以客数量
            Double userAverageNum = 0.0;
            if (dayUserNumMap.size() > 0){
                userAverageNum = DoubleUtil.divide((double) dayOrderList.size(), (double) dayUserNumMap.size(), 2);
            }

            franchiserBikeUseBO.setUserAverageNum(userAverageNum);
            //客单价 -- 总收入除以客数量
            Double userEveryTimePay = 0.0;
            if (dayUserNumMap.size() > 0){
                userEveryTimePay = DoubleUtil.divide(todayIncom, (double) dayUserNumMap.size(), 2);
            }
            franchiserBikeUseBO.setUserEveryPay(userEveryTimePay);
            //单车使用率 -- 每天使用数量除以每日运营总数量
            Double useRate = 0.0;
            if (todayOperaTotalNum > 0){
                useRate = DoubleUtil.divide((double) dayBikeUseNumMap.size(), (double) todayOperaTotalNum, 2);
            }
            franchiserBikeUseBO.setDayUseRate(useRate);
            franchiserBikeUseBOList.add(franchiserBikeUseBO);
        }
        return franchiserBikeUseBOList;
    }

    @Override
    public int removeUserOrder(String orderId) {
        int num = this.masterUserOrderMapper.deleteUserOrder(orderId);
        return num;
    }

}