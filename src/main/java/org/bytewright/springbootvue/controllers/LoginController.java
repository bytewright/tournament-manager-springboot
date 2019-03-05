package org.bytewright.springbootvue.controllers;

import org.bytewright.springbootvue.jpa.entities.User;
import org.bytewright.springbootvue.jpa.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users/login")
    public String login(@ModelAttribute("username") String username, @ModelAttribute("password") String password) {
        User user = userRepository.getUserByUsername(username);
        if (user == null) {
            user = userRepository.getUserByEmail(username);
        }
        if (user.getPassword().equals(password)) {
            LOGGER.info("user logged in: {}", user.getUsername());
        } else {
            LOGGER.info("user logged in with wrong pw: {}", user.getUsername());
        }
        return "index";
    }
}
