package com.basic.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.basic.entities.Sale;
import com.basic.entities.User;

@Repository
@Transactional
public class UserDAO {
	 @Autowired
	 private JdbcTemplate jdbcTemplate;
	 public List<User> list() {
	    	String sql = "SELECT * FROM USER";
	    	 
	        List<User> listSale = jdbcTemplate.query(sql,
	                BeanPropertyRowMapper.newInstance(User.class));
	     
	        return listSale;
	    }
	 
	 
	 public User findUser(String username, String password) {
		 try {
			 String sql = "SELECT * FROM USER where username =? and password = ?";
			 User user = jdbcTemplate.queryForObject(sql, new Object[] { username, password }, BeanPropertyRowMapper.newInstance(User.class));
			 return user;
		} 
		catch (EmptyResultDataAccessException e) {
		   return null;
		}
	 }
	 
	 public int createUser(User user) {
		 
		 int isSuccess = jdbcTemplate.update(
				    "INSERT INTO USER (username, password, phone,email, first_name,last_name) VALUES (?, ?,?,?,?,?)",
				    user.getUsername(), user.getPassword(),user.getPhone(),user.getEmail(),user.getFirst_name(),user.getLast_name()
				);
		 return isSuccess;
	 }
}
