package com.example.adminsystem.controller;

import com.example.adminsystem.model.User;
import com.example.adminsystem.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping
    public String list(@RequestParam(value="page", defaultValue = "1") int page,
                       @RequestParam(value="username", required=false) String username,
                       @RequestParam(value="role", required=false) String role,
                       Model model){
        PageHelper.startPage(page, 5);
        List<User> users = userService.findByCondition(username, role);
        PageInfo<User> pageInfo = new PageInfo<>(users);

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("username", username);
        model.addAttribute("role", role);
        return "users";
    }

    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("user", new User());
        return "user_form";
    }

    @PostMapping("/add")
    public String addSubmit(User user){
        userService.create(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model){
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "user_form";
    }

    @PostMapping("/edit")
    public String editSubmit(User user){
        userService.update(user);
        return "redirect:/users";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model){
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "user_view";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        userService.delete(id);
        return "redirect:/users";
    }
}
