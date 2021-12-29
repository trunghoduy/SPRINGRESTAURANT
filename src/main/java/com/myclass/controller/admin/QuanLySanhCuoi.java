package com.myclass.controller.admin;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myclass.dto.HallDto;
import com.myclass.entity.Hall;
import com.myclass.service.HallService;

@Controller
@RequestMapping(value = "api/QuanLySanhCuoi" , produces={"application/json","*/*"})
public class QuanLySanhCuoi {

	@Autowired
	private HallService hallService;
	
	@GetMapping("LayDanhSachSanhCuoi")
	public Object get(@RequestHeader("Authorization") String Authorization) {
		List<HallDto> hallDto = hallService.getAll();
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json = mapper.writeValueAsString(hallDto);
			return new ResponseEntity<Object>(json,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	@PostMapping("ThemSanhCuoi")
	public Object post(@RequestBody HallDto hallDto,@RequestHeader("Authorization") String Authorization) {
		try {
			hallService.insert(hallDto);
			return new ResponseEntity<Object>(HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	@GetMapping("ThongTinSanhCuoi")
	public Object get(@RequestParam("id") int id,@RequestHeader("Authorization") String Authorization) {
		try {
			HallDto hallDto = hallService.findById(id);
			return new ResponseEntity<Object>(hallDto,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	@PutMapping("SuaThonTinSanhCuoi/{id}")
	public Object put(@PathVariable("id") int id, @RequestBody HallDto hallDto,@RequestHeader("Authorization") String Authorization) {
		try {
			 hallService.update(hallDto,id);
			 return new ResponseEntity<Object>(hallDto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	@DeleteMapping("XoaSanhCuoi")
	public Object delete(@PathVariable("id") int id,@RequestHeader("Authorization") String Authorization) {
		try {
			hallService.delele(id);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	@GetMapping("TimKiemSanhCuoi")
	public ResponseEntity<Page<Hall>> get(@RequestParam("name") String name,@RequestHeader("Authorization") String Authorization) {
	
			Page<Hall> hall = hallService.getByName(name);
			
			if(hall.getSize()==0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<Page<Hall>>(hall,HttpStatus.OK);
		}
		
	
		
	}
		
