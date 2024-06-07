package br.com.ServiceFinancial.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_months")
public class MonthsEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id_months")
    private Long monthsId;

    @Column(name="nm_months")
    private String month;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "tb_months_year",
            joinColumns = @JoinColumn(name = "id_months", referencedColumnName = "id_months"),
            inverseJoinColumns = @JoinColumn(name = "id_year", referencedColumnName = "id_year")
    )
    private List<YearEntity> years = new ArrayList<>();
}
