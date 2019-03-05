package org.bytewright.springbootvue.controllers;

import org.bytewright.springbootvue.jpa.entities.Tournament;
import org.bytewright.springbootvue.jpa.entities.User;
import org.bytewright.springbootvue.jpa.repositories.TournamentsRepository;
import org.bytewright.springbootvue.jpa.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class TournamentManagementController {
  private static Logger LOGGER = LoggerFactory.getLogger(TournamentManagementController.class.getSimpleName());

  @Autowired
  private TournamentsRepository repository;

  @Autowired
  private UserRepository userRepository;

  @GetMapping("/{tournamentName}/admin")
  public String getTournamentManagePage(@PathVariable String tournamentName, Model model) {
    Tournament configuration = repository.getByPageUrlPath(tournamentName);
    LOGGER.info("Loading admin page for tournament: {}", configuration);
    model.addAttribute("config", configuration);
    return "manage/tournament";
  }

  @PostMapping("/tournaments/create/")
  public String createNewTournament(@ModelAttribute("newConfig") Tournament configuration) {
    User creator = getCurrentUser();
    LocalDateTime now = LocalDateTime.now();
    configuration.setCreatedDate(now);
    configuration.setModifiedDate(now);
    configuration.setCreator(creator);
//        configuration.setVersion(1L);
    repository.saveAndFlush(configuration);
    return "index";
  }

  private User getCurrentUser() {
    return userRepository.getUserByUsername("admin");
  }
}
