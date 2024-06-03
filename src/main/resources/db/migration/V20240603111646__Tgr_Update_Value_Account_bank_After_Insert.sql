DELIMITER $
CREATE TRIGGER Tgr_Update_Value_Account_bank_After_Insert AFTER INSERT
ON tb_operation_details
FOR EACH ROW
BEGIN
	IF(NEW.id_operation_type = 1) THEN
		UPDATE tb_account_bank SET vl_account_bank = vl_account_bank + NEW.vl_operation_detail WHERE id_account_bank = NEW.id_account_bank;
	ELSE
		UPDATE tb_account_bank SET vl_account_bank = vl_account_bank - NEW.vl_operation_detail WHERE id_account_bank = NEW.id_account_bank;
	END IF;
END$