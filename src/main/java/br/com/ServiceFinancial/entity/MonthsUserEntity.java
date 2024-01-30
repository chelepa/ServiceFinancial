package br.com.ServiceFinancial.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_months_user")
public class MonthsUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_months_user")
    private Long id;

    @Column(name = "nm_months")
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_year_user")
    private YearUserEntity year;
}
