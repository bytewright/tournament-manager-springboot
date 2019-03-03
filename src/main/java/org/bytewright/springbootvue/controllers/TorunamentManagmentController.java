package org.bytewright.springbootvue.controllers;

import org.bytewright.springbootvue.jpa.entities.TournamentConfiguration;
import org.bytewright.springbootvue.jpa.repositories.TournamentConfigurationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TorunamentManagmentController {
  private static Logger LOGGER = LoggerFactory.getLogger(TorunamentManagmentController.class.getSimpleName());

  @Autowired
  private TournamentConfigurationRepository repository;


  @GetMapping("/{tournamentId}/admin")
  public String getTournamentManagePage(@PathVariable Long tournamentId, Model model) {
    TournamentConfiguration configuration = repository.getOne(tournamentId);
    LOGGER.info("Loading page for tournament: {}", configuration);
    model.addAttribute("config", configuration);
    return "manage/tournament";
  }

  @PostMapping("/tournaments/create/")
  public String createNewTournament(@ModelAttribute("newConfig") TournamentConfiguration configuration) {
    repository.saveAndFlush(configuration);
    return "index";
  }
}
