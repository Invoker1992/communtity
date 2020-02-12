package com.mrh.community;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Thanks For Watching！
 *
 * @author HuJiaqun
 * @date 2020/2/11 15:52
 **/
@Controller
public class HelloController {
//    @GetMapping("/hello")
//    public String hello(@RequestParam(name ="name")String name, Model model)
//    {
//        model.addAttribute("name",name);
//        return "hello";
//    }
    @GetMapping("/hello")
    public String hello(@RequestParam(name="name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    /*@GetMapping("/hello")
    public String hello( Model model) {
        model.addAttribute("name", "benben");
        return "hello";
    }*/
}
