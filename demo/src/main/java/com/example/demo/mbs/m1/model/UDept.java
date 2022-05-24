package com.example.demo.mbs.m1.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.example.demo.mbs.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 部门表
 * </p>
 *
 * @author ${author}
 * @since 2022-05-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="UDept对象", description="部门表")
public class UDept extends BaseModel {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "部门id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "父部门id")
    private Long pid;

    @ApiModelProperty(value = "部门名称")
    private String name;

    @ApiModelProperty(value = "所属租户ID")
    private Long tenantId;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;


}
