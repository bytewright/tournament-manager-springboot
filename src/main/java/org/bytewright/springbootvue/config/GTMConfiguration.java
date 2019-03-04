package org.bytewright.springbootvue.config;

import org.bytewright.springbootvue.jpa.entities.Tournament;
import org.bytewright.springbootvue.jpa.repositories.TournamentsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GTMConfiguration {
  private static Logger LOGGER = LoggerFactory.getLogger(GTMConfiguration.class.getSimpleName());
  private final Tournament dbConfig;

  @Autowired
  public GTMConfiguration(TournamentsRepository repository) {
    List<Tournament> configurationList = repository.findAll();
//    if (configurationList.size() > 1) {
//      throw new IllegalStateException("More than one config found");
//    }
    if (configurationList.isEmpty()) {
      LOGGER.warn("No Tournament config found in DB, creating new");
//      Tournament configuration = new Tournament();
      this.dbConfig = null;
    } else {
      this.dbConfig = configurationList.get(0);
    }
  }

  public String getTournamentName() {
    return dbConfig.getName();
  }

  public Integer getTournamentRoundCount() {
    return dbConfig.getRoundCount();
  }

  public String getLocationAddress() {
    return dbConfig.getLocationAddress();
  }

  public String getTournamentStart() {
    return dbConfig.getStartDate();
  }

  public String getTournamentEnd() {
    return dbConfig.getEndDate();
  }
}
