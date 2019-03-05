package org.bytewright.springbootvue.jpa.repositories;

import org.bytewright.springbootvue.jpa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByUsername(String username);

    User getUserByEmail(String email);

    Boolean existsByEmail(String email);

    Boolean existsByUsername(String username);
}
