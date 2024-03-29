DELIMITER $

CREATE TRIGGER Tgr_Sum_Values_Insert AFTER INSERT
ON tb_expenses_and_income
FOR EACH ROW
BEGIN
	IF(NEW.flag_expenses = 1) THEN
		UPDATE tb_months_user SET vl_expenses = vl_expenses + NEW.value WHERE id_months_user = NEW.id_months_user;
	ELSE
		UPDATE tb_months_user SET vl_revenues = vl_revenues + NEW.value WHERE id_months_user = NEW.id_months_user;
	END IF;
END$

CREATE TRIGGER Tgr_Sum_Values_Delete AFTER DELETE
ON tb_expenses_and_income
FOR EACH ROW
BEGIN
	IF(OLD.flag_expenses = 1) THEN
		UPDATE tb_months_user SET vl_expenses = vl_expenses - OLD.value WHERE id_months_user = OLD.id_months_user;
	ELSE
		UPDATE tb_months_user SET vl_revenues = vl_revenues - OLD.value WHERE id_months_user = OLD.id_months_user;
	END IF;
END$

CREATE TRIGGER Tgr_Sum_Values_Update AFTER UPDATE
ON tb_expenses_and_income
FOR EACH ROW
BEGIN
	IF(OLD.flag_expenses = 1) THEN
		UPDATE tb_months_user SET vl_expenses = vl_expenses - OLD.value WHERE id_months_user = OLD.id_months_user;
	ELSE
		UPDATE tb_months_user SET vl_revenues = vl_revenues - OLD.value WHERE id_months_user = OLD.id_months_user;
	END IF;

    IF(NEW.flag_expenses = 1) THEN
		UPDATE tb_months_user SET vl_expenses = vl_expenses + NEW.value WHERE id_months_user = NEW.id_months_user;
	ELSE
		UPDATE tb_months_user SET vl_revenues = vl_revenues + NEW.value WHERE id_months_user = NEW.id_months_user;
	END IF;
END$

DELIMITER ;