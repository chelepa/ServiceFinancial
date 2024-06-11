package br.com.ServiceFinancial.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "tb_sub_category")
public class SubCategoryEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_sub_category")
    private Long subCategoryId;

    @Column(name="nm_sub_category")
    private String subCategoryName;

    @ManyToOne
    @JoinColumn(name="id_category")
    private CategoryEntity category;

}