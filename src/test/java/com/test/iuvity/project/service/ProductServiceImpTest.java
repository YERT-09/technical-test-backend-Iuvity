package com.test.iuvity.project.service;

import com.test.iuvity.project.repository.ProductRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.test.iuvity.project.DataTest.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImpTest {

    @Mock
    ProductRepository productRepository;
    @InjectMocks
    ProductServiceImp productService;

    @Test
    void findAll() {
        when(productRepository.findAll()).thenReturn(listProductsDataTest());
        Assert.assertEquals(productService.findAll().size(), 2);
    }

    @Test
    void save() {
        when(productRepository.save(Mockito.any())).thenReturn(productDataTest());
        Assert.assertEquals(productService.save(productDataTest()).getProductName(),
                "Mug IronMan");
    }

    @Test
    void deleteById() {
        when(productRepository.findAll()).thenReturn(listProductsDataTest());
        Assert.assertEquals(productService.deleteById(1).size(), 2);
    }
}