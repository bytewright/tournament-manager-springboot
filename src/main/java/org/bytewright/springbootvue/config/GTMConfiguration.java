package org.bytewright.springbootvue.config;

import org.bytewright.springbootvue.jpa.entities.TournamentConfiguration;
import org.bytewright.springbootvue.jpa.repositories.TournamentConfigurationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class GTMConfiguration {
  private static Logger LOGGER = LoggerFactory.getLogger(GTMConfiguration.class.getSimpleName());
  private final TournamentConfiguration dbConfig;

  @Autowired
  public GTMConfiguration(TournamentConfigurationRepository repository) {
    List<TournamentConfiguration> configurationList = repository.findAll();
    if (configurationList.size() > 1) {
      throw new IllegalStateException("More than one config found");
    }
    if (configurationList.isEmpty()) {
      LOGGER.warn("No Tournament config found in DB, creating new");
      TournamentConfiguration configuration = new TournamentConfiguration();
      this.dbConfig = repository.saveAndFlush(configuration);
    } else {
      this.dbConfig = configurationList.get(0);
    }
  }

  public String getTournamentName() {
    return dbConfig.getTournamentName();
  }

  public Integer getTournamentRoundCount() {
    return dbConfig.getTournamentRoundCount();
  }

  public String getLocationAddress() {
    return dbConfig.getLocationAddress();
  }

  public LocalDateTime getTournamentStart() {
    return dbConfig.getTournamentStart();
  }

  public LocalDateTime getTournamentEnd() {
    return dbConfig.getTournamentEnd();
  }
}
