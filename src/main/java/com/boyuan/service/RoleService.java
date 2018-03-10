package com.boyuan.service;

import com.boyuan.base.EasyhrException;
import com.boyuan.base.utils.TimeUtil;
import com.boyuan.domain.Permission;
import com.boyuan.domain.Role;
import com.boyuan.domain.RolePermission;
import com.boyuan.domain.User;
import com.boyuan.repository.PermissionRepository;
import com.boyuan.repository.RolePermissionRepository;
import com.boyuan.repository.RoleRepository;
import com.boyuan.vo.PermissionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RolePermissionRepository rolePermissionRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private PermissionService permissionService;

    public Role getRole(Long id) throws Exception {
        Role role = roleRepository.findOne(id);
        if (role == null) {
            throw new EasyhrException("角色不存在");
        }
        return role;
    }

    /**
     * 获取全部的权限点和这个角色已有的权限点
     */
    public List<PermissionVO> getPermission(Long roleId) {
        List<PermissionVO> permissionVOS = null;

        List<Permission> allPermission = permissionRepository.findAll();
        List<Long> rolePermissionIds = new ArrayList<Long>();

        if (roleId == null) {
            for (Permission permission : allPermission) {
                rolePermissionIds.add(permission.getId());
            }
        } else {
            List<RolePermission> rolePermissions = rolePermissionRepository.findByRoleId(roleId);
            if (!CollectionUtils.isEmpty(rolePermissions)) {
                for (RolePermission permission : rolePermissions) {
                    rolePermissionIds.add(permission.getPermissionId());
                }
            }
        }

        permissionVOS = buildPermissionTree(rolePermissionIds, allPermission);

        return permissionVOS;
    }

    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    public void save(Long id, String roleName, List<Long> permission,User user) throws Exception {
        if (StringUtils.isEmpty(roleName)) {
            throw new EasyhrException("角色名称不能为空");
        }

        Role roleDB = roleRepository.findByName(roleName);

        Role role;
        if (id != null) {
            role = roleRepository.findOne(id);
            if (role == null) {
                throw new EasyhrException("角色不存在");
            }

            if(roleDB != null && !roleDB.getId().equals(role.getId())){
                throw new EasyhrException("角色:" + roleName + "已经存在");
            }
        } else {
            if (roleDB != null) {
                throw new EasyhrException("角色:" + roleName + "已经存在");
            }

            role = new Role();
            role.setGmtCreated(TimeUtil.now());
            role.setModifiedUserId(user.getId());
        }

        role.setRoleName(roleName);
        role.setGmtModified(TimeUtil.now());
        role.setCreatedUserId(user.getId());
        role = roleRepository.saveAndFlush(role);

        permissionService.save(role,permission,user);
    }

    private List<PermissionVO> buildPermissionTree(List<Long> rolePermissionIds, List<Permission> allPermission) {
        List<PermissionVO> permissionVOS = new ArrayList<PermissionVO>();
        boolean checked;
        // level 1
        for (Permission permission : allPermission) {
            if (permission.getLevel() == 1) {
                checked = rolePermissionIds.contains(permission.getId()) ? true : false;
                permissionVOS.add(new PermissionVO(permission.getId(), permission.getName(), 1, checked));
            }
        }

        // level 2
        List<PermissionVO> permissionVOS1;
        for (int i = 0; i < permissionVOS.size(); i++) {
            permissionVOS1 = new ArrayList<PermissionVO>();
            for (Permission permission : allPermission) {
                if (permission.getLevel() == 2 && permission.getParentId().equals(permissionVOS.get(i).getId())) {
                    checked = rolePermissionIds.contains(permission.getId()) ? true : false;
                    permissionVOS1.add(new PermissionVO(permission.getId(), permission.getName(), 1, checked));
                }
            }
            permissionVOS.get(i).setChildren(permissionVOS1);
        }

        // level 3
        List<PermissionVO> permissionVOS2;
        for (PermissionVO permissionVO : permissionVOS) {
            for (PermissionVO vo : permissionVO.getChildren()) {
                permissionVOS2 = new ArrayList<PermissionVO>();
                for (Permission permission : allPermission) {
                    if (permission.getLevel() == 3 && permission.getParentId().equals(vo.getId())) {
                        checked = rolePermissionIds.contains(permission.getId()) ? true : false;
                        permissionVOS2.add(new PermissionVO(permission.getId(), permission.getName(), 1, checked));
                    }
                }
                vo.setChildren(permissionVOS2);
            }
        }
        return permissionVOS;
    }

}
