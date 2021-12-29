package com.myclass.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

import com.myclass.dto.HallDto;
import com.myclass.entity.Hall;

public interface HallService {

	List<HallDto> getAll();

	void insert(HallDto hallDto);

	HallDto findById(int id);

	void update(HallDto hallDto, int id);

	void delele(int id);

	

	Page<Hall>getByName(String name);

	Page<Hall> findAllPaging(int pageIndex);

	List<HallDto> getByHall(ArrayList<String> listA, ArrayList<Object> listB);

	Page<Hall> findByPrice(int priceStart, int priceEnd, int pageIndex);

}
