package com.myclass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myclass.dto.UserDto;
import com.myclass.service.UserService;

@Controller
@RequestMapping("api/auth")
public class AuthController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("resgiter")
	public Object post(@RequestBody UserDto userDto) {
		try {
			userService.insert(userDto);
			return new ResponseEntity<Object>(HttpStatus.CREATED);
			} catch (Exception e) {
			e.printStackTrace();
			}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	
}
