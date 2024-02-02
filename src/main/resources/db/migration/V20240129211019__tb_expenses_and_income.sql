CREATE TABLE IF NOT EXISTS tb_expenses_and_income (
  id_expenses_and_income INT NOT NULL AUTO_INCREMENT,
  flag_expenses TINYINT NULL DEFAULT NULL,
  flag_revenues TINYINT NULL DEFAULT NULL,
  description VARCHAR(45) NOT NULL,
  value DECIMAL(10,2) NOT NULL,
  flag_paid_out TINYINT NULL DEFAULT NULL,
  payment_date VARCHAR(45) NULL DEFAULT NULL,
  id_sub_category INT NOT NULL,
  id_months_user INT NOT NULL,
  PRIMARY KEY (id_expenses_and_income),
  INDEX fk_tb_expenses_and_income_tb_sub_category1_idx (id_sub_category ASC) VISIBLE,
  INDEX fk_tb_expenses_and_income_tb_months_user1_idx (id_months_user ASC) VISIBLE,
  CONSTRAINT fk_tb_expenses_and_income_tb_months_user1
    FOREIGN KEY (id_months_user)
    REFERENCES tb_months_user (id_months_user),
  CONSTRAINT fk_tb_expenses_and_income_tb_sub_category1
    FOREIGN KEY (id_sub_category)
    REFERENCES tb_sub_category (id_sub_category))

AUTO_INCREMENT = 1