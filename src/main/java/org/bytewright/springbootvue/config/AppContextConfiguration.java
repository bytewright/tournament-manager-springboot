package org.bytewright.springbootvue.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContextConfiguration {
  private static Logger LOGGER = LoggerFactory.getLogger(AppContextConfiguration.class.getSimpleName());

//  @Bean
//  public GTMConfiguration gtmConfiguration(TournamentsRepository repository) {
//    return new GTMConfiguration(repository);
//  }
}
