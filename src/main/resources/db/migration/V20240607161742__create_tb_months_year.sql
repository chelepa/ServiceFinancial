CREATE TABLE IF NOT EXISTS tb_months_year (
  id_months INT NOT NULL,
  id_year INT NOT NULL,
  PRIMARY KEY (id_months, id_year),
  INDEX fk_tb_months_has_tb_year_tb_year_idx (id_year ASC) VISIBLE,
  INDEX fk_tb_months_has_tb_year_tb_months_idx (id_months ASC) VISIBLE,
  CONSTRAINT fk_tb_months_has_tb_year_tb_months
    FOREIGN KEY (id_months)
    REFERENCES tb_months (id_months),
  CONSTRAINT fk_tb_months_has_tb_year_tb_year
    FOREIGN KEY (id_year)
    REFERENCES tb_year (id_year))