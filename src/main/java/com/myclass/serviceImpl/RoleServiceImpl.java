package com.myclass.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.dto.RoleDto;
import com.myclass.entity.Role;
import com.myclass.repository.RoleRepository;
import com.myclass.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public List<RoleDto> getAll() {
		List<RoleDto> dtos = new ArrayList<RoleDto>();
		try {
			List<Role> entities = roleRepository.findAll();
			for (Role entity : entities) {
				RoleDto dto = new RoleDto(
						entity.getId(),entity.getName(),entity.getDescription());
				dtos.add(dto);
			}
		} catch (Exception e) {
		 e.printStackTrace();
		}
		return dtos;
	}

}
