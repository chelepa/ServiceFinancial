CREATE TABLE IF NOT EXISTS tb_category (
  id_category INT NOT NULL AUTO_INCREMENT,
  nm_category VARCHAR(45) NOT NULL,
  id_users INT NOT NULL,
  PRIMARY KEY (id_category),
  INDEX fk_tb_category_tb_user_idx (id_users ASC) VISIBLE,
  CONSTRAINT fk_tb_category_tb_user FOREIGN KEY (id_users) REFERENCES tb_user (id_users)
)