DELIMITER $
CREATE TRIGGER Tgr_update_Value_Account_bank_After_deleted AFTER DELETE
ON tb_operation_details
FOR EACH ROW
BEGIN
	IF(OLD.id_operation_type = 1) THEN
		UPDATE tb_account_bank SET vl_account_bank = vl_account_bank - OLD.vl_operation_detail WHERE id_account_bank = OLD.id_account_bank;
	ELSE
		UPDATE tb_account_bank SET vl_account_bank = vl_account_bank + OLD.vl_operation_detail WHERE id_account_bank = OLD.id_account_bank;
	END IF;
END$