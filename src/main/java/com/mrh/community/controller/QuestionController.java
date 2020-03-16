package com.mrh.community.controller;

import com.mrh.community.dto.CommentDTO;
import com.mrh.community.dto.QuestionDTO;
import com.mrh.community.enums.CommentTypeEnum;
import com.mrh.community.service.CommentService;
import com.mrh.community.service.QuestionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Thanks For Watching！
 *
 * @author HuJiaqun
 * @date 2020/2/27 14:59
 **/
@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id")Long id,
                           Model model)
    {
        QuestionDTO questionDTO = questionService.getById(id);
        List<QuestionDTO> relatedQuestions = questionService.selectRelated(questionDTO);
        List<CommentDTO> comments = commentService.listByTargetId(id, CommentTypeEnum.QUESTION);
        questionService.incView(id); //累加阅读数
        //自加
        if(questionDTO.getTag().contains("."))
        {
          questionDTO.setTag(StringUtils.replace(questionDTO.getTag(),".",","));
        }

        model.addAttribute("question",questionDTO);
        model.addAttribute("comments",comments);
        model.addAttribute("relatedQuestions",relatedQuestions);
        return "question";
    }
}
