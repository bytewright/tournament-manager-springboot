package org.bytewright.springbootvue.controllers;

import com.google.common.collect.ImmutableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.Map;

@Controller
public class AdminController {
    private static Logger LOGGER = LoggerFactory.getLogger(AdminController.class.getSimpleName());

    @GetMapping("/admin/userdetails")
    @ResponseBody
    public Map<String, Object> currentUserDetails(Principal principal, Authentication authentication) {
        return ImmutableMap.of("name", principal.getName(), "auth", authentication);
    }

    @GetMapping(value = "/admin/status")
    @ResponseBody
    public Map<String, Object> status() {
        LOGGER.info("Admin status called");
        return ImmutableMap.of("status", "all okay");
    }
}
