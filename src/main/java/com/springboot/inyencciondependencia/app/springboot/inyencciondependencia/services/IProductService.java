package com.springboot.inyencciondependencia.app.springboot.inyencciondependencia.services;

import com.springboot.inyencciondependencia.app.springboot.inyencciondependencia.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(Integer id);
}
