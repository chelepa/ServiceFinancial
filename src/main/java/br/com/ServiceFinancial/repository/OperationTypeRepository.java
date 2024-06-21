package br.com.ServiceFinancial.repository;

import br.com.ServiceFinancial.entity.OperationTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationTypeRepository extends JpaRepository<OperationTypeEntity, Long> {

}
