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
 * 用户部门关系表
 * </p>
 *
 * @author ${author}
 * @since 2022-05-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="UUserDeptRel对象", description="用户部门关系表")
public class UUserDeptRel extends BaseModel {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "用户与部门关系主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "用户主键ID")
    private Long userId;

    @ApiModelProperty(value = "部门主键ID")
    private Long deptId;


}
