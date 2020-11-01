package com.example.demo.pingshi.json;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyu
 * @date 2019-10-28 21:08
 */

@RestController
public class JSONList {

    @RequestMapping(value="/jsonlist",method = RequestMethod.GET)
    public Param getJson() {
        String buildings = "[\"80c42069c9ca46d1b840b6d269fe170e0202\",\"179b55c031a04b58876ef409686db7c00052\",\"0d6f85f4aeb04439a57e3d9008c19ffd0938\",\"c7bb8a20548b423cb6db68498bac3aef0881\",\"ec3b28b513c74b929611c64a34e1c6950769\",\"6a2d289b96b04bb8b64775332a74e83d0418\",\"2f3d2b4d308c4de68003efe070592c500057\"]";
        System.out.println(buildings);
        Param param = new Param();
        param.setName("网站");
        param.setNum(3);
        List<String> siteList = new ArrayList<String>();
        siteList.add("Google");
        siteList.add("Runoob");
        siteList.add("Taobao");
        param.setSites(siteList);
        return param;
    }
}
