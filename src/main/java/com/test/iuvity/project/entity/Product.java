package com.test.iuvity.project.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigInteger;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    @NotEmpty
    private String productName;

    @Column(name = "code", unique = true)
    @NotNull
    @Min(value = 0)
    private BigInteger productCode;

    @Column(name = "price")
    @NotNull
    @Min(value = 0)
    private Double productPrice;

    @Column(name = "quantity")
    @NotNull
    @Min(value = 0)
    private Integer productQuantity;

}
