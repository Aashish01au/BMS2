package com.revesion.bms2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revesion.bms2.model.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, Integer> {

}
