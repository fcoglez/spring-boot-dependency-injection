package com.springboot.inyencciondependencia.app.springboot.inyencciondependencia.repositories;

import com.springboot.inyencciondependencia.app.springboot.inyencciondependencia.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Primary
@Repository
public class ProductRepository implements IProductRepository{

    List<Product> data;

    public ProductRepository() {
        this.data = Arrays.asList(
            new Product(1, "Lenovo ideapad 110", 357d),
            new Product(2, "Disco duro 1TB SDD", 246d),
            new Product(3, "Ratón Razer", 67.20),
            new Product(4, "Teclado mecanico", 120.65)
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
