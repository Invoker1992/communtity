package com.mrh.community.controller;

import com.mrh.community.dto.NotificationDTO;
import com.mrh.community.dto.PaginationDTO;
import com.mrh.community.enums.NotificationTypeEnum;
import com.mrh.community.model.User;
import com.mrh.community.service.NotificationService;
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
 * @date 2020/3/16 20:21
 **/
@Controller
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/notification/{id}")
    public String profile(HttpServletRequest request,
                          @PathVariable(name = "id") Long id)
    {
        User user = (User) request.getSession().getAttribute("user");
        if(user==null)
        {
            return "redirect:/";
        }

        NotificationDTO notificationDTO = notificationService.read(id,user);
        if(NotificationTypeEnum.REPLY_COMMENT.getType()==notificationDTO.getType()||
            NotificationTypeEnum.REPLY_QUESTION.getType()==notificationDTO.getType())
        {
            return "redirect:/question/"+notificationDTO.getOuterid();
        }
        else
        {
            return "profile";
        }

    }

}
