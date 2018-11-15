package com.zebra.zebraerp.api.controller;

import com.zebra.pony.common.model.Result;
import com.zebra.pony.common.utils.ResultUtils;
import com.zebra.pony.util.JsonUtil;
import com.zebra.zebraerp.api.Interceptor.RequestLocalInfo;
import com.zebra.zebraerp.api.converter.UserConverter;
import com.zebra.zebraerp.api.viewobject.UserOrderDetailVO;
import com.zebra.zebraerp.api.viewobject.UserConsumeVO;
import com.zebra.zebraerp.biz.service.BikeService;
import com.zebra.zebraerp.biz.service.UserBaseService;
import com.zebra.zebraerp.biz.service.UserOrderService;
import com.zebra.zebraerp.biz.service.WalletService;
import com.zebra.zebraerp.common.enums.RoleTypeEnum;
import com.zebra.zebraerp.common.enums.UserDepositEnum;
import com.zebra.zebraerp.common.util.CollectionUtils;
import com.zebra.zebraerp.common.util.StringUtils;
import com.zebra.zebraerp.dal.dataobject.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiatian on 2018/1/10.
 */
@RestController
@RequestMapping("user")
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserBaseService userBaseService;
    @Autowired
    private UserOrderService userOrderService;
    @Autowired
    private BikeService bikeService;
    @Autowired
    private WalletService walletService;

    /**
     * 分页查询用户消费列表
     *
     * @param phone
     * @param pageIndex
     * @return
     */
    @RequestMapping(value = "/getConsume/list", method = RequestMethod.POST)
    public Result<?> queryUserConsumeList(@RequestParam(value = "phone", required = false) String phone,
                                          @RequestParam(value = "pageIndex", required = false) Integer pageIndex) {
        logger.info("获取用户消费列表信息，phone={},pageIndex={}", phone, pageIndex);
        UserConsumeDO userConsumeDO = new UserConsumeDO();
        if (StringUtils.isNotEmpty(phone)) {
            userConsumeDO.setPhone(phone);
        }
        //如果是加盟商,官方查看全部订单
        if (RoleTypeEnum.FRANCHISER_TYPE.getRoleTypeCode().equals(RequestLocalInfo.getManagerRoleType())) {
            userConsumeDO.setFranchiserCode(RequestLocalInfo.getFranchiserCode());
        }
        userConsumeDO.setPageIndex(pageIndex);
        List<UserConsumeDO> userConsumeDOList = userBaseService.queryUserConsumeList(userConsumeDO);
        Integer consumeCount = userBaseService.queryUserConsumeCount(userConsumeDO);
        for (UserConsumeDO userConsume : userConsumeDOList) {
            if (null != userConsume.getUid()) {
                WalletDO walletDO = walletService.queryWalletById(userConsume.getUid());
                if (null != walletDO) {
                    userConsume.setDepositStatus(walletDO.getDepositStatus());
                } else {
                    userConsume.setDepositStatus(UserDepositEnum.WEIJIAO_DEPOSIT.getDepositStatusCode());
                }

            }
        }

        List<UserConsumeVO> userConsumeListVO = UserConverter.UserConsumeDO2VO(userConsumeDOList);
        return ResultUtils.genResultWithSuccess("userConsumeList", userConsumeListVO, "count", consumeCount);
    }

    /**
     * 分页查询用户订单详情列表
     *
     * @param
     * @param pageIndex
     * @return
     */
    @RequestMapping(value = "/getOrderDetail/list", method = RequestMethod.POST)
    public Result<?> queryUserOrderDetailList(
            @RequestParam(value = "orderId", required = false) String orderId,
            @RequestParam(value = "bikeNo", required = false) String bikeNo,
            @RequestParam(value = "uid", required = false) Long uid,
            @RequestParam(value = "pageIndex", required = false) Integer pageIndex) {
        logger.info("获取用户订单详情列表信息,orderId={},bikeNo={},pageIndex={}", orderId, bikeNo, pageIndex);
        UserOrderListDO userOrderListDO = new UserOrderListDO();
        if (StringUtils.isNotEmpty(orderId)) {
            userOrderListDO.setOrderId(orderId);
        }
        if (null != uid && uid > 0){
            userOrderListDO.setUid(uid);
        }
        userOrderListDO.setPageIndex(pageIndex);
        List<String> bikeCodeList = new ArrayList<>();
        logger.info("当前登录ERP管理员信息，franchiserCode={},franchiserName={},managerRoleType={}", RequestLocalInfo.getFranchiserCode(), RequestLocalInfo.getFranchiserName(), RequestLocalInfo.getManagerRoleType());
        BikeDO bikeDO = new BikeDO();
        if (StringUtils.isNotEmpty(bikeNo)) {
            bikeDO.setBikeNo(bikeNo);
        }
        //如果是加盟商展示自己的订单,官方展示所有的订单
        if (RoleTypeEnum.FRANCHISER_TYPE.getRoleTypeCode().equals(RequestLocalInfo.getManagerRoleType())) {
            bikeDO.setFranchiserName(RequestLocalInfo.getFranchiserName());
            bikeDO.setFranchiserCode(RequestLocalInfo.getFranchiserCode());
        }
        logger.info("查询bikeDO={}", JsonUtil.getJsonFromObject(bikeDO));
        List<BikeDO> bikeDOList = bikeService.queryBikeListByCondition(bikeDO);
        if (CollectionUtils.isNotEmpty(bikeDOList)) {
            for (BikeDO bike : bikeDOList) {
                bikeCodeList.add(bike.getBikeCode());
            }
        }
        userOrderListDO.setBikeCodeList(bikeCodeList);
        logger.info("查询到的bikeCodeList={},用户订单列表,userOrderListDO={}", JsonUtil.getJsonFromObject(bikeCodeList), JsonUtil.getJsonFromObject(userOrderListDO));
        List<UserOrderDO> userOrderDOList = userOrderService.queryUserOrderByPage(userOrderListDO);
        Integer userOrderCount = userOrderService.queryUserOrderCount(userOrderListDO);
        List<UserOrderDetailVO> userOrderDetailVOList = UserConverter.UserOrderDO2UserOrderDetailVO(userOrderDOList);
        return ResultUtils.genResultWithSuccess("userOrderDetailList", userOrderDetailVOList, "count", userOrderCount);
    }

}
