package com.zebra.zebraerp.biz.service.impl;

import com.zebra.pony.util.DateUtil;
import com.zebra.zebraerp.biz.service.ErpManagerService;
import com.zebra.zebraerp.biz.service.ErpManagerTokenService;
import com.zebra.zebraerp.common.Exception.ZebraerpException;
import com.zebra.zebraerp.common.enums.RoleTypeEnum;
import com.zebra.zebraerp.common.util.CollectionUtils;
import com.zebra.zebraerp.dal.dataobject.ErpManagerDO;
import com.zebra.zebraerp.dal.dataobject.ErpManagerTokenDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.zebra.zebraerp.dal.mapper.FranchiserBaseMapper;
import com.zebra.zebraerp.dal.dataobject.FranchiserBaseDO;
import com.zebra.zebraerp.biz.service.FranchiserBaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author
 * @ClassName: FranchiserBaseServiceImpl
 * @Description: by CodeGenerate
 */
@Service
@Transactional
public class FranchiserBaseServiceImpl implements FranchiserBaseService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private FranchiserBaseMapper masterFranchiserBaseMapper;
    @Autowired
    private FranchiserBaseMapper slaveFranchiserBaseMapper;
    @Autowired
    private ErpManagerService erpManagerService;

    @Override
    public FranchiserBaseDO queryFranchiserBaseById(String franchiserCode) {

        FranchiserBaseDO cFranchiserBase = this.slaveFranchiserBaseMapper.selectFranchiserBaseById(franchiserCode);
        return cFranchiserBase;
    }

    @Override
    public int queryFranchiserBaseCount(FranchiserBaseDO franchiserBaseDO) {
        return this.slaveFranchiserBaseMapper.selectFranchiserBaseCount(franchiserBaseDO);
    }

    @Override
    public List<FranchiserBaseDO> queryFranchiserBaseByPage(FranchiserBaseDO franchiserBaseDO) {

        List<FranchiserBaseDO> list = this.slaveFranchiserBaseMapper.selectFranchiserBasePage(franchiserBaseDO);
        return list;
    }

    @Override
    public List<FranchiserBaseDO> queryFranchiserBaseList(FranchiserBaseDO franchiserBaseDO) {
        List<FranchiserBaseDO> list = this.slaveFranchiserBaseMapper.selectFranchiserBaseList(franchiserBaseDO);
        return list;
    }

    @Override
    public void addFranchiser(FranchiserBaseDO franchiserBaseDO) {
        //生成加盟商code
        franchiserBaseDO.setFranchiserCode(String.valueOf(DateUtil.getCurrentTimeSeconds()));
        franchiserBaseDO.setStatus(0);
        franchiserBaseDO.setModifiedTime(new Date());
        franchiserBaseDO.setCreateTime(new Date());
        //判断加盟商账号和名称是否存在
        FranchiserBaseDO franchiserPhoneDO = this.slaveFranchiserBaseMapper.selectFranchiserBaseByPhone(franchiserBaseDO.getPhone());
        if (null != franchiserPhoneDO) {
            throw new ZebraerpException("当前加盟商账号已经存在，请更换手机号码添加");
        }
        FranchiserBaseDO franchiserNameDO = this.slaveFranchiserBaseMapper.selectFranchiserBaseByName(franchiserBaseDO.getFranchiserName());
        if (null != franchiserNameDO) {
            throw new ZebraerpException("当前加盟商账号已经存在，请更换加盟商名称添加");
        }
        //创建加盟商基本信息
        masterFranchiserBaseMapper.insertFranchiserBase(franchiserBaseDO);
        //创建加盟商ERP管理人员
        erpManagerService.createErpManager(this.converter2ErpManagerDO(franchiserBaseDO));

    }


    public ErpManagerDO converter2ErpManagerDO(FranchiserBaseDO franchiserBaseDO) {
        ErpManagerDO erpManagerDO = new ErpManagerDO();
        erpManagerDO.setManagerName(franchiserBaseDO.getPhone());
        erpManagerDO.setFranchiserCode(franchiserBaseDO.getFranchiserCode());
        erpManagerDO.setFranchiserName(franchiserBaseDO.getFranchiserName());
        erpManagerDO.setpassword(franchiserBaseDO.getPassword());
        erpManagerDO.setPhone(franchiserBaseDO.getPhone());
        erpManagerDO.setManagerRoleType(RoleTypeEnum.FRANCHISER_TYPE.getRoleTypeCode());
        erpManagerDO.setNickName(franchiserBaseDO.getPhone());
        erpManagerDO.setRegisterTime(new Date());
        return erpManagerDO;
    }

    public ErpManagerTokenDO coverter2ErpManagerTokenDO(ErpManagerDO erpManagerDO) {
        ErpManagerTokenDO erpManagerTokenDO = new ErpManagerTokenDO();
        erpManagerTokenDO.setManagerId(erpManagerDO.getId());
        //生成新的token
        String tokenStr = UUID.randomUUID().toString().replaceAll("-", "");
        erpManagerTokenDO.setToken(tokenStr);
        erpManagerTokenDO.setLastUpdateTime(new Date());
        return erpManagerTokenDO;
    }

    @Override
    public void createFranchiserBase(FranchiserBaseDO franchiserBaseDO) {
        this.masterFranchiserBaseMapper.insertFranchiserBase(franchiserBaseDO);
    }

    @Override
    public int modifyFranchiserBase(FranchiserBaseDO franchiserBaseDO) {
        int num = this.masterFranchiserBaseMapper.updateFranchiserBase(franchiserBaseDO);
        return num;
    }

    @Override
    public int modifyFranchiserBaseSelective(FranchiserBaseDO franchiserBaseDO) {
        if (null == franchiserBaseDO || null == franchiserBaseDO.getPhone() || null == franchiserBaseDO.getFranchiserName()) {
            throw new ZebraerpException("加盟商手机号或名称不能为空");
        }
        FranchiserBaseDO baseDO = new FranchiserBaseDO();
        baseDO.setPhone(franchiserBaseDO.getPhone());
        List<FranchiserBaseDO> baseDOList = this.slaveFranchiserBaseMapper.selectFranchiserBaseList(baseDO);
        if (baseDOList.size() > 1) {
            throw new ZebraerpException("加盟商手机号已存在，请更换手机号码");
        }
        FranchiserBaseDO baseNameDO = new FranchiserBaseDO();
        baseNameDO.setFranchiserName(franchiserBaseDO.getFranchiserName());
        List<FranchiserBaseDO> baseNameDOList = this.slaveFranchiserBaseMapper.selectFranchiserBaseList(baseNameDO);
        if (baseNameDOList.size() > 1) {
            throw new ZebraerpException("加盟商名称已存在，请修改加盟商名称");
        }
        franchiserBaseDO.setModifiedTime(new Date());
        int num = this.masterFranchiserBaseMapper.updateFranchiserBaseSelective(franchiserBaseDO);
        return num;
    }

    @Override
    public void removeFranchiserBase(String franchiserCode) {
        int num = this.masterFranchiserBaseMapper.deleteFranchiserBase(franchiserCode);
        erpManagerService.deleteByFranchiserCode(franchiserCode);
    }

}