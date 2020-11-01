package com.example.demo.pingshi.juhetemp;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Simple to Introduction
 * className: WorksiteServiceImpl
 *
 * @author zhangyu
 * @version 2019/10/16 14:21
 */
@Slf4j
public class Demo2 {

    Map<String, SelectCameraViewDTO> map=new HashMap<>();

    //初始化数据库数据
    public List<WSData> initData(){
        List<WSData> result= new ArrayList<>();
        WSData r1=new WSData();
        r1.setCity("长沙");
        r1.setWorksiteId("L-CS00-CSSDG11");
        r1.setWorksiteName("t1");
        r1.setStageId("L-CS00-CSSDG11.01");
        r1.setStageName("st1");
        result.add(r1);
        WSData r2=new WSData();
        r2.setCity("长沙");
        r2.setWorksiteId("L-CS00-CSSDG11");
        r2.setWorksiteName("t1");
        r2.setStageId("L-CS00-CSSDG11.02");
        r2.setStageName("st2");
        result.add(r2);
        WSData r3=new WSData();
        r3.setCity("青岛");
        r3.setWorksiteId("L-CS00-CSSDG12");
        r3.setWorksiteName("t2");
        r3.setStageId("L-CS00-CSSDG12.01");
        r3.setStageName("st1");
        result.add(r3);
        WSData r4=new WSData();
        r4.setCity("长沙");
        r4.setWorksiteId("L-CS00-CSSDG13");
        r4.setWorksiteName("t3");
        r4.setStageId("L-CS00-CSSDG13.01");
        r4.setStageName("st1");
        result.add(r4);
        WSData r5=new WSData();
        r5.setCity("青岛");
        r5.setWorksiteId("L-CS00-CSSDG14");
        r5.setWorksiteName("t4");
        r5.setStageId("L-CS00-CSSDG14.01");
        r5.setStageName("st1");
        result.add(r5);
        return result;
    }

    //存入对象到MAP
    public void putCity(WSData tempResult){
        List<StageInfoDTO> stageInfoDTOList=new ArrayList<>();
        List<WorksitePartDTO> worksitePartDTOList=new ArrayList<>();
        StageInfoDTO stageInfoDTO=new StageInfoDTO();
        WorksitePartDTO worksitePartDTO=new WorksitePartDTO();
        SelectCameraViewDTO selectCameraViewDTO=new SelectCameraViewDTO();
        selectCameraViewDTO.setCity(tempResult.getCity());
        worksitePartDTO.setWorksiteId(tempResult.getWorksiteId());
        worksitePartDTO.setWorksiteName(tempResult.getWorksiteName());
        stageInfoDTO.setStageId(tempResult.getStageId());
        stageInfoDTO.setStageName(tempResult.getStageName());
        stageInfoDTOList.add(stageInfoDTO);
        worksitePartDTO.setStageList(stageInfoDTOList);
        worksitePartDTOList.add(worksitePartDTO);
        selectCameraViewDTO.setWorksiteList(worksitePartDTOList);
        map.put(tempResult.getCity(),selectCameraViewDTO);
    }

    //zhangyu test
    public void rebuilder(List<WSData> wslist, Demo2 demo) {
        for (WSData tempResult : wslist) {
            SelectCameraViewDTO oneCity=map.get(tempResult.getCity());
            if (Objects.nonNull(oneCity)) {
                Map<String, WorksitePartDTO> mapws = oneCity.getWorksiteList().stream().collect(Collectors.toMap(WorksitePartDTO::getWorksiteId, worksitePartDTO -> worksitePartDTO));
                    WorksitePartDTO nowws=mapws.get(tempResult.getWorksiteId());
                    if (Objects.nonNull(nowws)){
                        //如果worksite相等，就加stage
                        StageInfoDTO stageInfoDTO=new StageInfoDTO();
                        stageInfoDTO.setStageId(tempResult.getStageId());
                        stageInfoDTO.setStageName(tempResult.getStageName());
                        nowws.getStageList().add(stageInfoDTO);
                    }else{
                        //如果没有这个worksite，就加worksite
                        nowws=new WorksitePartDTO();
                        nowws.setWorksiteId(tempResult.getWorksiteId());
                        nowws.setWorksiteName(tempResult.getWorksiteName());
                        StageInfoDTO stageInfoDTO=new StageInfoDTO();
                        stageInfoDTO.setStageId(tempResult.getStageId());
                        stageInfoDTO.setStageName(tempResult.getStageName());
                        List<StageInfoDTO> stageInfoDTOList=new ArrayList<>();
                        stageInfoDTOList.add(stageInfoDTO);
                        nowws.setStageList(stageInfoDTOList);
                        map.get(tempResult.getCity()).getWorksiteList().add(nowws);
                    }
            }else{
                demo.putCity(tempResult);
            }
        }
        System.out.println("========rebuilde结束===========");
        System.out.println(map);
        //map转list
        //List<SelectCameraViewDTO> list11 = map.entrySet().stream().sorted(Map.Entry.comparingByKey()).map(e -> new SelectCameraViewDTO(e.getKey(), e.getValue().getWorksiteList())).collect(Collectors.toList());
        List<SelectCameraViewDTO> list11 = map.entrySet().stream().map(e -> new SelectCameraViewDTO(e.getKey(), e.getValue().getWorksiteList())).collect(Collectors.toList());

        System.out.println(list11);

        System.out.println("end");

    }

    public static void main(String[] args) {
        Demo2 demo=new Demo2();
        demo.rebuilder(demo.initData(),demo);
    }


}
