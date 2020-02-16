package com.mrh.community.controller;

import com.mrh.community.dto.PaginationDTO;
import com.mrh.community.dto.QuestionDTO;
import com.mrh.community.mapper.QuestionMapper;
import com.mrh.community.mapper.UserMapper;
import com.mrh.community.model.Question;
import com.mrh.community.model.User;
import com.mrh.community.service.QuestionService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
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
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String Index(HttpServletRequest request,
                        Model model,
                        @RequestParam(name = "page",defaultValue = "1")Integer page,
                        @RequestParam(name = "size",defaultValue = "5")Integer size
                        )
    {
        Cookie[] cookies = request.getCookies();
        if(cookies!=null&&cookies.length!=0)
        {
            for(Cookie cookie : cookies)
            {
                if(cookie.getName().equals("token"))
                {
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if(user!=null)
                    {
                        request.getSession().setAttribute("user",user);
                    }
                    break;
                }
            }
        }
        PaginationDTO pagination = questionService.list(page,size);
        model.addAttribute("pagination",pagination);
        return "index";
    }

}
