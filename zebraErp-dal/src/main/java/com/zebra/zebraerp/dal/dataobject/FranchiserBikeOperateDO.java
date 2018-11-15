package com.zebra.zebraerp.dal.dataobject;

import java.io.Serializable;

/**
 * 加盟商单车使用情况
 *
 * @author owen
 */
public class FranchiserBikeOperateDO extends PageDO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * 所属加盟商编号
     */
    private String franchiserCode;
    /**
     * 所属加盟商名称
     */
    private String franchiserName;


    public String getFranchiserCode() {
        return franchiserCode;
    }

    public void setFranchiserCode(String franchiserCode) {
        this.franchiserCode = franchiserCode;
    }

    public String getFranchiserName() {
        return franchiserName;
    }

    public void setFranchiserName(String franchiserName) {
        this.franchiserName = franchiserName;
    }
}
