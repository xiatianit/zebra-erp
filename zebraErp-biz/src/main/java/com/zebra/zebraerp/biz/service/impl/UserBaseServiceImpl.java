package com.zebra.zebraerp.biz.service.impl;

import com.zebra.zebraerp.dal.dataobject.UserConsumeDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zebra.zebraerp.dal.mapper.UserBaseMapper;
import com.zebra.zebraerp.dal.dataobject.UserBaseDO;
import com.zebra.zebraerp.biz.service.UserBaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author
 * @ClassName: UserBaseServiceImpl
 * @Description: by CodeGenerate
 */
@Service
@Transactional
public class UserBaseServiceImpl implements UserBaseService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserBaseMapper masterUserBaseMapper;
    @Autowired
    private UserBaseMapper slaveUserBaseMapper;


    @Override
    public List<UserConsumeDO> queryUserConsumeList(UserConsumeDO userConsumeDO) {

        List<UserConsumeDO> userConsumeDOList = this.slaveUserBaseMapper.selectUserConsumeList(userConsumeDO);
        return userConsumeDOList;
    }

    @Override
    public Integer queryUserConsumeCount(UserConsumeDO userConsumeDO) {
        return this.slaveUserBaseMapper.selectUserConsumeCount(userConsumeDO);
    }

    @Override
    public UserBaseDO queryUserBaseById(long uid) {

        UserBaseDO cUserBase = this.slaveUserBaseMapper.selectUserBaseById(uid);
        return cUserBase;
    }

    @Override
    public List<UserBaseDO> queryUserBaseByPage(UserBaseDO userBaseDO) {

        List<UserBaseDO> list = this.slaveUserBaseMapper.selectUserBasePage(userBaseDO);
        return list;
    }

    @Override
    public List<UserBaseDO> queryUserBaseList(UserBaseDO userBaseDO) {
        List<UserBaseDO> list = this.slaveUserBaseMapper.selectUserBaseList(userBaseDO);
        return list;
    }

    @Override
    public void createUserBase(UserBaseDO userBaseDO) {
        this.masterUserBaseMapper.insertUserBase(userBaseDO);
    }

    @Override
    public int modifyUserBase(UserBaseDO userBaseDO) {
        int num = this.masterUserBaseMapper.updateUserBase(userBaseDO);
        return num;
    }

    @Override
    public int modifyUserBaseSelective(UserBaseDO userBaseDO) {
        int num = this.masterUserBaseMapper.updateUserBaseSelective(userBaseDO);
        return num;
    }

    @Override
    public int removeUserBase(long uid) {
        int num = this.masterUserBaseMapper.deleteUserBase(uid);
        return num;
    }

}