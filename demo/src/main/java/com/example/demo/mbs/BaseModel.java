package com.example.demo.mbs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 公共基类实体
 */

@Data
public class BaseModel {

    @ApiModelProperty(value = "创建时间")
    @JsonIgnore
    private String createTime;

}
