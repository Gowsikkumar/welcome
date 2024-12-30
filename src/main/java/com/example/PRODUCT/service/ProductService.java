package com.example.PRODUCT.service;

import com.example.PRODUCT.model.Product;
import com.example.PRODUCT.repo.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productre;

    public ProductService(ProductRepository productre) {
        this.productre = productre;
    }

    public List<Product> getAllproducts() {
        return productre.findAll();

    }
    public Product create(Product product)
    {
        return productre.save(product);
    }
    public Optional<Product>getById(Long id)
    {
        return productre.findById(id);
    }
    public  void deleteById(Long id)
    {
        productre.deleteById(id);
    }
    public  List<Product>Read()
    {
        return productre.findAll();
    }
}
