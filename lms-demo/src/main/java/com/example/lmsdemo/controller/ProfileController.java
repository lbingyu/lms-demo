package com.example.lmsdemo.controller;

import com.example.lmsdemo.entity.User;
import com.example.lmsdemo.service.ProfileService;
import com.example.lmsdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private UserService userService;

    // 显示用户个人信息页面
    @GetMapping("/profile")
    public String showProfile(@RequestParam String username, Model model) {
        User user = userService.findByUsername(username);
        model.addAttribute("user", user);
        return "profile";
    }

    // 修改用户信息
    @PostMapping("/profile/update")
    public String updateProfile(@RequestParam String username,
                                @RequestParam String email,
                                @RequestParam String phone,
                                Model model) {
        profileService.updateUserInfo(username, email, phone);
        model.addAttribute("message", "资料更新成功");
        User updatedUser = userService.findByUsername(username);
        model.addAttribute("user", updatedUser);
        return "profile";
    }
}
