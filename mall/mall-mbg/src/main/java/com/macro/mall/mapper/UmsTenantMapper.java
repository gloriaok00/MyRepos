package com.macro.mall.mapper;

import com.macro.mall.model.UmsTenant;
import com.macro.mall.model.UmsTenantExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsTenantMapper {
    long countByExample(UmsTenantExample example);

    int deleteByExample(UmsTenantExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UmsTenant record);

    int insertSelective(UmsTenant record);

    List<UmsTenant> selectByExample(UmsTenantExample example);

    UmsTenant selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UmsTenant record, @Param("example") UmsTenantExample example);

    int updateByExample(@Param("record") UmsTenant record, @Param("example") UmsTenantExample example);

    int updateByPrimaryKeySelective(UmsTenant record);

    int updateByPrimaryKey(UmsTenant record);
}