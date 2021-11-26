package com.macro.cloud.service;

import com.macro.cloud.mapper.PermissionMapper;
import com.macro.cloud.mapper.RoleMapper;
import com.macro.cloud.mapper.UserMapper;
import com.macro.cloud.model.Permission;
import com.macro.cloud.model.Role;
import com.macro.cloud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @description
 * @date 2021-11-26 10:39
 */

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDetails userDetails;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //查数据库
        User user = userMapper.loadUserByUsername( userName );
        if (null != user) {
            List<Role> roles = roleMapper.getRolesByUserId( user.getId() );
            List<Permission> permissionList = permissionMapper.getRolePermissions(roles.stream().map(Role::getId).collect(Collectors.toList()));
            MyUserDetails userDetails= new MyUserDetails(user,permissionList);
            return userDetails;
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }
}
