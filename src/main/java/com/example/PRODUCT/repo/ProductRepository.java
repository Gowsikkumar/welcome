package com.example.PRODUCT.repo;

import com.example.PRODUCT.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product,Long>{
}
