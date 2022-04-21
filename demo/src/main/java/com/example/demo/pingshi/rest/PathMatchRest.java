package com.example.demo.pingshi.rest;

import cn.hutool.core.collection.CollUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description
 * @date 2022-01-21 11:14
 */

@RestController
@SpringBootTest
@RunWith(SpringRunner.class)
public class PathMatchRest {


    @GetMapping(value = "/test/api/devices/v2/devices")
    public void show(HttpServletRequest request, @RequestParam String test){
        String url=request.getRequestURI();
        System.out.println("url:"+url);
        String[] cc=url.split("/api");
        PathMatcher mm=new AntPathMatcher();
        System.out.println(mm.match("/devices/v2/devices", cc[1]));
    }

    @Test
    public void s1(){
        String path = "/api/devices/v2/devices";
        String[] paths= path.split("/api");
        System.out.println("paths:"+paths[1]);
        PathMatcher pathMatcher = new AntPathMatcher();
        if (pathMatcher.match("/devices/v2/devices", paths[1])) {
            System.out.println("我爱你");
        }else{
            System.out.println("cy,ilu");
        }
    }

    @GetMapping(value = "/api/devices/v2/devices")
    public void s2(HttpServletRequest request,@RequestParam String test) {
        Map<String, ConfigAttribute> map = new ConcurrentHashMap<>();
        UPermission p1=new UPermission(27L,"/devices/v2/devices");
        UPermission p2=new UPermission(28L,"/devices");
        List<UPermission> permissionList = new ArrayList<>();
        permissionList.add(p1);
        permissionList.add(p2);
        for (UPermission permission : permissionList) {
            map.put(permission.getUrl(), new org.springframework.security.access.SecurityConfig(permission.getId() + ":" + permission.getUrl()));
        }
        List<ConfigAttribute> configAttributes = new ArrayList<>();
        //获取当前访问的路径
        String path = request.getRequestURI();
        String[] path1=path.split("/api");
        PathMatcher pathMatcher = new AntPathMatcher();
        Iterator<String> iterator = map.keySet().iterator();
        //获取访问该路径所需资源
        while (iterator.hasNext()) {
            String pattern = iterator.next();
            if (pathMatcher.match(pattern, path1[1])) {
                configAttributes.add(map.get(pattern));
            }
        }
        // 当接口未被配置资源时直接放行
        if (CollUtil.isEmpty(configAttributes)) {
            return;
        }
        Iterator<ConfigAttribute> iterator1 = configAttributes.iterator();
        while (iterator1.hasNext()) {
            ConfigAttribute configAttribute = iterator1.next();
            //将访问所需资源或用户拥有资源进行比对
            String needAuthority = configAttribute.getAttribute();
            String[] auths={"27:/devices/v2/devices"};
            for (int i=0;i< auths.length;i++) {
                if (needAuthority.trim().equals(auths[i])) {
                    System.out.println("我爱你");
                }
            }
        }
    }

}
