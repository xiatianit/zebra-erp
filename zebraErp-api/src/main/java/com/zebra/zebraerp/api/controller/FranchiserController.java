package com.zebra.zebraerp.api.controller;

import com.zebra.pony.common.model.Result;
import com.zebra.pony.common.utils.ResultUtils;
import com.zebra.pony.util.DateUtil;
import com.zebra.pony.util.JsonUtil;
import com.zebra.zebraerp.api.Interceptor.RequestLocalInfo;
import com.zebra.zebraerp.api.converter.FranchiserConverter;
import com.zebra.zebraerp.api.converter.UserConverter;
import com.zebra.zebraerp.api.paramobject.FranchiserAddPO;
import com.zebra.zebraerp.api.viewobject.BikeChargePriceVO;
import com.zebra.zebraerp.api.viewobject.FranchiserSettlementVO;
import com.zebra.zebraerp.api.viewobject.FranchiserVO;
import com.zebra.zebraerp.api.viewobject.UserOrderDetailVO;
import com.zebra.zebraerp.biz.service.BikeChargePriceService;
import com.zebra.zebraerp.biz.service.FranchiserBaseService;
import com.zebra.zebraerp.biz.service.FranchiserSettlementService;
import com.zebra.zebraerp.biz.service.UserOrderService;
import com.zebra.zebraerp.common.Exception.ZebraerpException;
import com.zebra.zebraerp.common.enums.FranchiserOrderApplyStatusEnum;
import com.zebra.zebraerp.common.enums.RoleTypeEnum;
import com.zebra.zebraerp.common.enums.SettlementStatusEnum;
import com.zebra.zebraerp.common.enums.UserOrderPayStatusEnum;
import com.zebra.zebraerp.common.util.CollectionUtils;
import com.zebra.zebraerp.common.util.DateUtils;
import com.zebra.zebraerp.common.util.StringUtils;
import com.zebra.zebraerp.dal.dataobject.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by xiatian on 2018/1/7.
 */
@RestController
@RequestMapping("franchiser")
public class FranchiserController {

    private final static Logger logger = LoggerFactory.getLogger(FranchiserController.class);


    @Autowired
    private FranchiserBaseService franchiserBaseService;
    @Autowired
    private FranchiserSettlementService franchiserSettlementService;
    @Autowired
    private UserOrderService userOrderService;
    @Autowired
    private BikeChargePriceService bikeChargePriceService;

    /**
     * 分页查询加盟商列表
     *
     * @param phone
     * @param franchiserName
     * @param franchiserCode
     * @param pageIndex
     * @return
     */
    @RequestMapping(value = "/getList", method = RequestMethod.POST)
    public Result<?> queryFranchiserList(@RequestParam(value = "phone", required = false) String phone,
                                         @RequestParam(value = "franchiserName", required = false) String franchiserName,
                                         @RequestParam(value = "franchiserCode", required = false) String franchiserCode,
                                         @RequestParam(value = "pageIndex", required = false) Integer pageIndex) {
        logger.info("查询加盟商列表信息,phone={},franchiserName={},franchiserCode={},pageIndex={}", phone, franchiserName, franchiserCode, pageIndex);
        FranchiserBaseDO franchiserBaseDO = new FranchiserBaseDO();
        if (StringUtils.isNotEmpty(franchiserCode)) {
            franchiserBaseDO.setFranchiserCode(franchiserCode);
        }
        if (StringUtils.isNotEmpty(franchiserName)) {
            franchiserBaseDO.setFranchiserName(franchiserName);
        }
        if (StringUtils.isNotEmpty(phone)) {
            franchiserBaseDO.setPhone(phone);
        }
        franchiserBaseDO.setPageIndex(pageIndex);
        List<FranchiserBaseDO> franchiserBaseDOList = franchiserBaseService.queryFranchiserBaseByPage(franchiserBaseDO);
        int baseCount = franchiserBaseService.queryFranchiserBaseCount(franchiserBaseDO);
        List<FranchiserVO> franchiserVOList = FranchiserConverter.franchiserDO2VO(franchiserBaseDOList);
        return ResultUtils.genResultWithSuccess("franchiserList", franchiserVOList, "count", baseCount);

    }

    /**
     * 获取所有加盟商信息列表
     *
     * @return
     */
   /* @RequestMapping(value = "/getAllList", method = RequestMethod.POST)
    public Result<?> queryAllFranchiserList() {
        logger.info("查询所有加盟商列表信息");
        List<FranchiserBaseDO> franchiserBaseDOList = franchiserBaseService.queryFranchiserBaseList(new FranchiserBaseDO());
        List<FranchiserVO> franchiserVOList = FranchiserConverter.franchiserDO2VO(franchiserBaseDOList);
        return ResultUtils.genResultWithSuccess(franchiserVOList);
    }*/
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<?> addFranchiser(FranchiserAddPO franchiserAddPO) {
        logger.info("添加加盟商入参,franchiserAddPO={}", JsonUtil.getJsonFromObject(franchiserAddPO));
        try {
            FranchiserBaseDO franchiserBaseDO = new FranchiserBaseDO();
            BeanUtils.copyProperties(franchiserAddPO, franchiserBaseDO);
            franchiserBaseService.addFranchiser(franchiserBaseDO);
        } catch (ZebraerpException e) {
            logger.error("添加加盟商异常" + e.getMessage());
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("添加加盟商异常" + e.getMessage());
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
        return ResultUtils.genResultWithSuccess();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<?> editFranchiser(FranchiserAddPO franchiserAddPO) {
        logger.info("编辑加盟商入参,franchiserAddPO={}", JsonUtil.getJsonFromObject(franchiserAddPO));
        try {
            FranchiserBaseDO franchiserBaseDO = new FranchiserBaseDO();
            BeanUtils.copyProperties(franchiserAddPO, franchiserBaseDO);
            franchiserBaseService.modifyFranchiserBaseSelective(franchiserBaseDO);
            return ResultUtils.genResultWithSuccess();
        } catch (ZebraerpException e) {
            logger.error("编辑加盟商异常e={}", e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("编辑加盟商异常e={}", e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }

    @RequestMapping(value = "/getDetail", method = RequestMethod.POST)
    public Result<FranchiserVO> getFranchiserDetail(@RequestParam(value = "franchiserCode", required = true) String franchiserCode) {
        logger.info("查看加盟商详情入参,franchiserCode={}", franchiserCode);
        FranchiserBaseDO franchiserBaseDO = franchiserBaseService.queryFranchiserBaseById(franchiserCode);
        FranchiserVO franchiserVO = FranchiserConverter.franchiserBaseDO2VODetail(franchiserBaseDO);
        return ResultUtils.genResultWithSuccess("franchiserDetail", franchiserVO);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result<?> deleteFranchiser(@RequestParam(value = "franchiserCode", required = true) String franchiserCode) {
        logger.info("删除加盟商入参,franchiserCode={}", franchiserCode);
        franchiserBaseService.removeFranchiserBase(franchiserCode);
        return ResultUtils.genResultWithSuccess();
    }

    /**
     * 加盟商申请结算
     *
     * @return
     */
    @RequestMapping(value = "/settlement/apply", method = RequestMethod.POST)
    public Result<?> franchiserApplySettlement() {
        logger.info("加盟商申请结算记录入参,franchiserCode={},applyTime={}", RequestLocalInfo.getFranchiserCode(), DateUtil.getTodayStartTimeSeconds());
        try {
            franchiserSettlementService.franchiserSettlementApply(RequestLocalInfo.getFranchiserCode(), RequestLocalInfo.getFranchiserName(), DateUtil.getTodayStartTimeSeconds());
            return ResultUtils.genResultWithSuccess();
        } catch (ZebraerpException e) {
            logger.error("加盟商申请结算异常,franchiserCode={},e={}", RequestLocalInfo.getFranchiserCode(), e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("加盟商申请结算异常,franchiserCode={},e", RequestLocalInfo.getFranchiserCode(), e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }

    /**
     * 获取当前日期
     * @return
     */
    @RequestMapping(value = "/current/date", method = RequestMethod.POST)
    public Result<?> getCurrentDate() {
        logger.info("获取当前日期");
        String date = DateUtils.getDate(new Date());
        return ResultUtils.genResultWithSuccess("currentDate", date);
    }


    /**
     * 加盟商结算申请列表查询
     *
     * @param id
     * @param franchiserName
     * @param status
     * @param pageIndex
     * @return
     */
    @RequestMapping(value = "/settlement/apply/list", method = RequestMethod.POST)
    public Result<?> getSettlementApplyList(@RequestParam(value = "id", required = false) Long id,
                                            @RequestParam(value = "franchiserName", required = false) String franchiserName,
                                            @RequestParam(value = "status", required = false) Integer status,
                                            @RequestParam(value = "pageIndex", required = false) Integer pageIndex) {
        logger.info("查询加盟商申请结算列表,id={},franchiserName={},status={},pageIndex={}", id, franchiserName, status, pageIndex);
        try {
            FranchiserSettlementDO franchiserSettlementDO = new FranchiserSettlementDO();
            if (null != id && id > 0) {
                franchiserSettlementDO.setId(id);
            }
            //如果是加盟商
            if (RoleTypeEnum.FRANCHISER_TYPE.getRoleTypeCode().equals(RequestLocalInfo.getManagerRoleType())) {
                franchiserSettlementDO.setFranchiserName(RequestLocalInfo.getFranchiserName());
                franchiserSettlementDO.setFranchiserCode(RequestLocalInfo.getFranchiserCode());
            }
            if (null != status && status > 0) {
                franchiserSettlementDO.setStatus(status);
            }
            if (StringUtils.isNotEmpty(franchiserName)) {
                franchiserSettlementDO.setFranchiserName(franchiserName);
            }
            franchiserSettlementDO.setPageIndex(pageIndex);
            List<FranchiserSettlementDO> franchiserSettlementDOList = franchiserSettlementService.queryFranchiserSettlementByPage(franchiserSettlementDO);
            List<FranchiserSettlementVO> franchiserSettlementVOList = FranchiserConverter.franchiserSettlementDO2VO(franchiserSettlementDOList);
            Integer settlementCount = franchiserSettlementService.queryFranchiserSettlementCount(franchiserSettlementDO);
            return ResultUtils.genResultWithSuccess("franchiserSettlementList", franchiserSettlementVOList, "count", settlementCount);
        } catch (ZebraerpException e) {
            logger.error("查询加盟商申请结算列表,id={},franchiserName={},status={},pageIndex={},e={}", id, franchiserName, status, pageIndex, e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("查询加盟商申请结算列表,id={},franchiserName={},status={},pageIndex={},e={}", id, franchiserName, status, pageIndex, e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }

    /**
     * 加盟商申请结算详情列表
     *
     * @param settlementId
     * @param pageIndex
     * @return
     */
    @RequestMapping(value = "/settlement/apply/detail/list", method = RequestMethod.POST)
    public Result<?> getSettlementApplyDetailList(@RequestParam(value = "settlementId", required = false) Long settlementId,
                                                  @RequestParam(value = "pageIndex", required = false) Integer pageIndex) {
        logger.info("加盟商申请结算详情列表,settlementId={},pageIndex={}", settlementId, pageIndex);
        UserOrderListDO userOrderListDO = new UserOrderListDO();
        userOrderListDO.setIsApply(FranchiserOrderApplyStatusEnum.HAVED_APPLY.getApplyStatusCode());
        if (null != settlementId && settlementId > 0) {
            userOrderListDO.setSettlementId(settlementId);
        }
        userOrderListDO.setPageIndex(pageIndex);
        List<UserOrderDO> userOrderDOList = userOrderService.queryUserOrderByPage(userOrderListDO);
        Integer userOrderCount = userOrderService.queryUserOrderCount(userOrderListDO);
        List<UserOrderDetailVO> userOrderDetailVOList = UserConverter.UserOrderDO2UserOrderDetailVO(userOrderDOList);
        return ResultUtils.genResultWithSuccess("userOrderDetailList", userOrderDetailVOList, "count", userOrderCount);

    }

    /**
     * 修改加盟商结算申请状态
     *
     * @param id
     * @param status
     * @return
     */
    @RequestMapping(value = "/settlement/status/update", method = RequestMethod.POST)
    public Result<?> editFranchiserSettlement(@RequestParam(value = "id", required = false) Long id,
                                              @RequestParam(value = "status", required = false) Integer status) {
        logger.info("修改加盟商结算申请入参,id={},status={}", id, status);
        try {
            FranchiserSettlementDO franchiserSettlementDO = new FranchiserSettlementDO();
            franchiserSettlementDO.setId(id);
            franchiserSettlementDO.setStatus(status);
            franchiserSettlementService.modifyFranchiserSettlementSelective(franchiserSettlementDO);
            return ResultUtils.genResultWithSuccess();
        } catch (ZebraerpException e) {
            logger.error("修改加盟商结算申请，id={},e", id, e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("修改加盟商结算申请，id={},e", id, e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }

    /**
     * 查看加盟商单车定价列表
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/bike/price/list", method = RequestMethod.POST)
    public Result<?> getFranchiserBikePriceList() {
        logger.info("查看加盟商单车价格列表入参,franchiserCode={}", RequestLocalInfo.getFranchiserCode());
        try {
            BikeChargePriceDO bikeChargePriceDO = new BikeChargePriceDO();
            bikeChargePriceDO.setFranchiserCode(RequestLocalInfo.getFranchiserCode());
            List<BikeChargePriceDO> bikeChargePriceDOList = bikeChargePriceService.queryBikeChargePriceList(bikeChargePriceDO);
            List<BikeChargePriceVO> bikeChargePriceVOList = FranchiserConverter.bikeChargePriceDO2VO(bikeChargePriceDOList);
            return ResultUtils.genResultWithSuccess("bikeChargePriceList", bikeChargePriceVOList);
        } catch (ZebraerpException e) {
            logger.error("查看加盟商单车价格列表e", e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("查看加盟商单车价格列表e", e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }

    /**
     * 加盟商单车定价设置
     *
     * @param bikeModelCode
     * @return
     */
    @RequestMapping(value = "/bike/price/set", method = RequestMethod.POST)
    public Result<?> addFranchiserBikePrice(@RequestParam(value = "bikeModelCode", required = true) String bikeModelCode,
                                            @RequestParam(value = "bikeModelName", required = true) String bikeModelName,
                                            @RequestParam(value = "unitPrice", required = true) Double unitPrice,
                                            @RequestParam(value = "unit", required = true) Integer unit) {
        logger.info("设置加盟商单车价格入参,bikeModelCode={},bikeModelName={},unitPrice={},unit={}", bikeModelCode, bikeModelName, unitPrice, unit);
        try {
            BikeChargePriceDO bikeChargePriceDO = new BikeChargePriceDO();
            bikeChargePriceDO.setBikeModelCode(bikeModelCode);
            bikeChargePriceDO.setBikeModelName(bikeModelName);
            bikeChargePriceDO.setUnitPrice(unitPrice);
            bikeChargePriceDO.setUnit(unit);
            bikeChargePriceDO.setFranchiserCode(RequestLocalInfo.getFranchiserCode());
            bikeChargePriceDO.setFranchiserName(RequestLocalInfo.getFranchiserName());
            bikeChargePriceService.createBikeChargePrice(bikeChargePriceDO);
            return ResultUtils.genResult(0, "定价设置成功");
        } catch (ZebraerpException e) {
            logger.error("设置加盟商单车价格异常", e.getMessage());
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error("设置加盟商单车价格异常", e.getMessage());
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }

    /**
     * 加盟商单车定价更新
     *
     * @return
     */
    @RequestMapping(value = "/bike/price/update", method = RequestMethod.POST)
    public Result<?> ranchiserBikePrice(@RequestParam(value = "id", required = true) Long id,
                                        @RequestParam(value = "unitPrice", required = false) Double unitPrice,
                                        @RequestParam(value = "bikeModelName", required = false) String bikeModelName,
                                        @RequestParam(value = "bikeModelCode", required = false) String bikeModelCode,
                                        @RequestParam(value = "unit", required = false) Integer unit) {
        logger.info("更新加盟商单车价格入参,id={},unitPrice={},bikeModelName={},bikeModelCode={},unit={}",id, unitPrice,bikeModelName,bikeModelCode,unit);
        BikeChargePriceDO bikeChargePriceDO = new BikeChargePriceDO();
        bikeChargePriceDO.setId(id);
        if(null != unitPrice && unitPrice >0){
            bikeChargePriceDO.setUnitPrice(unitPrice);
        }
        if (null !=  unit && unit >0){
            bikeChargePriceDO.setUnit(unit);
        }
        if (StringUtils.isNotEmpty(bikeModelName)){
            bikeChargePriceDO.setBikeModelName(bikeModelName);
        }
        if (StringUtils.isNotEmpty(bikeModelCode)){
            bikeChargePriceDO.setBikeModelCode(bikeModelCode);
        }
        bikeChargePriceService.modifyBikeChargePriceSelective(bikeChargePriceDO);
        return ResultUtils.genResult(0,"修改成功");
    }

    /**
     * 加盟商单车定价删除
     *
     * @return
     */
    @RequestMapping(value = "/bike/price/delete", method = RequestMethod.POST)
    public Result<?> ranchiserBikePrice(@RequestParam(value = "id", required = true) Long id) {
        logger.info("删除加盟商单车价格入参,id={}", id);
        bikeChargePriceService.removeBikeChargePrice(id);
        return ResultUtils.genResult(0,"删除成功");
    }

}
