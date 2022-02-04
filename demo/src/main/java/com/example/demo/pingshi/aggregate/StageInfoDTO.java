package com.example.demo.pingshi.aggregate;

import lombok.Data;

/**
 * 分期信息
 * className: StageInfoDTO
 *
 * @author zhangyu
 * @version 2019/11/06 16:17
 */
@Data
public class StageInfoDTO {

    /**
     * 分期ID
     */
    private String stageId;

    /**
     * 分期名称
     */
    private String stageName;

}
