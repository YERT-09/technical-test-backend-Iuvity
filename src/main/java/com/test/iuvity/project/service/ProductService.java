package com.test.iuvity.project.service;

import com.test.iuvity.project.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();
    Product save(Product product);
    List<Product> deleteById(Integer id);
}
