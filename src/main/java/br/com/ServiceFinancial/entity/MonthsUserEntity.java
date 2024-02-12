package br.com.ServiceFinancial.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "tb_months_user")
public class MonthsUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_months_user")
    private Long id;

    @Column(name = "nm_months")
    private String name;

    @Column(name = "vl_revenues")
    private BigDecimal valueRevenues;

    @Column(name = "vl_expenses")
    private BigDecimal valueExpenses;

    @ManyToOne
    @JoinColumn(name = "id_year_user")
    private YearUserEntity year;

    @OneToMany(mappedBy = "monthsUser", cascade = CascadeType.ALL)
    private List<ExpensesAndIncomeEntity> expensesAndIncome = new ArrayList<>();

    public MonthsUserEntity(String name, YearUserEntity year){
        this.setName(name);
        this.setValueExpenses(BigDecimal.valueOf(0));
        this.setValueRevenues(BigDecimal.valueOf(0));
        this.setYear(year);
        this.setExpensesAndIncome(null);
    }
}
