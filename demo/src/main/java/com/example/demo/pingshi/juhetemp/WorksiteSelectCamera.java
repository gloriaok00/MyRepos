package com.example.demo.pingshi.juhetemp;

import lombok.Data;


/**
 * @author zhangyu
 * @date 2019-11-07 11:01
 */

@Data
public class WorksiteSelectCamera {

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
