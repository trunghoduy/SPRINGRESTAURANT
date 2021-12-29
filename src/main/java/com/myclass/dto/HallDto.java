package com.myclass.dto;


import java.util.Date;

public class HallDto {

	private int id;
	private String name;
	private int area;
	private int table_count;
	private int cocktail_count;
	private int price;
	private Date date;
	
	public HallDto() {
		
	}
	public HallDto(int id, int area, int cocktail_count,String name, int table_count) {
		super();
		this.id = id;
		this.name = name;
		this.area = area;
		this.table_count = table_count;
		this.cocktail_count = cocktail_count;
		
	}
	

	public HallDto(int id, String name, int area, int table_count, int cocktail_count, int price, Date date) {
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
