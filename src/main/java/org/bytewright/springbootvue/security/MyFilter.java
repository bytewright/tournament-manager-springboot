package org.bytewright.springbootvue.security;

import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

@Component
public class MyFilter extends RolesAuthorizationFilter {
  private static Logger LOGGER = LoggerFactory.getLogger(MyFilter.class.getSimpleName());

  @Override
  public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {
    LOGGER.info("checking role");
    return super.isAccessAllowed(request, response, mappedValue);
  }
}
