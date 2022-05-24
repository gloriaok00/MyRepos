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
 * 菜单表
 * </p>
 *
 * @author ${author}
 * @since 2022-05-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="UMenu对象", description="菜单表")
public class UMenu extends BaseModel {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "菜单主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "父级ID")
    private Long pid;

    @ApiModelProperty(value = "菜单名称")
    private String title;


}
