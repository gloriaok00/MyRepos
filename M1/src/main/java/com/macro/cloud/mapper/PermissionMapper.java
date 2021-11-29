package com.macro.cloud.mapper;


import com.macro.cloud.model.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface PermissionMapper {

    @Select( "SELECT C.NAME AS name,C.url,C.id as id FROM role AS A LEFT JOIN role_permission B ON A.id=B.role_id LEFT JOIN permission AS C ON B.permission_id=C.id")
    List<Permission> getRolePermissions(@Param("ids") List<Long> ids);

    @Select( "SELECT name,url,id FROM permission")
    List<Permission> getAllPermissions();

}
