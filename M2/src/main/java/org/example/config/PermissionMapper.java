package org.example.config;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface PermissionMapper {

    @Select("<script>" + "SELECT p.name AS name,p.url,p.id as id FROM role_permission rp JOIN permission AS p ON rp.permission_id=p.id where role_id in"
            +"<foreach item='id' collection='ids' open='(' separator=',' close=')'>"
            + "#{id}"
            + "</foreach>"
            + "</script>")
    List<Permission> getRolePermissions(@Param("ids") List<Long> ids);

    @Select( "SELECT name,url,id FROM permission")
    List<Permission> getAllPermissions();

}
