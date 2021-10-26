package com.macro.mall.mapper;

import com.macro.mall.model.UmsAdminTenantRelation;
import com.macro.mall.model.UmsAdminTenantRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsAdminTenantRelationMapper {
    long countByExample(UmsAdminTenantRelationExample example);

    int deleteByExample(UmsAdminTenantRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UmsAdminTenantRelation record);

    int insertSelective(UmsAdminTenantRelation record);

    List<UmsAdminTenantRelation> selectByExample(UmsAdminTenantRelationExample example);

    UmsAdminTenantRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UmsAdminTenantRelation record, @Param("example") UmsAdminTenantRelationExample example);

    int updateByExample(@Param("record") UmsAdminTenantRelation record, @Param("example") UmsAdminTenantRelationExample example);

    int updateByPrimaryKeySelective(UmsAdminTenantRelation record);

    int updateByPrimaryKey(UmsAdminTenantRelation record);
}