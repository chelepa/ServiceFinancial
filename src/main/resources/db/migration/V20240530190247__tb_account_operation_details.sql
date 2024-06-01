CREATE TABLE IF NOT EXISTS tb_account_operation_details (
  id_account_bank INT NOT NULL,
  id_operation_detail INT NOT NULL,
  PRIMARY KEY (id_account_bank, id_operation_detail),
  INDEX fk_tb_account_bank_has_tb_operation_details_tb_operation_de_idx (id_operation_detail ASC) VISIBLE,
  INDEX fk_tb_account_bank_has_tb_operation_details_tb_account_bank_idx (id_account_bank ASC) VISIBLE,
  CONSTRAINT fk_tb_account_bank_has_tb_operation_details_tb_account_bank FOREIGN KEY (id_account_bank) REFERENCES tb_account_bank (id_account_bank) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT fk_tb_account_bank_has_tb_operation_details_tb_operation_date FOREIGN KEY (id_operation_detail) REFERENCES tb_operation_details (id_operation_detail) ON DELETE NO ACTION ON UPDATE NO ACTION
)