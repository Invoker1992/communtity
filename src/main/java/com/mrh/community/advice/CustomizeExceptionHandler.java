package com.mrh.community.advice;

import com.mrh.community.exception.CustomizeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Thanks For Watching！
 *
 * @author HuJiaqun
 * @date 2020/3/2 11:04
 **/
@ControllerAdvice
public class CustomizeExceptionHandler {


    @ExceptionHandler(Exception.class)
    ModelAndView handle(Throwable ex, Model model) {
        if(ex instanceof CustomizeException)
        {
            model.addAttribute("message",ex.getMessage());
        }
        else
        {
            model.addAttribute("message","服务器冒烟了，请稍后再试");
        }
        return new ModelAndView("error");
    }



}
