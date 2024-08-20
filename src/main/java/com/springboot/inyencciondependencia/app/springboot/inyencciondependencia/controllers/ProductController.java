package com.springboot.inyencciondependencia.app.springboot.inyencciondependencia.controllers;


import com.springboot.inyencciondependencia.app.springboot.inyencciondependencia.models.Product;
import com.springboot.inyencciondependencia.app.springboot.inyencciondependencia.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    private ProductService productService = new ProductService();

    @GetMapping()
    public List<Product> list(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Integer id){
        return productService.findById(id);
    }
}
