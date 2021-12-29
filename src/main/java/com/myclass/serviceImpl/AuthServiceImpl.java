package com.myclass.serviceImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


import com.myclass.dto.LoginDto;
import com.myclass.service.AuthService;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

//lấy thông tin để xác thực đăng nhập và tạo token

@Service
public class AuthServiceImpl implements AuthService{

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Override
	public String Login(LoginDto loginDto) {
		
		// xac thu kiem tra tk dang nhap
		Authentication authentication = 
				new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword());
		
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		authenticationManager.authenticate(authentication);
		
		// TẠO TOKEN
		Date nowDate = new Date();
		
		String token = Jwts.builder()
		.setSubject(loginDto.getEmail())
		.setIssuedAt(nowDate)
		.setExpiration(new Date(nowDate.getTime() + 864000000L))
		.signWith(SignatureAlgorithm.HS512, "ABCDEF")
		.compact();
		
		return token;
	}

}
