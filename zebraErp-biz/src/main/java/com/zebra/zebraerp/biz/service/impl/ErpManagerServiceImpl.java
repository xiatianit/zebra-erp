package com.zebra.zebraerp.biz.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import com.zebra.pony.util.JsonUtil;
import com.zebra.zebraerp.biz.service.ErpManagerTokenService;
import com.zebra.zebraerp.common.Exception.ZebraerpException;
import com.zebra.zebraerp.common.constant.ZebraerpConstant;
import com.zebra.zebraerp.common.util.CollectionUtils;
import com.zebra.zebraerp.dal.dataobject.ErpManagerTokenDO;
import com.zebra.zebraerp.dal.dataobject.businessObject.ErpManagerToken;
import com.zebra.zebraerp.dal.dataobject.businessObject.ManagerLoginBO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.zebra.zebraerp.dal.mapper.ErpManagerMapper;
import com.zebra.zebraerp.dal.dataobject.ErpManagerDO;
import com.zebra.zebraerp.biz.service.ErpManagerService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * @author
 * @ClassName: ErpManagerServiceImpl
 * @Description: by CodeGenerate
 */
@Service
@Transactional
public class ErpManagerServiceImpl implements ErpManagerService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ErpManagerMapper masterErpManagerMapper;
    @Autowired
    private ErpManagerMapper slaveErpManagerMapper;
    @Autowired
    private ErpManagerTokenService erpManagerTokenService;

    @Resource(name = "stringRedisTemplate")
    private ValueOperations<String, String> valueOps;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public ManagerLoginBO erpManagerLogin(String phone, String password) {

        ErpManagerDO erpManagerDO = new ErpManagerDO();
        erpManagerDO.setPhone(phone);
        erpManagerDO.setpassword(password);
        List<ErpManagerDO> erpManagerDOList = slaveErpManagerMapper.selectErpManagerList(erpManagerDO);
        if (CollectionUtils.isEmpty(erpManagerDOList)) {
            throw new ZebraerpException("账号或密码错误");
        }
        if (1 != erpManagerDOList.size()) {
            throw new ZebraerpException("当前登录账号异常");
        }
        ErpManagerDO erpManager = erpManagerDOList.get(0);
        //生成tokenkey
        String tokenStr = UUID.randomUUID().toString().replaceAll("-", "");
        valueOps.set(ZebraerpConstant.REDIS_PREFIX_ERP_TOKEN + tokenStr, buildErpManagerToken(erpManager), ZebraerpConstant.erpTokenEffectiveTime, TimeUnit.SECONDS);
        //返回token，角色类型，账号给前端
        ManagerLoginBO managerLoginBO = new ManagerLoginBO();
        managerLoginBO.setManagerRoleType(erpManager.getManagerRoleType());
        managerLoginBO.setPhone(erpManager.getPhone());
        managerLoginBO.setToken(tokenStr);
        return managerLoginBO;
    }

    /**
     * 构造ERP管理员token
     *
     * @param erpManagerDO
     * @return
     */
    public String buildErpManagerToken(ErpManagerDO erpManagerDO) {
        ErpManagerToken erpManagerToken = new ErpManagerToken();
        BeanUtils.copyProperties(erpManagerDO, erpManagerToken);
        return JsonUtil.getJsonFromObject(erpManagerToken);
    }

    @Override
    public ErpManagerDO queryErpManagerById(long id) {

        ErpManagerDO cErpManager = this.slaveErpManagerMapper.selectErpManagerById(id);
        return cErpManager;
    }


    @Override
    public List<ErpManagerDO> queryErpManagerByPage(ErpManagerDO erpManagerDO) {
        List<ErpManagerDO> list = this.slaveErpManagerMapper.selectErpManagerPage(erpManagerDO);
        return list;
    }

    @Override
    public List<ErpManagerDO> queryErpManagerList(ErpManagerDO erpManagerDO) {
        List<ErpManagerDO> list = this.slaveErpManagerMapper.selectErpManagerList(erpManagerDO);
        return list;
    }

    @Override
    public void createErpManager(ErpManagerDO erpManagerDO) {
        this.masterErpManagerMapper.insertErpManager(erpManagerDO);
    }

    @Override
    public int modifyErpManager(ErpManagerDO erpManagerDO) {
        int num = this.masterErpManagerMapper.updateErpManager(erpManagerDO);
        return num;
    }

    @Override
    public int modifyErpManagerSelective(ErpManagerDO erpManagerDO) {
        int num = this.masterErpManagerMapper.updateErpManagerSelective(erpManagerDO);
        return num;
    }

    @Override
    public int removeErpManager(long id) {
        int num = this.masterErpManagerMapper.deleteErpManager(id);
        return num;
    }

    @Override
    public int deleteByFranchiserCode(String franchiserCode) {
        int num = this.masterErpManagerMapper.deleteByFranchiserCode(franchiserCode);
        return num;
    }
}