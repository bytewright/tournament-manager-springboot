CREATE TABLE tournament_configuration
(
  id               bigint(20)  NOT NULL AUTO_INCREMENT,
  name             varchar(50) NOT NULL,
  round_count      int          DEFAULT 5,
  location_address varchar(255) DEFAULT NULL,
  page_url         varchar(255) DEFAULT NULL,
  start_date       varchar(50) NOT NULL,
  end_date         varchar(50) NOT NULL,
  PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;