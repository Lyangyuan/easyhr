package com.boyuan.api;

import com.boyuan.base.utils.PageUtil;
import com.boyuan.domain.RoleUser;
import com.boyuan.domain.User;
import com.boyuan.dto.UserDTO;
import com.boyuan.service.UserService;
import com.boyuan.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
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
@RequestMapping("/permission/user")
public class UserAPi {

    private static final String PAGE_PREFIX = "permission/user/%s";

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index(ModelMap model){
        List<RoleUser> roleUsers = userService.getUsers();
        model.addAttribute("roleUsers",roleUsers);
        return String.format(PAGE_PREFIX,"index");
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(@RequestAttribute("user")User user,
                      @RequestParam("role") Integer role,
                      @RequestParam("nickname") String nickname,
                      @RequestParam("account") String account) throws Exception{
        userService.add(user,nickname,account,role);
        return "redirect:index";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("id") Long id) throws Exception{
        userService.delete(id);
        return "redirect:index";
    }

    @RequestMapping("/freeze")
    public String freeze(@RequestParam("id") Long id) throws Exception{
        userService.freeze(id);
        return "redirect:index";
    }
}
