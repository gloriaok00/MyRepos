package com.macro.cloud.service;


import com.macro.cloud.model.Permission;
import com.macro.cloud.model.Role;
import com.macro.cloud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MyUserDetails implements UserDetails {

    //后台用户
    @Autowired
    private User user;

    //拥有资源列表
    private List<Permission> permissionList;

    //拥有角色列表
    private List<Role> roleList;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的资源
        return permissionList.stream()
                .map(permission ->new SimpleGrantedAuthority(permission.getId()+":"+permission.getName()))
                .collect(Collectors.toList());
        //返回当前用户的角色
     /*  return roleList.stream()
                .map(role ->new SimpleGrantedAuthority("ROLE_"+role.getName()))
                .collect(Collectors.toList());*/
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }

    public MyUserDetails(User user, List<Permission> permissionList, List<Role> roleList) {
        this.user = user;
        this.permissionList = permissionList;
        this.roleList = roleList;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
