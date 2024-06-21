package br.com.ServiceFinancial.repository;

import br.com.ServiceFinancial.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
