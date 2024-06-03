CREATE TABLE IF NOT EXISTS tb_operation_details (
  id_operation_detail INT NOT NULL AUTO_INCREMENT,
  date_operation_detail DATETIME NOT NULL,
  vl_operation_detail DECIMAL(10,2) NOT NULL,
  id_operation_type INT NOT NULL,
  id_account_bank INT NOT NULL,
  PRIMARY KEY (id_operation_detail),
  INDEX fk_tb_operation_details_tb_operation_type_idx (id_operation_type ASC) VISIBLE,
  INDEX fk_tb_operation_details_tb_account_bank1_idx (id_account_bank ASC) VISIBLE,
  CONSTRAINT fk_tb_operation_details_tb_operation_type FOREIGN KEY (id_operation_type) REFERENCES tb_operation_type (id_operation_type),
  CONSTRAINT fk_tb_operation_details_tb_account_bank1 FOREIGN KEY (id_account_bank) REFERENCES tb_account_bank (id_account_bank) ON DELETE NO ACTION ON UPDATE NO ACTION
)