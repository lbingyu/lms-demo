package com.example.lmsdemo.service.impl;

import com.example.lmsdemo.entity.User;
import com.example.lmsdemo.repository.UserRepository;
import com.example.lmsdemo.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void updateUserInfo(String username, String email, String phone) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            user.setEmail(email);
            user.setPhone(phone);
            userRepository.save(user);
        }
    }
}
