package com.boyuan.api;

import com.boyuan.domain.InterviewRecord;
import com.boyuan.domain.User;
import com.boyuan.dto.CreateRecordDTO;
import com.boyuan.service.InterviewRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jiangbo
 * @time 2017/12/9
 */
@Controller
@RequestMapping("/interview/record")
public class InterviewRecordApi {

    @Autowired
    private InterviewRecordService recordService;

    private static final String PAGE_PREFIX = "interview/record/%s";

    /**
     * @status
     * @desc 面试记录列表页面
     */
    @RequestMapping("/index")
    public String index(@RequestParam("candidateId") Long candidateId, ModelMap model) throws Exception{
        List<InterviewRecord> records = recordService.getRecordByCandidate(candidateId);
        model.addAttribute("records",records);

        return String.format(PAGE_PREFIX,"index");
    }

    /**
     * @status
     * @desc 创建面试记录
     */
    @ResponseBody
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public void create(@RequestAttribute("user") User user,CreateRecordDTO recordDTO) throws Exception{
        recordService.create(user,recordDTO);
    }

    /**
     * @status
     * @desc 填写页面
     */
    @RequestMapping("/save")
    public String add(@RequestParam(name = "id",required = false) Long id,ModelMap model) throws Exception{
        InterviewRecord record = recordService.getOne(id);
        model.addAttribute("record",record);
        return String.format(PAGE_PREFIX,"save");
    }

    /**
     * @status
     * @desc 他人填写页面
     */
    @RequestMapping("/save2")
    public String save2(@RequestParam(name = "token") String token,ModelMap model) throws Exception{
        InterviewRecord record = recordService.getByToken(token);
        model.addAttribute("record",record);
        model.addAttribute("token",token);
        return String.format(PAGE_PREFIX,"save");
    }

    /**
     * 自己保存接口
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(@RequestAttribute("user") User user, InterviewRecord record) throws Exception{
        recordService.save(record,user);
        return "redirect:index";
    }

    /**
     * 他人保存接口
     */
    @ResponseBody
    @RequestMapping(value = "/save2",method = RequestMethod.POST)
    public String save2(InterviewRecord record) throws Exception{
        recordService.save2(record);
        return "填写成功";
    }

    /**
     * @status ok
     * @desc 锁定解锁
     */
    @ResponseBody
    @RequestMapping("/lock")
    public void lock(@RequestAttribute("user") User user,@RequestParam("id") Long id) throws Exception{
        recordService.lock(user,id);
    }
}
