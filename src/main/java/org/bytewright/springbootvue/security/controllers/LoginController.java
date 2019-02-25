package org.bytewright.springbootvue.security.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
  private static Logger LOGGER = LoggerFactory.getLogger(LoginController.class.getSimpleName());

  @RequestMapping("/login.html")
  public String loginTemplate() {

    return "login";
  }
}
