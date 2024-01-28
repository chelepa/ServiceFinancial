package br.com.ServiceFinancial.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_months")
public class MonthsEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_months")
    private Long id;

    @Column(name = "nm_months")
    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "tb_months_year",
            joinColumns = @JoinColumn(name = "id_months", referencedColumnName = "id_months"),
            inverseJoinColumns = @JoinColumn(name = "id_year", referencedColumnName = "id_year")
    )
    private List<YearEntity> year = new ArrayList<>();
}
