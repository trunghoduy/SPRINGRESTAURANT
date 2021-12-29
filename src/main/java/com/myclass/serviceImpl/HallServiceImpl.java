package com.myclass.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.myclass.dto.HallDto;
import com.myclass.entity.Hall;
import com.myclass.repository.HallRepository;
import com.myclass.service.HallService;

@Service
public class HallServiceImpl implements HallService{

	@Autowired
	private HallRepository hallRepository;
	
	@Override
	public List<HallDto> getAll() {
		List<HallDto> hallDto = new ArrayList<HallDto>();
		try {
			List<Hall> entities = hallRepository.findAll();
			for (Hall entity : entities) {
				HallDto dto = new HallDto();
				dto.setId(entity.getId());
				dto.setName(entity.getName());
				dto.setArea(entity.getArea());
				dto.setTable_count(entity.getTable_count());
				dto.setCocktail_count(entity.getCocktail_count());
				hallDto.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hallDto;
	}

	@Override
	public void insert(HallDto hallDto) {
		Hall entity = new Hall();
		entity.setId(hallDto.getId());
		entity.setName(hallDto.getName());
		entity.setArea(hallDto.getArea());
		entity.setTable_count(hallDto.getTable_count());
		entity.setCocktail_count(hallDto.getCocktail_count());
		hallRepository.save(entity);
		
	}

	@Override
	public HallDto findById(int id) {
		Hall entity = hallRepository.findById(id).get();
		return new HallDto(entity.getId(),entity.getArea(),entity.getCocktail_count(),entity.getName(),entity.getTable_count());
	}

	@Override
	public void update(HallDto hallDto, int id) {
		if(hallRepository.existsById(id)) {
			Hall entity = new Hall(hallDto.getId(),hallDto.getArea(),hallDto.getCocktail_count(),hallDto.getName(),hallDto.getTable_count());
			entity.setName(hallDto.getName());
			entity.setArea(hallDto.getArea());
			entity.setTable_count(hallDto.getTable_count());
			entity.setCocktail_count(hallDto.getCocktail_count());
			hallRepository.save(entity);
		}
		
	}

	@Override
	public void delele(int id) {
		hallRepository.deleteById(id);
		
	}

	
	@Override
	public Page<Hall> getByName(String name) {	
		
		return hallRepository.findByName(name,PageRequest.of(0,20));
		
	//	return new HallDto(entity.getId(),entity.getArea(),entity.getCocktail_count(),entity.getName(),entity.getTable_count());
	}

		
	@Override
	public Page<Hall> findAllPaging(int pageIndex) {
		Pageable pageable = PageRequest.of(pageIndex,20);
		return hallRepository.findAllpaging(pageable);
	}

	@Override
	public List<HallDto> getByHall(ArrayList<String> listA, ArrayList<Object> listB) {
		
		
		return null;
	}

	@Override
	public Page<Hall> findByPrice(int priceStart, int priceEnd, int pageIndex) {
		
//		List<HallDto> hallDto = new ArrayList<HallDto>();
//		try {
//			List<Hall> entities = hallRepository.findByPrice(priceStart,priceEnd,PageRequest.of(pageIndex,20));
//			for (Hall entity : entities) {
//				HallDto dto = new HallDto();
//				dto.setId(entity.getId());
//				dto.setName(entity.getName());
//				dto.setArea(entity.getArea());
//				dto.setTable_count(entity.getTable_count());
//				dto.setCocktail_count(entity.getCocktail_count());
//				dto.setDate(entity.getDate());
//				dto.setPrice(entity.getPrice());
//				hallDto.add(dto);
//				System.out.println(entities);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	
		return hallRepository.findByPrice(priceStart,priceEnd,PageRequest.of(pageIndex,20));
	}
		
			
	

}
