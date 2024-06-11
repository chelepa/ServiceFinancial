package br.com.ServiceFinancial.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_category")
public class CategoryEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_category")
    private Long categoryId;

    @Column(name="nm_category")
    private String categoryName;

    @ManyToOne
    @JoinColumn(name="id_users")
    private UserEntity user;

    @OneToMany(mappedBy = "category", cascade = {CascadeType.ALL})
    private List<SubCategoryEntity> subCategory = new ArrayList<>();
}
