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
@Table(name = "tb_account")
public class AccountEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_account")
    private Long accountId;

    @Column(name="ds_account")
    private String accountDescription;

    @Column(name="vl_account")
    private BigDecimal accountValue;

    @Column(name="flag_account_pay")
    private boolean accountPay;

    @Column(name="dt_payment")
    private ZonedDateTime datePayment;

    @ManyToOne
    @JoinColumn(name="id_category")
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name="id_sub_category")
    private SubCategoryEntity subCategory;

    @ManyToOne
    @JoinColumn(name="id_users")
    @JoinColumn(name="id_year")
    @JoinColumn(name="id_months")
    private UserAccountEntity userAccount;
}
