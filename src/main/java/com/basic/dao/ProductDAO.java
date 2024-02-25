package com.basic.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.basic.entities.Product;

@Repository
@Transactional
public class ProductDAO {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	 public List<Product> list() {
	    	String sql = "SELECT * FROM Product";
	    	 
	        List<Product> listProduct = jdbcTemplate.query(sql,
	                BeanPropertyRowMapper.newInstance(Product.class));
	     
	        return listProduct;
	    }
}
