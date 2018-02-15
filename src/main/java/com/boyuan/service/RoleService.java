package com.boyuan.service;

import com.boyuan.base.EasyhrException;
import com.boyuan.domain.Permission;
import com.boyuan.domain.Role;
import com.boyuan.domain.RolePermission;
import com.boyuan.repository.RolePermissionRepository;
import com.boyuan.repository.RoleRepository;
import com.boyuan.vo.PermissionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RolePermissionRepository rolePermissionRepository;

    public Role getRole(Long id) throws Exception{
        Role role = roleRepository.findOne(id);
        if(role == null){
            throw new EasyhrException("角色不存在");
        }
        return role;
    }

    public List<PermissionVO> getPermission(Long roleId){
        List<RolePermission> rolePermissions = rolePermissionRepository.findByRoleId(roleId);
        List<PermissionVO> permissionVOS = null;
        if(!CollectionUtils.isEmpty(rolePermissions)){
            permissionVOS = new ArrayList<PermissionVO>();
            Map<String,List<Permission>> map = new HashMap<String, List<Permission>>();
            List<Permission> permissions;
            for (RolePermission rolePermission : rolePermissions) {
//                if(map.containsKey(rolePermission.getPermission().getModule())){
//                    map.get(rolePermission.getPermission().getModule()).add(rolePermission.getPermission());
//                } else {
//                    permissions = new ArrayList<Permission>();
//                    permissions.add(rolePermission.getPermission());
//                    map.put(rolePermission.getPermission().getModule(),permissions);
//                }
            }

            PermissionVO permissionVO;
            for (String key : map.keySet()) {
                permissionVO = new PermissionVO();
                permissionVO.setModule(key);
                permissionVO.setPermissions(map.get(key));
                permissionVOS.add(permissionVO);
            }
        }
        return permissionVOS;
    }

    public List<Role> getRoles(){
        return roleRepository.findAll();
    }
}
