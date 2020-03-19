package com.mrh.community.controller;

import com.mrh.community.dto.PaginationDTO;
import com.mrh.community.mapper.UserMapper;
import com.mrh.community.model.User;
import com.mrh.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

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

    @GetMapping("/")
    public String Index(Model model,
                        @RequestParam(name = "page",defaultValue = "1")Integer page,
                        @RequestParam(name = "size",defaultValue = "5")Integer size,
                        @RequestParam(name = "search",required = false)String search
                        )
    {
        PaginationDTO pagination = questionService.list(search,page,size);
        model.addAttribute("pagination",pagination);
        model.addAttribute("search",search);
        return "index";
    }

}
