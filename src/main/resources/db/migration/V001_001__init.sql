CREATE TABLE users
(
  id         bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  version    bigint(20) unsigned NOT NULL,
  created_at timestamp           NOT NULL,
  updated_at timestamp           NOT NULL,
  username   varchar(50)         NOT NULL,
  password   varchar(50)         NOT NULL,
  email      varchar(255)        NOT NULL,
  PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE tournaments
(
  id               bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  version          bigint(20) unsigned NOT NULL,
  created_at       timestamp           NOT NULL,
  updated_at       timestamp           NOT NULL,
  name             varchar(50)         NOT NULL,
  round_count      int          DEFAULT 5,
  location_address varchar(255) DEFAULT NULL,
  page_url_path    varchar(255) DEFAULT NULL,
  start_date       timestamp           NOT NULL,
  end_date         timestamp           NOT NULL,
  creator_id       bigint(20) unsigned NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT url_path_must_be_unique UNIQUE (page_url_path),
  FOREIGN KEY (creator_id) REFERENCES users (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE players
(
  id            bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  version       bigint(20) unsigned NOT NULL,
  created_at    timestamp           NOT NULL,
  updated_at    timestamp           NOT NULL,
  first_name    varchar(50)         NOT NULL,
  last_name     varchar(50)  DEFAULT NULL,
  email         varchar(255) DEFAULT NULL,
  phone         varchar(255) DEFAULT NULL,
  gender        varchar(10)  DEFAULT NULL,
  age           int unsigned DEFAULT 18,
  city          varchar(255) DEFAULT NULL,
  go_rank       varchar(5)   DEFAULT '25k',
  student       boolean      DEFAULT false,
  reduced_fee   boolean      DEFAULT false,
  club_member   boolean      DEFAULT false,
  tournament_id bigint(20) unsigned NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (tournament_id) REFERENCES tournaments (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
