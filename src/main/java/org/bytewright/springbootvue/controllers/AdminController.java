package org.bytewright.springbootvue.controllers;

import com.google.common.collect.ImmutableMap;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class AdminController {
  private static Logger LOGGER = LoggerFactory.getLogger(AdminController.class.getSimpleName());

  @RequiresRoles("admin")
  @GetMapping(value = "/admin/status")
  @ResponseBody
  public Map<String, Object> status() {
    LOGGER.info("Admin status called");
    return ImmutableMap.of("status", "all okay");
  }
}
