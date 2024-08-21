package com.springboot.inyencciondependencia.app.springboot.inyencciondependencia.repositories;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.inyencciondependencia.app.springboot.inyencciondependencia.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;


public class ProductJsonRepository implements IProductRepository{

    private List<Product> list;

    public ProductJsonRepository() throws IOException {
        Resource resource = new ClassPathResource("json/product.json");
        ObjectMapper objectMapper = new ObjectMapper();
        list = List.of(objectMapper.readValue(resource.getFile(), Product[].class));
    }

    @Override
    public List<Product> findAll() {
        return list;
    }

    @Override
    public Product findById(Integer id) {
        return list.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .get();
    }
}
