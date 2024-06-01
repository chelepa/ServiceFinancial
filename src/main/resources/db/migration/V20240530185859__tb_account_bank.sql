CREATE TABLE IF NOT EXISTS tb_account_bank (
  id_account_bank INT NOT NULL AUTO_INCREMENT,
  ds_account_bank VARCHAR(45) NOT NULL,
  id_users INT NOT NULL,
  PRIMARY KEY (id_account_bank),
  INDEX fk_tb_account_bank_tb_user1_idx (id_users ASC) VISIBLE,
  CONSTRAINT fk_tb_account_bank_tb_user1 FOREIGN KEY (id_users) REFERENCES tb_user (id_users) ON DELETE NO ACTION ON UPDATE NO ACTION
)