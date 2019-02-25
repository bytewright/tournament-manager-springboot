package org.bytewright.springbootvue.jpa.repositories;

import org.bytewright.springbootvue.jpa.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
