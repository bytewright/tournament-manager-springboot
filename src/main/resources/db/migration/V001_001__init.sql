CREATE TABLE players
(
  id          bigint(20)  NOT NULL AUTO_INCREMENT,
  first_name  varchar(50) NOT NULL,
  last_name   varchar(50)  DEFAULT NULL,
  sex         varchar(10)  DEFAULT NULL,
  age         int          DEFAULT 18,
  city        varchar(255) DEFAULT NULL,
  go_rank     varchar(5)  NOT NULL,
  student     boolean      DEFAULT false,
  reduced_fee boolean      DEFAULT false,
  club_member boolean      DEFAULT false,
  PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;