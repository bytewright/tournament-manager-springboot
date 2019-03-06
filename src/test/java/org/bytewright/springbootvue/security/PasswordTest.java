package org.bytewright.springbootvue.security;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;


class PasswordTest {
    @Test
    void passwordEncoder() {
        PasswordEncoder encoder = WebSecurityConfig.passwordEncoder();
        String result = encoder.encode("admin");
        Assertions.assertTrue(encoder.matches("myPassword", result));
    }
}