package com.boyuan.api;

import com.boyuan.domain.Template;
import com.boyuan.domain.User;
import com.boyuan.service.TemplateService;
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
 * @time 2018/1/5
 */
@Controller
@RequestMapping("/interview/template")
public class TemplateApi {

    @Autowired
    private TemplateService templateService;

    private static final String PAGE_PREFIX = "interview/template/%s";

    @RequestMapping("/index")
    public String index(@RequestParam(value = "name",defaultValue = "")String name,ModelMap model){
        List<Template> templates = templateService.getTemplates(name);
        model.addAttribute("templates",templates);

        return String.format(PAGE_PREFIX,"index");
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(){

        return String.format(PAGE_PREFIX,"save");
    }

    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public String edit(@RequestParam("id") Long id,ModelMap model) throws Exception{
        Template template = templateService.getOne(id);
        model.addAttribute("template",template);

        return String.format(PAGE_PREFIX,"save");
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(@RequestAttribute("user")User user, Template template) throws Exception{
        templateService.save(template,user);

        return "redirect:index";
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String delete(@RequestParam("id") Long id,@RequestAttribute("user")User user) throws Exception{
        templateService.delete(id,user);

        return "redirect:index";
    }
}
