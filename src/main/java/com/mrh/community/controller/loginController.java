package com.mrh.community.controller;

import com.mrh.community.dto.PaginationDTO;
import com.mrh.community.dto.QuestionDTO;
import com.mrh.community.dto.RegisterUserDTO;
import com.mrh.community.mapper.RegisterUserMapper;
import com.mrh.community.mapper.UserMapper;
import com.mrh.community.model.User;
import com.mrh.community.model.UserExample;
import com.mrh.community.service.QuestionService;
import com.mrh.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

/**
 * Thanks For Watching！
 *
 * @author HuJiaqun
 * @date 2021/5/27 15:52
 **/
@Controller
public class loginController {

//    private static final String avatarUrl = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201702%2F06%2F20170206134245_zeQx2.jpeg&refer=http%3A%2F%2Fb-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1624763475&t=773674ece66c9b5384b76596e64e3808";

    @Autowired
    private RegisterUserMapper userMapper;

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String Login() {
        return "/login";
    }

    @RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
    public String LoginCheck(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             HttpServletResponse response,
                             Model model) {
        RegisterUserDTO registerUserDTO = userMapper.loginCheckStatus(username, password);
        if (registerUserDTO!=null) {
            User user = new User();
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setName(registerUserDTO.getUsername());
            user.setAccountId(getLenAccountId(10));
            user.setAvatarUrl(registerUserDTO.getAvatarUrl());
            userService.createOrUpdate(user);
            //登录成功，写cookie，session
            response.addCookie(new Cookie("token", token));
            return "redirect:/";
        }
        model.addAttribute("loginError", "账号密码错误，或用户不存在！");
        return "/login";
    }

    /**
     * 获取定长的随机码
     *
     * @param len
     * @return
     */
    private String getLenAccountId(int len) {
        String baseStr = "1234567890";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int tem = (int) (Math.random() * (baseStr.length()- 1));
            while (i == 0 && tem == (baseStr.length() - 1)) {
                tem = (int) (Math.random() * (baseStr.length()- 1));
            }
            builder.append(baseStr.charAt(tem));
        }
        return builder.toString();
    }

}
