package br.com.devcave.product.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Category {

    @Id
    @Column(name = "id_category", nullable = false)
    private Long id;

    @Column(name="nam_category", nullable=false)
    private String name;
}
