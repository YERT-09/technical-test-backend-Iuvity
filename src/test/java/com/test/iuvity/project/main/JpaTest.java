package com.test.iuvity.project.main;

import com.test.iuvity.project.entity.Product;
import com.test.iuvity.project.repository.ProductRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.test.iuvity.project.DataTest.productDataJpaTest;
import static com.test.iuvity.project.DataTest.productDataTest;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class JpaTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void testFindAll(){
        List<Product> response = (List<Product>) productRepository.findAll();
        System.out.println(response);
        Assert.assertTrue(response.size()>0);
    }

    @Test
    void testSave(){
        Product response = productRepository.save(productDataJpaTest());
        System.out.println(response);
        Assert.assertNotNull(response);
    }

    @Test
    void testUpdate(){
        Product response = productRepository.save(productDataTest());
        Assert.assertEquals(response.getId(), productDataTest().getId());
    }

    @Test
    void testDelete(){
        List<Product> responseBefore = (List<Product>) productRepository.findAll();
        productRepository.deleteById(1);
        List<Product> responseAfter = (List<Product>) productRepository.findAll();
        Assert.assertTrue(responseBefore.size() > responseAfter.size());
    }
}
