package com.myclass.dto;

public class ServiceDto {

	private int id;
	private String title;
	private String icon;
	
	public ServiceDto() {
		
	}
	
	public ServiceDto(int id, String icon, String title) {
		super();
		this.id = id;
		this.icon = icon;
		this.title = title;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	
	
}
