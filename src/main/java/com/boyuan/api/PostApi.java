package com.boyuan.api;

import com.boyuan.domain.Post;
import com.boyuan.domain.User;
import com.boyuan.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jiangbo
 * @time 2018/1/1
 */
@Controller
@RequestMapping("/employee/post")
public class PostApi {

    @Autowired
    private PostService postService;

    private static final String PAGE_PREFIX = "/employee/post/%s";

    @RequestMapping("/index")
    public String index(ModelMap model){
        List<Post> posts =  postService.getPosts(new Post());
        model.addAttribute("posts",posts);

        return String.format(PAGE_PREFIX,"index");
    }

    @RequestMapping("/get")
    @ResponseBody
    public Post getOne(@RequestParam("id") Long id) throws Exception {
        Post post = postService.getOne(id);

        return post;
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(@RequestAttribute("user") User user, Post post) throws Exception{
        postService.save(post,user);

        return "redirect:index";
    }

    @RequestMapping(value = "/delete")
    public String delete(@RequestParam("id") Long id,@RequestAttribute("user") User user) throws Exception {
        postService.delete(id,user);

        return "redirect:index";
    }
}
