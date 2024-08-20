package com.springboot.inyencciondependencia.app.springboot.inyencciondependencia.services;

import com.springboot.inyencciondependencia.app.springboot.inyencciondependencia.models.Product;
import com.springboot.inyencciondependencia.app.springboot.inyencciondependencia.repositories.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ProductService implements IProductService {

    private ProductRepository productRepository = new ProductRepository();

    @Override
    public List<Product> findAll(){
        return productRepository.findAll()
                .stream()
                .map(product -> {
                    int priceTax = (int) (product.getPrice() * 1.25);
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
