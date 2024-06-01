package br.com.ServiceFinancial.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
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

    @ManyToOne
    @JoinColumn(name="id_users")
    private UserEntity user;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "tb_account_operation_details",
            joinColumns = {@JoinColumn(name = "id_account_bank", referencedColumnName = "id_account_bank")},
            inverseJoinColumns = {@JoinColumn(name = "id_operation_detail", referencedColumnName = "id_operation_detail")}
    )
    private List<OperationDetailsEntity> operationDetails = new ArrayList<>();

}
