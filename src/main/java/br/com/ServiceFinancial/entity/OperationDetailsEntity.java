package br.com.ServiceFinancial.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

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

    @ManyToOne
    @JoinColumn(name="id_account_bank")
    private AccountBankEntity accountBank;
}
