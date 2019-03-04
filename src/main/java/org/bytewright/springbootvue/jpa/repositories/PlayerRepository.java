package org.bytewright.springbootvue.jpa.repositories;

import org.bytewright.springbootvue.jpa.entities.Player;
import org.bytewright.springbootvue.jpa.entities.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> getPlayersByTournament(Tournament tournament);

    Player getPlayerByFirstNameAndLastName(String firstName, String lastName);
}
