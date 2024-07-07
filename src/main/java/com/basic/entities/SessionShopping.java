package com.basic.entities;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "session_shoping")
public class SessionShopping {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userId;
	
	@Column(name = "total_price")
	private double totalPrice;
	
	@Column(name = "creat_at")
	private Timestamp  creatAt;
	@Column(name = "modify_at")
	private Timestamp modifyAt;

}
