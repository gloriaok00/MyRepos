package com.example.demo.pingshi.aggregate;

import lombok.Data;

/**
 * @author zhangyu
 * @date 2019-11-06 17:51
 */

@Data
public class WSData {

    /**
     * 工地ID
     */
    private String worksiteId;

    /**
     * 分期ID
     */
    private String stageId;

    /**
     * 工地名称
     */
    private String worksiteName;

    /**
     * 分期名称
     */
    private String stageName;


    /**
     * 城市
     */
    private String city;

}
