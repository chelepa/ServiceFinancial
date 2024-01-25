CREATE TABLE IF NOT EXISTS tb_months_year (
  id_year INT NOT NULL,
  id_months INT NOT NULL,
  PRIMARY KEY (id_year, id_months),
  INDEX fk_tb_months_year_tb_year1_idx (id_year ASC) VISIBLE,
  INDEX fk_tb_months_year_tb_months1_idx (id_months ASC) VISIBLE,
  CONSTRAINT fk_tb_months_year_tb_year1
    FOREIGN KEY (id_year)
    REFERENCES tb_year (id_year)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_tb_months_year_tb_months1
    FOREIGN KEY (id_months)
    REFERENCES tb_months (id_months)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)