package com.boyuan.api;

import com.boyuan.domain.Role;
import com.boyuan.domain.User;
import com.boyuan.service.RoleService;
import com.boyuan.vo.PermissionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping("/save")
    public String save(@RequestParam(value = "id",required = false) Long id, ModelMap model) throws Exception{
        if(id != null){
            Role role = roleService.getRole(id);
            model.put("currentRole",role);
        }
        List<PermissionVO> permissionVOS = roleService.getPermission(id);
        model.put("permissionVOS",permissionVOS);
        return String.format(PAGE_PREFIX,"save");
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(@RequestParam(value = "roleId",required = false) Long roleId,@RequestAttribute("user") User user
            ,@RequestParam("roleName") String roleName,@RequestParam("permission") List<Long> permission) throws Exception{
        roleService.save(roleId,roleName,permission,user);
        return "redirect:index";
    }
}
