package br.com.ServiceFinancial.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "tb_operation_type")
public class OperationTypeEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_operation_type")
    private Long operationTypeId;

    @Column(name="ds_operation_type")
    private String operationTypeDescription;

    @OneToMany
    @JoinColumn(name = "id_operation_type")
    private Set<OperationDetailsEntity> operationDetails;
}
