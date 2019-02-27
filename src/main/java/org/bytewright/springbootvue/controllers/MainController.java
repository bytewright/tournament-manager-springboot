package org.bytewright.springbootvue.controllers;

import org.bytewright.springbootvue.config.GTMConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

  @Autowired
  private GTMConfiguration configuration;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index(Model model) {
    // this attribute will be available in the view index.html as a thymeleaf variable

    model.addAttribute("eventName", configuration.getTournamentName());
    // this just means render index.html from static/ area
    return "index";
  }
}
