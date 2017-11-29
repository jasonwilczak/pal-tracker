CREATE TABLE time_entries (
  id         BIGINT(20) NOT NULL AUTO_INCREMENT,
  project_id BIGINT(20),
  user_id    BIGINT(20),
  date       DATE,
  hours      INT,

  PRIMARY KEY (id)
)
  ENGINE = innodb
<<<<<<< HEAD
  DEFAULT CHARSET = utf8;
=======
  DEFAULT CHARSET = utf8;
>>>>>>> b28134d5e6788ac6ef8ba5e82a8b4b7fbdfa62e7
