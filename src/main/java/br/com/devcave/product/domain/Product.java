package br.com.devcave.product.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class Product {

    @GeneratedValue
    @Column(name = "id_product", nullable = false)
    @Id
    private Long id;

    @Column(name="nam_product", nullable = false)
    private String name;

    @Column(name="val_product", nullable = false)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;
}
