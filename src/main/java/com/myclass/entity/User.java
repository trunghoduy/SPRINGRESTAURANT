package com.myclass.entity;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "email", length = 100, nullable = false )
	private String email;
	
	@Column(name = "fullname" ,length = 100, nullable = false)
	private String fullname;
	
	@Column(name = "password" ,length = 100, nullable = false)
	private String password;
	
	@Column(name = "avatar", nullable = false)
	private String avatar;
	
	@Column(name = "phone" ,length = 20, nullable = false)
	private String phone;
	
	@Column(name = "addreess" , nullable = false)
	private String address;
	
	@Column(name = "role_id" )
	private int role_id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id" , insertable = false, updatable = false)
	private Role role;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "user_hall ", joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name ="hall_id"))
	private List<Hall> likedHall;
	
	public User() {
		
	}
	
	public User(int id, String email, String fullname, String password, String avatar, String phone, String address,
			int role_id) {
		super();
		this.id = id;
		this.email = email;
		this.fullname = fullname;
		this.password = password;
		this.avatar = avatar;
		this.phone = phone;
		this.address = address;
		this.role_id = role_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
