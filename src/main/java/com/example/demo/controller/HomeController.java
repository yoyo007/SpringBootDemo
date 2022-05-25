package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.IUserRepository;
import com.example.demo.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    private UserService _userService;
    
    @Autowired
    public HomeController(UserService userService){
        _userService = userService;
    }
    @GetMapping("/")
    public String Index(Model model){
        model.addAttribute("Test", "TestText");
        long userCount = _userService.UserCount();
        model.addAttribute("UserCount", userCount);
        List<User> userList = _userService.UserList();
        model.addAttribute("UserList", userList);
        return "index";
    }
}
