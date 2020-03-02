package com.wzw.springboot.controller;

import com.wzw.springboot.entity.User;
import com.wzw.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id")Integer id){
//        return userRepository.getOne(id);
        return userRepository.findById(id).get();
    }

    @GetMapping("/user")
    public User insertUser(User user){
        return userRepository.save(user);
    }

}
