package com.myclass.service;

import java.util.List;

import com.myclass.dto.ServiceDto;

public interface ServiceService {

	void insert(ServiceDto serviceDto);

	List<ServiceDto> getAll();

	void update(ServiceDto serviceDto, int id);

	void delele(int id);

	ServiceDto getById(int id);

}
