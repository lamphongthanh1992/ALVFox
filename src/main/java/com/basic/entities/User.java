package com.basic.entities;


import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idUser;
	@Column(length = 50)
	private String username;
	@Column(length = 100)
	private String password;
	@Column(length = 20)
	private String phone;
	@Column(length = 100)
	private String email;
	@Column(length = 100, name = "first_name")
	private String firstName;
	@Column(length = 100, name = "last_name")
	private String last_name;
	@Column(length = 10)
	private String gender;
	@Column(name = "date_Of_Birth")
	private Date dateOfBirth;
	@Column(length = 200)
	private String address;
	@Column(name = "creat_at")
	private Timestamp  creatAt;
	@Column(name = "modify_at")
	private Timestamp modifyAt;
	@Column(name = "last_login")
	private Timestamp lastLogin;
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirst_name() {
		return firstName;
	}
	public void setFirst_name(String first_name) {
		this.firstName = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Timestamp getCreatAt() {
		return creatAt;
	}
	public void setCreatAt(Timestamp creatAt) {
		this.creatAt = creatAt;
	}
	public Timestamp getModifyAt() {
		return modifyAt;
	}
	public void setModifyAt(Timestamp modifyAt) {
		this.modifyAt = modifyAt;
	}
	public Timestamp getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
