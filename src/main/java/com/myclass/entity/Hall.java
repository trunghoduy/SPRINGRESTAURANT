package com.myclass.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "halls")
public class Hall {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name ="name" ,length = 100 ,nullable = false)
	private String name;
	
	@Column(name ="area")
	private int area;
	
	@Column(name= "table_count")
	private int table_count; 
	
	@Column(name = "cocktail_count")
	private int cocktail_count;
	
	@Column(name = "price")
	private int price;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date date;
	

	@ManyToMany(mappedBy = "likedHall", fetch = FetchType.LAZY)
	private List<User> user;

	public Hall() {
		
	}
	public Hall(int id,  int area, int cocktail_count,String name, int table_count) {
		super();
		this.id = id;
		this.name = name;
		this.area = area;
		this.table_count = table_count;
		this.cocktail_count = cocktail_count;
		
	}
	
	
	public Hall(int id, String name, int area, int table_count, int cocktail_count, int price, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.area = area;
		this.table_count = table_count;
		this.cocktail_count = cocktail_count;
		this.price = price;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public int getTable_count() {
		return table_count;
	}
	public void setTable_count(int table_count) {
		this.table_count = table_count;
	}
	public int getCocktail_count() {
		return cocktail_count;
	}
	public void setCocktail_count(int cocktail_count) {
		this.cocktail_count = cocktail_count;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
