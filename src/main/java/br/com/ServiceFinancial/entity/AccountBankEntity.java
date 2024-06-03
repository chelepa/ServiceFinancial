package br.com.ServiceFinancial.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_account_bank")
public class AccountBankEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_account_bank")
    private Long accountBankId;

    @Column(name="ds_account_bank")
    private String accountBankDescription;

    @Column(name="vl_account_bank")
    private BigDecimal accountBankValue;

    @ManyToOne
    @JoinColumn(name="id_users")
    private UserEntity user;

    @OneToMany(mappedBy = "accountBank")
    private List<OperationDetailsEntity> operationDetails = new ArrayList<>();

}
