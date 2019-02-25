package org.bytewright.springbootvue.controllers;

import org.bytewright.springbootvue.jpa.entities.Player;
import org.bytewright.springbootvue.jpa.repositories.PlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
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
        // this just means render index.html from static/ area
        return "manage/players";
    }

    @GetMapping("/manage/players/")
    public String edit(@RequestParam(value = "txtEmail", required = false) Long id, Model model) {

        Player player = playerRepository.getOne(id);
        model.addAttribute("isEdit", true);
        model.addAttribute("player", player);
        List<Player> players = playerRepository.findAll();
        model.addAttribute("playerList", players);
        // this just means render index.html from static/ area
        return "manage/players";
    }

    @PostMapping("/manage/players/add")
    public String add(HttpServletRequest request,
                      @RequestParam(value = "txtEmail", required = false) String name,
                      @RequestParam(value = "txtEmail", required = false) String surName,
                      @RequestParam(value = "txtEmail", required = false) Integer age,
                      @RequestParam(value = "txtEmail", required = false) String city,
                      @RequestParam(value = "txtEmail", required = false) String rank,
                      @RequestParam(value = "txtEmail", required = false) String sex,
                      @RequestParam(value = "txtEmail", required = false) Boolean student,
                      @RequestParam(value = "txtEmail", required = false) Boolean reduced,
                      @RequestParam(value = "txtEmail", required = false) Boolean clubMember) {
        Player player = new Player();
        player.setFirstName(name);
        player.setLastName(surName);
        player.setAge(age);
        player.setCity(city);
        player.setGoRank(rank);
        player.setSex(sex);
        player.setStudent(student);
        player.setReducedFee(reduced);
        player.setClubMember(clubMember);
        player = playerRepository.save(player);
        LOGGER.info("Adding player {} {} with id: {}", name, surName, player.getId());
        return "manage/players";
    }
}
