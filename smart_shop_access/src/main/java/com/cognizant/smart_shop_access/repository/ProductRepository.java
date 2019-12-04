package com.cognizant.smart_shop_access.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.smart_shop_access.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

}
