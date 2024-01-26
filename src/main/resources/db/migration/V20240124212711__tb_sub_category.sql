CREATE TABLE IF NOT EXISTS tb_sub_category (
  id_sub_category INT NOT NULL AUTO_INCREMENT,
  nm_sub_category VARCHAR(45) NOT NULL,
  id_category INT NOT NULL,
  PRIMARY KEY (id_sub_category),
  INDEX fk_tb_sub_category_tb_category_idx (id_category ASC) VISIBLE,
  CONSTRAINT fk_tb_sub_category_tb_category
    FOREIGN KEY (id_category)
    REFERENCES tb_category (id_category)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)