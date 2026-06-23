package com.example.adminsystem.controller;

import com.example.adminsystem.model.User;
import com.example.adminsystem.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class AuthController {

    @Resource
    private UserService userService;

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam String username, @RequestParam String password, HttpSession session, Model model){
        User user = userService.login(username, password);
        if(user != null){
            session.setAttribute("currentUser", user);
            return "redirect:/users";
        } else {
            model.addAttribute("error","用户名或密码错误");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }
}
