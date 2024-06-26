CREATE TABLE IF NOT EXISTS tb_account (
  id_account INT NOT NULL AUTO_INCREMENT,
  ds_account VARCHAR(45) NOT NULL,
  vl_account DECIMAL(10,2) NOT NULL,
  flag_account_pay TINYINT NOT NULL DEFAULT '0',
  dt_payment DATETIME NULL DEFAULT NULL,
  id_category INT NOT NULL,
  id_sub_category INT NOT NULL,
  id_users INT NOT NULL,
  id_months INT NOT NULL,
  id_year INT NOT NULL,
  PRIMARY KEY (id_account),
  INDEX fk_tb_account_aux_tb_category_idx (id_category ASC) VISIBLE,
  INDEX fk_tb_account_aux_tb_sub_category_idx (id_sub_category ASC) VISIBLE,
  INDEX fk_tb_account_tb_user1_idx (id_users ASC) VISIBLE,
  INDEX fk_tb_account_tb_months1_idx (id_months ASC) VISIBLE,
  INDEX fk_tb_account_tb_year1_idx (id_year ASC) VISIBLE,
  CONSTRAINT fk_tb_account_aux_tb_category
    FOREIGN KEY (id_category)
    REFERENCES tb_category (id_category),
  CONSTRAINT fk_tb_account_aux_tb_sub_category
    FOREIGN KEY (id_sub_category)
    REFERENCES tb_sub_category (id_sub_category),
  CONSTRAINT fk_tb_account_tb_user1
    FOREIGN KEY (id_users)
    REFERENCES tb_user (id_users)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_tb_account_tb_months1
    FOREIGN KEY (id_months)
    REFERENCES tb_months (id_months)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_tb_account_tb_year1
    FOREIGN KEY (id_year)
    REFERENCES tb_year (id_year)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)