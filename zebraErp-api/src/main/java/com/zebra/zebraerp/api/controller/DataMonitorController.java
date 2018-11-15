package com.zebra.zebraerp.api.controller;

import com.zebra.pony.common.model.Result;
import com.zebra.pony.common.utils.ResultUtils;
import com.zebra.zebraerp.api.Interceptor.RequestLocalInfo;
import com.zebra.zebraerp.api.converter.BikeConverter;
import com.zebra.zebraerp.api.viewobject.FranchiserBikeUseVO;
import com.zebra.zebraerp.api.viewobject.OperateInfoVO;
import com.zebra.zebraerp.biz.service.BikeService;
import com.zebra.zebraerp.biz.service.UserOrderService;
import com.zebra.zebraerp.common.Exception.ZebraerpException;
import com.zebra.zebraerp.dal.dataobject.businessObject.FranchiserBikeUseBO;
import com.zebra.zebraerp.dal.dataobject.businessObject.FranchiserOperateBO;
import com.zebra.zebraerp.dal.dataobject.businessObject.OperateInfoBO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xiatian on 2018/1/16.
 */
@RestController
@RequestMapping("franchiser")
public class DataMonitorController {
    private final static Logger logger = LoggerFactory.getLogger(DataMonitorController.class);

    @Autowired
    private BikeService bikeService;
    @Autowired
    private UserOrderService userOrderService;

    /**
     * 查询加盟商运营信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/operate/info", method = RequestMethod.POST)
    public Result<?> franchiserOperateInfo() {
        logger.info("查询加盟商运营信息,fracniserName={},franchiserCode={}", RequestLocalInfo.getFranchiserName(), RequestLocalInfo.getFranchiserCode());
        try {
            OperateInfoBO operateInfoBO = bikeService.queryFranchiserOperateInfo(RequestLocalInfo.getFranchiserName(), RequestLocalInfo.getFranchiserCode());
            OperateInfoVO operateInfoVO = new OperateInfoVO();
            BeanUtils.copyProperties(operateInfoBO, operateInfoVO);
            return ResultUtils.genResultWithSuccess("operateInfo", operateInfoVO);
        } catch (ZebraerpException e) {
            logger.error("查询加盟商运营信息异常,fracniserName={},franchiserCode={},e={}", RequestLocalInfo.getFranchiserName(), RequestLocalInfo.getFranchiserCode(), e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("查询加盟商运营信息异常,fracniserName={},franchiserCode={},e={}", RequestLocalInfo.getFranchiserName(), RequestLocalInfo.getFranchiserCode(), e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }

    /**
     * 查询加盟商电车近30天运营详情
     *
     * @return
     */
    @RequestMapping(value = "/bike/operate/detail", method = RequestMethod.POST)
    public Result<?> franchiserBikeOperateDetail() {
        logger.info("查询加盟商单车使用情况,fracniserName={},franchiserCode={}", RequestLocalInfo.getFranchiserName(), RequestLocalInfo.getFranchiserCode());
        try {
            FranchiserOperateBO franchiserBikeOperateBO = new FranchiserOperateBO();
            franchiserBikeOperateBO.setFranchiserName(RequestLocalInfo.getFranchiserName());
            franchiserBikeOperateBO.setFranchiserCode(RequestLocalInfo.getFranchiserCode());
            List<FranchiserBikeUseBO> franchiserBikeUseBOList = userOrderService.queryFranchiserBikeUseInfo(franchiserBikeOperateBO);
            List<FranchiserBikeUseVO> franchiserBikeUseVOList = BikeConverter.franchiserBikeUseBO2VO(franchiserBikeUseBOList);
            return ResultUtils.genResultWithSuccess("franchiserOperateList", franchiserBikeUseVOList);
        } catch (ZebraerpException e) {
            logger.error("查询加盟商单车使用情况异常,fracniserName={},franchiserCode={},e={}", RequestLocalInfo.getFranchiserName(), RequestLocalInfo.getFranchiserCode(), e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("查询加盟商单车使用情况异常,fracniserName={},franchiserCode={},e={}", RequestLocalInfo.getFranchiserName(), RequestLocalInfo.getFranchiserCode(), e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }


}
