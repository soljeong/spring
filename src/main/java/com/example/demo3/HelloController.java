package com.example.demo3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("/ddd")
    @ResponseBody
    public String hello(){
        return "hello";
    }
    @GetMapping("/hello")
    @ResponseBody
    public String hello2(){
        return "hello2222";
    }
    
}
