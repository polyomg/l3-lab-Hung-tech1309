// src/main/java/com/example/demo/entity/Category.java

package com.poly.lab7.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Entity
@Table(name = "Categories")
 @Getter
 @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category implements Serializable {

    @Id
    @Column(name = "Id", length = 4)
    private String id;

    @Column(name = "Name", length = 50, nullable = false)
    private String name;
}