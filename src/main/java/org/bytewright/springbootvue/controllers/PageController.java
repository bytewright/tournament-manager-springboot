package org.bytewright.springbootvue.controllers;

import org.bytewright.springbootvue.jpa.entities.TournamentConfiguration;
import org.bytewright.springbootvue.jpa.repositories.TournamentConfigurationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageController {
  private static Logger LOGGER = LoggerFactory.getLogger(PageController.class.getSimpleName());

  @Autowired
  private TournamentConfigurationRepository repository;

  @GetMapping("/{tournamentId}/")
  public String getTournamentPage(@PathVariable Long tournamentId, Model model) {

    TournamentConfiguration configuration = repository.getOne(tournamentId);
    LOGGER.info("Loading page for tournament: {}", configuration);
    model.addAttribute("config", configuration);
    return "tournamentPage";
  }
}
