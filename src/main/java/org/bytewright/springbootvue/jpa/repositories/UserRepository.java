package org.bytewright.springbootvue.jpa.repositories;

import org.bytewright.springbootvue.jpa.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    AppUser getUserByEmail(String email);

    AppUser getUserByUsername(String username);

    Boolean existsByEmail(String email);

    Boolean existsByUsername(String username);
}
