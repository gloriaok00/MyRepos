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
 * 用户角色关系表
 * </p>
 *
 * @author ${author}
 * @since 2022-05-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="UUserRoleRel对象", description="用户角色关系表")
public class UUserRoleRel extends BaseModel {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "用户与角色关系主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "用户主键ID")
    private Long userId;

    @ApiModelProperty(value = "角色主键ID")
    private Long roleId;

    @ApiModelProperty(value = "租户ID")
    private Long tenantId;


}
