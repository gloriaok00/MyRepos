package com.example.demo.pingshi.aggregate;

import lombok.Data;

import java.util.List;

/**
 * 工地信息
 * @author zhangyu
 * @date 2019-11-06 18:26
 */
@Data
public class WorksitePartDTO {

    private String worksiteId;
    private String  worksiteName;
    private List<StageInfoDTO> stageList;

}
