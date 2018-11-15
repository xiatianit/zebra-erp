package com.zebra.zebraerp.dal.mapper;

import java.util.List;

import com.zebra.zebraerp.dal.dataobject.CityDO;

/**
 * 城市信息表MAPPER
 *
 * @author
 * @ClassName: CityMapper
 * @Description: by CodeGenerate
 */

public interface CityMapper {

    /**
     * 添加
     */
    public int insertCity(CityDO cityDO);

    /**
     * 根据主键查询
     */
    public CityDO selectCityById(String cityCode);

    /**
     * 查询列表
     */
    public List<CityDO> selectCityList(CityDO cityDO);

    /**
     * 分页计数
     */
    public int selectCityCount(CityDO cityDO);

    /**
     * 分页查找
     */
    public List<CityDO> selectCityPage(CityDO cityDO);

    /**
     * 完全修改
     */
    public int updateCity(CityDO cityDO);

    /**
     * 选择性修改
     */
    public int updateCitySelective(CityDO cityDO);

    /**
     * 删除
     */
    public int deleteCity(String cityCode);
}