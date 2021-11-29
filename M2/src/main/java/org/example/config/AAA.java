package org.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description
 * @date 2021-11-29 16:08
 */

@Configuration
public class AAA {

    @Autowired
    private PermissionMapper permissionMapper;

    @Bean
    public DynamicSecurityService dynamicSecurityService() {
        return new DynamicSecurityService() {
            @Override
            public Map<String, ConfigAttribute> loadDataSource() {
                Map<String, ConfigAttribute> map = new ConcurrentHashMap<>();
                List<Permission> permissionList = permissionMapper.getAllPermissions();
                for (Permission permission : permissionList) {
                    map.put(permission.getUrl(), new org.springframework.security.access.SecurityConfig(permission.getId() + ":" + permission.getName()));
                }
                return map;
            }
        };
    }
}
