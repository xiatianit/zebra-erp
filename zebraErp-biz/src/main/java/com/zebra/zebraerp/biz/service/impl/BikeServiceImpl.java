package com.zebra.zebraerp.biz.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zebra.zebraerp.biz.service.UserOrderService;
import com.zebra.zebraerp.common.util.CollectionUtils;
import com.zebra.zebraerp.common.util.DoubleUtil;
import com.zebra.zebraerp.dal.dataobject.BikeCountDO;
import com.zebra.zebraerp.dal.dataobject.UserOrderDO;
import com.zebra.zebraerp.dal.dataobject.businessObject.OperateInfoBO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zebra.zebraerp.biz.service.BikeService;
import com.zebra.zebraerp.biz.service.SiteService;
import com.zebra.zebraerp.common.Exception.ZebraerpException;
import com.zebra.pony.util.JsonUtil;
import com.zebra.zebraerp.dal.dataobject.BikeDO;
import com.zebra.zebraerp.dal.dataobject.SiteDO;
import com.zebra.zebraerp.dal.dataobject.businessObject.BikeBindStaffBO;
import com.zebra.zebraerp.dal.dataobject.businessObject.BikeBindSiteBO;
import com.zebra.zebraerp.dal.mapper.BikeMapper;
import org.springframework.transaction.annotation.Transactional;

/**
 * 电车
 *
 * @author owen
 */
@Service
@Transactional
public class BikeServiceImpl implements BikeService {

    private final static Logger logger = LoggerFactory.getLogger(BikeServiceImpl.class);

    @Autowired
    private BikeMapper masterBikeMapper;

    @Autowired
    private BikeMapper slaveBikeMapper;

    @Autowired
    private SiteService siteService;

    @Autowired
    private UserOrderService userOrderService;

    /***
     * 新增bike
     */
    @Override
    public void addBike(BikeDO bikeDO) {
        logger.info("新增电车，bikeDO={}", JsonUtil.getJsonFromObject(bikeDO));
            BikeDO bike = this.slaveBikeMapper.selectByPk(bikeDO.getBikeCode());
            if (null != bike) {
                throw new ZebraerpException("当前GPRS号码" + bikeDO.getGprsPhone() + "已存在");
            }
            int effectRows = masterBikeMapper.insert(bikeDO);
            if (effectRows == 0) {
                throw new ZebraerpException("新增电车失败");
            }
    }

    /**
     * 修改电车信息
     *
     * @param
     */
    public void editBike(BikeDO bikeDO) {
        logger.info("修改电车，bikeDO={}", JsonUtil.getJsonFromObject(bikeDO));
        if (null == bikeDO.getBikeCode()) {
            throw new ZebraerpException("电车编号不能为空");
        }
        int effectRows = masterBikeMapper.update(bikeDO);
        if (effectRows == 0) {
            throw new ZebraerpException("修改电车失败");
        }
    }

    @Override
    public void deleteBike(String bikeCode) {
        logger.info("删除电车，bikeCode={}", bikeCode);
        masterBikeMapper.delete(bikeCode);
    }

    /**
     * 捆绑投放点信息， 电车与投放点的关系
     *
     * @param
     */
    public void editBikeBindSite(BikeBindSiteBO bikeBindSiteBO) {
        logger.info("捆绑投放点信息， 电车与投放点的关系，bikeBindSiteBO={}", JsonUtil.getJsonFromObject(bikeBindSiteBO));
        //根据site_id,site_name 获取相对应的city_code,city_name,zone_code,zone_name
        SiteDO siteDO = siteService.querySiteByPk(bikeBindSiteBO.getSiteId());
        bikeBindSiteBO.setSiteName(siteDO.getSiteName());
        bikeBindSiteBO.setCityCode(siteDO.getCityCode());
        bikeBindSiteBO.setCityName(siteDO.getCityName());
        bikeBindSiteBO.setZoneCode(siteDO.getZoneCode());
        bikeBindSiteBO.setZoneName(siteDO.getZoneName());
        int effectRows = masterBikeMapper.updateBikeBindSite(bikeBindSiteBO);
        if (effectRows == 0) {
            logger.error("捆绑投放点信息， 电车与投放点的关系，bikeBindSiteBO={}", JsonUtil.getJsonFromObject(bikeBindSiteBO));
            throw new ZebraerpException("捆绑投放点信息， 电车与投放点关联失败");
        }
    }

    /**
     * 捆绑投放点信息， 电车与员工的关系
     *
     * @param
     */
    public void editBikeBindStaff(BikeBindStaffBO bikeBindStaffBO) {
        logger.info("捆绑投放点信息， 电车与员工的关系，bikeBindSidBO={}", JsonUtil.getJsonFromObject(bikeBindStaffBO));
        try {
            int effectRows = masterBikeMapper.updateBikeBindStaff(bikeBindStaffBO);
            if (effectRows == 0) {
                throw new ZebraerpException("捆绑投放点信息， 电车与员工失败");
            }
        } catch (Exception e) {
            logger.error("捆绑投放点信息， 电车与员工的关系，bikeBindStaffBO={},e={}", JsonUtil.getJsonFromObject(bikeBindStaffBO), e);
            throw new ZebraerpException("捆绑投放点信息， 电车与员工的关系失败");
        }
    }

    /**
     * 解绑投放点信息， 电车与投放点的关系
     *
     * @param bikeCode
     */
    public void editBikeUnBindSite(String bikeCode) {
        logger.info("解绑投放点信息， 电车与投放点的关系，bikeCode={}", bikeCode);
        try {
            int effectRows = masterBikeMapper.updateBikeUnBindSite(bikeCode);
            if (effectRows == 0) {
                throw new ZebraerpException("解绑投放点信息， 电车与投放点失败");
            }
        } catch (Exception e) {
            logger.error("解绑投放点信息， 电车与投放点的关系，bikeCode={},e={}", bikeCode, e);
            throw new ZebraerpException("解绑投放点信息， 电车与投放点的关系失败");
        }
    }

    /**
     * 解绑投放点信息， 电车与员工的关系
     *
     * @param bikeCode
     */
    public void editBikeUnBindStaff(String bikeCode) {

        logger.info("解绑投放点信息， 电车与员工的关系，bikeCode={}", bikeCode);
        try {
            int effectRows = masterBikeMapper.updateBikeUnBindStaff(bikeCode);
            if (effectRows == 0) {
                throw new ZebraerpException("解绑投放点信息， 电车与员工失败");
            }
        } catch (Exception e) {
            logger.error("解绑投放点信息， 电车与员工的关系，bikeCode={},e={}", bikeCode, e);
            throw new ZebraerpException("解绑投放点信息， 电车与员工的关系失败");
        }

    }

    @Override
    public List<BikeDO> queryBikeListByCondition(BikeDO bikeDO) {
        return slaveBikeMapper.selectBikeByCondition(bikeDO);
    }

    /**
     * 获取电车列表
     */
    @Override
    public List<BikeDO> queryBikeList(BikeDO bikeDO) {
        return slaveBikeMapper.selectByCondition(bikeDO);
    }

    /**
     * 获取电车数量
     */
    @Override
    public int queryBikeCount(BikeDO bikeDO) {
        return slaveBikeMapper.selectCountByCondition(bikeDO);
    }

    /**
     * 获取电车信息，根据主键 bikeCode
     *
     * @param
     * @return
     */
    public BikeDO querySiteByPk(String bikeCode) {
        return slaveBikeMapper.selectByPk(bikeCode);
    }

    @Override
    public OperateInfoBO queryFranchiserOperateInfo(String franchiserName, String franchiserCode) {
        BikeDO bikeDO = new BikeDO();
        bikeDO.setFranchiserCode(franchiserCode);
        bikeDO.setFranchiserName(franchiserName);
        List<BikeDO> bikeDOList = slaveBikeMapper.selectByCondition(bikeDO);
        List<String> bikeCodeList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(bikeDOList)) {
            for (BikeDO bike : bikeDOList) {
                bikeCodeList.add(bike.getBikeCode());
            }
        }
        if (CollectionUtils.isEmpty(bikeCodeList)) {
            throw new ZebraerpException("当前加盟商车辆为空，请添加加盟商车辆");
        }
        List<UserOrderDO> userOrderDOList = userOrderService.queryUserOrderByBikeCodeList(bikeCodeList);
        Map<Long, List<UserOrderDO>> userMap = new HashMap<>();
        List<UserOrderDO> userOrderDOs;
        int totalUserNum = 0;
        Double totalIncom = 0.0;
        if (CollectionUtils.isNotEmpty(userOrderDOList)) {
            for (UserOrderDO userOrderDO : userOrderDOList) {
                Long uid = userOrderDO.getUid();
                //实际支付金额
                Double payAmount = userOrderDO.getPayAmount();
                if (null != payAmount && payAmount > 0) {
                    totalIncom = totalIncom + payAmount;
                }
                if (CollectionUtils.isNotEmpty(userMap.get(uid))) {
                    List<UserOrderDO> userOrderDOS = userMap.get(uid);
                    userOrderDOS.add(userOrderDO);
                    userMap.put(uid, userOrderDOS);
                } else {
                    totalUserNum = totalUserNum + 1;
                    userOrderDOs = new ArrayList<>();
                    userOrderDOs.add(userOrderDO);
                    userMap.put(uid, userOrderDOs);
                }
            }
        }
        OperateInfoBO operateInfoBO = new OperateInfoBO();
        operateInfoBO.setTotalBikeNum(bikeCodeList.size());
        operateInfoBO.setTotalOrderNum(userOrderDOList.size());
        operateInfoBO.setTotalUserNum(totalUserNum);
        operateInfoBO.setTotalIncom(totalIncom);
        //笔单价 -- 总收入除以订单数量
        Double orderEveryTimePay = 0.0;
        if (userOrderDOList.size() > 0) {
            orderEveryTimePay = DoubleUtil.divide(totalIncom, (double) userOrderDOList.size(), 2);
        }
        operateInfoBO.setOrderEveryPay(orderEveryTimePay);
        //客均单 -- 总订单数除以客数量
        Double userAverageNum = 0.0;
        if (totalUserNum > 0) {
            userAverageNum = DoubleUtil.divide((double) userOrderDOList.size(), (double) totalUserNum, 2);
        }
        operateInfoBO.setUserAverageNum(userAverageNum);
        //客单价 -- 总收入除以客数量
        Double userEveryTimePay = 0.0;
        if (totalUserNum > 0) {
            userEveryTimePay = DoubleUtil.divide(totalIncom, (double) totalUserNum, 2);
        }
        operateInfoBO.setUserEveryPay(userEveryTimePay);

        return operateInfoBO;
    }

    @Override
    public int queryBikeCountByDay(BikeCountDO bikeCountDO) {
        return this.slaveBikeMapper.selectFranchiserOperaBikeCountByDay(bikeCountDO);
    }
}
