package com.test.iuvity.project.repository;

import com.test.iuvity.project.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
