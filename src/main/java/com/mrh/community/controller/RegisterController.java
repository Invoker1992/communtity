package com.mrh.community.controller;

import com.mrh.community.cache.avatarUrlCache;
import com.mrh.community.dto.RegisterUserDTO;
import com.mrh.community.mapper.RegisterUserMapper;
import com.mrh.community.model.User;
import com.mrh.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * Thanks For Watching！
 *
 * @author HuJiaqun
 * @date 2021/5/27 15:52
 **/
@Controller
public class RegisterController {

    @Autowired
    private RegisterUserMapper userMapper;

    @Autowired
    private avatarUrlCache avatarUrl;

    @GetMapping("/register")
    public String doRegister() {
        return "register";
    }

    @RequestMapping(value = "/registerCheck", method = RequestMethod.POST)
    public String LoginCheck(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             Model model) {

        int count = userMapper.getUserNameNum(username);
        if(count>0){
            model.addAttribute("msg","用户名已存在，请更换…");
            return "register";
        }
        try{
            userMapper.registerUser(username,password,avatarUrl.getAvatarUrl());
        }catch (Exception e){
            model.addAttribute("msg", "注册失败，请稍后重试");
            return "resister";
        }
        model.addAttribute("loginError", "注册成功，请登录！");
        return "login";
    }

}
