package org.bytewright.springbootvue.controllers;

import org.apache.commons.codec.digest.DigestUtils;
import org.bytewright.springbootvue.jpa.entities.User;
import org.bytewright.springbootvue.jpa.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class UsersController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsersController.class);
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users/login")
    public String login(@ModelAttribute("username") String username, @ModelAttribute("password") String password) {
        User user = userRepository.getUserByUsername(username);
        if (user == null) {
            user = userRepository.getUserByEmail(username);
        }
        String hexPassword = DigestUtils.sha512Hex(password);
        if (user.getPassword().equals(hexPassword)) {
            LOGGER.info("user logged in: {}", user.getUsername());
        } else {
            LOGGER.info("user logged in with wrong pw: {}", user.getUsername());
        }
        return "index";
    }

    @PostMapping("/users/register")
    public String register(@ModelAttribute("username") String username,
                           @ModelAttribute("password") String password,
                           @ModelAttribute("email") String email) {
        if (userRepository.existsByEmail(email)) {
            LOGGER.warn("Username {} or email {} has already been taken");
        } else if (userRepository.existsByUsername(username)) {
            LOGGER.warn("Username {} or email {} has already been taken");
        } else {
            User user = new User();
            user.setUsername(username);
            user.setPassword(DigestUtils.sha512Hex(password));
            user.setEmail(email);
            LocalDateTime now = LocalDateTime.now();
            user.setCreatedDate(now);
            user.setModifiedDate(now);
            userRepository.save(user);
            LOGGER.info("Created user: {}", user);
        }

        return "index";
    }
}
