package com.zebra.zebraerp.api.controller;

import com.zebra.pony.common.model.Result;
import com.zebra.pony.common.utils.ResultUtils;
import com.zebra.zebraerp.api.Interceptor.RequestLocalInfo;
import com.zebra.zebraerp.api.viewobject.ManagerLoginVO;
import com.zebra.zebraerp.biz.service.ErpManagerService;
import com.zebra.zebraerp.common.Exception.ZebraerpException;
import com.zebra.zebraerp.common.constant.ZebraerpConstant;
import com.zebra.zebraerp.dal.dataobject.businessObject.ManagerLoginBO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Created by xiatian on 2018/1/9.
 */
@RestController
@RequestMapping("erpmanager")
public class LoginController {
    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private ErpManagerService erpManagerService;
    @Resource(name = "stringRedisTemplate")
    private ValueOperations<String, String> valueOps;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result<ManagerLoginVO> erpManagerLogin(@RequestParam(value = "phone", required = false) String phone,
                                                  @RequestParam(value = "password", required = false) String password) {
        logger.info("erp管理员登录,phone={},password={}", phone, password);
        ManagerLoginVO managerLoginVO;
        try {
            ManagerLoginBO managerLoginBO = erpManagerService.erpManagerLogin(phone, password);
            managerLoginVO = new ManagerLoginVO();
            BeanUtils.copyProperties(managerLoginBO, managerLoginVO);
            return ResultUtils.genResultWithSuccess("managerLogin", managerLoginVO);
        } catch (ZebraerpException e) {
            logger.error("erp管理员登录e={}", e.getMessage());
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("登录异常e={}", e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }

    /**
     * 管理员退出
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/loginOut", method = RequestMethod.POST)
    public Result<?> doLoginOut() {
        logger.info("退出登录");
        String tokenKey = RequestLocalInfo.getToken();
        valueOps.set(ZebraerpConstant.REDIS_PREFIX_ERP_TOKEN + tokenKey, "", 3, TimeUnit.SECONDS);
        return ResultUtils.genResultWithSuccess();
    }
}