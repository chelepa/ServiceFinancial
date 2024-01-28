CREATE TABLE IF NOT EXISTS tb_months_year_user (
  id_months_year INT NOT NULL,
  id_users INT NOT NULL,
  PRIMARY KEY (id_months_year, id_users),
  INDEX fk_tb_months_year_has_tb_user_tb_user1_idx (id_users ASC) VISIBLE,
  INDEX fk_tb_months_year_has_tb_user_tb_months_year1_idx (id_months_year ASC) VISIBLE,
  CONSTRAINT fk_tb_months_year_has_tb_user_tb_months_year1
    FOREIGN KEY (id_months_year)
    REFERENCES tb_months_year (id_months_year)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_tb_months_year_has_tb_user_tb_user1
    FOREIGN KEY (id_users)
    REFERENCES tb_user (id_users)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)