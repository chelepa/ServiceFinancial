CREATE TABLE IF NOT EXISTS tb_user_year (
  tb_user_id_users INT NOT NULL,
  tb_year_year INT NOT NULL,
  PRIMARY KEY (tb_user_id_users, tb_year_year),
  INDEX fk_tb_user_has_tb_year_tb_year_idx (tb_year_year ASC) VISIBLE,
  INDEX fk_tb_user_has_tb_year_tb_user_idx (tb_user_id_users ASC) VISIBLE,
  CONSTRAINT fk_tb_user_has_tb_year_tb_user FOREIGN KEY (tb_user_id_users) REFERENCES tb_user (id_users),
  CONSTRAINT fk_tb_user_has_tb_year_tb_year FOREIGN KEY (tb_year_year) REFERENCES tb_year (id_year)
)