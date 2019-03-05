package org.bytewright.springbootvue.jpa.repositories;

import org.bytewright.springbootvue.jpa.entities.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentsRepository extends JpaRepository<Tournament, Long> {
    Tournament getByPageUrlPath(String path);
}
