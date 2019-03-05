package org.bytewright.springbootvue.controllers;

import org.bytewright.springbootvue.jpa.entities.Player;
import org.bytewright.springbootvue.jpa.repositories.PlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PlayerManagmentController {
  private static Logger LOGGER = LoggerFactory.getLogger(PlayerManagmentController.class.getSimpleName());

  @Autowired
  private PlayerRepository playerRepository;

  @GetMapping("/manage/players/")
  public String overview(Model model) {
    // this attribute will be available in the view index.html as a thymeleaf variable
    List<Player> players = playerRepository.findAll();
    model.addAttribute("playerList", players);
    model.addAttribute("isEdit", false);
    // this just means render index.html from static/ area
    return "manage/players";
  }


  @GetMapping("/manage/players/add")
  public String add() {
    // this attribute will be available in the view index.html as a thymeleaf variable
    Player player = new Player();
    player.setFirstName("abc");
    player.setLastName("dfg");
    player.setAge(22);
    player.setCity("Hamburg");
    player.setGoRank("10k");
    player.setGender("m");
    player.setStudent(true);
    playerRepository.save(player);
    return "manage/players";
  }
}
