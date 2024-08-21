package com.springboot.inyencciondependencia.app.springboot.inyencciondependencia.services;

import com.springboot.inyencciondependencia.app.springboot.inyencciondependencia.models.Product;
import com.springboot.inyencciondependencia.app.springboot.inyencciondependencia.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    @Autowired
    @Qualifier("productJsonRepository")//Ponemos el nombre de la clase pero en minuscula la primera letra
    private IProductRepository productRepository;

    @Autowired
    private Environment environment;


    @Override
    public List<Product> findAll( ){
        return productRepository.findAll()
                .stream()
                .map(product -> {
                    Double priceTax = (product.getPrice() * environment.getProperty("config.price.tax", Double.class));
//                  return new Product(product.getId(), product.getName(), priceTax); esto es principio de inmutabilidad para que el objeto (product) no vaya cambiando
                    Product newProduct = (Product) product.clone();
                    newProduct.setPrice(priceTax);
                    return newProduct;
                }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Integer id){
        return productRepository.findById(id);
    }
}
