package com.boyuan.service;

import com.boyuan.domain.Permission;
import com.boyuan.domain.RolePermission;
import com.boyuan.domain.RoleUser;
import com.boyuan.domain.User;
import com.boyuan.repository.PermissionRepository;
import com.boyuan.repository.RolePermissionRepository;
import com.boyuan.repository.RoleUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangbo
 * @time 2018/1/3
 */
@Service
public class AuthenticateService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private RoleUserRepository roleUserRepository;

    @Autowired
    private RolePermissionRepository rolePermissionRepository;

    /**
     * 获取全部权限url
     * @return
     */
    public List<String> getPermissionUrls(){
        List<String> urls = new ArrayList<String>();
        List<Permission> permissions = permissionRepository.findAll();
        if(!CollectionUtils.isEmpty(permissions)){
            for (Permission permission : permissions) {
                urls.add(permission.getUrl());
            }
        }
        return urls;
    }

    public boolean checkPermission(User user,String url){
        // 获取用户的角色
        List<RoleUser> roleUsers = roleUserRepository.findByUserId(user.getId());
        if(!CollectionUtils.isEmpty(roleUsers)){
            List<Long> roleIds = new ArrayList<Long>();
            for (RoleUser roleUser : roleUsers) {
                roleIds.add(roleUser.getRoleId());
            }
            List<RolePermission> rolePermissions = rolePermissionRepository.findByRoleIds(roleIds);
            if(!CollectionUtils.isEmpty(rolePermissions)){
                List<String> urls = new ArrayList<String>();
                for (RolePermission rolePermission : rolePermissions) {
                    urls.add(rolePermission.getPermission().getUrl());
                }
                if(urls.contains(url)){
                    return true;
                }
            }
        }
        return false;
    }
}
