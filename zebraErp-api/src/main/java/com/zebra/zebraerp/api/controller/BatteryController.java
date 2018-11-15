package com.zebra.zebraerp.api.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.zebra.pony.util.DateUtil;
import com.zebra.zebraerp.common.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zebra.pony.common.model.Result;
import com.zebra.pony.common.utils.ResultUtils;
import com.zebra.pony.util.JsonUtil;

import com.zebra.zebraerp.api.converter.BatteryConverter;
import com.zebra.zebraerp.api.paramobject.BatteryAddPO;
import com.zebra.zebraerp.api.paramobject.BatteryEditPO;
import com.zebra.zebraerp.api.viewobject.BatteryVO;
import com.zebra.zebraerp.api.viewobject.ServiceStationVO;
import com.zebra.zebraerp.biz.service.BatteryService;
import com.zebra.zebraerp.common.Exception.ZebraerpException;
import com.zebra.zebraerp.dal.dataobject.BatteryDO;
import com.zebra.zebraerp.dal.dataobject.businessObject.BatteryBindStaffBO;

/**
 * 电池
 *
 * @author owen
 */
@RestController
@RequestMapping("battery")
public class BatteryController {

    private final static Logger logger = LoggerFactory.getLogger(BatteryController.class);

    @Autowired
    private BatteryService batteryService;

    /**
     * 添加电池信息
     *
     * @param batteryAddPO
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<?> addBattery(BatteryAddPO batteryAddPO) {
        logger.info("添加电池信息,BatteryAddPO={}", JsonUtil.getJsonFromObject(batteryAddPO));
        try {
            BatteryDO batteryDO = BatteryConverter.batteryAddPO2BBatteryDO(batteryAddPO);
            batteryDO.setCreateTime(DateUtil.getCurrentTimeSeconds());
            batteryService.addBattery(batteryDO);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_SUCCESS, "添加电池信息成功");
        } catch (ZebraerpException e) {
            logger.error("添加电池信息失败,siteAddPO={}", JsonUtil.getJsonFromObject(batteryAddPO));
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("添加电池信息失败,siteAddPO={}", JsonUtil.getJsonFromObject(batteryAddPO));
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }

    /**
     * 修改电池信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<?> editBattery(BatteryEditPO batteryEditPO) {
        logger.info("修改电池信息,BatteryEditPO={}", JsonUtil.getJsonFromObject(batteryEditPO));
        try {
            BatteryDO batteryDO = BatteryConverter.batteryEditPO2BBatteryDO(batteryEditPO);
            batteryService.editBattery(batteryDO);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_SUCCESS, "修改电池信息成功");
        } catch (ZebraerpException e) {
            logger.error("修改电池信息失败,BatteryEditPO={}", JsonUtil.getJsonFromObject(batteryEditPO));
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("修改电池信息失败,BatteryEditPO={}", JsonUtil.getJsonFromObject(batteryEditPO));
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }

    /**
     * 删除电池信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result<?> deleteBattery(@RequestParam(value = "batteryCode", required = false) String batteryCode) {
        logger.info("删除电池信息,batteryCode={}", batteryCode);
        try {
            batteryService.deleteBattery(batteryCode);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_SUCCESS, "删除电池信息成功");
        } catch (ZebraerpException e) {
            logger.error("删除电池信息失败,batteryCode={}", batteryCode);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("删除电池信息失败,batteryCode={}", batteryCode);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }

    /**
     * 捆绑电池与员工的关系
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/toStaff", method = RequestMethod.POST)
    public Result<?> editBatteryBindStaff(@RequestParam(value = "sid", required = true) Long sid,
                                          @RequestParam(value = "batteryCodes", required = true) String batteryCodes) {
        logger.info("捆绑电池与员工信息,sid={},BatteryCodes={}", sid, batteryCodes);
        try {
            BatteryBindStaffBO batteryBindStaffBO = new BatteryBindStaffBO();
            batteryBindStaffBO.setSid(sid);
            String[] batteryCodeArr = batteryCodes.split(",");
            List<String> batteryCodeList = Arrays.asList(batteryCodeArr);
            batteryBindStaffBO.setBatteryCodeList(batteryCodeList);
            batteryService.editBatteryBindStaff(batteryBindStaffBO);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_SUCCESS, "捆绑电池与员工信息成功");
        } catch (ZebraerpException e) {
            logger.error("捆绑电池与员工信息失败,siteId={},batteryCodes={},e={}", sid, batteryCodes, e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("捆绑电池与员工信息失败,siteId={},batteryCodes={}", sid, batteryCodes);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }


    /**
     * 获取电池列表信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/getList", method = RequestMethod.POST)
    public Result<BatteryVO> queryBatteryList(@RequestParam(value = "batteryCode", required = false) String batteryCode,
                                              @RequestParam(value = "pageIndex", required = false) Integer pageIndex,
                                              @RequestParam(value = "siteId", required = false) Long siteId,
                                              @RequestParam(value = "sid", required = false) Long sid) {
        logger.info("获取电池列表信息，batteryStatus={},batteryCode={},siteId={},sid={},pageIndex={},", batteryCode, siteId, sid, pageIndex);
        try {
            BatteryDO batteryDO = new BatteryDO();
            if (StringUtils.isNotEmpty(batteryCode)) {
                batteryDO.setBatteryCode(batteryCode);
            }
            batteryDO.setPageIndex(pageIndex);
            List<BatteryDO> listData = batteryService.queryBatteryList(batteryDO);
            Integer listCount = batteryService.queryBatteryCount(batteryDO);
            List<BatteryVO> listVo = BatteryConverter.batteryDO2BBatteryVO(listData);
            return ResultUtils.genResultWithSuccess("batteryList", listVo, "count", listCount);
        } catch (ZebraerpException e) {
            logger.error("获取电池列表信息batteryCode={},siteId={},sid={},pageIndex={},e={}", batteryCode, siteId, sid, pageIndex, e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("获取电池列表信息,batteryCode={},siteId={},sid={},pageIndex={},e={}", batteryCode, siteId, sid, pageIndex, e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }


    /**
     * 获取单个电池详细信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/getDetail", method = RequestMethod.POST)
    public Result<ServiceStationVO> querySingleBattery(@RequestParam(value = "batteryCode", required = true) String batteryCode) {
        logger.info("获取单个电池详细信息，batteryCode={}", batteryCode);
        try {
            if (StringUtils.isEmpty(batteryCode)) {
                return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, "电池编号为空");
            }
            BatteryDO batteryDO = batteryService.queryBatteryByPk(batteryCode);
            BatteryVO batteryVO = BatteryConverter.batteryDO2BBatteryVO(batteryDO);
            return ResultUtils.genResultWithSuccess("batteryDetail", batteryVO);
        } catch (ZebraerpException e) {
            logger.error("获取单个电池编号，batteryCode={},e={}", batteryCode, e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("获取单个电池编号，batteryCode={},e={}", batteryCode, e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }

}
