CREATE TABLE IF NOT EXISTS tb_user_account (
  id_users INT NOT NULL,
  id_year INT NOT NULL,
  id_months INT NOT NULL,
  PRIMARY KEY (id_users, id_year, id_months),
  INDEX fk_tb_user_account_tb_user_idx (id_users ASC) VISIBLE,
  INDEX fk_tb_user_account_tb_year_idx (id_year ASC) VISIBLE,
  INDEX fk_tb_user_account_tb_months_idx (id_months ASC) VISIBLE,
  CONSTRAINT fk_tb_user_account_tb_user
    FOREIGN KEY (id_users)
    REFERENCES tb_user (id_users)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_tb_user_account_tb_year
    FOREIGN KEY (id_year)
    REFERENCES tb_year (id_year)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_tb_user_account_tb_months
    FOREIGN KEY (id_months)
    REFERENCES tb_months (id_months)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)