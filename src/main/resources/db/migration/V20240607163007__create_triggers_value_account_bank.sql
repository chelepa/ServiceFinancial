DELIMITER $
CREATE TRIGGER tgr_update_value_account_bank_after_insert AFTER INSERT
ON tb_operation_details
FOR EACH ROW
BEGIN
	IF(NEW.id_operation_type = 1) THEN
		UPDATE tb_account_bank SET vl_account_bank = vl_account_bank + NEW.vl_operation_detail WHERE id_account_bank = NEW.id_account_bank;
	ELSE
		UPDATE tb_account_bank SET vl_account_bank = vl_account_bank - NEW.vl_operation_detail WHERE id_account_bank = NEW.id_account_bank;
	END IF;
END$
DELIMITER $
CREATE TRIGGER tgr_update_value_account_bank_after_update AFTER UPDATE
ON tb_operation_details
FOR EACH ROW
BEGIN
	IF(OLD.id_operation_type = 1) THEN
		UPDATE tb_account_bank SET vl_account_bank = vl_account_bank - OLD.vl_operation_detail WHERE id_account_bank = OLD.id_account_bank;
	ELSE
		UPDATE tb_account_bank SET vl_account_bank = vl_account_bank + OLD.vl_operation_detail WHERE id_account_bank = OLD.id_account_bank;
	END IF;

	IF(NEW.id_operation_type = 1) THEN
		UPDATE tb_account_bank SET vl_account_bank = vl_account_bank + NEW.vl_operation_detail WHERE id_account_bank = NEW.id_account_bank;
	ELSE
		UPDATE tb_account_bank SET vl_account_bank = vl_account_bank - NEW.vl_operation_detail WHERE id_account_bank = NEW.id_account_bank;
	END IF;
END$
DELIMITER $
CREATE TRIGGER tgr_update_value_account_bank_after_deleted AFTER DELETE
ON tb_operation_details
FOR EACH ROW
BEGIN
	IF(OLD.id_operation_type = 1) THEN
		UPDATE tb_account_bank SET vl_account_bank = vl_account_bank - OLD.vl_operation_detail WHERE id_account_bank = OLD.id_account_bank;
	ELSE
		UPDATE tb_account_bank SET vl_account_bank = vl_account_bank + OLD.vl_operation_detail WHERE id_account_bank = OLD.id_account_bank;
	END IF;
END$