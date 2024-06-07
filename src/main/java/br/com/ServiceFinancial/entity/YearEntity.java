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
@Table(name = "tb_year")
public class YearEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id_year")
    private Long year;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "tb_months_year",
            joinColumns = @JoinColumn(name = "id_year", referencedColumnName = "id_year"),
            inverseJoinColumns = @JoinColumn(name = "id_months", referencedColumnName = "id_months")
    )
    private List<MonthsEntity> months = new ArrayList<>();

}
