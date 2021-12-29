package com.myclass.dto;

public class UserHallDto {
	
	private int user_id;
	private int hall_id;
	
	
	public UserHallDto() {
		
	}

	public UserHallDto(int user_id, int hall_id) {
		super();
		this.user_id = user_id;
		this.hall_id = hall_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getHall_id() {
		return hall_id;
	}

	public void setHall_id(int hall_id) {
		this.hall_id = hall_id;
	}

	
}
