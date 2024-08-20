package com.springboot.inyencciondependencia.app.springboot.inyencciondependencia.repositories;

import com.springboot.inyencciondependencia.app.springboot.inyencciondependencia.models.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    Product findById(Integer id);
}
