package com.boyuan.service;

import com.boyuan.base.EasyhrException;
import com.boyuan.base.utils.TimeUtil;
import com.boyuan.domain.Permission;
import com.boyuan.domain.Role;
import com.boyuan.domain.RolePermission;
import com.boyuan.domain.User;
import com.boyuan.repository.PermissionRepository;
import com.boyuan.repository.RolePermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangbo
 * @time 2018/1/3
 */
@Service
public class PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

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

    public void save(Role role,List<Long> permissionIds,User user) throws  Exception{
        rolePermissionRepository.deleteByRoleId(role.getId());

        if(CollectionUtils.isEmpty(permissionIds)){
            throw new EasyhrException("权限点不能为空");
        }

        List<RolePermission> rolePermissions = new ArrayList<RolePermission>();
        RolePermission rolePermission;
        for (Long permissionId : permissionIds) {
            rolePermission = new RolePermission();
            rolePermission.setPermissionId(permissionId);
            rolePermission.setRoleId(role.getId());
            rolePermission.setCreatedUserId(user.getId());
            rolePermission.setModifiedUserId(user.getId());
            rolePermission.setGmtCreated(TimeUtil.now());
            rolePermission.setGmtModified(TimeUtil.now());

            rolePermissions.add(rolePermission);
        }

        rolePermissionRepository.save(rolePermissions);
        rolePermissionRepository.flush();
    }
}
