package br.com.ServiceFinancial.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_sub_category")
public class SubCategoryEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sub_category")
    private Long id;

    @Column(name = "nm_sub_category")
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private CategoryEntity category;

    @OneToMany(mappedBy = "subCategory", cascade = CascadeType.ALL)
    private List<ExpensesAndIncomeEntity> expensesAndIncome = new ArrayList<>();
}
