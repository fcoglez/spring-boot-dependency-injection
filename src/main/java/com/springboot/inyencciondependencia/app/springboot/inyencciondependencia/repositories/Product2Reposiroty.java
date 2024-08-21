package com.springboot.inyencciondependencia.app.springboot.inyencciondependencia.repositories;

import com.springboot.inyencciondependencia.app.springboot.inyencciondependencia.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;


@Repository
public class Product2Reposiroty implements IProductRepository{

    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(17, "Manzanas", 5.20));
    }

    @Override
    public Product findById(Integer id) {
        return new Product(id, "Huevos", 3d);
    }
}
