package com.boyuan.api;

import com.boyuan.base.utils.PageUtil;
import com.boyuan.domain.Candidate;
import com.boyuan.domain.Post;
import com.boyuan.domain.User;
import com.boyuan.dto.CandidateDTO;
import com.boyuan.enums.CandidateStatusEnum;
import com.boyuan.service.CandidateService;
import com.boyuan.service.PostService;
import com.boyuan.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangbo
 * @date 2017\11\18 0018
 */
@Controller
@RequestMapping("/interview/candidate")
public class CandidateApi {

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private PostService postService;

    private static final String PAGE_PREFIX = "interview/candidate/%s";

    /**
     * @status ok
     * @desc 列表页面
     */
    @RequestMapping("/index")
    public String index(CandidateDTO candidateDTO, ModelMap model){
        Page<Candidate> page = candidateService.query(candidateDTO);
        PageResult<List<Candidate>> pageResult = PageUtil.getPageResult(page);
        List<String> statusList = new ArrayList<String>();
        CandidateStatusEnum[] statuses = CandidateStatusEnum.values();
        for (CandidateStatusEnum status : statuses) {
            statusList.add(status.getStatus());
        }
        model.addAttribute("pageResult",pageResult);
        model.addAttribute("statusList",statusList);

        return String.format(PAGE_PREFIX,"index");
    }

    /**
     * @status ok
     * @desc 添加页面
     */
    @RequestMapping("/save")
    public String edit(@RequestParam(name = "id",required = false) Long id,ModelMap model) throws Exception{
        if(id != null){
            Candidate candidate = candidateService.getOne(id);
            model.addAttribute("candidate",candidate);
        }

        List<Post> posts = postService.getPosts(new Post());
        model.addAttribute("posts",posts);

        return String.format(PAGE_PREFIX,"save");
    }

    /**
     * @status ok
     * @desc 保存候选人
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(@RequestAttribute("user")User user, Candidate candidate) throws Exception{
        candidateService.save(user,candidate);
        return "redirect:index";
    }

    /**
     * @status ok
     * @desc 修改状态
     */
    @ResponseBody
    @RequestMapping(value = "/status")
    public void status(@RequestAttribute("user")User user,
                       @RequestParam("id") Long id,
                       @RequestParam("status") String status) throws Exception{
        candidateService.status(user,id,status);
    }

    /**
     * @status
     * @desc 入职操作
     */
    @ResponseBody
    @RequestMapping("/entry")
    public String entry(@RequestAttribute("user")User user,@RequestParam("id") Long id){
        // TODO make candidate entry company

        return "redirect:index";
    }

    /**
     * @status
     * @desc 下载
     */
    @RequestMapping("/download")
    public String download(@RequestParam("condition") String condition){
        // TODO download candidates

        return "redirect:index";
    }
}
