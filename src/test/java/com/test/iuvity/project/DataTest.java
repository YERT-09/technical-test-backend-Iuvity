package com.test.iuvity.project;

import com.test.iuvity.project.entity.Product;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class DataTest {
    public static List<Product> listProductsDataTest(){

        return Arrays.asList(Product.builder()
                .id(1)
                .productName("Mug IronMan")
                .productCode(new BigInteger("77270000001"))
                .productPrice(12.2)
                .productQuantity(100).build(),

                Product.builder()
                        .id(2)
                        .productName("Mug SpiderMan")
                        .productCode(new BigInteger("77270000002"))
                        .productPrice(12.2)
                        .productQuantity(100).build());
    }

    public static Product productDataTest(){
        return Product.builder()
                .id(1)
                .productName("Mug IronMan")
                .productCode(new BigInteger("77270000001"))
                .productPrice(12.2)
                .productQuantity(100).build();
    }

    public static Product productDataJpaTest(){
        return Product.builder()
                .productName("Comic IronMan")
                .productCode(new BigInteger("77270000010"))
                .productPrice(5.2)
                .productQuantity(100).build();
    }
}
