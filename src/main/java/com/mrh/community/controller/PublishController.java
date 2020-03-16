package com.mrh.community.controller;

import com.mrh.community.cache.TagCache;
import com.mrh.community.dto.QuestionDTO;
import com.mrh.community.mapper.QuestionMapper;
import com.mrh.community.model.Question;
import com.mrh.community.model.User;
import com.mrh.community.service.QuestionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Thanks For Watching！
 *
 * @author HuJiaqun
 * @date 2020/2/14 19:19
 **/

@Controller
public class PublishController {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/publish/{id}")
    public String edit(@PathVariable(name = "id")Long id,
                       Model model)
    {
        QuestionDTO question = questionService.getById(id);
        model.addAttribute("title",question.getTitle());
        model.addAttribute("description",question.getDescription());
        model.addAttribute("tag",question.getTag());
        model.addAttribute("id",question.getId());

        model.addAttribute("tags", TagCache.get());
        return "publish";
    }

    @GetMapping("/publish")
    public String publish(Model model)
    {
        model.addAttribute("tags", TagCache.get());
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(
            @RequestParam(value = "title",required = false)String title,
            @RequestParam(value = "description",required = false)String description,
            @RequestParam(value = "tag",required = false)String tag,
            @RequestParam(value = "id",required = false)Long id,
            HttpServletRequest request,
            Model model)
    {
        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);
        model.addAttribute("tags", TagCache.get());

        if(title==null||title=="")
        {
            model.addAttribute("Error","标题不能为空");
            return "publish";
        }
        if(description==null||description=="")
        {
            model.addAttribute("Error","话题补充不能为空");
            return "publish";
        }
        if(tag==null||tag=="")
        {
            model.addAttribute("Error","标签不能为空");
            return "publish";
        }

        String invalid = TagCache.filterInvalid(tag);
        if(StringUtils.isNotBlank(invalid))
        {
            model.addAttribute("Error","标签内含有非法字符："+invalid);
            return "publish";
        }

        User user = (User) request.getSession().getAttribute("user");
        if(user == null)
        {
            model.addAttribute("Error","用户未登录");
            return "publish";
        }

        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());
        question.setId(id);
        questionService.createOrUpdate(question);

        return "redirect:/";
    }
}
