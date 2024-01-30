CREATE TABLE IF NOT EXISTS tb_months_user (
  id_months_user INT NOT NULL AUTO_INCREMENT,
  nm_months VARCHAR(45) NOT NULL,
  id_year_user INT NOT NULL,
  PRIMARY KEY (id_months_user),
  INDEX fk_tb_months_user_tb_year_user1_idx (id_year_user ASC) VISIBLE,
  CONSTRAINT fk_tb_months_user_tb_year_user1
    FOREIGN KEY (id_year_user)
    REFERENCES tb_year_user (id_year_user))

AUTO_INCREMENT = 1