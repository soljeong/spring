package com.example.demo3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping("/mode")
    @ResponseBody
    public String index() {
        System.out.println("index");
        return "index";
    }
    
}
