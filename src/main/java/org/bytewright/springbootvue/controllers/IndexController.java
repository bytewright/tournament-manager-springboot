package org.bytewright.springbootvue.controllers;

import org.bytewright.springbootvue.jpa.entities.Tournament;
import org.bytewright.springbootvue.jpa.repositories.TournamentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @Autowired
    private TournamentsRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        // this attribute will be available in the view index.html as a thymeleaf variable

        model.addAttribute("tournamentList", repository.findAll());
        model.addAttribute("newConfig", new Tournament());
        model.addAttribute("tournamentListUrl", "https://localhost:8443/tournaments/list/");

        return "index";
    }
}
