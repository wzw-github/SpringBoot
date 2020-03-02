package com.wzw.springboot.controller;

import com.wzw.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

 /*   @RequestMapping({"/","/inedx.html"})
    public String index(){
        return "index";
    }*/

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(String user){
        if(user.equals("aaa")){
            throw new UserNotExistException();
        }
        return "Hello World";
    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>hello</h1>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        //classpath:/templates/success
        return "success";
    }
}
