package com.zebra.zebraerp.api.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.zebra.pony.util.DateUtil;
import com.zebra.pony.util.RandomUtil;
import com.zebra.zebraerp.api.Interceptor.RequestLocalInfo;
import com.zebra.zebraerp.api.viewobject.BikeModelVO;
import com.zebra.zebraerp.biz.service.BikeModelService;
import com.zebra.zebraerp.common.enums.RoleTypeEnum;
import com.zebra.zebraerp.common.util.DateUtils;
import com.zebra.zebraerp.common.util.StringUtils;
import com.zebra.zebraerp.dal.dataobject.BikeModelDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zebra.zebraerp.api.converter.BikeConverter;
import com.zebra.zebraerp.api.paramobject.BikeAddPO;
import com.zebra.zebraerp.api.paramobject.BikeEditPO;
import com.zebra.zebraerp.api.viewobject.BikeDetailVO;
import com.zebra.zebraerp.api.viewobject.BikeVO;
import com.zebra.zebraerp.api.viewobject.ServiceStationVO;
import com.zebra.zebraerp.biz.service.BikeService;
import com.zebra.zebraerp.common.Exception.ZebraerpException;
import com.zebra.pony.common.model.Result;
import com.zebra.pony.common.utils.ResultUtils;
import com.zebra.pony.util.JsonUtil;
import com.zebra.zebraerp.dal.dataobject.BikeDO;
import com.zebra.zebraerp.dal.dataobject.businessObject.BikeBindSiteBO;
import com.zebra.zebraerp.dal.dataobject.businessObject.BikeBindStaffBO;

/**
 * 电车
 */
@RestController
@RequestMapping("bike")
public class BikeController {

    private final static Logger logger = LoggerFactory.getLogger(BikeController.class);

    @Autowired
    private BikeService bikeService;
    @Autowired
    private BikeModelService bikeModelService;

    /**
     * 添加电车信息
     *
     * @param bikeAddPO
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<?> addBike(BikeAddPO bikeAddPO) {
        logger.info("添加电车信息,bikeAddPO={}", JsonUtil.getJsonFromObject(bikeAddPO));
        try {
            if(StringUtils.isEmpty(bikeAddPO.getBikeNo())){
                return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, "车辆编号不能为空");
            }
            if(StringUtils.isEmpty(bikeAddPO.getGprsPhone())){
                return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, "gprs号码不能为空");
            }
            BikeDO bikeDO = BikeConverter.bikeAddPO2BBikeDO(bikeAddPO);
            bikeDO.setCreateTime(DateUtil.getCurrentTimeSeconds());
            bikeService.addBike(bikeDO);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_SUCCESS, "添加电车信息成功");
        } catch (ZebraerpException e) {
            logger.error("添加电车信息失败,siteAddPO={}", JsonUtil.getJsonFromObject(bikeAddPO));
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("添加电车信息失败,siteAddPO={}", JsonUtil.getJsonFromObject(bikeAddPO));
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }

    /**
     * 修改电车信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<?> editBike(BikeEditPO bikeEditPO) {
        logger.info("修改电车信息,bikeEditPO={}", JsonUtil.getJsonFromObject(bikeEditPO));
        try {
            if(StringUtils.isEmpty(bikeEditPO.getBikeNo())){
                return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, "车辆编号不能为空");
            }
            if(StringUtils.isEmpty(bikeEditPO.getGprsPhone())){
                return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, "gprs号码不能为空");
            }
            BikeDO bikeDO = BikeConverter.bikeEditPO2BBikeDO(bikeEditPO);
            bikeService.editBike(bikeDO);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_SUCCESS, "修改电车信息成功");
        } catch (ZebraerpException e) {
            logger.error("修改电车信息失败,bikeEditPO={}", JsonUtil.getJsonFromObject(bikeEditPO));
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("修改电车信息失败,bikeEditPO={}", JsonUtil.getJsonFromObject(bikeEditPO));
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }

    /**
     * 删除电车信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result<?> deleteBike(String bikeCode) {
        logger.info("删除电车信息,bikeCode={}", bikeCode);
        try {
            if (StringUtils.isEmpty(bikeCode)){
                return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, "车辆编号不能为空");
            }
            bikeService.deleteBike(bikeCode);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_SUCCESS, "删除电车信息成功");
        } catch (ZebraerpException e) {
            logger.error("删除电车信息失败,bikeCode={}", bikeCode);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("删除电车信息失败,bikeCode={}", bikeCode);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }

    /**
     * 捆绑电车与投放点的关系
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/toSite", method = RequestMethod.POST)
    public Result<?> editBikeBindSite(@RequestParam(value = "siteId", required = true) Long siteId,
                                      @RequestParam(value = "bikeCodes", required = true) String bikeCodes) {
        logger.info("捆绑电车与投放点信息,siteId={},bikeCodes={}", siteId, bikeCodes);
        try {
            BikeBindSiteBO bikeBindSiteBO = new BikeBindSiteBO();
            bikeBindSiteBO.setSiteId(siteId);
            String[] bikeCodeArr = bikeCodes.split(",");
            List<String> bikeCodeList = Arrays.asList(bikeCodeArr);
            bikeBindSiteBO.setBikeCodeList(bikeCodeList);
            bikeService.editBikeBindSite(bikeBindSiteBO);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_SUCCESS, "捆绑电车与投放点信息成功");
        } catch (ZebraerpException e) {
            logger.error("捆绑电车与投放点信息失败,siteId={},bikeCodes={},e={}", siteId, bikeCodes, e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("捆绑电车与投放点信息失败,siteId={},bikeCodes={}", siteId, bikeCodes);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }

    /**
     * 捆绑电车与员工的关系
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/toStaff", method = RequestMethod.POST)
    public Result<?> editBikeBindStaff(@RequestParam(value = "sid", required = true) Long sid,
                                       @RequestParam(value = "bikeCodes", required = true) String bikeCodes) {
        logger.info("捆绑电车与员工信息,sid={},bikeCodes={}", sid, bikeCodes);
        try {
            BikeBindStaffBO bikeBindStaffBO = new BikeBindStaffBO();
            bikeBindStaffBO.setSid(sid);
            String[] bikeCodeArr = bikeCodes.split(",");
            List<String> bikeCodeList = Arrays.asList(bikeCodeArr);
            bikeBindStaffBO.setBikeCodeList(bikeCodeList);
            bikeService.editBikeBindStaff(bikeBindStaffBO);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_SUCCESS, "捆绑电车与员工信息成功");
        } catch (ZebraerpException e) {
            logger.error("捆绑电车与员工信息失败,siteId={},bikeCodes={},e={}", sid, bikeCodes, e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("捆绑电车与员工信息失败,siteId={},bikeCodes={}", sid, bikeCodes);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }

    /**
     * 解绑电车与投放点的关系
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/unbundleSite", method = RequestMethod.POST)
    public Result<?> editBikeUnBindSite(@RequestParam(value = "bikeCode", required = true) String bikeCode) {
        logger.info("解绑电车与投放点信息,bikeCode{}", bikeCode);
        try {
            bikeService.editBikeUnBindSite(bikeCode);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_SUCCESS, "解绑电车与投放点信息成功");
        } catch (ZebraerpException e) {
            logger.error("解绑电车与投放点信息失败,bikeCode={},e={}", bikeCode, e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("解绑电车与投放点信息失败,bikeCode={},e={}", bikeCode, e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }

    /**
     * 解绑电车与员工的关系
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/unbundleStaff", method = RequestMethod.POST)
    public Result<?> editBikeBindStaff(@RequestParam(value = "bikeCode", required = true) String bikeCode) {
        logger.info("解绑电车与员工信息,bikeCodes={}", bikeCode);
        try {
            bikeService.editBikeUnBindStaff(bikeCode);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_SUCCESS, "解绑电车与员工信息成功");
        } catch (ZebraerpException e) {
            logger.error("解绑电车与员工信息失败,bikeCode={},e={}", bikeCode, e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("解绑电车与员工信息失败,bikeCode={},e={}", bikeCode, e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }

    /**
     * 获取电车列表信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/getList", method = RequestMethod.POST)
    public Result<BikeVO> queryBikeList(@RequestParam(value = "bikeNo", required = false) String bikeNo,
                                        @RequestParam(value = "pageIndex", required = false) Integer pageIndex,
                                        @RequestParam(value = "siteId", required = false) Long siteId,
                                        @RequestParam(value = "sid", required = false) Long sid) {
        logger.info("获取电车列表信息,bikeNo={},siteId={},sid={},pageIndex={}", bikeNo, siteId, sid, pageIndex);
        try {
            BikeDO bikeDO = new BikeDO();
            if (StringUtils.isNotEmpty(bikeNo)) {
                bikeDO.setBikeNo(bikeNo);
            }
            if (null != siteId && siteId > 0) {
                bikeDO.setSiteId(siteId);
            }
            if (null != siteId && sid > 0) {
                bikeDO.setSid(sid);
            }
            bikeDO.setPageIndex(pageIndex);
            //如果是加盟商,官方查看全部订单
            if (RoleTypeEnum.FRANCHISER_TYPE.getRoleTypeCode().equals(RequestLocalInfo.getManagerRoleType())) {
                bikeDO.setFranchiserCode(RequestLocalInfo.getFranchiserCode());
            }
            List<BikeDO> listData = bikeService.queryBikeList(bikeDO);
            Integer listCount = bikeService.queryBikeCount(bikeDO);
            List<BikeVO> listVo = BikeConverter.bikeDO2BBikeVO(listData);
            return ResultUtils.genResultWithSuccess("bikeList", listVo, "count", listCount);
        } catch (ZebraerpException e) {
            logger.error("获取电车列表信息,bikeNo={},siteId={},sid={},pageIndex={},e={}", bikeNo, siteId, sid, pageIndex, e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("获取电车列表信息,bikeNo={},siteId={},sid={},pageIndex={},e={}", bikeNo, siteId, sid, pageIndex, e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }


    /**
     * 获取单个电车信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/getDetail", method = RequestMethod.POST)
    public Result<ServiceStationVO> querySingleBike(@RequestParam(value = "bikeCode", required = true) String bikeCode) {
        logger.info("获取单个电车编号，bikeCode={}", bikeCode);
        try {
            BikeDO bikeDO = bikeService.querySiteByPk(bikeCode);
            BikeDetailVO bikeDetailVO = BikeConverter.bikeDO2BBikeDetailVO(bikeDO);
            return ResultUtils.genResultWithSuccess("bikeDetail", bikeDetailVO);
        } catch (ZebraerpException e) {
            logger.error("获取单个电车编号，bikeCode={},e={}", bikeCode, e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("获取单个电车编号，bikeCode={},e={}", bikeCode, e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }

    /**
     * 添加单车车型
     */
    @RequestMapping(value = "/add/bike/model", method = RequestMethod.POST)
    public Result<?> addBikeModel(@RequestParam(value = "bikeModelName", required = true) String bikeModelName) {
        logger.info("添加单车车型,bikeModelName={}", bikeModelName);
        BikeModelDO bikeModelDO = new BikeModelDO();
        bikeModelDO.setBikeModelName(bikeModelName);
        bikeModelDO.setBikeModelCode(RandomUtil.getFourRandom());
        bikeModelService.createBikeModel(bikeModelDO);
        return ResultUtils.genResultWithSuccess();
    }

    /**
     * 查询所有单车类型
     *
     * @return
     */
    @RequestMapping(value = "/getBike/model/list", method = RequestMethod.POST)
    public Result<?> getBikeModelList() {
        List<BikeModelDO> modelDOList = bikeModelService.queryBikeModelList(new BikeModelDO());
        List<BikeModelVO> bikeModelList = BikeConverter.bikeModelDO2BikeModelVO(modelDOList);
        return ResultUtils.genResultWithSuccess("bikeModelList", bikeModelList);
    }
}
