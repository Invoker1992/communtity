package com.mrh.community.controller;

import com.mrh.community.dto.PaginationDTO;
import com.mrh.community.dto.QuestionDTO;
import com.mrh.community.mapper.UserMapper;
import com.mrh.community.model.User;
import com.mrh.community.service.QuestionService;
import com.mrh.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Thanks For Watching！
 *
 * @author HuJiaqun
 * @date 2020/2/11 15:52
 **/
@Controller
public class IndexController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String Index(Model model,
                        @RequestParam(name = "page",defaultValue = "1")Integer page,
                        @RequestParam(name = "size",defaultValue = "7")Integer size,
                        @RequestParam(name = "search",required = false)String search
                        )
    {
        PaginationDTO pagination = questionService.list(search,page,size);
        List<QuestionDTO> popularQuestions = questionService.selectPopular();
        List<QuestionDTO> topQuestions = questionService.selectTop();
        List<User> topUsers = userService.selectUser();
        model.addAttribute("pagination",pagination);
        model.addAttribute("search",search);
        model.addAttribute("topUsers",topUsers); //活跃用户
        model.addAttribute("popularQuestions",popularQuestions); //热门话题
        model.addAttribute("topQuestions",topQuestions); //话题排行榜
        return "index";
    }

}
