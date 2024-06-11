package br.com.ServiceFinancial.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "tb_user_account")
public class UserAccountEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @ManyToOne
    @JoinColumn(name="id_users")
    private UserEntity user;

    @Id
    @ManyToOne
    @JoinColumn(name="id_year")
    private YearEntity year;

    @Id
    @ManyToOne
    @JoinColumn(name="id_months")
    private MonthsEntity months;
}
