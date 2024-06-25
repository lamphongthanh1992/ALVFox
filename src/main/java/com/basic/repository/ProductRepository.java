package com.basic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.basic.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	List<Product> findAll();

}
