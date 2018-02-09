package com.boyuan.service;

import com.boyuan.domain.Permission;
import com.boyuan.repository.PermissionRepository;
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
public class PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

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
}
