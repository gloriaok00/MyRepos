package com.example.demo.mbs.cus.dto;

import com.example.demo.mbs.BaseModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author ${author}
 * @since 2022-02-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "UUser对象", description = "用户表")
public class UUser extends BaseModel {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户主键ID")
    private Long id;

    @ApiModelProperty(value = "用户名称")
    private String username;

    @ApiModelProperty(value = "用户密码")
    private String password;

    @ApiModelProperty(value = "图片地址")
    private String url;

    @ApiModelProperty(value = "手机")
    private String phone;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "性别(1.男 2.女)")
    private Integer sex;

    @ApiModelProperty(value = "更新时间")
    @JsonIgnore
    private String updateTime;

    @ApiModelProperty(value = "备注")
    private String remark;


}
