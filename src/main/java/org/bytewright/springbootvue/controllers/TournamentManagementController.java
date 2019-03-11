package org.bytewright.springbootvue.controllers;

import com.google.common.collect.ImmutableMap;
import org.bytewright.springbootvue.jpa.entities.AppUser;
import org.bytewright.springbootvue.jpa.entities.Tournament;
import org.bytewright.springbootvue.jpa.repositories.TournamentsRepository;
import org.bytewright.springbootvue.jpa.repositories.UserRepository;
import org.bytewright.springbootvue.model.TournamentDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        AppUser creator = getCurrentUser();
        LocalDateTime now = LocalDateTime.now();
        configuration.setCreatedDate(now);
        configuration.setModifiedDate(now);
        configuration.setCreator(creator);
//        configuration.setVersion(1L);
        repository.saveAndFlush(configuration);
        return "index";
    }


    @GetMapping("/tournaments/list/")
    @ResponseBody
    public Map<String, List<TournamentDto>> listTournaments() {
        List<TournamentDto> tournamentDtoList = repository.findAll().stream()
                .sorted(Comparator.comparing(Tournament::getStartDate))
                .map(TournamentDto::new)
                .collect(Collectors.toList());
        LOGGER.info("tournament list api call, retuning map with {} entries", tournamentDtoList.size());
        return ImmutableMap.of("tournaments", tournamentDtoList);
    }

    private AppUser getCurrentUser() {
        return userRepository.getUserByUsername("admin");
    }
}
