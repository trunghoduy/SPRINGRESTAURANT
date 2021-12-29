package com.myclass.serviceImpl;

import java.util.ArrayList;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myclass.dto.UserDetailsDto;
import com.myclass.entity.User;
import com.myclass.repository.UserRepository;


@Service
@Transactional(rollbackOn = Exception.class)
public class UserDetailsServiceImpl  implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// truy van lay thong tin 
		User user =userRepository.findByEmail(email);
		if( user == null) throw new UsernameNotFoundException("email không tồn tại!");
		// tạo danh sach chua ten quyen nguoi dung
		String roleName = user.getRole().getName();
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		authorities.add(new SimpleGrantedAuthority(roleName));
		// lưu thong tin vao trong userdelteil quan li 
		UserDetails userDetails = new UserDetailsDto(user.getEmail(), user.getPassword(), authorities);
		return userDetails;
	}

}
