package com.springboot.inyencciondependencia.app.springboot.inyencciondependencia.repositories;

import com.springboot.inyencciondependencia.app.springboot.inyencciondependencia.models.Product;

import java.util.Arrays;
import java.util.List;

public class ProductRepository implements IProductRepository{


    List<Product> data;

    public ProductRepository() {
        this.data = Arrays.asList(
            new Product(1, "Lenovo ideapad 110", 357),
            new Product(2, "Disco duro 1TB SDD", 246),
            new Product(3, "Ratón Razer", 67),
            new Product(4, "Teclado mecanico", 120)
        );
    }

    @Override
    public List<Product> findAll(){
        return data;
    }

    @Override
    public Product findById(Integer id){
        return data.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .get();
    }
}
