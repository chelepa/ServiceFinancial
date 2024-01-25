CREATE TABLE IF NOT EXISTS tb_expenses_and_income (
  id_expenses_and_income INT NOT NULL AUTO_INCREMENT,
  flag_expenses TINYINT NOT NULL,
  flag_revenues TINYINT NOT NULL,
  description VARCHAR(45) NOT NULL,
  value DECIMAL NOT NULL,
  flag_paid_out VARCHAR(45) NULL,
  payment_date VARCHAR(45) NULL,
  id_sub_category INT NOT NULL,
  id_year INT NOT NULL,
  id_months INT NOT NULL,
  PRIMARY KEY (id_expenses_and_income),
  INDEX fk_tb_expenses_and_income_tb_sub_category1_idx (id_sub_category ASC) VISIBLE,
  INDEX fk_tb_expenses_and_income_tb_months_year1_idx (id_year ASC, id_months ASC) VISIBLE,
  CONSTRAINT fk_tb_expenses_and_income_tb_sub_category1
    FOREIGN KEY (id_sub_category)
    REFERENCES tb_sub_category (id_sub_category)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_tb_expenses_and_income_tb_months_year1
    FOREIGN KEY (id_year , id_months)
    REFERENCES tb_months_year (id_year , id_months)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)