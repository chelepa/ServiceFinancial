package br.com.ServiceFinancial.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_operation_details")
public class OperationDetailsEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_operation_detail")
    private Long operationDetailId;

    @Column(name="date_operation_detail")
    private ZonedDateTime operationDetailDate;

    @Column(name="vl_operation_detail")
    private BigDecimal operationDetailDateValue;

    @ManyToOne
    @JoinColumn(name="id_operation_type")
    private OperationTypeEntity operationType;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "tb_account_operation_details",
            joinColumns = {@JoinColumn(name = "id_operation_detail", referencedColumnName = "id_operation_detail")},
            inverseJoinColumns = {@JoinColumn(name = "id_account_bank", referencedColumnName = "id_account_bank")}
    )
    private List<AccountBankEntity> accountBank = new ArrayList<>();
}
