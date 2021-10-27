package com.example.demo.pingshi.aggregate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * 摄像机聚合列表结果实体类
 * className: SelectCameraViewDTO
 *
 * @author zhangyu
 * @version 2019/11/06 16:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class SelectCameraViewDTO{

    /**
     * 城市
     */
    @Size(max=32)
    private String city;

    /**
     * 工地列表信息
     */
    private List<WorksitePartDTO> worksiteList;

}
