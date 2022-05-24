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
 * 用户租户关系表
 * </p>
 *
 * @author ${author}
 * @since 2022-05-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="UUserTenantRel对象", description="用户租户关系表")
public class UUserTenantRel extends BaseModel {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "用户与租户关系主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "用户主键")
    private Long userId;

    @ApiModelProperty(value = "租户主键")
    private Long tenantId;


}
