package org.bytewright.springbootvue.jpa.repositories;

import org.bytewright.springbootvue.jpa.entities.TournamentConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentConfigurationRepository extends JpaRepository<TournamentConfiguration, Long> {
}
