package br.com.ServiceFinancial.repository;

import br.com.ServiceFinancial.entity.OperationTypeEntity;
import br.com.ServiceFinancial.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationTypeRepository extends JpaRepository<OperationTypeEntity, Long> {

}
