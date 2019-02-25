CREATE TABLE tournament_configuration
(
  id                     bigint(20)  NOT NULL AUTO_INCREMENT,
  tournament_name        varchar(50) NOT NULL,
  tournament_round_count int          DEFAULT 5,
  location_address       varchar(255) DEFAULT NULL,
  tournament_start       datetime    NOT NULL,
  tournament_end         datetime    NOT NULL,
  PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;