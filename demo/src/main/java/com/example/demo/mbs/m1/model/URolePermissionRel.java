package com.example.demo.mbs.m1.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.example.demo.mbs.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色资源关系表
 * </p>
 *
 * @author ${author}
 * @since 2022-05-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="URolePermissionRel对象", description="角色资源关系表")
public class URolePermissionRel extends BaseModel {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "角色与资源主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "角色主键")
    private Long roleId;

    @ApiModelProperty(value = "资源主键")
    private Long permissionId;


}
