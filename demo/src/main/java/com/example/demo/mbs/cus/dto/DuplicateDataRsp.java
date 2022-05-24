package com.example.demo.mbs.cus.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description  目前是想明白了 解决方法：
 *     SELECT * FROM u_user_role_rel urr
 *     JOIN u_role_tenant_rel rtr ON rtr.role_id=urr.role_id and rtr.tenant_id=1 and urr.tenant_id=rtr.tenant_id
 * @date 2022/5/24 15:02
 */

@Data
public class DuplicateDataRsp {

    private Long id;

    @ApiModelProperty(value = "用户主键ID")
    private Long userId;

    @ApiModelProperty(value = "角色主键ID")
    private Long roleId;

    @ApiModelProperty(value = "租户ID")
    private Long tenantId;

    @ApiModelProperty(value = "租户ID")
    private String createTime;


    private Long id1;

    private Long roleId1;

    private Long tenantId1;

    private String createTime1;

}
