package org.bytewright.springbootvue.controllers;

import org.apache.commons.codec.digest.DigestUtils;
import org.bytewright.springbootvue.jpa.entities.AppUser;
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
        AppUser appUser = userRepository.getUserByUsername(username);
        if (appUser == null) {
            appUser = userRepository.getUserByEmail(username);
        }
        String hexPassword = DigestUtils.sha512Hex(password);
        if (appUser.getPassword().equals(hexPassword)) {
            LOGGER.info("appUser logged in: {}", appUser.getUsername());
        } else {
            LOGGER.info("appUser logged in with wrong pw: {}", appUser.getUsername());
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
            AppUser appUser = new AppUser();
            appUser.setUsername(username);
            appUser.setPassword(DigestUtils.sha512Hex(password));
            appUser.setEmail(email);
            LocalDateTime now = LocalDateTime.now();
            appUser.setCreatedDate(now);
            appUser.setModifiedDate(now);
            userRepository.save(appUser);
            LOGGER.info("Created appUser: {}", appUser);
        }

        return "index";
    }
}
