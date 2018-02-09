package com.boyuan.api;

import com.boyuan.base.utils.PageUtil;
import com.boyuan.domain.Employee;
import com.boyuan.domain.User;
import com.boyuan.dto.EmployeeDTO;
import com.boyuan.service.EmployeeService;
import com.boyuan.vo.EmployeeVO;
import com.boyuan.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jiangbo
 * @time 2018/1/19
 */
@Controller
@RequestMapping("/employee")
public class EmployeeApi {

    @Autowired
    private EmployeeService employeeService;

    private static final String PAGE_PREFIX = "employee/%s";

    /**
     * 列表页面
     */
    @RequestMapping("/index")
    public String index(EmployeeDTO employeeDTO, ModelMap model){
        Page<Employee> page = employeeService.query(employeeDTO);
        PageResult<List<Employee>> pageResult = PageUtil.getPageResult(page);

        model.addAttribute("pageResult",pageResult);
        return String.format(PAGE_PREFIX,"index");
    }

    @RequestMapping("/save")
    public String save(@RequestParam("id") Long id,ModelMap model) throws Exception{
        model.put("employee",employeeService.getOne(id));
        return String.format(PAGE_PREFIX,"save");
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(@RequestAttribute("user") User user,Employee employee) throws Exception{
        employeeService.save(user,employee);
        return "redirect:index";
    }

    @RequestMapping("/save2")
    public String save2(@RequestParam(name = "token") String token,ModelMap model){

        model.put("employee",null);
        return String.format(PAGE_PREFIX,"save");
    }

    @RequestMapping(value = "/save2",method = RequestMethod.POST)
    public String save2(Employee employee) throws Exception{
        // employeeService.save(user,employee);
        return "redirect:index";
    }

    @ResponseBody
    @RequestMapping("/save2")
    public String save2(){

        return "填写成功";
    }

    /**
     * @status ok
     * @desc 锁定解锁
     */
    @ResponseBody
    @RequestMapping("/lock")
    public void lock(@RequestAttribute("user") User user, @RequestParam("id") Long id) throws Exception{
        employeeService.lock(user,id);
    }
}
