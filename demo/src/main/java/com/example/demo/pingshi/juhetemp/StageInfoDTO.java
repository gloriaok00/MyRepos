package com.example.demo.pingshi.juhetemp;

import lombok.Data;
import lombok.ToString;

/**
 * 分期信息
 * className: StageInfoDTO
 *
 * @author zhangyu
 * @version 2019/11/06 16:17
 */
@Data
@ToString(callSuper = true)
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