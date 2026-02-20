package com.klu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klu.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
