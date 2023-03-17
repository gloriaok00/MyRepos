package org.example.edge.pojo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * mx xml 返回参数
 */

@Data
public class MxXmlRequest {

    //@ApiModelProperty(value = "design-view返回值已加密文本")
    @NotBlank
    private String content;

}
