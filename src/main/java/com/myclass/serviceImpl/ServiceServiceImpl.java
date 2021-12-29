package com.myclass.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.myclass.dto.ServiceDto;
import com.myclass.entity.Service;
import com.myclass.repository.ServiceRepository;
import com.myclass.service.ServiceService;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService{

	@Autowired
	private ServiceRepository serviceRepository;
	
	@Override
	public void insert(ServiceDto serviceDto) {
		Service entity = new Service();
		entity.setId(serviceDto.getId());
		entity.setIcon(serviceDto.getIcon());
		entity.setTitle(serviceDto.getTitle());
		
		serviceRepository.save(entity);
	}

	@Override
	public List<ServiceDto> getAll() {
		List<ServiceDto> serviceDto = new ArrayList<ServiceDto>();
		try {
		List<Service> entities  = serviceRepository.findAll();
		for (Service entity : entities) {
			ServiceDto dto = new ServiceDto();
			dto.setId(entity.getId());
			dto.setIcon(entity.getIcon());
			dto.setTitle(entity.getTitle());
		
			serviceDto.add(dto);
			
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return serviceDto;
	}

	@Override
	public void update(ServiceDto serviceDto, int id) {

		if(serviceRepository.existsById(id)) {
			Service entity = new Service(serviceDto.getId(), serviceDto.getIcon(), serviceDto.getTitle());
			entity.setId(serviceDto.getId());
			entity.setIcon(serviceDto.getIcon());
			entity.setTitle(serviceDto.getTitle());
			serviceRepository.save(entity);
		}
	}

	@Override
	public void delele(int id) {
		serviceRepository.deleteById(id);
		
	}

	@Override
	public ServiceDto getById(int id) {
		Service entity = serviceRepository.findById(id).get();
		return new ServiceDto(entity.getId(),entity.getIcon(),entity.getTitle());
	}

	

}
