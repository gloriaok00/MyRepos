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
 * 资源表
 * </p>
 *
 * @author ${author}
 * @since 2022-05-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="UPermission对象", description="资源表")
public class UPermission extends BaseModel {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "资源主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "资源路径")
    private String url;

    @ApiModelProperty(value = "资源名称")
    private String name;

    @ApiModelProperty(value = "父级ID")
    private Long pid;

    @ApiModelProperty(value = "资源分类")
    private Long typeId;

    @ApiModelProperty(value = "前端路由PATH")
    private String path;

    @ApiModelProperty(value = "1.create 2.delete 3.update 4.list")
    private Integer action;

    @ApiModelProperty(value = "备注")
    private String remark;


}
