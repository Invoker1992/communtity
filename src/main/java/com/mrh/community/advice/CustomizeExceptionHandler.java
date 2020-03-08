package com.mrh.community.advice;

import com.alibaba.fastjson.JSON;
import com.mrh.community.dto.ResultDTO;
import com.mrh.community.exception.CustomizeErrorCode;
import com.mrh.community.exception.CustomizeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.JsonViewRequestBodyAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Thanks For Watching！
 *
 * @author HuJiaqun
 * @date 2020/3/2 11:04
 **/
@ControllerAdvice
public class CustomizeExceptionHandler {

    @ExceptionHandler(Exception.class)
    ModelAndView handle(Throwable ex, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String contentType = request.getContentType();
        if("application/json".equals(contentType))
        {
            ResultDTO resultDTO;
            //返回Json
            if(ex instanceof CustomizeException)
            {
                resultDTO = ResultDTO.errorOf((CustomizeException)ex);
            }
            else {
                resultDTO = ResultDTO.errorOf(CustomizeErrorCode.SYS_ERROR);
            }
            response.setContentType("application/json");
            response.setStatus(200);
            response.setCharacterEncoding("utf-8");
            PrintWriter writer = response.getWriter();
            writer.write(JSON.toJSONString(resultDTO)); //此处的write方法可能有问题
            writer.close();
            return null;
        }
        else
        {
            //错误页面跳转
            if(ex instanceof CustomizeException)
            {
                model.addAttribute("message",ex.getMessage());
            }
            else
            {
                model.addAttribute("message",CustomizeErrorCode.SYS_ERROR.getMessage());
            }
            return new ModelAndView("error");
        }

    }



}
