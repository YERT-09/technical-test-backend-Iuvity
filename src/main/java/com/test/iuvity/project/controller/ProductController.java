package com.test.iuvity.project.controller;

import com.test.iuvity.project.entity.Product;
import com.test.iuvity.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/findAll")
    public ResponseEntity findAll() {
        try{
            return ResponseEntity.ok(productService.findAll());
        }catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity createProduct(@RequestBody Product product) {
        try{
            System.out.println("Product: "+ product);
            return ResponseEntity.ok(productService.save(product));
        }catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity updateProduct(@RequestBody Product product) {
        try{
            System.out.println("Product: "+ product);
            return ResponseEntity.ok(productService.save(product));
        }catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable Integer id) {
        try{
            return ResponseEntity.ok(productService.deleteById(id));
        }catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
