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
 * 
 * </p>
 *
 * @author ${author}
 * @since 2022-05-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="UAssUserRel对象", description="")
public class UAssUserRel extends BaseModel {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "分配与用户表主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "分配token")
    private String assToken;

    @ApiModelProperty(value = "用户主键")
    private Long userId;

    @ApiModelProperty(value = "租户ID")
    private Long tenantId;


}
