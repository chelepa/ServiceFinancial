package br.com.ServiceFinancial.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_year_user")
public class YearUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_year_user")
    private Long id;

    @Column(name = "year")
    private Long year;

    @ManyToOne
    @JoinColumn(name = "id_users")
    private UserEntity user;

    @OneToMany(mappedBy = "year", cascade = CascadeType.ALL)
    private List<MonthsUserEntity> months = new ArrayList<>();
}
