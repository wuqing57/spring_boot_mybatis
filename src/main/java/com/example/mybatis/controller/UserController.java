package com.example.mybatis.controller;

import com.example.mybatis.bean.User;
import com.example.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/all")
    public List<User> findAll() {
        return userService.findAll();
    }

    @RequestMapping(value = "/finduserid/{userId}")
    public User findUserById(@PathVariable("userId")  Long id) {
        return userService.findUserById(id);
    }

    @RequestMapping(value = "/add/{user_name},{pass_word}")
    public void save(User user,@PathVariable("user_name") String name,@PathVariable("pass_word") String password) {
        userService.insert(user,name,password);
    }

    @RequestMapping(value = "update")
    public void update (User user) {
        userService.update(user);
    }

    @RequestMapping(value = "delete/{userId}")
    public void delete (@PathVariable("userId") Long id) {
        userService.delete(id);
    }
}
