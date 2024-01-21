package com.basic.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.basic.entities.Sale;

@Repository
@Transactional
public class SalesDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
  
    public List<Sale> list() {
    	String sql = "SELECT * FROM SALES";
    	 
        List<Sale> listSale = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Sale.class));
     
        return listSale;
    }
  
    public void save(Sale sale) {
    }
  
    public Sale get(int id) {
        return null;
    }
  
    public void update(Sale sale) {
    }
  
    public void delete(int id) {
    }
}
