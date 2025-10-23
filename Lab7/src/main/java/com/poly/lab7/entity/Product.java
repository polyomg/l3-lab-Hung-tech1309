// src/main/java/com/example/demo/entity/Product.java

package com.poly.lab7.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Name", length = 50, nullable = false)
    private String name;

    @Column(name = "Price", nullable = false)
    private Double price;

    @Temporal(TemporalType.DATE)
    @Column(name = "CreateDate", nullable = false)
    private Date createDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CategoryId", nullable = false)
    private Category category;

    @Column(name = "CategoryId", insertable = false, updatable = false)
    private String categoryId;
}