package com.revesion.bms2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revesion.bms2.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
