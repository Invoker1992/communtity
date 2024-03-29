package com.mrh.community.controller;

import com.mrh.community.dto.PaginationDTO;
import com.mrh.community.model.User;
import com.mrh.community.service.NotificationService;
import com.mrh.community.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Thanks For Watching！
 *
 * @author HuJiaqun
 * @date 2020/2/17 20:19
 **/

@Controller
@Slf4j
public class profileController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/profile/{action}")
    public String profile(HttpServletRequest request,
                          @PathVariable(name = "action") String action,
                          Model model,
                          @RequestParam(name = "page",defaultValue = "1")Integer page,
                          @RequestParam(name = "size",defaultValue = "7")Integer size)
    {
        User user = (User) request.getSession().getAttribute("user");
        if(user==null)
        {
            //log.error("profile:user==null,{}",action);
            return "redirect:/";
        }

        if("questions".equals(action))
        {
            model.addAttribute("section","questions");
            model.addAttribute("sectionName","我的提问");
            PaginationDTO paginationDTO = questionService.list(user.getId(), page, size);
            model.addAttribute("pagination",paginationDTO);
        }
        else if("replies".equals(action))
        {
            PaginationDTO paginationDTO = notificationService.list(user.getId(), page, size);
            Long unreadCount = notificationService.unreadCount(user.getId());
            model.addAttribute("pagination",paginationDTO);
            model.addAttribute("section","replies");
            model.addAttribute("sectionName","最新回复");
            model.addAttribute("unreadMessage",unreadCount);
        }
        return "profile";
    }
}
