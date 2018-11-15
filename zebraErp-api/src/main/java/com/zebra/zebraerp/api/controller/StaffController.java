package com.zebra.zebraerp.api.controller;

import java.util.List;

import com.zebra.zebraerp.api.Interceptor.RequestLocalInfo;
import com.zebra.zebraerp.biz.service.ErpManagerService;
import com.zebra.zebraerp.common.enums.RoleTypeEnum;
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
import com.zebra.zebraerp.api.converter.StaffConverter;
import com.zebra.zebraerp.api.paramobject.StaffBaseAddPO;
import com.zebra.zebraerp.api.paramobject.StaffBaseEditPO;
import com.zebra.zebraerp.api.viewobject.BikeVO;
import com.zebra.zebraerp.api.viewobject.ServiceStationVO;
import com.zebra.zebraerp.api.viewobject.StaffBaseVO;
import com.zebra.zebraerp.biz.service.StaffService;
import com.zebra.zebraerp.common.Exception.ZebraerpException;
import com.zebra.zebraerp.dal.dataobject.StaffBaseDO;

/**
 * 员工controller
 *
 * @author owen
 */
@RestController
@RequestMapping("staff")
public class StaffController {

    private final static Logger logger = LoggerFactory.getLogger(StaffController.class);

    @Autowired
    private StaffService staffService;


    /**
     * 添加员工基本信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<?> addStaff(StaffBaseAddPO staffBaseAddPO) {
        logger.info("添加员工信息入参,staffBaseAddPO={}", JsonUtil.getJsonFromObject(staffBaseAddPO));
        try {
            StaffBaseDO staffBaseDO = StaffConverter.staffBaseAddPO2BStaffBaseDO(staffBaseAddPO);
            staffBaseDO.setFranchiserName(RequestLocalInfo.getFranchiserName());
            staffBaseDO.setFranchiserCode(RequestLocalInfo.getFranchiserCode());
            staffBaseDO.setStaffType(RequestLocalInfo.getManagerRoleType());
            staffBaseDO.setStaffStatus(1);
            staffService.addStaffBase(staffBaseDO);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_SUCCESS, "添加员工信息成功");
        } catch (ZebraerpException e) {
            logger.error("添加员工基础信息失败,staffBaseAddPO={}", JsonUtil.getJsonFromObject(staffBaseAddPO));
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("添加员工基础信息失败,staffBaseAddPO={}", JsonUtil.getJsonFromObject(staffBaseAddPO));
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }

    /**
     * 修改员工基本信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<?> editStaff(StaffBaseEditPO staffBaseEditPO) {
        logger.info("修改员工信息入参,staffBaseAddPO={}", JsonUtil.getJsonFromObject(staffBaseEditPO));
        try {
            StaffBaseDO staffBaseDO = StaffConverter.staffBaseEditPO2BStaffBaseDO(staffBaseEditPO);
            staffService.editStaffBase(staffBaseDO);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_SUCCESS, "修改员工基础信息成功");
        } catch (ZebraerpException e) {
            logger.error("修改员工基础信息失败,staffBaseEditPO={}", JsonUtil.getJsonFromObject(staffBaseEditPO));
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("修改员工基础信息失败,staffBaseEditPO={}", JsonUtil.getJsonFromObject(staffBaseEditPO));
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }

    /**
     * 删除员工基本信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result<?> deleteStaff(@RequestParam(value = "sid", required = true) Long sid) {
        logger.info("删除员工信息入参,sid={}", sid);
        try {
            staffService.deleteStaffBase(sid);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_SUCCESS, "删除员工成功");
        } catch (ZebraerpException e) {
            logger.error("删除员工基础信息失败,sid={},e={}", sid, e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("删除员工基础信息失败,sid={},e={}", sid, e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }

    /**
     * 获取员工列表信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/getList", method = RequestMethod.POST)
    public Result<BikeVO> queryStaffList(@RequestParam(value = "pageIndex", required = false) Integer pageIndex,
                                         @RequestParam(value = "staffName", required = false) String staffName) {

        logger.info("获取员工列表信息,pageIndex={},staffName={}", pageIndex, staffName);
        try {
            StaffBaseDO staffBaseDO = new StaffBaseDO();
            staffBaseDO.setPageIndex(pageIndex);
            if (StringUtils.isNotEmpty(staffName)) {
                staffBaseDO.setStaffName(staffName);
            }
            //如果是加盟商
            if (RoleTypeEnum.FRANCHISER_TYPE.getRoleTypeCode().equals(RequestLocalInfo.getManagerRoleType())) {
                staffBaseDO.setStaffType(RoleTypeEnum.FRANCHISER_TYPE.getRoleTypeCode());
                staffBaseDO.setFranchiserCode(RequestLocalInfo.getFranchiserCode());
                staffBaseDO.setFranchiserName(RequestLocalInfo.getFranchiserName());
            }
            List<StaffBaseDO> listData = staffService.queryStaffBaseList(staffBaseDO);
            Integer listCount = staffService.queryStaffBaseCount(staffBaseDO);
            List<StaffBaseVO> listVo = StaffConverter.staffBaseDO2BStaffBaseVO(listData);
            return ResultUtils.genResultWithSuccess("staffList", listVo, "count", listCount);
        } catch (ZebraerpException e) {
            logger.error("获取电车列表信息,pageIndex={},e={}", pageIndex, e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("获取电车列表信息,pageIndex={},e={}", pageIndex, e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }

    /**
     * 获取单个员工基本明细信息
     *
     * @param sid
     * @return
     */
    @RequestMapping(value = "/getDetail", method = RequestMethod.POST)
    public Result<ServiceStationVO> querySingleStaff(@RequestParam(value = "sid", required = true) Long sid) {
        logger.info("获取单个员工基本明细信息编号，sid={}", sid);
        try {
            StaffBaseDO staffBaseDO = staffService.queryStaffBaseByPk(sid);
            StaffBaseVO staffBaseVO = StaffConverter.staffBaseDO2BStaffBaseVO(staffBaseDO);
            return ResultUtils.genResultWithSuccess("staffDetail", staffBaseVO);
        } catch (ZebraerpException e) {
            logger.error("获取员工基本明细信息编号，sid={},e={}", sid, e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("获取员工基本明细信息编号，sid={},e={}", sid, e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }

}
