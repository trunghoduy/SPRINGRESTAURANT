package com.myclass.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.myclass.dto.UserDto;
import com.myclass.entity.User;
import com.myclass.repository.UserRepository;
import com.myclass.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void insert(UserDto userDto) {
			if((userRepository.findByEmail(userDto.getEmail())==null)) {
				String hasher = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt());
				User entity = new User();
				entity.setAddress(userDto.getAddress());
				entity.setAvatar(userDto.getAvatar());
				entity.setEmail(userDto.getEmail());
				entity.setFullname(userDto.getFullname());
				entity.setPassword(hasher);
				entity.setPhone(userDto.getPhone());
				entity.setRole_id(userDto.getRole_id()); // vì là client nen dat ROLE_CLIENT = 3 
				userRepository.save(entity);
			} 
	}

	

	@Override
	public List<UserDto> getAll() {
		List<UserDto> dtos = new ArrayList<UserDto>();
		try {
			List<User> entities = userRepository.findAllRole_id();
			for (User entity : entities) {
				UserDto dto = new UserDto();
				dto.setId(entity.getId());
				dto.setAddress(entity.getAddress());
				dto.setAvatar(entity.getAvatar());
				dto.setEmail(entity.getEmail());
				dto.setFullname(entity.getFullname());
				dto.setPassword(entity.getPassword());
				dto.setPhone(entity.getPhone());
				dto.setRole_id(entity.getRole_id());
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtos;
	}

	@Override
	public void update(int id, UserDto userDto) {
		String hasher = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt());
		if(userRepository.existsById(id)) {
			User entity = new User(userDto.getId(),userDto.getEmail(),
					userDto.getFullname(),userDto.getPassword(),userDto.getAvatar(),
					userDto.getPhone(),userDto.getAddress(),userDto.getRole_id());
			entity.setEmail(userDto.getEmail());
			entity.setFullname(userDto.getFullname());
			entity.setPassword(hasher);
			entity.setAvatar(userDto.getAvatar());
			entity.setAddress(userDto.getAddress());
			entity.setPhone(userDto.getPhone());
			entity.setRole_id(userDto.getRole_id());
			userRepository.save(entity);
		}
	}

	@Override
	public void delete(int id) {
		userRepository.deleteById(id);		
	}

	@Override
	public UserDto getById(int id) {
	User entity = userRepository.findById(id).get();
		return new UserDto(entity.getId(),entity.getAddress(),entity.getAvatar(),entity.getEmail(),entity.getFullname(),entity.getPassword(),entity.getPhone(),entity.getRole_id());
	}

	@Override
	public UserDto getByPhone(String phone) {
		
		User entity = userRepository.findByPhone(phone);
		
		return new UserDto(entity.getId(),entity.getAddress(),entity.getAvatar(),entity.getEmail(),entity.getFullname(),entity.getPassword(),entity.getPhone(),entity.getRole_id());
	}

}
