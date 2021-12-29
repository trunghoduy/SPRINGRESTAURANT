package com.myclass.controller.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myclass.dto.LoginDto;
import com.myclass.service.AuthService;

@Controller
@RequestMapping("/api/admin")
public class AdminLoginController {
	
	@Autowired
	private AuthService authService;

	@PostMapping("login")
	public Object post(@RequestBody LoginDto loginDto) {
		try {
			String token = authService.Login(loginDto);
			return new ResponseEntity<Object>(token,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}

	}
