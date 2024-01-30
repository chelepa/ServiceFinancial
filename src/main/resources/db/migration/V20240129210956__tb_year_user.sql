CREATE TABLE IF NOT EXISTS tb_year_user (
  id_year_user INT NOT NULL AUTO_INCREMENT,
  year INT NOT NULL,
  id_users INT NOT NULL,
  PRIMARY KEY (id_year_user),
  INDEX fk_tb_year_user_tb_user1_idx (id_users ASC) VISIBLE,
  CONSTRAINT fk_tb_year_user_tb_user1
    FOREIGN KEY (id_users)
    REFERENCES tb_user (id_users))

AUTO_INCREMENT = 1