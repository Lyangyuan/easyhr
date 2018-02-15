package com.boyuan.api;

import com.boyuan.domain.Role;
import com.boyuan.service.RoleService;
import com.boyuan.vo.PermissionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author jiangbo
 * @time 2018/1/20
 */
@Controller
@RequestMapping("/permission/role")
public class RoleApi {

    @Autowired
    private RoleService roleService;

    private static final String PAGE_PREFIX = "permission/role/%s";

    @RequestMapping("/index")
    public String index(ModelMap model){
        List<Role> roles =  roleService.getRoles();
        model.put("roles",roles);
        return String.format(PAGE_PREFIX,"index");
    }

    @RequestMapping("/edit")
    public String edit(@RequestParam("id")Long id, ModelMap model) throws Exception{
        Role role = roleService.getRole(id);
        List<PermissionVO> permissionVOS = roleService.getPermission(id);
        model.put("currentRole",role);
        model.put("permissionVOS",permissionVOS);
        return String.format(PAGE_PREFIX,"edit");
    }
}
